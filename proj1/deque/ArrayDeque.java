package deque;

public class ArrayDeque<Type> {
    Type[] ArrayDeque = (Type[]) new Object[100];
    static int size;

    /** A method to creat an empty deque. */
    public ArrayDeque() {
        size = 0;
    }

    /** A method to creat a deque with one item. */
    public ArrayDeque(Type data) {
        ArrayDeque[0] = data;
        size = 1;
    }

    /** A method to resize the deque. */
    public Type[] resize(int newSize) {
        Type[] newArray = (Type[]) new Object[newSize];
        System.arraycopy(ArrayDeque, 0, newArray, 0, size);
        ArrayDeque = newArray;
        return ArrayDeque;
    }

    /** A method to add data to the front of the deque. */
    public void addFirst(Type data) {
//        if (size + 1 == ArrayDeque.length) {
//            Type[] newArray = (Type[]) new Object[ArrayDeque.length * 2];
//            newArray[0] = data;
//            System.arraycopy(ArrayDeque, 0, newArray, 1, size);
//            size = size + 1;
//            ArrayDeque = newArray;
//        } else {
//            Type[] newArray =(Type[]) new Object[ArrayDeque.length];
//            newArray[0] = data;
//            System.arraycopy(ArrayDeque, 0, newArray, 1, size);
//            size = size + 1;
//            ArrayDeque = newArray;
//        }
        Type[] newArray =(Type[]) new Object[ArrayDeque.length];
        newArray[0] = data;
        System.arraycopy(ArrayDeque, 0, newArray, 1, size);
        size = size + 1;
        ArrayDeque = newArray;
        if ((double) ( size / ArrayDeque.length ) > 0.75) {
            ArrayDeque = resize(ArrayDeque.length * 2);
        }
    }

    /** A method to add data to the end of the deque. */
    public void addLast(Type data) {
//        if (size + 1 == ArrayDeque.length) {
//            Type[] newArray = (Type[]) new Object[ArrayDeque.length * 2];
//            System.arraycopy(ArrayDeque, 0, newArray, 0, size);
//            newArray[size] = data;
//            size = size + 1;
//            ArrayDeque = newArray;
//        } else {
//            ArrayDeque[size] = data;
//        }
        ArrayDeque[size] = data;
        size = size + 1;
        if ((double) ( size / ArrayDeque.length ) > 0.75) {
            ArrayDeque = resize(ArrayDeque.length * 2);
        }
    }

    /** A method to judge if the deque is empty. */
    public static boolean isEmpty() {
        return size == 0;
    }

    /** A method to get the size of the deque. */
    public int size() {
        return size;
    }

    /** A method to print the deque. */
    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            System.out.print(ArrayDeque[i] + " ");
        }
        System.out.println();
    }

    /** A method to remove the first item of the deque. */
    public Type removeFirst() {
        if (size == 0) {
            return null;
        }
        Type[] newArray = (Type[]) new Object[ArrayDeque.length];
        System.arraycopy(ArrayDeque, 1, newArray, 0, size - 1);
        Type pop = ArrayDeque[0];
        size = size - 1;
        ArrayDeque = newArray;
        if ((double) ( size / ArrayDeque.length ) < 0.25 && ArrayDeque.length > 100) {
            ArrayDeque = resize(ArrayDeque.length / 2);
        }
        return pop;
    }

    /** A method to remove the last item of the deque. */
    public Type removeLast() {
        if (size == 0) {
            return null;
        }
        Type pop = ArrayDeque[size - 1];
        ArrayDeque[size - 1] = null;
        size = size - 1;
        if ((double) ( size / ArrayDeque.length ) < 0.25) {
            ArrayDeque = resize(ArrayDeque.length / 2);
        }
        return pop;
    }

    /** A method to get the item at the given index. */
    public Type get(int index) {
        return ArrayDeque[index];
    }

    /** A method to creat a deep copy of others. */
    public ArrayDeque(ArrayDeque other) {
        Type[] ArrayDeque = (Type[]) new Object[other.ArrayDeque.length];
        System.arraycopy(other.ArrayDeque, 0, ArrayDeque, 0, size);
        size = other.size;
    }

}
