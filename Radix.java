import java.util.*;
public class Radix{
  public static void radixsort(int[] data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] bucket = new MyLinkedList[20];
    for(int i =0; i < bucket.length; i++){
      bucket[i] = new MyLinkedList();
    }
    MyLinkedList<Integer> tempB = new MyLinkedList();
    for(int i = 0; i < data.length; i++){
      tempB.add(data[i]);
    }
    for(int i = 0; i <data.length; i++){
      if(data[i] < 0){
        bucket[9 + data[i] % 10].addBeg(data[i]);
      }
      else{
        bucket[10 + data[i] % 10].addEnd(data[i]);
      }
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
      tempB.clear();
      for(int i = 0; i < data.length; i++){
        tempB.extend(bucket[i]);
      }
      index++;
    }
    for(int i = 0; i < data.length; i ++){
      System.out.println(tempB.removeFront());
      data[i] = tempB.removeFront();
    }
  }
  public static void main(String[] args) {
    int[] test = {23,4,55, 98, 80};
    radixsort(test);
    String newstr = "";
    for(int i = 0; i < test.length; i++){
      newstr += "" + test[i];
    }
  }
}
