public class QuadraticProbing<T> implements HashTable<T> {
    private UnorderedArray<T> table;
    private int capacity;


    public QuadraticProbing(int capacity) {
        this.capacity = capacity;
        this.table = new UnorderedArray<>(capacity);
    }


    @Override
    public void insert(String key, T value) {
        int index = hash(key);
        int i = 0;
        // Loop to find an empty slot using quadratic probing O(n)
        while (table.get(key) != null) {
            // Calculate the next index using the quadratic probing formula
            index = (index + i * i) % capacity;
            i++;
        }
        // Add the key-value pair to the table at the found index
        table.add(key, value);
    }


    @Override
    public T search(String key) {
        int index = hash(key);
        int i = 0;
        //loop to find the key
        while (table.get(key) != null) {
            return table.get(key);
        }
        return null;
    }


    @Override
    public void delete(String key) {
        table.remove(key);
    }

    @Override
    public String toString() {
        return table.toString();
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}