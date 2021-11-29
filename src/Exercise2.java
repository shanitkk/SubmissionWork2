import java.util.Scanner;

public class Exercise2 {
    final static int SIZE_ARRAY = 10;

    public static void main(String[] args) {
        printBiggerThanAverage();
    }

    public static void printBiggerThanAverage() {
        Scanner scanner = new Scanner(System.in);
        int[] numArray = new int[SIZE_ARRAY];
        double average = 0;
        for (int i = 0; i < SIZE_ARRAY; i++) {
            System.out.println("Enter the " + (i + 1) + " number:");
            numArray[i] = scanner.nextInt();
            average = average + numArray[i];
        }
        average = (average / SIZE_ARRAY);
        System.out.println(" The average is: " + average + " ,The numbers are bigger then the average are: ");
        for (int i = 0; i < SIZE_ARRAY; i++) {
            if (numArray[i] > average)
                System.out.print(numArray[i] + " , ");
        }
    }
}