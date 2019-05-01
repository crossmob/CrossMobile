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

#import "java_util_Locale.h"


// java.util.Locale
//----------------------------------------------------------------------------
@implementation java_util_Locale

static Class localeClass;

+ (void) initialize
{
	localeClass = [java_util_Locale class];
}	

- (id) init
{
	if (self = [super init]) {
		self->language = JAVA_NULL;
		self->languageHash = 0;
		self->country = JAVA_NULL;
		self->countryHash = 0;
	}
	return self;
}

- (instancetype) __init_java_util_Locale___java_lang_String: (java_lang_String*) theLanguage
{
    [self init];
	language = [theLanguage retain];
	languageHash = [theLanguage hash];
    return self;
}

- (instancetype) __init_java_util_Locale___java_lang_String_java_lang_String:(java_lang_String*) theLanguage
                                                                    :(java_lang_String*) theCountry
{
    [self init];
	language = [theLanguage retain];
	languageHash = [theLanguage hash];
	country = [theCountry retain];
	countryHash = [theCountry hash];
    return self;
}

- (void) dealloc
{
	[language release];
	[country release];
	[super dealloc];
}

+ (java_util_Locale*) getDefault__
{
	NSUserDefaults* defs = [NSUserDefaults standardUserDefaults];
	NSArray* languages = [defs objectForKey:@"AppleLanguages"];
	NSString* preferredLang = [languages objectAtIndex:0];

	java_util_Locale *l = [[java_util_Locale alloc] init];
	[l __init_java_util_Locale___java_lang_String:preferredLang];
	return l;
}

- (int) equals___java_lang_Object:(java_lang_Object*) obj
{
	if (![obj isKindOfClass:localeClass]) {
		return 0;
	}
	java_util_Locale* other = (java_util_Locale*) obj;
	if ((countryHash != other->countryHash) || (languageHash != other->languageHash)) {
		return 0;
	}
	// Hash values match. Now make sure that the strings are actually equal
	if ([language isEqual:other->language] && [country isEqual:other->country]) {
		return 1;
	}
	return 0;
}

- (java_lang_String*) toString__
{
  return [language retain];
}

- (java_lang_String*) getLanguage__
{
	return [language retain];
}

- (java_lang_String*) getCountry__
{
	return [country retain];
}

@end
