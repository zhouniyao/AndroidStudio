package tree.niming;

/**
 * Created by Administrator on 2017/11/14.
 */

public class AVLTree  <T extends Comparable<T>>{
    private AVLTreeNode<T> head;

    public AVLTreeNode<T> getHead(){
        return head;
    }
    public NTreeNode<T> Create(T[] data){
        NTreeNode<T> root = null;
        for(T i : data){
            root = Insert(root, i);
        }
        head = (AVLTreeNode<T> )root;
        return root;
    }
    //先根遍历
    public  void PreOrder(NTreeNode<T> root){
        if(root != null){
            //Do something;
            System.out.print(root.getData()+"  ");
            PreOrder(root.getLeft());
            PreOrder(root.getRight());
        }
    }
    //逐层打印
    public void LevelPrint(NTreeNode<T> root){
        if(root == null) return;
        else{
            LLQueue<NTreeNode<T>> Q = new LLQueue<>();
            LLNode<NTreeNode<T>> temp;
            Q.enQueue(root);
            while(!Q.IsEmpty()){
                temp = Q.deQueue();//取队头的值
                //Do something
                System.out.print(temp.data.getData() + "  ");//打印
                if(temp.data.getLeft() != null){
                    Q.enQueue(temp.data.getLeft());//左儿子入队列
                }
                if(temp.data.getRight() != null){
                    Q.enQueue(temp.data.getRight());//右儿子入队列
                }

            }
        }
    }

    //求树的高度
    int Height(NTreeNode<T> root){
        return Height((AVLTreeNode<T>) root);
    }
    //求AVL树的高度
    int Height(AVLTreeNode<T> root){
        if(root == null)
            return -1;
        else
            return root.getHeight();//节点中已保存Height = 根到该节点的路径长(根记为0)
    }

    //可能违背AVL树性质的4种情况
    //1 在节点X的左孩子节点的左子树中插入元素
    //左左旋转
    AVLTreeNode<T> SingleRotateLeft(AVLTreeNode<T> X){
        AVLTreeNode W = (AVLTreeNode<T>)X.getLeft();
        X.setLeft(W.getRight());
        W.setRight(X);

        X.setHeight( Math.max(Height(X.getLeft()), Height(X.getRight())) + 1);
        W.setHeight( Math.max(Height(W.getLeft()), X.getHeight()) + 1);
        return W;
    }

    //2 在节点Z的左孩子节点的右子树中插入元素 [左->右]放入
    //左右旋转（双旋转）先在X右旋转，再在Z左旋转，（X是Z的左孩子)   [照图示做]
//    AVLTreeNode<T> DoubleRotatewithLeft(AVLTreeNode<T> Z){  //have a bug
//        Z.setLeft(SingleRotateRight((AVLTreeNode<T>)Z.getLeft()));
//        return SingleRotateLeft(Z);
//    }
    AVLTreeNode<T> DoubleRotatewithLeft(AVLTreeNode<T> Z){
        AVLTreeNode<T> X = (AVLTreeNode<T>) Z.getLeft();
        AVLTreeNode<T> Y = (AVLTreeNode<T>)X.getRight();
        X.setRight(Y.getLeft());
        Y.setLeft(X);
        Z.setLeft(Y.getRight());
        Y.setRight(Z);
        return Y;
    }

    //3 在节点Z的右孩子节点的左子树中插入元素  [右->左]放入
    //右左旋转，先在X左旋转，再在Z右旋转，（X是Z的右孩子）
//    AVLTreeNode<T> DoubleRotatewithRight(AVLTreeNode<T> Z){ //have a bug
//        Z.setLeft(SingleRotateLeft((AVLTreeNode<T>)Z.getRight()));
//        return SingleRotateRight(Z);
//    }
    AVLTreeNode<T> DoubleRotatewithRight(AVLTreeNode<T> Z){
        AVLTreeNode<T> X = (AVLTreeNode<T>) Z.getRight();
        AVLTreeNode<T> Y = (AVLTreeNode<T>)X.getLeft();
        X.setLeft(Y.getRight());
        Y.setRight(X);
        Z.setRight(Y.getLeft());
        Y.setLeft(Z);
        return Y;
    }


    //4 在节点X的右孩子节点的右子树中插入元素
    //右右旋转
    AVLTreeNode<T> SingleRotateRight(AVLTreeNode<T> W){
        AVLTreeNode X = (AVLTreeNode<T>)W.getRight();
        W.setRight(X.getLeft());
        X.setLeft(W);
        W.setHeight( Math.max(Height(W.getLeft()), Height(W.getRight())) + 1);
        X.setHeight( Math.max(Height(X.getLeft()), W.getHeight()) + 1);
        return X;
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


    //AVL树的插入操作
    //插入一个元素后，需要检查高度是否平衡，如果不平衡，需要调用相应的旋转函数
    NTreeNode<T> Insert(NTreeNode<T> root, T data){
        return Insert((AVLTreeNode) root, data);
    }
    //AVL树的插入操作【改】
    AVLTreeNode<T> Insert( AVLTreeNode<T> root, T data){
        if(root == null){
            root = new AVLTreeNode();
            root.setData(data);
            root.setHeight(0);
            root.setLeft(null);
            root.setRight(null);
        }
        else if(Compare(data, root.getData()) < 0){
            root.setLeft(Insert(root.getLeft(), data));//向左子树插入
            if((Height(root.getLeft())) - Height(root.getRight()) == 2){
                if(Compare(data, root.getLeft().getData()) <0 ){//情形1
                    root = SingleRotateLeft(root);
                }
                else{
                    root = DoubleRotatewithLeft(root);//情形2
                }
            }
        }
        else if(Compare(data, root.getData()) > 0){
            root.setRight(Insert(root.getRight(),data));//向右子树插入
            if((Height(root.getRight()) - Height(root.getLeft())) == 2){
                if(Compare(data, root.getRight().getData()) > 0){//情形4
                    root = SingleRotateRight(root);
                }else
                {
                    root = DoubleRotatewithRight(root);//情形3
                }
            }
        }
        //相等时，数据已经在树中，什么也不做
        root.setHeight(Math.max(Height(root.getLeft()), Height(root.getRight())) + 1);//新调整高度
        return root;
    }


    //【例】判断一颗二叉搜索树，是否为AVL树。不是AVL树，返回-1
    int IsAVL(BinaryTreeNode root){
        int left, right;
        if(root == null){
            return 0;
        }
        left = IsAVL(root.getLeft());
        if(left == -1){
            return left;
        }

        right = IsAVL(root.getRight());
        if(right == -1){
            return right;
        }

        if(Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right)+1;
    }

    //逐层打印
    public void PrintTree(NTreeNode<T> root){

        if(root == null)return;
        AVLTreeNode<T> symbol = new AVLTreeNode<>();//标识节点
        int level = Height(root);//节点所在的高，根最高【平衡二叉树的高度反了】
        //满二叉树上，n层的节点数为2^n
        int leafNum = (int)Math.pow(2, level);//满二叉树叶子数（最低层）
        LLQueue<NTreeNode<T>> Q = new LLQueue<>();//新建二叉搜索树节点队列
        LLNode<NTreeNode<T>> temp;
        Q.enQueue(root);//根入队列
        //逐层
        for(int i=0; i <= level; i++){
            int num = (int)Math.pow(2, i);//每一层最多为2^n
            int length = Math.round(leafNum/(num +1));//int length = (leafNum -(num + 1))/(num + 1);
            //System.out.println(num);
            for(int j = 0; j < num; j++){ //每一层最多为2^n 节点
                temp = Q.deQueue();//取队头
                //打印////////////////////////////
                for(int k = 0; k < length; k++){
                    System.out.print("//");
                }
                //队列中的节点为symbol，打印占位符//
                if(symbol == (temp.data)){ //temp.data == symbol
                    System.out.print("//");
                }else {//否则打印节点信息
                    T info = temp.data.getData();
                    System.out.print(info);//打印节点值
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


}



/*

//平衡二叉搜索树，平衡因子k为左子树和右子树的高度差
//k=0，完全平衡二叉搜索树
//k=1，AVL(Adelson-Velskii and Landis)树，即左子树与右子树的高度差最多不超过1
class AVLTreeNode2{
    private int data;
    private int height;
    private AVLTreeNode left;
    private AVLTreeNode right;

    public int getData(){
        return data;
    }
    public void setData(int data){
        this.data = data;
    }
    public int getHeight(){
        return height;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public AVLTreeNode getLeft(){
        return left;
    }
    public void setLeft(AVLTreeNode left){
        this.left = left;
    }
    public AVLTreeNode getRight(){
        return right;
    }
    public void setRight(AVLTreeNode right){
        this.right = right;
    }
    //求AVL树的高度
    int Height(AVLTreeNode root){
        if(root == null)
            return -1;
        else
            return root.getHeight();
    }

    //可能违背AVL树性质的4种情况
    //1 在节点X的左孩子节点的左子树中插入元素
    //左左旋转
    AVLTreeNode SingleRotateLeft(AVLTreeNode X){
        AVLTreeNode W = X.getLeft();
        X.setLeft(W.getRight());
        W.setRight(X);

        X.setHeight( Math.max(Height(X.getLeft()), Height(X.getRight())) + 1);
        W.setHeight( Math.max(Height(W.getLeft()), X.getHeight()) + 1);
        return W;
    }

    //2 在节点Z的左孩子节点的右子树中插入元素
    //左右旋转【命名不服】（双旋转）先在X右旋转，再在Z左旋转，（X是Z的左孩子)
    AVLTreeNode DoubleRotatewithLeft(AVLTreeNode Z){
        Z.setLeft(SingleRotateRight(Z.getLeft()));
        return SingleRotateLeft(Z);
    }


    //3 在节点Z的右孩子节点的左子树中插入元素
    //右左旋转，先在X左旋转，再在Z右旋转，（X是Z的右孩子）
    AVLTreeNode DoubleRotatewithRight(AVLTreeNode Z){
        Z.setLeft(SingleRotateLeft(Z.getRight()));
        return SingleRotateRight(Z);
    }


    //4 在节点X的右孩子节点的右子树中插入元素
    //右右旋转
    AVLTreeNode SingleRotateRight(AVLTreeNode W){
        AVLTreeNode X = W.getRight();
        W.setRight(X.getLeft());
        X.setLeft(W);
        W.setHeight( Math.max(Height(W.getLeft()), Height(W.getRight())) + 1);
        X.setHeight( Math.max(Height(X.getLeft()), W.getHeight()) + 1);
        return X;
    }

    //AVL树的插入操作
    //插入一个元素后，需要检查高度是否平衡，如果不平衡，需要调用相应的旋转函数
    AVLTreeNode Insert(AVLTreeNode root, AVLTreeNode parent, int data){
        if(root == null){
            root = new AVLTreeNode();
            root.setData(data);
            root.setHeight(0);
            root.setLeft(null);
            root.setRight(null);
        }
        else if(data < root.getData()){
            root.setLeft(Insert(root.getLeft(), root, data));//向左子树插入
            if((Height(root.getLeft())) - Height(root.getRight()) == 2){
                if(data < root.getLeft().getData()){//情形1
                    root = SingleRotateLeft(root);
                }
                else{
                    root = DoubleRotatewithLeft(root);//情形2
                }
            }
        }
        else if(data > root.getData()){
            root.setRight(Insert(root.getRight(), root, data));//向右子树插入
            if((Height(root.getRight()) - Height(root.getLeft())) == 2){
                if(data > root.getRight().getData()){//情形4
                    root = SingleRotateRight(root);
                }else
                {
                    root = DoubleRotatewithRight(root);//情形3
                }
            }
        }
        //否则，数据已经在树中，什么也不做
        root.setHeight(Math.max(Height(root.getLeft()), Height(root.getRight())) + 1);//新调整高度
        return root;
    }

    //【例】判断一颗二叉搜索树，是否为AVL树。不是AVL树，返回-1
    int IsAVL(BinaryTreeNode root){
        int left, right;
        if(root == null){
            return 0;
        }
        left = IsAVL(root.getLeft());
        if(left == -1){
            return left;
        }

        right = IsAVL(root.getRight());
        if(right == -1){
            return right;
        }

        if(Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right)+1;
    }
}
*/