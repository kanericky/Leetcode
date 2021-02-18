import java.util.*;

/**
 * @author kanericky
 * @version 1.0
 */

public class Question721 {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        String[] account1 = new String[]{"John", "johnsmith@mail.com", "john00@mail.com"};
        String[] account2 = new String[]{"John", "johnnybravo@mail.com"};
        String[] account3 = new String[]{"John", "johnsmith@mail.com", "john_newyork@mail.com"};
        String[] account4 = new String[]{"Mary", "mary@mail.com"};
        accounts.add(Arrays.asList(account1));
        accounts.add(Arrays.asList(account2));
        accounts.add(Arrays.asList(account3));
        accounts.add(Arrays.asList(account4));
        System.out.println(accountsMerge(accounts));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();

        //无向图点集边集
        Map<String, List<String>> nodes = new HashMap<>();
        Map<String, Integer> visited = new HashMap<>();

        /**
         * 
         * 根据所给List构建无向图
         */
        for(List<String> account : accounts){
            String masterNode = account.get(1);
            if(account.size() == 2)
                nodes.put(masterNode, new ArrayList<>());

            for(int i = 2; i < account.size(); i++) {
                List<String> edgesOfMasterNode = nodes.getOrDefault(account.get(i), new ArrayList<>());
                edgesOfMasterNode.add(masterNode);
                nodes.put(account.get(i), edgesOfMasterNode);

                List<String> edgesOfOthers = nodes.getOrDefault(masterNode, new ArrayList<>());
                edgesOfOthers.add(account.get(i));
                nodes.put(masterNode, edgesOfOthers);
            }
        }

        /**
         * 遍历无向图
         */
        for(List<String> account : accounts){
            List<String> accountWithoutDuplicate = new ArrayList<>();
            String masterNode = account.get(1);
            if(!visited.containsKey(masterNode)){
                dfs(visited, accountWithoutDuplicate, nodes, masterNode);
            }

            if(accountWithoutDuplicate.size() != 0){
                List<String> accountAns = new ArrayList<>();
                accountAns.add(account.get(0));
                accountAns.addAll(accountWithoutDuplicate);
                Collections.sort(accountAns);
                ans.add(accountAns);
            }
        }
        return ans;
    }

    /**
     * Depth-first-search
     * @param visited a Map which record the node has been visited or not.
     * @param emails a List to store the node.
     * @param nodes collection of nodes
     * @param currentEmail current email to check
     */
    private static void dfs(Map<String, Integer> visited, List<String> emails, Map<String, List<String>> nodes, String currentEmail){

        if(visited.containsKey(currentEmail))
            return;
        visited.put(currentEmail, 1);
        emails.add(currentEmail);

        for(int i = 0; i < nodes.get(currentEmail).size(); i++)
            dfs(visited, emails, nodes, nodes.get(currentEmail).get(i));
    }

    //TODO:使用并查集优化
}
