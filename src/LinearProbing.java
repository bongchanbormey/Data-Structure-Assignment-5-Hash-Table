public class LinearProbing<T> implements HashTable<T> {
    private UnorderedArray<Entry<String, T>> table;
    private int capacity;
    private int size;
    public LinearProbing(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.table = new UnorderedArray<>(capacity); // No need to add null placeholders
    }
    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }
    @Override
    public void insert(String key, T value) {
        int hashIndex = hash(key);
        int originalIndex = hashIndex;
// Linear probing to find an empty slot or update an existing key
        while (true) {
            Entry<String, T> entry = table.get(key); // Try to get entry with given key
            if (entry != null && entry.getKey().equals(key)) {
// Key exists, update the value
                table.remove(key);
                table.add(key, new Entry<>(key, value));
                return;
            }
// Check the next index for an empty slot
            if (entry == null) {
                table.add(key, new Entry<>(key, value)); // Insert new entry if slot is empty
                size++;
                return;
            }
            hashIndex = (hashIndex + 1) % capacity;
            if (hashIndex == originalIndex) {
                throw new RuntimeException("Hash table is full");
            }
        }
    }
    @Override
    public T search(String key) {
        int hashIndex = hash(key);
        int originalIndex = hashIndex;
// Linear probing to search for the key
        while (true) {
            Entry<String, T> entry = table.get(key); // Search using key
            if (entry == null) {
                return null; // Key not found
            } else if (entry.getKey().equals(key)) {
                return entry.getValue(); // Key found
            }
            hashIndex = (hashIndex + 1) % capacity;
            if (hashIndex == originalIndex) {
                return null; // End of probe cycle, key not found
            }
        }
    }
    @Override
    public void delete(String key) {
        int hashIndex = hash(key);
        int originalIndex = hashIndex;
        while (true) {
            Entry<String, T> entry = table.get(key); // Get by key, as direct indexing isn't supported
            if (entry == null) {
                return; // If there's no entry, key doesn't exist in the table
            } else if (entry.getKey().equals(key)) {
// Key found, so remove it
                table.remove(key);
                size--;
                return;
            }
// Simulate linear probing by calculating the next index position
            hashIndex = (hashIndex + 1) % capacity;
            if (hashIndex == originalIndex) {
                break; // Break the loop if we've circled back to the starting index
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hash Table Contents:\n");
// Loop through the table
        for (int i = 0; i < capacity; i++) {
// Get the entry at index i
            Object entry = table.getEntryAt(i); // Assuming getEntryAt returns an Object type
// Check if the entry is not null and is of the correct type
            if (entry instanceof Entry) {
                Entry<String, T> currentEntry = (Entry<String, T>) entry;
                sb.append("Index ").append(i).append(": ").append(currentEntry.getKey()).append(" -> ").append(currentEntry.getValue()).append("\n");
            } else {
                sb.append("Index ").append(i).append(": null\n");
            }
        }
        return sb.toString();
    }
    // Inner class to represent key-value pairs
    private static class Entry<K, V> {
        private final K key;
        private final V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }
}