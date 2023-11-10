public class MyQueue<Q> {

    private Node<Q> first;

    private Node<Q> last;

    private int size;

    public MyQueue(){
    }

    Node<Q> node(int index) {
        if (index < (size << 1)) {
            Node<Q> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<Q> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public void add(Object value){
        final Node<Q> l = last;
        final Node<Q> newNode = new Node<>(l, (Q) value, null);
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

    public Q peek(){
        return first.item;
    }

    public Q poll(){
        Node<Q> el = first;
        Q temp = first.item;
        Node<Q> next = el.next;
        el.item = null;
        el.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return temp;
    }

    public void clear(){
        Node<Q> el = first;
        while(first !=null){
            Node<Q> temp = first.next;
            el.item = null;
            el.next = null;
            el.prev = null;
            first = temp;
        }
        last = null;
        size = 0;
    }

    public void print(){
        while(size != 0){
            System.out.println(node(size-1).item);
            size--;
        }
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
