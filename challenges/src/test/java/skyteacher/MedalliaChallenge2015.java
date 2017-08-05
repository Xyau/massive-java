package skyteacher;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import skyteacher.tuples.Pair;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Julian Benitez on 8/5/2017.
 */
public class MedalliaChallenge2015{
    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void closestNumbersTest(){
        ArrayList<Integer> values = CollectionsV0.arrayListOf(4,-2,-1,3);
        Collection<Pair<Integer,Integer>> res = CollectionsV0.findMinimumAbsoluteDifference(values);
        softly.assertThat(res).as("Original %s",values).containsExactly(Pair.of(-2,-1),Pair.of(3,4));
        values = CollectionsV0.arrayListOf(4,2,1,3);
        res = CollectionsV0.findMinimumAbsoluteDifference(values);
        softly.assertThat(res).as("Original %s",values).containsExactly(Pair.of(1,2),Pair.of(2,3),Pair.of(3,4));
    }

    @Test
    public void possiblePalindromeTest(){
        String s = "aaaasdd";
        softly.assertThat(CollectionsV0.isAnyPermutationAPalindrome(s)).as("%s",s).isEqualTo(true);
        s = "a";
        softly.assertThat(CollectionsV0.isAnyPermutationAPalindrome(s)).as("%s",s).isEqualTo(true);
    }
}
