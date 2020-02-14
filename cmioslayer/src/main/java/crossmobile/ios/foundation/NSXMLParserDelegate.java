/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.Map;

/**
 * NSXMLParserDelegate interface is the delegate responsible to collaborate with
 * NSXMLParser objects.
 */
@CMClass
public interface NSXMLParserDelegate {

    /**
     * It is used by the parser when it first meets the specified prefix.
     *
     * @param parser       The parser that corresponds to this delegate.
     * @param prefix       The namespace of the prefix.
     * @param namespaceURI A string that specifies a namespace URI.
     */
    @CMSelector("- (void)parser:(NSXMLParser *)parser \n"
            + "didStartMappingPrefix:(NSString *)prefix \n"
            + "         toURI:(NSString *)namespaceURI;")
    default public void didStartMappingPrefix(NSXMLParser parser, String prefix, String namespaceURI) {
    }

    /**
     * It is used by the parser when the namespace of the specified prefix goes
     * out of scope.
     * <p>
     * Sent by a parser object to its delegate when a given namespace prefix
     * goes out of scope.
     *
     * @param parser The parser that corresponds to this delegate.
     * @param prefix The namespace of the prefix.
     */
    @CMSelector("- (void)parser:(NSXMLParser *)parser \n"
            + "didEndMappingPrefix:(NSString *)prefix;")
    default public void didEndMappingPrefix(NSXMLParser parser, String prefix) {
    }

    /**
     * It is used by the parser when it finds a start tag of an element.
     *
     * @param parser        The parser that corresponds to this delegate.
     * @param elementName   The name of the element.
     * @param namespaceURI  The URI of the current namespace.
     * @param qualifiedName The qualified name of the current namespace.
     * @param attributes    Attributes of the element.
     */
    @CMSelector("- (void)parser:(NSXMLParser *)parser \n"
            + "didStartElement:(NSString *)elementName \n"
            + "  namespaceURI:(NSString *)namespaceURI \n"
            + " qualifiedName:(NSString *)qName \n"
            + "    attributes:(NSDictionary<NSString *,NSString *> *)attributeDict;")
    default public void didStartElement(NSXMLParser parser, String elementName, String namespaceURI, String qualifiedName, Map<String, String> attributes) {
    }

    /**
     * It is used by the parser when it finds an end tag of an element.
     *
     * @param parser        The parser that corresponds to this delegate.
     * @param elementName   The name of the element.
     * @param namespaceURI  The URI of the current namespace.
     * @param qualifiedName The qualified name of the current namespace.
     */
    @CMSelector("- (void)parser:(NSXMLParser *)parser \n"
            + " didEndElement:(NSString *)elementName \n"
            + "  namespaceURI:(NSString *)namespaceURI \n"
            + " qualifiedName:(NSString *)qName;")
    default public void didEndElement(NSXMLParser parser, String elementName, String namespaceURI, String qualifiedName) {
    }

    /**
     * It is used in order to provide a String with all the characters of the
     * current element.
     *
     * @param parser     The parser that corresponds to this delegate.
     * @param characters The String that contains all the element's characters.
     */
    @CMSelector("- (void)parser:(NSXMLParser *)parser \n"
            + "foundCharacters:(NSString *)string;")
    default public void foundCharacters(NSXMLParser parser, String characters) {
    }

    /**
     * It is used when the parser comes across CDATA block.
     *
     * @param parser     The parser that corresponds to this delegate.
     * @param CDATABlock The data that contains the CDATA block.
     */
    @CMSelector("- (void)parser:(NSXMLParser *)parser \n"
            + "    foundCDATA:(NSData *)CDATABlock;")
    default public void foundCDATA(NSXMLParser parser, NSData CDATABlock) {
        // TODO : call me from DefaultHandler
    }

}
