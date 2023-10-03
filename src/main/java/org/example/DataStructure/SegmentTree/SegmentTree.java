package org.example.DataStructure.SegmentTree;

public interface SegmentTree {
    Object[] getTree();
    void update(int idx, Object diff);
    Object getIntervalValue(int left, int right);
}
