import java.util.*;
public class Radix{
  public static void radixsort(int [] data){
  MyLinkedList<Integer> tempB = new MyLinkedList<Integer>();
  for(int i = 0; i < data.length; i++){
    tempB.add(data[i]);
    //System.out.println(tempB.get(i));
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
  MyLinkedList<Integer>[] bucket = new MyLinkedList[20];
	for(int i = 0; i < 20; i++){
            bucket[i] = new MyLinkedList<Integer>();
  }
  int ind = 0;
	while(ind < maxDigits){
	    for(int i=0;i<tempB.size();i++){
		  int num = tempB.get(i);
      int temp = num;
      if(ind > 0){
		    temp=num/((int)Math.pow(10,ind));
      }
      int digit = temp % 10;
      bucket[digit].add(num);
	    }
	    for(int i=0;i<bucket.length;i++){
        //System.out.println(bucket[i]);
		    data[i] = bucket[i].removeFront();
	    }
	    ind++;
	   }
  }

    public static void main(String[] args) {
      int[] testing = {0,17,5,8,332,4,12,32,15,25,167};
      System.out.println(Arrays.toString(testing));
      Radix.radixsort(testing);
      System.out.println(Arrays.toString(testing));
    }

}
