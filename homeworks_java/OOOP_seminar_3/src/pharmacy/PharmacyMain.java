package pharmacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PharmacyMain {
     public static void main(String[] args) {

        Component pineceline = new Component("Pineceline", "10mg", 100);
        Component salt = new Component("Salt", "20gr", 10);
        Component sugar = new Component("Sugar", "87gr", 80);
        Component calcium = new Component("Calcium", "77gr", 15);
        Component magnesium = new Component("Magnesium", "67gr", 70);
        Component water = new Component("Water", "20mg", 65);

        
        Pharmacy pharmacy1 = new Pharmacy(1300);
        Pharmacy pharmacy2 = new Pharmacy(200);
        Pharmacy pharmacy3 = new Pharmacy(650);
        Pharmacy pharmacy4 = new Pharmacy(550);
        pharmacy1.addComponents(salt, pineceline, magnesium);
        pharmacy2.addComponents(salt, pineceline, water);
        pharmacy3.addComponents(salt, magnesium, sugar);
        pharmacy4.addComponents(salt, calcium, sugar);
        
        List<Pharmacy> medicines = new ArrayList<>();
        
        medicines.add(pharmacy1);
        medicines.add(pharmacy2);
        medicines.add(pharmacy3);
        medicines.add(pharmacy4);

        Collections.sort(medicines);
        for (Pharmacy c : medicines){
            System.out.println(c);
       }

        System.out.println("--------------------------------");

        IterablePharmacy pharmacyIter1 = new IterablePharmacy();
        IterablePharmacy pharmacyIter2 = new IterablePharmacy();
        IterablePharmacy pharmacyIter3 = new IterablePharmacy();
        IterablePharmacy pharmacyIter4 = new IterablePharmacy();
       
        pharmacyIter1.addComponents(sugar, pineceline);
        pharmacyIter2.addComponents(salt, sugar, calcium);
        pharmacyIter3.addComponents(sugar,magnesium,water);
        pharmacyIter4.addComponents(sugar,magnesium,water);

        List<Component> list = new ArrayList<>();
        list.add(pineceline);
        list.add(salt);
        list.add(sugar);
        list.add(calcium);
        list.add(magnesium);

        Collections.sort(list);
        
         for (Component c : list){
            System.out.println(c);
       }
       System.out.println("------------------------");

         Set<IterablePharmacy> result = new HashSet<>();
         result.add(pharmacyIter1);
         result.add(pharmacyIter2);
         result.add(pharmacyIter3);
         result.add(pharmacyIter4);

         System.out.println(pharmacyIter1);
         System.out.println("---------------------------");
         System.out.println(result.size());

    
    }

}
    

