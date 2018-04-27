package DesignPattern.AbstractFactoryPattern;


interface Bottom {
    public String getName();
}

interface Leather {
    public String getName();
}

public class Ingredient {

    public static class RubberBottom implements Bottom {

        @Override
        public String getName() {
            return "고무";
        }
    }

    public static class PlasticAndRubberBottom implements Bottom {

        @Override
        public String getName() {
            return "플라스틱과 고무의 혼합";
        }
    }

    public static class LeatherOfCows implements Leather {

        @Override
        public String getName() {
            // TODO Auto-generated method stub
            return "소가죽";
        }

    }

    public static class LeatherOfSheeps implements Leather {

        @Override
        public String getName() {
            // TODO Auto-generated method stub
            return "양가죽";
        }

    }
}
