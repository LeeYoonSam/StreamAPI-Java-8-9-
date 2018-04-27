package DesignPattern.FactoryMethodPattern;

public class FranceShoesStore extends ShoesStore {
    @Override
    Shoes makeShoes(String name) {
        if(name.equals(Common.BLACK_SHOES)) {
            return new EachShoes.FRStyleBlackShoes();
        } else if(name.equals(Common.BROWN_SHOES)) {
            return new EachShoes.FRStyleBrownShoes();
        } else if(name.equals(Common.RED_SHOES)) {
            return new EachShoes.FRStyleRedShoes();
        } else {
            return null;
        }
    }
}
