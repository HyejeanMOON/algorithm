public class Main {

    public static void main(String[] args) {
        new Main().runTrie();
    }

    public static int[] generateData(int len) {
        int[] data = new int[len];
        for (int i = 0; i < len; i++) {
            data[i] = (int) (Math.random() * len);
        }
        return data;
    }

    public static int[] generateOrderData(int len) {
        int[] data = new int[len];
        for (int i = 0; i < len; i++) {
            data[i] = i / 2;
        }
        return data;
    }

    public static void runBubbleSort(int len) {
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        Sorts.bubbleSort(data);
        for (int i = 0; i < len; i++) {
            System.out.println(data[i]);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static void runInsertionSort(int len) {
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        Sorts.insertionSort(data);

        for (int i = 0; i < len; i++) {
            System.out.println(data[i]);
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static void runSelectionSort(int len) {
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        Sorts.selectionSort(data);

        for (int i = 0; i < len; i++) {
            System.out.println(data[i]);
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static void runMergeSort(int len) {
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        Sorts.mergeSort(data, 0, len - 1);

        for (int i = 0; i < len; i++) {
            System.out.println(data[i]);
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static void runQuickSort(int len) {
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        Sorts.quickSort(data);

        for (int i = 0; i < len; i++) {
            System.out.println(data[i]);
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static int runKthSmallest(int len) {
        int[] data = generateData(len);

        Long startTime = System.currentTimeMillis();
        int result = KthSmallest.KthSmallest(data, 100);

        System.out.println(System.currentTimeMillis() - startTime);

        return result;
    }

    public void runBinarySearchTree() {
        BinarySearchTree bst = new BinarySearchTree(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(5);
        bst.insert(25);
        bst.insert(6);
        bst.insert(23);
        bst.insert(27);

        System.out.println("preOrderSearch");
        System.out.println("-------------");
        bst.preOrderSearch();

        System.out.println("");
        System.out.println("");
        System.out.println("inOrderSearch");
        System.out.println("-------------");
        bst.inOrderSearch();

        System.out.println("");
        System.out.println("");
        System.out.println("postOrderSearch");
        System.out.println("-------------");
        bst.postOrderSearch();

        System.out.println("");
        System.out.println("");
        System.out.println("search");
        System.out.println("-------------");
        System.out.println(bst.search(23));

        System.out.println("");
        System.out.println("");
        System.out.println("max value");
        System.out.println("-------------");
        System.out.println(bst.maxValue().value);

        System.out.println("");
        System.out.println("");
        System.out.println("min value");
        System.out.println("-------------");
        System.out.println(bst.minValue().value);

        System.out.println("");
        System.out.println("");
        System.out.println("delete");
        System.out.println("-------------");
        System.out.println(bst.delete(10));
        bst.inOrderSearch();
        System.out.println("");
        System.out.println(bst.delete(25));
        bst.inOrderSearch();
    }

    public void runTrie() {
        Trie trie = new Trie();
        trie.insert("hello".toCharArray());
        trie.insert("world".toCharArray());

        System.out.println("find <hello> :"+trie.find("hello".toCharArray()));
        System.out.println("find <worl> :"+ trie.find("worl".toCharArray()));
    }
}
