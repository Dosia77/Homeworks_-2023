import list.MyArrayList;
import list.MyList;
import linkedList.*;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();
        list.add("2");
        list.add("30");
        list.add("20");
        list.add("ggr");
        System.out.println(list.get(0));
        list.delete(2);
        System.out.println(list);


        MyLinkedList<String> str = new MyLinkedList<>();
        str.addLast("bbb");
        str.addFirst("aaa");
        str.addLast("ccc");
        System.out.println(str.size());
        System.out.println("---------------------------------");
        System.out.println(str.getElementByIndex(0));
        System.out.println("---------------------------------");
         str.printList(str);
      
        
}
}