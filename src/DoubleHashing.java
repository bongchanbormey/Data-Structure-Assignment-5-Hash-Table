public class DoubleHashing<T> implements HashTable<T> {
    private UnorderedArray<HashEntry<T>> table;
    private int size;
    private int capacity;


    public DoubleHashing(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new UnorderedArray<>(capacity);
    }


    // Insert a key-value pair using double hashing for collision resolution
    public void insert(String key, T value) {
        if (size >= capacity) {
            System.out.println("Hash table is full. Cannot insert.");
            return;
        }

        // Start by calculating the hash value using the first hash function
        int index = hash1(key);
        int i = 0; // Collision counter for double hashing

        // Check for collisions and apply double hashing until we find an empty slot
        while (table.get(getKey(index)) != null) {
            i++;
            index = getIndex(key, i); // Apply double hashing formula
        }

        // Insert the element at the found index
        table.add(getKey(index), new HashEntry<>(key, value));
        size++;
    }


    // Search for a value by key
    public T search(String key) {
        int index = hash1(key);
        int i = 0;

        // Probe using double hashing
        while (table.get(getKey(index)) != null) {
            HashEntry<T> entry = table.get(getKey(index));
            // Check if the current entry matches the key
            if (entry != null && entry.getKey().equals(key)) {
                return entry.getValue();
            }
            i++;
            index = getIndex(key, i); // Try next index using double hashing
        }

        return null; // Not found
    }


    // Delete a key-value pair by key
    public void delete(String key) {
        int index = hash1(key);
        int i = 0;

        // Probe using double hashing
        while (table.get(getKey(index)) != null) {
            HashEntry<T> entry = table.get(getKey(index));
            // If we find the key, remove it
            if (entry != null && entry.getKey().equals(key)) {
                table.remove(getKey(index)); // Remove element from array
                size--;
                return;
            }
            i++;
            index = getIndex(key, i); // Try next index using double hashing
        }
    }


    // Display the hash table in a table format (index and values)
    public void printTable() {
        System.out.println("Index\tKey\tValue");
        for (int i = 0; i < capacity; i++) {
            HashEntry<T> entry = table.get(getKey(i));
            System.out.printf("%d\t%s\t%s\n", i, getKey(i), (entry != null ? entry.getValue() : "Empty"));
        }
    }


    // First hash function (primary hash function)
    private int hash1(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }


    // Second hash function (used for double hashing)
    private int hash2(String key) {
        return 7 - (Math.abs(key.hashCode()) % 7);          // Avoid zero in second hash
    }


    // Double hashing index calculation
    private int getIndex(String key, int i) {
        return (hash1(key) + i * hash2(key)) % capacity;    // Apply double hashing formula
    }


    // Generate a key string based on the index (for mapping purposes)
    private String getKey(int index) {
        return String.valueOf(index); // Mapping index to string key
    }

    // Inner class for key-value pairs
    private static class HashEntry<T> {
        private String key;
        private T value;

        public HashEntry(String key, T value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }
}
