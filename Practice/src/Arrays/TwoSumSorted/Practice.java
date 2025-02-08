import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {
    static int secondSmallestNumber(int arr[]){
        int secondSmallest = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;
        int n = 5;
        double ceil = Math.floor(n/3);

        // find smallest
        for(int i=0;i<arr.length;i++){
            if(arr[i] < smallest){
                secondSmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] > smallest && arr[i] < secondSmallest){
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;

        // //find secondSmallest
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i] < secondSmallest && arr[i] != smallest){
        //         secondSmallest = arr[i];
        //     }
        // }
        // return secondSmallest;
    }

    static int[] moveAllZerosToEnd(int arr[]){
        int firstZeroIndex=-1;
        int n = arr.length;

        // find first zero index
        for(int i=0;i<n;i++){
            if(arr[i] == 0) {
                firstZeroIndex = i;
                break;
            }
        }

        if(firstZeroIndex == -1) return arr;

        for(int i=firstZeroIndex+1;i<n;i++){
            if(arr[i] !=0){
                // swap
                int temp = arr[firstZeroIndex];
                arr[firstZeroIndex] = arr[i];
                arr[i] = temp;

                firstZeroIndex++;
            }
        }

        return arr;
    }
    
    static List<Integer> majorityElement(int[] nums) {
        int count1 = 0,count2 = 0;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(count1 == 0 && nums[i] != element2){
                count1=1;
                element1 = nums[i];
            }else if(count2 == 0 && nums[i] != element1){
                count2=1;
                element2 = nums[i];
            }else if(nums[i] == element1) count1++;
            else if(nums[i] == element2) count2++;
            else{
                count1--;
                count2--;
            }
        }

        int ceilCount = (int)Math.floor(nums.length/3);
       
        if(count1 > ceilCount) ans.add(element1);
        if(count2 > ceilCount) ans.add(element2);

        return ans;
    }

    public static List<Integer> majorityElement2(int []v) {
        int n = v.length; //size of the array

        int cnt1 = 0, cnt2 = 0; // counts
        int el1 = Integer.MIN_VALUE; // element 1
        int el2 = Integer.MIN_VALUE; // element 2

        // applying the Extended Boyer Moore's Voting Algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != v[i]) {
                cnt1 = 1;
                el1 = v[i];
            } else if (cnt2 == 0 && el1 != v[i]) {
                cnt2 = 1;
                el2 = v[i];
            } else if (v[i] == el1) cnt1++;
            else if (v[i] == el2) cnt2++;
            else {
                cnt1--; cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el1) cnt1++;
            if (v[i] == el2) cnt2++;
        }

        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) ls.add(el1);
        if (cnt2 >= mini) ls.add(el2);

        // Uncomment the following line
        // if it is told to sort the answer array:
        //Collections.sort(ls); //TC --> O(2*log2) ~ O(1);

        return ls;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,1,3};
        System.out.println(majorityElement(arr));
        System.out.println(majorityElement2(arr));
    }
}
