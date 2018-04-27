package DesignPattern.DecoratorPattern;

public abstract class Beverage {

    String description = "no title";

    public abstract int cost();

    public String getDescription() {
        return description;
    }
}
