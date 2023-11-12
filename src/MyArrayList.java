import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<A> {

    private Object[] arr;

    private static final Object[] EMPTY = {};

    public MyArrayList(int initial){
        if(initial > 0){
            this.arr = new Object[initial];
        } else if(initial == 0){
            this.arr = EMPTY;
        } else throw new IllegalArgumentException("Array cannot have negative size!");

    }

    public MyArrayList(){
            this.arr = EMPTY;
    }

    public void add(A obj){
        arr = Arrays.copyOf(arr,arr.length+1);
        arr[arr.length - 1] = obj;
    }

    public A get(int index){
        if(index > 0 && index < arr.length) {
            return (A) arr[index];
        }
        return null;
    }

    public A remove(int index){
        try {
            Object[] newarr = Arrays.copyOf(arr, arr.length - 1);
            for (int i = index+1; i < arr.length; i++) {
                newarr[i - 1] = arr[i];
            }
            arr = Arrays.copyOf(newarr, newarr.length);
            return (A) arr;
        }catch (IndexOutOfBoundsException e){
            System.out.println("Please enter correct index!");}
        return null;
    }

    public int size(){
        return arr.length;
    }

    public void clear(){
        arr = EMPTY;
    }


    public void print(){
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
}
