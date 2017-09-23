package org.dgw.student;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Datainputdtream {

	public static void main(String[] args) throws IOException {

		DataOutputStream diStream = new DataOutputStream(new FileOutputStream(new File("d:/java.txt")));
				for (int i = 0; i <1000; i++) {
					StringBuffer stringBuffer=new StringBuffer();
					stringBuffer.append(i);
					diStream.writeUTF(new String(stringBuffer));
					
				}
	}

}
