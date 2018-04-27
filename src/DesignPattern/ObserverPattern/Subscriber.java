package DesignPattern.ObserverPattern;

import java.util.Observable;
import java.util.Observer;

// 구독자로서 Observable로 전달받은 데이터를 사용하는곳
public class Subscriber implements Observer, DisplayElement {

    Observable observable;

    private String photoUrl;
    private String content;

    public Subscriber(Observable observable) {
        this.observable = observable;

        // 전달받은 observable에 옵저버로 등록
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("1번째 구독자");
        System.out.println("photo link: " + photoUrl);
        System.out.println("content: " + content);
        System.out.println("\n");
    }

    // 새로운 소식을 받는 메소드
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Company) {
            Company company = (Company) o;

            this.photoUrl = company.getPhotoUrl();
            this.content = company.getContent();

            display();
        }

    }
}
