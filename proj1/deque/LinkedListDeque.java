package deque;

public class LinkedListDeque<Type> {
    private class stuffNode {
        public stuffNode pre;
        public stuffNode next;
        public Type data;

        public stuffNode(Type data, stuffNode pre, stuffNode next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    private stuffNode headNode = new stuffNode(null, null, null);
    private stuffNode tailNode = new stuffNode(null, null, null);
    private int size = 0;

    /** A method to creat an empty deque. */
    public LinkedListDeque() {
        headNode.next = tailNode;
        tailNode.pre = headNode;
    }

    /** A method to creat a deque with one item. */
    public LinkedListDeque(Type data) {
        headNode.next = new stuffNode(data, headNode, tailNode);
        tailNode.pre = headNode.next;
        size = 1;
    }

    /** A method to add data to the front of the deque. */
    public void addFirst(Type data) {
        stuffNode newNode = new stuffNode(data, headNode, headNode.next);
        headNode.next.pre = newNode;
        headNode.next = newNode;
        size = size + 1;
    }

    /** A method to add data to the end of the deque. */
    public void addLast(Type data) {
        stuffNode newNode = new stuffNode(data, tailNode.pre, tailNode);
        tailNode.pre.next = newNode;
        tailNode.pre = newNode;
        size = size + 1;
    }

    /** A method to judge if the deque is empty. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** A method to get the size of the deque. */
    public int size() {
        return size;
    }

    /** A method to print the deque. */
    public void printDeque() {
        stuffNode current = headNode.next;
        while (current != tailNode) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /** A method to remove the first item of the deque. */
    public Type removeFirst() {
        if (size == 0) {
            return null;
        }
        stuffNode temp = headNode.next;
        headNode.next = temp.next;
        temp.next.pre = headNode;
        size = size - 1;
        return temp.data;
    }

    /** A method to remove the last item of the deque. */
    public Type removeLast() {
        if (size == 0) {
            return null;
        }
        stuffNode temp = tailNode.pre;
        tailNode.pre = temp.pre;
        temp.pre.next = tailNode;
        size = size - 1;
        return temp.data;
    }

    /** A method to get the item at the given index. */
    public Type get(int index) {
        stuffNode current = headNode.next;
        while (index > 0) {
            current = current.next;
            index = index - 1;
        }
        return current.data;
    }

    /** A helper method to get the item at the given index. */
    public Type getRecursive(int index, stuffNode current) {
        if (index == 0) {
            return current.data;
        }
        return getRecursive(index - 1, current.next);
    }

    /** A method to get the item at the given index. */
    public Type getRecursive(int index) {
        return getRecursive(index, headNode.next);
    }

    /** A method to creat a deque with the same items as the given deque. */
    public LinkedListDeque(LinkedListDeque other) {
        stuffNode headNode = new stuffNode(null, null, null);
        stuffNode tailNode = new stuffNode(null, null, null);
        int size = 0;
        headNode.next = tailNode;
        tailNode.pre = headNode;

        for (int i = 0; i < other.size; i += 1) {
            addLast((Type) other.get(i));
        }
    }
}
