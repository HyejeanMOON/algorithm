public class BinarySearch {

    public static int binarySearch1(int[] data, int value) {
        // 二分查找， 可用于查找数据中有序且无重复
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);  // int mid = (low+high)/2;
            if (data[mid] > value) {
                high = mid - 1;
            } else if (data[mid] == value) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch2_1(int[] data, int value) {
        // 二分查找， 可用于有序且有重复的数据中查找指定的第一个数
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (data[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low < data.length && data[low] == value) return low;
        return -1;
    }

    public static int binarySearch2_2(int[] data, int value) {
        // 二分查找， 可用于有序且有重复的数据中查找指定的第一个数
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (data[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || data[mid - 1] != value) return mid;
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch3_1(int[] data, int value) {
        // 二分查找， 可用于有序且有重复的数据中查找指定的最后一个数
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (data[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (high > 0 && data[high] == value) return high;

        return -1;
    }

    public static int binarySearch3_2(int[] data, int value) {
        // 二分查找， 可用于有序且有重复的数据中查找指定的最后一个数
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (data[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == data.length - 1 || data[mid + 1] != value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch4_1(int[] data, int value) {
        //　二分查找， 查找第一个大于等于给定值的元素
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (data[mid] >= value) {
                if (mid == 0 || data[mid - 1] < value) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch5_1(int[] data, int value) {
        // 二分查找， 查找最后一个小于等于给定值的元素
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (data[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == data.length - 1 || data[mid + 1] > value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

}
