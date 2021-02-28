package leetcode;

import tools.TreeNode;

/**
 * @author kanericky
 */
public class Question437 {
    public static void main(String[] args) {

    }

    public static int pathSum(TreeNode root, int sum) {
        return root == null ? 0 : check(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static int check(TreeNode root, int sum){
        if(root == null) return 0;

        int counter = root.val == sum ? 1 : 0;

        counter += check(root.left, sum - root.val);
        counter += check(root.right, sum - root.val);

        return counter;
    }
}
