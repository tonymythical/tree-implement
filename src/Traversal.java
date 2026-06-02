public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(10);

    root.left = new TreeNode<>(9);
    root.left.left = new TreeNode<>(5);
    root.left.right = new TreeNode<>(2);

    root.right = new TreeNode<>(15);
    root.right.left = new TreeNode<>(-3);
    root.right.right = new TreeNode<>(5);
    root.right.right.right = new TreeNode<>(22);

    TreeNode<String> stringRoot = new TreeNode<>("hello");


    stringRoot.left = new TreeNode<>("e");
    stringRoot.left.left = new TreeNode<>("f");
    stringRoot.left.right = new TreeNode<>("g");

    stringRoot.right = new TreeNode<>("h");
    stringRoot.right.left = new TreeNode<>("i");
    stringRoot.right.right = new TreeNode<>("f");
    stringRoot.right.right.right = new TreeNode<>("j");

    preorder(stringRoot);
    // inorder(root);
    postorder(root);
    printGreaterThan(root, 1);
  }

  // Do a preorder traversal
  // but ONLY PRINT the nodes that are greater than our threshold
  public static void printGreaterThan(TreeNode<Integer> current, int threshold) {
    if (current == null) return;
    if (current.value > threshold) {
      System.out.println(current.value);
    }
    printGreaterThan(current.left, threshold);
    printGreaterThan(current.right, threshold);
  }

  public static void preorder(TreeNode<?> current) {
    if(current == null) return;
    System.out.println(current.value);

    preorder(current.left);
    preorder(current.right);
  }

  public static void inorder(TreeNode<?> current) {
    if(current == null) return;

    inorder(current.left);

    System.out.println(current.value);
    
    inorder(current.right);
  }

  public static <E> void postorder(TreeNode<E> current) {
    if(current == null) return;

    postorder(current.left);
    postorder(current.right);

    E myValue = current.value;
    System.out.println(myValue);
  }
}
