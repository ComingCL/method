package org.example.algorithm;

import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {
    long capacity = 10000;// 桶容量
    long rate = 1;// 令牌添加速率
    AtomicLong tokens = new AtomicLong(100);// 桶内当前令牌数量
    long start = System.currentTimeMillis();

    boolean add(){
        // 添加令牌
        long now = System.currentTimeMillis();
        tokens.set(Math.min(capacity, tokens.get() + rate * (now - start)));
        if(tokens.get() >= 1){
            tokens.decrementAndGet();
            return true;
        }
        return false;
    }

    public TokenBucket setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public TokenBucket setRate(int rate) {
        this.rate = rate;
        return this;
    }
}
