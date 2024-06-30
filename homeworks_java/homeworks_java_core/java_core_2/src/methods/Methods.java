package methods;

public class Methods {

    public static int countEvens(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0)
                count++;
        }

        return count;
    }

    public static int range(int... array) {
        //OptionalInt range = OptionalInt.empty();
       int range = 0;
        if (array != null && array.length > 0) {
            int min = array[0];
            int max = min;

            for (int n : array) {
                if (n < min) {
                    min = n;
                } else if (n > max) {
                    max = n;
                }
            }
            range = max - min;
        }

        return range;
    }

    public static boolean twoZeros(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 0 && array[i + 1] == 0) {
                return true;
            }
        }
        return false;
    }
}
