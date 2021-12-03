import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumberMain {
    public static void main(String[] args) {
        //Enter a number
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int givenNum = scanner.nextInt();

        scanner.close();

        //prime numbers less tahn or equal to given number
        for (int i = 2; i <= givenNum; i++) {
            //1은 무조건 아니니, 2부터 prime numbers 구하기
            ArrayList<Integer> primeNums = getPrimeNumbersLessThanEqualTo(i);
            //출력할 문자열 생성하기
            String display = String.format("Prime Numbers less than or equal to %d = %s", i, Arrays.toString(primeNums.toArray()));
            System.out.println(display);
        }
    }

    protected static ArrayList<Integer> getPrimeNumbersLessThanEqualTo(int targetNum) {

        ArrayList<Integer> primes = new ArrayList<Integer>();

        for (int i = 2; i <= targetNum; i++) {
            boolean isPrime = isPrimeNum(i);
            if(isPrime) primes.add(i);
        }

        return primes;
    }

    protected static boolean isPrimeNum(int num) {
        if(num == 1)
            return false;

        if(num == 2)
            return true;

        for (int i = 2; i < num; i++) {
            if(num % i == 0)
                return false;
        }

        return true;
    }
}
