package leetcode;

import tools.TreeNode;

/**
 * @author kanericky
 */

public class Question104 {

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
