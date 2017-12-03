package tree.niming;

/**
 * Created by Administrator on 2017/11/15.
 */

public interface NTreeNode<T> {
    public T getData();
    public void setData(T data);

    public NTreeNode<T> getLeft();
    public void setLeft(NTreeNode<T> left);
    public NTreeNode<T> getRight();
    public void setRight(NTreeNode<T> right);
}
