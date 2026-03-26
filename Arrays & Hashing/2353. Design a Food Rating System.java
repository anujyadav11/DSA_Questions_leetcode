/*********************************************** JAVA **************************************************/

// Optimal Solution - Maintains per-cuisine food rankings using TreeSets with negated ratings, enabling O(log n) updates and O(1) highest-rated queries.
/* "The key trick is storing negative ratings in the TreeSet so first() always returns the highest-rated food. On rating change, I remove the old (-oldRating, food) pair and insert (-newRating, food) — TreeSet handles reordering automatically. 
    This beats a heap since TreeSet supports O(log n) arbitrary removal." */

class FoodRatings {
    // maps food name to its current rating
    private Map<String, Integer> food_rating = new HashMap<>();
    // maps food name to its cuisine type
    private Map<String, String> food_cuisine = new HashMap<>();
    // maps cuisine to a sorted set of (-rating, food) pairs for O(log n) max retrieval
    private Map<String, TreeSet<Pair<Integer, String>>> cuisine_ratings_food = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            // store food's rating and cuisine
            food_rating.put(foods[i], ratings[i]);
            food_cuisine.put(foods[i], cuisines[i]);
            // create TreeSet with comparator: sort by rating asc, then name asc (negated rating = highest first)
            cuisine_ratings_food.computeIfAbsent(cuisines[i], k -> new TreeSet<>((a, b) -> {
                int compareByRating = Integer.compare(a.getKey(), b.getKey());
                // if ratings tie, sort alphabetically by food name
                if (compareByRating == 0)
                    return a.getValue().compareTo(b.getValue());
                return compareByRating;
            // store negative rating so highest rating sits at the front (first()) of TreeSet
            })).add(new Pair<>(-ratings[i], foods[i]));
        }
    }
    public void changeRating(String food, int newRating) {
        String cuisineName = food_cuisine.get(food);
        TreeSet<Pair<Integer, String>> cuisineSet = cuisine_ratings_food.get(cuisineName);
        // remove old entry using negated old rating to match stored key
        Pair<Integer, String> oldElement = new Pair<>(-food_rating.get(food), food);
        cuisineSet.remove(oldElement);
        // update rating in food_rating map
        food_rating.put(food, newRating);
        // insert updated entry with negated new rating
        cuisineSet.add(new Pair<>(-newRating, food));
    }
    public String highestRated(String cuisine) {
        // first() returns smallest key = most negative = highest actual rating
        Pair<Integer, String> highestRated = cuisine_ratings_food.get(cuisine).first();
        // return just the food name
        return highestRated.getValue();
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).
