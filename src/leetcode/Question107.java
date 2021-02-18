package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kanericky
 * @version 1.0
 */

public class Question107 {
    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        System.out.println(levelOrderBottom(treeNode0));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();

        if(root == null)
            return ans;

        nodes.offer(root);

        while(!nodes.isEmpty() ){
            List<Integer> currentLevel = new ArrayList<>();

            int size = nodes.size();

            for(int i = 0; i < size; i++){
                TreeNode currentNode = nodes.poll();
                if(currentNode == null) break;
                currentLevel.add(currentNode.val);

                if(currentNode.left != null)
                    nodes.offer(currentNode.left);
                if(currentNode.right != null)
                    nodes.offer(currentNode.right);
            }
            ans.add(0, currentLevel);
        }

        return ans;
    }

}
