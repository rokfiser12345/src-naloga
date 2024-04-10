package org.src.resource;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class RestCallCounter {

    private final AtomicInteger actorResourceCalls = new AtomicInteger();
    private final AtomicInteger movieResourceCalls = new AtomicInteger();

    public int incrementActorResourceCall() {
        return actorResourceCalls.incrementAndGet();
    }

    public int incrementMovieResourceCall() {
        return movieResourceCalls.incrementAndGet();
    }

    public int getActorResourceCallCount() {
        return actorResourceCalls.get();
    }

    public int getMovieResourceCallCount() {
        return movieResourceCalls.get();
    }
}