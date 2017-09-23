package org.dgw.zip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Unzip{
	    public static void main(String[] args) throws IOException, Exception {
	    	File file = new File("d:" + File.separator + "student.zip");
	    	File file123 = new File("D:" + File.separator + "studentview.jar");
	    	ZipFile zFile=new ZipFile(file);
	    	//与原来设置的进入点 相同才能执行相同的操作！@
	    	ZipEntry zipEntr=zFile.getEntry("1234444");
	    	InputStream inputStream=zFile.getInputStream(zipEntr);
	    	OutputStream outputStream=new FileOutputStream(file123);
	    	int temp;
	    	while((temp=inputStream.read())!=-1){
	    		outputStream.write(temp);
	    	}
	    	inputStream.close();
	    	outputStream.close();
		} 
  
			
}
 