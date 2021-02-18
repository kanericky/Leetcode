package leetcode;

import tools.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kanericky
 * @version 1.0
 */

public class Question257 {
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3= new TreeNode(5);

        node0.left = node1;
        node0.right = node2;
        node1.right = node3;

        System.out.println(binaryTreePaths(node0));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;
        String currentPath = "";
        dfs(root, ans, currentPath);
        return ans;
    }

    private static void dfs(TreeNode currentNode, List<String> ans, String currentPath){
        if(currentNode == null) return;
        currentPath += currentNode.val;
        if(currentNode.right != null || currentNode.left != null)
            currentPath += "->";
            if(currentNode.left != null)
                dfs(currentNode.left, ans, currentPath);
            if(currentNode.right != null)
                dfs(currentNode.right, ans, currentPath);
        if(currentNode.left == null && currentNode.right == null)
            ans.add(currentPath);
    }
}
