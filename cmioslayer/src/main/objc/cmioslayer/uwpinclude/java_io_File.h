/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 */

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_net_URI.h"
#import "java_io_FilenameFilter.h"

static java_lang_String* _separator = @"/";
CM_EXPORT_CLASS
@interface java_io_File : java_lang_Object {
	java_lang_String* path;
}

+ (java_lang_String*) _GET_separator;
+ (XMLVMArray*) listRoots__;

+ (java_io_File*) createTempFile___java_lang_String_java_lang_String:(java_lang_String*)prefix :(java_lang_String*)suffix;

- (instancetype) __init_java_io_File___java_net_URI: (java_net_URI*) uri;
- (instancetype) __init_java_io_File___java_lang_String: (java_lang_String*) pathname;
- (instancetype) __init_java_io_File___java_io_File_java_lang_String: (java_io_File*) dir: (java_lang_String*) name;

- (void) dealloc;

- (bool) canRead__;
- (bool) canWrite__;
- (bool) createNewFile__;
- (bool) delete__;
- (bool) exists__;
- (JAVA_LONG) length__;
- (java_lang_String*) getName__;
- (java_lang_String*) getPath__;
- (java_net_URI*) toURI__;
- (bool) isDirectory__;
- (bool) isHidden__;
- (JAVA_LONG) lastModified__;
- (XMLVMArray*) listFiles__;
- (XMLVMArray*) listFiles___java_io_FilenameFilter: (java_io_FilenameFilter*) filter;
- (XMLVMArray*) list__;
- (XMLVMArray*) list___java_io_FilenameFilter: (java_io_FilenameFilter*) filter;
- (bool) mkdir__;
- (bool) mkdirs__;
- (java_lang_String*) getAbsolutePath__;
- (java_lang_String*) getCanonicalPath__;
- (JAVA_LONG) getUsableSpace__;
- (bool) renameTo___java_io_File: (java_io_File*) f;
- (java_io_File*) getParentFile__;

@end
