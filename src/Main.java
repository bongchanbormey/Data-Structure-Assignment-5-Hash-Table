public class Main {
    public static void main(String[] args) {
        // Double Hashing Test Cases
        // Create a DoubleHashing instance with capacity 10
        DoubleHashing<String> hashTable = new DoubleHashing<>(10);

        // Inserting elements
        System.out.println("Inserting elements:");
        hashTable.insert("A", "Apple");
        hashTable.insert("G", "Banana");
        hashTable.insert("C", "Cherry");
        hashTable.insert("H", "Date");
        hashTable.insert("E", "Elderberry");

        // Print hash table after insertions in table format
        System.out.println("\nHash Table after insertions:");
        hashTable.printTable();

        // Searching for elements
        System.out.println("\nSearching for elements:");
        System.out.println("Search for key 'A': " + hashTable.search("A"));
        System.out.println("Search for key 'C': " + hashTable.search("C"));
        System.out.println("Search for key 'F': " + hashTable.search("F"));

        // Deleting elements
        System.out.println("\nDeleting elements:");
        hashTable.delete("A");
        hashTable.delete("C");
        System.out.println("\nHash Table after deletions:");
        hashTable.printTable();

        // Attempting to delete a non-existing key
        System.out.println("\nDeleting a non-existing key:");
        hashTable.delete("F");


        // Quadratic Hashing Test Cases
        // Create an instance of the QuadraticProbing hash table with a specified capacity
        QuadraticProbing<String> hashTable1 = new QuadraticProbing<>(10);

        // Insert key-value pairs into the hash table
        hashTable1.insert("apple", "A fruit");
        hashTable1.insert("banana", "Another fruit");
        hashTable1.insert("carrot", "A vegetable");
        hashTable1.insert("date", "A sweet fruit");

        // Print the contents of the hash table
        System.out.println("Hash Table Contents:");
        System.out.println(hashTable1);

        // Search for values by key
        String searchKey = "banana";
        String result = hashTable1.search(searchKey);
        System.out.println("Search for key '" + searchKey + "': " + result);

        // Delete a key-value pair
        String deleteKey = "carrot";
        hashTable1.delete(deleteKey);
        System.out.println("After deleting key '" + deleteKey + "':");
        System.out.println(hashTable1);

        // Try searching for the deleted key
        result = hashTable1.search(deleteKey);
        System.out.println("Search for deleted key '" + deleteKey + "': " + result);



        // Separate Chaining
        // Create a hash table with a small size to show chaining in action
        SeparateChaining<String> hashTable3 = new SeparateChaining<>(5, 3); // 5 chains, each with capacity 3

        hashTable3.insert("apple", "fruit");
        hashTable3.insert("carrot", "vegetable");
        hashTable3.insert("banana", "fruit");
        hashTable3.insert("cucumber", "vegetable");
        hashTable3.insert("grape", "fruit");
        hashTable3.insert("lettuce", "vegetable");

        System.out.println("Hash Table:");
        System.out.println(hashTable3);

        System.out.println("Searching for 'banana': " + hashTable3.search("banana"));
        System.out.println("Searching for 'grape': " + hashTable3.search("grape"));
        System.out.println("Searching for 'pineapple': " + hashTable3.search("pineapple"));

        hashTable3.delete("carrot");
        System.out.println("\nHash Table after deleting 'carrot':");
        System.out.println(hashTable3);

        hashTable3.delete("apple");
        System.out.println(hashTable3);



        // Linear Probing Test Cases
        // Create a LinearProbing hash table with a capacity of 5
        LinearProbing<String> hashTable4 = new LinearProbing<>(5);

        // Insert some data into the table
        hashTable4.insert("name", "John Doe");
        hashTable4.insert("email", "john.doe@example.com");
        hashTable4.insert("city", "New York");

        // Print the table contents after insertion
        System.out.println("Table contents after inserts:");
        System.out.println(hashTable4);

        // Search for an existing key
        String searchResult = hashTable4.search("email");
        System.out.println("Search for 'email': " + searchResult);

        // Search for a non-existing key
        String searchResult2 = hashTable4.search("phone");
        System.out.println("Search for 'phone': " + searchResult2);

        // Delete an entry
        hashTable4.delete("city");
        System.out.println("Table contents after deleting 'city':");
        System.out.println(hashTable4);
    }

}