package wc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineCount {	
	LineCount() throws IOException{
		System.out.println("�������ļ��ľ���·��");
		System.out.print("wc.exe -l ");
		Scanner inl=new Scanner(System.in);
		String path=inl.nextLine();
		BufferedReader fis=new BufferedReader(new FileReader(path));
		String s;
		int linecount=0;
		while((s=fis.readLine())!=null) {  //ֱ�Ӷ���һ�о�+1
				linecount++;
		}
		System.out.println("���ļ���"+linecount+"��\n\n");
		   fis.close();
	}
}
