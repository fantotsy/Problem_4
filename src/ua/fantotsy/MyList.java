package ua.fantotsy;

public class MyList<T extends Comparable> {
    Header header = new Header();

    private static class Header {
        Node first;
        Node last;
    }

    private static class Node<T> {
        Node next;
        T data;
    }

    public int size() {
        if (header.first == null) {
            return 0;
        }
        int result = 0;
        Node current = new Node();
        current = header.first;
        while (current != null) {
            result++;
            current = current.next;
        }
        return result;
    }

    public void addOnPosition(int position, T element) {
        Node current = header.first;
        int iterator = 0;
        try {
            while (iterator != position) {
                current = current.next;
                iterator++;
            }
            current.data = element;
        } catch (NullPointerException e) {
            System.out.println("Position > Size OR Position < 0! Message: " + e.getMessage());
        }
    }

    public void add(T element) {
        Node node = new Node();
        node.data = element;
        if (size() == 0) {
            header.first = node;
            header.last = node;
        } else {
            header.last.next = node;
            header.last = node;
        }
    }

    public void print() {
        Node current = header.first;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print("]\n");
    }

    public void remove(T element) {
        Node current = header.first;
        if (size() == 0) {
            return;
        } else if (size() == 1) {
            if (current.data == element) {
                header.first = null;
                header.last = null;
            }
            return;
        } else {
            int iterator = 0;
            while (current != null) {
                if (current.data == element) {
                    if (iterator == 0) {
                        header.first = current.next;
                        current = header.first;
                    } else if (iterator == (size() - 1)) {
                        current = header.first;
                        for (int i = 1; i < iterator; i++) {
                            current = current.next;
                        }
                        current.next = null;
                        header.last = current;
                    } else {
                        current = header.first;
                        for (int i = 1; i < iterator; i++) {
                            current = current.next;
                        }
                        current.next = current.next.next;
                        current = current.next;
                    }
                } else {
                    iterator++;
                    current = current.next;
                }
            }
        }
    }

}
