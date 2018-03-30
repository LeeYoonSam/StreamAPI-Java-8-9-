package MaxMin;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * URL - https://howtodoinjava.com/java-8/java-stream-distinct-examples/
 */
public class MaxMinExample {

    public static void main(String[] args) {

        System.out.println("[ Find Min or Max Date ]");
        localDateMaxMin();
        System.out.println("-----------------------------------------");


        System.out.println("[ Find Min or Max Number ]");
        findMaxMinNumber();
        System.out.println("-----------------------------------------");


        System.out.println("[ Find Min or Max Char or String ]");
        findMaxMinChar();
        System.out.println("-----------------------------------------");


        System.out.println("[ Find Min or Max Object ]");
        findMaxMinObject();
        System.out.println("-----------------------------------------");

    }

    public static void localDateMaxMin() {
        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        List<LocalDate> dates = Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .collect(Collectors.toList());

        // Get Min or Max Date
        LocalDate maxDate = dates.stream().max( Comparator.comparing( LocalDate::toEpochDay ) ).get();
        LocalDate minDate = dates.stream().min( Comparator.comparing( LocalDate::toEpochDay ) ).get();

        System.out.println("maxDate = " + maxDate);
        System.out.println("minDate = " + minDate);
    }

    public static void findMaxMinNumber() {
        Integer maxNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .max(Comparator.comparing(Integer::valueOf)).get();

        Integer minNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .min(Comparator.comparing(Integer::valueOf)).get();

        System.out.println("maxNumber = " + maxNumber);
        System.out.println("minNumber = " + minNumber);
    }

    public static void findMaxMinChar() {
        String maxChar = Stream.of("H", "T", "D", "I", "J")
                .max(Comparator.comparing(String::valueOf)).get();

        String minChar = Stream.of("H", "T", "D", "I", "J")
                .min(Comparator.comparing(String::valueOf)).get();

        System.out.println("maxChar = " + maxChar);
        System.out.println("minChar = " + minChar);
    }

    public static void findMaxMinObject() {
        List<Employee> emps = new ArrayList<Employee>();

        emps.add(new Employee(1, "Lokesh", 36));
        emps.add(new Employee(2, "Alex", 46));
        emps.add(new Employee(3, "Brian", 52));

        Comparator<Employee> comparator = Comparator.comparing(Employee::getAge);

        Employee minObject = emps.stream().max(comparator).get();
        Employee maxObject = emps.stream().min(comparator).get();

        System.out.println("minObject = " + minObject);
        System.out.println("maxObject = " + maxObject);
    }


    static class Employee {
        private int id;
        private String name;
        private int age;

        public Employee(int id, String name, int age) {
            super();
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            StringBuilder str = null;
            str = new StringBuilder();
            str.append("Id: " + getId() + " Name: " + getName() + " Age: " + getAge());
            return str.toString();
        }
    }
}
