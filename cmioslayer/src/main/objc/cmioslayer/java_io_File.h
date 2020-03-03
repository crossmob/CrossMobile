/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_net_URI.h"
#import "java_io_FilenameFilter.h"

static java_lang_String* _separator = @"/";
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
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
- (bool) isFile__;
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
