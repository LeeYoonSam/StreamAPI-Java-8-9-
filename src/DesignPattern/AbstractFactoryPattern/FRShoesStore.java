package DesignPattern.AbstractFactoryPattern;

public class FRShoesStore extends ShoesStore {

    @Override
    Shoes makeShoes(String name) {
        Shoes shoes = null;
        ShoesIngredientFactory shoesIngredientFactory = new FRShoesIngredientFactory();

        if (name.equals(Common.BLACK_SHOES)) {

            shoes = new BlackShoes(shoesIngredientFactory);
            shoes.setName("프랑스 스타일의 검은 구두");

        } else if (name.equals(Common.BROWN_SHOES)) {

            shoes = new BrownShoes(shoesIngredientFactory);
            shoes.setName("프랑스 스타일의 갈색 구두");
        } else if (name.equals(Common.RED_SHOES)) {

            shoes = new RedShoes(shoesIngredientFactory);
            shoes.setName("프랑스 스타일의 빨간 구두");
        }

        return shoes;

    }
}
