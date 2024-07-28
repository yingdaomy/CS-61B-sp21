package SLList;

public class SSList {

    private class StuffNode {
        public int item;
        public StuffNode next;

        public StuffNode(int i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    private final StuffNode sentinel = new StuffNode(63, null);
    private int size = 0;
    private StuffNode Last = sentinel;

    /**
     * Adds x to the front of the list.
     */
    public void addFirst(int x) {
        sentinel.next = new StuffNode(x, sentinel.next);
        size += 1;

    }

    /**
     * Get the first items
     */
    public int getFirst() {
        return sentinel.next.item;
    }

    /**
     * Get the items of ith
     */
    public int get(int i) {
        StuffNode P = sentinel.next;
        while (i > 0) {
            P = P.next;
            i -= 1;
        }
        return P.item;
    }

    /**
     * A helper method to ge the size of the list
     */
    private int size(StuffNode P) {
        if (P.next == null) {
            return 1;
        }
        return 1 + size(P.next);
    }

    /**
     * Get the size of the list
     */
    public int size() {
//        IntNode P = sentinel.next;
//        int totalSize = 0;
//        while (P != null) {
//            totalSize += 1;
//            P = P.next;
//        }
//        return totalSize;

//        return size(sentinel.next);

        return size;
    }

    /**
     * Add x to the end of the list
     */
    public void addLast(int x) {
//        IntNode P = sentinel;
//        while (P.next != null) {
//            P = P.next;
//        }
//        P.next = new IntNode(x, null);
//        size += 1;
//        Last = P.next;

        Last.next = new StuffNode(x, null);
        Last = Last.next;
        size += 1;
    }


    /**
     * Create a list with one element
     */
    public SSList(int x) {
        sentinel.next = new StuffNode(x, null);
        size += 1;
        Last = sentinel.next;
    }

    /**
     * Create an empty list
     */
    public SSList() {
        sentinel.next = null;
        size = 0;
    }
}

