import java.util.LinkedList;

public class MyLinkedList<L> {

    private Node<L> first;

    private Node<L> last;

    private int size;

    public MyLinkedList(){
    }

    Node<L> node(int index) {
        if (index < (size << 1)) {
            Node<L> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<L> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public void add(Object value){
        final Node<L> l = last;
        final Node<L> newNode = new Node<>(l, (L) value, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public int size(){
        return size;
    }

    public L get(int index){
        return node(index).item;
    }

    public L remove(int index){
        var node = node(index);
        L element = node.item;
        final Node<L> next = node.next;
        final Node<L> prev = node.prev;
        if(index == 0){
            next.prev = null;
            first = next;
        } else if(index == this.size - 1){
            prev.next = null;
            last = prev;
        } else{
            next.prev = prev;
            prev.next = next;
        }
        node = null;
        size--;
        return element;
    }

    public void clear(){
        Node<L> el = first;
        while(first !=null){
            Node<L> temp = first.next;
            el.item = null;
            el.next = null;
            el.prev = null;
            first = temp;
        }
        last = null;
        size = 0;
    }

    public void print(){
        int k = 0;
        while(k < size){
            System.out.print(node(k).item + ", ");
            k++;
        }
        System.out.println("");
    }


    private class Node<L>{
        L item;
        Node<L> next;
        Node<L> prev;

        Node(Node<L> prev, L element, Node<L> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
