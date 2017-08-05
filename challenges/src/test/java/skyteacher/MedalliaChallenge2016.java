package skyteacher;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import skyteacher.tuples.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Julian Benitez on 8/5/2017.
 */
public class MedalliaChallenge2016 {
    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void anagramsInPhraseTest(){
        String phrase = "word is drow when dwor";
        String word = "word";

        softly.assertThat(StringsManipulations.countAnagrams(word,phrase)).isEqualTo(3);
        phrase = "nothing to see here";
        word = "word";

        softly.assertThat(StringsManipulations.countAnagrams(word,phrase)).isEqualTo(0);
        word = "dormitory";

        phrase = "dirty room";
        softly.assertThat(StringsManipulations.countAnagrams(word,phrase)).isEqualTo(0);

        phrase = "dirtyroom";
        softly.assertThat(StringsManipulations.countAnagrams(word,phrase)).isEqualTo(1);

        phrase = "roomisdirty";
        softly.assertThat(StringsManipulations.countAnagrams(word,phrase)).isEqualTo(0);
    }

    @Test
    public void stepsToClimb(){
        softly.assertThat(CollectionsV0.fibonacci(0)).isEqualTo(0);
        softly.assertThat(CollectionsV0.fibonacci(1)).isEqualTo(1);
        softly.assertThat(CollectionsV0.fibonacci(2)).isEqualTo(2);
        softly.assertThat(CollectionsV0.fibonacci(3)).isEqualTo(3);
        softly.assertThat(CollectionsV0.fibonacci(4)).isEqualTo(5);
        softly.assertThat(CollectionsV0.fibonacci(10)).isEqualTo(89);
    }
    @Test
    public void ironMan(){
        softly.assertThat(minimum(CollectionsV0.arrayListOf(-5, 4, -2, 3, 1, -1, -6, -1, 0, 5))).isEqualTo(8);
        softly.assertThat(minimum(CollectionsV0.arrayListOf(-5,4,-2, 3, 1))).isEqualTo(6);
    }

    @Test
    public void minimumStepsToReachNumberFrom0(){
        softly.assertThat(minimumStep(5)).isEqualTo(4);
        softly.assertThat(minimumStep(3)).isEqualTo(3);
        softly.assertThat(minimumStep(50)).isEqualTo(8);
    }

    @Test
    public void arrayGaemMinSteps(){
        softly.assertThat(arrayGameMinimumSteps(CollectionsV0.arrayListOf(1,2,3))).isEqualTo(3);
        softly.assertThat(arrayGameMinimumSteps(CollectionsV0.arrayListOf(2,2,2))).isEqualTo(0);
    }

    private Integer minimumStep(Integer number){
        Integer steps = 0;
        while (number != 0){
            if(number %2 == 0) number = number/2;
            else number -=1;
            steps++;
        }
        return steps;
    }

    private Integer arrayGameMinimumSteps(ArrayList<Integer> numbers){
        Collections.sort(numbers);
        Integer min = numbers.get(0);
        return numbers.stream().mapToInt(a -> a-min).sum();
    }

    private Integer minimum(ArrayList<Integer> encounters){
        Integer minLife = 1;
        Integer life = 1;
        for (Integer i : encounters){
            life += i;
            if(life <= 0){
                minLife -= life-1;
                life = 1;
            }
        }
        return minLife;
    }
}
