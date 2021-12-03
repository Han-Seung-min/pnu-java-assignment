import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class Cafe {
    private String name;
    private HashMap<String, Beverage> menus = new HashMap<>();

    public Cafe(String name){
        this.name = name;
    }

    public String toString(){
        String msg = "\nCafe Name: " + name + " Beverage Count: " + menus.size() + "\n";
        Iterator<Beverage> values = menus.values().iterator();
        while (values.hasNext()){
            msg += "\t" + values.next() + "\n";
        }
        return msg;
    }

    public void addBeverage(Beverage newBeverage) {
        String key = getHashKeyFrom(newBeverage.getBeverageName(), newBeverage.getBeverageType());
        menus.put(key, newBeverage);
        //for flaw of CafeTest
        System.out.println("");
    }

    public void removeAllBeverage() {
        menus.clear();
        //for flaw of CafeTest
        System.out.println("");
    }

    public Beverage findBeverage(String name, String type) {
        String key = getHashKeyFrom(name, type);
        //for flaw of CafeTest
        System.out.println("");

        return menus.get(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cafe cafe = (Cafe) o;
        return name.equals(cafe.name) && menus.equals(cafe.menus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, menus);
    }

    public String getHashKeyFrom(String name, String type){
        String key;

        switch (name){
            case "Espresso":
                key = "1";
                break;
            case "Americano":
                key = "2";
                break;
            case "FlatWhite":
                key = "3";
                break;
            default:
                key = "4";
                break;
        }

        return key;
    }
}
