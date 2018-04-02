package Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * URL - https://howtodoinjava.com/java-8/using-comparator-becomes-easier-with-lambda-expressions-java-8/
 */
public class ComparatorExample {

    public static void main(String[] args) {
        System.out.println("[ Sort all employees by first name ]");
        sortFirstName();
        System.out.println("-------------------------------");

        System.out.println("[ Sort all employees by last name ]");
        sortLastName();
        System.out.println("-------------------------------");

        System.out.println("[ Sort By first name and then by last name (sort on multiple fields) ]");
        sortByFirstAndThenLastName();
        System.out.println("-------------------------------");

        System.out.println("[ Using parallel sorting (with multiple threads) ]");
        sortParallel();
        System.out.println("-------------------------------");
    }

    private static List<Employee> getEmployees() {
        List<Employee> employees  = new ArrayList<>();
        employees.add(new Employee(1,"Lokesh", "Gupta", 32));
        employees.add(new Employee(2,"Aman", "Sharma", 28));
        employees.add(new Employee(3,"Aakash", "Yaadav", 52));
        employees.add(new Employee(4,"James", "Hedge", 72));
        employees.add(new Employee(5,"David", "Kameron", 19));
        employees.add(new Employee(6,"Yash", "Chopra", 25));
        employees.add(new Employee(7,"Karan", "Johar", 59));
        employees.add(new Employee(8,"Balaji", "Subbu", 88));
        employees.add(new Employee(9,"Vishu", "Bissi", 33));
        employees.add(new Employee(10,"Lokesh", "Ramachandran", 60));

        return employees;
    }

    // FirstName으로 정렬 및 리버스 정렬
    private static void sortFirstName() {
        List<Employee> employees  = getEmployees();

        Comparator<Employee> comparator = Comparator.comparing(Employee::getFirstName);

        // 전 직원의 firstName으로 정렬
//        employees.sort(Comparator.comparing(e-> e.getFirstName()));
        // or
        employees.sort(comparator);
        System.out.println(employees);

        System.out.println("[ Sort all employees by first name in reverse order ]");
        employees.sort(comparator.reversed());
        System.out.println(employees);
        System.out.println("-------------------------------");
    }

    // LastName으로 정렬
    private static void sortLastName() {
        List<Employee> employees = getEmployees();

        employees.sort(Comparator.comparing(Employee::getLastName));
        System.out.println(employees);
    }

    // FirstName으로 먼저 비교 후 동일하면 두번째 조건은 LastName으로 정렬한다.
    private static void sortByFirstAndThenLastName() {
        List<Employee> employees = getEmployees();

        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
        employees.sort(groupByComparator);

        System.out.println(employees);
    }

    private static void sortParallel() {

        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);

        List<Employee> employees = getEmployees();

        Employee[] employeesArray = employees.toArray(new Employee[employees.size()]);

        Arrays.parallelSort(employeesArray, groupByComparator);

        Arrays.stream(employeesArray).forEach(System.out::println);
    }
}
