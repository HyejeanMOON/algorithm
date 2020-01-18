public class Sorts {
    // 冒泡排序
    // 冒泡排序是稳定的原地排序， 主要思想是两个相邻的数字进行比较交换
    // 时间复杂度:O(n^2), 空间复杂度：O(1)
    public static void bubbleSort(int[] data){

        if(data.length<=1) return ;

        for(int i=0; i<data.length; i++){
            boolean flag = false;
            for(int j=0; j<data.length-i-1; j++){
                if(data[j]>data[j+1]){
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }

    // 插入排序
    // 插入排序是稳定的原地排序， 主要的思想是选取第一个数字为基准点，按大小往基准有序区进行插入
    // 时间复杂度：O(n^2), 空间复杂度：O(1)
    public static void insertionSort(int[] data){

        if(data.length<=1) return;

        for(int i=1; i<data.length; i++){
            int value = data[i];

            int j= i-1;

            for( ; j>=0; j--){
                if(data[j]>value){
                    data[j+1] =data[j];
                }else break;
            }
            data[j+1] = value;
        }
    }

    // 选择排序
    // 选择排序是不稳定的原地排序， 主要思想是查找为排序区中的最小值进行交换
    // 时间复杂度：O(n^2), 空间复杂度：O(1)
    public static void selectionSort(int[] data){

        if(data.length <=1) return;

        for(int i=0; i<data.length-1 ;i++){
            int minIndex = i;

            for(int j=i+1 ; j<data.length; j++){
                if(data[minIndex] > data[j]){
                    minIndex = j;
                }
            }
            int tmp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = tmp;
        }
    }
}
