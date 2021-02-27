package leetcode;

import tools.TreeNode;

public class Question543 {

    int diameter = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 1;
        diameterCalculator(root);
        return diameter - 1;
    }

    private int diameterCalculator(TreeNode root){
        if(root == null) return 0;

        int left = diameterCalculator(root.left);
        int right = diameterCalculator(root.right);
        diameter = Math.max(left + right, diameter);
        return Math.max(left, right) + 1;
    }

}
