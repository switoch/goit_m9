import java.util.HashMap;
import java.util.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

       MyArrayList<String> data = new MyArrayList<String>();
        data.add("asd");
        data.add("asd1");
        data.add("asd2");
        data.add("asd3");
        data.add("asd4");
        data.add("asd5");
        data.add("asd6");
        data.add("test12");

        System.out.println("First = " + data.get(1));
        data.remove(5);
        data.print();
        data.size();
        data.clear();
        data.print();


        MyHashMap<String, Integer> mymap = new MyHashMap<String, Integer>();
        mymap.put("Lina", 34);
        mymap.put("Anna", 40);
        mymap.put("Alla", 59);
        mymap.put("Lew", 3);
        mymap.put("Test", 11);
        mymap.put("Last", 48);

        System.out.println("mymap.size() = " + mymap.size());
        System.out.println("mymap.get(\"Lina\") = " + mymap.get("Lina"));

       mymap.remove("Lina");

        System.out.println("mymap.get(\"Lina\") = " + mymap.get("Lina"));
        System.out.println("mymap.size() = " + mymap.size());


        MyQueue<Double> queue = new MyQueue<Double>();
        queue.add(0.1d);
        queue.add(2.5d);
        queue.add(6.8d);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue.peek());

    }
}