import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public int[] twoSum(int[] numbers, int target){
        int start = 0;
        int end = numbers.length-1;
        int ans[] = new int[2];

        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(sum == target){
                ans[0] = start+1;
                ans[1] = end+1;
                return ans;
            } else if(sum > target) end--;
            else{
                start++;
            }
        }
        return ans;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k]);
                        if(!ans.contains(list)) ans.add(list);
                    }
                }
            }
        }
        return ans;
    }

    public static int[] prefixProduct(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;

        for(int i=1;i<n;i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        return ans;
    }

    
    //  ans = [1,-1,-1,0,0]
    public static void main(String[] args) {
        int nums[] = new int[]{-1,1,0,-3,3};
        int ans[] = prefixProduct(nums);
        for(int i: ans){
            System.out.print(i + ",");
        }
    }

    
}
