package wc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineCount {	
	LineCount() throws IOException{
		System.out.println("请输入文件的绝对路径");
		System.out.print("wc.exe -l ");
		Scanner inl=new Scanner(System.in);
		String path=inl.nextLine();
		BufferedReader fis=new BufferedReader(new FileReader(path));
		String s;
		int linecount=0;
		while((s=fis.readLine())!=null) {  //直接读到一行就+1
				linecount++;
		}
		System.out.println("该文件有"+linecount+"行\n\n");
		   fis.close();
	}
}
