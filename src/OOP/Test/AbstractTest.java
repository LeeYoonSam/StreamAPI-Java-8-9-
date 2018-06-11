package OOP.Test;

abstract public class AbstractTest {
    String url;

    String printURL() {
        return this.url;
    }

    abstract void print(String message);
}
