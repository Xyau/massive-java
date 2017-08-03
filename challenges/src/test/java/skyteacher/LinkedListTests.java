package skyteacher;

import org.assertj.core.api.JUnitSoftAssertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import skyteacher.linkedList.Node;
import static org.assertj.core.api.Assertions.*;
/**
 * Created by Julian Benitez on 7/29/2017.
 */
public class LinkedListTests {

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void appendToTailTest(){
        Node<Integer> start = new Node<>(0);
        System.out.println(start);
        start.appendToTail(1);
        start.appendToTail(2);
        start.appendToTail(3);
        start.appendToTail(5);
        System.out.println(start);
        assertThat(start.toString()).isEqualToIgnoringCase("{0},{1},{2},{3},{5}");
    }

    @Test
    public void nodeOfTest(){
        Node<Integer> start = Node.of(3,4,5,6);
        System.out.println(start);
        start.appendToTail(2);
        System.out.println(start);
        start.deleteData(5);
        System.out.println(start);
    }
    @Test
    public void equalsTest(){
        Node<Integer> one= Node.of(3,4,5,6);
        Node<Integer> two= Node.of(3,4,5,6);
        System.out.println(one);
        System.out.println(two);
        softly.assertThat(one).isEqualTo(two);

        one.appendToTail(3);
        softly.assertThat(one.size()).isEqualTo(5);
        softly.assertThat(two.size()).isEqualTo(4);
    }
    @Test
    public void removeDuplicatesTest(){
        Node<Integer> original= Node.of(3,3,3,4,5,5,6,6);
        Node<Integer> expected= Node.of(3,4,5,6);
        System.out.println(original);
        System.out.println(original.removeDuplicates());
        softly.assertThat(original).isEqualTo(expected);
    }

    @Test
    public void findkthTest(){
        Node<Integer> original= Node.of(1,2,3,4,5,6,7,8);
        System.out.println(original);
        softly.assertThat(original.findKthToTheLastElement(2).getData()).isEqualTo(6);
        softly.assertThat(original.findKthToTheLastElement(1).getData()).isEqualTo(7);
        softly.assertThat(original.findKthToTheLastElement(0).getData()).isEqualTo(8);
        softly.assertThat(original.findKthToTheLastElement(6).getData()).isEqualTo(2);
        softly.assertThat(original.findKthToTheLastElement(7).getData()).isEqualTo(1);

    }
}
