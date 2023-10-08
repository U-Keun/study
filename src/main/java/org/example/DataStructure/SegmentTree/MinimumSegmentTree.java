package org.example.DataStructure.SegmentTree;

public class MinimumSegmentTree extends AbstractSegmentTree {
    private Long[] originalArray;
    private MinimumSegmentTree(Object[] arr) {
        super(arr);
        this.originalArray = (Long[]) arr;
    }
    public static MinimumSegmentTree create(Long[] arr) { return new MinimumSegmentTree(arr); }

    @Override
    Long generate(Object[] arr, int current, int start, int end) {
        if (start == end) return (Long) (this.tree[current] = arr[start]);
        int mid = (start + end) / 2;
        return (Long) (this.tree[current] = Math.min(generate(arr, current * 2, start, mid),
                generate(arr, current * 2 + 1, mid + 1, end)));
    }

    @Override
    void internalUpdate(int current, int start, int end, int idx, Object diff) {
        
    }

    @Override
    Long internalIntervalValue(int current, int start, int end, int left, int right) {
        if (left > end || right < start) return Long.MAX_VALUE;
        if (left <= start && right >= end) return (Long) this.tree[current];
        int mid = (start + end) / 2;
        return Math.min(internalIntervalValue(current * 2 , start, mid, left, right),
                internalIntervalValue(current * 2 + 1, mid + 1, end, left, right));
    }
}
