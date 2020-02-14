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
package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.*;

/**
 * NSURLCache class defines an object that represents cache for URL load
 * requests.
 */
@CMClass
public class NSURLCache extends NSObject {

    private int memoryCapacity;
    private int diskCapacity;
    private int currentMemoryUsage;
    private int currentDiskUsage;
    private final String path;

    /**
     * Constructs a cache object with the specified memory and disk
     * capacity,located to the specified path.
     *
     * @param memoryCapacity The memory capacity of the object.
     * @param diskCapacity   The disk capacity of the object.
     * @param path           The location on the disk of the cache object.
     */
    @CMConstructor("- (instancetype)initWithMemoryCapacity:(NSUInteger)memoryCapacity \n"
            + "                          diskCapacity:(NSUInteger)diskCapacity \n"
            + "                              diskPath:(NSString *)path;")
    public NSURLCache(int memoryCapacity, int diskCapacity, String path) {
        this.memoryCapacity = memoryCapacity;
        this.diskCapacity = diskCapacity;
        this.path = path;
    }

    /**
     * Sets the memory capacity of the cache object.
     *
     * @param memoryCapacity The memory capacity of the cache object in bytes.
     */
    @CMSetter("@property NSUInteger memoryCapacity;")
    public void setMemoryCapacity(int memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    /**
     * Returns the capacity of the cache object.
     *
     * @return The capacity of the cache object in bytes.
     */
    @CMGetter("@property NSUInteger memoryCapacity")
    public int memoryCapacity() {
        return memoryCapacity;
    }

    /**
     * Returns the current size of the cache on the disk.
     *
     * @return The current size of the cache on the disk.
     */
    @CMGetter("@property(readonly) NSUInteger currentMemoryUsage;")
    public int currentMemoryUsage() {
        return currentMemoryUsage;
    }

    /**
     * Sets the size of the cache on the disk.
     *
     * @param diskCapacity The size of the cache on the disk in bytes.
     */
    @CMSetter("@property NSUInteger diskCapacity;")
    public void setDiskCapacity(int diskCapacity) {
        this.diskCapacity = diskCapacity;
    }

    /**
     * Returns the capacity of the cache on the disk.
     *
     * @return The capacity of the cache on the disk in bytes.
     */
    @CMGetter("@property NSUInteger diskCapacity;")
    public int diskCapacity() {
        return diskCapacity;
    }

    /**
     * Returns the current size of the disk.
     *
     * @return The current size of the disk.
     */
    @CMGetter("@property(readonly) NSUInteger currentDiskUsage;")
    public int currentDiskUsage() {
        return currentDiskUsage;
    }

    /**
     * Clears the cache.
     */
    @CMSelector("- (void)removeAllCachedResponses;")
    public void removeAllCachedResponses() {
    }

    /**
     * Removes the cached URL response for a specified URL request.
     *
     * @param request The URL request for which the responses are removed.
     */
    @CMSelector("- (void)removeCachedResponseForRequest:(NSURLRequest *)request;")
    public void removeCachedResponseForRequest(NSURLRequest request) {
    }
}
