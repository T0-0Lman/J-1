import java.util.*;
import java.util.LinkedList;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    // 构造方法
    public TreeNode(char val) { this.val = val; }
}

public class Main3 {
    public TreeNode createTree(){
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;

        return A;
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void preOrderTraversal(TreeNode root) {
        if(root == null)
            return;
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                System.out.print(node.val+" ");
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑，弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inOrderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                System.out.print(node.val+" ");
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postOrderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        TreeNode lastNode = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            // 查看当前栈顶元素
            node = treeNodeStack.peek();
            // 如果其右子树也为空，或者右子树已经访问过，则可以直接输出当前节点的值
            if (node.right == null || node.right == lastNode) {
                System.out.print(node.val+" ");
                treeNodeStack.pop();
                // 把输出的节点赋值给lastNode游标，作为下次比对的依据
                lastNode = node;
                node = null;
            }
            // 否则，继续遍历右子树
            else {
                node = node.right;
            }
        }
    }

    public boolean isCompleteTree(TreeNode root){
        if(root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            if(top != null){
                queue.offer(top.left);
                queue.offer(top.right);
            }else{
                break;
            }
        }
        while(!queue.isEmpty()){
            TreeNode ret = queue.peek();
            if(ret == null){
                queue.poll();
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main3 binaryTree = new Main3();
        TreeNode root = binaryTree.createTree();
        System.out.print("前序遍历：");
        binaryTree.preOrderTraversal(root);
        System.out.println();

    }
}
