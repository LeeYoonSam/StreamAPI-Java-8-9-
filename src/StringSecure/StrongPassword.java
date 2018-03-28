package StringSecure;

public class StrongPassword {
    private final int minimumNumberOfDigits;
    private final int minimumNumberOfCapitalLetters;
    private final int minimumNumberOfSpecialCharacters;
    private final int minimumLength;
    private int length;
    private int numberOfDigits;
    private int numberOfSpecialCharacters;
    private int numberOfCapitalLetters;

    private StrongPassword(Builder builder) {
        this.minimumNumberOfDigits = builder.minimumNumberOfDigits;
        this.minimumNumberOfCapitalLetters = builder.minimumNumberOfCapitalLetters;
        this.minimumNumberOfSpecialCharacters = builder.minimumNumberOfSpecialCharacters;
        this.minimumLength = builder.minimumLength;
    }

    public boolean isWeek(String s) {
        final boolean isWeekPassword = (length < minimumLength)
                || (numberOfDigits < minimumNumberOfDigits)
                || (numberOfSpecialCharacters < minimumNumberOfSpecialCharacters)
                || (numberOfCapitalLetters < minimumNumberOfCapitalLetters);
        length++;
        if (Character.isDigit(s.charAt(0))) {
            numberOfDigits++;
        } else if (!Character.isLetter(s.charAt(0))) {
            numberOfSpecialCharacters++;
        } else if (s.equals(s.toUpperCase())) {
            numberOfCapitalLetters++;
        }
        return isWeekPassword;
    }

    public static class Builder {

        private int minimumNumberOfDigits;
        private int minimumNumberOfCapitalLetters;
        private int minimumNumberOfSpecialCharacters;
        private int minimumLength;

        public Builder minimumNumberOfDigits(int minimumNumberOfDigits) {
            this.minimumNumberOfDigits = minimumNumberOfDigits;
            return this;
        }

        public Builder minimumNumberOfCapitalLetters(int minimumNumberOfCapitalLetters) {
            this.minimumNumberOfCapitalLetters = minimumNumberOfCapitalLetters;
            return this;
        }

        public Builder minimumNumberOfSpecialCharacters(int minimumNumberOfSpecialCharacters) {
            this.minimumNumberOfSpecialCharacters = minimumNumberOfSpecialCharacters;
            return this;
        }

        public Builder minimumLength(int minimumLength) {
            this.minimumLength = minimumLength;
            return this;
        }

        public StrongPassword build() {
            return new StrongPassword(this);
        }
    }

}
