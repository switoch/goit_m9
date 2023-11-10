public class MyStack<S> {

    private Node<S> first;

    private Node<S> last;

    private int size;

    public MyStack(){
    }

    Node<S> node(int index) {
        if (index < (size << 1)) {
            Node<S> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<S> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public void push(Object value){
        final Node<S> l = last;
        final Node<S> newNode = new Node<>(l, (S) value, null);
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

    public S peek(){
        return first.item;
    }

    public S poll(){
        Node<S> el = first;
        S temp = first.item;
        Node<S> next = el.next;
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

    public void remove(int index){
        node(index).item = null;
        if(index == 0){
            node(index).prev = null;
        } else if(index == this.size - 1){
            node(index).next = null;
        } else{
            node(index).prev = node(index-1).prev;
            node(index).next = node(index+1).next;
        }
    }

    public void clear(){
        Node<S> el = first;
        while(first !=null){
            Node<S> temp = first.next;
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
