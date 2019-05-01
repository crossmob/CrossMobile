package org.robovm.objc.block;

/**
 * Block which takes a single {@code boolean} argument and returns no value.
 * This is used to map the Objective-C {@code void (^)(BOOL)} block type.
 */
public interface VoidBooleanBlock {

    /**
     * Runs this block.
     *
     * @param v the block argument.
     */
    void invoke(boolean v);
}