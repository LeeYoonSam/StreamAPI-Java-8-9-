package DesignPattern.AbstractFactoryPattern;

public class ShoesDrive {
    public static void main(String[] args) {
        JPShoesStore jpStore = new JPShoesStore();
        jpStore.orderShoes(Common.BLACK_SHOES);

        FRShoesStore frStore = new FRShoesStore();
        frStore.orderShoes(Common.RED_SHOES);
    }
}
