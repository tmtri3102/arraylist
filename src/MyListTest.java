public class MyListTest {
    public static void main(String[] args) {
        // Create a MyList object with default capacity
        MyList<String> myList = new MyList<>();

        // Add some elements
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");

        // Print size and elements
        System.out.println("List size after adding 3 elements: " + myList.size()); // Expected: 3
        System.out.println("Element at index 0: " + myList.get(0)); // Expected: Apple
        System.out.println("Element at index 1: " + myList.get(1)); // Expected: Banana
        System.out.println("Element at index 2: " + myList.get(2)); // Expected: Cherry

        // Add element at a specific index
        myList.add(1, "Mango");
        System.out.println("Element at index 1 after adding 'Mango': " + myList.get(1)); // Expected: Mango
        System.out.println("Element at index 2 after shift: " + myList.get(2)); // Expected: Banana

        // Check if list contains specific elements
        System.out.println("List contains 'Apple': " + myList.contains("Apple")); // Expected: true
        System.out.println("List contains 'Grape': " + myList.contains("Grape")); // Expected: false

        // Remove an element
        String removedElement = myList.remove(2); // Remove 'Banana'
        System.out.println("Removed element: " + removedElement); // Expected: Banana
        System.out.println("List size after removal: " + myList.size()); // Expected: 3

        // Print the current list elements
        for (int i = 0; i < myList.size(); i++) {
            System.out.println("Element at index " + i + ": " + myList.get(i));
        }

        // Clone the list and check if it is identical
        MyList<String> clonedList = myList;
        System.out.println("Cloned list size: " + clonedList.size()); // Expected: same as original
        System.out.println("Element in cloned list at index 0: " + clonedList.get(0)); // Expected: same as original

        // Clear the list
        myList.clear();
        System.out.println("List size after clearing: " + myList.size()); // Expected: 0
    }
}
