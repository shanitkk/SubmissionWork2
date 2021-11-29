public class Exercise5 {
    public static void main(String[] args) {
        int[] arrayNumbers = {1, 3, 6, 11, 10, 9, 4, 2, 0};
        int indexTop = returnIndexTop(arrayNumbers);
        if (indexTop == -1) {
            System.out.println(indexTop);
        } else {
            System.out.println("The biggest index on the array is: " + indexTop);
        }
    }

    public static int returnIndexTop(int[] arrayNumbers) {
        int indexTop = biggestIndexOnTheArray(arrayNumbers);
        boolean answerIfTheNumberIsIncreasing = isIncreasingNumbers(arrayNumbers, indexTop);
        boolean answerIfTheNumberIsDeclining = isDecliningNumbers(arrayNumbers, indexTop);
        if (answerIfTheNumberIsIncreasing == false || answerIfTheNumberIsDeclining == false) {
            indexTop = -1;
        }
        return indexTop;
    }

    public static int biggestIndexOnTheArray(int[] arrayNumbers) {
        int biggestIndex = 0;
        for (int i = 0; i < (arrayNumbers.length - 1); i++) {
            if ((arrayNumbers[i + 1]) > (arrayNumbers[i])) {
                biggestIndex = i + 1;
            }
        }
        return biggestIndex;
    }

    public static boolean isIncreasingNumbers(int[] arrayNumbers, int theBiggestIndex) {
        boolean increasingNumbers = false;
        int counterUpNumbers = 0;
        for (int i = 0; i < theBiggestIndex; i++) {
            if (arrayNumbers[i + 1] > arrayNumbers[i]) {
                counterUpNumbers++;
            }
        }
        if (counterUpNumbers == theBiggestIndex) {
            increasingNumbers = true;
        }
        return increasingNumbers;
    }

    public static boolean isDecliningNumbers(int[] arrayNumbers, int theBiggestIndex) {
        boolean decliningNumbers = false;
        int counterDownNumbers = 0;
        for (int i = theBiggestIndex; i < arrayNumbers.length - 1; i++) {
            if (arrayNumbers[i + 1] < arrayNumbers[i]) {
                counterDownNumbers++;
            }
        }
        if (counterDownNumbers == arrayNumbers.length - 1 - theBiggestIndex) {
            decliningNumbers = true;
        }
        return decliningNumbers;
    }
}
