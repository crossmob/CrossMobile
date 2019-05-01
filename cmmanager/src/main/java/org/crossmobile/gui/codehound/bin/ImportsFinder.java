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
package org.crossmobile.gui.codehound.bin;

import com.strobel.assembler.metadata.*;
import com.strobel.decompiler.DecompilationOptions;
import com.strobel.decompiler.DecompilerSettings;
import com.strobel.decompiler.ITextOutput;
import com.strobel.decompiler.PlainTextOutput;
import com.strobel.decompiler.languages.java.JavaFormattingOptions;
import org.crossmobile.utils.ClasspathUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ImportsFinder {

    public static Collection<String> findAllImports(String classpath) throws IOException {
        ImportFilterWriter writer = new ImportFilterWriter();
        ITypeLoader tloader = new CompositeTypeLoader(new ClasspathTypeLoader(classpath));

        DecompilerSettings settings = new DecompilerSettings();
        settings.setForceExplicitImports(true);
        settings.setTypeLoader(tloader);
        settings.setJavaFormattingOptions(JavaFormattingOptions.createDefault());

        final DecompilationOptions decompilationOptions = new DecompilationOptions();
        decompilationOptions.setSettings(settings);
        decompilationOptions.setFullDecompilation(true);

        final ITextOutput out = new PlainTextOutput(writer);
        MetadataSystem metadataSystem = new NoRetryMetadataSystem(tloader);
        metadataSystem.setEagerMethodLoadingEnabled(false);
        int classesDecompiled = 0;

        for (String internalName : ClasspathUtils.getClasspathClasses(classpath)) {
            decompileType(metadataSystem, internalName, decompilationOptions, false, out);
            if (++classesDecompiled % 100 == 0)
                metadataSystem = new NoRetryMetadataSystem(tloader);
        }
        return writer.getClasses();
    }

    private static void decompileType(final MetadataSystem metadataSystem, final String typeName, final DecompilationOptions options, final boolean includeNested, ITextOutput out) throws IOException {
        final TypeReference type;
        final DecompilerSettings settings = options.getSettings();
        if (typeName.length() == 1) {
            final MetadataParser parser = new MetadataParser(IMetadataResolver.EMPTY);
            final TypeReference reference = parser.parseTypeDescriptor(typeName);
            type = metadataSystem.resolve(reference);
        } else
            type = metadataSystem.lookupType(typeName);
        final TypeDefinition resolvedType;
        if (type == null || (resolvedType = type.resolve()) == null)
//          System.err.println("Failed to load class " + typeName);
            return;
        if (!includeNested && (resolvedType.isNested() || resolvedType.isAnonymous() || resolvedType.isSynthetic()))
            return;
        settings.getLanguage().decompileType(resolvedType, out, options);
    }

    private static final class NoRetryMetadataSystem extends MetadataSystem {

        private final Set<String> _failedTypes = new HashSet();

        NoRetryMetadataSystem(final ITypeLoader typeLoader) {
            super(typeLoader);
        }

        @Override
        protected TypeDefinition resolveType(final String descriptor, final boolean mightBePrimitive) {
            if (_failedTypes.contains(descriptor))
                return null;

            final TypeDefinition result = super.resolveType(descriptor, mightBePrimitive);

            if (result == null)
                _failedTypes.add(descriptor);

            return result;
        }

    }

    private static final class ImportFilterWriter extends Writer {

        private StringBuilder out = new StringBuilder();
        private final Set<String> imports = new TreeSet<>();

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            for (int idx = off; idx < cbuf.length && idx < (off + len); idx++) {
                char c = cbuf[idx];
                if (c == '\n') {
                    parseLine();
                    out = new StringBuilder();
                } else
                    out.append(c);
            }
        }

        private void parseLine() {
            String line = out.toString().trim();
            if (!line.isEmpty() && line.startsWith("import"))
                imports.add(line.substring(7, line.length() - 1));
        }

        @Override
        public void flush() throws IOException {
            parseLine();
        }

        @Override
        public void close() throws IOException {
        }

        public Set<String> getClasses() {
            return imports;
        }
    }
}
