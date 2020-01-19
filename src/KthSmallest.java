public class KthSmallest {

    public static int KthSmallest(int[] data, int k) {
        if (data == null || data.length < k) {
            return -1;
        }

        int partition = partition(data, 0, data.length - 1);
        while (partition + 1 != k) {
            if (partition + 1 < k) {
                partition = partition(data, partition + 1, data.length - 1);
            } else {
                partition = partition(data, 0, partition - 1);
            }
        }
        return data[partition];
    }

    public static int partition(int[] data, int p, int r) {
        int pivot = data[r];
        int i = p;

        for (int j = p; j < r; j++) {
            if (data[j] <= pivot) {
                // 这里要是 <= ，不然会出现死循环，比如查找数组 [1,1,2] 的第二小的元素
                swap(data, i, j);
                i++;
            }
        }
        swap(data, i, r);

        return i;
    }

    public static void swap(int[] data, int left, int right) {
        if (left == right) return;

        int tmp = data[left];
        data[left] = data[right];
        data[right] = tmp;
    }
}
