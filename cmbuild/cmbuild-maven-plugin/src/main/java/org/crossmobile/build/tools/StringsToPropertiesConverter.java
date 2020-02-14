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
package org.crossmobile.build.tools;

import com.dd.plist.PropertyListParser;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.build.antlr.LProjBaseListener;
import org.crossmobile.build.antlr.LProjLexer;
import org.crossmobile.build.antlr.LProjParser;
import org.crossmobile.build.ib.i18n.LocalizedType;
import org.crossmobile.build.ib.i18n.TranslationElement;
import org.crossmobile.build.ib.i18n.TranslationTable;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.crossmobile.bridge.system.I18Nparser.*;
import static org.crossmobile.utils.TextUtils.plural;

public class StringsToPropertiesConverter extends LProjBaseListener {

    private static final Map<String, String> DICT_ENTRIES = new HashMap<>();

    private static final String PLURAL_TYPE = "NSStringPluralRuleType";
    private static final String GENDER_TYPE = "NSStringGenderRuleType";
    private static final Collection<String> DICT_TYPES = new HashSet<>(Arrays.asList(PLURAL_TYPE, GENDER_TYPE));

    static {
        DICT_ENTRIES.put("zero", ZERO);
        DICT_ENTRIES.put("one", ONE);
        DICT_ENTRIES.put("two", TWO);
        DICT_ENTRIES.put("other", OTHER);
        DICT_ENTRIES.put("few", FEW);
        DICT_ENTRIES.put("many", MANY);
    }

    private final JsonObject entries = Json.object();
    private StringBuilder missing;

    public static String parseStrings(File file, LocalizedType localizedType, TranslationTable table) {
        StringsToPropertiesConverter converter = new StringsToPropertiesConverter();
        try (Reader r = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            ANTLRInputStream input = new ANTLRInputStream(r);
            LProjLexer lexer = new LProjLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LProjParser parser = new LProjParser(tokens);

            ParseTree tree = parser.lproj();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(converter, tree);
        } catch (IOException e) {
            Log.error("Unable to parse .strings file " + file.getAbsolutePath());
            BaseUtils.throwException(e);
        }
        if (table != null && localizedType != null && !localizedType.isBase) {
            int howMany = converter.findMissing(table, file);
            if (howMany > 0) {
                Log.warning("Appended " + howMany + " " + (howMany > 1 ? "entries" : "entry") + " for localized file " + file.getAbsolutePath());
                FileUtils.write(file, FileUtils.read(file) + converter.missing.toString());
            }
        }
        return converter.entries.toString();
    }

    private int findMissing(TranslationTable table, File file) {
        missing = new StringBuilder();
        int howMany = 0;
        Collection<String> notValidAnymore = new HashSet<>(entries.names());
        for (TranslationElement element : table)
            if (entries.get(element.key) == null) {
                entries.add(element.key, element.text);
                howMany++;
                missing.append("\n/*").
                        append(" Class = \"").append(element.classType).append("\";").
                        append(" ObjectID = \"").append(element.objectId).append("\";").
                        append(" Property = \"").append(element.property).append("\";").
                        append(" text = \"").append(element.text).append("\";").
                        append(" */\n").
                        append("\"").append(element.key).append("\" = \"").append(element.text).append("\";\n");
            } else
                notValidAnymore.remove(element.key);
        if (!notValidAnymore.isEmpty()) {
            Log.warning("The following translation" + plural(notValidAnymore.size()) + " in file " + file.getAbsolutePath() + " might not be valid anymore and probably " +
                    "should be removed:");
            for (String entry : notValidAnymore)
                Log.warning("\u00A0\u00A0\u00A0\u00A0\"" + entry + "\"");
        }
        return howMany;
    }

    @Override
    public void exitPair(LProjParser.PairContext ctx) {
        String key = ctx.key.getText();
        String value = ctx.value.getText();
        key = key.substring(1, key.length() - 1);       // remove quotes
        value = value.substring(1, value.length() - 1); // remove quotes
        entries.add(key, value);
    }

    @SuppressWarnings("unchecked")
    public static String parseStringsDict(File input) {
        JsonObject rootJ = Json.object();
        try {
            Map<String, Map<String, Object>> root = (Map<String, Map<String, Object>>) PropertyListParser.parse(input).toJavaObject();
            for (String translation : root.keySet()) {
                Map<String, Object> fields = root.get(translation);
                String format = (String) fields.remove("NSStringLocalizedFormatKey");
                JsonObject translationJ = Json.object();
                rootJ.add(translation, translationJ);
                translationJ.add(FORMAT, format);

                for (String field : fields.keySet()) {
                    Map<String, String> forms = (Map<String, String>) fields.get(field);

                    String specType = forms.remove("NSStringFormatSpecTypeKey");
                    if (specType == null || !DICT_TYPES.contains(specType)) {
                        Log.warning("Skipping entry " + field + " in translation " + translation + " due to incorrect NSStringFormatSpecTypeKey: " + specType);
                        continue;
                    }
                    String valueType = forms.remove("NSStringFormatValueTypeKey");
                    if (valueType == null || valueType.trim().isEmpty()) {
                        Log.warning("Entry " + field + " in translation " + translation + " missing value of NSStringFormatValueTypeKey");
                        continue;
                    }
                    if (specType.equals(PLURAL_TYPE) && forms.getOrDefault("other", "").trim().isEmpty()) {
                        Log.error("Entry " + field + " in translation " + translation + " missing value of `other` type");
                        continue;
                    }

                    JsonObject fieldJ = Json.object();
                    translationJ.add(field, fieldJ);
                    fieldJ.add(TYPE, valueType);
                    for (String form : forms.keySet()) {
                        final String formTo = forms.getOrDefault(form, "");
                        if (!formTo.isEmpty())
                            fieldJ.add(DICT_ENTRIES.getOrDefault(form, form), formTo);
                    }
                }
            }
            return rootJ.toString();
        } catch (Exception e) {
            Log.error("Unable to parse .stringsdict file " + input.getAbsolutePath());
            BaseUtils.throwException(e);
        }
        return null;
    }
}
