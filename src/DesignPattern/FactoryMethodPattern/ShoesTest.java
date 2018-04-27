package DesignPattern.FactoryMethodPattern;

public class ShoesTest {
    public static void main(String[] args) {
        ShoesStore jpStore = new JapanShoesStore();
        ShoesStore frStore = new FranceShoesStore();

        Shoes shoes = jpStore.makeShoes(Common.BLACK_SHOES);
        System.out.println("일본 매장에서 산 구두는? --> " + shoes.getName());
        System.out.println();

        shoes = frStore.makeShoes(Common.BLACK_SHOES);
        System.out.println("프랑스 매장에서 산 구두는? --> " + shoes.getName());
        System.out.println();
    }
}
