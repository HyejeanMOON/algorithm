/**
 * Trie, 字典树
 */
public class Trie {
    // 字典树的作用是可以高效的查找是否存有相应的字符串。
    // 虽然能高效的查找，但代价是空间复杂度很大。
    // 每个TrieNode中都有很长的children，其中children还没有值，造成内存浪费。
    // 查找和输入的时间复杂度O(n), n位字符串的长度。
    // -------
    // 
    // 第一，字符串中包含的字符集不能太大。我们前面讲到，如果字符集太大，那存储空间可能就会浪费很多。即便可以优化，但也要付出牺牲查询、插入效率的代价。
    // 第二，要求字符串的前缀重合比较多，不然空间消耗会变大很多。
    // 第三，如果要用 Trie 树解决问题，那我们就要自己从零开始实现一个 Trie 树，还要保证没有 bug，这个在工程上是将简单问题复杂化，除非必须，一般不建议这样做。
    // 第四，我们知道，通过指针串起来的数据块是不连续的，而 Trie 树中用到了指针，所以，对缓存并不友好，性能上会打个折扣。

    TrieNode root = new TrieNode('/');

    public boolean find(char[] word) {
        TrieNode p = root;
        for (char c : word) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEnding;
    }

    public void insert(char[] word) {
        TrieNode p = root;
        for (char c : word) {
            int index = c - 'a';
            if (p.children[index] == null) {
                TrieNode node = new TrieNode(c);
                p.children[index] = node;
            }
            p = p.children[index];
        }
        if (!p.isEnding) p.isEnding = true;
    }

    public class TrieNode {
        char data;
        boolean isEnding = false;
        TrieNode[] children;

        public TrieNode(char data) {
            this.data = data;
            children = new TrieNode[52];
        }
    }
}
