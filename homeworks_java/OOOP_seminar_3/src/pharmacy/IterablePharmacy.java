package pharmacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

//import java.util.*;

public class IterablePharmacy implements Iterable<Component> {
    private int index;
    private final List<Component> components;

    public IterablePharmacy() {
        this.index = 0;
        this.components = new ArrayList<>();
    }

    public void addComponents(Component ... components){
        if (components.length == 0) System.out.println("Вы ничего не добавили!");
        else Collections.addAll(this.components, components);

    }

    public List<Component> getComponents() {
        return components;
    }

    @NotNull
    @Override
    public Iterator<Component> iterator() {

        return new Iterator<Component>() {
            @Override
            public boolean hasNext() {
                return index < components.size();
            }
            @Override
            public Component next() {
                return components.get(index++);
            }
        };
    }

//    @NotNull
//    @Override
//    public Iterator<Component> iterator() {
//        return new ComponentIterator(this);
//    }
  
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IterablePharmacy that = (IterablePharmacy) o;
        return index == that.index && Objects.equals(components, that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, components);
    }

//    @Override
//    public int compareTo(@NotNull IterablePharmacy o) {
////        //        return Integer.compare(this.power, o.power);
////        if (this.name.compareTo(o.name) > 0) return -1;
////        if (this.name.compareTo(o.name) < 0) return 1;
////        return 0;
//////        return Integer.compare(0, this.name.compareTo(o.name));
////    
//}
@Override

    public String toString() {
        return "IterablePharmacy{" +
                "index=" + index +
                ", components=" + components +
                '}';
    }
    
}