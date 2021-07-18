package one;

import javax.swing.*;
import java.net.URL;

//Ako želimo dodati sličice na dugmiće, pisemo private class ImageIconLoader
public class ImageIconLoader {

    private Class<ButtonPanel> path;//path?-->sličice

    public ImageIconLoader(Class<ButtonPanel> buttonPanelClass){
        this.path = path;
    }

    public ImageIcon load(String path){
        URL imageUrl=ButtonPanel.class.getResource(path);//Da bi učitali
        //sličice moramo znati url; sličice se nalaze u ButtonPanel-u

        if(imageUrl !=null){
            ImageIcon imageIcon=new ImageIcon(imageUrl);
            return imageIcon;
        }else{
            System.err.println("Nema slike na putanji "+path);
            return null;
        }
    }


}
