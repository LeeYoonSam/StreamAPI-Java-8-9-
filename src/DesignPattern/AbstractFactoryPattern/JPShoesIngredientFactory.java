package DesignPattern.AbstractFactoryPattern;

public class JPShoesIngredientFactory implements ShoesIngredientFactory {
    @Override
    public Bottom makeBottom() {
        return new Ingredient.RubberBottom();
    }

    @Override
    public Leather makeLeather() {
        return new Ingredient.LeatherOfCows();
    }

    @Override
    public boolean hasPattern() {
        return false;
    }
}
