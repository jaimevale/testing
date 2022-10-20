import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Test{
    public static void main(String[] args){
        int numVThreads = Integer.parseInt(args[0]);
        int sleep = Integer.parseInt(args[1]);

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, numVThreads).forEach(i -> {
                long slp= Math.round(sleep*Math.random());
                executor.submit(() -> {
                    Thread.sleep(java.time.Duration.ofMillis(slp));
                    System.out.printf("- [vThread # %d @ %d] ",i,slp);
                    return i;
                });
            });
        }  // executor.close() is called implicitly, and waits
    }
}


//Test.main(new String[]{"100000","30000"});