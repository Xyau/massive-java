package skyteacher.tuples;

/**
 * Created by Julian Benitez on 8/5/1007.
 */
public class Triple<K,T,S> {
    private K data0;
    private T data1;
    private S data2;

    public Triple(K data0, T data1, S data2){
        this.data0 = data0;
        this.data1 = data1;
        this.data2 = data2;
    }

    public K get0(){
        return data0;
    }
    public T get1(){
        return data1;
    }
    public S get2(){
        return data2;
    }

    public static <K,T,S> Triple<K,T,S> of(K data0, T data1, S data2){
        return new Triple<K, T, S>(data0,data1,data2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;

        if (data0 != null ? !data0.equals(triple.data0) : triple.data0 != null) return false;
        if (data1 != null ? !data1.equals(triple.data1) : triple.data1 != null) return false;
        return data2 != null ? data2.equals(triple.data2) : triple.data2 == null;

    }

    @Override
    public int hashCode() {
        int result = data0 != null ? data0.hashCode() : 0;
        result = 31 * result + (data1 != null ? data1.hashCode() : 0);
        result = 31 * result + (data2 != null ? data2.hashCode() : 0);
        return result;
    }
}
