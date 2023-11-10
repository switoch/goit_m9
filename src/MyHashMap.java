import java.util.HashMap;

public class MyHashMap<K, V> {

    private Node<K, V>[] buckets;

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

        if(buckets[bucketNumber] == null) {
            buckets[bucketNumber] = kvEntry;
        } else{
            kvEntry.setKvNextElement(buckets[bucketNumber]);
            buckets[bucketNumber] = kvEntry;
        }
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
        Node<K, V> currentEntry = buckets[bucketNumber];
        if(hash == currentEntry.key.hashCode() && currentEntry.key.equals(key)){
            currentEntry = null;
        }
        return currentEntry;
    }

    public int size(){
        return buckets.length;
    }

    private V checkEquals(Node<K,V> e, K key){
        if (e.getKey().equals(key)) {
            return e.getValue();
        }
        return null;
    }

    private class Node<K, V>{
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
