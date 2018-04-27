package DesignPattern.AbstractFactoryPattern;

public class JPShoesStore extends ShoesStore {
    @Override
    Shoes makeShoes(String name) {

        Shoes shoes = null;
        ShoesIngredientFactory shoesIngredientFactory = new JPShoesIngredientFactory();

        if(name.equals(Common.BLACK_SHOES)) {
            shoes = new BlackShoes(shoesIngredientFactory);
            shoes.setName("일본 스타일의 검은 구두");
        } else if(name.equals(Common.BROWN_SHOES)) {
            shoes = new BrownShoes(shoesIngredientFactory);
            shoes.setName("일본 스타일의 갈색 구두");
        } else if(name.equals(Common.RED_SHOES)) {
            shoes = new RedShoes(shoesIngredientFactory);
            shoes.setName("일본 스타일의 빨간 구두");
        }

        return shoes;
    }
}
