package StringToDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringToDateExample {

    public static void main(String[] args) {
        System.out.println("[ Convert string to date in ISO8601 format ]");
        convertStringToDate();
        System.out.println("-------------------------------");

        System.out.println("[ Convert string to date in custom formats ]");
        convertCustomStringToDate();
        System.out.println("-------------------------------");
    }

    public static void convertStringToDate() {
        String armisticeDate = "2018-03-30";

        LocalDate localDate = LocalDate.parse(armisticeDate);
        System.out.println("Date: " + localDate);

        String armisticeDateTime = "2018-03-30T11:50";

        LocalDateTime localDateTime = LocalDateTime.parse(armisticeDateTime);
        System.out.println("Date/Time: " + localDateTime);
    }

    public static void convertCustomStringToDate() {
        String anotherDate = "04 Apr 2016";

        // 날짜 포맷 설정
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");

        // Date 형태로 파싱
        LocalDate random = LocalDate.parse(anotherDate, df);

        System.out.println(anotherDate + " parse as " + random);
    }
}
