/*********************************************** JAVA **************************************************/

// Optimal Solution - LRU Cache implemented using HashMap and Doubly Linked List for O(1) get and put operations. 
                  // HashMap gives O(1) access, doubly linked list maintains LRU order — combine both to achieve constant-time operations.

/* "The challenge is to support both fast lookup and fast eviction of the least recently used item. A HashMap provides direct access to cache entries in O(1), 
    while a doubly linked list maintains the usage order. Whenever an entry is accessed or updated, it is moved to the front of the list (MRU). When the cache reaches capacity, 
    the node just before the dummy tail (LRU) is removed from both the list and the HashMap. This combination ensures all operations run in constant time." */

class LRUCache {
    // Dummy head and tail nodes to simplify insert/delete operations
    final Node head = new Node();
    final Node tail = new Node();
    // Maps a key to its corresponding node in the doubly linked list
    Map<Integer, Node> nodeMap;
    // Maximum number of entries the cache can hold
    int capacity;
    public LRUCache(int capacity) {

        nodeMap = new HashMap<>(capacity);
        this.capacity = capacity;
        //Initialise the doubly linked list
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        Node node = nodeMap.get(key);
        // Key not found
        if (node == null) {
            return -1;
        }
        // Move the accessed node to the front (Most Recently Used)
        remove(node);
        add(node);

        return node.val;
    }
    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        // Update existing key
        if (node != null) {

            node.val = value;

            remove(node);
            add(node);
        } else {
            // Remove the Least Recently Used node if the cache is full
            if (nodeMap.size() == capacity) {

                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            // Create and insert a new node
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;

            nodeMap.put(key, newNode);
            add(newNode);
        }
    }
    // Insert a node right after the head (Most Recently Used position)
    private void add(Node node) {
        Node firstNode = head.next;

        node.next = firstNode;
        node.prev = head;

        head.next = node;
        firstNode.prev = node;
    }
    // Remove a node from the doubly linked list
    private void remove(Node node) {

        Node previousNode = node.prev;
        Node nextNode = node.next;

        previousNode.next = nextNode;
        nextNode.prev = previousNode;
    }
    class Node {
        int key;
        int val;

        Node prev;
        Node next;
    }
}

// Time Complexity :- O(1).- get take O(1) and put also take O(1).
// Space Complexity :- O(capacity).
