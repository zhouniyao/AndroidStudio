package tree.niming;

//    ┌┬┐ ->┌┬┐->┌┬┐->┌┬┐
//    └┴┘   └┴┘  └┴┘  └┴┘
//     ↑                       ↑
//    front                    rear
/**
 * 线性链-队列
 */
public class LLQueue <T>{
    private LLNode<T> front;
    private LLNode<T> rear;


    public LLQueue(){
        this.front = null;
        this.rear  = null;
    }
    public boolean IsEmpty(){
        return (front == null);
    }

    //入队列
    public void enQueue(T data){
        LLNode newNode = new LLNode(data);
        if(rear != null){
            rear.next = newNode;
        }
        rear = newNode;
        if(front == null){
            front = rear;
        }
    }
    //出队列
//    public LLNode<T> deQueue(){
//        LLNode<T> temp = null;
//        if(IsEmpty()) {
//            //Do something
//        }
//        else{
//            temp = front;
//            front = front.next;
//        }
//        return temp;
//    }
    //取值
    //如果值为引用型，小心->抛出NullPointerException
    public LLNode<T> deQueue(){
        LLNode<T> temp = null;
        if(IsEmpty()) {
            //Do something
        }
        else{

            temp = front;
            front = front.next;
        }
        return temp;
    }
//    public T getT(){
//        return temp;
//    }

}

class LLNode<T>{
    T data;
    LLNode<T> next;

    public LLNode(T data){
        this.data = data;
    }
}
