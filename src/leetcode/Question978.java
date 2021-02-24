package leetcode;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question978 {
    public static void main(String[] args) {
        int[] numbers = new int[]{9,4,2,10,7,8,8,1,9};
        System.out.println(maxTurbulenceSize(numbers));
    }

    public static int maxTurbulenceSize(int[] arr) {
        int m = arr.length;
        if(m == 0) return 0;

        int maxUp = 1, maxDown = 1;
        int[] dpUp = new int[m+1];
        int[] dpDown = new int[m+1];

        dpUp[0] = dpDown[0] = 1;

        for(int i = 1; i < m; i++){
            dpUp[i] = dpDown[i] = 1;
            if(arr[i] < arr[i-1]){
                dpUp[i] = dpDown[i-1] + 1;
                if(dpUp[i] > maxUp) {
                    maxUp = dpUp[i];
                }
            }
            if(arr[i] > arr[i-1]){
                dpDown[i] = dpUp[i-1] + 1;
                if(dpDown[i] > maxDown) {
                    maxDown = dpDown[i];
                }
            }
            if(arr[i-1] == arr[i]) {
                dpUp[i] = dpDown[i] = 1;
            }
        }
        return Math.max(maxDown, maxUp);
    }
}
