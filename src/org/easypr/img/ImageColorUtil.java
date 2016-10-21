package org.easypr.img;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import static org.bytedeco.javacpp.opencv_highgui.imread;
import org.bytedeco.javacpp.opencv_core.Mat;

public class ImageColorUtil {
	
	public static void main(String args[]) throws IOException {  
		
    }
	
	
	/**
	 * 外接接口，指定颜色范围
	 * @param bi
	 * @param target:目录
	 * @param rgbRange
	 * @throws IOException
	 */
	public static Mat replaceColor(BufferedImage bi, String plateColor) throws IOException {
        
        plateLocate(bi,plateColor);
        
        FileOutputStream ops1 = new FileOutputStream(new File("yrTmp/temp.jpg"));  
        ImageIO.write(bi,"jpg", ops1);  
        ops1.flush();  
        ops1.close(); 
        
        Mat bw = imread("yrTmp/temp.jpg");
        return bw;
	}
	
	
	
	
	private static void plateLocate(BufferedImage bi, String plateColor) {
		
		int width = bi.getWidth();  
        int height = bi.getHeight();  
        int minx = bi.getMinX();  
        int miny = bi.getMinY();  
        
        for (int i = minx; i < width; i++) {  
            for (int j = miny; j < height; j++) {  
            	
                int pixel = bi.getRGB(i, j);  
                
                int[] rgb = new int[3];  
                rgb[0] = (pixel & 0xff0000) >> 16;  
                rgb[1] = (pixel & 0xff00) >> 8;  
                rgb[2] = (pixel & 0xff);  
                
                boolean isPlateColor = false;
                
                boolean isBlueColor = rgb[0]>=Constants.blueRGB[0] && rgb[0]<=Constants.blueRGB[1]	&& 	rgb[1]>=Constants.blueRGB[2] && rgb[1]<=Constants.blueRGB[3]&& rgb[2]>=Constants.blueRGB[4] && rgb[2]<=Constants.blueRGB[5];
                boolean isYellowColor = rgb[0]>=Constants.yellowRGB[0] && rgb[0]<=Constants.yellowRGB[1]	&& 	rgb[1]>=Constants.yellowRGB[2] && rgb[1]<=Constants.yellowRGB[3]&& rgb[2]>=Constants.yellowRGB[4] && rgb[2]<=Constants.yellowRGB[5];
                
                if(plateColor.equals(Constants.BLUE_PLATE)){
                	isPlateColor = isBlueColor;
                }else if(plateColor.equals(Constants.YELLOW_PLATE)){
                	isPlateColor = isYellowColor;
                }else{
                	isPlateColor = isBlueColor || isYellowColor;
                }
                
                //如果颜色在范围内，变白，否则变黑
                if(isPlateColor){  
                	bi.setRGB(i, j, 0xFFFFFF);
                }else{
                	bi.setRGB(i, j, 0x000000);
                }
                  
            }  
        }  
		
	}
	

}
