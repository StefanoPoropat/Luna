import java.time.LocalDate;

public class Test {

    public static LocalDate calculateLunarEclipseDate() {
        // Given values
        double tgl = getTgl();
        int e = (int) Math.floor(tgl / 30.6001);
        int month = (e >= 14) ? e - 13 : e + 1;

        // Step 28: Determine the year of the lunar eclipse
        int c = (tgl < 2299161) ? (int) ((tgl - 1867216.25) / 36524.25) : (int) (tgl + 1 + ((tgl - 1867216.25) / 36524.25) - ((tgl - 1867216.25) / 1461.0));
        int yearEclipse = (month <= 2) ? c - 4715 : c - 4716;

        // Ensure the month value is within the valid range
        month = Math.max(1, Math.min(12, month));

        // Ensure the day value is within the valid range
        int day = (int) Math.floor(tgl - 0.5);
        int daysInMonth = LocalDate.of(yearEclipse, month, 1).lengthOfMonth();
        day = Math.max(1, Math.min(daysInMonth, day));

        return LocalDate.of(yearEclipse, month, day);
    }

    private static double getTgl() {
        int year = 1443; // Example year
        int monthPrediction = 5; // Example month prediction
        int tz = 7; // Example timezone WIB = 7

        // Step 3: Calculating the Hijri Year (Y) on the date when the eclipse is predicted to occur
        double estimatedYear = year + ((double) monthPrediction / 12.0);

        // Step 4: Calculating the value of K
        double k = (estimatedYear - 1420.75) * 12 - 0.5;

        // Step 5: Calculating the value of T
        double t = k / 1236.85;

        // Step 6: Calculate the Julian Day Ephemeris (JDE)
        double jde = 2451550.09766 + 29.530588861 * k + 0.00015437 * Math.pow(t, 2) - 0.00000015 * Math.pow(t, 3) + 0.00000000073 * Math.pow(t, 4);

        // Step 16: Calculate the Julian date adjusted to the time of the area (JDE WD)
        double jdeWd = jde + tz / 24.0;

        // Step 27: Determine the month of the lunar eclipse
        return jdeWd - Math.floor(jdeWd) + 1; // Add 1 to adjust the day calculation
    }

    public static void main(String[] args) {
        LocalDate lunarEclipseDate = calculateLunarEclipseDate();
        System.out.println("Date of the Lunar Eclipse: " + lunarEclipseDate);
    }
}
