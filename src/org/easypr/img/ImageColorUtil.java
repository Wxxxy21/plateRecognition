package org.easypr.img;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageColorUtil {

	public static void main(String args[]) throws IOException {  
		
		replaceColor("e:/d4/jingQM01G6.jpg","e:/d5/jingQM01G6.jpg",new int[]{0,10},new int[]{15,35},new int[]{100,130});
    }

	private static void replaceColor(BufferedImage bi, String target,
			int[] red, int[] green, int[] blue) throws IOException {
		 /** 
         * 定义一个RGB的数组，因为图片的RGB模式是由三个 0-255来表示的 比如白色就是(255,255,255) 
         */  
        int[] rgb = new int[3];  
        
        /** 
         * 得到图片的长宽 
         */  
        int width = bi.getWidth();  
        int height = bi.getHeight();  
        int minx = bi.getMinX();  
        int miny = bi.getMinY();  
        System.out.println("正在处理……");  
        /** 
         * 这里是遍历图片的像素，因为要处理图片的背色，所以要把指定像素上的颜色换成目标颜色 
         * 这里 是一个二层循环，遍历长和宽上的每个像素 
         */  
        for (int i = minx; i < width; i++) {  
            for (int j = miny; j < height; j++) {  
                // System.out.print(bi.getRGB(jw, ih));  
                /** 
                 * 得到指定像素（i,j)上的RGB值， 
                 */  
                int pixel = bi.getRGB(i, j);  
                /** 
                 * 分别进行位操作得到 r g b上的值 
                 */  
                rgb[0] = (pixel & 0xff0000) >> 16;  
                rgb[1] = (pixel & 0xff00) >> 8;  
                rgb[2] = (pixel & 0xff);  
                //如果颜色在范围内，变白，否则变黑
                if(	rgb[0]<=red[1]&&rgb[0]>red[0] 
               		 	&& 
                		rgb[1]<green[1]&&rgb[1]>green[0] 
                			&& 
                		rgb[2]<blue[1]&&rgb[2]>blue[0] 
                	){  
               	 
               	 bi.setRGB(i, j, 0xFFFFFF);
                }else{
                	bi.setRGB(i, j, 0x000000);
                }
                  
            }  
        }  
        System.out.println("处理完毕。");  
        System.out.println();  
        /** 
         * 将缓冲对象保存到新文件中 
         */  
        FileOutputStream ops = new FileOutputStream(new File(target));  
        ImageIO.write(bi,"jpg", ops);  
        ops.flush();  
        ops.close();  
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
	public static void replaceColor(String src, String target, int[] red,
			int[] green, int[] blue) throws IOException {
		File file = new File(src); 
		BufferedImage bi = null;  
        try {  
            bi = ImageIO.read(file);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
		replaceColor(bi,"e:/d5/jingQM01G6.jpg",new int[]{0,10},new int[]{15,35},new int[]{100,130});
		
	}  

}
