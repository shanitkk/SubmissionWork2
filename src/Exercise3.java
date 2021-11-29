import java.util.Scanner;

public class Exercise3 {

    final static int MIN_DIGIT_NUMBER = 10;
    final static int MAX_DIGIT_NUMBER = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter phone number");
        String phoneNumFromUser = scanner.nextLine();
        String goodPhoneNum = getGoodPhoneNumber(phoneNumFromUser);
        System.out.println(goodPhoneNum);
    }

    public static String getGoodPhoneNumber(String getPhoneNumber) {
        String newPhoneNum = "   ";

        int length = getPhoneNumber.length();
        if (length >= MIN_DIGIT_NUMBER && length <= MAX_DIGIT_NUMBER) {
            if (sameStart(getPhoneNumber) && length == 11) {
                newPhoneNum = getPhoneNumber;
            } else if (sameStart(getPhoneNumber) && length == MIN_DIGIT_NUMBER) {
                newPhoneNum = addMiddleLine(getPhoneNumber);
            } else if (sameStart(getPhoneNumber) && length == MAX_DIGIT_NUMBER) {
                newPhoneNum = addMiddleLine(changeToZero(getPhoneNumber));
            }
        }
        return newPhoneNum;
    }

    public static boolean onlyNumbers(String phoneNumber) {
        boolean onlyNumbers = false;
        int counter = 0;
        for (int i = 4; i < phoneNumber.length(); i++) {
            counter++;
            if (counter == (phoneNumber.length() - 4))
                System.out.println(counter);
                onlyNumbers = true;
        }
        return onlyNumbers;
    }

    public static boolean sameStart(String string) {
        boolean equals = false;
        String israelAreaCode = "972";
        String zeroFive = "05";
        int counterIsraelAreaCode = 1;
        int counterZeroFive = 1;
        if (string.charAt(0) == israelAreaCode.charAt(0) || string.charAt(0) == zeroFive.charAt(0)) {
            for (int i = 1; i < israelAreaCode.length(); i++) {
                if (israelAreaCode.charAt(i) == string.charAt(i)) {
                    counterIsraelAreaCode++;
                } else if (zeroFive.charAt(i) == string.charAt(i)) {
                    counterZeroFive++;
                }
                if (counterIsraelAreaCode == israelAreaCode.length())
                    equals = true;
                else if (counterZeroFive == zeroFive.length()) {
                    equals = true;
                    break;
                }
            }
        }
        return equals;
    }

    public static String changeToZero(String str) {
        String newStr = "0";
        for (int i = 3; i < str.length(); i++) {
            newStr = newStr + str.charAt(i);
        }
        return newStr;
    }

    public static String addMiddleLine(String PhoneNum) {
        String phoneNunWithLine = "";
        char middleLine = '-';
        for (int i = 0; i < PhoneNum.length(); i++) {
            phoneNunWithLine = phoneNunWithLine + PhoneNum.charAt(i);
            if (i == 2)
                phoneNunWithLine = phoneNunWithLine + middleLine;
        }
        return phoneNunWithLine;
    }
}
