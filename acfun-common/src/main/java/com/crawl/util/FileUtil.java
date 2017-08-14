package com.crawl.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class FileUtil {	


	public static File inputStreamToFile(InputStream ins,String fileDir, String filePath) throws IOException {
		File fd = new File(fileDir);
		if(!fd.exists()){
			fd.mkdirs();
		}
		
		File file = new File(filePath);
		if(!file.exists()){       
            file.createNewFile();
        } 
		
		OutputStream os = new FileOutputStream(file);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		ins.close();

		return file;
	}
	
	public static void filePutContent(String fileName, String content, String charset){
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			fos.write(content.getBytes(charset));
			fos.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getFileExtName(String name) {
		int index = name.lastIndexOf(".");
		if (index >= 0) {
			return name.substring(index + 1) != null ? name.substring(index + 1).toLowerCase() : null;
		} else {
			return null;
		}
	}
	
	public static String getFileBaseName(String name) {
		int index = name.lastIndexOf(".");
		if (index >= 0) {
			return name.substring(0, index);
		} else {
			return name;
		}
	}
	
	public static String getFileContents(String fileName, String charset) throws Exception{
		FileInputStream fis = new FileInputStream(fileName);
		String contents = getFileContents(fis, charset);
		fis.close();
		return contents;
	}
	
	public static String getFileContents(InputStream is, String charset) throws Exception{
		
		InputStreamReader reader = new InputStreamReader(is, Charset.forName(charset));
		
		StringBuffer buffer = new StringBuffer();
		BufferedReader br = new BufferedReader(reader);
		while (true){
			String line = br.readLine();
			if (line == null){
				break;
			}
			buffer.append(line + System.lineSeparator());
		}
		br.close();
		reader.close();		
		return buffer.toString();
	}
	
	public static byte[] readInputStream(InputStream inStream) throws Exception{  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        //创建一个Buffer字符串  
        byte[] buffer = new byte[1024];  
        //每次读取的字符串长度，如果为-1，代表全部读取完毕  
        int len = 0;  
        //使用一个输入流从buffer里把数据读取出来  
        while( (len=inStream.read(buffer)) != -1 ){  
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
            outStream.write(buffer, 0, len);  
        }  
        //关闭输入流  
        inStream.close();  
        //把outStream里的数据写入内存  
        return outStream.toByteArray();  
    }

	public static void filePutContents(String fileName, String contents) throws Exception {
		FileOutputStream fos = new FileOutputStream(fileName);
		fos.write(contents.getBytes("utf-8"));
		fos.close();
	} 
}
