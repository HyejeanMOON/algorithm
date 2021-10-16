package two_pointer;

// 在LinkedList等的数据结构中双指针的应用
public class TwoPointerForLinkedNode {
    LinkedNode head;

    public TwoPointerForLinkedNode(LinkedNode linkedNode) {
        this.head = linkedNode;
    }

    // 找出LinkedNode中是否有环
    public boolean hasCycle() {
        LinkedNode fast = head, slow = head;
        // 我们需要一快指针一慢指针
        // 快指针的速度是慢指针的两倍
        // 当快指针到底了，说明LinkedNode中没有环
        // 如果快指针和慢指针相遇了，说明LinkedNode中有环
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }

        return false;
    }

    // 找出倒数第K位的节点
    // 该算法的前提是LinkedNode中没有环
    public LinkedNode findOutLastKthNode(int k) {
        if (k < 0) throw new IllegalArgumentException();
        LinkedNode fast = head, slow = head;

        while (k < 0) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                // 如果等于null说明该LinkedNode本身就没有k长，所以要返回null
                return null;
            }
            k--;
        }

        // fast指针和slow指针要以同样的速度走到尾
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // fast走到尾了，因为slow和fast的距离是k，所以slow指针指向的就是倒数第k位
        return slow;
    }

    // 找出Linked中的中点
    public LinkedNode getMiddlePoint() {
        LinkedNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    // 找出环的起点
    public LinkedNode detectCycle(){
        LinkedNode fast = head, slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) break;
        }

        // 说明该LinkedNode中没有环
        if(fast.next == null || fast.next.next == null){
            return null;
        }

        slow = head;

        // 这一部分比较难理解
        // https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E5%8F%8C%E6%8C%87%E9%92%88%E6%8A%80%E5%B7%A7.md
        // 假设相遇点里环起始点的距离位m，快指针走了2k距离，慢指针走了k距离。
        // 所以从head到环起始点距离位k-m，但同时fast指针到环起始的距离也是k-m。
        // head到相遇的位置是k，环本身的长度也是k，理解了这一点就能很快的理解上一段句子的意思了。
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}

class LinkedNode {
    int value;
    LinkedNode next;

    LinkedNode(int value) {
        this.value = value;
        this.next = null;
    }

    LinkedNode(int value, LinkedNode next) {
        this.value = value;
        this.next = next;
    }
}
