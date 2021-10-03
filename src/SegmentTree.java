public class SegmentTree {
    // 线段树
    // 线段树本质上是二叉树，但不同的是每个节点存放的是单纯的元素，而是存放一个可以表示区间的值。
    // 除了区间以外还可以存放最大值，最小值，区间和。
    // 我们在更新一个节点的值的同时，还有更改其母节点的值。

    int[] list;
    SegmentTreeNode root;

    public SegmentTree(int[] list) {
        this.list = list;
        root = buildTree(0, list.length - 1);
    }

    // 创建线段树
    private SegmentTreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(
                start,
                end,
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                0);

        if (start != end) {
            int mid = (start + end) / 2;
            root.left = buildTree(start, mid);
            root.right = buildTree(mid + 1, end);
            root.max = Math.max(root.left.max, root.right.max);
            root.min = Math.min(root.left.min, root.right.min);
            root.sum = root.left.sum + root.right.sum;
        } else {
            root.max = list[start];
            root.min = list[start];
            root.sum = list[start];
        }
        return root;
    }

    // 区间中的最小值
    public int getMin(int start, int end) {
        return getMin(root, start, end);
    }

    private int getMin(SegmentTreeNode node, int start, int end) {
        if (start == node.start && end == node.end) {
            return node.min;
        }

        int mid = (node.start + node.end) / 2;
        int leftMin = Integer.MAX_VALUE, rightMin = Integer.MAX_VALUE;

        // left
        if (start <= mid) {
            if (mid < end) {
                leftMin = getMin(node.left, start, mid);
            } else {
                leftMin = getMin(node.left, start, end);
            }
        }

        // right
        if (mid < end) {
            if (start <= mid) {
                rightMin = getMin(node.right, mid + 1, end);
            } else {
                rightMin = getMin(node.right, start, end);
            }
        }

        return Math.min(leftMin, rightMin);
    }

    // 区间中的最大值
    public int getMax(int start, int end) {
        return getMax(root, start, end);
    }

    private int getMax(SegmentTreeNode node, int start, int end) {
        if (start == node.start && end == node.end) {
            return node.max;
        }

        int mid = (node.start + node.end) / 2;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;

        // left
        if (start <= mid) {
            if (mid < end) {
                leftMax = getMax(node.left, start, mid);
            } else {
                leftMax = getMax(node.left, start, end);
            }
        }

        // right
        if (mid < end) {
            if (start <= mid) {
                rightMax = getMax(node.right, mid + 1, end);
            } else {
                rightMax = getMax(node.right, start, end);
            }
        }

        return Math.max(leftMax, rightMax);
    }

    // 区间和
    public int getSum(int start, int end) {
        if (start < 0 || end >= list.length) throw new IllegalArgumentException();
        return getSum(root, start, end);
    }

    private int getSum(SegmentTreeNode node, int start, int end) {
        if (start == node.start && end == node.end) {
            return node.sum;
        }

        int mid = (node.start + node.end) / 2;
        int leftSum = 0, rightSum = 0;

        // left
        if (start <= mid) {
            if (mid < end) {
                leftSum = getSum(node.left, start, mid);
            } else {
                leftSum = getSum(node.left, start, end);
            }
        }

        // right
        if (mid < end) {
            if (start <= mid) {
                rightSum = getSum(node.right, mid + 1, end);
            } else {
                rightSum = getSum(node.right, start, end);
            }
        }

        return leftSum + rightSum;
    }

    public void updateMin(int index, int value) {
        updateMin(root, index, value);
    }

    private void updateMin(SegmentTreeNode node, int index, int value) {
        if (node.start == index && node.end == index) {
            node.min = value;
            return;
        }

        int mid = (node.start + node.end) / 2;
        if (node.start <= index && index <= mid) {
            updateMin(node.left, index, value);
        }

        if (mid < index && index <= node.end) {
            updateMin(node.right, index, value);
        }

        node.min = Math.min(node.left.min, node.right.min);
    }

    public void updateMax(int index, int value) {
        updateMax(root, index, value);
    }

    private void updateMax(SegmentTreeNode node, int index, int value) {
        if (node.start == index && node.end == index) {
            node.max = value;
            return;
        }

        int mid = (node.start + node.end) / 2;
        if (node.start <= index && index <= mid) {
            updateMax(node.left, index, value);
        }

        if (mid < index && index <= node.end) {
            updateMax(node.right, index, value);
        }

        node.max = Math.max(node.left.min, node.right.min);
    }

    public void updateSum(int index, int value) {
        updateSum(root, index, value);
    }

    private void updateSum(SegmentTreeNode node, int index, int value) {
        if (node.start == index && node.end == index) {
            node.sum = value;
            return;
        }

        int mid = (node.start + node.end) / 2;
        if (node.start <= index && index <= mid) {
            updateSum(node.left, index, value);
        }

        if (mid < index && index <= node.end) {
            updateSum(node.right, index, value);
        }

        node.sum = node.left.sum + node.right.sum;
    }

    static class SegmentTreeNode {
        int start, end;
        int min, max, sum;
        SegmentTreeNode left = null;
        SegmentTreeNode right = null;

        public SegmentTreeNode(
                int start,
                int end,
                int max,
                int min,
                int sum
        ) {
            this.start = start;
            this.end = end;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
}
