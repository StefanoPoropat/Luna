import java.time.LocalDate;

public class Test2 {

    public static void main(String[] args) {
        // Step 1: Determine the approximate year (Y) and the month prediction (M)
        // of the lunar eclipse in the Hijri calendar.


        // Step 2: Determine Time Zone (TZ)
        String timeZone = "WIB"; // Example time zone
        int timeZoneValue = determineTimeZone(timeZone);
        int year = LocalDate.now().getYear();
        double monthsPassed = LocalDate.now().getDayOfMonth();
        double estimatedYear = year + monthsPassed/12;

        double k = (estimatedYear - 1420.75) * 12 - 0.5;
        double t = k / 1236.85;
        double jde = 2451550.09766 + 29.530588861 * k + 0.00015437 * Math.pow(t,2) - 0.00000015 * Math.pow(t,3) + 0.00000000073 * Math.pow(t,4);
        double sunMeanAnomaly = 2.5534 + 29.1053567 * k - 0.0000014 * Math.pow(t,2) - 0.00000011 * Math.pow(t,3);
        double moonMeanAnomaly =  201.5643 + 385.81693528 * k + 0.0107582 * Math.pow(t,2) + 0.00001238 * Math.pow(t,3) - 0.000000058 * Math.pow(t,4);
        double astronomicalLongitude = 124.7746 - 1.56375588 * k + 0.0020672 * Math.pow(t,2) + 0.00000215 * Math.pow(t,3);
        double argumentLatitude = 160.7108 + 390.67050284 * k - 0.0016118 * Math.pow(t,2) - 0.00000227 * Math.pow(t,3) + 0.000000011 * Math.pow(t,4) - 0.026665 * Math.sin(astronomicalLongitude);
        double imkan = Math.abs(Math.sin(Math.toRadians(argumentLatitude)));
        String imkanYN = determineEclipseProbability(argumentLatitude);
        double eccentricity = 1 - 0.002561 * t - 0.0000074 * Math.pow(t,2);
        double a = 0.0003 * Math.sin(299.77 + 0.107408 * k - 0.009173 * Math.pow(t,2));
        double c = calculateCorrections();
        double jdeTD = jde + a + c + 0.5;
        double jdeWD = jdeTD + (double) timeZoneValue /24;
        double gmt = (jdeTD - (int)(jdeWD))*24;
        double wd = (jdeWD - (int)(jdeTD))*24;
        int z = (int)(jdeWD);
        int alpha = (int)((z- 1867216.25) / 36524.25);
        int a2 = calculateA2(z, alpha);
        double b = a2 + 1524;
        int cValue = (int)((b-122.1)/365.25);
        int d = (int)(365.25*cValue);
        int eValue = (int)((b-d)/30.6001);
        double tgl = b-d-(int)(30.6001*eValue);
        int bln = calculateMonthLunarEclipse(eValue);
        double thn = calculateYearLunarEclipse(bln, cValue);
        double ha = Math.ceilMod(z+2, 7);
        double pa = Math.ceilMod(z+1, 5);
        double p1 = 0.2070 * eValue * Math.sin(sunMeanAnomaly);
        double p2 = 0.0024 * eValue * Math.sin(2*sunMeanAnomaly);
        double p3 = -0.0392 * Math.sin(moonMeanAnomaly);
        double p4 = 0.0116 * Math.sin(2*moonMeanAnomaly);
        double p5 = -0.0073 * eValue * Math.sin(moonMeanAnomaly+sunMeanAnomaly);
        double p6 = 0.0067 * eValue * Math.sin(moonMeanAnomaly-sunMeanAnomaly);
        double p7 = 0.0118 * Math.sin(2*argumentLatitude);
        double p = p1 + p2 + p3 + p4 + p5 + p6 + p7;
        double q1 = -0.0048 * eValue * Math.cos(sunMeanAnomaly);
        double q2 = 0.0020 * eValue * Math.cos(2*sunMeanAnomaly);
        double q3 = -0.3299 * moonMeanAnomaly;
        double q4 = -0.0060 * eValue * (moonMeanAnomaly+sunMeanAnomaly);
        double q5 = +0.0041 * eValue * (moonMeanAnomaly-sunMeanAnomaly);
        double q = 5.2207 + q1 + q2 + q3 +q4 + q5;
        double u1 = 0.0046 * eValue * Math.cos(sunMeanAnomaly);
        double u2 = -0.0182 * Math.cos(moonMeanAnomaly);
        double u3 =  0.0004 * Math.cos(2*moonMeanAnomaly);
        double u4 = -0.0005 * Math.cos(sunMeanAnomaly+moonMeanAnomaly);
        double u = 0.0059 + u1 + u2 + u3 + u4;
        double w = Math.abs(Math.cos(Math.toRadians(173.033505)));
        double y = (p*Math.cos(argumentLatitude) + q*Math.sin(argumentLatitude) * (1-0.0048*w));
        double h = 1.5573 + u;
        double pValue = 1.0128 - u;
        double tValue = 0.4678 - u;
        double n = 0.5458+0.04*Math.cos(Math.toRadians(moonMeanAnomaly));
        double mp =  1.9506;
        double mu = 1.0058;
        double tp = Math.sqrt(Math.pow(h,2)-Math.pow(0.4794,2))/n;
        double tu = Math.sqrt(Math.pow(p,2)-Math.pow(0.4794,2))/n;
        double tt = Math.sqrt(Math.pow(t,2)-Math.pow(0.4794,2))/n;
        double magnitude = calculateMagnitude(h, pValue, tValue);
        String te = determineEclipseType(magnitude, tp, tu, tt);
        double dp = tp * 2;
        double du = tu * 2;
        double dt = tt * 2;








        // Output the results
        System.out.println("Curent year: " + year);
        System.out.println("Time zone: " + timeZone);
        System.out.println("Time zone value: " + timeZoneValue);
        System.out.println("Estimated year: " + (int)estimatedYear);
        System.out.println("Estimated month: " + (int)bln);
        System.out.println("Estimated day: " + (int)tgl);
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


    // Step 11: Determine the probability of an eclipse
    public static String determineEclipseProbability(double argumentLatitude) {
        if (Math.abs(Math.sin(Math.toRadians(argumentLatitude))) < 0.3588) {
            return "M";
        } else {
            return "T";
        }
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

    // Step 19: Calculate the value of A
    public static int calculateA2(int z, int alpha) {
        return (z - alpha) / 7;
    }

    // Step 25: Determine the month of the lunar eclipse (BLN)
    public static int calculateMonthLunarEclipse(int eValue) {
        if (eValue >=14) {
            return eValue-13;
        } else {
            return eValue-1;
        }
    }

    // Step 26: Determine the year of the lunar eclipse (THN)
    public static int calculateYearLunarEclipse(int bln, int cValue) {
        if (bln<=2) {
            return cValue - 4715;
        } else {
            return cValue - 4716;
        }
    }

    // Step 38: Calculate the Magnitude of the Eclipse
    public static double calculateMagnitude(double h, double pValue, double tValue) {
        return h * pValue * tValue;
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
}
