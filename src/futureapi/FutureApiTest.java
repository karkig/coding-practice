package futureapi;

import java.util.concurrent.CompletableFuture;

public class FutureApiTest {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(()-> CompletableFuture.completedFuture(null))

        ;
    }
}
