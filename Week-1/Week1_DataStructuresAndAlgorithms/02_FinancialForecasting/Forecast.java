import java.util.Scanner;

public class Forecast {

    public static double predictFutureValue(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return predictFutureValue(presentValue * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter present value: ");
        double present = scanner.nextDouble();

        System.out.print("Enter annual growth rate (in %): ");
        double ratePercent = scanner.nextDouble();
        double growthRate = ratePercent / 100;

        System.out.print("Enter number of years: ");
        int numYears = scanner.nextInt();

        double futureValue = predictFutureValue(present, growthRate, numYears);

        System.out.printf("Future value after %d years: %.2f%n", numYears, futureValue);
    }
}
