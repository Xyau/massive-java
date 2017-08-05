package skyteacher;


import skyteacher.tuples.Pair;

import java.util.*;

/**
 * Created by Julian Benitez on 8/5/2017.
 */
public class CollectionsV0 {
    public static Collection<Pair<Integer,Integer>> findMinimumAbsoluteDifference(List<Integer> values){
        Collections.sort(values);
        Integer minimum=null;
        List<Pair<Integer,Integer>> result = new ArrayList<>();
        for (int i = 0; i < values.size() -1; i++) {
            Integer abs = Math.abs(values.get(i)-values.get(i+1));
            if(minimum == null || minimum > abs){
                minimum = abs;
                result = new ArrayList<>();
                result.add(Pair.of(values.get(i),values.get(i+1)));
            }else if (minimum == abs){
                result.add(Pair.of(values.get(i),values.get(i+1)));
            }
        }
        return result;
    }

    public static Boolean isAnyPermutationAPalindrome(String string){
        HashMap<Character, Integer> wordCounts = StringsManipulations.getWordCount(string);
        Boolean uneven = false;
        for (Character c : wordCounts.keySet()){
            if(wordCounts.get(c) % 2 ==1){
                if(uneven) {
                    return false;
                } else {
                    uneven = true;
                }
            }
        }
        return true;
    }


    public static <R> ArrayList<R> arrayListOf(R... datas){
        ArrayList<R> result = new ArrayList<R>();
        for (R data : datas){
            result.add(data);
        }
        return result;
    }

    public static Integer fibonacci(Integer nth){
        if(nth == 0)return 0;
        if(nth == 1)return 1;

        Integer prev=0;
        Integer cur=1;
        for (int i = 0; i < nth; i++) {
            Integer temp=cur+prev;
            prev = cur;
            cur = temp;
        }
        return cur;
    }
}
