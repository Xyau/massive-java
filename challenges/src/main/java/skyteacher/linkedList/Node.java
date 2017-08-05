package skyteacher.linkedList;

import skyteacher.tuples.Pair;

import java.util.HashSet;
import java.util.function.BiFunction;

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

    public Node<T> partition(Comparable<T> pivot){
        return null;
    }

    public static <Q,R,S> Node<S> mergeLists(Node num1, Node num2, BiFunction<Node<Q>,Node<R>,Node<S>> function){
        Node current1 = num1;
        Node current2 = num2;
        Node result = null;
        Node nodeTail = null;
        Node nodeToAdd;


        do {
            nodeToAdd = function.apply(current1,current2);
            if(result == null || nodeTail == null){
                result = nodeToAdd;
                nodeTail = nodeToAdd;
            } else {
                nodeTail.next = nodeToAdd;
                nodeTail = nodeToAdd.getTail();
            }


            if (current1 != null) current1 = current1.next;
            if (current2 != null) current2 = current2.next;
        } while (current1 != null || current2 != null);

        return result;
    }

    public Node<T> getTail(){
        Node<T> tail = this;

        while (tail.next != null){
            tail = tail.next;
        }
        return tail;
    }

    public void setNext(Node<T> node){
        next = node;
    }

    public boolean hasLoop(){
        HashSet<Node> nodes = new HashSet<>();
        Node current = this;
        do {
            if(nodes.contains(current)) return true;
            else current = current.next;
        } while (current != null);
        return false;
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
            return Pair.of(this,0);
        } else {
            Pair<Node<T>,Integer> node = next.findKthToTheLastElementRec(k);
            if(node.get1()+1 == k){
                return Pair.of(this,node.get1()+1);
            } else {
                return Pair.of(node.get0(),node.get1()+1);
            }
        }
    }

    public Node<T> findKthToTheLastElement(Integer k){
        return findKthToTheLastElementRec(k).get0();
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
