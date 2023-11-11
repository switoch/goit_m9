import java.util.HashMap;

public class MyHashMap<K, V> {

    private Node<K, V>[] buckets;

    private int size;

    public MyHashMap() {
        this.buckets = new Node[10];
    }

    public void clear(){
        this.buckets = new Node[10];
    }

    public void put(K key, V value){
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Node<K, V> kvEntry = new Node<>();
        kvEntry.setKey(key);
        kvEntry.setValue(value);
        Node<K, V> currentEntry = buckets[bucketNumber];
        if(currentEntry == null){
            buckets[bucketNumber] = kvEntry;
        }else {
            while(currentEntry.getKvNextElement() != null){
                currentEntry = currentEntry.getKvNextElement();
            }
            currentEntry.setKvNextElement(kvEntry);
        }
        size++;
    }

    public V get (K key){
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Node<K, V> currentEntry = buckets[bucketNumber];
        while(currentEntry.getKvNextElement() != null){
            V v = checkEquals(currentEntry,key);
            if(v!=null){
                return v;
            }

            currentEntry = currentEntry.getKvNextElement();
        }
        return checkEquals(currentEntry,key);
    }

    public Node<K, V> remove(K key){
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;
        if(buckets[bucketNumber] == null){return null;}
        Node<K, V> prev = null;
        Node<K, V> currentEntry = buckets[bucketNumber];
        Node<K, V> next = currentEntry.getKvNextElement();
        do{
            if(currentEntry.getKey().equals(key)){
                if(prev == null) {
                    buckets[bucketNumber] = next;
                }else {prev.setKvNextElement(next);}
                size--;
                return currentEntry;
            }
            prev = currentEntry;
            currentEntry = next;
            next = currentEntry.getKvNextElement();
        }while(currentEntry.getKvNextElement() != null);
        return null;
    }

    public int size(){
        return size;
    }

    private V checkEquals(Node<K,V> e, K key){
        if (e.getKey().equals(key)) {
            return e.getValue();
        }
        return null;
    }

    private static class Node<K, V>{
        private K key;

        private V value;

        private Node<K, V> kvNextElement;

        public Node<K, V> getKvNextElement() {
            return kvNextElement;
        }

        public Node<K, V> nextElement() {
            return kvNextElement;
        }

        public void setKvNextElement(Node<K, V> kvNextElement) {
            this.kvNextElement = kvNextElement;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
