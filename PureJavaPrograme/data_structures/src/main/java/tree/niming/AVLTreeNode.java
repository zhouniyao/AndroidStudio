package tree.niming;



/**
 * Created by Administrator on 2017/11/14.
 */


//平衡二叉搜索树，平衡因子k为左子树和右子树的高度差
//k=0，完全平衡二叉搜索树
//k=1，AVL(Adelson-Velskii and Landis)树，即左子树与右子树的高度差最多不超过1
public class AVLTreeNode <T extends Comparable<T>> implements NTreeNode<T>{

    private T data;
    private int height;
    private AVLTreeNode<T> left;
    private AVLTreeNode<T> right;

    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }
    public int getHeight(){
        return height;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public NTreeNode<T> getLeft(){
        return left;
    }
    public void setLeft(NTreeNode<T> left){
        this.left = (AVLTreeNode<T> )left;
    }
    public NTreeNode<T> getRight(){
        return right;
    }
    public void setRight(NTreeNode<T> right){
        this.right = (AVLTreeNode<T> )right;
    }

}