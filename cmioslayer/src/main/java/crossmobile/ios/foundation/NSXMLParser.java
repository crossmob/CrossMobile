/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import net.n3.nanoxml.IXMLElement;
import net.n3.nanoxml.IXMLParser;
import net.n3.nanoxml.StdXMLReader;
import net.n3.nanoxml.XMLParserFactory;
import org.crossmobile.bridge.ann.*;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static org.crossmobile.bind.system.AbstractLifecycleBridge.errorFromThrowable;

/**
 * NSXMLParser class defines an object that is used in order to parse XML
 * documents.
 */
@CMClass
public class NSXMLParser extends NSObject {

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
     * Sets a Boolean that defines whether the parser should process the
     * namespaces.
     *
     * @param flag TRUE the parser should report the namespaces.
     */
    @CMSetter("@property BOOL shouldProcessNamespaces;")
    public void setShouldProcessNamespaces(boolean flag) {
        this.shouldProcessNamespaces = flag;
    }

    /**
     * Returns a Boolean that shows whether the parser process the namespaces.
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
            IXMLParser parser = XMLParserFactory.createDefaultXMLParser();
            //noinspection CharsetObjectCanBeUsed
            parser.setReader(StdXMLReader.stringReader(new String(data.data, "UTF-8")));
            if (delegate != null)
                fire((IXMLElement) parser.parse());
            return true;
        } catch (Exception ex) {
            error = NSError.errorWithDomain(NSError.Domain.NSPOSIX, 0, errorFromThrowable(ex));
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    private void fire(IXMLElement element) {
        Map<String, String> attributes = new HashMap<>();
        Enumeration<String> names = element.enumerateAttributeNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            attributes.put(name, element.getAttribute(name, null));
        }
        delegate.didStartElement(this, element.getName(), element.getNamespace(), element.getFullName(), attributes);

        Enumeration<IXMLElement> children = element.enumerateChildren();
        while (children.hasMoreElements())
            fire(children.nextElement());

        String content = element.getContent();
        if (content != null && !content.isEmpty())
            delegate.foundCharacters(this, content);

        delegate.didEndElement(this, element.getName(), element.getNamespace(), element.getFullName());
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

}
