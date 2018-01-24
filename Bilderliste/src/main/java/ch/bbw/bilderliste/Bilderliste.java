/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbw.bilderliste;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 * This Class is madlad.
 *
 * @author 5im15rafarsinejad
 */
public class Bilderliste {

    private String laufwerk = "D:\\Modul_151/Projektarbeit/wallpapers";
    private ArrayList<Picture> wallsList;
    private FileWriter fw;
    private BufferedWriter bw;

    public Bilderliste() throws IOException {
        wallsList = new ArrayList<>();
        fw = new FileWriter("../test.txt");
        bw = new BufferedWriter(fw);
    }

    /**
     * This method does something.
     */
    public void fetchPapes() {

        BufferedImage image = null;
        String[] wallPs;
        File rootFile = new File(laufwerk);
        String[] subFile = rootFile.list();
        for (String filename : subFile) {
//            if (filename.startsWith("wallpapers")) {
//                Element element = new Element("wallpapers");
//                Attribute klassenOrdner = new Attribute( "name", filename);
//                System.out.println(klassenOrdner.getValue());
//            }
            File file = new File(laufwerk + "/" + filename); //image file path
            try {
                image = ImageIO.read(file);
            } catch (IOException ex) {
                Logger.getLogger(Bilderliste.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] splt = filename.split("\\.");
            wallsList.add(new Picture(image, splt[0], splt[1], (laufwerk + "/" + filename), image.getWidth(), image.getHeight()));
        }
    }

    public void soutList() {
        for (Picture pic : wallsList) {
            System.out.println(pic.getName() + " " + pic.getFileDec());
        }
    }

    public void writeXML() {
        for (Picture pic : wallsList) {
            try {
                bw.append("<webseite>"
                        + "<name>" + pic.getName() + "</name>");
            } catch (IOException ex) {
                Logger.getLogger(Bilderliste.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Bilderliste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This is the main method of the program.
     *
     * @param args This is the argument parameter
     */
    public static void main(String[] args) throws IOException {
        Bilderliste bl = new Bilderliste();
        bl.fetchPapes();
        bl.soutList();
        bl.writeXML();
    }
}
