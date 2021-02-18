package leetcode;

import tools.*;

import java.util.LinkedList;
import java.util.Queue;

public class Question559 {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        int level = 0;

        if(root == null) return level;

        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(root);

        while(!nodes.isEmpty()){
            int size = nodes.size();
            for(int i = 0; i < size; i++){
                Node tempNode = nodes.poll();
                if(!tempNode.children.isEmpty()){
                    for(Node node: tempNode.children)
                        nodes.offer(node);
                }
            }
            level++;
        }
        return level;
    }
}
