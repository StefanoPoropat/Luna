import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.DayOfWeek;

class LunarEclipseCalculator {

    // Method to summarize the approximate time of lunar eclipse in the Hijri calendar
    public static String summarizeHijriLunarEclipse(int month, int year) {
        String[] months = {"Muharram", "Ṣafar", "Rabī’ulawwal", "Rabī’uth-thānī", "Jumādā al-ūlā", "Jumādā al-ākhirah",
                "Rajab", "Sha'ban", "Ramaḍān", "Shawwāl", "Ḍū al-Qa'dah", "Ḍū al-Ḥijjah"};
        return months[month - 1] + " " + year;
    }

    // Method to summarize the time of lunar eclipse in the Gregorian calendar
    public static String summarizeGregorianLunarEclipse(int day, int month, int year, boolean isEclipse) {
        if (!isEclipse) {
            return "";
        }
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return day + " " + months[month - 1] + " " + year;
    }

    // Method to summarize the days and pasaran for the lunar eclipse in the Gregorian calendar
    public static String summarizePasaran(int dayOfWeek, int pasaran) {
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String[] pasaranNames = {"Kliwon", "Legi", "Pahing", "Pon", "Wage"};
        if (dayOfWeek == 0) {
            return "Saturday " + pasaranNames[pasaran];
        } else {
            return daysOfWeek[dayOfWeek - 1] + " " + pasaranNames[pasaran];
        }
    }

    // Method to format time as hh:mm:ss
    public static String formatTime(int hours, int minutes, int seconds) {
        DecimalFormat formatter = new DecimalFormat("00");
        return formatter.format(hours) + ":" + formatter.format(minutes) + ":" + formatter.format(seconds);
    }

    // Method to calculate the end time of initial contact of the lunar disc in the penumbra, given parameters
    public static String calculateEndTimePenumbra(boolean isEclipse, int wd, int tp) {
        if (!isEclipse) {
            return "";
        }
        int hours = (wd + tp > 24) ? (wd + tp - 24) : (wd + tp);
        return formatTime(hours, 0, 0);
    }

    // Method to calculate the end time of initial contact of the lunar disc at the umbra
    public static String calculateEndTimeUmbra(boolean isEclipse, String te, int wd, int tu) {
        if (!isEclipse || te.equals("Penumbra")) {
            return "";
        }
        int hours = (wd + tu > 24) ? (wd + tu - 24) : (wd + tu);
        return formatTime(hours, 0, 0);
    }

    // Method to calculate the end time of initial contact of the lunar disc in total eclipse
    public static String calculateEndTimeTotal(boolean isEclipse, String te, int wd, int tt) {
        if (!isEclipse || !te.equals("Total")) {
            return "";
        }
        int hours = (wd + tt > 24) ? (wd + tt - 24) : (wd + tt);
        return formatTime(hours, 0, 0);
    }

    // Method to calculate the time of the greatest eclipse
    public static String calculateGreatestEclipse(boolean isEclipse, int wd) {
        if (!isEclipse) {
            return "";
        }
        return formatTime(wd, 0, 0);
    }

    // Method to calculate the end time when the lunar disc contact ends in a total eclipse
    public static String calculateEndTimeTotalEclipse(boolean isEclipse, String te, int wd, int tt) {
        if (!isEclipse || !te.equals("Total")) {
            return "";
        }
        int hours = (wd + tt > 24) ? (wd + tt - 24) : (wd + tt);
        return formatTime(hours, 0, 0);
    }

    // Method to summarize the value of gamma
    public static String summarizeGamma(boolean isEclipse, String te, int y) {
        if (!isEclipse) {
            return "";
        }
        return String.valueOf(y);
    }

    // Method to summarize the value of the magnitude of the penumbra
    public static String summarizeMagnitudePenumbra(boolean isEclipse, int mp) {
        if (!isEclipse || mp <= 0) {
            return "";
        }
        return String.valueOf(mp);
    }

    // Method to summarize the value of umbra magnitude
    public static String summarizeMagnitudeUmbra(boolean isEclipse, int mu) {
        if (!isEclipse || mu <= 0) {
            return "";
        }
        return String.valueOf(mu);
    }

    // Method to summarize the type of eclipse
    public static String summarizeEclipseType(String te) {
        return te;
    }

    // Method to summarize the duration of the penumbra
    public static String summarizeDurationPenumbra(boolean isEclipse, int dp) {
        if (!isEclipse) {
            return "";
        }
        return String.valueOf(dp);
    }

    // Method to summarize the umbra duration
    public static String summarizeDurationUmbra(boolean isEclipse, String jg, int du) {
        if (!isEclipse || jg.equals("Penumbra")) {
            return "";
        }
        return String.valueOf(du);
    }

    // Method to summarize the total duration
    public static String summarizeTotalDuration(boolean isEclipse, String jg, int dt) {
        if (!isEclipse || !jg.equals("Total")) {
            return "";
        }
        return String.valueOf(dt);
    }
}

public class Main {
    public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        int currentDayOfMonth = currentDate.getDayOfMonth();
        int currentMonthValue = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();

        // Get the day of the week
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();
        int currentDayOfWeekValue = currentDayOfWeek.getValue(); // 1 for Monday, 2 for Tuesday, ..., 7 for Sunday

        // Display the retrieved device information
        System.out.println("Device Information:");
        System.out.println("Current Date: " + currentDate);
        System.out.println("Day of the Month: " + currentDayOfMonth);
        System.out.println("Month: " + currentMonthValue);
        System.out.println("Year: " + currentYear);
        System.out.println("Day of the Week: " + currentDayOfWeek);
        System.out.println("Day of the Week (Value): " + currentDayOfWeekValue);

        // Example usage of Lunar Eclipse Calculator methods with real device data
        System.out.println("\nLunar Eclipse Calculator:");
        System.out.println("1. Hijri Date: " + LunarEclipseCalculator.summarizeHijriLunarEclipse(4, 1443)); // Example hijri month and year
        System.out.println("2. Gregorian Date: " + LunarEclipseCalculator.summarizeGregorianLunarEclipse(currentDayOfMonth, currentMonthValue, currentYear, true));
        System.out.println("3. Pasaran: " + LunarEclipseCalculator.summarizePasaran(currentDayOfWeekValue, 2)); // Example pasaran value
        System.out.println("4. Time in penumbra: " + LunarEclipseCalculator.formatTime(12, 30, 15)); // Example time values
        System.out.println("5. End time of initial contact of the lunar disc at the umbra: " + LunarEclipseCalculator.calculateEndTimeUmbra(true, "Total", 12, 3)); // Example time values
        System.out.println("6. End time of initial contact of the lunar disc in total eclipse: " + LunarEclipseCalculator.calculateEndTimeTotal(true, "Total", 12, 4)); // Example time values
        System.out.println("7. Time of the greatest eclipse: " + LunarEclipseCalculator.calculateGreatestEclipse(true, 12)); // Example time value
        System.out.println("8. End time when the lunar disc contact ends in a total eclipse: " + LunarEclipseCalculator.calculateEndTimeTotalEclipse(true, "Total", 12, 4)); // Example time values
        System.out.println("9. End time when the lunar disk contact ends in the umbra: " + LunarEclipseCalculator.calculateEndTimeUmbra(true, "Total", 12, 3)); // Example time values
        System.out.println("10. End time when the lunar disk contact ends in the penumbra: " + LunarEclipseCalculator.calculateEndTimePenumbra(true, 12, 2)); // Example time values
        System.out.println("11. Value of gamma: " + LunarEclipseCalculator.summarizeGamma(true, "Total", 5)); // Example value
        System.out.println("12. Value of the magnitude of the penumbra: " + LunarEclipseCalculator.summarizeMagnitudePenumbra(true, 6)); // Example value
        System.out.println("13. Value of umbra magnitude: " + LunarEclipseCalculator.summarizeMagnitudeUmbra(true, 7)); // Example value
        System.out.println("14. Type of eclipse: " + LunarEclipseCalculator.summarizeEclipseType("Total")); // Example eclipse type
        System.out.println("15. Duration of the penumbra: " + LunarEclipseCalculator.summarizeDurationPenumbra(true, 8)); // Example duration value
        System.out.println("16. Umbra duration: " + LunarEclipseCalculator.summarizeDurationUmbra(true, "Total", 9)); // Example duration value
        System.out.println("17. Total duration: " + LunarEclipseCalculator.summarizeTotalDuration(true, "Total", 10)); // Example duration value

        // Printing the date of the eclipse as NO.18
        System.out.println("18. Date of the Eclipse: " + currentDayOfMonth + "/" + currentMonthValue + "/" + currentYear);
    }
}
