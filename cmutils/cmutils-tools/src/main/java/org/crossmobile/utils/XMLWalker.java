/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class XMLWalker {

    private static final Object defaultTag = new Object();
    private final Document document;
    private Node current;
    private Map<Object, Node> tags;
    private Node nodeLast;
    private Object meta;
    private Consumer<String> errorHandler = error -> {
        throw new XMLWalkerException(error);
    };

    public static XMLWalker load(File file) {
        Document document = XMLUtils.loadXML(file);
        return document == null ? null : new XMLWalker(document);
    }

    public static XMLWalker load(InputStream is) {
        Document document = XMLUtils.loadXML(is);
        return document == null ? null : new XMLWalker(document);
    }

    public static XMLWalker load(Reader r) {
        Document document = XMLUtils.loadXML(r);
        return document == null ? null : new XMLWalker(document);
    }

    public XMLWalker() {
        this(XMLUtils.createXML());
    }

    private XMLWalker(Document document) {
        current = this.document = document;
    }

    public XMLWalker store(File outXML, boolean indent) {
        error(XMLUtils.saveXML(document, outXML, indent) ? null : "Unable to store XML to file " + outXML.getAbsolutePath());
        return this;
    }

    public XMLWalker root() {
        current = document;
        return this;
    }

    /**
     * Will go to first child node found with specific name
     *
     * @param name
     * @return
     */
    public XMLWalker node(String name) {
        return nodeWithText(name, null);
    }

    /**
     * Will go to first child node found with specific text
     *
     * @param text
     * @return
     */
    public XMLWalker nodeWithText(String text) {
        return nodeWithText(null, text);
    }

    /**
     * Will go to first child node found with specific name and text
     *
     * @param name
     * @param text
     * @return
     */
    public XMLWalker nodeWithText(String name, String text) {
        locateNode(name, text, true, false);
        return this;
    }

    /**
     * Node with specific name exists
     *
     * @param name
     * @return
     */
    public boolean nodeExists(String name) {
        return nodeWithTextExists(name, null);
    }

    /**
     * Check if this node has any child nodes
     *
     * @return true, if at least one node exists
     */
    public boolean nodeExists() {
        return !XMLUtils.getNodes(current).isEmpty();
    }

    /**
     * Node with specific text exists
     *
     * @param text
     * @return
     */
    public boolean nodeWithTextExists(String text) {
        return nodeWithTextExists(null, text);
    }

    /**
     * Node with specific name and text exists
     *
     * @param name
     * @param text
     * @return
     */
    public boolean nodeWithTextExists(String name, String text) {
        locateNode(name, text, false, true);
        return nodeLast != null;
    }

    /**
     * Execute code on the current node
     *
     * @param code
     * @return
     */
    public XMLWalker exec(Consumer<XMLWalker> code) {
        return execIf(null, code);
    }

    public XMLWalker execIf(Predicate<XMLWalker> predicate, Consumer<XMLWalker> code) {
        if (code != null) {
            Node now = current;
            if (predicate == null || predicate.test(this)) {
                current = now;
                code.accept(this);
            }
            current = now;
        }
        return this;
    }

    /**
     * Will iterate all child nodes
     *
     * @param nodes
     * @return
     */
    public XMLWalker nodes(Consumer<XMLWalker> nodes) {
        return nodesWithText(null, null, nodes);
    }

    /**
     * Will iterate all child nodes found with specific name
     *
     * @param name
     * @param nodes
     * @return
     */
    public XMLWalker nodes(String name, Consumer<XMLWalker> nodes) {
        return nodesWithText(name, null, nodes);
    }

    /**
     * Will iterate all child nodes found with specific text
     *
     * @param text
     * @param nodes
     * @return
     */
    public XMLWalker nodesWithText(String text, Consumer<XMLWalker> nodes) {
        return nodesWithText(null, text, nodes);
    }

    /**
     * Will iterate all child nodes found with specific name and text
     *
     * @param name
     * @param text
     * @param nodes
     * @return
     */
    public XMLWalker nodesWithText(String name, String text, Consumer<XMLWalker> nodes) {
        locateNodes(name, text, nodes, false, true);
        return this;
    }

    /**
     * Go to specific path
     *
     * @param path
     * @return
     */
    public XMLWalker path(String path) {
        locatePath(path, true, false);
        current = nodeLast;
        return this;
    }

    /**
     * Specific path exists
     *
     * @param path
     * @return
     */
    public boolean pathExists(String path) {
        locatePath(path, false, true);
        return nodeLast != null;
    }

    private void locateNode(String name, String text, boolean strict, boolean immutableNode) {
        locateNodes(name, text, null, true, immutableNode);
        error(strict && nodeLast == null ? "Unable to locate node" + (name == null ? "" : " name='" + name + "'") + (text == null ? "" : " text='" + text + "'") : null);
    }

    private void locatePath(String path, boolean strict, boolean immutable) {
        Node now = current;
        if (path.startsWith("/"))
            current = document;
        for (String part : path.split("/"))
            if (!part.isEmpty()) {
                String[] val = part.split(":");
                String name = val[0].length() == 0 ? null : val[0];
                String text = val.length > 1 ? val[1] : null;
                locateNode(name, text, false, false);
                if (nodeLast == null)
                    break;
            }
        error(strict && nodeLast == null ? "Unable to follow path " + path : null);
        // Immutability should come from here, not in locateNode; locateNode should be mutable
        if (immutable)
            current = now;
    }

    private void locateNodes(String name, String text, Consumer<XMLWalker> nodes, boolean onlyOnce, boolean immutableNode) {
        filterNodes(name, text, nodes, null, onlyOnce, immutableNode);
    }

    /**
     * Will iterate and filter based on predicate all child nodes
     *
     * @param nodes
     * @param predicate
     * @return
     */
    public XMLWalker filterNodes(Consumer<XMLWalker> nodes, Predicate<XMLWalker> predicate) {
        return filterNodesWithText(null, null, nodes, predicate);
    }

    /**
     * Will iterate and filter based on predicate all child nodes found with
     * specific name
     *
     * @param name
     * @param nodes
     * @return
     */
    public XMLWalker filterNodes(String name, Consumer<XMLWalker> nodes) {
        return filterNodesWithText(name, null, nodes, null);
    }

    /**
     * Will iterate and filter based on predicate all child nodes found with
     * specific name
     *
     * @param name
     * @param nodes
     * @param predicate
     * @return
     */
    public XMLWalker filterNodes(String name, Consumer<XMLWalker> nodes, Predicate<XMLWalker> predicate) {
        return filterNodesWithText(name, null, nodes, predicate);
    }

    /**
     * Will iterate and filter based on predicate all child nodes found with
     * specific text
     *
     * @param text
     * @param nodes
     * @param predicate
     * @return
     */
    public XMLWalker filterNodesWithText(String text, Consumer<XMLWalker> nodes, Predicate<XMLWalker> predicate) {
        return filterNodesWithText(null, text, nodes, predicate);
    }

    /**
     * Will iterate and filter based on predicate all child nodes found with
     * specific name and text
     *
     * @param name
     * @param text
     * @param nodes
     * @param predicate
     * @return
     */
    public XMLWalker filterNodesWithText(String name, String text, Consumer<XMLWalker> nodes, Predicate<XMLWalker> predicate) {
        filterNodes(name, text, nodes, predicate, false, true);
        return this;
    }

    private void filterNodes(String name, String text, Consumer<XMLWalker> nodes, Predicate<XMLWalker> pred, boolean onlyOnce, boolean immutableNode) {
        Node now = current;
        nodeLast = null;
        for (Node child : XMLUtils.getNodesWithName(current, name, true))
            if (text == null || text.equals(XMLUtils.getNodeText(child))) {
                nodeLast = current = child;
                if (nodes != null && (pred == null || pred.test(this)))
                    nodes.accept(this);
                if (onlyOnce)
                    break;
            }
        if (immutableNode)
            current = now;
    }

    /**
     * Go to parent node, if exists
     *
     * @return
     */
    public XMLWalker parent() {
        current = current.getParentNode();
        if (current == null)
            current = document;
        return this;
    }

    /**
     * Remove node with name and go to parent after removal
     *
     * @return
     */
    public XMLWalker remove() {
        Node parent = current.getParentNode();
        boolean success = XMLUtils.removeNode(parent, current);
        error(success ? null : "Unable to remove node");
        if (success)
            current = parent;
        return this;
    }

    /**
     * Create node with name and go to newly created node after addition
     *
     * @param name
     * @return
     */
    public XMLWalker add(String name) {
        Node newNode = XMLUtils.addNode(document, current, name);
        error(newNode == null ? "Unable to create node with name " + name + " under " + current.getNodeName() : null);
        if (newNode != null)
            current = newNode;
        return this;
    }

    public String text() {
        return XMLUtils.getNodeText(current);
    }

    public XMLWalker text(Consumer<String> txt) {
        if (txt != null)
            txt.accept(text());
        return this;
    }

    public XMLWalker setText(String txt) {
        error(XMLUtils.setNodetext(current, txt) ? null : "Unable to set text to node");
        return this;
    }

    public XMLWalker name(Consumer<String> name) {
        if (name != null)
            name.accept(name());
        return this;
    }

    public String name() {
        return current.getNodeName();
    }

    public XMLWalker attribute(String attributeName, Consumer<String> attribute) {
        if (attribute != null)
            attribute.accept(attribute(attributeName));
        return this;
    }

    public String attribute(String name) {
        return XMLUtils.getAttribute(current, name);
    }

    public boolean attributeExists(String name) {
        return !XMLUtils.getAttribute(current, name).isEmpty();
    }

    public XMLWalker attributes(BiConsumer<String, String> attributes) {
        if (attributes != null) {
            Map<String, String> attrs = XMLUtils.getAttributes(current);
            if (attrs != null)
                for (String key : attrs.keySet())
                    attributes.accept(key, attrs.get(key));
        }
        return this;
    }

    public XMLWalker setAttribute(String attributeName, String value) {
        if (!XMLUtils.setAttribute(current, attributeName, value))
            error("Unable to set attribute " + attributeName);
        return this;
    }

    public XMLWalker removeAttribute(String attributeName) {
        if (!XMLUtils.deleteAttribute(current, attributeName))
            error("Unable to remove attribute " + attributeName);
        return this;
    }

    public XMLWalker setErrorHandler(Consumer<String> errorHandler) {
        this.errorHandler = errorHandler;
        return this;
    }

    /**
     * Tag current node
     *
     * @return
     */
    public XMLWalker tag() {
        return tag(defaultTag);
    }

    /**
     * Tag current node
     *
     * @param tagger
     * @return
     */
    public XMLWalker tag(Object tagger) {
        if (tagger != null) {
            if (tags == null)
                tags = new HashMap<>();
            tags.put(tagger, current);
        }
        return this;
    }

    /**
     * Go to tagged node
     *
     * @return
     */
    public XMLWalker toTag() {
        return toTag(defaultTag);
    }

    /**
     * Go to tagged node
     *
     * @param tagger
     * @return
     */
    public XMLWalker toTag(Object tagger) {
        if (tagger != null && tags != null) {
            Node toGo = tags.get(tagger);
            if (toGo == null)
                error("Unable to locate tag " + tagger.toString());
            else
                current = toGo;
        }
        return this;
    }

    /**
     * Check if the generic tag exists
     *
     * @return true if exists
     */
    public boolean hasTag() {
        return hasTag(defaultTag);
    }

    /**
     * Check if a specific tag exists
     *
     * @param tagger the tag to search for
     * @return true if exists
     */
    public boolean hasTag(Object tagger) {
        return tags != null && tags.get(tagger) != null;
    }

    public XMLWalker untag() {
        return untag(defaultTag);
    }

    public XMLWalker untag(Object tagger) {
        tags.remove(tagger);
        return this;
    }

    public XMLWalker setMeta(Object metadata) {
        this.meta = metadata;
        return this;
    }

    public Object meta() {
        return meta;
    }

    public XMLWalker meta(Consumer<?> metadata) {
        if (metadata != null)
            ((Consumer) metadata).accept(meta);
        return this;
    }

    private void error(String errorTxt) {
        if (errorTxt != null && errorHandler != null)
            errorHandler.accept(errorTxt);
    }

    public XMLWalker last() {
        if (nodeLast != null)
            current = nodeLast;
        return this;
    }

    public static final class XMLWalkerException extends RuntimeException {

        private XMLWalkerException(String reason) {
            super(reason);
        }
    }

    @Override
    public String toString() {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            StringWriter out = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(out));
            return out.toString();
        } catch (TransformerException ex) {
        }
        return "";
    }

}
