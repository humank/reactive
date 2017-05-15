package solid.humank.actor;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yikai on 12/05/2017.
 */
public class TwoNumberTest {

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    @Test
    public void testTwoNumbers(){
        int[] numbers ={0,1,2};
        int[] target = {0,1};
        Assert.assertArrayEquals(target,twoSum(numbers,1));
    }

}
