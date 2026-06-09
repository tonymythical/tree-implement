import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

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

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1);
    TreeNode<Integer> current = megaRoot;
  
    for (int i = 1; i < 100_001; i++) {
      current.right = new TreeNode<Integer>(i);
      current = current.right;
    }

    // preorder(stringRoot);
    // inorder(root);
    // postorder(root);
    // printGreaterThan(root, 1);
    // System.out.println(countNodes(root));

    // preorderIterative(megaRoot);
    levelOrder(root);
    
  }


  public static int countNodes(TreeNode<?> current) {
    return current == null ? 0 : 1 + countNodes(current.left) + countNodes(current.right);
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

  public static void preorderIterative(TreeNode<?> root) {
    Stack<TreeNode<?>> stack = new Stack<>();

    stack.push(root);

    while(!stack.isEmpty()) {
      TreeNode<?> current = stack.pop();
      if(current == null) continue;
      // do something
      System.out.println(current.value);
      stack.push(current.right);
      stack.push(current.left);
    }
  }

  public static void levelOrder(TreeNode<?> root) {
    Queue<TreeNode<?>> queue = new LinkedList<>();

    queue.offer(root);

    while(!queue.isEmpty()) {
      TreeNode<?> current = queue.remove();
      if(current == null) continue;
      System.out.println(current.value);
      queue.offer(current.left);
      queue.offer(current.right);
    }
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
