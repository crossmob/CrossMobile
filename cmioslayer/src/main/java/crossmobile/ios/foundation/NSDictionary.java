/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.support.MiGBase64;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * NSDictionary class defines an object that represents a dictionary that maps
 * immutable keys to maps.
 */
@CMClass
public final class NSDictionary extends NSObject implements NSSecureCoding {

    /**
     * Constructs and returns a new dictionary that contains the values and keys
     * of the file of the specified path.
     *
     * @param path The path of the file that contains the values and keys.
     * @return The new dictionary containing the values and keys of the
     * specified file.
     */
    @CMSelector("+ (NSDictionary<KeyType,ObjectType> *)dictionaryWithContentsOfFile:(NSString *)path;")
    public static Map<String, Object> dictionaryWithContentsOfFile(String path) {
        final List<Map<String, Object>> root_dict = new ArrayList<>();
        final Stack<Container> stack = new Stack<>();

        NSData data = NSData.dataWithContentsOfFile(path);
        if (data == null)
            return null;
        NSXMLParser p = new NSXMLParser(data);
        p.setDelegate(new NSXMLParserDelegate() {
            private StringBuffer text;
            private String keyname;

            @Override
            public void didStartElement(NSXMLParser parser, String elementName, String namespaceURI, String qualifiedName, Map<String, String> attributes) {
                if (elementName.equals("dict")) {
                    NSDictionaryDict dict = new NSDictionaryDict();
                    dict.key = keyname; // Should be early, since the variable will be overriden
                    stack.push(dict);
                    if (root_dict.isEmpty())
                        root_dict.add(dict);
                    return;
                }

                if (stack.isEmpty())    // Should already have something to add to
                    return;

                if (elementName.equals("array")) {
                    NSDictionaryArray list = new NSDictionaryArray();
                    list.key = keyname; // Should be early, since the variable will be overriden
                    stack.push(list);
                    return;
                }

                if (elementName.equals("key")
                        || elementName.equals("string")
                        || elementName.equals("integer")
                        || elementName.equals("real")
                        || elementName.equals("date")
                        || elementName.equals("data"))
                    text = new StringBuffer();
            }

            @Override
            public void foundCharacters(NSXMLParser parser, String characters) {
                if (text != null)// Only when expecting text
                    text.append(characters);
            }

            @Override
            public void didEndElement(NSXMLParser parser, String elementName, String namespaceURI, String qualifiedName) {
                if (stack.isEmpty())
                    return;

                if (elementName.equals("dict") || elementName.equals("array")) {
                    Container child = stack.pop();
                    if (!stack.isEmpty())
                        stack.peek().store(child.getkey(), child);
                    keyname = null;
                    text = null;
                    return;
                }

                if (elementName.equals("key")) {
                    keyname = text.toString();
                    text = null;
                    return;
                }

                Object item = null;
                switch (elementName) {
                    case "true":
                        item = Boolean.TRUE;
                        break;
                    case "false":
                        item = Boolean.FALSE;
                        break;
                    case "string":
                        item = text.toString();
                        break;
                    case "integer":
                        item = Integer.valueOf(text.toString());
                        break;
                    case "real":
                        item = Double.valueOf(text.toString());
                        break;
                    case "date":
                        try {
                            item = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ").parse(text.toString());
                        } catch (ParseException ex) {
                        }
                        break;
                    case "data":
                        item = new NSData(MiGBase64.decode(text.toString()));
                        break;
                    default:
                        break;
                }
                if (item != null)
                    stack.peek().store(keyname, item);
                keyname = null;
                text = null;
            }
        });
        p.parse();
        return root_dict.isEmpty() ? null : root_dict.get(0);
    }

    private static interface Container {

        String getkey();

        void store(String key, Object item);
    }

    private static class NSDictionaryDict extends HashMap<String, Object> implements Container {

        private String key;

        @Override
        public void store(String key, Object item) {
            if (key == null)
                throw new NullPointerException("NSDictionary <dict> error: <key> not defined");
            put(key, item);
        }

        @Override
        public String getkey() {
            return key;
        }
    }

    private static class NSDictionaryArray extends ArrayList<Object> implements Container {

        private String key;

        @Override
        public void store(String key, Object item) {
            add(item);
        }

        @Override
        public String getkey() {
            return key;
        }
    }
}
