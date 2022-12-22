package org.example.algorithm;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LeakyBucket {
    private final long start = System.currentTimeMillis();

    private long capacity = 10000;// 桶的容量
    private long speed = 1;// 水流速
    private AtomicLong water = new AtomicLong(100);// 当前水量

    boolean add() {
//        添加令牌
        final long now = System.currentTimeMillis();
        water.set(Math.max(0, water.get() - speed * (now - start) * speed));
        long expected = water.get() + speed;
        return expected <= capacity && water.compareAndSet(expected, water.get() + speed);
    }

    public LeakyBucket setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public LeakyBucket setSpeed(int speed) {
        this.speed = speed;
        return this;
    }
}
