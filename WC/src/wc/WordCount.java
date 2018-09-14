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
		System.out.println("请输入文件的绝对路径:");
		System.out.print("wc.exe -w ");
		Scanner inw=new Scanner(System.in);
		String path=inw.nextLine();
		BufferedReader fis=new BufferedReader(new FileReader(path));
		String s;
		int wordcount=0;
		while((s=fis.readLine())!=null) {
			if(s.isEmpty()==false) {   //要不是一行空行才进行下面的操作，不然要是有空行的话结果不对
			String[] letter=p.split(s);
			for(String word : letter)
				wordcount++;
			   }
			}
		System.out.println("该文件有"+wordcount+"个单词\n\n");
		   fis.close();
	}
}

