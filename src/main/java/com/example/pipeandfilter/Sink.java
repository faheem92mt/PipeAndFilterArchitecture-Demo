package com.example.pipeandfilter;

import java.io.EOFException;

public class Sink extends Filter {

    @Override
    public void run() {
//        while(true){
//            try{
//                System.out.println("YOLO");
//                System.out.println(read());
//
//            }catch(EOFException e){
//                break;
//            }
//        }
    }

    public String returnPrint() throws EOFException {


        return read();

//        String[] entries = new String[1000];
//
//        int i = 0;
//
//        while(true){
//            System.out.println("Here");
//            try{
//                System.out.println("Not failed");
//                entries[i++] = read();
//                System.out.println(entries[i++]);
//                System.out.println("*******************************");
//            }
//            catch(EOFException e) {
//                System.out.println("Failed");
//                break;
//            }
//        }
//
//        return entries;

    }

}
