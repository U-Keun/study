package org.example.DataStructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SegmentTreeTest {
    private long[] test = new long[]{3, 1, 2, 5, 4};
    private SegmentTree instance = SegmentTree.create(test);
    @Test
    void getPrefixSum() {
        long test = instance.getPrefixSum(1, 3);

        assertEquals(test, 8);
    }
    @Test
    void update() {
        instance.update(1, 9);
        long test = instance.getPrefixSum(1, 1);
        assertEquals(test, 10);
    }
}