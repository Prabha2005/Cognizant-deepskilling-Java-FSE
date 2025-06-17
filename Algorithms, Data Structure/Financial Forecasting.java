import java.util.Scanner;

public class Main {


    public static double forecast(double presentValue, double rate, int years) {
        if (years == 0) return presentValue;
        return forecast(presentValue, rate, years - 1) * (1 + rate);
    }


    public static double forecastMemo(double presentValue, double rate, int years, double[] memo) {
        if (years == 0) return presentValue;
        if (memo[years] != 0) return memo[years];
        memo[years] = forecastMemo(presentValue, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter present value: ");
        double pv = sc.nextDouble();
        System.out.println("Enter annual growth rate (e.g. 0.1 for 10%): ");
        double r = sc.nextDouble();
        System.out.println("Enter number of years to forecast: ");
        int n = sc.nextInt();

        System.out.println("\nRecursive Forecast: " + forecast(pv, r, n));

        double[] memo = new double[n + 1];
        System.out.println("Memoized Forecast: " + forecastMemo(pv, r, n, memo));
    }
}