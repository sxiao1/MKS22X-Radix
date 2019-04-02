import java.util.*;
public class MyLinkedList<T>{
  private int size;
  private Node start;
  private Node end;
  public MyLinkedList(){
    start = null;
    end = null;
    size = 0;
  }
  public Node getNode(int index){
    Node beg = start;
    for(int i = 0; i < index; i++){
      beg = beg.getNext();
    }
    return beg;
  }
  public void clear(){
    start = null;
    end = null;
    size = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String newstr = "[";
    int i = 0;
    for(; i < size() -1; i++){
      newstr += getNode(i).getValue() + ",";
    }
    newstr += getNode(i).getValue();
    return newstr + "]";
  }
  public boolean add(T newNode){
    Node add = new Node(newNode);
    if(size() == 0){
      start = add;
      end = add;
    }
    else if(size() == 1){
      end = add;
      start.setNext(add);
      add.setPrev(start);
    }
    else{
      add.setPrev(end);
      end.setNext(add);
      end = add;
    }
    size++;
    return true;
  }
  private class Node{
    private T data;
    private Node next;
    private Node prev;
    public Node(T num){
      data = num;
      next = null;
      prev = null;
    }
    public Node getNext(){
      return next;
    }
    public Node getPrev(){
      return prev;
    }
    public T getNum(){
      return data;
    }
    public T getValue(){
      return data;
    }
    public void setNext(Node newNum){
      next = newNum;
    }
    public void setPrev(Node newNum){
      prev = newNum;
    }
    public void setValue(T newNum){
      data = newNum;
    }
    public String toString(Node n){
      String newstr = "" + n.getValue();
      return newstr;
    }
  }

}
