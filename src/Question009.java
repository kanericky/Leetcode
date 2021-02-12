/**
 * @author kanericky
 * @version 1.0
 */

public class Question009 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0) return false;

        String number = String.valueOf(x);

        int leftIndex = 0, rightIndex = number.length() - 1;

        while(leftIndex <= rightIndex) if (number.charAt(++leftIndex) != number.charAt(--rightIndex)) return false;

        return true;
    }

}
