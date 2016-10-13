package org.easypr.img;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class ImgTest {
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		
		
		new ImgTest().replaceImageColor();
		
	}
	
	
	public void replaceImageColor() throws IOException{
		
		File file = new File("test.jpg");
		
        BufferedImage image =  ImageIO.read(file); 
        
        int type = image.getType();
        
        System.out.println(image.getWidth());
        System.out.println(type);
        
        if ( type ==BufferedImage.TYPE_INT_ARGB || type == BufferedImage.TYPE_INT_RGB ){
        	
        }
        
        int temp = 0;
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
            	
            	
            }
        }
        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("png");
        ImageWriter writer = it.next();
        File f = new File("test_result.jpg");
        ImageOutputStream ios = ImageIO.createImageOutputStream(f);
        writer.setOutput(ios);
        writer.write(image);
        image.flush();
        ios.flush();
        ios.close();
    }
    
	/**
	 * 是车牌，63，71，204（红绿蓝）
	 * @param curColor
	 * @return
	 */
    private boolean isPlate(Color curColor) {
    	int red = Math.abs(curColor.getRed()-63);
    	int green = Math.abs(curColor.getRed()-71);
    	int blue = Math.abs(curColor.getRed()-204);
    	
    	if( red<50 && green<50 && blue <50){
    		return true;
    	}
		return false;
	}


	public void createImage(int width, int height) throws IOException{
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D graphic = bi.createGraphics();
        graphic.setColor(new Color(0.2f,0.3f,0.4f,0.4f));
        graphic.fillRect(0, 0, width, height);
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                  //result[i][j] = bi.getRGB(i, j) & 0xFFFFFF;
                  System.out.println(bi.getRGB(i, j));
                 // bi.setRGB(i, j, 0xFFFFFF);
            }
       }
        
        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("png");
        ImageWriter writer = it.next();
        File f = new File("c://test02.png");
        ImageOutputStream ios = ImageIO.createImageOutputStream(f);
        writer.setOutput(ios);
        
        writer.write(bi);
    }

}
