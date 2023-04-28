import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumOptimal {

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int j = 0; j < nums.length; j++) {
            if (map.containsKey(nums[j]) && j != map.get(nums[j]))
                return new int[] { map.get(nums[j]), j };
            else
                map.put(target - nums[j], j);
        }

        return null;
    }
}
