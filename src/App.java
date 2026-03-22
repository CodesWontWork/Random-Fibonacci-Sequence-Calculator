import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int numb = 0;
        numb = ask(numb);
        fibb(numb);
    }

    public static int ask(int numb) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please type x amount of the Fibonacci sequence: ");
        numb = sc.nextInt();
        return numb;
    }

    public static void fibb(int numb) {
        ArrayList<BigInteger> fib = new ArrayList<>();
        fib.add(BigInteger.ONE);
        fib.add(BigInteger.ONE);
        int i;
        for (i = 2; i < (numb + 2); i++) {
            fib.add(fib.get(i - 1).add(fib.get(i - 2)));
        }

        System.out.printf("%-10s %-50s %-20s\n", "Index", "Fibonacci", "Ratio");
        for (i = 0; i < numb; i++) {
            String ratio = "-";
            if (i > 0) {
                ratio = String.format("%.15f", fib.get(i).doubleValue() / fib.get(i - 1).doubleValue());
            }
            System.out.printf("%-10d %-50s %-20s\n", i + 1, fib.get(i), ratio);
        }
    }
}