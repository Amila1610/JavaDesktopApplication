package one;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Executor {
    public static void main(String[] args) {

        JFrame frame=new JFrame(); //--------> OKVIR/Glavni prozor
        frame.setTitle("Prvi naš frejm"); //->NAZIV okvira

        //kada smo ispisali ButtonPanel, napravili klasu za dugmiće
        //sada ih moramo UGRADITI u naš frame (2.dodavanje u executor)
        ButtonPanel buttonPanel=new ButtonPanel(); //--objekat
        frame.setContentPane(buttonPanel);         //button panel se nalazi na oknu-ContentPane-u


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //-- Ovo je defaultno, ali možemo i pisati - kockica X

        //frame.setSize(400,400); //---> VELIČINA OKVIRA,DIMENZIJE
        frame.pack();//umjesto frame.setSize, znači da će
                     // frame zauzeti onoliko mjesta koliko je potrebno za dugmiće

        frame.setVisible(true); // -----> Želimo da ovaj okvir bude VIDLJIV-TRUE

        //Okvir se sastoji od: 1. trake sa naslovom i - x
        //                     2.OKNA sa sadržajem(CONTENTPANE)
        frame.getContentPane().setBackground(Color.WHITE);
        //sada ćemo kreirati 2-3 DUGMIĆA- BUTTON u drugoj klasi BUTTONPANEL

    }

}
