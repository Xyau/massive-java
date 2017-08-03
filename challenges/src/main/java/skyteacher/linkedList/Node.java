package skyteacher.linkedList;

import org.javatuples.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * Created by Julian Benitez on 7/29/2017.
 */
public class Node<T> {
    private Node<T> next = null;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void appendToTail(T data){
        if(next == null){
            next = new Node<>(data);
        }else {
            next.appendToTail(data);
        }
    }

    public Node<T> deleteData(T data){
        if(data.equals(this.data)){
            if(next == null){
                return null;
            } else {
                return next;
            }
        } else if(next != null){
            next = next.deleteData(data);
        }
        return this;
    }

    public Integer size(){
        Node<T> node = this;
        Integer res = 0;
        do {
            res++;
            node = node.next;
        }while (node != null);
        return res;
    }

    public Node<T> removeDuplicates(){
        Node<T> node = this;
        Node<T> prev = null;
        HashSet<Object> set = new HashSet<>();
        do {
            if(!set.contains(node.getData())) {
                set.add(node.getData());
                if(prev!= null){
                    prev.next = node;
                }
                prev = node;
            } else {
                prev.next =null;
            }
            node = node.next;
        }while (node != null);
        return this;
    }

    private Pair<Node<T>,Integer> findKthToTheLastElementRec(Integer k) {
        if(next == null){
            return Pair.with(this,0);
        } else {
            Pair<Node<T>,Integer> node = next.findKthToTheLastElementRec(k);
            if(node.getValue1()+1 == k){
                return Pair.with(this,node.getValue1()+1);
            } else {
                return Pair.with(node.getValue0(),node.getValue1()+1);
            }
        }
    }

    public Node<T> findKthToTheLastElement(Integer k){
        return findKthToTheLastElementRec(k).getValue0();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append(data);
        stringBuffer.append("}");
        if(next != null){
            stringBuffer.append(",");
            stringBuffer.append(next);
        }
        return stringBuffer.toString();
    }

    public static <R> Node<R> of(R... datas){
        Node<R> next = null;
        Node<R> node = null;
        for (R data : datas){
            if(node == null) {
                node = new Node<R>(data);
                next = node;
            } else {
                next.next = new Node<R>(data);
                next = next.next;
            }
        }
        return node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> other = (Node<?>) o;
        Node<T> localNode = this;
        do{
            if(localNode.data != other.data) return false;
            other = other.next;
            localNode = localNode.next;
            if(other == null && localNode ==null){
                return true;
            } else if(other == null || localNode == null) {
                return false;
            }
        } while (localNode != null && other!= null);
        return false;
    }

    @Override
    public int hashCode() {
        return next != null ? next.hashCode() : 0;
    }
}
