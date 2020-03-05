package com.lihui.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {

	/**
	 * 
	 * @Title: closeStream 
	 * @Description: 关闭流
	 * @param autoCloseables
	 * @return: void
	 */
	public static void closeStream(AutoCloseable ...autoCloseables ) {
		if(autoCloseables!=null) {
			for (AutoCloseable autoCloseable : autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 
	 * @Title: readLine 
	 * @Description: 按行读流
	 * @param ips
	 * @return
	 * @return: List<String>
	 */
	public static List<String> readLine(InputStream ips){
		List<String> list=new ArrayList<String>();
		String line="";
		BufferedReader bufferedReader =null;
		try {
			/*转换流，将字节输入流转换为字符输入流
			 * InputStreamReader reader = new InputStreamReader(ips,"utf-8"); BufferedReader
			 * 缓冲流，字符输入缓冲流
			 * bufferedReader = new BufferedReader(reader);
			 */
			bufferedReader = new BufferedReader(new InputStreamReader(ips, "utf-8"));
			line=bufferedReader.readLine();
			while (null!=line) {
				list.add(line);
				line=bufferedReader.readLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeStream(bufferedReader,ips);
		}
		return list;
	}
	
	/**
	 * 
	 * @Title: readFile 
	 * @Description: 按字节读流
	 * @param file
	 * @return
	 * @return: String
	 */
	public static String readFile(File file){
		StringBuffer stringBuffer = new StringBuffer();
		InputStream ips=null;
		try {
			ips=new FileInputStream(file);
			byte[] b=new byte[1024];
			int reads ;
			while((reads= ips.read(b))!=-1) {
				stringBuffer.append(new String(b));
				reads=ips.read();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeStream(ips);
		}
		return stringBuffer.toString();
	}
	
	public static String readTextFile(String fileName) {
		return readFile(new File(fileName));
	}
	
	public static void writeTextFile(String content,File file) {
			//e:/aa/bb/aa.txt
		String parent = file.getParent();//e:/aa/bb
		//父目录   文件夹
		File parentFile=new File(parent);
		if(!parentFile.exists()) {
			parentFile.mkdirs();
		}
		//写到文件
		Writer fw = null;
		BufferedWriter bw=null;
		try {
			fw = new FileWriter(file);
			 bw=new BufferedWriter(fw);
			 bw.write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeStream(bw,fw);
		}
		
	}
	
}
