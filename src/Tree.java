public class Tree {
    static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node bulid(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return  A;
    }


    //先序遍历
    public static void proOrder(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        proOrder(root.left);
        proOrder(root.right);
    }

    //中序遍历
    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    //后序遍历
    public static void postOrder(Node root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }



    //计算节点的个数
    public static int size1(Node root){
        if (root == null){
            return 0;
        }
        //整个树的节点个数=根节点个数+左子树节点个数+右子树节点个数
        return 1 + size1(root.left) + size1(root.right);
    }


    private static int TreeCount = 0;
    public static void size2(Node root){
        if (root == null){
            return;
        }
        TreeCount++;
        size2(root.left);
        size2(root.right);
    }



    //计算叶子节点的个数
    public static int leafSize1(Node root){
        if (root == null){
            return 0;
        }
        if (root.left  == null && root.right == null){
            return 1;
        }
        return leafSize1(root.left) + leafSize1(root.right);
    }


    private static int leafCount = 0;
    public static void leafSize2(Node root){
        if (root == null){
            return;
        }
        if (root.left  == null && root.right == null){
            leafCount++;
            return;
        }
        leafSize2(root.left);
        leafSize2(root.right);
    }




    //求第K层的节点个数 例：第三层
    public static int klevelSize(Node root , int k){
        if (root == null || k < 1){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        return klevelSize(root.left,k-1) + klevelSize(root.right,k-1);
    }



    //查找是否存在给定值
    public static Node result = null;
    public static void find1(Node root , int value){
        if (root == null){
            return;
        }
        if (root.val == value){
            result = root;
            return;
        }
        find1(root.left,value);
        find1(root.right,value);
    }

    public static Node find2(Node root , int value){
        if (root == null){
            return null;
        }
        if (root.val == value ){
            return root;
        }
        Node ret = find2(root.left,value);
        if (ret != null){
            return ret;
        }
        return find2(root.right,value);
    }


    public static void main(String[] args) {

    }
}
