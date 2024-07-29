package compareArr;

public class CompareArr {

    public static <T> boolean compareArrays(T [] arr, T [] arr2) {
        int count = 0;
        if (arr.length == arr2.length) {
            for (int i = 0; i < arr.length; i++) {
                if (!arr[i].getClass().equals(arr2[i].getClass())) {
                    count = count + 1;
                }
            }
            if (count > 0) {
                return false;
            } else {
                return true;
            }
        }else {
            return  false;
        }
    }
}
