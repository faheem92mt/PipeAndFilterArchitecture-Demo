package com.example.pipeandfilter;

import java.io.EOFException;

public class CircularLeftShift extends Filter {

    @Override
    public void run() {
        while (true) {
            try {
                String s = read();
                String words[] = s.split("\\s");

                for(int i = 0; i < words.length; i++) {

                    String toWrite = "";
                    for(int j = 0; j < words.length; j++) {
                        toWrite+=words[j] + " ";
                    }
                    toWrite+="\n";
                    shiftLeft(words);
                    write(toWrite);
                }

            } catch (EOFException e) {
                out.close();
                break;
            }
        }
    }
    private void shiftLeft(String[] array) {
        String temp = array[0];
        int i;
        for (i = 0; i < array.length - 1; i++)
            array[i] = array[i + 1];
        array[i] = temp;
    }

}
