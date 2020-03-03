/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

@class java_util_Observable;


// java.util.Observer
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@protocol java_util_Observer <NSObject>
- (void) update___java_util_Observable_java_lang_Object: (java_util_Observable*) o : (java_lang_Object*) arg;
@end

@interface java_util_Observer : java_lang_Object <java_util_Observer>
@end
