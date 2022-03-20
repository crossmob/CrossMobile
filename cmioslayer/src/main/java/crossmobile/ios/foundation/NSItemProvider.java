/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.List;
import java.util.Map;

@CMClass
public class NSItemProvider extends NSObject {

    private List<String> registeredTypeIdentifiers;
    private NSItemProviderLoadHandler previewImageHandler;

    @CMConstructor("- (instancetype)initWithContentsOfURL:(NSURL *)fileURL;")
    public NSItemProvider(NSURL fileURL) {

    }

    @CMConstructor("- (instancetype)initWithItem:(id<NSSecureCoding>)item"
            + "typeIdentifier:(NSString *)typeIdentifier;")
    public NSItemProvider(NSSecureCoding item, String typeIdentifier) {

    }
    /*

    @CMSelector("- (void)registerItemForTypeIdentifier:(NSString *)typeIdentifier\n"
            + "    loadHandler:(NSItemProviderLoadHandler)loadHandler;")
    public void registerItemForTypeIdentifier(String typeIdentifier, NSItemProviderLoadHandler loadHandler) {

    }*/

    @CMGetter("@property(copy, readonly, nonatomic) NSArray *registeredTypeIdentifiers;")
    public List<String> registeredTypeIdentifiers() {
        return registeredTypeIdentifiers;
    }

    @CMSelector(" - (BOOL)hasItemConformingToTypeIdentifier:(NSString *)typeIdentifier;")
    public boolean hasItemConformingToTypeIdentifier(String typeIdentifier) {
        return false;
    }

    @CMSelector("- (void)loadItemForTypeIdentifier:(NSString *)typeIdentifier\n"
            + "    options:(NSDictionary *)options\n"
            + "    completionHandler:(NSItemProviderCompletionHandler)completionHandler;")
    public void loadItemForTypeIdentifier(String typeIdentifier, Map<String, Object> options, NSItemProviderCompletionHandler completionHandler) {

    }

    @CMSelector("- (void)loadPreviewImageWithOptions:(NSDictionary *)options\n"
            + "    completionHandler:(NSItemProviderCompletionHandler)completionHandler;")
    public void loadPreviewImageWithOptions(Map<String, Object> options, NSItemProviderCompletionHandler completionHandler) {

    }
/*
    @CMGetter("@property(copy, nonatomic) NSItemProviderLoadHandler previewImageHandler;")
    public NSItemProviderLoadHandler previewImageHandler() {
        return previewImageHandler;
    }

    @CMSetter("@property(copy, nonatomic) NSItemProviderLoadHandler previewImageHandler;")
    public void setPreviewImageHandler(NSItemProviderLoadHandler previewImageHandler) {
        this.previewImageHandler = previewImageHandler;
    }*/

}
