package com.wipro.day6.projects;

class Counter {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}

