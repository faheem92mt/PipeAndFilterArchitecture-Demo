package com.example.pipeandfilter;

public class Pipeline implements Runnable {

    private Filter[] filters;

    public Pipeline(Filter ... filters) {
        this.filters = filters;

        for(int i=0;i<filters.length-1;i++) {
            Pipe pipe = new Pipe();
            filters[i].setOut(pipe);
            filters[i+1].setIn(pipe);

        }
    }

    @Override
    public void run() {
        for(Filter filter : filters) {
            Thread thread = new Thread(filter);
            thread.start();
        }

    }

}
