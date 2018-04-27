package DesignPattern.AbstractFactoryPattern;

public abstract class Shoes {
    String name;
    Bottom bottom;
    Leather leather;
    boolean hasPattern;

    abstract  void assembling();

    void prepare() {
        System.out.println("완성된 신발을 준비 중 입니다..");
    }

    void packing() {
        System.out.println("신발을 포장 하고 있습니다..");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
