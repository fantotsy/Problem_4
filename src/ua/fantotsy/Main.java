package ua.fantotsy;

public class Main {

    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        System.out.println(list.size());
        list.print();
        list.add(4);
        list.print();
        list.add(5);
        list.print();
        list.add(6);
        list.print();
        System.out.println(list.size());
        list.addOnPosition(0, 3);
        list.add(6);
        list.print();
        list.remove(6);
        list.remove(3);
        list.remove(5);
        list.print();
        System.out.println(list.size());

    }
}
