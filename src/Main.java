public class Main {

    public static void main(String[] args){
        int len = 50000;

        runBubbleSort(len);
        runInsertionSort(len);
        runSelectionSort(len);

    }

    public static int[] generateData(int len){
        int[] data = new int[len];
        for(int i=0; i<len; i++){
            data[i] = (int)(Math.random()*len);
        }
        return data;
    }

    public static void runBubbleSort(int len){
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        Sorts.bubbleSort(data);
        System.out.println(System.currentTimeMillis()-startTime);
    }

    public static void runInsertionSort(int len){
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        Sorts.insertionSort(data);

        System.out.println(System.currentTimeMillis()-startTime);
    }

    public static void runSelectionSort(int len){
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        Sorts.selectionSort(data);

        System.out.println(System.currentTimeMillis()-startTime);
    }
}
