public class BinarySearchTree {
    // 二叉搜索树

    private Node root;

    class Node {
        int value;
        Node leftNode;
        Node rightNode;

        public Node(int value) {
            this.value = value;
            leftNode = null;
            rightNode = null;
        }
    }

    public BinarySearchTree(int value) {
        this.root = new Node(value);
    }

    public void preOrderSearch() {
        preOrderSearch(root);
    }

    public void preOrderSearch(Node node) {
        // 前序遍历， 遍历顺序：根节点，左节点，右节点
        System.out.println(node.value);
        if (node.leftNode != null) {
            preOrderSearch(node.leftNode);
        }
        if (node.rightNode != null) {
            preOrderSearch(node.rightNode);
        }
    }

    public void inOrderSearch() {
        inOrderSearch(root);
    }

    public void inOrderSearch(Node node) {
        // 中序遍历， 遍历顺序：左节点，根节点，右节点
        if (node.leftNode != null) {
            inOrderSearch(node.leftNode);
        }
        System.out.println(node.value);
        if (node.rightNode != null) {
            inOrderSearch(node.rightNode);
        }
    }

    public void postOrderSearch() {
        postOrderSearch(root);
    }

    public void postOrderSearch(Node node) {
        // 后序遍历， 遍历顺序：左节点，右节点，根节点
        if (node.leftNode != null) {
            inOrderSearch(node.leftNode);
        }
        if (node.rightNode != null) {
            inOrderSearch(node.rightNode);
        }
        System.out.println(node.value);
    }

    public boolean insert(int value) {
        return insert(root, value);
    }

    public boolean insert(Node node, int value) {
        if (value == node.value) return false;

        if (node.value > value) {
            if (node.leftNode != null) {
                insert(node.leftNode, value);
            } else {
                Node newNode = new Node(value);
                node.leftNode = newNode;
            }
        } else {
            if (node.rightNode != null) {
                insert(node.rightNode, value);
            } else {
                Node newNode = new Node(value);
                node.rightNode = newNode;
            }
        }
        return true;
    }

    public Node minValue() {
        return minValue(root);
    }

    public Node minValue(Node node) {
        // 查找二叉查找树中的最小值，即最左边的节点
        if (node == null) return null;

        if (node.leftNode == null) {
            return node;
        }
        return minValue(node.leftNode);
    }

    public Node maxValue() {
        return maxValue(root);
    }

    public Node maxValue(Node node) {
        // 查找二叉查找树中的最大值，即最右边的节点
        if (node == null) return null;

        if (node.rightNode == null) {
            return node;
        }
        return maxValue(node.rightNode);
    }

    public boolean search(int value) {
        return search(root, value);
    }

    public boolean search(Node node, int value) {
        if (node == null) return false;

        if (node.value > value) return search(node.leftNode, value);
        else if (node.value < value) return search(node.rightNode, value);

        return true; // 相同的情况返回true
    }

    public boolean delete(int value) {
        return delete(null, root, value);
    }

    public boolean delete(Node parent, Node node, int value) {
        // 删除节点的操作根据要删除节点的位置的不同分为三种情况
        // 要删除节点没有任何子节点： 直接删除该节点
        // 要删除节点有一个子节点： 把子节点顶替到要删除节点的位置
        // 要删除节点有两个子节点： 把右子树中最左节点替换到要删除节点的位置

        if (node == null) return false;

        if (node.value != value) {
            if (node.value > value) {
                return delete(node, node.leftNode, value);
            } else {
                return delete(node, node.rightNode, value);
            }
        } else {
            if (node.leftNode == null && node.rightNode == null) {
                if(node==root){
                    // 如果删除节点是根节点，且没有左右子节点，则直接把root设为null
                    root = null;
                    return true;
                }
                boolean isParentLeftNode = parent.value > node.value;
                // 没有左右子节点
                if (isParentLeftNode) {
                    parent.leftNode = null;
                } else {
                    parent.rightNode = null;
                }
                node = null;
            } else if (node.leftNode != null && node.rightNode != null) {
                // 有左右两个节点
                // 查找右子树中的最左节点，进行替换
                Node minNode = node.rightNode;
                Node minNodeParent = null;
                if(minNode.leftNode==null){
                    // 如果要删除节点的右节点没有左子树，则把右节点直接替换到要删除的节点上
                    node.value = node.rightNode.value;
                    node.rightNode = null;
                }else{
                    // 如果要删除节点的右节点有左子树，则找其最小值
                    while(minNode.leftNode !=null){
                        minNodeParent = minNode;
                        minNode = minNode.leftNode;
                    }
                    // 把刚才查找到的值赋值到要删除的节点上
                    node.value = minNode.value;
                    // 删除刚才查找的节点
                    minNode = null;
                    minNodeParent.leftNode = null;
                }
            } else {
                boolean isParentLeftNode = parent.value > node.value;
                // 有左右节点中的其中一个
                if (node.leftNode != null) {
                    // 存在左节点
                    if (isParentLeftNode) {
                        parent.leftNode = node.leftNode;
                    } else {
                        parent.rightNode = node.leftNode;
                    }
                } else {
                    // 存在右节点
                    if (isParentLeftNode) {
                        parent.leftNode = node.rightNode;
                    } else {
                        parent.rightNode = node.rightNode;
                    }
                }
                node = null;
            }
        }
        return true;
    }
}
