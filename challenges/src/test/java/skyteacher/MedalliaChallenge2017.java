package skyteacher;

import org.assertj.core.api.JUnitSoftAssertions;
import org.assertj.core.api.MapAssert;
import org.junit.Rule;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static skyteacher.CollectionsV0.mostFrequentNumber;

/**
 * Created by Julian Benitez on 8/5/2017.
 */
public class MedalliaChallenge2017 {
    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();


    @Test
    public void mostRepeats(){
        System.out.println(mostFrequentNumber(new int[]{1,0}));
    }
    @Test
    public void efficiency(){
        System.out.println(minShotsForEfficiency((float) 33.4));
    }

    int minShotsForEfficiency(float efficiency) {
        if(efficiency == 100) return 1;
        float target = efficiency*10;
        int total =1;
        int goals= 1;
        float ratio;

        do{
            ratio = Math.round(goals*1.0/total*1000);
            if(ratio > target ) total++;
            else if(ratio < target) goals++;
        } while (Math.abs(ratio - target) >= 1);

        return total;
    }

    @Test
    public void money(){
        System.out.println(maxMoney(3,3));
    }
    static int maxMoney(long n, long k) {
        Integer notColected = 0;
        Boolean finished = false;
        do {
            Double x1 = (-1 + Math.sqrt(Math.pow(1, 2) - (-8*(k+notColected))))/2;
            Double x2= (-1 - Math.sqrt(Math.pow(1, 2) - (-8*(k+notColected))))/2;

            if(x1 == Math.floor(x1) && x1 > 0 && x1 < n && x1 != notColected*1.0){
                notColected ++;
            } else if(x2 == Math.floor(x2) && x2 > 0 && x2 < n && x2 != notColected*1.0){
                notColected ++;
            } else {
                finished = true;
            }
        } while (!finished);
        return (int) (((n*(n+1)/2)-notColected)%(10^9+7));
    }

    @Test
    public void integerPals(){
        System.out.println(nonPalindromicMultiples(1515));
    }

    int nonPalindromicMultiples(int n) {
        int palindromes =0;
        int curr=n;

        while (curr < 10000){
            if(!isPalindrome(curr)) palindromes++;
            curr += n;
        }
        return palindromes;
    }

    private boolean isPalindrome(int curr) {
        if(curr < 10) return true;
        if(curr < 100){
            if (curr % 10 != curr / 10) return false;
            else return true;
        }
        if(curr < 1000){
            if (curr % 10 != curr / 100) return false;
            else return true;
        }
            if (curr % 10 != curr / 1000) return false;
            if ((curr % 100) / 10 != (curr % 1000) / 100) return false;
        return true;
    }

    @Test
    public void mostFrequent(){
        System.out.println(mostFrequentNumber(new int[]{3,45,6,7}));
    }

    static int mostFrequentNumber(int[] numbers) {
        HashMap<Integer,Integer> count = new HashMap<>();
        for (int i: numbers){
            if(count.containsKey(i)){
                count.put(i,count.get(i)+1);
            }else {
                count.put(i,1);
            }
        }

        Integer max = null;
        List<Integer> nums = count.keySet().stream( ).collect(Collectors.toList());
        Collections.sort(nums);
        for (Integer i:nums){
            if(max == null || count.get(i) > count.get(max)){
                max = i;
            }
        }
        return max;
    }
}

