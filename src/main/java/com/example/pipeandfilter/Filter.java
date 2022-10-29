package com.example.pipeandfilter;

import java.io.EOFException;

public abstract class Filter implements Runnable {

    // The input pipe.
    protected Pipe in;
    // The output pipe.
    protected Pipe out;

    // Set the input pipe.
    public void setIn(Pipe in) {
        this.in = in;
    }
    // Set the output pipe.
    public void setOut(Pipe out) {
        this.out = out;
    }
    // Write a string to the output pipe.
    public void write(String s) {
        if(s==null) {
            out.close();
            return;
        }
        out.write(s);
    }

    // Read from the input pipe.
    public String read() throws EOFException {
        return in.read();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
    }

}
