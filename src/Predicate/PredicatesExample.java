package Predicate;

import java.util.List;

public class PredicatesExample {
    public static void main(String[] args) {
        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");

        List<Employee> employees = List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        // 성인남성 출력
        System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultMale()));

        // 성인여성 출력
        System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultFemale()));

        // 35세 이상 출력
        System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAgeMoreThan(35)));

        // 35세 이하 출력
        System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAgeMoreThan(35).negate()));
    }
}
