package Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DifferenceBetweenDatesExample {

    public static void main(String[] args) {
        System.out.println("[ Difference between dates in java 8 ]\n\n");

        System.out.println("[ java.time.Period example to know the difference in days/months/years ]");
        betweenPeriod();
        System.out.println("-------------------------------");

        System.out.println("[ java.time.temporal.ChronoUnit example to know the difference in days/months/years ]");
        difference_between_two_dates_java8();
        difference_between_two_dates_chronounit();
        System.out.println("-------------------------------");

        System.out.println("[ java.time.Duration example to know the difference in millis/seconds/minutes etc ]");
        difference_between_two_dates_duration();
        System.out.println("-------------------------------");
    }

//    public static void difference_between_two_dates_duration_Joda() {
//        DateTime dateOfBirth = new DateTime(1988, 7, 4, 0, 0, GregorianChronology.getInstance());
//        DateTime currentDate = new DateTime();
//        Days diffInDays = Days.daysBetween(dateOfBirth, currentDate);
//        Hours diffInHours = Hours.hoursBetween(dateOfBirth, currentDate);
//        Minutes diffInMinutes = Minutes.minutesBetween(dateOfBirth, currentDate);
//        Seconds seconds = Seconds.secondsBetween(dateOfBirth, currentDate);
//    }

    public static void betweenPeriod() {
        LocalDate endofCentury = LocalDate.of(2017, 01, 01);
        LocalDate now = LocalDate.now();

        Period diff = Period.between(endofCentury, now);
        System.out.printf("Difference is %d years, %d months and %d days old\n",
                diff.getYears(), diff.getMonths(), diff.getDays());
    }

    // java.time.temporal.ChronoUnit 사용
    public static void difference_between_two_dates_java8() {
        LocalDate dateOfBirth = LocalDate.of(1986, Month.AUGUST, 13);
        LocalDate currentDate = LocalDate.now();

        long diffInDays = ChronoUnit.DAYS.between(dateOfBirth, currentDate);
        long diffInMonths = ChronoUnit.MONTHS.between(dateOfBirth, currentDate);
        long diffInYears = ChronoUnit.YEARS.between(dateOfBirth, currentDate);

        System.out.printf("Difference is %d years, %d months and %d days old\n",
                diffInYears, diffInMonths, diffInDays);
    }

    public static void difference_between_two_dates_chronounit()
    {
        LocalDateTime dateTime = LocalDateTime.of(1988, 7, 4, 0, 0);
        LocalDateTime dateTime2 = LocalDateTime.now();
        long diffInNano = ChronoUnit.NANOS.between(dateTime, dateTime2);
        long diffInSeconds = ChronoUnit.SECONDS.between(dateTime, dateTime2);
        long diffInMilli = ChronoUnit.MILLIS.between(dateTime, dateTime2);
        long diffInMinutes = ChronoUnit.MINUTES.between(dateTime, dateTime2);
        long diffInHours = ChronoUnit.HOURS.between(dateTime, dateTime2);

        System.out.printf("Difference is %d NANOS, %d SECONDS, %d MILLIS, %d MINUTES, %d HOURS, \n",
                diffInNano, diffInSeconds, diffInMilli, diffInMinutes, diffInHours);
    }

    public static void difference_between_two_dates_duration()
    {
        LocalDateTime dateTime = LocalDateTime.of(1988, 7, 4, 0, 0);
        LocalDateTime dateTime2 = LocalDateTime.now();
        int diffInNano = java.time.Duration.between(dateTime, dateTime2).getNano();
        long diffInSeconds = java.time.Duration.between(dateTime, dateTime2).getSeconds();
        long diffInMilli = java.time.Duration.between(dateTime, dateTime2).toMillis();
        long diffInMinutes = java.time.Duration.between(dateTime, dateTime2).toMinutes();
        long diffInHours = java.time.Duration.between(dateTime, dateTime2).toHours();

        System.out.printf("Difference is %d NANOS, %d SECONDS, %d MILLIS, %d MINUTES, %d HOURS, \n",
                diffInNano, diffInSeconds, diffInMilli, diffInMinutes, diffInHours);
    }
}
