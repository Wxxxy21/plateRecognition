package org.easypr;

import static org.bytedeco.javacpp.opencv_highgui.imread;
import static org.easypr.core.CoreFunc.getPlateType;
import static org.easypr.core.CoreFunc.projectedHistogram;
import static org.easypr.core.CoreFunc.showImage;

import java.util.Vector;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.easypr.core.CharsIdentify;
import org.easypr.core.CharsRecognise;
import org.easypr.core.CoreFunc;
import org.easypr.core.PlateDetect;
import org.easypr.core.PlateLocate;
import org.junit.Test;

/**
 * @author lin.yao
 * 
 */
public class EasyPrTest {
    
    @Test
    public void testPlateRecognise(String imgPath) {
    
        Mat src = imread(imgPath);
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<Mat> matVector = new Vector<Mat>();
        
        int returnVal = plateDetect.plateDetect(src, matVector);
        
        if (returnVal != 0 || matVector.size() == 0) {
        	
        	System.out.println("车牌定位失败，开始使用车牌颜色定位车牌……");
        	matVector = new Vector<Mat>();
        	returnVal = plateDetect.plateDetectByColor(src, matVector);
        	
        	if (returnVal == 0 && matVector.size() > 0) {
        		for (int i = 0; i < matVector.size(); ++i) {
                	CharsRecognise cr = new CharsRecognise();
                    String result = cr.charsRecognise(matVector.get(i));
                    System.out.println("车牌识别结果： " + result);
                }
            }else{
            	System.out.println("识别车牌失败。");
            }
        	
        }else{
        	for (int i = 0; i < matVector.size(); ++i) {
            	CharsRecognise cr = new CharsRecognise();
                String result = cr.charsRecognise(matVector.get(i));
                System.out.println("车牌识别结果： " + result);
            }
        }
        
        
    }

    @Test
    public void testPlateDetect() {
        String imgPath = "res/image/test_image/test.jpg";

        Mat src = imread(imgPath);
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<Mat> matVector = new Vector<Mat>();
        if (0 == plateDetect.plateDetect(src, matVector)) {
            for (int i = 0; i < matVector.size(); ++i) {
                showImage("Plate Detected", matVector.get(i));
            }
        }
    }

    @Test
    public void testPlateLocate() {
        String imgPath = "res/image/test_image/test.jpg";

        Mat src = imread(imgPath);

        PlateLocate plate = new PlateLocate();
        plate.setDebug(true);
        plate.setLifemode(true);

        Vector<Mat> resultVec = plate.plateLocate(src);

        int num = resultVec.size();
        for (int j = 0; j < num; j++) {
            // showImage("Plate Located " + j, resultVec.get(j));
        }

        return;
    }

    @Test
    public void testCharsRecognise() {
        String imgPath = "res/image/test_image/chars_recognise_huAGH092.jpg";

        Mat src = imread(imgPath);
        CharsRecognise cr = new CharsRecognise();
        cr.setCRDebug(true);
        String result = cr.charsRecognise(src);
        System.out.println("Chars Recognised: " + result);
    }

    @Test
    public void testColorDetect() {
        String imgPath = "res/image/test_image/core_func_yellow.jpg";

        Mat src = imread(imgPath);

        CoreFunc.Color color = getPlateType(src, true);
        System.out.println("Color Deteted: " + color);
    }

    @Test
    public void testProjectedHistogram() {
        String imgPath = "res/image/test_image/chars_identify_E.jpg";

        Mat src = imread(imgPath);
        projectedHistogram(src, CoreFunc.Direction.HORIZONTAL);
    }

    @Test
    public void testCharsIdentify() {
        String imgPath = "res/image/test_image/chars_identify_E.jpg";

        Mat src = imread(imgPath);
        CharsIdentify charsIdentify = new CharsIdentify();
        String result = charsIdentify.charsIdentify(src, false, true);
        System.out.println(result);
    }

}
