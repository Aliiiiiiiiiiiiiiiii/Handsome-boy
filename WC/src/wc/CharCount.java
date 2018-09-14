package wc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharCount {
	String REGEX="\\S"; //非空白字符
	
	CharCount() throws IOException{
		Pattern p=Pattern.compile(REGEX);  //利用正则表达式Pattern类以及Matcher类
		System.out.println("请输入文件的绝对路径:");
		System.out.print("wc.exe -c ");
		Scanner inc=new Scanner(System.in);
		String path=inc.nextLine();
		BufferedReader fis=new BufferedReader(new FileReader(path));
		String s;
		int charcount=0;
		while((s=fis.readLine())!=null) {
			Matcher m=p.matcher(s);  //对正则表达式进行模式匹配
			while(m.find())
				charcount++;
		}
		System.out.println("该文件有"+charcount+"个字符\n\n");
		fis.close();
	}
}
