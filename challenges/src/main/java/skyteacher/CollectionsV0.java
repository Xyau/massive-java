package skyteacher;


import skyteacher.tuples.Pair;

import java.time.Period;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

//    public static <R> R[] toArray(Collection<R> collection){
//        return collection.toArray(new R[collection.size()]);
//    }

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
    static String findNumber(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == k) return "YES";
        }
        return "NO";
    }


    static int[] oddNumbers(int l, int r) {
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = (l%2==0?l+1:l); i <= r; i+=2) {
            values.add(i);
        }
        return toArray(values);
    }

    static int[] toArray(Collection<Integer> collection){
        int[] arr = new int[collection.size()];
        int a = 0;
        for (Integer i : collection){
            arr[a++]=i;
        }
        return arr;
    }
    class Person {
        public int id;
        public int salary;
        public int children;
        public String civilStatus;
        public int age;

        Person(int id, int salary, int children, String civilStatus, int age) {
            this.id = id;
            this.salary = salary;
            this.children = children;
            this.civilStatus = civilStatus;
            this.age = age;
        }
    }
    int getAnswer(ArrayList<Person> _a) {
        ArrayList<Person> res = new ArrayList<>();
        for(Person p:_a){
            if(p.civilStatus.equals("single") &&
                    p.children <= 3 && p.children >= 1 &&
                    p.age >= 30 && p.age >= 40) res.add(p);
        }
        res.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                Double d1 = o1.salary*.85;
                d1 = d1 - d1 * 0.01 * Math.max(0,4-o1.children);
                Double d2 = o2.salary*.85;
                d2 = d2 - d2 * 0.01 * Math.max(0,4-o2.children);
                return Double.compare(d1,d2);
            }
        });
        return res.get(2).id;
    }

    static int mostFrequentNumber(int[] numbers) {
        HashMap<Integer,Integer> nums = new HashMap<>(10);
        for (Integer i : numbers){
            if(nums.containsKey(i)){
                nums.put(i,nums.get(i)+1);
            } else {
                nums.put(i,1);
            }
        }

        Integer min=null;
        for (Integer i : nums.keySet()){
            if(min == null || nums.get(i) > nums.get(min)){
                min = i;
            }
        }
        return min;
    }

}
