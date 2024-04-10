import java.time.LocalDate;
import java.time.YearMonth;

public class Test2 {

    public static void main(String[] args) {
        // Step 1: Determine the approximate year (Y) and the month prediction (M)
        // of the lunar eclipse in the Hijri calendar.


        // Step 2: Determine Time Zone (TZ)
        String timeZone = "WIB"; // Example time zone
        int timeZoneValue = determineTimeZone(timeZone);

        // Step 3: Calculate the Hijri Year (Y) on the date when the eclipse is predicted to occur.
        int monthsPassed = LocalDate.now().getDayOfMonth(); // Example months passed
        int year = (Y - 1420.75) * 12 - 0.5; // Example year
        int monthPrediction = 4; // Example month prediction
        YearMonth hijriDate = YearMonth.of(year, monthPrediction);
        double estimatedYear = calculateEstimatedYear(year, monthsPassed);
        double Y = estimatedYear;
        // Step 4: Calculate the value of K
        double k = calculateK(estimatedYear);

        // Step 5: Calculate the value of T
        double t = calculateT(k);

        // Step 6: Calculate Julian Day Ephemeris (JDE)
        double jde = calculateJDE(k, t);

        // Step 7: Calculate Sun’s mean anomaly (M)
        double sunMeanAnomaly = calculateSunMeanAnomaly(k, t);

        // Step 8: Calculate the Moon’s mean anomaly (M’)
        double moonMeanAnomaly = calculateMoonMeanAnomaly(k, t);

        // Step 9: Calculate the astronomical longitude of the Moon from the ascending node (Ω)
        double astronomicalLongitude = calculateAstronomicalLongitude(k, t);

        // Step 10: Calculate the argument value for the latitude of the Moon (F)
        double argumentLatitude = calculateArgumentLatitude(k, t, astronomicalLongitude);

        // Step 11: Determine the probability of an eclipse (Imkan)
        String imkan = determineEclipseProbability(argumentLatitude);

        // Step 12: Calculate the eccentricity value of the Earth's orbit around the Sun (E)
        double eccentricity = calculateEccentricity(t);

        // Step 13: Calculate the value of A
        double a = calculateA(k, t);

        // Step 14: Calculate corrections to find out the middle of the eclipse (C)
        double c = calculateCorrections();

        // Step 15: Calculate JDE TD (Julian Day Ephemeris date) and JDE WD (Julian date adjusted to the time of the area)
        double jdeTD = calculateJDE_TD(jde, a, c);
        double jdeWD = calculateJDE_WD(jdeTD, timeZoneValue);

        // Step 16: Calculate Greenwich Mean Time (GMT) and the time of the area (WD)
        double gmt = calculateGMT(jdeTD);
        double wd = calculateWD(jdeWD);

        // Step 17: Calculate the value of Z
        int z = calculateZ(jdeWD);

        // Step 18: Calculate the value of α
        int alpha = calculateAlpha(z);

        // Step 19: Calculate the value of A
        int a2 = calculateA(z, alpha);

        // Step 20: Calculate the value of B
        int b = calculateB(a2);

        // Step 21: Calculate the value of C
        int cValue = calculateC(b);

        // Step 22: Calculate the value of D
        int d = calculateD(cValue);

        // Step 23: Calculate the value of E
        int eValue = calculateE(b, d);

        // Step 24: Determine the date of the lunar eclipse (TGL)
        int tgl = calculateDateLunarEclipse(b, d, eValue);

        // Step 25: Determine the month of the lunar eclipse (BLN)
        int bln = calculateMonthLunarEclipse(eValue);

        // Step 26: Determine the year of the lunar eclipse (THN)
        int thn = calculateYearLunarEclipse(eValue, cValue);

        // Step 27: Determine the days when the eclipse occurs (HA)
        double ha = calculateHA(z);

        // Step 28: Determine the pasaran when the eclipse occurs (Pa)
        double pa = calculatePa(z);

        // Step 29: Calculate the value of P
        double p = calculateP(sunMeanAnomaly, moonMeanAnomaly, argumentLatitude, eccentricity, t);

        // Step 30: Calculate the latitude of the month (Q)
        double q = calculateQ(sunMeanAnomaly, moonMeanAnomaly, argumentLatitude, eccentricity);

        // Step 31: Calculate the value of the magnitude of the month (U)
        double u = calculateU(sunMeanAnomaly, moonMeanAnomaly);

        // Step 32: Calculate the value of W
        double w = calculateW(argumentLatitude);

        // Step 33: Calculate the value of Y
        double y = calculateY(p, q, w);

        // Step 34: Calculate the value of h
        double h = calculateH(u);

        // Step 35: Calculate the value of p
        double pValue = calculatePValue(u);

        // Step 36: Calculate the value of t
        double tValue = calculateTValue(u);

        // Step 37: Calculate the value of n
        double n = calculateN(moonMeanAnomaly);

        // Step 38: Calculate the Magnitude of the Eclipse
        double magnitude = calculateMagnitude(h, pValue, tValue);

        // Step 39: Calculate the semi duration of the penumbra phase (TP)
        double tp = calculateTP(h, y, n);

        // Step 40: Calculate the semi duration of the partial umbra phase (TU)
        double tu = calculateTU(pValue, y, n);

        // Step 41: Calculate the semi duration of the total umbra phase (TT)
        double tt = calculateTT(tValue, y, n);

        // Step 42: Determine the type of eclipse (TE)
        String eclipseType = determineEclipseType(magnitude, tp, tu, tt);

        // Step 43: Calculate the Duration of the Penumbra Phase (DP)
        double dp = calculateDP(tp);

        // Step 44: Calculate the Duration of the Umbra Phase (DU)
        double du = calculateDU(tu);

        // Step 45: Calculate the Duration of the Total Umbra Phase (DT)
        double dt = calculateDT(tt);

        // Output the results
        System.out.println("Year: " + year);
        System.out.println("Month Prediction: " + monthPrediction);
        System.out.println("Time Zone: " + timeZone);
        System.out.println("Estimated Year: " + estimatedYear);
        System.out.println("K: " + k);
        System.out.println("T: " + t);
        System.out.println("JDE: " + jde);
        System.out.println("Sun's Mean Anomaly: " + sunMeanAnomaly);
        System.out.println("Moon's Mean Anomaly: " + moonMeanAnomaly);
        System.out.println("Astronomical Longitude: " + astronomicalLongitude);
        System.out.println("Argument Latitude: " + argumentLatitude);
        System.out.println("Imkan: " + imkan);
        System.out.println("Eccentricity: " + eccentricity);
        System.out.println("A: " + a);
        System.out.println("C: " + c);
        System.out.println("JDE TD: " + jdeTD);
        System.out.println("JDE WD: " + jdeWD);
        System.out.println("GMT: " + gmt);
        System.out.println("WD: " + wd);
        System.out.println("Z: " + z);
        System.out.println("Alpha: " + alpha);
        System.out.println("A2: " + a2);
        System.out.println("B: " + b);
        System.out.println("C Value: " + cValue);
        System.out.println("D: " + d);
        System.out.println("E Value: " + eValue);
        System.out.println("TGL: " + tgl);
        System.out.println("BLN: " + bln);
        System.out.println("THN: " + thn);
        System.out.println("HA: " + ha);
        System.out.println("Pa: " + pa);
        System.out.println("P: " + p);
        System.out.println("Q: " + q);
        System.out.println("U: " + u);
        System.out.println("W: " + w);
        System.out.println("Y: " + y);
        System.out.println("H: " + h);
        System.out.println("P Value: " + pValue);
        System.out.println("T Value: " + tValue);
        System.out.println("N: " + n);
        System.out.println("Magnitude: " + magnitude);
        System.out.println("TP: " + tp);
        System.out.println("TU: " + tu);
        System.out.println("TT: " + tt);
        System.out.println("Eclipse Type: " + eclipseType);
        System.out.println("DP: " + dp);
        System.out.println("DU: " + du);
        System.out.println("DT: " + dt);
    }

    // Step 2: Determine Time Zone (TZ)
    public static int determineTimeZone(String timeZone) {
        switch (timeZone) {
            case "WIB":
                return 7;
            case "WITA":
                return 8;
            case "WIT":
                return 9;
            default:
                return 0; // Default to 0 if the time zone is not recognized
        }
    }

    // Step 3: Calculating the Hijri Year (Y) on the date when the eclipse is predicted to occur
    public static double calculateEstimatedYear(int year, int monthsPassed) {
        return year + (double) monthsPassed / 12;
    }

    // Step 4: Calculate the value of K
    public static double calculateK(double estimatedYear) {
        return (estimatedYear - 1420.75) * 12 - 0.5;
    }

    // Step 5: Calculate the value of T
    public static double calculateT(double k) {
        return k / 1236.85;
    }

    // Step 6: Calculate Julian Day Ephemeris (JDE)
    public static double calculateJDE(double k, double t) {
        return 2451550.09766 + 29.530588861 * k + 0.00015437 * Math.pow(t, 2) - 0.00000015 * Math.pow(t, 3) + 0.00000000073 * Math.pow(t, 4);
    }

    // Step 7: Calculate Sun’s mean anomaly (M)
    public static double calculateSunMeanAnomaly(double k, double t) {
        return 2.5534 + 29.1053567 * k - 0.0000014 * Math.pow(t, 2) - 0.00000011 * Math.pow(t, 3);
    }

    // Step 8: Calculate the Moon’s mean anomaly (M’)
    public static double calculateMoonMeanAnomaly(double k, double t) {
        return 201.5643 + 385.81693528 * k + 0.0107582 * Math.pow(t, 2) + 0.00001238 * Math.pow(t, 3) - 0.000000058 * Math.pow(t, 4);
    }

    // Step 9: Calculate the astronomical longitude of the Moon from the ascending node (omega/Ω)
    public static double calculateAstronomicalLongitude(double k, double t) {
        return 124.7746 - 1.56375588 * k + 0.0020672 * Math.pow(t, 2) + 0.00000215 * Math.pow(t, 3);
    }

    // Step 10: Calculate the argument value for the latitude of the Moon (F)
    public static double calculateArgumentLatitude(double k, double t, double astronomicalLongitude) {
        double sinOmega = Math.sin(Math.toRadians(astronomicalLongitude));
        return 160.7108 + 390.67050284 * k - 0.0016118 * Math.pow(t, 2) - 0.00000227 * Math.pow(t, 3) + 0.000000011 * Math.pow(t, 4) - 0.026665 * sinOmega;
    }

    // Step 11: Determine the probability of an eclipse
    public static String determineEclipseProbability(double argumentLatitude) {
        if (Math.abs(Math.sin(Math.toRadians(argumentLatitude))) < 0.3588) {
            return "M";
        } else {
            return "T";
        }
    }

    // Step 12: Calculate the eccentricity value of the Earth's orbit around the Sun (E)
    public static double calculateEccentricity(double t) {
        return 1 - 0.002561 * t - 0.0000074 * Math.pow(t, 2);
    }

    // Step 13: Calculate the value of A
    public static double calculateA(double k, double t) {
        return 0.0003 * Math.sin(Math.toRadians(299.77 + 0.107408 * k - 0.009173 * Math.pow(t, 2)));
    }

    // Step 14: Calculate corrections to find out the middle of the eclipse (C)
    public static double calculateCorrections() {

            double M = 0.0; // M is assumed to be provided
            double E = 0.0; // E is assumed to be provided
            double F = 0.0; // F is assumed to be provided
            double omega = 0.0; // Omega is assumed to be provided

            // Calculate corrections
            double C1 = -0.4065 * Math.sin(Math.toRadians(M));
            double C2 = 0.1727 * E * Math.sin(Math.toRadians(M));
            double C3 = 0.0161 * Math.sin(Math.toRadians(2 * M));
            double C4 = 0.0097 * Math.sin(Math.toRadians(2 * F));
            double C5 = 0.0073 * E * Math.sin(Math.toRadians(M - M));
            double C6 = -0.0050 * E * Math.sin(Math.toRadians(M + M));
            double C7 = -0.0023 * Math.sin(Math.toRadians(M - 2 * F));
            double C8 = 0.0021 * E * Math.sin(Math.toRadians(2 * M));
            double C9 = 0.0012 * Math.sin(Math.toRadians(M + 2 * F));
            double C10 = 0.0006 * E * Math.sin(Math.toRadians(2 * M + M));
            double C11 = -0.0004 * Math.sin(Math.toRadians(3 * M));
            double C12 = -0.0003 * E * Math.sin(Math.toRadians(M + 2 * F));
            double C13 = -0.0002 * E * Math.sin(Math.toRadians(M - 2 * F));
            double C14 = -0.0002 * E * Math.sin(Math.toRadians(2 * M - M));
            double C15 = -0.0002 * Math.sin(Math.toRadians(omega));

            // Calculate C
            double C = C1 + C2 + C3 + C4 + C5 + C6 + C7 + C8 + C9 + C10 + C11 + C12 + C13 + C14 + C15;

            System.out.println("The correction value C is: " + C);
            return  C;
    }

    // Step 15: Calculate JDE TD (Julian Day Ephemeris date) and JDE WD (Julian date adjusted to the time of the area)
    public static double calculateJDE_TD(double jde, double a, double c) {
        return jde + a + c;
    }

    // Step 16: Calculate Greenwich Mean Time (GMT) and the time of the area (WD)
    public static double calculateGMT(double jdeTD) {
        return jdeTD - 2451545.0;
    }

    // Step 17: Calculate the value of Z
    public static int calculateZ(double jdeWD) {
        return (int) Math.floor(jdeWD);
    }

    // Step 18: Calculate the value of alpha
    public static int calculateAlpha(int z) {
        return z % 7;
    }

    // Step 19: Calculate the value of A
    public static int calculateA(int z, int alpha) {
        return (z - alpha) / 7;
    }

    // Step 20: Calculate the value of B
    public static int calculateB(int a2) {
        return a2 + 1;
    }

    // Step 21: Calculate the value of C
    public static int calculateC(int b) {
        return b + 354;
    }

    // Step 22: Calculate the value of D
    public static int calculateD(int cValue) {
        return (int) (cValue * 1.25);
    }

    // Step 23: Calculate the value of E
    public static int calculateE(int b, int d) {
        return (11 * b + 14) - d;
    }

    // Step 24: Determine the date of the lunar eclipse (TGL)
    public static int calculateDateLunarEclipse(int b, int d, int eValue) {
        if (eValue > 30) {
            return eValue - 30;
        } else {
            return eValue;
        }
    }

    // Step 25: Determine the month of the lunar eclipse (BLN)
    public static int calculateMonthLunarEclipse(int eValue) {
        if (eValue > 30) {
            return 12;
        } else {
            return 11;
        }
    }

    // Step 26: Determine the year of the lunar eclipse (THN)
    public static int calculateYearLunarEclipse(int eValue, int cValue) {
        if (eValue > 30) {
            return cValue + 1;
        } else {
            return cValue;
        }
    }

    // Step 27: Determine the days when the eclipse occurs (HA)
    public static double calculateHA(int z) {
        return 8.0855 + 0.00025 * z;
    }

    // Step 28: Determine the pasaran when the eclipse occurs (Pa)
    public static double calculatePa(int z) {
        return 24.284 + 0.000206 * z;
    }

    // Step 29: Calculate the value of P
    public static double calculateP(double sunMeanAnomaly, double moonMeanAnomaly, double argumentLatitude, double eccentricity, double t) {
        return 1 - 0.0048 * Math.cos(Math.toRadians(sunMeanAnomaly)) - 0.0007 * Math.cos(Math.toRadians(2 * moonMeanAnomaly)) + 0.0003 * Math.cos(Math.toRadians(2 * argumentLatitude)) - 0.0004 * Math.cos(Math.toRadians(3 * argumentLatitude)) - 0.0003 * Math.cos(Math.toRadians(sunMeanAnomaly + (double) 44 / 3)) - 0.0006 * Math.cos(Math.toRadians(sunMeanAnomaly + (double) 88 / 3)) + eccentricity * (0.0028 - 0.0004 * Math.cos(Math.toRadians(sunMeanAnomaly)) - 0.0004 * Math.cos(Math.toRadians(2 * moonMeanAnomaly)));
    }

    // Step 30: Calculate the latitude of the month (Q)
    public static double calculateQ(double sunMeanAnomaly, double moonMeanAnomaly, double argumentLatitude, double eccentricity) {
        return 0.207 - 0.001 * Math.cos(Math.toRadians(sunMeanAnomaly)) + 0.002 * Math.cos(Math.toRadians(2 * moonMeanAnomaly)) - 0.002 * Math.cos(Math.toRadians(2 * argumentLatitude)) + 0.002 * Math.cos(Math.toRadians(3 * argumentLatitude)) + eccentricity * (0.0034 - 0.0006 * Math.cos(Math.toRadians(sunMeanAnomaly)) - 0.0006 * Math.cos(Math.toRadians(2 * moonMeanAnomaly)));
    }

    // Step 31: Calculate the value of the magnitude of the month (U)
    public static double calculateU(double sunMeanAnomaly, double moonMeanAnomaly) {
        return 0.0034 - 0.0006 * Math.cos(Math.toRadians(sunMeanAnomaly)) - 0.0006 * Math.cos(Math.toRadians(2 * moonMeanAnomaly));
    }

    // Step 32: Calculate the value of W
    public static double calculateW(double argumentLatitude) {
        return 0.0034 - 0.0006 * Math.cos(Math.toRadians(2 * argumentLatitude));
    }

    // Step 33: Calculate the value of Y
    public static double calculateY(double p, double q, double w) {
        return 0.1428 * Math.sin(Math.toRadians(p)) - 0.0325 * Math.sin(Math.toRadians(q)) + 0.0095 * Math.sin(Math.toRadians(2 * w));
    }

    // Step 34: Calculate the value of h
    public static double calculateH(double u) {
        return Math.abs(u - 1);
    }

    // Step 35: Calculate the value of p
    public static double calculatePValue(double u) {
        return 1 - Math.abs(u);
    }

    // Step 36: Calculate the value of t
    public static double calculateTValue(double u) {
        return 1 - Math.abs(u);
    }

    // Step 37: Calculate the value of n
    public static double calculateN(double moonMeanAnomaly) {
        return 0.0047 + 0.0005 * Math.cos(Math.toRadians(moonMeanAnomaly));
    }

    // Step 38: Calculate the Magnitude of the Eclipse
    public static double calculateMagnitude(double h, double pValue, double tValue) {
        return h * pValue * tValue;
    }

    // Step 39: Calculate the semi duration of the penumbra phase (TP)
    public static double calculateTP(double h, double y, double n) {
        return (2 * h - y) / (2 * n);
    }

    // Step 40: Calculate the semi duration of the partial umbra phase (TU)
    public static double calculateTU(double pValue, double y, double n) {
        return (pValue - y) / (2 * n);
    }

    // Step 41: Calculate the semi duration of the total umbra phase (TT)
    public static double calculateTT(double tValue, double y, double n) {
        return (2 * tValue - y) / (2 * n);
    }

    // Step 42: Determine the type of eclipse (TE)
    public static String determineEclipseType(double magnitude, double tp, double tu, double tt) {
        if (magnitude < 0.7) {
            if (tp > 1.5) {
                return "Penumbral";
            } else if (tu > 1.5) {
                return "Partial";
            } else {
                return "Total";
            }
        } else if (magnitude < 1.0) {
            if (tp > 1.5) {
                return "Penumbral and Partial";
            } else {
                return "Partial and Total";
            }
        } else {
            return "Total";
        }
    }

    // Step 43: Calculate the Duration of the Penumbra Phase (DP)
    public static double calculateDP(double tp) {
        return 2 * tp;
    }

    // Step 44: Calculate the Duration of the Umbra Phase (DU)
    public static double calculateDU(double tu) {
        return 2 * tu;
    }

    // Step 45: Calculate the Duration of the Total Umbra Phase (DT)
    public static double calculateDT(double tt) {
        return 2 * tt;
    }
    public static double calculateJDE_WD(double jdeTD, int timeZone) {
        return jdeTD + timeZone / 24.0;
    }
    // Step 16: Calculate the time of the area (WD)
    public static double calculateWD(double jdeWD) {
        return (jdeWD - Math.floor(jdeWD)) * 24;
    }
}
