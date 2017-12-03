package tree.niming;

/**
 * Created by Administrator on 2017/11/14.
 */
/**
 * 二叉搜索树性质：
 *   1 非空左子树的所有键值小于其根结点的键值；
 2 非空右子树的所有键值大于其根结点的键值；
 3 左右子树均为二叉搜索树；
 4 树中没有键值相等的结点。
 */
public class BinarySearchTreeNode<T extends Comparable<T>> implements NTreeNode<T>{
    private T data;
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;

    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }

    public BinarySearchTreeNode<T> getLeft(){
        return left;
    }
    public void setLeft(NTreeNode<T> left){
        this.left = (BinarySearchTreeNode<T>)left;
    }
    public BinarySearchTreeNode<T> getRight(){
        return right;
    }
    public void setRight(NTreeNode<T> right){
        this.right = (BinarySearchTreeNode<T>)right;
    }

}

