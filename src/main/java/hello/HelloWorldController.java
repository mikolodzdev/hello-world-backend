package hello;

import java.net.InetAddress;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    private Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/hello-world", method=RequestMethod.GET)
    public Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) throws Exception {
        return new Greeting(counter.incrementAndGet(), String.format(template, name), InetAddress.getLocalHost().getHostAddress());
    }

    @RequestMapping(path = "/fibonacci/{f}", method=RequestMethod.GET)
    public CompletableFuture<Fibonacci> fibonacci(@PathVariable Long f) {
        LOGGER.info("Fibonacci: {}", f);
        CompletableFuture result = CompletableFuture.supplyAsync(() -> calculateFibonacci(f,f)).thenApply(fibRes -> new Fibonacci(f, fibRes));
        return result;
    }


    public long calculateFibonacci(long initn, long n) {
        LOGGER.info("calculateFibonacci: {} - {}",initn, n);
        if (n <= 1) return n;
        else return calculateFibonacci(n, n-1) + calculateFibonacci(n,n-2);
    }
}
