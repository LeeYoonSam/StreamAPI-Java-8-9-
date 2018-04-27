package DesignPattern.FactoryMethodPattern;

public class JapanShoesStore extends ShoesStore {
    @Override
    Shoes makeShoes(String name) {
        if(name.equals(Common.BLACK_SHOES)) {
            return new EachShoes.JPStyleBlackShoes();
        } else if(name.equals(Common.BROWN_SHOES)) {
            return new EachShoes.JPStyleBrownShoes();
        } else if(name.equals(Common.RED_SHOES)) {
            return new EachShoes.JPStyleRedShoes();
        } else {
            return null;
        }
    }
}
