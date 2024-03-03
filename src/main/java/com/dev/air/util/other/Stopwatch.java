package com.dev.air.util.other;

import org.lwjglx.Sys;

public class Stopwatch {

    private long lastMS;

    public Stopwatch() {
        lastMS = System.currentTimeMillis();
    }

    public long getLastMS() {
        return lastMS;
    }

    public boolean hasReached(long ms) {
        return System.currentTimeMillis() - lastMS >= ms;
    }

    public long reset() {
        return lastMS = System.currentTimeMillis();
    }

}
