import java.util.*;

class TreeNode{
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val){
        this.val = val;
    }
}

public class BinaryTree {
//    public TreeNode createTree(){
//        TreeNode A = new TreeNode('A');
//        TreeNode B = new TreeNode('B');
//        TreeNode C = new TreeNode('C');
//        TreeNode D = new TreeNode('D');
//        TreeNode E = new TreeNode('E');
//        TreeNode F = new TreeNode('F');
//        TreeNode G = new TreeNode('G');
//        TreeNode H = new TreeNode('H');
//
//        A.left = B;
//        A.right = C;
//        B.left = D;
//        B.right = E;
//        C.left = F;
//        C.right = G;
//        E.right = H;
//
//        return A;
//    }
    public static int i = 0;
    public TreeNode createTree(String str){
        if(str == null){
            return null;
        }
        TreeNode root = null;
        if(str.charAt(i) != '#'){
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else{
            i++;
        }
        return root;
    }
    // 前序遍历
    public void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //前序遍历非递归
    public void preOrderTraversalNor(TreeNode root){
        if(root == null) return;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            }

            TreeNode top = stack.pop();
            cur = top.right;
        }
        System.out.println();
    }
    // 中序遍历
    public void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }
    //中序遍历非递归
    public void inOrderTraversalNor(TreeNode root){
        if(root == null) return;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
        System.out.println();
    }
    // 后序遍历
    public void postOrderTraversal(TreeNode  root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }
    //后序遍历非递归
    public void postOrderTraversalNor(TreeNode root){
        if(root == null) return;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        while(cur != null ||  !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //当cur一直往左走的时候，遇到null，此时还不能出栈，因为栈顶元素的右树还没执行
            cur = stack.peek();
            if(cur.right == null || preNode == cur.right){
                TreeNode popNode = stack.pop();
                System.out.print(popNode.val + " ");
                preNode = cur;
                cur =null;
            }else {
                cur = cur.right;
            }
        }
    }
    //层序遍历
    public void levelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            System.out.print(top.val + " ");
            if(top.left != null){
                queue.offer(top.left);
            }
            if(top.right != null){
                queue.offer(top.right);
            }
        }
    }
    //分层遍历
    public List<List<Character>> levelOrder(TreeNode root) {
        List<List<Character>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        //使用队列来实现层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Character> list = new ArrayList<>();
            while(size != 0){
                TreeNode top = queue.poll();
                list.add(top.val);
                if(top.left != null){
                    queue.offer(top.left);
                }
                if(top.right != null){
                    queue.offer(top.right);
                }
                size--;
            }
            ret.add(list);
        }
        return ret;
    }
    // 遍历思路-求结点个数
    static int size = 0;
    public void getSize1(TreeNode  root){
        if(root == null){
            return;
        }
        //前序遍历
       /* size++;
        getSize1(root.left);
        getSize1(root.right);*/
        //中序遍历
       /* getSize1(root.left);
        size++;
        getSize1(root.right);*/
        //后续遍历
        getSize1(root.left);
        getSize1(root.right);
        size++;

    }
    // 子问题思路-求结点个数
    public int getSize2(TreeNode  root){
        if(root == null){
            return 0;
        }
        return getSize2(root.left) + getSize2(root.right) + 1;
    }
    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    public void getLeafSize1(TreeNode  root){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);

    }
    // 子问题思路-求叶子结点个数
    public int getLeafSize2(TreeNode  root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }
    // 子问题思路-求第 k 层结点个数
    public int getKLevelSize(TreeNode  root,int k){
        if(root == null) return 0;
        if(k==1){
            return 1;
        }
        return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
    }
    //获取二叉树的高度
    public int getHeight(TreeNode root){
        if(root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int sum = 0;
        if(leftHeight > rightHeight){
            sum = leftHeight + 1;
        }else{
            sum = rightHeight+1;
        }
        return sum;
    }
    //判断一棵树是否是完全二叉树
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
    //查找val所在的节点，没找到返回null。按照根->左->右的顺序进行查找，一但找到，立即返回，不需要继续在其他位置查找，默认是在无重复节点的情况下 。
    TreeNode find(TreeNode root,char val){
        if(root == null) return null;
        if(root.val == val) return root;

        TreeNode ret = find(root.left,val);
        if(ret != null){
            return ret;
        }

        ret = find(root.right,val);
        if(ret != null){
            return ret;
        }
        return null;
    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        TreeNode root = binaryTree.createTree(str);
        System.out.print("前序遍历：");
        binaryTree.preOrderTraversal(root);
        System.out.println();
        System.out.print("非递归前序遍历：");
        binaryTree.preOrderTraversalNor(root);
        System.out.print("中序遍历：");
        binaryTree.inOrderTraversal(root);
        System.out.println();
        System.out.print("非递归中序遍历：");
        binaryTree.inOrderTraversalNor(root);
        System.out.print("后序遍历：");
        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.print("后序遍历非递归：");
        binaryTree.postOrderTraversalNor(root);
        System.out.println();
        System.out.print("层序遍历：");
        binaryTree.levelOrderTraversal(root);
        System.out.println();
        System.out.print("层序遍历：");
        List<List<Character>> ret1 = binaryTree.levelOrder(root);
        System.out.print(ret1);
        System.out.println();
        System.out.print("节点个数：");
        binaryTree.getSize1(root);
        System.out.print(BinaryTree.size);
        System.out.println();
        System.out.print("节点个数：");
        binaryTree.getSize2(root);
        System.out.print(BinaryTree.size);
        System.out.println();
        System.out.print("叶子节点个数：");
        binaryTree.getLeafSize1(root);
        System.out.println(BinaryTree.leafSize);
        System.out.print("叶子节点个数：");
        System.out.println(binaryTree.getLeafSize2(root));
        System.out.print("二叉树的高度：");
        int height =binaryTree.getHeight(root);
        System.out.println(height);
        System.out.print("是否为完全二叉树：");
        System.out.println(binaryTree.isCompleteTree(root));
        System.out.print("字符所在地址：");
        TreeNode ret2 =  binaryTree.find(root,'C');
        System.out.print(ret2);
    }
}
