/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils.reqgraph;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RequirementTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCycles() {
        Requirement parent = new Requirement("parent");
        Requirement child1 = new Requirement("child1");
        Requirement child3 = new Requirement("child3");
        parent.setRequiredBy(child1);
        child1.setRequiredBy(child3);

        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Requirement cycle detected");
        child3.setRequiredBy(parent);
    }

    @Test
    public void testClosed() {
        Requirement parent = new Requirement("parent");
        Requirement child1 = new Requirement("child1");
        Requirement child2 = new Requirement("child2");
        parent.setRequiredBy(child1);
        parent.setRequiredBy(child2);
        child2.setRequiredBy(child1);

        assertTrue("Parent required by Parent", parent.requiredBy(parent));
        assertTrue("Parent required by Child1", parent.requiredBy(child1));
        assertTrue("Parent required by Child2", parent.requiredBy(child2));
        assertTrue("Parent requires Parent", parent.requires(parent));
        assertFalse("Parent requires Child1", parent.requires(child1));
        assertFalse("Parent requires Child2", parent.requires(child2));

        assertFalse("Child1 required by Parent", child1.requiredBy(parent));
        assertTrue("Child1 required by Child1", child1.requiredBy(child1));
        assertFalse("Child1 required by Child2", child1.requiredBy(child2));
        assertTrue("Child1 requires Parent", child1.requires(parent));
        assertTrue("Child1 requires Child1", child1.requires(child1));
        assertTrue("Child1 requires Child2", child1.requires(child2));

        assertFalse("Child2 required by Parent", child2.requiredBy(parent));
        assertTrue("Child2 required by Child1", child2.requiredBy(child1));
        assertTrue("Child2 required by Child2", child2.requiredBy(child2));
        assertTrue("Child2 requires Parent", child2.requires(parent));
        assertFalse("Child2 requires Child1", child2.requires(child1));
        assertTrue("Child2 requires Child2", child2.requires(child2));
    }

    @Test
    public void testOpen() {
        Requirement parent = new Requirement("parent");
        Requirement child1 = new Requirement("child1");
        Requirement child3 = new Requirement("child2");
        parent.setRequiredBy(child1);
        child1.setRequiredBy(child3);

        assertTrue("Parent required by Parent", parent.requiredBy(parent));
        assertTrue("Parent required by Child1", parent.requiredBy(child1));
        assertTrue("Parent required by Child3", parent.requiredBy(child3));
        assertTrue("Parent requires Parent", parent.requires(parent));
        assertFalse("Parent requires Child1", parent.requires(child1));
        assertFalse("Parent requires Child3", parent.requires(child3));

        assertFalse("Child1 required by Parent", child1.requiredBy(parent));
        assertTrue("Child1 required by Child1", child1.requiredBy(child1));
        assertTrue("Child1 required by Child3", child1.requiredBy(child3));
        assertTrue("Child1 requires Parent", child1.requires(parent));
        assertTrue("Child1 requires Child1", child1.requires(child1));
        assertFalse("Child1 requires Child3", child1.requires(child3));

        assertFalse("Child3 required by Parent", child3.requiredBy(parent));
        assertFalse("Child3 required by Child1", child3.requiredBy(child1));
        assertTrue("Child3 required by Child3", child3.requiredBy(child3));
        assertTrue("Child3 requires Parent", child3.requires(parent));
        assertTrue("Child3 requires Child1", child3.requires(child1));
        assertTrue("Child3 requires Child3", child3.requires(child3));
    }

    @Test
    public void testComplex() {
        Requirement a = new Requirement("a");
        Requirement b = new Requirement("b");
        Requirement c = new Requirement("c");
        Requirement d = new Requirement("d");
        Requirement e = new Requirement("e");
        Requirement f = new Requirement("f");
        Requirement g = new Requirement("g");
        a.setRequiredBy(b);
        a.setRequiredBy(c);
        a.setRequiredBy(f);
        b.setRequiredBy(e);
        c.setRequiredBy(d);
        c.setRequiredBy(e);
        e.setRequiredBy(d);
        f.setRequiredBy(g);
        assertEquals("Requirement representation", d.toStringWithReqs(), "d[c[a], e[b[a], c[a]]]");
        assertEquals("Requirement list", d.listRequirements().toString(), "[a, c, b, e, d]");
        assertTrue("D requires A", d.requires(a));
        assertFalse("D requires F", d.requires(f));
        assertFalse("D requires G", d.requires(g));

        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Requirement cycle detected");
        d.setRequiredBy(a);
    }

    @Test
    public void testSelfCycles1() {
        Requirement self = new Requirement(null);
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Requirement cycle detected");
        self.setRequires(self);
    }

    @Test
    public void testSelfCycles2() {
        Requirement self = new Requirement(null);
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Requirement cycle detected");
        self.setRequiredBy(self);
    }

}
