package skyteacher.deques;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by Julian Benitez on 8/5/2017.
 */
public class SetOfStacks<T> {
    ArrayList<Deque<T>> stacks = new ArrayList<>();
    Integer maxStackSize = 50;

    public SetOfStacks(Integer maxStackSize) {
        this.maxStackSize = maxStackSize;
        stacks.add(new ArrayDeque<T>());
    }

    public void push(T data){
        Deque<T> lastStack = stacks.get(stacks.size()-1);
        if(lastStack.size()<maxStackSize){
            lastStack.push(data);
        } else {
            stacks.add(new ArrayDeque<T>());
            stacks.get(stacks.size()-1).push(data);
        }
    }

    public T pop(){
        Deque<T> lastStack = stacks.get(stacks.size()-1);

        return lastStack.pop();
    }

    @Override
    public String toString() {
        return stacks.toString();
    }
}
