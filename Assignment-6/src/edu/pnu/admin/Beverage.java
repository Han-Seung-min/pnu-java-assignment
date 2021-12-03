package edu.pnu.admin;

import java.util.Objects;

public class Beverage {
    private String type;
    private String name;

    public Beverage(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getBeverageName() {
        return name;
    }

    public String getBeverageType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Beverage beverage = (Beverage) obj;
        return type.equals(beverage.type) && name.equals(beverage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", name, type);
    }
}
