package wc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCount {
	String REGEX="[^a-zA-Z]";
	
	WordCount() throws IOException{
		Pattern p=Pattern.compile(REGEX);
		System.out.println("�������ļ��ľ���·��:");
		System.out.print("wc.exe -w ");
		Scanner inw=new Scanner(System.in);
		String path=inw.nextLine();
		BufferedReader fis=new BufferedReader(new FileReader(path));
		String s;
		int wordcount=0;
		while((s=fis.readLine())!=null) {
			if(s.isEmpty()==false) {   //Ҫ����һ�п��вŽ�������Ĳ�������ȻҪ���п��еĻ��������
			String[] letter=p.split(s);
			for(String word : letter)
				wordcount++;
			   }
			}
		System.out.println("���ļ���"+wordcount+"������\n\n");
		   fis.close();
	}
}

