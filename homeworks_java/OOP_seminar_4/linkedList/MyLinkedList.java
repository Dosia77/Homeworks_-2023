package linkedList;
import java.util.Iterator;
//import java.util.LinkedList;


public class MyLinkedList<E> implements Linked<E>, Iterable<E>{
    private int size;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
    }
  
    public void printList(MyLinkedList<E> str){
        for(E s: str){
            System.out.println(s);
        }
    }
   @Override
    public void addFirst(E e) {
    
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;

    }
   @Override
    public void addLast(E e) {
       Node<E> l = last;
       Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElementByIndex(int index) {

       if (!(index >= 0 && index < size)){
        throw new IndexOutOfBoundsException(index);
       }
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return  x.item;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x.item;
        }
    }

   @Override
    public Iterator<E> iterator(){
        return new Iterator<E>(){
            int counter = 0;
        
    @Override 
    public boolean hasNext(){
        return counter < size;
    }
    @Override
    public E next(){
        return getElementByIndex(counter++);
    }
    };
    }


	private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    } 
}  

   


    

