package SegmentTrees.Basic;

public class SegmentTree {
    static int[] tree;
    static int[] lazy;
    static int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        lazy = new int[4 * n];
        build(nums, 0, 0, n - 1);
    }

    static void build(int[] nums, int idx, int start, int end) {
        if (start == end) {
            tree[idx] = nums[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(nums, 2 * idx + 1, start, mid);
        build(nums, 2 * idx + 2, mid + 1, end);

        tree[idx] = Math.min(tree[2 * idx + 1], tree[2 * idx + 2]);
    }

    // 🔹 RANGE QUERY (with lazy propagation)
    static int query(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    static int query(int idx, int start, int end, int l, int r) {

        // Apply pending updates
        if (lazy[idx] != 0) {
            tree[idx] += lazy[idx];

            if (start != end) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }

            lazy[idx] = 0;
        }

        // No overlap
        if (r < start || end < l) return Integer.MAX_VALUE;

        // Complete overlap
        if (l <= start && end <= r) return tree[idx];

        int mid = start + (end - start) / 2;

        int leftMin = query(2 * idx + 1, start, mid, l, r);
        int rightMin = query(2 * idx + 2, mid + 1, end, l, r);

        return Math.min(leftMin, rightMin);
    }

    // 🔹 POINT UPDATE (same as before)
    static void pointUpdate(int index, int value) {
        pointUpdate(0, 0, n - 1, index, value);
    }

    static void pointUpdate(int idx, int start, int end, int pos, int val) {

        if (start == end) {
            tree[idx] = val;
            return;
        }

        int mid = start + (end - start) / 2;

        if (pos <= mid) {
            pointUpdate(2 * idx + 1, start, mid, pos, val);
        } else {
            pointUpdate(2 * idx + 2, mid + 1, end, pos, val);
        }

        tree[idx] = Math.min(tree[2 * idx + 1], tree[2 * idx + 2]);
    }

    // 🔥 RANGE UPDATE (Lazy Propagation)
    static void rangeUpdate(int l, int r, int val) {
        rangeUpdate(0, 0, n - 1, l, r, val);
    }

    static void rangeUpdate(int idx, int start, int end, int l, int r, int val) {

        // Apply pending updates
        if (lazy[idx] != 0) {
            tree[idx] += lazy[idx];

            if (start != end) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }

            lazy[idx] = 0;
        }

        // No overlap
        if (r < start || end < l) return;

        // Complete overlap
        if (l <= start && end <= r) {
            tree[idx] += val;

            if (start != end) {
                lazy[2 * idx + 1] += val;
                lazy[2 * idx + 2] += val;
            }
            return;
        }

        int mid = start + (end - start) / 2;

        rangeUpdate(2 * idx + 1, start, mid, l, r, val);
        rangeUpdate(2 * idx + 2, mid + 1, end, l, r, val);

        tree[idx] = Math.min(tree[2 * idx + 1], tree[2 * idx + 2]);
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 1, 6, 3, 7};
        new SegmentTree(nums);

        System.out.println("Min [1,5]: " + query(1, 5));

        pointUpdate(3, 9);
        System.out.println("After point update: " + query(1, 5));

        rangeUpdate(1, 4, 3);
        System.out.println("After range update (+3): " + query(1, 5));
    }
}