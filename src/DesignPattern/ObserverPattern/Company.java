package DesignPattern.ObserverPattern;


import java.util.Observable;

// Observable를 상속받아서 addObserver 등의 함수를 통해서 옵저버 등록이 가능 / 단순 클래스가 아닌 Observable 클래스
public class Company extends Observable {
    private String photoUrl;
    private String content;

    public Company() {
    }

    // 새로운 소식이 들어왔을때 (상태가 변했다고 알려주는 메소드)
    public void messageChanged() {
        setChanged();
        notifyObservers();
    }

    // 새로운 소식이 들어오는 메소드
    public void setMessage(String photoUrl, String content) {
        this.photoUrl = photoUrl;
        this.content = content;

        messageChanged();
    }

    public String getContent() {
        return content;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
