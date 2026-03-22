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
        System.out.print("plese type xth fibonacci sequence: ");
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
        
        for (i = 0; i < numb; i++) {
            System.out.printf("%-5d. %-20s\n", i + 1, fib.get(i));
        }
    }


}
