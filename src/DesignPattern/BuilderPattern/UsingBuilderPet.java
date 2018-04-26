package DesignPattern.BuilderPattern;

public class UsingBuilderPet {
    public static void main(String[] args) {
        BuilderPet.Builder builder = new BuilderPet.Builder();
        BuilderPet builderPet = builder.withA("a")
                .withB("b")
                .withC("c")
                .withD("d")
                .build();

        System.out.println(builderPet.getA());
        System.out.println(builderPet.getF());
    }
}
