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
		//���ý�����Ŀ���� �ڿ�ͷλ�ã���������ļ����ļ����������쳣�����½�ѹ�������ļ��쳣
		zoStream.putNextEntry(new ZipEntry("1234444"));
		int temp = 0;
		while ((temp = filei.read()) != -1) {
			System.out.println("����ѹ��");
			zoStream.write(temp);
		}
		zoStream.finish();
		filei.close();
		fileo.close();
	}

}
