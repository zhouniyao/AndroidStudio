package com.example;

public class GenericDemo {
//    //递归
//    static int Print(int n){
//        if(n == 0)return 0;
//        else{
//            System.out.println(n);
//            return Print(n-1);
//        }
//    }
//    static void print2(int n){
//        if(n==0)return;
//        else{
//            System.out.println(n);
//            print2(n-1);
//
//        }
//    }



    public static void main(String[] args){
        System.out.println("start ====================");
        Integer[] A = {14,5,20,9,41,13,25,17,8,33,3,12,7,1,21,31};//随机个数组
//        Integer[] A = {0,1,2,3,4,5,6,7,8,9};
        /*
        //平衡二叉树
        AVLTree<Integer> nSearchTree = new AVLTree<>();
        nSearchTree.Create(A);
        nSearchTree.PreOrder(nSearchTree.getHead());
        System.out.println();
        //分层打印
        nSearchTree.PrintTree(nSearchTree.getHead());
*/


////////////////////////////////////////////////////////////////////////////////////////////

//        //二叉搜索树的综合测试
//        Integer[] A = {0,1,2,3,4,5,6,7,8,9};
//        BSTree<Integer> mSearchTree = new BSTree<>(10);
//        mSearchTree.Create(A);
//                //逐层打印
//        mSearchTree.PrintTree(mSearchTree.getHead());

        /*手动建立二叉树*/
//        //声明 BinarySearchTreeNode，为了调用Insert() 和 PreOrder()，否则出现空指针异常
////        BSTree<Integer> mSearchTree = new BSTree<>(10);
//        NTreeNode<Integer> root = null;
//        //建立二叉搜素树
//        for(int data : A){
//            //Integer temp = data;
//            root = mSearchTree.Insert(root, data);//返回根
//        }


        //二叉搜索树的高度
//         System.out.println(mSearchTree.Height(mSearchTree.getHead()));


        /*
        //删除一个节点
        Integer in = new Integer(10);
        mSearchTree.Delete(root, in);
        */
        /*
        System.out.println(mSearchTree.FindMin(root.getLeft().getLeft()).getData());//找出根左子树的左子树最小值
        System.out.println(mSearchTree.FindMin(root.getRight()).getData());//找出根右子树最小值
        */

        //打印
//        mSearchTree.PreOrder(root);
//        System.out.println();
//        mSearchTree.InOrder(root);
//        System.out.println();
//        mSearchTree.PostOrder(root);

//        mSearchTree.PrintTree(root);
////        mSearchTree.LevelPrint(root);
//        System.out.println("Delete a Node ===============");
//        mSearchTree.Delete(root, 13);
//        //逐层打印
//        mSearchTree.PrintTree(root);

//        mSearchTree.PrintTree(mSearchTree.getHead());
////        mSearchTree.LevelPrint(root);
//        System.out.println("Delete a Node ===============");
//        mSearchTree.Delete(mSearchTree.getHead(), 13);
//        //逐层打印
//        mSearchTree.PrintTree(mSearchTree.getHead());


//        print2(100);

//        //引用类型实现Comparable接口
//        YinYong dd = new YinYong();//默认11
//        YinYong yy = new YinYong();
//        yy.setData(10);
//        System.out.println(yy.compareTo(dd));

//        Ang<Integer> integer = new Ang<>(18);
//        int a = integer.getT();
//        System.out.println(a);

//        //泛型 例
//        Pair<String, Integer> p = new Pair<>("niming", 32);
//        System.out.println(p.getFirst() +"  "+ p.getSecond());
//
//        //泛型数组
//        Pair<String, String>[] pairs = (Pair<String, String>[]) new Pair[10];//声明并初始化一个泛型数组
//
//        for(Integer i =0; i < pairs.length; i++){
//            pairs[i] = new Pair(i.toString(),i.toString());
//        }
//        for(int i =0; i< pairs.length; i++){
//            System.out.println(pairs[i].getFirst() +"  "+ pairs[i].getSecond());
//        }
    }
}

//泛型类
class Pair<T, U>{
    private T first;
    private U second;
    public Pair(){}
    public Pair(T first, U second){
        this.first = first;
        this.second = second;
    }
    public T getFirst(){
        return first;
    }
    public U getSecond(){
        return second;
    }
    public void setFirst(T first){
        this.first = first;
    }
    public void setSecond(U second){
        this.second = second;
    }

}
class YinYong implements  Comparable{
    public int data;
    public YinYong(){
        data = 11;
        System.out.println("这是引用类型");
    }
    public void setData(int data){
        this.data = data;
    }
    public int compareTo(Object b){
        YinYong c = (YinYong)b;
        if(data > c.data)
            return 1;
        else if(data < c.data)
            return -1;
        else
            return 0;
    }
}
class Ang<T>{
    T data;
    public Ang(T data){
        this.data = data;
        System.out.println("这是泛型类");
        //this.data = new T():
    }
    public T getT(){
        return data;
    }
}