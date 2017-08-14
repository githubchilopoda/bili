package com.crawl.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;




/**
 * @description: HttpClient工具
 * @author: Paul.Li
 * @date: 2013-12-25
 * @version: 1.0
 *
 */

public class HttpUtils {

    public static String doPost(String url, Map<String, String> params, String charset) {
        StringBuffer response = new StringBuffer();
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        List<NameValuePair> list = new ArrayList<NameValuePair>();
        //设置Http Post数据
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                post.setEntity(new UrlEncodedFormEntity(list, charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            HttpResponse httpResponse = client.execute(post);
            //if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),charset));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
            //}else{
            //    ResultObject responseContent=new ResultObject(ResultCode.SERVER_ERROR.toString(),ResultMessage.SERVER_ERROR);
            //    response.append(JsonHelper.ObjToJsonStr(responseContent));
            //}
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            post.releaseConnection();
            client.getConnectionManager().shutdown();
        }
        return response.toString();
    }
    
    public static String doPost(String url, Map<String, String> params, Map<String, String> headers, String charset) {
        StringBuffer response = new StringBuffer();
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        List<NameValuePair> list = new ArrayList<NameValuePair>();
        //设置Http Post数据
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                post.setEntity(new UrlEncodedFormEntity(list, charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (headers != null){
        	for (Map.Entry<String, String> entry : headers.entrySet()) {
        		post.addHeader(entry.getKey(), entry.getValue());
            }
        }
        
        try {
            HttpResponse httpResponse = client.execute(post);
            //if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),charset));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
            //}else{
            //    ResultObject responseContent=new ResultObject(ResultCode.SERVER_ERROR.toString(),ResultMessage.SERVER_ERROR);
            //    response.append(JsonHelper.ObjToJsonStr(responseContent));
            //}
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            post.releaseConnection();
            client.getConnectionManager().shutdown();
        }
        return response.toString();
    }


    public static String doPost(String url, Map<String, String> params, String charset,Map connectionMap) {
        StringBuffer response = new StringBuffer();
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        List<NameValuePair> list = new ArrayList<NameValuePair>();
        //设置Http Post数据
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                post.setEntity(new UrlEncodedFormEntity(list, charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {

            if(connectionMap!=null){
                if(connectionMap.containsKey(CoreConnectionPNames.CONNECTION_TIMEOUT)){
                    client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,connectionMap.get(CoreConnectionPNames.CONNECTION_TIMEOUT)); //连接时间
                }

                if(connectionMap.containsKey(CoreConnectionPNames.SO_TIMEOUT)){
                    client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,connectionMap.get(CoreConnectionPNames.SO_TIMEOUT));//数据传输时间
                }
            }

            HttpResponse httpResponse = client.execute(post);
            //if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),charset));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            //}else{
            //    ResultObject responseContent=new ResultObject(ResultCode.SERVER_ERROR.toString(),ResultMessage.SERVER_ERROR);
            //    response.append(JsonHelper.ObjToJsonStr(responseContent));
            //}
        } catch (IOException e) {
            e.printStackTrace();            
        } finally {
            post.releaseConnection();
            client.getConnectionManager().shutdown();
        }
        return response.toString();
    }

    public static String doGet(String url, Map<String, String> params, String charset,Map connectionMap) {
        StringBuffer response = new StringBuffer();
        HttpClient client = new DefaultHttpClient();

        List<NameValuePair> list = new ArrayList<NameValuePair>();
        //设置Http Get数据
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(list, charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        HttpGet get = new HttpGet(url);

        try {

            if(connectionMap!=null){
                if(connectionMap.containsKey(CoreConnectionPNames.CONNECTION_TIMEOUT)){
                    client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,connectionMap.get(CoreConnectionPNames.CONNECTION_TIMEOUT)); //连接时间
                }

                if(connectionMap.containsKey(CoreConnectionPNames.SO_TIMEOUT)){
                    client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,connectionMap.get(CoreConnectionPNames.SO_TIMEOUT));//数据传输时间
                }
            }

            HttpResponse httpResponse = client.execute(get);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),charset));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
            }else{
                
            }
        } catch (IOException e) {
            e.printStackTrace();           
        } finally {
            get.releaseConnection();
            client.getConnectionManager().shutdown();
        }
        return response.toString();
    }
    
//    public static String doGet(String url, Map<String, Object> params, String charset) {
//    	Map<String, String> converted = new HashMap<String, String>();
//    	Set<String> keySet = params.keySet();
//    	for (String key: keySet){
//    		Object obj = params.get(key);
//    		String val = "";
//    		if (obj != null){
//    			val = obj.toString();
//    		}
//    		converted.put(key, val);
//    	}
//    	return doGet(url, converted, charset);
//	}
    
    public static String getFullUrl(String url, Map<String, String> params, String charset){

        List<NameValuePair> list = new ArrayList<NameValuePair>();
        //设置Http Get数据
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(list, charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return url;
    }

    public static String doGet(String url, Map<String, String> params, String charset) {
        StringBuffer response = new StringBuffer();
        HttpClient client = new DefaultHttpClient();

        List<NameValuePair> list = new ArrayList<NameValuePair>();
        //设置Http Get数据
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(list, charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse httpResponse = client.execute(get);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),charset));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line + "\n");
                }
                reader.close();
            }else{
                
            }
        } catch (IOException e) {
            e.printStackTrace();            
        } finally {
            get.releaseConnection();
            client.getConnectionManager().shutdown();
        }
        return response.toString();
    }


    public static String doPostList(String url, Map<String, List<String>> params, String charset) {
        StringBuffer response = new StringBuffer();
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        List<NameValuePair> list = new ArrayList<NameValuePair>();
        //设置Http Post数据
        if (params != null) {
            for (Map.Entry<String, List<String>> entry : params.entrySet()) {
                List<String> paramNameValues = entry.getValue();
                if (paramNameValues != null && !paramNameValues.isEmpty()) {
                    for (String value : paramNameValues) {
                        list.add(new BasicNameValuePair(entry.getKey(), value));
                    }
                }
            }
            try {
                post.setEntity(new UrlEncodedFormEntity(list, charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            HttpResponse httpResponse = client.execute(post);
            //if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),charset));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            //}else{
            //    ResultObject responseContent=new ResultObject(ResultCode.SERVER_ERROR.toString(),ResultMessage.SERVER_ERROR);
            //    response.append(JsonHelper.ObjToJsonStr(responseContent));
            //}
        } catch (IOException e) {
            e.printStackTrace();            
        } finally {
            post.releaseConnection();
        }
        return response.toString();
    }


    public static String doGetHttp(String url, Map<String, String[]> data, HttpServletRequest request, String charset) throws SocketTimeoutException, IOException{

        return sendRequest(getHttpGet(url,data,request,charset), charset);
    }


    public static String sendRequest(HttpUriRequest httpUriRequest, String charset) throws SocketTimeoutException, IOException{
        HttpClient client = new DefaultHttpClient();
        client.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT, 10*60000);

        try {
            HttpResponse response = client.execute(httpUriRequest);

            String responseContent = "";
            int statusCode = response.getStatusLine().getStatusCode();

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                try {
                    responseContent = EntityUtils.toString(responseEntity, charset);
                    EntityUtils.consume(responseEntity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if ( statusCode == HttpStatus.SC_MOVED_TEMPORARILY
                    || statusCode == HttpStatus.SC_MOVED_PERMANENTLY ) {
                responseContent = response.getFirstHeader(HttpHeaders.LOCATION).getValue();
            } else {
                HttpEntity responseEntity = response.getEntity();
                try {
                    responseContent = EntityUtils.toString(responseEntity, charset);
                    EntityUtils.consume(responseEntity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return responseContent;
        } catch (SocketTimeoutException e) {

            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            client.getConnectionManager().shutdown();
        }
    }


    public static HttpGet getHttpGet(String url, Map<String, String[]> data, HttpServletRequest request,String charset)
            throws UnsupportedEncodingException {
        if (url.lastIndexOf("/") == (url.length() - 1)) {
            url = url.substring(0, url.length() - 1);
        }

        StringBuilder queryString = new StringBuilder(url);
        String getUrl;

        if(data != null && data.size() > 0){
            queryString.append("?");
        }
        for (Map.Entry<String, String[]> entry : data.entrySet()) {
            for(String value : entry.getValue()) {
                if ("".equals(value)) {
                    continue;
                }
                queryString.append(entry.getKey()).append("=").append(URLEncoder.encode(value, charset)).append("&");
            }
        }

        if(queryString.lastIndexOf("&") == queryString.length() - 1){
            getUrl=queryString.substring(0, queryString.length() - 1);
        }

        getUrl=queryString.toString();


        HttpGet httpGet = new HttpGet(getUrl);



        httpGet.addHeader("Content-Type", "text/xml; charset=" + charset);
        return httpGet;
    }
    
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 ||"unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 ||"unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 ||"unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
     }
    
    public static Map<String, String> convertParamMap(Map<String, Object> params) {
		Map<String, String> converted = new HashMap<String, String>();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			Object obj = params.get(key);
			String val = "";
			if (obj != null) {
				val = obj.toString();
			}
			converted.put(key, val);
		}
		return converted;
	}
}
