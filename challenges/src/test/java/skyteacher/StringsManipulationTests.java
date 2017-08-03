package skyteacher;

import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

/**
 * Unit test for simple StringsManipulations.
 */
public class StringsManipulationTests {

    @Test
    public void testAllUnique(){
        assertThat(StringsManipulations.allUniqueNaive("asd")).isEqualTo(true);
        assertThat(StringsManipulations.allUniqueNaive("asda")).isEqualTo(false);
    }

    @Test
    public void testIsPermutation(){
        assertThat(StringsManipulations.isPermutation("asda","asdd")).isEqualTo(false);
        assertThat(StringsManipulations.isPermutation("asd","dsa")).isEqualTo(true);
        assertThat(StringsManipulations.isPermutation("asda","asd")).isEqualTo(false);
    }

    @Test
    public void testReverse(){
        assertThat(StringsManipulations.reverse("asd")).isEqualTo("dsa");
        assertThat(StringsManipulations.reverse("julian")).isEqualTo("nailuj");
        assertThat(StringsManipulations.reverse("")).isEqualTo("");
    }
    @Test
    public void testReplace(){
        assertThat(StringsManipulations
                .replaceInPlace("asddddas".toCharArray(),"as".toCharArray(),"xxx".toCharArray())).isEqualTo("xxxddddxxx".toCharArray());
        assertThat(StringsManipulations
                .replaceInPlace("asddds".toCharArray(),"ddd".toCharArray(),"x".toCharArray())).isEqualTo("asxs".toCharArray());
        assertThat(StringsManipulations
                .replaceInPlace("aaasaaasaaa".toCharArray(),"s".toCharArray(),"xxx".toCharArray())).isEqualTo("aaaxxxaaaxxxaaa".toCharArray());
        assertThat(StringsManipulations
                .replaceInPlace("asdddds".toCharArray(),"ddd".toCharArray(),"xx".toCharArray())).isEqualTo("asxxds".toCharArray());
        assertThat(StringsManipulations
                .replaceInPlace("asdddds".toCharArray(),"d".toCharArray(),"x".toCharArray())).isEqualTo("asxxxxs".toCharArray());
    }

    @Test
    public void compressionTest(){
        assertThat(StringsManipulations
                .compress("aaaaasddddas")).isEqualTo("a5s1d4a1s1");
        assertThat(StringsManipulations
                .compress("asddddas")).isEqualTo("asddddas");
    }

    @Test
    public void rotateTest(){
        int n =3;
        Integer[][] image = getFilledMatrix(n,n);
        Printer.printMatrix(image);
        image = StringsManipulations.rotate90degrees(image);
        System.out.println();
        Printer.printMatrix(image);

    }


    private Integer[][] getFilledMatrix(int width, int height){
        Integer[][] image = new Integer[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
//                image[x][y] = (x+y)%((height+width)/2);
                image[x][y] = (x+y);
            }
        }
        return image;
    }
}
