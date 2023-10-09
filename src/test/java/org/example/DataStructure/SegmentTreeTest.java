package org.example.DataStructure;

import org.example.DataStructure.SegmentTree.MinimumSegmentTree;
import org.example.DataStructure.SegmentTree.PrefixSumSegmentTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SegmentTreeTest {
    private Long[] test = new Long[]{3L, 1L, 2L, 5L, 4L};
    private PrefixSumSegmentTree prefixSumInstance = PrefixSumSegmentTree.create(test);
    private MinimumSegmentTree minimumInstance = MinimumSegmentTree.create(test);
    @Test
    void getPrefixSum() {
        System.out.println(prefixSumInstance);
        Long test = (Long) prefixSumInstance.getIntervalValue(1, 3);

        assertEquals(test, 8);
    }
    @Test
    void updatePrefixSum() {
        prefixSumInstance.update(1, 9L);
        System.out.println(prefixSumInstance);
        Long test = (Long) prefixSumInstance.getIntervalValue(1, 1);

        assertEquals(test, 10);
    }
    @Test
    void getMinimum() {
        Long test = (Long) minimumInstance.getIntervalValue(2, 4);

        assertEquals(test, 2);
    }
}