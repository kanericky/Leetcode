public class Question122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,5,127,7}));
    }

    public static int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

}
