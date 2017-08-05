package skyteacher;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import java.util.BitSet;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

/**
 * Unit test for simple StringsManipulations.
 */
public class StringsManipulationTests {

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();


    @Test
    public void isAnagramtest(){
        softly.assertThat(StringsManipulations.isAnagram("asd","sad")).isEqualTo(true);
        softly.assertThat(StringsManipulations.isAnagram("asdaa","sad")).isEqualTo(false);
        softly.assertThat(StringsManipulations.isAnagram("aasdaa","aaasad")).isEqualTo(true);
        softly.assertThat(StringsManipulations.isAnagram("aasdaan","aaasadñ")).isEqualTo(false);
    }

    @Test
    public void allUniqueTest(){
        softly.assertThat(StringsManipulations.allUniqueNaive("asd")).isEqualTo(true);
        softly.assertThat(StringsManipulations.allUniqueNaive("asda")).isEqualTo(false);
    }

    @Test
    public void isPermutationTest(){
        softly.assertThat(StringsManipulations.isPermutation("asda","asdd")).isEqualTo(false);
        softly.assertThat(StringsManipulations.isPermutation("asd","dsa")).isEqualTo(true);
        softly.assertThat(StringsManipulations.isPermutation("asda","asd")).isEqualTo(false);
    }

    @Test
    public void testReverse(){
        softly.assertThat(StringsManipulations.reverse("asd")).isEqualTo("dsa");
        softly.assertThat(StringsManipulations.reverse("julian")).isEqualTo("nailuj");
        softly.assertThat(StringsManipulations.reverse("")).isEqualTo("");
    }
    @Test
    public void testReplace(){
        softly.assertThat(StringsManipulations
                .replaceInPlace("asddddas".toCharArray(),"as".toCharArray(),"xxx".toCharArray())).isEqualTo("xxxddddxxx".toCharArray());
        softly.assertThat(StringsManipulations
                .replaceInPlace("asddds".toCharArray(),"ddd".toCharArray(),"x".toCharArray())).isEqualTo("asxs".toCharArray());
        softly.assertThat(StringsManipulations
                .replaceInPlace("aaasaaasaaa".toCharArray(),"s".toCharArray(),"xxx".toCharArray())).isEqualTo("aaaxxxaaaxxxaaa".toCharArray());
        softly.assertThat(StringsManipulations
                .replaceInPlace("asdddds".toCharArray(),"ddd".toCharArray(),"xx".toCharArray())).isEqualTo("asxxds".toCharArray());
        softly.assertThat(StringsManipulations
                .replaceInPlace("asdddds".toCharArray(),"d".toCharArray(),"x".toCharArray())).isEqualTo("asxxxxs".toCharArray());
    }

    @Test
    public void compressionTest(){
        softly.assertThat(StringsManipulations
                .compress("aaaaasddddas")).isEqualTo("a5s1d4a1s1");
        softly.assertThat(StringsManipulations
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

    @Test
    public void Ipv4ParseTest(){
        softly.assertThat(StringsManipulations.isIPV4("123.45.67.4")).isEqualTo(true);
        softly.assertThat(StringsManipulations.isIPV4("12.35.776.34")).isEqualTo(false);
        softly.assertThat(StringsManipulations.isIPV4("12.35a.776.34")).isEqualTo(false);
        softly.assertThat(StringsManipulations.isIPV4("12..776.34")).isEqualTo(false);
    }

     @Test
    public void Ipv6ParseTest(){
        softly.assertThat(StringsManipulations.isIPV6("2001:0db8:0000:00001:0000:ff00:0042:8329")).isEqualTo(true);
        softly.assertThat(StringsManipulations.isIPV6("2001:0db8:0000::0000:ff00:0042:8329")).isEqualTo(true);
        softly.assertThat(StringsManipulations.isIPV6("2001:0db8:0000:0000:ff00:0042:8329")).isEqualTo(false);
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
