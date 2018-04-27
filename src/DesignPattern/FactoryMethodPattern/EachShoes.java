package DesignPattern.FactoryMethodPattern;

public class EachShoes {
    public static class JPStyleBlackShoes extends Shoes {

        public JPStyleBlackShoes() {
            name = "일본 스타일의 검은 구두";
            bottom = "검은색 고무 밑창";
            leather = "소가죽";
            hasPattern = false;
        }
    }

    public static class FRStyleBlackShoes extends Shoes {

        public FRStyleBlackShoes() {
            // TODO Auto-generated constructor stub

            name = "프랑스 스타일의 검은 구두";
            bottom = "옅은 검은색의 플라스틱과 고무 혼용";
            leather = "양가죽";
            hasPattern = true;


        }

    }

    public static class JPStyleBrownShoes extends Shoes {

        public JPStyleBrownShoes() {
            // TODO Auto-generated constructor stub

            name = "일본 스타일의 갈색 구두";
            bottom = "진 갈색 고무 밑창";
            leather = "소가죽";
            hasPattern = false;


        }

    }

    public static class FRStyleBrownShoes extends Shoes {

        public FRStyleBrownShoes() {
            // TODO Auto-generated constructor stub

            name = "프랑스 스타일의 검은 구두";
            bottom = "밝은 갈색에 플라스틱과 고무 혼용";
            leather = "양가죽";
            hasPattern = true;


        }

    }

    public static class JPStyleRedShoes extends Shoes {

        public JPStyleRedShoes() {
            // TODO Auto-generated constructor stub

            name = "일본 스타일의 빨간색과 와인색 중간의 구두";
            bottom = "와인색 고무 밑창";
            leather = "소가죽";
            hasPattern = false;


        }

    }

    public static class FRStyleRedShoes extends Shoes {

        public FRStyleRedShoes() {
            // TODO Auto-generated constructor stub

            name = "프랑스 스타일의 버건디 색에 가까운 구두";
            bottom = "빨간 검은색의 플라스틱과 고무 혼용";
            leather = "양가죽";
            hasPattern = true;


        }

    }

}
