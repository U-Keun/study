package org.example.DataStructure.SegmentTree;

public abstract class AbstractSegmentTree implements SegmentTree {
    private final Object[] tree;
    private final int height, arrayLength;

    private AbstractSegmentTree(Object[] arr) {
        arrayLength = arr.length;
        height = (int) Math.ceil(Math.log(arrayLength) / Math.log(2));
        tree = new Object[(int) Math.pow(2, height + 1)];
        generate(arr, 1, 0, arrayLength - 1);
    }
    public Object[] getTree() { return tree; }
    public void update(int idx, Object diff) {
        internalUpdate(1, 0, arrayLength - 1, idx, diff);
    }
    public Object getIntervalValue(int left, int right) {
        return internalIntervalValue(1, 0, arrayLength - 1, left, right);
    }
    abstract Object generate(Object[] arr, int current, int start, int end);
    abstract void internalUpdate(int current, int start, int end, int idx, Object diff);
    abstract Object internalIntervalValue(int current, int start, int end, int left, int right);
}
