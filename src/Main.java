public class Main {

    public static void main(String[] args){
        LruCache lru = new LruCache(3);

        lru.put(1,"beijing");
        lru.put(2,"shanghai");
        lru.put(3,"tianjin");
        lru.put(4,"chongqing");
        lru.put(5,"shenzhen");

        lru.put(3,"china");

        lru.print();
        lru.printLastNode();
    }

    public static int[] generateData(int len){
        int[] data = new int[len];
        for(int i=0; i<len; i++){
            data[i] = (int)(Math.random()*len);
        }
        return data;
    }

    public static int[] generateOrderData(int len){
        int[] data = new int[len];
        for(int i=0; i<len; i++){
            data[i] = i/2;
        }
        return data;
    }

    public static void runBubbleSort(int len){
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        Sorts.bubbleSort(data);
        for(int i=0 ; i<len;i++){
            System.out.println(data[i]);
        }
        System.out.println(System.currentTimeMillis()-startTime);
    }

    public static void runInsertionSort(int len){
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        Sorts.insertionSort(data);

        for(int i=0 ; i<len;i++){
            System.out.println(data[i]);
        }

        System.out.println(System.currentTimeMillis()-startTime);
    }

    public static void runSelectionSort(int len){
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        Sorts.selectionSort(data);

        for(int i=0 ; i<len;i++){
            System.out.println(data[i]);
        }

        System.out.println(System.currentTimeMillis()-startTime);
    }

    public static void runMergeSort(int len){
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        Sorts.mergeSort(data,0,len-1);

        for(int i=0 ; i<len;i++){
            System.out.println(data[i]);
        }

        System.out.println(System.currentTimeMillis()-startTime);
    }

    public static void runQuickSort(int len){
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        Sorts.quickSort(data);

        for(int i=0 ; i<len;i++){
            System.out.println(data[i]);
        }

        System.out.println(System.currentTimeMillis()-startTime);
    }

    public static int runKthSmallest(int len){
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        int result = KthSmallest.KthSmallest(data, 100);

        System.out.println(System.currentTimeMillis()-startTime);

        return result;
    }
}
