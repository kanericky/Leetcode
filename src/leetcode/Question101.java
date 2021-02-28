package leetcode;

import tools.TreeNode;

/**
 * @author kanericky
 */
public class Question101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || check(root.left, root.right);
    }

    public static boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}
