package org.easypr.img;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageColorUtil {
	
	
	public static final int[] whiteRGB = new int[]{255,255,255,255,255,255};
	
	
	//京QM01G6	通过
	public static final String src_path = "C:/Users/yr/Documents/GitHub/plateRecognition/test4/1.jpg";
    public static final int plate_width_divisor = 10;
	public static final int plate_height_divisor = 30;
	public static final int[] blueRGB = new int[]{0,35,15,35,60,130};
	public static final int x1_offset = -20;
	public static final int x2_offset = -10;
	public static final int y1_offset = 0;
	public static final int y2_offset = -20;
	
	
	//京HH8489	通过
	/*
	public static final String src_path = "C:/Users/yr/Documents/GitHub/plateRecognition/test4/2.jpg";
	public static final int plate_width_divisor = 10;
	public static final int plate_height_divisor = 30;
	public static final int[] blueRGB = new int[]{0,35,15,35,60,130};
	public static final int x1_offset = -0;
	public static final int x2_offset = -0;
	public static final int y1_offset = -5;
	public static final int y2_offset = -5;*/
	
	//京FS0196	通过
	/*
	public static final String src_path = "C:/Users/yr/Documents/GitHub/plateRecognition/test4/3.jpg";
	public static final int plate_width_divisor = 10;
	public static final int plate_height_divisor = 50;
	public static final int[] blueRGB = new int[]{0,35,15,35,60,130};
	public static final int x1_offset = -0;
	public static final int x2_offset = -0;
	public static final int y1_offset = -5;
	public static final int y2_offset = -5;*/
	
	//京QM01G6	通过
	/*
	public static final String src_path = "C:/Users/yr/Documents/GitHub/plateRecognition/test4/6.jpg";
	public static final int plate_width_divisor = 10;
	public static final int plate_height_divisor = 50;
	public static final int[] blueRGB = new int[]{0,35,15,120,60,240};
	public static final int x1_offset = -0;
	public static final int x2_offset = -0;
	public static final int y1_offset = -5;
	public static final int y2_offset = -5;*/
	
	//冀GX3499	通过一半
	/*
	public static final String src_path = "C:/Users/yr/Documents/GitHub/plateRecognition/test4/7.jpg"; 
	public static final int plate_width_divisor = 10;
	public static final int plate_height_divisor = 50;
	public static final int[] blueRGB = new int[]{0,35,15,120,60,240};
	public static final int x1_offset = -0;
	public static final int x2_offset = -0;
	public static final int y1_offset = -15;
	public static final int y2_offset = -15;*/
	
	//（黄色车牌）京AA8322
/*	
 	public static final String src_path = "C:/Users/yr/Documents/GitHub/plateRecognition/test4/1.jpg";
 	public static final int plate_width_divisor = 10;
	public static final int plate_height_divisor = 50;
	public static final int[] blueRGB = new int[]{200,255,140,220,0,50};
	public static final int x1_offset = -0;
	public static final int x2_offset = -0;
	public static final int y1_offset = -15;
	public static final int y2_offset = -15;*/
	
	
	

	public static void main(String args[]) throws IOException {  
		
		replaceColor(src_path,"e:/d5/result.jpg",blueRGB);
    }

	public static void replaceColor(BufferedImage bi, String target,int[] rgbRange) throws IOException {
        
        setFrameBi(bi,rgbRange);
        
        FileOutputStream ops1 = new FileOutputStream(new File("e:/d5/temp.jpg"));  
        ImageIO.write(bi,"jpg", ops1);  
        
        completeImage(bi);
        
        System.out.println("处理完毕。");  
        /** 
         * 将缓冲对象保存到新文件中 
         */  
        FileOutputStream ops = new FileOutputStream(new File(target));  
        ImageIO.write(bi,"jpg", ops);  
        ops.flush();  
        ops.close();  
	}
	
	
	private static void setFrameBi(BufferedImage bi, int[] rgbRange) {
		int width = bi.getWidth();  
        int height = bi.getHeight();  
        int minx = bi.getMinX();  
        int miny = bi.getMinY();  
        System.out.println("正在处理");  
        System.out.println("图片 width："+width+"，height："+height);
        for (int i = minx; i < width; i++) {  
            for (int j = miny; j < height; j++) {  
            	
                int pixel = bi.getRGB(i, j);  
                
                int[] rgb = new int[3];  
                rgb[0] = (pixel & 0xff0000) >> 16;  
                rgb[1] = (pixel & 0xff00) >> 8;  
                rgb[2] = (pixel & 0xff);  
                
                //如果颜色在范围内，变白，否则变黑
                if(	rgb[0]>=rgbRange[0] && rgb[0]<=rgbRange[1]	&& 	rgb[1]>=rgbRange[2] && rgb[1]<=rgbRange[3]&& rgb[2]>=rgbRange[4] && rgb[2]<=rgbRange[5]){  
                	bi.setRGB(i, j, 0xFFFFFF);
                }else{
                	bi.setRGB(i, j, 0x000000);
                }
                  
            }  
        }  
		
	}

	private static void completeImage(BufferedImage bi) {
		
		int y1 = getY1(bi) - y1_offset;
        int y2 = getY2(bi) + y2_offset;
        
        int x1 = getX1(bi) - x1_offset;
        int x2 = getX2(bi) + x2_offset;
        
        System.out.println("车牌 width："+(x2-x1)+" , height："+(y2-y1));
        System.out.println("车牌的宽高比是："+new Float(x2-x1)/new Float(y2-y1));
		
		
		int width = bi.getWidth();  
        int height = bi.getHeight();  
        int minx = bi.getMinX();  
        int miny = bi.getMinY();  
        
        for (int i = minx; i < width; i++) {  
            for (int j = miny; j < height; j++) {  
                
                //如果颜色在范围内，变白，否则变黑
                if( i>=x1 && i<=x2 && j>=y1 && j<=y2 ){  
                	bi.setRGB(i, j, 0xFFFFFF);
                }else{
                	bi.setRGB(i, j, 0x000000);
                }
                  
            }  
        }  
		
	}

	private static int getX2(BufferedImage bi) {
		int width = bi.getWidth();  
        int height = bi.getHeight();  
        int miny = bi.getMinY();  
        
        for (int i = width-1; i >0; i--) {  
        	int count = 0;
        	for(int j = miny; j< height ; j++ ){
        		//System.out.println(i+","+j);
        		int pixel = bi.getRGB(i, j);  
        		int r = (pixel & 0xff0000) >> 16;  
            	int g = (pixel & 0xff00) >> 8;  
                int b = (pixel & 0xff);  
                if(r==255 && g == 255 && b == 255){
                	count++;
                }
        	}
        	if(count>(width/plate_height_divisor)){
        		return i;
        	}
        	
        }
		return 0;
	}
	
	private static int getX1(BufferedImage bi) {
		
		int width = bi.getWidth();  
        int height = bi.getHeight();  
        int minx = bi.getMinX();  
        int miny = bi.getMinY();  
        
        for (int i = minx; i < width; i++) {  
        	int count = 0;
        	for(int j = miny; j< height ; j++ ){
        		//System.out.println(i+","+j);
        		int pixel = bi.getRGB(i, j);  
        		int r = (pixel & 0xff0000) >> 16;  
            	int g = (pixel & 0xff00) >> 8;  
                int b = (pixel & 0xff);  
                if(r==255 && g == 255 && b == 255){
                	count++;
                }
        	}
        	if(count>(width/plate_height_divisor)){
        		return i;
        	}
        	
        }
		return 0;
	}

	private static int getY2(BufferedImage bi) {
		
		int width = bi.getWidth();  
        int height = bi.getHeight();  
        int minx = bi.getMinX();  
        
        for (int i = height-1; i>0 ; i--) {  
        	
        	int count = 0;
        	for(int j = minx; j< width ; j++ ){
        		
        		int pixel = bi.getRGB(j, i);  
        		int r = (pixel & 0xff0000) >> 16;  
            	int g = (pixel & 0xff00) >> 8;  
                int b = (pixel & 0xff);  
                if(r==255 && g == 255 && b == 255){
                	count++;
                }
        	}
        	if(count>(width/plate_width_divisor)){
        		return i;
        	}
        	
        }
		return 0;
	}

	/**
	 * 获取Y轴上的第一个坐标
	 * @param bi
	 * @return
	 */
	private static int getY1(BufferedImage bi) {
		
		int width = bi.getWidth();  
        int height = bi.getHeight();  
        int minx = bi.getMinX();  
        int miny = bi.getMinY();  
        
        for (int i = miny; i < height; i++) {  
        	int count = 0;
        	for(int j = minx; j< width ; j++ ){
        		//System.out.println(i+","+j);
        		int pixel = bi.getRGB(j, i);  
        		int r = (pixel & 0xff0000) >> 16;  
            	int g = (pixel & 0xff00) >> 8;  
                int b = (pixel & 0xff);  
                if(r==255 && g == 255 && b == 255){
                	count++;
                }
        	}
        	if(count>(width/plate_width_divisor)){
        		return i;
        	}
        	
        }
		return 0;
	}

	/**
	 * 
	 * 把图片中在范围内的像素变白，其他变黑
	 * 
	 * @param src
	 * @param target
	 * @param red 红色所在的范围
	 * @param green
	 * @param blue
	 * @throws IOException
	 */
	public static void replaceColor(String src, String target, int[] rgbRange) throws IOException {
		File file = new File(src); 
		BufferedImage bi = null;  
        try {  
            bi = ImageIO.read(file);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
		replaceColor(bi,target,rgbRange);
		
	}  

}
