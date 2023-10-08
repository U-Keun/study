package org.example.DataStructure.SegmentTree;

public class PrefixSumSegmentTree extends AbstractSegmentTree {
    private PrefixSumSegmentTree(Object[] arr) { super(arr); }
    public static PrefixSumSegmentTree create(Long[] arr) { return new PrefixSumSegmentTree(arr); }

    @Override
    Long generate(Object[] arr, int current, int start, int end) {
        if (start == end) return (Long) (this.tree[current] = arr[start]);
        int mid = (start + end) / 2;
        return (Long) (this.tree[current] = generate(arr, current * 2, start, mid) +
                generate(arr, current * 2 + 1, mid + 1, end));
    }

    @Override
    void internalUpdate(int current, int start, int end, int idx, Object diff) {
        if (idx < start || idx > end) return;
        this.tree[current] = (Long) this.tree[current] + (Long) diff;
        if (start != end) {
            int mid = (start + end) / 2;
            internalUpdate(current * 2, start, mid, idx, diff);
            internalUpdate(current * 2 + 1, mid + 1, end, idx, diff);
        }
    }

    @Override
    Long internalIntervalValue(int current, int start, int end, int left, int right) {
        if (left > end || right < start) return 0L;
        if (left <= start && right >= end) return (Long) this.tree[current];
        int mid = (start + end) / 2;
        return internalIntervalValue(current * 2, start, mid, left, right) +
                internalIntervalValue(current * 2 + 1, mid + 1, end, left, right);
    }

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
                if (tree[size + j] != null) {
                    sb.append("(").append(tree[size + j]).append(" + ");
                    sb.append(tree[size + j + 1]).append(")");
                } else sb.append(tree[(size + j) / 2]);
                if (j < size - 2) sb.append(" + ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
