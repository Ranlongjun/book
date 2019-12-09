package com.ranlj.authservice.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class AuthenticationStringUtil {
	//手机号码
	private static final String phoneRegex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
     /**
      * MD5 加密
      * @param str
      * @return
      */
	 @SuppressWarnings("restriction")
	public static String EncoderByMd5(String str) {
	        //确定计算方法
	        MessageDigest md5= null;
	        try {
	            md5 = MessageDigest.getInstance("MD5");
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
			BASE64Encoder base64en = new BASE64Encoder();
	        //加密后的字符串
	        String newstr= null;
	        try {
	            newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        return newstr;
	    }
	 /**
	  * 校验手
	  * 机号码
	  * @return
	  */
	 public static boolean checkPhoneNum(String phone){
		 if(StringUtils.isBlank(phone)){
			 return false;
		 }
		 return Pattern.matches(phoneRegex, phone);
	 }
	 
	 public static void main(String[] args) {
		System.out.println(base64EncodeReverse("huangx"));
	}
	/**
     * Base64反转解密
     * @param v
     * @return
     * @throws Exception
     */
    public  static String base64DecodeReverse(String v) {
        if(StringUtils.isNotEmpty(v)){
            String val = new StringBuilder(v).reverse().toString();
            byte[] bytes = Base64.decodeBase64(val);
            return  new String(bytes);
        }
        else{
            return v;
        }
    }
    /**
     * Base64 加密反转
     * @param v
     * @return
     * @throws Exception
     */
    public  static String base64EncodeReverse(String v){
        if(StringUtils.isBlank(v)){
            return v;
        }
        byte[] bytes = Base64.encodeBase64(v.getBytes());
        String val = new StringBuilder(new String(bytes)).reverse().toString();
        return val;
    }
   
}
