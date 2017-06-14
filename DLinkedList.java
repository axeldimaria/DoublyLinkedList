/**
 * Created by axelntwari on 6/8/17.
 */
public class DLinkedList<T> {

    private Node head;
    private Node tail;

    public DLinkedList(){
        // Constructor
        head = new Node();
        tail = new Node();
    }

    public DLinkedList(T data){
        // Constructor with initialization of list
        head = new Node();
        tail = new Node();
        add(data);
    }

    public Boolean isEmpty(){
        if (head.getNext() == null && tail.getPrevious() == null){
            return true;
        }else {
            return false;
        }
    }

    public void add(T data){
        // Creating a new node from the given data
        Node newNode = new Node(data);

        if(head.getNext() == null){
            // If the linked list is empty, just insert the new node between the head and tail
            head.setNext(newNode);
            tail.setPrevious(newNode);
            newNode.setPrevious(head);
            newNode.setNext(tail);

        } else {
            // Adding new node at the end of the tail
            Node lastNode = tail.getPrevious();
            newNode.setPrevious(lastNode);
            newNode.setNext(tail);
            lastNode.setNext(newNode);
            tail.setPrevious(newNode);

        }

    }

    public int size(){
        int count = 0;
        Node currentNode = head.getNext();
        while( currentNode.getNext() != null){
            currentNode = currentNode.getNext();
            count++;
        }
        return count;
    }

    public Boolean search(T data){

        Node currentNode = head;

        while( currentNode.getData() != data && currentNode.getNext() != null ){
            currentNode = currentNode.getNext();
        }

        if (currentNode.getData() == data){
            return true;
        } else {
            return false;
        }
    }

    public Boolean smartSearch(T data){
        //Traverses the DLinkedList from the front and back at the same time.

        Node headStart = head;
        Node tailStart = tail;

        while( headStart.getData() != data &&
                tailStart.getData() != data &&
                headStart != tailStart &&
                headStart.getPrevious() != tailStart)
        {

            headStart = headStart.getNext();
            tailStart = tailStart.getPrevious();
        }

        if (tailStart.getData() == data || headStart.getData() == data){
            return true;
        } else {
            return false;
        }
    }


    public void remove(T data){


        Node currentNode = head;
        while( currentNode.getData() != data && currentNode.getNext() != null ){
            currentNode = currentNode.getNext();
        }

        // Removes the currentNode only if the node with data exists
        if (currentNode.getData() == data){

            System.out.println("Current Node: " + currentNode);

            if (currentNode.getPrevious() == head && currentNode.getNext() == tail){
                //Only one node thus far

                head = new Node();
                tail = new Node();
            } else {
                Node previousNode = currentNode.getPrevious();
                previousNode.setNext(currentNode.getNext());
                tail.setPrevious(previousNode);
            }
        }

    }

    public String toString(){

        if (head.getNext() == null){
            //If the LinkedList is empty
            return "";
        }

        Node currentNode = head.getNext();
        String a = currentNode + "";
        currentNode = currentNode.getNext();
        while (currentNode.getNext() != null) {
            a = a + " -> " + currentNode ;
            currentNode = currentNode.getNext();
        }

        return a;
    }

    public static void main(String[] args){

        DLinkedList<Integer> a = new DLinkedList<Integer>();

        a.add(0);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        // TESTING SEARCH
        System.out.println(a);
        System.out.println("Search for 1: " + a.search(1));
        System.out.println("Search for 9: " + a.search(9));


        // TESTING SIZE
        System.out.println("Size of LinkedList: " + a.size());


        // TESTING DELETING
        a.add(5);
        a.add(6);
        a.add(7);
        System.out.println("Before deleting 5: "+ a);
        a.remove(5);
        System.out.println("After deleting 5: "+ a);

        //Creating a Non-empty Linked List
        DLinkedList<String> b = new DLinkedList<String>("Let's get it!!");
        b.remove("Let's get it!!");
        b.add("This is fucked up!");
        System.out.println("B: " + b);
        b.remove("This is fucked up!");
        System.out.println("B: " + b);

    }

}



