import graph.DirectedWeightedAdjacencyList;
import graph.DirectedWeightedAdjacencyMatrix;

public class Main {

    public static void main(String[] args) {
        testPascalsTriangle();
    }

    public static void testPascalsTriangle(){
        PascalsTriangle triangle = new PascalsTriangle(10);
        triangle.print();
        System.out.println(triangle.levelSum(9));
        System.out.println(triangle.possibility(4,1));
    }

    public static void testSegmentTree(){
        int[] list = new int[]{1,3,5,2,4,7,6};
        SegmentTree tree  = new SegmentTree(list);
        tree.updateMin(1,1);
        System.out.println(tree.getMin(1,5));
    }

    public static void testHeap(){
        Heap heap = new Heap(10);
        heap.insert(1);
        heap.insert(3);
        heap.insert(5);
        heap.insert(2);
        heap.insert(7);
        heap.insert(9);
        heap.sort();
        heap.print();
    }

    public static void testDirectedWeightedAdjacencyMatrix(){
        DirectedWeightedAdjacencyMatrix matrix = new DirectedWeightedAdjacencyMatrix(5);
        matrix.add(0,1,2);
        matrix.add(1,2,1);
        matrix.add(1,4,3);
        matrix.add(1,3,1);
        matrix.add(2,4,1);
        matrix.add(4,3,4);
        matrix.add(3,0,5);
        System.out.println(matrix.hasCircleConnection());
        matrix.getDistanceFromOneNodeToAllNode(1);
    }

    public static void testDirectedWeightedAdjacencyList(){
        DirectedWeightedAdjacencyList graphList = new DirectedWeightedAdjacencyList(5);
        graphList.add(0,1,2);
        graphList.add(1,2,1);
        graphList.add(2,4,3);
        graphList.add(4,3,4);
        graphList.add(3,0,5);
        System.out.println(graphList.hasConnectionBetweenTwoNode(0,2));
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
