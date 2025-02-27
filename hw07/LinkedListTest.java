public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Test isEmpty and size
        assert list.isEmpty() : "List should be empty initially";
        assert list.size() == 0 : "Initial size should be 0";

        // Test add(E element)
        list.add("A");
        list.add("B");
        list.add("C");
        assert list.size() == 3 : "Size should be 3 after adding elements";
        assert list.toString().equals("[A, B, C]") : "List should contain [A, B, C]";

        // Test add(int index, E element)
        list.add(1, "D");
        assert list.size() == 4 : "Size should be 4 after adding element at index 1";
        assert list.toString().equals("[A, D, B, C]") : "List should contain [A, D, B, C]";

        // Test get(int index)
        assert list.get(0).equals("A") : "Element at index 0 should be A";
        assert list.get(2).equals("B") : "Element at index 2 should be B";

        // Test indexOf(Object o)
        assert list.indexOf("B") == 2 : "Index of B should be 2";
        assert list.indexOf("Z") == -1 : "Index of non-existent element should be -1";

        // Test contains(Object o)
        assert list.contains("D") : "List should contain D";
        assert !list.contains("Z") : "List should not contain Z";

        // Test set(int index, E element)
        list.set(1, "E");
        assert list.get(1).equals("E") : "Element at index 1 should be E";
        assert list.toString().equals("[A, E, B, C]") : "List should contain [A, E, B, C]";

        // Test remove(int index)
        String removedElement = list.remove(2);
        assert removedElement.equals("B") : "Removed element should be B";
        assert list.size() == 3 : "Size should be 3 after removal";
        assert list.toString().equals("[A, E, C]") : "List should contain [A, E, C]";

        // Test remove(Object o)
        boolean removed = list.remove("E");
        assert removed : "Element E should be removed successfully";
        assert list.toString().equals("[A, C]") : "List should contain [A, C]";

        // Test clear()
        list.clear();
        assert list.isEmpty() : "List should be empty after clear";
        assert list.size() == 0 : "Size should be 0 after clear";
        assert list.toString().equals("[]") : "List should be empty";

        // Test equals(Object obj)
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();
        list1.add("X");
        list1.add("Y");
        list2.add("X");
        list2.add("Y");
        assert list1.equals(list2) : "Lists should be equal";
        list2.add("Z");
        assert !list1.equals(list2) : "Lists should not be equal";

        System.out.println("All tests passed!");
    }
}