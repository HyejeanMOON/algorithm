package sort;

import java.util.Arrays;

public class Heap {
    // 堆可以分为大顶堆和小顶堆，每个节点的值都大于其子树中的节点的值，我们称为大顶堆。
    // 堆是一个完全二叉树，且堆中的每一个节点的值必须要大于等于（或者小于等于）其子树中的节点的值。
    // 完全二叉树指的是除了最后一层，其他层的节点的个数都是满的，最后一层节点都靠左排列。
    // 堆排序不是一个稳定的排序方法
    // 堆排序的时间复杂度是O(nlogn),空间复杂度是O(1)
    // 需要注意的是，为了让除于2的操作更加容易，我们存储数据的时候需要从1位置。
    // 加入父节点的位置为i，则它的两个子节点的位置为2*i和2*i+1
    // 建堆即heapify的时间复杂度是O(n)

    int[] list;
    int capacity;
    int count;

    public Heap(int capacity) {
        this.capacity = capacity;
        list = new int[capacity + 1];
        Arrays.fill(list,Integer.MIN_VALUE);
        count = 0;
    }

    public boolean insert(int num) {
        if (count >= capacity) {
            return false; // 堆满了，不能进行添加了
        }
        count++;
        list[count] = num;
        int i = count;
        while (i / 2 > 0 && list[i] > list[i / 2]) {
            swap(i, i / 2);  // 交换i和i/2的数据
            i = i / 2;
        }
        return true;
    }

    public int removeMax(){
        if(count == 0) return Integer.MIN_VALUE;
        int maxInt = list[1];
        list[1] = list[count];
        list[count] = Integer.MIN_VALUE;
        count--;
        heapify(count,1);
        return maxInt;
    }

    public void sort(){
        int k = count;
        while(k>1){
            swap(1,k);
            k--;
            heapify(k,1);
        }
    }

    private void buildHeap() {
        for(int i=count/2; i>=1 ; i--){
            heapify(count,i);
        }
    }

    // 建堆的复杂度是O(n)
    private void heapify(int count,int position) {
        while (true) {
            int maxPos = position;
            if (position * 2 <= count && list[position] < list[position * 2]) maxPos = position * 2;
            if (position * 2 + 1 <= count && list[maxPos] < list[position * 2 + 1]) maxPos = position * 2 + 1;
            if (maxPos == position) break;
            swap(position, maxPos);
            position = maxPos;
        }
    }

    private void swap(int left, int right) {
        int temp = list[left];
        list[left] = list[right];
        list[right] = temp;
    }

    public void print() {
        for (int i = 0; i < capacity; i++) {
            if(list[i]!=Integer.MIN_VALUE){
                System.out.print(list[i] + " ");
            }
        }
    }
}
