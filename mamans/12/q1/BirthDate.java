package avivn.mmn12.q1;

/**
 * Represents an employee's birthdate
 * @author Aviv Naaman
 */
public class BirthDate {
    // day, month and year properties
    private int day = 1;
    private int month = 1;
    private int year = 1;

    // lookup table for max day num per month
    private static final int[] monthDaysCount = {
            31, 28, 31, 30,
            31, 30, 31, 31,
            30, 31, 30, 31
    };

    /**
     * Creates a new birth date instance, leaving invalid values as 1.
     *
     * @param day   The birth date's day of month
     * @param month The birth date's month
     * @param year  The birth date's year
     */
    public BirthDate(int day, int month, int year) {
        this.year = year;
        // check month validity
        if (month >= 1 && month <= 12) {
            this.month = month;
        }
        else {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }
        // check day validity for month & year
        if (checkDay(day)) {
            this.day = day;
        }
        else {
            throw new IllegalArgumentException(
                    String.format("Day must be legal for the month %d and year %d", month, year));
        }
    }

    /**
     * Checks whether day of month is valid for current month and year.
     *
     * @param day The new value to check
     * @return Whether the new value is valid
     */
    private boolean checkDay(int day) {
        // leap year
        if (year % 4 == 0 && month == 2) {
            return day >= 1 && day <= 29;
        }
        // normal year
        else {
            return day >= 1 && day <= monthDaysCount[month-1];
        }
    }

    /**
     * @return This date's day of month
     */
    public int getDay() {
        return day;
    }

    /**
     * @return This date's month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @return This date's year
     */
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
