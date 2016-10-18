package org.easypr;



public class Main {

    public static void main(String[] args) {    	
    	

    	 //   	String imgPath = "res/image/test_image/chars_identify_E.jpg";  //NULL
    	 //   	String imgPath = "res/image/test_image/chars_recognise_huAGH092.jpg";//R
    	 //   	String imgPath = "res/image/test_image/chars_recognise_suEUK722.jpg";//NULL
//    	    	String imgPath = "res/image/test_image/chars_segment.jpg";//R
//    	    	String imgPath = "res/image/test_image/core_func_blue.jpg";//R
//    	    	String imgPath = "res/image/test_image/core_func_yellow.jpg";//R
//    	    	String imgPath = "res/image/test_image/plate_detect.jpg";//R
//    	    	String imgPath = "res/image/test_image/plate_judge.jpg";//R
//    	    	String imgPath = "res/image/test_image/plate_locate.jpg";//R
//    	    	String imgPath = "res/image/test_image/plate_recognize.jpg";//NULL
//    	    	String imgPath = "res/image/test_image/test.jpg";//R
    	
//    ============================R:34    W:17    NULL:21   Error:3=========================================	
//    	String imgPath = "res/image/general_test3/chuanC28888.jpg";//W   川C2888B
//    	String imgPath = "res/image/general_test3/heiA1R272.jpg";//R
//    	String imgPath = "res/image/general_test3/heiAB4444.jpg";//null
//    	String imgPath = "res/image/general_test3/huA51V39.jpg";//R
//    	String imgPath = "res/image/general_test3/huAGH092.jpg";//R
//    	String imgPath = "res/image/general_test3/huAP0910.jpg";//R
//    	String imgPath = "res/image/general_test3/huJ32500.jpg";//R
//    	String imgPath = "res/image/general_test3/huK62933.jpg";//R
//    	String imgPath = "res/image/general_test3/jinAHP676.jpg";//R
//    	String imgPath = "res/image/general_test3/jinE22602.jpg";//W   津ALZ680
//    	String imgPath = "res/image/general_test3/jingA88731.jpg";//ERROR
//    	String imgPath = "res/image/general_test3/jingCX8888.jpg";//W   京AX8880
//    	String imgPath = "res/image/general_test3/jinLS2999.jpg";//R
//    	String imgPath = "res/image/general_test3/jinRB7992.jpg";//NULL
//    	String imgPath = "res/image/general_test3/liaoB99999.jpg";//NULL
//    	String imgPath = "res/image/general_test3/liaoBMW005.jpg";//R
//    	String imgPath = "res/image/general_test3/liaoC33333.jpg";//NULL
//    	String imgPath = "res/image/general_test3/liaoPE9218.jpg";//R
//    	String imgPath = "res/image/general_test3/luA88888.jpg";//NULL
//    	String imgPath = "res/image/general_test3/luJRW350.jpg";//W   鲁J00300
//    	String imgPath = "res/image/general_test3/luKK5555.jpg";//R
//    	String imgPath = "res/image/general_test3/luLD9016.jpg";//W   川A09010
//    	String imgPath = "res/image/general_test3/luY44748.jpg";//R
//    	String imgPath = "res/image/general_test3/minHB1508.jpg";//R
//    	String imgPath = "res/image/general_test3/suA0CP56.jpg";//R
//    	String imgPath = "res/image/general_test3/suA6E176.jpg";//NULL
//    	String imgPath = "res/image/general_test3/suB551QV.jpg";//R
//    	String imgPath = "res/image/general_test3/suB577CU.jpg";//R
//    	String imgPath = "res/image/general_test3/suBGG522.jpg";//R
//    	String imgPath = "res/image/general_test3/suBU5838.jpg";//R
//    	String imgPath = "res/image/general_test3/suDLA031.jpg";//NULL
//    	String imgPath = "res/image/general_test3/suE2Y256.jpg";//R
//    	String imgPath = "res/image/general_test3/wanA00T45.jpg";//NULL
//    	String imgPath = "res/image/general_test3/wanA09T87.jpg";//NULL
//    	String imgPath = "res/image/general_test3/wanA1T235.jpg";//R
//    	String imgPath = "res/image/general_test3/wanA22T43.jpg";//R
//    	String imgPath = "res/image/general_test3/wanA2F56D.jpg";//NULL
//    	String imgPath = "res/image/general_test3/wanA45277.jpg";//R
//    	String imgPath = "res/image/general_test3/wanA80003.jpg";//W  冀AFJC5Z
//    	String imgPath = "res/image/general_test3/wanA80375.jpg";//R
//    	String imgPath = "res/image/general_test3/wanA85890.jpg";//R
//    	String imgPath = "res/image/general_test3/wanA87271.jpg";//W  皖A07271
//    	String imgPath = "res/image/general_test3/wanAA361D.jpg";//W  皖AA3610
//    	String imgPath = "res/image/general_test3/wanAH8331.jpg";//R
//    	String imgPath = "res/image/general_test3/wanAJH155.jpg";//W  川A1
//    	String imgPath = "res/image/general_test3/wanAK169H.jpg";//W  皖A01690
//    	String imgPath = "res/image/general_test3/wanAL025S.jpg";//R
//    	String imgPath = "res/image/general_test3/wanAS3165.jpg";//W  鄂M0AS31
//    	String imgPath = "res/image/general_test3/wanAT789S.jpg";//W  皖AT709S
//    	String imgPath = "res/image/general_test3/wanATH859.jpg";//R
//    	String imgPath = "res/image/general_test3/wanAUB816.jpg";//W E   皖A0816
//    	String imgPath = "res/image/general_test3/wanAX688A.jpg";//R
//    	String imgPath = "res/image/general_test3/wanBBC666.jpg";//NULL
//    	String imgPath = "res/image/general_test3/wanEZM618.jpg";//NULL
//    	String imgPath = "res/image/general_test3/wanF71646.jpg";//W  皖F71040
//    	String imgPath = "res/image/general_test3/wanM12288.jpg";//W  川A12200
//    	String imgPath = "res/image/general_test3/wanM69311.jpg";//NULL
//    	String imgPath = "res/image/general_test3/wanP77222.jpg";//R
//    	String imgPath = "res/image/general_test3/wanQ06417.jpg";//NULL
//    	String imgPath = "res/image/general_test3/wanQ18632.jpg";//NULL
//    	String imgPath = "res/image/general_test3/wanQ19917.jpg";//R
//    	String imgPath = "res/image/general_test3/wanQ80197.jpg";//NULL
//    	String imgPath = "res/image/general_test3/wanQA2825.jpg";//NULL
//    	String imgPath = "res/image/general_test3/xiangAL8387.jpg";//NULL
//    	String imgPath = "res/image/general_test3/xiangAT3597.jpg";//NULL
//    	String imgPath = "res/image/general_test3/xiangGR0L16.jpg";//W  豫F
//    	String imgPath = "res/image/general_test3/yueB0K999.jpg";//R
//    	String imgPath = "res/image/general_test3/yuK91239.jpg";//NULL
//    	String imgPath = "res/image/general_test3/yuS33909.jpg";//R
//    	String imgPath = "res/image/general_test3/zheA88888.jpg";//R
//    	String imgPath = "res/image/general_test3/zheB7C289.jpg";//NULL
//    	String imgPath = "res/image/general_test3/zheF397C0.jpg";//E
//    	String imgPath = "res/image/general_test3/zheG70000.jpg";//E
//    	String imgPath = "res/image/general_test3/zheGZB388.jpg";//R
    	
    	
    	//String imgPath = "res/image/general_test3/zheGZJ021.jpg";//W  浙GZ0021
    	String imgPath = "test4/r.jpg";//
    	
    	//boolean try_color_detect = false;// false/true
    	
    	EasyPrTest t = new EasyPrTest();
     	t.testPlateRecognise(imgPath);
    	
    }
}
