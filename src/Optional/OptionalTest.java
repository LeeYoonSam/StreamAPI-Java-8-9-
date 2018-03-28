package Optional;

import java.util.Optional;

public class OptionalTest {
    /**
     * URL - https://howtodoinjava.com/java-8/java-8-optionals-complete-reference/
     *
     * Remember that it is never said that optional “contain null”.
     */

    /**
     *
     * URL - http://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html
     *
     * so that the following piece of code
        String version = "UNKNOWN";
        if(computer != null){
             Soundcard soundcard = computer.getSoundcard();
             if(soundcard != null){
                 USB usb = soundcard.getUSB();
                 if(usb != null){
                     version = usb.getVersion();
                }
            }
        }

     * can be written as
         String name = computer.flatMap(Computer::getSoundcard)
         .flatMap(Soundcard::getUSB)
         .map(USB::getVersion)
         .orElse("UNKNOWN");

     */


    public static void main(String[] args) {

        singleValueOptional();

        optinalValueIsPresent();

        absentValueAndAction();
    }

    public static void singleValueOptional() {
        Optional<Integer> canBeEmpty1 = Optional.of(5);

        System.out.println("canBeEmpty1.isPresent(): " + canBeEmpty1.isPresent());      // reutrn true
        System.out.println("canBeEmpty1.get(): " + canBeEmpty1.get());                  // return 5

        Optional<Integer> canBeEmpty2 = Optional.empty();
        System.out.println("canBeEmpty2.isPresent(): " + canBeEmpty2.isPresent());      // return false
    }

    public static void createOptionalObj() {
        Optional<Integer> possible;

        // 1) Use Optional.empty() to create empty optional.
        possible = Optional.empty();

        // 2) Use Optional.of() to create optional with default non-null value. If you pass null in of(), then a NullPointerException is thrown immediately.
        possible = Optional.of(5);

        // 3) Use Optional.ofNullable() to create an Optional object that may hold a null value. If parameter is null, the resulting Optional object would be empty (remember that value is absent; don’t read it null).
        possible = Optional.ofNullable(null);
        //or
        possible = Optional.ofNullable(5);
    }

    public static void optinalValueIsPresent() {
        Optional<Integer> possible = Optional.of(5);
        possible.ifPresent(System.out::println);

        if(possible.isPresent()){
            System.out.println(possible.get());
        }
    }

    public static void absentValueAndAction() {

        class Company {
            Company (String name) {
                this.name = name;
            }
            String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        //Assume this value has returned from a method
        Optional<Company> companyOptional = Optional.empty();
//        Optional<Company> companyOptional = Optional.of(new Company("Finance"));

        //Now check optional; if value is present then return it, else create a new Company object and retur it
//        Company company = companyOptional.orElse(new Company(""));

        //OR you can throw an exception as well
//        Company companyThrow = companyOptional.orElseThrow(IllegalStateException::new);


        companyOptional.filter(department -> "Finance".equals(department.getName()))
                .ifPresent( company1 -> System.out.println("Finance is present") );
    }
}
