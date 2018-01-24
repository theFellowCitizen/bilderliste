/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbw.bilderliste;

import java.awt.image.BufferedImage;

/**
 *
 * @author 5im15rafarsinejad
 */
class Picture {
    
    private BufferedImage image;
    private String name;
    private String fileDec;
    private String path;
    private int width;
    private int height;

    public Picture(BufferedImage bi, String name, String fileDec, String path, int width, int height) {
        this.image = bi;
        this.name = name;
        this.fileDec = fileDec;
        this.path = path;
        this.width = width;
        this.height = height;
    }

    public Picture(String name, String fileDec) {
        this.name = name;
        this.fileDec = fileDec;
    }

    public Picture() {
    }
    
    
    /**
     * @return the image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the fileDec
     */
    public String getFileDec() {
        return fileDec;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    
        
}
