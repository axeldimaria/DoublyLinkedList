/**
 * Created by axelntwari on 6/8/17.
 */
public class Node<T> {

    private T data;
    private Node next;
    private Node previous;

    public Node(){
        this.data = null;
        this.next = null;
        this.previous = null;
    }

    public Node(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public T getData(){
        return data;
    }

    public void setData(T newData){
        data = newData;
    }

    public Node getNext(){
        return next;
    }
    public Node getPrevious(){
        return previous;
    }

    public void setNext(Node newNode){
        next =newNode;
    }
    public void setPrevious(Node newNode){
        previous =newNode;
    }

    public String toString(){
        return data + "";
    }

}

