import java.util.HashMap;
import java.util.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

       /* MyArrayList<String> data = new MyArrayList<String>();
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
        data.print();*/

//        MyLinkedList<Integer> nums = new MyLinkedList<Integer>();
//        nums.add(5);
//        nums.add(6);
//        nums.add(8);
//        nums.add(4);
//        System.out.println("Zero = " + nums.get(0));
//
//        nums.print();
//        System.out.println("first = " + nums.get(1));
//        System.out.println("Size = " + nums.size());
//        nums.remove(3);
//        nums.print();
//        System.out.println("*******");
//        System.out.println("First = " + nums.get(1));
//        System.out.println(nums.size());
//        nums.clear();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Lina", 34);
        map.put("Anna", 40);
        map.put("Alla", 59);
        map.put("Lew", 3);
        System.out.println("map.get(\"Lina\") = " + map.get("Lina"));
        System.out.println("map.size() = " + map.size());

        MyHashMap<String, Integer> mymap = new MyHashMap<String, Integer>();
        mymap.put("Lina", 34);
        mymap.put("Anna", 40);
        mymap.put("Alla", 59);
        mymap.put("Lew", 3);
        System.out.println("mymap.get(\"Lina\") = " + mymap.get("Lina"));
        System.out.println("mymap.size() = " + mymap.size());


//        MyQueue<Double> queue = new MyQueue<Double>();
//        queue.add(0.1d);
//        queue.add(2.5d);
//        queue.add(6.8d);
//        System.out.println(queue.peek());
//        queue.poll();
//        System.out.println(queue.peek());

    }
}