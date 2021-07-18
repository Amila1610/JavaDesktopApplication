package two.I;

import one.ButtonPanel;

import javax.swing.*;
import java.net.URL;

//Ako želimo dodati sličice na dugmiće, pisemo private class ImageIconLoader
public class ImageIconLoader {
    private final Class clazz;

    public ImageIconLoader(Class clazz){
        this.clazz=clazz;
    }

    public ImageIcon load(String path){
        URL imageUrl=clazz.getResource(path);//Da bi učitali
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
