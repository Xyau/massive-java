package skyteacher;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import skyteacher.deques.SetOfStacks;

/**
 * Created by Julian Benitez on 8/5/2017.
 */
public class DequesTests {


    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void SetOfStacksTest(){
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(5);
        setOfStacks.push(5);
        setOfStacks.push(2);
        setOfStacks.push(4);
        setOfStacks.push(6);
        setOfStacks.push(8);
        setOfStacks.push(3);
        setOfStacks.push(2);
        System.out.println(setOfStacks);
    }
}
