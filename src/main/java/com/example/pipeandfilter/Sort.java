package com.example.pipeandfilter;

import java.io.EOFException;
import java.util.ArrayList;

public class Sort extends Filter {

    private ArrayList<String> list;
    public Sort() {
        list = new ArrayList<String>();
    }

    @Override
    public void run() {
        boolean turn = true;
        while(turn) {
            try {
                String s = read();
                list.add(s);
                if(this.in.size() == 0)
                    turn = false;
            } catch(EOFException e) {
                break;
            }
        }
        try{
            ArrayList<String> res =  sortList(list);
            while(res.size() != 0){
                write(res.get(0));
                res.remove(0);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println(e.getStackTrace());
        }

    }
    public ArrayList<String> sortList(ArrayList<String> list){
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println();
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            String temp = list.get(i);
            for(int j=1;j<list.size();j++){
                if(list.get(j).compareToIgnoreCase(temp) < 0){
                    temp = list.get(j);
                }
            }
            res.add(temp);
            list.remove(temp);
            i--;
        }
        return res;
    }

}
