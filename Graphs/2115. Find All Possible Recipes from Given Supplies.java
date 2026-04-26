/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds all makeable recipes using topological sort on ingredient dependencies, propagating completed recipes as available ingredients for downstream recipes.
/*  "The key insight is that completed recipes become available ingredients — this creates a dependency chain modelled as a DAG. Kahn's topological sort naturally handles this: 
    Start with recipes fully satisfied by supplies, process them, then unlock dependent recipes. Cycle detection is implicit — 
    Recipes in a cycle never reach indegree 0 and never appear in the result." */

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        // available ingredients from initial supplies
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        // adjacency list: ingredient -> list of recipe indices that need it
        Map<String, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n];
        // build dependency graph — only for ingredients not in initial supplies
        for (int i = 0; i < n; i++) {
            for (String ing : ingredients.get(i)) {
                if (!available.contains(ing)) {
                    adj.putIfAbsent(ing, new ArrayList<>());
                    adj.get(ing).add(i);
                    indegree[i]++;
                }
            }
        }
        // topological sort — start with recipes needing no missing ingredients
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0) que.add(i);
        List<String> res = new ArrayList<>();
        while (!que.isEmpty()) {
            int i = que.poll();
            // recipe is now makeable — add to result
            res.add(recipes[i]);
            // this recipe can now satisfy other recipes that need it
            if (adj.containsKey(recipes[i])) {
                for (int idx : adj.get(recipes[i])) {
                    if (--indegree[idx] == 0)
                        que.add(idx);
                }
            }
        }
        return res;
    }
}

// Time Complexity :- O(n * m + S). n recipes, m average ingredients per recipe, s supplies.
// Space Complexity :- O(n * m + S).
