package Distinct;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * URL - https://howtodoinjava.com/java-8/java-stream-distinct-examples/
 */
public class DistinctSample {

    public static void main(String[] args) {
        findAllDistinct();

        System.out.println("");

        findAllDistinctAttrProperty();
    }

    public static void findAllDistinct() {
        Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");

        // 전체 출력
        System.out.println("Before");
        System.out.println(list.stream().collect(Collectors.toList()));

        // 중복되는 것을 삭제하고 리스트를 받아온다.
        List<String> distinctElement = list.stream().distinct().collect(Collectors.toList());
        System.out.println("After");
        System.out.println(distinctElement);
    }


    // Filter Distinct Elements by Object Attribute/Property
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static void findAllDistinctAttrProperty() {
        Person lokesh = new Person(1, "Lokesh", "Gupta");
        Person brian = new Person(2, "Brian", "Clooney");
        Person alex = new Person(3, "Alex", "Kolen");

        //Add some random persons
        Collection<Person> list = Arrays.asList(lokesh,brian,alex,lokesh,brian,lokesh);
        System.out.println("Before");
        System.out.println(list);

        // Get distinct only
        List<Person> distinctElements = list.stream()
                .filter(distinctByKey(person -> person.getId()))
                .collect(Collectors.toList());

        System.out.println("After");
        System.out.println(distinctElements);
    }

    static class Person
    {
        public Person(Integer id, String fname, String lname) {
            super();
            this.id = id;
            this.fname = fname;
            this.lname = lname;
        }

        private Integer id;
        private String fname;
        private String lname;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        @Override
        public String toString() {
            return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
        }
    }
}
