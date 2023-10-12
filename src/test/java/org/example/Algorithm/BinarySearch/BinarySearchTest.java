package org.example.Algorithm.BinarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void binarySearchPeak() {
        int[] arr = {1, 2, 4, 6, 3, 2};
        int peak = BinarySearch.binarySearchPeak(arr);

        assertEquals(peak, 3);
    }

    @Test
    void binarySearchUpperBound() {
        int[] arr = {1, 2, 2, 3, 4, 5};
        int idx = BinarySearch.binarySearchUpperBound(arr, 2);

        assertEquals(idx, 3);
    }

    @Test
    void binarySearchLowerBound() {
        int[] arr = {1, 2, 2, 3, 4, 5};
        int idx = BinarySearch.binarySearchLowerBound(arr, 2);

        assertEquals(idx, 1);
    }
}