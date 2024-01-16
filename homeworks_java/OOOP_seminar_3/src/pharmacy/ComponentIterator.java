package pharmacy;

import java.util.Iterator;

public class ComponentIterator implements Iterator<Component> {
    private int index = 0;
    private IterablePharmacy pharmacy;

    public ComponentIterator(IterablePharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    @Override
    public boolean hasNext() {
        return index < pharmacy.getComponents().size();
    }

    @Override
    public Component next() {
        //component c = components.get(index);
        //index++;
        //return c;
        return pharmacy.getComponents().get(index++);
    }
}
    

