/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

import org.crossmobile.bridge.ann.CMSelector;

import java.util.*;

@CMClass
public class WKUserContentController extends NSObject {
    private Set<WKUserScript> userScripts;
    private Map<String, WKScriptMessageHandler> messageHandlers;

    public WKUserContentController() {
        this(null);
    }

    WKUserContentController(WKUserContentController other) {
        if (other != null) {
            if (other.userScripts != null)
                this.userScripts = new LinkedHashSet<>(other.userScripts);
            if (other.messageHandlers != null)
                this.messageHandlers = new LinkedHashMap<>(other.messageHandlers);
        }
    }

    @CMSelector("- (void)addUserScript:(WKUserScript *)userScript;")
    public void addUserScript(WKUserScript userScript) {
        if (userScript == null)
            return;
        if (userScripts == null)
            userScripts = new LinkedHashSet<>();
        userScripts.add(userScript);
    }

    @CMSelector("- (void)removeAllUserScripts;")
    public void removeAllUserScripts() {
        userScripts = null;
    }

    @CMGetter("@property(nonatomic, readonly, copy) NSArray<WKUserScript *> *userScripts;")
    List<WKUserScript> userScripts() {
        return userScripts == null ? Collections.emptyList() : new ArrayList<>(userScripts);
    }

    @CMSelector("- (void)addScriptMessageHandler:(id<WKScriptMessageHandler>)scriptMessageHandler \n" +
            "                           name:(NSString *)name;\n")
    public void addScriptMessageHandler(WKScriptMessageHandler handler, String name) {
        if (handler == null)
            return;
        if (messageHandlers == null)
            messageHandlers = new LinkedHashMap<>();
        messageHandlers.put(name, handler);
    }

    @CMSelector("- (void)removeScriptMessageHandlerForName:(NSString *)name;")
    public void removeScriptMessageHandlerForName(String name) {
        messageHandlers.remove(name);
    }

    @CMSelector("- (void)removeAllScriptMessageHandlers;")
    public void removeAllScriptMessageHandlers() {
        messageHandlers = null;
    }
}
