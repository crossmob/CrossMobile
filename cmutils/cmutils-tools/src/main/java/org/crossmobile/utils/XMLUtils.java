/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

class XMLUtils {

    public static Document loadXML(File infile) {
        try {
            return loadXML(new FileInputStream(infile));
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    public static Document loadXML(InputStream in) {
        try {
            if (in != null)
                return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new InputStreamReader(in, StandardCharsets.UTF_8)));
        } catch (SAXException | IOException | ParserConfigurationException ex) {
        }
        return null;
    }

    public static Document loadXML(Reader r) {
        try {
            if (r != null)
                return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(r));
        } catch (SAXException | IOException | ParserConfigurationException ex) {
        }
        return null;
    }

    public static Document createXML() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            return docBuilder.newDocument();
        } catch (ParserConfigurationException ex) {
            return null;
        }
    }

    @SuppressWarnings("UseSpecificCatch")
    public static boolean saveXML(Document doc, File outfile, boolean indent) {
        OutputStreamWriter writer = null;
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(writer = new OutputStreamWriter(new FileOutputStream(outfile), StandardCharsets.UTF_8));
            if (indent) {
                // Remove each empty text node from document.
                doc.normalize();
                NodeList emptyTextNodes = (NodeList) XPathFactory.newInstance().newXPath()
                        .evaluate("//text()[normalize-space(.) = '']", doc, XPathConstants.NODESET);
                for (int i = 0; i < emptyTextNodes.getLength(); i++) {
                    Node emptyTextNode = emptyTextNodes.item(i);
                    emptyTextNode.getParentNode().removeChild(emptyTextNode);
                }

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            }
            transformer.transform(source, result);
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    public static Node getNodeWithPath(Node parent, String... name) {
        Node current = parent;
        for (String n : name)
            if (current != null)
                current = getNodeWithName(parent, n);
            else
                break;
        return current;
    }

    public static Node getNodeWithPath(Node parent, String path, String delimiter) {
        return getNodeWithPath(parent, path.split(delimiter));
    }

    public static Node addNode(Document doc, Node parent, String name) {
        Node child = null;
        try {
            child = doc.createElement(name);
            return parent.appendChild(child);
        } catch (DOMException ex) {
            try {
                if (child != null)
                    parent.removeChild(child);
            } catch (DOMException ex2) {
            }
            return null;
        }
    }

    public static boolean removeNode(Node parent, Node child) {
        if (parent == null || child == null)
            return false;
        try {
            parent.removeChild(child);
            return true;
        } catch (DOMException ex) {
            return false;
        }
    }

    public static String getNodeText(Node node) {
        try {
            return node.getTextContent();
        } catch (DOMException ex) {
            return null;
        }
    }

    public static boolean setNodetext(Node node, String text) {
        try {
            node.setTextContent(text);
            return true;
        } catch (DOMException ex) {
            return false;
        }
    }

    public static Node getNode(Node parent) {
        return getNodeWithName(parent, null);
    }

    public static List<Node> getNodes(Node parent) {
        return getNodesWithName(parent, null, true);
    }

    public static Node getNodeWithName(Node parent, String name) {
        List<Node> nodes = getNodesWithName(parent, name, false);
        if (nodes.size() < 1)
            return null;
        return nodes.get(0);
    }

    public static List<Node> getNodesWithName(Node parent, String name, boolean all_of_them) {
        ArrayList<Node> valid = new ArrayList<>();
        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++)
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE
                    && (name == null || children.item(i).getNodeName().equalsIgnoreCase(name))) {
                valid.add(children.item(i));
                if (!all_of_them)
                    break;
            }
        return valid;
    }

    public static Node getNodeWithKey(Node parent, String key, String value) {
        HashSet<String> values = new HashSet<>();
        values.add(value);
        List<Node> nodes = getNodesWithKey(parent, key, values, false);
        if (nodes.size() < 1)
            return null;
        return nodes.get(0);
    }

    public static List<Node> getNodesWithKey(Node parent, String key, String value, boolean all_of_them) {
        HashSet<String> values = new HashSet<>();
        values.add(value);
        return getNodesWithKey(parent, key, values, all_of_them);
    }

    public static List<Node> getNodesWithKey(Node parent, String key, Set<String> values, boolean all_of_them) {
        ArrayList<Node> valid = new ArrayList<>();
        NodeList children = parent.getChildNodes();
        Node current;
        for (int i = 0; i < children.getLength(); i++) {
            current = children.item(i);
            NamedNodeMap attrs = current.getAttributes();
            if (attrs != null) {
                Node keynode = attrs.getNamedItem(key);
                if (keynode != null)
                    if (values == null || values.contains(keynode.getNodeValue())) {
                        valid.add(current);
                        if (!all_of_them)
                            break;
                    }
            }
        }
        return valid;
    }

    public static String getAttribute(Node n, String name) {
        if (n == null || name == null)
            return null;
        if (n instanceof Element)
            return ((Element) n).getAttribute(name);
        return null;
    }

    public static boolean setAttribute(Node n, String name, String value) {
        if (value == null)
            return deleteAttribute(n, name);
        if (n == null || name == null)
            return false;
        if (n instanceof Element) {
            ((Element) n).setAttribute(name, value);
            return true;
        }
        return false;
    }

    public static boolean deleteAttribute(Node n, String name) {
        if (n == null || name == null)
            return false;
        if (n instanceof Element) {
            ((Element) n).removeAttribute(name);
            return true;
        }
        return false;
    }

    public static Map<String, String> getAttributes(Node n) {
        if (n == null)
            return null;
        NamedNodeMap attributes = n.getAttributes();
        if (attributes == null || attributes.getLength() <= 0)
            return null;

        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            result.put(attr.getNodeName(), attr.getNodeValue());
        }
        return result;
    }
}
