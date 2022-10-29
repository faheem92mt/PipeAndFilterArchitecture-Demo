package com.example.pipeandfilter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pump extends Filter {

    private BufferedReader reader;
    private String ent;

    public Pump(String ent1) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        ent = ent1;
    }

    @Override
    public void run() {
        try {
            String s = ent;
            if (s == null) {
                write(null);
            }
            else {
                write(s + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
