/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.plugin.actions;

import org.crossmobile.bridge.ann.CMLibTarget.BaseTarget;
import org.crossmobile.build.ArtifactInfo;
import org.crossmobile.plugin.Packages;
import org.crossmobile.plugin.Repository;
import org.crossmobile.plugin.reg.PackageRegistry;
import org.crossmobile.plugin.reg.PluginRegistry;
import org.crossmobile.plugin.reg.ProguardRegistry;
import org.crossmobile.plugin.utils.ClassCollection;
import org.crossmobile.utils.JarUtils;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.plugin.DependencyItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.io.File.separator;
import static org.crossmobile.plugin.actions.CreateBeanAPI.OBJ_STYLE;
import static org.crossmobile.plugin.actions.ProjectRegistry.*;
import static org.crossmobile.utils.FileUtils.delete;
import static org.crossmobile.utils.FileUtils.mkdirs;
import static org.crossmobile.utils.JarUtils.unzipJar;
import static org.crossmobile.utils.TextUtils.plural;
import static org.crossmobile.utils.TimeUtils.time;

public class PluginAssembler {
    public static final String BUNDLES = "bundles";

    public static final BiFunction<File, String, File> compileBase = (target, plugin) -> new File(target, BUNDLES + separator + plugin + separator + "compile");
    public static final BiFunction<File, String, File> builddepBase = (target, plugin) -> new File(target, BUNDLES + separator + plugin + separator + "builddep");
    public static final BiFunction<File, String, File> desktopBase = (target, plugin) -> new File(target, BUNDLES + separator + plugin + separator + "desktop");
    public static final BiFunction<File, String, File> androidBase = (target, plugin) -> new File(target, BUNDLES + separator + plugin + separator + "android");
    public static final BiFunction<File, String, File> iosBase = (target, plugin) -> new File(target, BUNDLES + separator + plugin + separator + "ios");
    public static final BiFunction<File, String, File> uwpBase = (target, plugin) -> new File(target, BUNDLES + separator + plugin + separator + "uwp");
    public static final BiFunction<File, String, File> rvmBase = (target, plugin) -> new File(target, BUNDLES + separator + plugin + separator + "rvm");

    private static final byte SOURCE_TYPE = OBJ_STYLE;

    public static void assemble(File target, DependencyItem root,
                                String[] embedlibs, boolean obfuscate,
                                File proguardConf, File vendorFiles,
                                Consumer<ArtifactInfo> installer,
                                Function<ArtifactInfo, File> resolver,
                                File proguard, File proguardMap,
                                File cachedir, Packages[] packs,
                                boolean buildDesktop, boolean buildIos, boolean buildAndroid, boolean buildUwp, boolean buildRvm, boolean buildCore,
                                File VStudioLocation, File report, Repository repository) {

        File encjar = new File(target, root.getArtifactID() + "-" + root.getVersion() + ".pro.jar");
        File runtime = new File(target, "runtime");
        File runtime_rvm = new File(target, "runtime_rvm");
        File bundles = new File(target, BUNDLES);
        delete(bundles);

        ClassCollection cc = new ClassCollection();
        time(() -> {
            time(() -> {
                ProjectRegistry.register(root, embedlibs, cc);
                if (packs != null && packs.length > 0)
                    for (Packages pack : packs)
                        if (pack != null)
                            PackageRegistry.register(pack.getName(), pack.getPlugin(), pack.getTarget());
            }, "Initialize classes");

            time(() -> {
                if (obfuscate) {
                    Obfuscator.obfuscate(proguard, proguardConf, proguardMap, root.getFile(), encjar, getLibAndBlacklistedJars(), getEmbedjars());
                    ProguardRegistry.register(proguardMap);
                } else
                    JarUtils.createJar(null, encjar, getAppjars().toArray(new File[]{}));

                if (buildIos || buildDesktop || buildUwp || buildAndroid) {
                    unzipJar(encjar, runtime);
                }
            }, "Encrypt and downgrade");

            time(() -> {
                Log.info("Parse native API");
                for (Class cls : buildUwp ? cc.getUWPNativeClasses() : cc.getIOsNativeClasses())
                    Parser.parse(cls);
                XMLPluginWriter.updateXML(repository, root);
            }, "Native Parser");
            CodeReverse codeRev = time(() -> new CodeReverse(cc.getClassPool()), "Create reverse code");
//            time(() -> new JavaTransformer(cc.getClassPool(), runtime_rvm));
            time(() -> new CreateLibs(resolver, target, cachedir, vendorFiles, null, buildIos), "Create iOS libraries");
            time(() -> new CreateDlls(resolver, target, cachedir, vendorFiles, VStudioLocation, buildUwp), "Create UWP libraries");

            time(() -> {
                for (String plugin : PluginRegistry.plugins()) {
                    mkdirs(compileBase.apply(target, plugin));
                    mkdirs(builddepBase.apply(target, plugin));
                    if (buildDesktop)
                        mkdirs(desktopBase.apply(target, plugin));
                    if (buildAndroid)
                        mkdirs(androidBase.apply(target, plugin));
                    if (buildIos)
                        mkdirs(iosBase.apply(target, plugin));
                    if (buildUwp)
                        mkdirs(uwpBase.apply(target, plugin));
                    if (buildRvm)
                        mkdirs(rvmBase.apply(target, plugin));
                }
//                Πιθανών να Μην χρειάζεαται
//
//                Log.info("Update API");
//                CreateBeanAPI bean = new CreateBeanAPI(cc.getClassPool());
//                for (Class cls : cc.getCompileTimeClasses())
//                    bean.beanClass(cls, runtime);

                Log.info("Create stub compile-time files");
                CreateSkeleton skel = new CreateSkeleton(cc.getClassPool());
                int hm = 0;
                for (Class cls : cc.getCompileTimeClasses())
                    hm += skel.stripClass(cls, plugin -> compileBase.apply(target, plugin), SOURCE_TYPE) ? 1 : 0;
                for (Class cls : cc.getBuildDependencyClasses())
                    hm += skel.stripClass(cls, plugin -> builddepBase.apply(target, plugin), SOURCE_TYPE) ? 1 : 0;
                // Still might need to add extra resource files
                CreateBundles.bundleFiles(runtime, plugin -> compileBase.apply(target, plugin), CreateBundles.noClassResolver, BaseTarget.COMPILE, true);
                CreateBundles.bundleFiles(runtime, plugin -> builddepBase.apply(target, plugin), CreateBundles.noClassResolver, BaseTarget.BUILDDEP, false);

                Log.debug(hm + " class" + plural(hm, "es") + " stripped");
            }, "Initialize and create stub compile-time files");
            time(() -> {
                Log.info("Create distributions of artifacts");
                if (buildDesktop)
                    CreateBundles.bundleFiles(runtime, plugin -> desktopBase.apply(target, plugin), CreateBundles.bundleResolver, BaseTarget.DESKTOP);
                if (buildIos)
                    CreateBundles.bundleFiles(runtime, plugin -> iosBase.apply(target, plugin), CreateBundles.bundleResolver, BaseTarget.IOS);
                if (buildRvm)
                    CreateBundles.bundleFiles(runtime_rvm, plugin -> rvmBase.apply(target, plugin), CreateBundles.bundleResolver, BaseTarget.IOS);
                if (buildUwp)
                    CreateBundles.bundleFiles(runtime, plugin -> uwpBase.apply(target, plugin), CreateBundles.bundleResolver, BaseTarget.UWP);
                if (buildAndroid)
                    CreateBundles.bundleFiles(runtime, plugin -> androidBase.apply(target, plugin), CreateBundles.bundleResolver, BaseTarget.ANDROID);

                StringWriter writer = report == null ? null : new StringWriter();
                for (String plugin : PluginRegistry.plugins())
                    CreateArtifacts.installPlugin(installer, plugin, target, root, cachedir, vendorFiles, codeRev,
                            buildDesktop, buildIos, buildUwp, buildAndroid, buildRvm, buildCore, writer);
                if (writer != null)
                    try (OutputStreamWriter filewriter = new OutputStreamWriter(new FileOutputStream(report), StandardCharsets.UTF_8)) {
                        filewriter.write(writer.toString().replaceAll(root.getVersion(), "<VERSION>"));
                        filewriter.flush();
                    } catch (Exception e) {
                        Log.error("Unable to store reports.txt", e);
                    }
            }, "Install targets");

        }, "");
    }

}
