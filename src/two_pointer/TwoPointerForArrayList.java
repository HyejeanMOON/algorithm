package two_pointer;

public class TwoPointerForArrayList {
    // 双指针方法在数组中的应用

    // 两数之和
    // list中的数字是从低到高排列的好的数组，我们要返回两个index，
    // 要使index中的和为target
    // 答案只有一个，或者没有
    public int[] twoSum(int[] list, int target) {
        int left = 0, right = list.length - 1;

        while (left < right) {
            int sum = list[left] + list[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }

    // 反转数组的顺序
    public int[] reverseList(int[] list) {
        int left = 0, right = list.length - 1;

        while (left < right) {
            int temp = list[left];
            list[left] = list[right];
            list[right] = temp;
            left++;
            right--;
        }
        return list;
    }

    // 二分查找
    // 返回的是index
    public int binarySearch(int[] list, int target) {
        int left = 0, right = list.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list[mid] == target) {
                return mid;
            } else if (list[mid] < target) {
                left = mid + 1;
            } else if (list[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
