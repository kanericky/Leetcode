import java.util.ArrayList;
import java.util.Arrays;

/**
 * 129. 求根到叶子节点数字之和
 * 难度 中等
 *
 * AUTHOR: RUIQI ZHANG
 * DATE: 29/10/2020
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 */

public class Question129 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        a.left = new TreeNode(9);
        a.right = new TreeNode(0);
        a.left.left = new TreeNode(5);
        a.left.right = new TreeNode(1);
        int num = sumNumbers(a);
        System.out.println(num);
    }

    // 100 * 4 + 10 * 9 + 1 * 5
    public static int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;

        return dfs(root, 0);
    }

    // Use dfs to visit the node, calculate when dfs is applied to the next node... if there is a leaf, then return the sum...
    public static int dfs(TreeNode root, int previousNum){
        if(root == null) return 0;
        int sum = root.val + 10 * previousNum;
        if(root.left == null && root.right == null){
            return sum;
        }else{
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}