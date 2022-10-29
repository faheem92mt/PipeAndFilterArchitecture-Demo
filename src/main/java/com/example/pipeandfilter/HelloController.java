package com.example.pipeandfilter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.EOFException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField enter;

    @FXML
    protected void onHelloButtonClick() {

        String string = enter.getText();

        Pump pump = new Pump(enter.getText());
        CircularLeftShift circularLeftShift = new CircularLeftShift();
        Sort sort = new Sort();
        Sink sink = new Sink();

        Pipeline pipeline = new Pipeline(pump, circularLeftShift, sort, sink);
        System.out.println("result: ");
        pipeline.run();

        int count = 0;
        char ch[]= new char[string.length()];
        for(int i=0;i<string.length();i++)
        {
            ch[i]= string.charAt(i);
            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )
                count++;
        }

        // safe
        String ent = null;

        for (int i = 0; i<count; i++) {
            try {
                ent = sink.returnPrint();
            } catch (EOFException e) {
                e.printStackTrace();
            }
            System.out.println(ent);
            welcomeText.setText(welcomeText.getText() + ent );
        }





        //        String ent[] = new String[0];
//        try {
//            ent = sink.returnPrint();
//        } catch (EOFException e) {
//            e.printStackTrace();
//        }
//        for (int i=0; i<ent.length; i++) {
//            System.out.println(ent[i]);
//        }


    }



}