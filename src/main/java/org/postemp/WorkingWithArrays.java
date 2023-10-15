package org.postemp;

import java.util.Arrays;

public class WorkingWithArrays {
    public static void main(String[] args) {
        WorkingWithArrays workingWithArrays = new WorkingWithArrays();
//        int[] inputArray = new int[]{1, 2, 2, 2, 2};
//        int[] inputArray = new int[]{1, 2, 1, 2, 1};
//        int[] inputArray = new int[]{1, 2, 1, 1, 2};
//        int[] inputArray = new int[]{1, 2, 1, 2, 2};
//        int[] inputArray = new int[]{1, 3, 2, 2};
        int[] inputArray = new int[]{2, 2, 2};
//        int[] inputArray = new int[0];
//        System.out.println("входной массив состоит только из 1 и 2 : "+ workingWithArrays.checkArray(inputArray));
        System.out.println(Arrays.toString(workingWithArrays.processArray(inputArray)));
    }

    public  int[] processArray(int[] inputArray) {
        int foundIndex = -1;
        for (int i = inputArray.length-1; i >= 0; i--) {
            if (inputArray[i] == 1) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1) {
            throw new RuntimeException("Так и не встретили единичку :(");
        }
        int[] outArray = new int[inputArray.length-1 - foundIndex];
        int cntr = 0;
        for (int i = foundIndex+1; i < inputArray.length; i++) {
            outArray[cntr] = inputArray[i];
            cntr++;
        }
        return outArray;
    }
    public  boolean checkArray(int[] inputArray) {
        boolean itHas1 = false;
        boolean itHas2 = false;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == 1) {
                itHas1 = true;
            } else if (inputArray[i] == 2) {
                itHas2 = true;
            } else {
                return false;
            }
        }
        return itHas1 && itHas2;
    }

}
