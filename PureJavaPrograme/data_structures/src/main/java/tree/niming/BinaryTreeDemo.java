package tree.niming;

/**
 * Created by Administrator on 2017/11/13.
 */

public class BinaryTreeDemo {
    public static void main(String[] args){

    }
}
class BinaryTreeNode{
    private static final int INT_MIN = 0;
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    public int getData(){
        return data;
    }
    public void setData(int data){
        this.data = data;
    }

    public BinaryTreeNode getLeft(){
        return left;
    }
    public void setLeft(BinaryTreeNode left){
        this.left = left;
    }
    public BinaryTreeNode getRight(){
        return right;
    }
    public void setRight(BinaryTreeNode right){
        this.right = right;
    }

    void PreOrder(BinaryTreeNode root){
        if(root != null) {
            System.out.println(root.getData());//Do something;
            PreOrder(root.getLeft());
            PreOrder(root.getRight());
        }
    }
    void InOrder(BinaryTreeNode root){
        if(root != null){
            InOrder(root.getLeft());
            System.out.println(root.getData());//Do something;
            InOrder(root.getRight());
        }
    }
    void PostOrder(BinaryTreeNode root){
        if(root != null){
            PostOrder(root.getLeft());
            PostOrder(root.getRight());
            System.out.println(root.getData());//Do something;
        }
    }

    class LLNode<T>{
        T data;
        LLNode next;
        public LLNode(T data){
            this.data = data;
            next = null;
        }
    }
    //队列
    class LLQueue<T>{


    }

    //层次遍历——广度优先
    void LevelOrder(BinaryTreeNode root){

    }
    //从3个int值挑出最大的序号，如a为0，b为1，c为2
    int MaxOrder(int a, int b, int c){
        int max;
        max = a>b? a : b;
        max = max>c? max : c;
        if(max == a)return 0;
        else if(max == b) return 1;
        else return 2;
    }
    //乱序中，找到tree最大值节点
    BinaryTreeNode FindMax(BinaryTreeNode root){
        int root_val, left_val, right_val;
        root_val = left_val = right_val = INT_MIN;
        BinaryTreeNode  Max = null;
        if(root != null){
            root_val = root.getData();
            left_val = FindMax(root.getLeft()).getData();//左子树最大节点
            right_val = FindMax(root.getRight()).getData();//右子树最大节点
            //依据三个int中找到最大的那个节点
            int temp = MaxOrder(root_val, left_val, right_val);//判断哪个最大
            switch(temp){
                case 0:
                    Max = root;break;
                case 1:
                    Max = left;break;
                case 2:
                    Max = right;
            }
        }
        return Max;
    }

    //打印某节点所有祖先
    int PrintAllAncestors(BinaryTreeNode root, BinaryTreeNode node){
        if(root == null)
            return 0;//未找到目标node
        if(root.getLeft() == node || root.getRight() == node ||
                PrintAllAncestors(root.getLeft(), node) == 1 || PrintAllAncestors(root.getRight(), node)==1 ){
            System.out.println(root.getData());
            return 1;//找到目标啦
        }
        return 0;
    }
    //找出两节点最近公共祖先(LCA)，假设a、b都是二叉树中的节点【对照图剖析算法】
    BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b){
        BinaryTreeNode left, right;
        if(root == null)
            return null; //return root;
        if(root == a || root == b)//找到目标节点
            return root;
        left = LCA(root.getLeft(), a, b);//左子树找到目标节点a或b
        right = LCA(root.getRight(), a, b);//右子树找到目标节点a或b
        if(left != null && right != null)//当左右子树都不为空时，左子树找到一个，比如a，那么右子树也找到另一个b
            return root;
        else{
            return ((left != null) ? left : right);//某个子树同时找到2个目标
        }
    }
}


class BinarySearchTree{
    //二叉搜索树插入新data
    BinaryTreeNode Insert(BinaryTreeNode root, int data){
        if(root == null){
            root = new BinaryTreeNode();
            if(root == null){System.out.println("Memory Error");return null;}
            else{
                root.setData(data);
                root.setLeft(null);root.setRight(null);
            }
        }
        else{
            if(data > root.getData()){
                root.setRight(Insert(root.getRight(), data));//更新右子树
            }else if(data < root.getData()){
                root.setLeft(Insert(root.getLeft(), data));//更新左子树
            }
        }
        return root;
    }
    //寻找二叉搜索树中Max节点（最右节点）
    BinaryTreeNode FindMax(BinaryTreeNode root){
        if(root == null){
            return null;
        }else if(root.getRight() == null){
            return root;
        }else{
            return FindMax(root.getRight());
        }
    }

    //二叉搜索树中删除指定data
    BinaryTreeNode Delete(BinaryTreeNode root, int data){
        BinaryTreeNode temp;
        if(root == null)System.out.println("Element not there in tree!");
        else if(data < root.getData()){
            Delete(root.getLeft(), data);
        }else if(data > root.getData()){
            Delete(root.getRight(), data);
        }
        //if(root.getData() == data) {//找到要删除的节点，从左子树中挑出最大的节点代替根
        else{
            if(root.getLeft()!=null && root.getRight()!=null){//左右子树不空
                temp = FindMax(root.getLeft());//找到左子树最大节点
                root.setData(temp.getData());//根节点重新赋值
                root.setLeft(Delete(root.getLeft(), temp.getData()));//递归
            }else{//如果是单支或无儿子
                temp = root;
                if(root.getLeft() == null)
                    root = root.getRight();
                if(root.getRight() == null)
                    root = root.getLeft();
                temp = null;//释放空间
            }

        }
        return root;
    }

    //给定数据集，建立二叉搜索树
    BinaryTreeNode CreateTree(int[] A){
        BinaryTreeNode root = null;
        for(int i: A){
            Insert(root, i);
        }
        return root;
    }



}
