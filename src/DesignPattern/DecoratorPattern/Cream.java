package DesignPattern.DecoratorPattern;

public class Cream extends CondimentDecorator {
    Beverage beverage;

    public Cream(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost() + 500;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 크림";
    }
}
