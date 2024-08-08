package deque;
import deque.ArrayDeque;
import java.util.Comparator;

public class MaxArrayDeque<Type> {

    public MaxArrayDeque(Comparator<Type> c) {
    }

    public Type max() {
        if (ArrayDeque.isEmpty()) {
            return null;
        }

    }

}
