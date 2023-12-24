package pharmacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Pharmacy implements Iterator<Component> , Comparable<Pharmacy>{
    private int index;
    private int price;
    private final List<Component> components;

    public Pharmacy(int price) {
        this.index = 0;
        this.price = price;
        this.components = new ArrayList<>();

    }

    // public int getPrise(){
    //     return price();
    // }

    public void addComponents(Component ... components){
        if (components.length == 0) System.out.println("Вы ничего не добавили!");
        else Collections.addAll(this.components, components);

    }

    @Override
    public boolean hasNext() {
        return index < components.size();
    }

    @Override
    public Component next() {
        //component c = components.get(index);
        //index++;
        //return c;
        return components.get(index++);
    }

    @Override

    public String toString() {
        return "Pharmacy{" +
                "index = " + index +
                " , price = " + price +
                ", components = " + components +
                '}';
    }

    @Override
    public int compareTo(Pharmacy o) {
        return Integer.compare(this.price, o.price);
    }

    
}