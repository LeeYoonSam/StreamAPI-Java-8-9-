package OOP.Test;

import java.util.ArrayList;
import java.util.List;

public class TargetClass extends AbstractTest implements InterfaceTest<List<String>, String> {

    List<String> list = new ArrayList<>();
//    @Override
//    String printURL() {
//        return url.split("/").toString();
//    }
//
//    @Override
//    void print(String message) {
//        System.out.println("TargetClass: " + message);
//    }

    @Override
    public String get(int index) {

        if(list != null) {
            if(list.size() < index -1)
                throw new IndexOutOfBoundsException();
            else
                return list.get(index);
        }

        return null;
    }

    @Override
    public void add(List<String> strings) {

    }

    @Override
    void print(String message) {
        System.out.println(this.url + ": " + message);
    }
}
