package DesignPattern.AbstractFactoryPattern;

public class FRShoesIngredientFactory implements ShoesIngredientFactory {
    @Override
    public Bottom makeBottom() {
        return new Ingredient.PlasticAndRubberBottom();
    }

    @Override
    public Leather makeLeather() {
        return new Ingredient.LeatherOfSheeps();
    }

    @Override
    public boolean hasPattern() {
        return false;
    }
}