package solid.humank.actor;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yikai on 14/05/2017.
 */
public class BalacneArrayTest {


    static final int[] sut = {-7, 1, 5, 2, -4, 3, 0};

    public static int solution(int[] target) {
        int idx=0;
        int a=0;
        int b= Arrays.stream(target).sum();
        for(int i=0;i<sut.length;i++){
            b-=sut[i];
            if(a==b){
                idx= i;
                break;
            }else{
                a+=sut[i];
            }
        }
        return idx;
    }

    @Test
    public void test(){
        Assert.assertEquals(3,solution(sut));
    }
}
