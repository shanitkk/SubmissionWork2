public class Exercise6 {

    public static void main(String[] args) {
        int[] array1 = {3,9,1,10,2,10,5};
        int[] array2 = {1,23,4,10,5,7,5,1,100,7};

        boolean answer = strangersArray(array1,array2);
        System.out.println(answer);

        int[] intersectionArray = getIntersectionArray(array1, array2);
        System.out.print("the intersection array is: ");
        for (int i = 0; i < intersectionArray.length; i++)
            System.out.print(intersectionArray[i] + " ,");
    }

    public static int[] getIntersectionArray(int[] array1, int[] array2) {
        int arrayLength;
        if (array1.length <= array2.length) {
            arrayLength = array1.length;
        } else {
            arrayLength = array2.length;
        }
        int[] intersectionArrayWithZero = new int[arrayLength];
        int indexIntersectionArray = 0;
        for (int k = 0; k < array1.length; k++) {
            for (int i = 0; i < array2.length; i++) {
                {
                    if (array2[i] == array1[k]) {
                        if (checksDuplicatesInTheNewArray(intersectionArrayWithZero, array2[i]) == false) {
                            intersectionArrayWithZero[indexIntersectionArray] = array2[i];
                            indexIntersectionArray++;
                        }
                    }
                }
            }
        }
        int indexValueIsZero = 0;
        for (int i = 0; i < intersectionArrayWithZero.length; i++) {
            if (intersectionArrayWithZero[i] == 0) {
                indexValueIsZero = i;
                break;
            }
        }

        int[] intersectionArray = new int[indexValueIsZero];
        for (int i = 0; i < intersectionArray.length; i++) {
            intersectionArray[i] = intersectionArrayWithZero[i];
        }

        return intersectionArray;
    }

    public static boolean checksDuplicatesInTheNewArray(int[] newArrayWithoutDuplicates, int valueInArray) {
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

    public static boolean strangersArray(int[] array1, int[] array2) {
        boolean isStrangersArrays = false;
        int[] intersectionArray = getIntersectionArray(array1, array2);
        if (intersectionArray[0] == 0)
            isStrangersArrays = true;

            return isStrangersArrays;
    }

}
