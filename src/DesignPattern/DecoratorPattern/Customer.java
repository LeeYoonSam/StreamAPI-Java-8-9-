package DesignPattern.DecoratorPattern;

/*
Customer의 코드와 같이 초기화 시켰을 때, Shot-Shot-Americano 이렇게 감싸지는 형태로 객체가 생성 되게 됩니다. 첨가물들의 beverage 필드를 통해 저런 형태의 체인이 만들어 지게 되는데,
이때 제일 외부의 Shot 객체의 getDescription 메소드를 실행 시키면, beverage에 저장 되어 있는 Shot 객체의 getDescription으로, 그리고 이어서 Americano 객체에 있는 getDescription 메소드가 차례로 호출 되게 됩니다.
그리고 리턴은 역순으로 일어나게 되므로, Amerciano 객체에 있는 description이 차례로 리턴되면서 Shot 객체를 거쳐 문자열이 더해지며 최종 적으로는 "아메리카노, 샷, 샷" 으로 표시 되게 됩니다.
cost 메소드 또한 Americano 까지 호출되어 가서, 리턴 되며 가격이 더해져서 최종적으로 더해진 가격이 나옵니다.

이 데코레이터 패턴은 어디서 사용할까요?
이미 눈치 채고 계신 분들도 있겠지만, 자바의 I/O 클래스에서 이 패턴으로 설계 되어 있습니다.

출처 : http://stg-tud.github.io/sedc/Lecture/ws13-14/5.3-Decorator.html
자바의 I/O 클래스는 이렇게 구성되어 있습니다. FileInputStream을 구현할 때, BufferedInputStream을 감싸서 주로 구현합니다.

 */
public class Customer {
    public static void main(String[] args) {
        Beverage beverage = new Americano();
        beverage = new Shot(beverage);
        beverage = new Shot(beverage);

        System.out.println("메뉴 : " + beverage.getDescription());
        System.out.println("가격 : " + beverage.cost());
    }
}
