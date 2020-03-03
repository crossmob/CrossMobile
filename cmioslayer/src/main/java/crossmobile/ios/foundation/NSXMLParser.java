// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import static org.crossmobile.bind.system.AbstractLifecycleBridge.errorFromThrowable;

/**
 * NSXMLParser class defines an object that is used in order to parse XML
 * documents.
 */
@CMClass
public class NSXMLParser extends NSObject {

    private static SAXParserFactory FACTORY;

    NSXMLParserDelegate delegate;
    private final NSData data;
    private boolean shouldReportNamespacePrefixes;
    private boolean shouldProcessNamespaces;
    private NSError error;

    /**
     * Constructs an NSXMLParser for the specified NSData object.
     *
     * @param data The NSData for which the NSXMLPareser is created.
     */
    @CMConstructor("- (instancetype)initWithData:(NSData *)data;")
    public NSXMLParser(NSData data) {
        this.data = data;
    }

    /**
     * Sets specified delegate of this NSXMLParser object.
     *
     * @param delegate The delegate of this NSXMLParser object.
     */
    @CMSetter("@property(assign) id<NSXMLParserDelegate> delegate;")
    public void setDelegate(NSXMLParserDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Sets a Boolean that defines whether the parser should report the
     * namespaces.
     *
     * @param flag TRUE the parser should report the namespaces.
     */
    @CMSetter("@property BOOL shouldProcessNamespaces;")
    public void setShouldProcessNamespaces(boolean flag) {
        this.shouldProcessNamespaces = flag;
    }

    /**
     * Returns a Boolean that shows whether the parser reports the namespaces.
     *
     * @return TRUE the parser reports the namespaces.
     */
    @CMGetter("@property BOOL shouldProcessNamespaces;")
    public boolean shouldProcessNamespaces() {
        return shouldProcessNamespaces;
    }

    /**
     * Sets a Boolean that defines whether the parser should report the prefixes
     * that define the namespace.
     *
     * @param flag TRUE the parser should report the prefixes.
     */
    @CMSetter("@property BOOL shouldReportNamespacePrefixes;")
    public void setShouldReportNamespacePrefixes(boolean flag) {
        this.shouldReportNamespacePrefixes = flag;
    }

    /**
     * Returns a Boolean that shows whether the parser reports the prefixes that
     * define the namespace.
     *
     * @return TRUE the parser reports the prefixes.
     */
    @CMGetter("@property BOOL shouldReportNamespacePrefixes;")
    public boolean shouldReportNamespacePrefixes() {
        return this.shouldReportNamespacePrefixes;
    }

    /**
     * Starts the parsing operation.
     *
     * @return TRUE then the parsing was successful.
     */
    @CMSelector("- (BOOL)parse;")
    public boolean parse() {
        error = null;
        if (data == null)
            return false;
        try {
            parse(this, new String(data.data, "UTF-8"));
            return true;
        } catch (Exception ex) {
            error = NSError.errorWithDomain(NSError.Domain.NSPOSIX, 0, errorFromThrowable(ex));
            return false;
        }
    }

    /**
     * Returns an NSError object that contains information about a parsing
     * error.
     *
     * @return An NSError object that contains information about a parsing
     * error.
     */
    @CMGetter("@property(readonly, copy) NSError *parserError;")
    public NSError parserError() {
        return error;
    }

    private WeakReference<NSXMLParser> parser;
    DefaultHandler handler = new DefaultHandler() {
        @Override
        public InputSource resolveEntity(String publicID, String systemID) throws IOException, SAXException {
            return new InputSource(new StringReader(""));
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) {
            if (delegate != null)
                delegate.didStartMappingPrefix(parser.get(), prefix, uri);
        }

        @Override
        public void endPrefixMapping(String prefix) {
            if (delegate != null)
                delegate.didEndMappingPrefix(parser.get(), prefix);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            Map<String, String> attribs = new HashMap<>();
            for (int i = 0; i < attributes.getLength(); i++)
                attribs.put(attributes.getQName(i), attributes.getValue(i));
            if (delegate != null)
                delegate.didStartElement(parser.get(), qName, uri, qName, attribs);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (delegate != null)
                delegate.didEndElement(parser.get(), qName, uri, qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String characters = String.copyValueOf(ch, start, length);
            if (delegate != null)
                delegate.foundCharacters(parser.get(), characters);
        }
    };

    void parse(NSXMLParser parser, String data) throws Exception {
        if (FACTORY == null) {
            FACTORY = SAXParserFactory.newInstance();
            FACTORY.setValidating(false);
        }

        this.parser = new WeakReference<>(parser);
        SAXParser saxParser = FACTORY.newSAXParser();
        try {
            saxParser.setProperty("namespaces", parser.shouldProcessNamespaces());
        } catch (SAXNotRecognizedException | SAXNotSupportedException e) {
        }
        try {
            saxParser.setProperty("namespace-prefixes", parser.shouldReportNamespacePrefixes());
        } catch (SAXNotRecognizedException | SAXNotSupportedException e) {
        }
        saxParser.parse(new InputSource(new StringReader(data)), handler);
    }

}
