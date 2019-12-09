package com.ranlj.authservice.util;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class HttpRequestUtils {

	private static Logger logger = Logger.getLogger(HttpRequestUtils.class);    //日志记录
	
    /**
     * 
     * @param url
     * @param param
     * @return
     */
    public static boolean httpPost(String url, Map<String, String> param){
    	boolean messageFlag = false;
        //post请求返回结果
    	CloseableHttpClient httpClient = HttpClients.createDefault();
        UrlEncodedFormEntity entity = null;
        List<NameValuePair> params=null;
        HttpPost httpPost =null;
        try {
        	url = URLDecoder.decode(url, "UTF-8");
        	httpPost = new HttpPost(url);
        	httpPost.setConfig(RequestConfig.custom().setConnectTimeout(2000).build());
            if (null != param) {
            	params= new ArrayList<NameValuePair>();
            	for(Entry<String, String> entry:param.entrySet()){
            		params.add(new  BasicNameValuePair(entry.getKey(),entry.getValue()));
            	}
            	entity = new UrlEncodedFormEntity(params,"utf-8");
            	httpPost.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(httpPost);
            
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
            	 messageFlag = true;
            }
            else{
            	logger.error("post请求提交响应码失败"+result.getStatusLine().getStatusCode());
            	messageFlag=false;
            } 
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url);
            messageFlag=false;
        }finally{
        	httpPost.releaseConnection();
        }
        return messageFlag;
    }
    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static boolean httpGet(String url){
    	boolean messageFlag = false;
    	HttpGet request =null;
        try {
        	CloseableHttpClient httpClient = HttpClients.createDefault();
            url = URLDecoder.decode(url, "UTF-8");
            //发送get请求
            request= new HttpGet(url);
            request.setConfig(RequestConfig.custom().setConnectTimeout(2000).build());
            HttpResponse response = httpClient.execute(request);
           
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            	messageFlag=true;
            } else {
            	logger.error("get请求提交响应码失败"+response.getStatusLine().getStatusCode());
            	messageFlag=false;
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
            messageFlag=false;
        }finally{
        	request.releaseConnection();
        }
        return messageFlag;
    }
    public static void main(String[] args) {
//		String url="http://192.168.5.112:8088/auth-getUser";
//		Map<String,String> param = new HashMap<String,String>();
//		param.put("sId", "150fb8a8489346a8bb0c25e85431e293");
//		System.out.println(httpPost(url, param));
	}
}
