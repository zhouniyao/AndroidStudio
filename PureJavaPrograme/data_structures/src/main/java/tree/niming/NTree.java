package tree.niming;

/**
 * Created by Administrator on 2017/11/15.
 */

//未带来好处和方便，不使用
public interface NTree<T>{
    /*
        接口中的【变量】会被隐式地指定为public static final变量（并且只能是public static final变量，用private修饰会报编译错误），
        而【方法】会被隐式地指定为public abstract方法且只能是public abstract方法（用其他关键字，比如private、protected、static、 final等修饰会报编译错误），
        接口中的方法必须都是抽象方法。从这里可以隐约看出接口和抽象类的区别，接口是一种极度抽象的类型，它比抽象类更加“抽象”，并且一般情况下不在接口中定义变量。
     */
    NTreeNode<T> Insert(NTreeNode<T> name, T data);
    void PrintTree(NTreeNode<T> root);
}
