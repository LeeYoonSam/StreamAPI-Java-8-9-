package DesignPattern.DecoratorPattern;

public class CaffeLatte extends Beverage {
    public CaffeLatte() {
        super();
        description = "카페라떼";
    }

    @Override
    public int cost() {
        return 5000;
    }
}
