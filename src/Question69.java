public class Question69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if(x == 0) return 0;
        int left = 1, right = x, mid, sqrt;

        while(left <= right){
            mid = left + (right - left) / 2;
            sqrt = x / mid;

            if(sqrt == mid)
                return mid;
            else if (sqrt < mid)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return right;
    }
}
