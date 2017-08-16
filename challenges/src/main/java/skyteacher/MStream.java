package skyteacher;

import java.util.stream.Stream;

public class MStream {
    public static Stream<Integer> range(Integer start, Integer end){
        Stream.Builder<Integer> builder = Stream.builder();
        for (int i = start; i < end; i++) {
            builder.add(i);
        }
        return builder.build();
    }

    public static Stream<Integer> to(Integer end){
        return range(0,end);
    }

}
