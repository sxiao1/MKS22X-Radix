import java.util.*;
public class Radix{
  public static void radixsort(int[] data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] bucket = new MyLinkedList[20];
    for(int i = 0; i < bucket.length; i++){
      bucket[i] = new MyLinkedList<>();
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
    String maxStr = "" + maxNum;
    int maxDigits = maxStr.length();
    int index = 0;
    while(index < maxDigits){
      for(int i = 0; i < data.length; i++){
        int temp = data[i];
        int newTemp = temp;
        if(index != 0){
          newTemp = temp / ((int) Math.pow(10, index));
        }
        int num = newTemp % 10;
        bucket[num].add(temp);
      }
      
    }
  }
}
