package one;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ButtonPanel extends JPanel {
    //postavljamo atribute za svaki od dugmića, koji želimo da imamo
    private JButton leftButton;
    private JButton middleButton;  // moramo kreirati OBJEKAT po šablonu klase
    private JButton rightButton;   // ButtonPanel

    //da bi kreirali objekad, moramo imati KONSTRUKTOR
    public ButtonPanel(){

        //nakon kreiranja f-je za povezivanje dugmića sa radom, kreiramo objekat
        //po šablonu klase
        ActionListener buttonActionListener=new ButtonActionListener();//3. dodavanje
        ImageIconLoader iconLoader=new ImageIconLoader(ButtonPanel.class);//dodajemo da bi se slike ucitale 6.

        this.leftButton=new JButton("Disable middle button");  // Kreiranje polja
        //ToolTip- kada mišem pređemo preko dugmića, pisat će ovo iz zagrade(2.dodavanje)
        this.leftButton.setToolTipText("Ovo je moj lijevi dugmić");
        //3. dodavanje, lijevom dugmiću dodajemo f-ju koja ispisuje
        //"Da li se ovo izvršava?"
        //this.leftButton.addActionListener(buttonActionListener);

        //4. dodavanje, želimo znati koji je dugmić kliknut i pozvao f-ju
        this.leftButton.setActionCommand("disable");

        //5.dodavanje, ako želimo upravljati preko tastature
        this.leftButton.setMnemonic(KeyEvent.VK_D); //alt+d
        ImageIcon leftIcon= iconLoader.load("right.gif");
        // osim ova 2 reda
        this.leftButton.addActionListener(buttonActionListener);  //dodajemo ispod
        //"Da li se ovo izvršava?" if-else

        this.leftButton.setHorizontalTextPosition(SwingConstants.LEADING);
        this.leftButton.setVerticalTextPosition(SwingConstants.CENTER);
        this.leftButton.setIcon(leftIcon);

        this.middleButton=new JButton("Victim");               // objekta
        this.middleButton.setToolTipText("Ja sam žrtva");
        ImageIcon middleIcon= iconLoader.load("middle.gif");
        this.middleButton.setHorizontalTextPosition(SwingConstants.CENTER);
        this.middleButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.middleButton.setIcon(middleIcon);

        this.rightButton= new JButton("Enable middle button"); // ButtonPanel
        this.rightButton.setToolTipText("Ovo je moj desni dugmić");
        //this.rightButton.addActionListener(buttonActionListener);
        this.rightButton.setActionCommand("enable");
        ImageIcon rightIcon= iconLoader.load("left.gif");
        //this.rightButton.setHorizontalTextPosition(SwingConstants.CENTER);
        //this.rightButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.rightButton.addActionListener(buttonActionListener);
        this.rightButton.setMnemonic(KeyEvent.VK_E);
        this.rightButton.setIcon(rightIcon);

        // sada moramo DODATI ove dugmiće na naš frame, sa ADD pozivamo f-ju
        add(leftButton);
        add(middleButton);
        add(rightButton);

        //u Executor moramo UGRADITI naše dugmiće, da budu vidljivi
    }
    //3. pisanje: dodat ćemo privatnu klasu ButtonActionListner
    //koji implementuje ActionListener
    //on pomaže da naši dugmići dobiju svoju f-ju
    private class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Da li se ovo izvršava?");
            if("disable".equals(e.getActionCommand())){ //ovdje smo oba dugmića povezali
                middleButton.setEnabled(false); //sa f-jom, kako da znamo koji je?
                //pomocu ActionCommand ćemo znati koji to dugmić radi
                //jedan smo nazvali enable, drugi disable
                //oba smo povezali sa f-jom buttonActionListener, ako bude enable izvršit
                //će se jedan dio koda, disable drugi dio.
            }else{
                middleButton.setEnabled(true);
            }
            //middleButton.setEnabled(false); // kada kliknemo lijevi dugmić
            //žrtva će posiviti, a kada kliknemo desni, opet će poplaviti
        }
        //Ako želimo dodati sličice na dugmiće, pisemo private class ImageIconLoader

        }
    }

