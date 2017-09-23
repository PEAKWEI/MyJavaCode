package org.dgw.student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BufferWriter {
	
	  public static void main(String[] args) throws IOException {
		Random random=new Random(100);
		File file=new File("D:/word.txt");
		FileWriter fw1 = null;
		try {
			fw1 = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bufferedWriter=new BufferedWriter(fw1);
		for (int i = 0; i <10000000; i++) {
			bufferedWriter.write(random.nextInt());
			
			
			
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		fw1.close();
		
		
		
	}

}
