import java.util.*;
public class Radix{
  public static void radixsort(int[] data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] bucket = new MyLinkedList[10];
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
    
  }
}
