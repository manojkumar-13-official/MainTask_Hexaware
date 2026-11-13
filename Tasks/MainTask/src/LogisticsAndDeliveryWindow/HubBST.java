package LogisticsAndDeliveryWindow;

public class HubBST {
    private TreeNode root;

    public void insert(String code) {
        root = insertRecursive(root, code);
    }

    private TreeNode insertRecursive(TreeNode current, String code) {
        if (current == null) {
            return new TreeNode(code);
        }
        int comparison = code.compareTo(current.hubCode);

        if (comparison < 0) {
            current.left = insertRecursive(current.left, code);
        } else if (comparison > 0) {
            current.right = insertRecursive(current.right, code);
        }
        return current;
    }

    public boolean search(String code) {
        return searchRecursive(root, code);
    }

    private boolean searchRecursive(TreeNode current, String code) {
        if (current == null) {
            return false;
        }

        if (code.equals(current.hubCode)) {
            return true;
        }

        int comparison = code.compareTo(current.hubCode);
        if (comparison < 0) {
            return searchRecursive(current.left, code);
        } else {
            return searchRecursive(current.right, code);
        }
    }

    public int getHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int leftHeight = calculateHeight(current.left);
        int rightHeight = calculateHeight(current.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
