/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils.test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.crossmobile.utils.XMLWalker;
import org.junit.Test;

import static org.junit.Assert.*;

public class XMLWalkerTest {

    @Test
    public void loadXML() {
        XMLWalker walker = XMLWalker.load(getClass().getResourceAsStream("/pom.xml"));
        assertNotNull(walker);
    }

    @Test
    public void nodeWalk() {
        XMLWalker walker = XMLWalker.load(getClass().getResourceAsStream("/pom.xml"));
        walker.node("project").node("name").parent().node("packaging");
        assertEquals("jar", walker.text());
    }

    @Test
    public void nodeMissing() {
        XMLWalker walker = XMLWalker.load(getClass().getResourceAsStream("/pom.xml"));
        boolean noException = false;
        try {
            walker.node("project").node("name").parent().node("packaging-no");
        } catch (XMLWalker.XMLWalkerException ex) {
            noException = true;
        }
        assertTrue("Should be an error", noException);
    }

    @Test
    public void nodeExistenceTest() {
        XMLWalker walker = XMLWalker.load(getClass().getResourceAsStream("/pom.xml"));
        assertTrue("Should found the path", walker.root().node("project").nodeExists("profiles"));
        assertFalse("Shouldn't find the path", walker.root().node("project").nodeExists("profiles-no"));
    }

    @Test
    public void nodeLocationTest() {
        XMLWalker walker = XMLWalker.load(getClass().getResourceAsStream("/pom.xml"));
        walker.node("project").nodeExists("profiles");
        assertEquals("project", walker.name());
    }

    @Test
    public void pathExistenceTest() {
        XMLWalker walker = XMLWalker.load(getClass().getResourceAsStream("/pom.xml"));
        assertTrue("Should found the path", walker.pathExists("/project/profiles/profile"));
        assertFalse("Shouldn't find the path", walker.pathExists("/project/profiles/profile-no"));
    }

    @Test
    public void pathLocationTest() {
        XMLWalker walker = XMLWalker.load(getClass().getResourceAsStream("/pom.xml"));
        walker.pathExists("/project/profiles/profile");
        assertEquals("#document", walker.name());
    }

    @Test
    public void pathAbsolute() {
        XMLWalker walker = XMLWalker.load(getClass().getResourceAsStream("/pom.xml"));
        walker.node("project");
        walker.path("profiles/profile");
        walker.path("/project/profiles/profile");
        walker.root().path("project///profiles/profile");
        walker.path("///project///profiles/profile");
    }

    @Test
    public void nodeLast() {
        XMLWalker walker = XMLWalker.load(getClass().getResourceAsStream("/pom.xml"));
        walker.node("project");
        walker.nodeExists("profiles");
        assertEquals("project", walker.name());
        assertEquals("profiles", walker.last().name());

        walker.path("/project");
        walker.pathExists("profiles/profile");
        assertEquals("project", walker.name());
        assertEquals("profile", walker.last().name());
        assertEquals("profiles", walker.parent().name());
    }

    @Test
    public void getAsName() {
        XMLWalker walker = XMLWalker.load(getClass().getResourceAsStream("/pom.xml"));
        assertEquals("id2", walker.node("project").node("profiles").node("profile").nodeWithText("id2 text").name());
        assertEquals("id2", walker.path("/project/profiles/profile").nodeWithText("id2 text").name());
        assertEquals("id2", walker.path("/project/profiles/profile/:id2 text").name());
        assertEquals("lala", walker.path("/project/profiles/profile/id3/koko/lala").name());
        assertEquals("lala", walker.path("/project/profiles/profile/id2/koko/lala").name());
        assertEquals("lala", walker.path("/project/profiles/profile/:id2 text/koko/lala").name());

    }

    @Test
    public void tagging() {
        XMLWalker.load(getClass().getResourceAsStream("/pom.xml")).
                node("project").tag(1).node("profiles").tag(2).node("profile").tag(3).
                root().
                toTag(3).exec(w -> assertEquals("profile", w.name())).
                toTag(1).exec(w -> assertEquals("project", w.name())).
                toTag(2).exec(w -> assertEquals("profiles", w.name()));
    }

    @Test
    public void conditionalExec() {
        AtomicBoolean test1 = new AtomicBoolean(false);
        AtomicBoolean test2 = new AtomicBoolean(false);
        AtomicBoolean test3 = new AtomicBoolean(true);
        AtomicBoolean test4 = new AtomicBoolean(false);
        AtomicBoolean test5 = new AtomicBoolean(false);
        AtomicBoolean test6 = new AtomicBoolean(false);
        AtomicBoolean test7 = new AtomicBoolean(true);
        AtomicBoolean test8 = new AtomicBoolean(true);
        XMLWalker.load(getClass().getResourceAsStream("/pom.xml")).node("project").
                execIf(w -> w.nodeExists("profiles"), w -> test1.set(true)). // should run
                execIf(w -> w.nodeExists("profiles"), w -> test2.set(true)). // should run
                execIf(w -> w.nodeExists("profiles-no"), w -> test3.set(false)). // should not run
                execIf(w -> w.pathExists("profiles/profile"), w -> test4.set(true)). // should run
                exec(w -> assertEquals("project", w.name())).
                //
                        path("/project").execIf(w -> !w.nodeExists("pro-no"), w -> test5.set(true)).// should run
                execIf(w -> !w.pathExists("/project/pro-no"), w -> test6.set(true)).// should run
                path("/project").execIf(w -> !w.nodeExists("profiles"), w -> test7.set(false)). // should not run
                execIf(w -> !w.pathExists("/project/profiles"), w -> test8.set(false)). // should not run
                execIf(w -> w.pathExists("/project/profiles"), w -> assertEquals("profiles", w.last().name()));
        assertTrue(test1.get());
        assertTrue(test2.get());
        assertTrue(test3.get());
        assertTrue(test4.get());
        assertTrue(test5.get());
        assertTrue(test6.get());
        assertTrue(test7.get());
        assertTrue(test8.get());
    }

    @Test
    public void nodeIteration() {
        AtomicInteger counter = new AtomicInteger(0);
        StringBuilder artifacts = new StringBuilder();
        StringBuilder groups = new StringBuilder();
        StringBuilder versions = new StringBuilder();
        XMLWalker.load(getClass().getResourceAsStream("/pom.xml")).path("/project/dependencies").nodes("dependency", w -> {
            artifacts.append(":").append(w.node("artifactId").text());
            groups.append(":").append(w.parent().node("groupId").text());
            versions.append(":").append(w.parent().node("version").text());
            counter.addAndGet(1);
        });
        assertEquals(5, counter.get());
        assertEquals(":artifact1:artifact2:artifact3:artifact1:artifact2", artifacts.toString());
        assertEquals(":group:group:group:other:other", groups.toString());
        assertEquals(":1:1:1:a:b", versions.toString());
    }

    @Test
    public void addRemoveNode() {
        XMLWalker.load(getClass().getResourceAsStream("/pom.xml")).path("/project/profiles/profile").execIf(w -> w.nodeExists("id2"), w -> w.node("id2").remove().exec(c -> assertFalse(c.nodeExists("id2"))));
    }

}
