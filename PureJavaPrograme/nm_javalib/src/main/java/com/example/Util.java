//package com.example;
//
///**
// * Created by Administrator on 2017/11/15.
// */
//
//public class Util {
////    //当前节点height = 根到当前节点的路径长
////    public static<T extends NTree> int Height(T root){
////        if(root == null)
////            return 0;
////        else{
////            return Math.max(Height(root.get)
////        }
////    }
//    //逐层打印
//    public static<T extends NTree> void TreePrint(T root){
//        if(root == null)return;
//        BinarySearchTreeNode<T> symbol = new BinarySearchTreeNode<>();//标识节点
//        int level = Height(root) - 1 ;//节点层次，从根为0层开始
//        //满二叉树上，n层的节点数为2^n
//        int leafNum = (int)Math.pow(2, level);//满二叉树叶子数（最低层）
//
////        for(int i=0; i<(leafNum/2)*3; i++)
////            System.out.print("/");//打印leafNum个空格
////        System.out.println(root.getData());//打印根
////        PrintBSTree(root.getLeft()); //Error
////        PrintBSTree(root.getRight());//Error
//        LLQueue<BinarySearchTreeNode<T>> Q = new LLQueue<>();//新建二叉搜索树节点队列
//        LLNode<BinarySearchTreeNode<T>> temp;//注意泛型
//        Q.enQueue(root);//根入队列
//        //逐层
//        for(int i=0; i <= level; i++){
//            int num = (int)Math.pow(2, i);//每一层最多为2^n
//            int length = Math.round(leafNum/(num +1));//int length = (leafNum -(num + 1))/(num + 1);
//            //System.out.println(num);
//            for(int j = 0; j < num; j++){ //每一层最多为2^n
//                temp = Q.deQueue();//取队头
//                //打印////////////////////////////
//                for(int k = 0; k < length; k++){
//                    System.out.print("//");
//                }
//                //队列中的节点为symbol，打印占位符//
//                if(symbol.equals(temp.data)){ //temp.data == symbol
//                    System.out.print("//");
//                }else {//否则打印节点信息
//                    T info = temp.data.getData();
//                    System.out.print(info);//打印节点值
//                    if(info.compareTo(CMP) <= -1)//小于10的数，再填个占位符
//                        System.out.print("/");
//
////                    System.out.print(temp.data.getData());
//                }
//
//                if(temp.data.getLeft() != null){
//                    Q.enQueue(temp.data.getLeft());//左儿子入队列
//                }else{
//                    Q.enQueue(symbol);//压入一个空标志
//                }
//                if(temp.data.getRight() != null){
//                    Q.enQueue(temp.data.getRight());//右儿子入队列
//                }else{
//                    Q.enQueue(symbol);
//                }
//            }
//            //再打印些
//            for(int k = 0; k < length; k++){
//                System.out.print("//");
//            }
//            System.out.println();
//        }
//
//    }
//
//}
