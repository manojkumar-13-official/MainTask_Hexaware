package LogisticsAndDeliveryWindow;

public class BreakDown1 {
    public static void main(String[] args) {
        HubBST tree = new HubBST();
        String[] hubsUnsorted = {"DEL", "BOM", "MAA", "BLR", "CCU"};

        for (String hub : hubsUnsorted) {
            tree.insert(hub);
        }

        System.out.println("--- Unsorted Insertion ---");
        System.out.println("Search 'MAA': " + tree.search("MAA"));
        System.out.println("Search 'HYD': " + tree.search("HYD"));
        System.out.println("Tree Height: " + tree.getHeight());
        HubBST sortedTree = new HubBST();
        String[] hubsSorted = {"BLR", "BOM", "CCU", "DEL", "MAA"};

        for (String hub : hubsSorted) {
            sortedTree.insert(hub);
        }

        System.out.println("\n--- Sorted Input Insertion ---");
        System.out.println("Tree Height (Sorted Input): " + sortedTree.getHeight());
    }
}