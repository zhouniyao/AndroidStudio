package tree.niming;

/**
 * Created by Administrator on 2017/11/14.
 */

public class BSTree<T extends Comparable<T>>{
    private BinarySearchTreeNode<T> head;//根节点
    private final T CMP; //打印个位的话，多一个占位符
    BSTree(T primer){CMP = primer;}//primer设置为10,

    NTreeNode<T> getHead(){
        return head;
    }
    //新建BSTree树
    public NTreeNode<T> Create(T[] data ){
        NTreeNode<T> root = null;
        for(T temp : data){
            root = Insert(root, temp);
        }
        head = (BinarySearchTreeNode<T>)root;
        return root;
    }
    //  10
    //  / \
    // 8  12
    //假设每个数据占2个//
    public void PrintTree(NTreeNode<T> root){
        //BinarySearchTreeNode<T> root = (BinarySearchTreeNode<T>) name;
        if(root == null)return;
        BinarySearchTreeNode<T> symbol = new BinarySearchTreeNode<>();//标识节点
        int level = Height(root) - 1 ;//节点所在的层，从根为0层开始
        //满二叉树上，n层的节点数为2^n
        int leafNum = (int)Math.pow(2, level);//满二叉树叶子数（最低层）
        LLQueue<NTreeNode<T>> Q = new LLQueue<>();//新建二叉搜索树节点队列
        LLNode<NTreeNode<T>> temp;//注意泛型
        Q.enQueue(root);//根入队列
        //逐层
        for(int i=0; i <= level; i++){
            int num = (int)Math.pow(2, i);//每一层最多为2^n
            int length = Math.round(leafNum/(num +1));//int length = (leafNum -(num + 1))/(num + 1);
            //System.out.println(num);
            for(int j = 0; j < num; j++){ //每一层最多为2^n
                temp = Q.deQueue();//取队头
                //打印////////////////////////////
                for(int k = 0; k < length; k++){
                    System.out.print("//");
                }
                //队列中的节点为symbol，打印占位符//
                if(symbol.equals(temp.data)){ //temp.data == symbol
                    System.out.print("//");
                }else {//否则打印节点信息
                    T info = temp.data.getData();
                    System.out.print(info);//打印节点值
                    if(info.compareTo(CMP) <= -1)//小于10的数，再填个占位符
                        System.out.print("/");
                }

                if(temp.data.getLeft() != null){
                    Q.enQueue(temp.data.getLeft());//左儿子入队列
                }else{
                    Q.enQueue(symbol);//压入一个空标志
                }
                if(temp.data.getRight() != null){
                    Q.enQueue(temp.data.getRight());//右儿子入队列
                }else{
                    Q.enQueue(symbol);
                }
            }
            //再打印些
            for(int k = 0; k < length; k++){
                System.out.print("//");
            }
            System.out.println();
        }
    }

    //逐层打印
    public void LevelPrint(BinarySearchTreeNode<T> root){
        if(root == null) return;
        else{
            LLQueue<BinarySearchTreeNode<T>> Q = new LLQueue<>();
            LLNode<BinarySearchTreeNode<T>> temp;
            Q.enQueue(root);
            while(!Q.IsEmpty()){
                temp = Q.deQueue();//取队头的值
                //Do something
                System.out.print(temp.data.getData()+"  ");//打印
                if(temp.data.getLeft() != null){
                    Q.enQueue(temp.data.getLeft());//左儿子入队列
                }
                if(temp.data.getRight() != null){
                    Q.enQueue(temp.data.getRight());//右儿子入队列
                }

            }
        }
    }
    //先根遍历
    public  void PreOrder(BinarySearchTreeNode<T> root){
        if(root != null){
            //Do something;
            System.out.print(root.getData()+"  ");
            PreOrder(root.getLeft());
            PreOrder(root.getRight());
        }
    }
    //中根遍历
    public  void InOrder(BinarySearchTreeNode<T> root){
        if(root != null){
            InOrder(root.getLeft());
            System.out.print(root.getData()+"  ");//Do something;
            InOrder(root.getRight());
        }
    }

    //后根遍历
    public   void PostOrder(BinarySearchTreeNode<T> root){
        if(root != null){
            PostOrder(root.getLeft());
            PostOrder(root.getRight());
            System.out.print(root.getData()+"  ");//Do something;
        }
    }

    //a大于b，返回1；a小于b，返回-1；a等于b，返回0；
    private int Compare(T a, T b){
        /* compareTo()
            如果指定的数与参数相等返回0。
            如果指定的数小于参数返回 -1。
            如果指定的数大于参数返回 1。
         */
        return a.compareTo(b);
    }

    //插入
    public NTreeNode<T> Insert(NTreeNode<T> root, T data){
        //BinarySearchTreeNode<T> root = (BinarySearchTreeNode<T>) name;
        if(root == null){
            root = new BinarySearchTreeNode<>();
            root.setData(data);
            root.setLeft(null);
            root.setRight(null);
        }else{
            if(data.compareTo(root.getData()) >= 1){         //data > root.getData();
                root.setRight(Insert(root.getRight(), data));
            }else if(data.compareTo(root.getData()) <= -1){  //data > root.getData();
                root.setLeft(Insert(root.getLeft(), data));
            }else{      // 找到相同的点什么也不做；

            }
        }
        return root;
    }

    //得到二叉搜索树高度
    public int Height(NTreeNode<T> root){
        if(root == null){
            return 0;
        }
        return ( Height(root.getLeft()) > Height(root.getRight()) ?  Height(root.getLeft()) : Height(root.getRight()) ) + 1;//根节点记为 1
    }

    //最小值节点，最左的叶子
    public NTreeNode<T> FindMin(NTreeNode<T> root){
        if(root == null){ //判断第一次进入的根
            return null;
        }
        if(root.getLeft() == null){
            return root;
        }else{
            return FindMin(root.getLeft());
        }
    }

    //删除节点
    public NTreeNode<T> Delete(NTreeNode<T>root, T data){
        //BinarySearchTreeNode<T> root = (BinarySearchTreeNode<T>) name;
        BinarySearchTreeNode<T> rightMin;//定义泛型变量【注意T】
        if(root == null)
            System.out.println("Element not there in tree!");//没有找到data的节点
        else if (Compare(data, root.getData()) >= 1) {
            root.setRight(Delete(root.getRight(), data));
        }else if(Compare(data, root.getData()) <= -1){
            //root.setLeft(Delete(root.getLeft(), data));
            BinarySearchTreeNode<T> temp = (BinarySearchTreeNode<T>)Delete(root.getLeft(), data);
            root.setLeft(temp);
        }else {
            //找到节点
            if (root.getLeft() != null && root.getRight() != null) {

                rightMin = (BinarySearchTreeNode<T>)FindMin(root.getRight());//找出右子树最小值
                root.setData(rightMin.getData());//右子树最小值替换当前节点值
                root.setRight(Delete(root.getRight(), rightMin.getData()));

            }else if(root.getLeft() == null && root.getRight() == null){ //不填这支就错误
                root = null;
            }else{
                //单支或叶子节点[这样可以令左右孩子都为null]
                if(root.getLeft() == null){
                    root = root.getRight();
                }
                if(root.getRight() == null){
                    root = root.getLeft();
                }

            }
        }
        return root;
    }
}


