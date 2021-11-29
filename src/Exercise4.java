public class Exercise4 {

    public static void main(String[] args) {
        int[] array = {1, 4, 7, 1, 8, 9, 2, 1, 3, 8, 0};
        int[] newArray = arrayWithoutDuplicates(array);
        for (int i = 0; i <= newArray.length -1 ; i++) {
            System.out.print(newArray[i]+ ",");
        }
    }

    public static int[] arrayWithoutDuplicates(int[] array) {
        int[] newArrayWithoutDuplicates = new int[array.length];
        int[] finalArray;
        int valueInArray;
        int indexArray = 0;
        int counterNumbersInArray = 0;
        for (int i = 0; i < array.length; i++) {
            valueInArray = array[i];
            if (checksDuplicates(newArrayWithoutDuplicates, valueInArray) == false) {
                newArrayWithoutDuplicates[indexArray] = array[i];
                indexArray++;
                counterNumbersInArray++;
            }
        }
        finalArray = new int[counterNumbersInArray + 1];
        for(int j=0; j <= counterNumbersInArray; j++)
        {
            finalArray[j]= newArrayWithoutDuplicates[j];
        }
        return finalArray;
    }


    public static boolean checksDuplicates(int[] newArrayWithoutDuplicates, int valueInArray) {
        int counter = 1;
        boolean answer = false;
        for (int i = 0; i < newArrayWithoutDuplicates.length; i++) {
            if (newArrayWithoutDuplicates[i] == valueInArray) {
                counter++;
            }
        }
        if (counter > 1)
            answer = true;
        return answer;
    }
}