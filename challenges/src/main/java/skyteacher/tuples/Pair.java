package skyteacher.tuples;

/**
 * Created by Julian Benitez on 8/5/1007.
 */
public class Pair<K,T> {
    private K data0;
    private T data1;

    public Pair(K data0, T data1){
        this.data0 = data0;
        this.data1 = data1;
    }

    public K get0(){
        return data0;
    }
    public T get1(){
        return data1;
    }

    public static <K,T> Pair<K,T> of(K data0, T data1){
        return new Pair<K, T>(data0,data1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (data0 != null ? !data0.equals(pair.data0) : pair.data0 != null) return false;
        return data1 != null ? data1.equals(pair.data1) : pair.data1 == null;

    }

    @Override
    public int hashCode() {
        int result = data0 != null ? data0.hashCode() : 0;
        result = 31 * result + (data1 != null ? data1.hashCode() : 0);
        return result;
    }
}
