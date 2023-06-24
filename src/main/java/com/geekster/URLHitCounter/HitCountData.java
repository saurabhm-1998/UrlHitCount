package com.geekster.URLHitCounter;

public class HitCountData {
    private final String username;
    private int hitCount;

    public HitCountData(String username) {
        this.username = username;
        this.hitCount = 1;
    }

    public String getUsername() {
        return username;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void incrementHitCount() {
        hitCount++;
    }
}
