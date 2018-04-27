package DesignPattern.ObserverPattern;

public class Messenger {

    public static void main(String[] args) {
        // Subject 클래스 생성(Observable 이므로 new Subscriber(observable)에 파라미터로 넣을수 있음.
        Company company = new Company();

        // Observer 클래스 생성
        Subscriber subscriber1 = new Subscriber(company);
        Subscriber2 subscriber2 = new Subscriber2(company);

        // Subject에게 새로운 소식을 전달한다.
        company.setMessage("photo", "이벤트");
    }
}
