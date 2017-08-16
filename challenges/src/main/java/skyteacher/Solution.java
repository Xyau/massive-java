package skyteacher;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Julian Benitez on 8/12/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            Integer n = in.nextInt();
            Integer k = in.nextInt();
            int counter[] = new int[k];
            Integer index = 0;
            ArrayList<Integer> seq = new ArrayList<>(n);
            ArrayList<Integer> input = new ArrayList<>();
            in.nextLine();
            Scanner seqScanner = new Scanner(in.nextLine());
            StringBuffer stringBuffer = new StringBuffer();

            while (seqScanner.hasNext()){
                if(todosIguales(counter)){
                    seq.add(index);
                }
                index++;
                input.add(seqScanner.nextInt());
                addTo(counter,0,n);
            }

            Collections.sort(input);

            for (Integer integer:seq){
                stringBuffer.append(input.get(integer)/k);
                stringBuffer.append(" ");
            }

            System.out.println(stringBuffer);
        }
    }

    private static int addTo(int [] arr, int index, int n){
        if(n == 1) return 1;
        if(arr[index] == n-1){
            if(index +1 == arr.length) return arr[index];
            arr[index] = addTo(arr,index+1,n);
        } else {
            arr[index] = arr[index] + 1;
        }
        return arr[index];
    }

    private static boolean todosIguales(int [] arr){
        if(arr.length <= 0)return true;
        Integer max = arr[0];
        for (int a = 0; a < arr.length; a++) {
            if(max != arr[a]) return false;
        }
        return true;
    }


    private void ksums(){
        Scanner in = new Scanner(System.in);
        Integer testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            Integer n = in.nextInt();
            Integer k = in.nextInt();
            ArrayList<Integer> input = new ArrayList<>();
            ArrayList<Integer> seq = new ArrayList<>(n);
            in.nextLine();
            Scanner seqScanner = new Scanner(in.nextLine());
            StringBuffer stringBuffer = new StringBuffer();

            while (seqScanner.hasNext()){
                Integer num = seqScanner.nextInt();
                input.add(num);
            }

            Collections.sort(input);
            for (int index = 0; index < n; index++) {
                if(index == 0){
                    seq.add( input.get(0)/k);
                } else {
                    seq.add( input.get(index)-seq.get(0)*(k-1));
                }
                stringBuffer.append(seq.get(index));
                stringBuffer.append(" ");
            }
            System.out.println(stringBuffer);

        }
    }

    private void bigints(){
        Scanner in = new Scanner(System.in);
        BigInteger p1 = in.nextBigInteger();
        BigInteger p2 = in.nextBigInteger();
        BigInteger p3 = in.nextBigInteger();
        BigInteger N = in.nextBigInteger();

        BigInteger nodes = p1.modPow(p2.pow(N.intValue()),p3);

        BigInteger res = nodes.multiply(nodes.subtract(new BigInteger("1"))).divide(new BigInteger("2")).mod(p3);
        System.out.println(res);
    }

    private void stacks(){
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int size1 = 0;
        int size2= 0;
        int size3= 0;
        Queue<Integer> st1 = new ArrayDeque<>();
        Queue<Integer> st2 = new ArrayDeque<>();
        Queue<Integer> st3 = new ArrayDeque<>();
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            int n = in.nextInt();
            st1.add(n);
            size1 += n;
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            int n = in.nextInt();
            st2.add(n);
            size2 += n;
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            int n = in.nextInt();
            st3.add(n);
            size3 += n;
        }

        while (size1 != size2 || size1 != size3 || size2 != size3){
            if(size1 >= size2 && size1 >= size3 ){
                size1 -= st1.poll();
            } else if (size2 >= size1 && size2 >= size3){
                size2 -= st2.poll();
            } else if (size3 >= size1 && size3 >= size1){
                size3 -= st3.poll();
            }
        }
        System.out.println(size1);
    }

    private void matrixFlip(){
        System.out.println("hhi");
        Scanner sc = new Scanner(System.in);
        Integer querys = sc.nextInt();

        while (sc.hasNext()){
            Integer n = sc.nextInt();
            Integer arr[][] = new Integer[2*n][2*n];
            Integer res = 0;

            for (int i = 0; i < 2*n; i++) {
                for (int j = 0; j < 2 * n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Integer max = Integer.MIN_VALUE;
                    if(max < arr[i][j]) max = arr[i][j];
                    if(max < arr[2*n-i-1][j]) max = arr[2*n-i-1][j];
                    if(max < arr[i][2*n-j-1]) max = arr[i][2*n-j-1];
                    if(max < arr[2*n-i-1][2*n-j-1]) max = arr[2*n-i-1][2*n-j-1];
                    res += max;
                }
            }

            System.out.println(res);;
        }
    }
}
