import java.util.*;
public class Radix{
  public static void radixsort(int[] data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] bucket = new MyLinkedList[20];
    for(int i = 0; i < bucket.length; i++){
      bucket[i] = new MyLinkedList<Integer>();
    }
    int maxNum = 0;
    int maxInd = 0;
    for(int i = 0; i < data.length; i++){
      if(i == 0){
        maxNum = data[i];
        maxInd = i;
      }
      else{
        if(data[i] > maxNum){
          maxNum = data[i];
          maxInd = i;
        }
      }
    }
    int temp1 = data[maxInd];
    data[maxInd] = data[data.length -1];
    data[data.length -1] = temp1;
    int[] tempdata = new int[data.length];
    for(int i = 0; i < data.length; i++){
      int temp = data[i] % 10;
      tempdata[i] = temp;
    }
  }
}
