package com.example.pipeandfilter;

import java.io.EOFException;
import java.util.LinkedList;

public class Pipe {

    private LinkedList<String> stream;
    private boolean closed;

    public Pipe(){
        stream = new LinkedList<String>();
        closed = false;
    }

    // write a string to the pipe
    public void write(String s){
        if(closed){
            throw new IllegalStateException("Pipe is closed");
        }
        stream.add(s);
    }

    // Read from the Pipe.
    public String read() throws EOFException {
        while(true){
            if(stream.size() == 0){
                if(closed){
                    throw new EOFException("Pipe is closed");
                }
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    System.err.println("Interrupted Exception caught in Pipe");
                }
            }else{
                return stream.pop();
            }
        }
    }
    public int size(){
        return stream.size();
    }

    // Close the pipe.
    public void close(){
        closed = true;
    }

}
