import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sentence: ");
        String str = scanner.nextLine();
        System.out.println("Enter the word to search: ");
        String word = scanner.nextLine();
        boolean answer = wordExistsInStr(str, word);
        System.out.println(answer);
    }

    public static boolean wordExistsInStr(String str, String word) {
        boolean answerWordExistsInStr = false;
        int counterLettersInWord = 0;
        int indexWord = 0;
        int indexStr = 0;

        for (int i = 0; i < str.length(); i++) {
            if (word.charAt(indexWord) != str.charAt(indexStr)) {
                indexStr++;
                indexWord = 0;

            } else {
                indexWord++;
                indexStr++;
                counterLettersInWord++;
                if (counterLettersInWord == word.length()) {
                    answerWordExistsInStr = true;
                    break;

                }
            }
        }
        return answerWordExistsInStr;
    }
}