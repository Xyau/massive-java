package skyteacher;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Julian Benitez on 7/13/2017.
 */
public class Printer {

    public static void printMatrix(Object[][] array){
        if(array.length == 0) {
            System.out.println("Empty array");
            return;
        }
        StringBuffer buffer = new StringBuffer(array[0].length);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                buffer.append(array[i][j]);
                buffer.append(array[i][j].toString().length() == 1?"  ":" ");
            }
            System.out.println(buffer);
            buffer.setLength(0);
        }
    }

    public static void printArray(int[] array){
        if(array.length == 0) {
            System.out.println("Empty array");
            return;
        }
        StringBuffer buffer = new StringBuffer(array.length);
        for (int i = 0; i < array.length; i++) {
            buffer.append(array[i]);
            buffer.append(" ");
        }
        System.out.println(buffer);
    }

    public static void printCollection(Collection collection){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        for (Object o : collection){
            stringBuffer.append(o.toString());
            stringBuffer.append(",");
        }
        stringBuffer.setLength(stringBuffer.length()-1);
        stringBuffer.append("}");
        System.out.println(stringBuffer);
    }

    public static void printHashmap(HashMap hashMap){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        for (Object o : hashMap.keySet()){
            stringBuffer.append("[");
            stringBuffer.append(o.toString());
            stringBuffer.append(" -> ");
            stringBuffer.append(hashMap.get(o).toString());
            stringBuffer.append("],");
        }
        stringBuffer.setLength(stringBuffer.length()-1);
        stringBuffer.append("}");
        System.out.println(stringBuffer);
    }
}
