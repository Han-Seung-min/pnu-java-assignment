package edu.pnu.admin;

import edu.pnu.collection.GenericList;
import java.util.Iterator;

public class Cafe {
    private String name;
    private GenericList<Beverage> students = new GenericList<Beverage>();

    public Cafe(String name) {
        this.name = name;
        //this.students = new GenericList<Beverage>();
    }

    public void addBeverage(Beverage newBeverage) {
        students.add(newBeverage);
        System.out.println("\n");
    }

    public void removeAllBeverage() {
        students.clear();
        System.out.println("\n");
    }

    public Beverage findBeverage(String name, String type) {
        Beverage matchedBeverage = students.find(new Beverage(name, type));
        System.out.println("\n");
        return matchedBeverage;
    }

    @Override
    public String toString() {
        String msg = String.format("Cafe Name: %s Beverage Count: %d\n", name, students.size());
        msg += String.format("%s", students);
        return msg;
    }
}
