package com.ranlj.authservice.util;

import java.util.Random;

public class RandomUtil {

	private static final String allChar="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private static final String numChar="0123456789";
	
	private static Random random = new Random();
	/**
	 * 生成定长的随机码(含大小写数据)
	 * @param length
	 * @return
	 */
	public static String generateString(int length) {
         StringBuffer sb = new StringBuffer();
         for (int i = 0; i < length; i++) {   
             sb.append(allChar.charAt(random.nextInt(allChar.length())));   
         }   
         return sb.toString();   
    }
	/**
	 * 生成定长的随机码(数字)
	 * @param length
	 * @return
	 */
	public static String generateNum(int length){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++){
			sb.append(numChar.charAt(random.nextInt(numChar.length())));
		}
		return sb.toString();
	}
  
}
