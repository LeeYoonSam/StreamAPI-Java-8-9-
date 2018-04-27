package DesignPattern.FactoryMethodPattern;

public abstract class ShoesStore {
    public Shoes orderShoes(String name) {

        Shoes shoes;

        shoes = makeShoes(name);

        shoes.prepare();
        shoes.packing();

        return shoes;
    }

    abstract Shoes makeShoes(String name);
}
