package skyteacher;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * Created by Julian Benitez on 7/13/2017.
 */
public class Tester {
    Double minImprovement;
    Integer minWarmupCicles;
    Duration maxSingleTest;

    public Tester(Double minImprovement, Duration maxSingleTest, Integer minWarmupCicles){
        this.maxSingleTest = maxSingleTest;
        if(minImprovement < 0 || minImprovement > 1)
            throw new IllegalArgumentException("Min improvement must be between 0 and 1");
        this.minImprovement = minImprovement;
        this.minWarmupCicles = minWarmupCicles;
    }

    public StringBuffer test(Callable runnable){
        System.gc();
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        Duration lastDuration=null;
        Duration duration;
        Double improvement;
        Instant start;
        do {
            start =Instant.now();
            for (int j = 0; j < 400; j++) {
                try {
                    System.out.println(runnable.call());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            duration = Duration.between(start,Instant.now());
            improvement = (i == 0?1D:lastDuration.toNanos() / duration.toNanos());
            System.out.println("Round " + i + " - " + duration.toMillis() + " ms");
            lastDuration = duration;
            i++;
        } while ( i < minWarmupCicles || improvement > minImprovement );

        System.out.println("Rounds of warmup: " + (i -1));
        System.out.println("Last Duration: " + duration.toMillis() + "ms");
        return buffer;
    }
}
