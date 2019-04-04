import java.util.*;
import java.io.*;
public class MyLinkedList<T extends Comparable<T>>{
  private int size;
  private Node start;
  private Node end;
  public MyLinkedList(){
    start = null;
    end = null;
    size = 0;
  }
  public T removeFront(){
    if(size() == 0){
      throw new IndexOutOfBoundsException("");
    }
    Node current = start;
    T old = current.getValue();
    if(size() == 1){
      start = null;
      end = null;
    }
    else{
      start = current.getNext();
      start.setPrev(null);
    }
    size--;
    return old;
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
  public T get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getValue();
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
  public void add(int index, T num){
    Node add = new Node(num);
    if(index == size()){
      add(num);
      return;
    }
    else if(index == 0){
      add.setNext(start);
      start.setPrev(add);
      start = add;
    }
    else{
      add.setNext(getNode(index));
      add.setPrev(getNode(index - 1));
      getNode(index - 1).setNext(add);
      getNode(index).setPrev(add);
    }
    size++;
  }
  public boolean addBeg(T num){
    Node add = new Node(num);
    if(size() == 0){
      start = add;
      end = add;
      size ++;
    }
    else{
      add.setNext(start);
      start.setPrev(add);
      start = add;
      size++;
    }
    return true;
  }
  public boolean addEnd(T num){
    Node add = new Node(num);
    if(size() == 0){
      start = add;
      end = add;
    }
    else{
      add.setPrev(end);
      end.setNext(add);
      end = add;
    }
    return true;
  }
  public void extend(MyLinkedList<T> other){
	   if(other.size() == 0){
	      return;
	     }
	   if(size()==0){
	      start=other.start;
      }
	   else{
	      end.setNext(other.start);
	      other.start.setPrev(end);
	   }
	   end=other.end;
	   size+=other.size();
     other.clear();
     return;
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
