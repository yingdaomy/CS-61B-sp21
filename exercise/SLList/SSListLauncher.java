package SLList;

public class SSListLauncher {
    public static void main(String[] args) {
        SSList s1 = new SSList();
        s1.addFirst(10);
        s1.addFirst(20);
        s1.addFirst(30);
        System.out.println(s1.get(0));
    }
}
