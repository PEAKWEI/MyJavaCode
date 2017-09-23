package org.dgw.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CretaZip {

	public static void main(String[] args) throws IOException {
		File file = new File("D:" + File.separator + "studentview.jar");
		File zipfile = new File("d:" + file.separator + "student.zip");
		FileOutputStream fileo = new FileOutputStream(zipfile);
		ZipOutputStream zoStream = new ZipOutputStream(fileo);
		FileInputStream filei = new FileInputStream(file);
		zoStream.setComment("123");
		//设置进入点的目的是 在开头位置，命名这个文件的文件名，设置异常将导致解压出来的文件异常
		zoStream.putNextEntry(new ZipEntry("1234444"));
		int temp = 0;
		while ((temp = filei.read()) != -1) {
			System.out.println("正在压缩");
			zoStream.write(temp);
		}
		zoStream.finish();
		filei.close();
		fileo.close();
	}

}
