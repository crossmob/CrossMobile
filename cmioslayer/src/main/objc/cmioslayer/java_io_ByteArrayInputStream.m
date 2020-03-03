/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_io_ByteArrayInputStream.h"

@implementation java_io_ByteArrayInputStream;

- (instancetype) __init_java_io_ByteArrayInputStream___byte_ARRAYTYPE_int_int :(XMLVMArray*)buf :(int)from :(int)len
{
	self->length = len;
	self->buffer = malloc(sizeof(char)*len);

	int src = from;
	int dst = 0;
	while (dst < len) {
		buffer[dst++] = buf->array.b[src++];
	}
	self->pos = 0;
	self->marked = 0;
    return self;
}

- (instancetype) __init_java_io_ByteArrayInputStream___byte_ARRAYTYPE: (XMLVMArray*)buf
{
	return [self __init_java_io_ByteArrayInputStream___byte_ARRAYTYPE_int_int:buf :0 :[buf count]];
}

- (int) read__
{
	if (pos>=length) {
		return -1;
	} else {
		return buffer[pos++];
	}
}

- (void) dealloc
{
	free(buffer);
	[super dealloc];
}

- (bool) available__
{
  return length - pos;
}

- (JAVA_LONG) skip___long: (JAVA_LONG) shift
{
  pos += shift;
  if (pos >= length) {
  	pos = length;
  }
  return pos;
}

- (void) mark___long: (JAVA_LONG) max
{
  marked = pos;
}

- (void) mark___int: (int) max
{
  marked = pos;
}


- (void) reset__
{
  pos = marked;
}

- (int) read___byte_ARRAYTYPE :(XMLVMArray*)buf
{
  if (pos >= length) {
  	return -1;
  }
  int len = [buf count];
  int c = 0;
  int p2 = pos;
  while (p2 < length && c < len) {
    buf->array.b[c++] = buffer[p2++];
  }
  pos = p2;
  return c;
}

- (int) read___byte_ARRAYTYPE_int_int :(XMLVMArray*)buf :(int)offs :(int)len
{
  if (pos >= length) {
  	return -1;
  }
  int c = 0;
  int p2 = pos;
  while (p2 < length && c < len) {
    buf->array.b[offs+(c++)] = buffer[p2++];
  }
  pos = p2;
  return c;
}

// duplicate of read___byte_ARRAYTYPE_int_int - needed?
- (int) read___char_ARRAYTYPE_int_int: (XMLVMArray *) buf: (int) offs: (int) len
{
  if (pos >= length) {
  	return -1;
  }
  int c = 0;
  int p2 = pos;
  while (p2 < length && c < len) {
    buf->array.c[offs+(c++)] = buffer[p2++];
  }
  pos = p2;
  return c;
}

- (java_lang_String*) readLine__
{
	return JAVA_NULL;
}

- (void) close__
{
}

@end
