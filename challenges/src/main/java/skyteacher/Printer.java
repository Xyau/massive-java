package skyteacher;

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
}
