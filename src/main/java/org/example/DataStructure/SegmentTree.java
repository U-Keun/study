package org.example.DataStructure;

public class SegmentTree {
    private final long[] tree;
    private final int height, arrayLength;

    private SegmentTree(long[] arr) {
        arrayLength = arr.length;
        height = (int) Math.ceil(Math.log(arrayLength) / Math.log(2));
        tree = new long[(int) Math.pow(2, height + 1)];
        generate(arr, 1, 0, arr.length - 1);
    }
    public static SegmentTree create(long[] arr) {
        return new SegmentTree(arr);
    }

    public void update(int idx, long diff) {
        internalUpdate(1, 0, arrayLength - 1, idx, diff);
    }

    public long getPrefixSum(int left, int right) {
        return internalPrefixSum(1, 0, arrayLength - 1, left, right);
    }
    public long[] getTree() { return this.tree; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        final int defaultBlank = String.valueOf(tree[1]).length() + 1;
        for (int i = 1; i < height + 1; i++) {
            int size = (int) Math.pow(2, i);
            if (i == 1) {
                sb.append(tree[1]).append(" = ");
            } else sb.append(" ".repeat(defaultBlank)).append("= ");
            for (int j = 0; j < size; j += 2) {
                if (tree[size + j] + tree[size + j + 1] == tree[(size + j) / 2]) {
                    sb.append("(").append(tree[size + j]).append(" + ");
                    sb.append(tree[size + j + 1]).append(")");
                } else sb.append(tree[(size + j) / 2]);
                if (j < size - 2) sb.append(" + ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private void internalUpdate(int current, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) return;
        tree[current] += diff;
        if (start != end) {
            int mid = (start + end) / 2;
            internalUpdate(current * 2, start, mid, idx, diff);
            internalUpdate(current * 2 + 1, mid + 1, end, idx, diff);
        }
    }

    private long internalPrefixSum(int current, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && right >= end) return tree[current];
        int mid = (start + end) / 2;
        return internalPrefixSum(current * 2, start, mid, left, right)
                + internalPrefixSum(current * 2 + 1, mid + 1, end, left, right);
    }

    private long generate(long[] arr, int current, int start, int end) {
        if (start == end) return tree[current] = arr[start];
        int mid = (start + end) / 2;
        return tree[current] = generate(arr, current * 2, start, mid)
                + generate(arr, current * 2 + 1, mid + 1, end);
    }
}
