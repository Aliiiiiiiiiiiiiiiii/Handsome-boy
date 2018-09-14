package wc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ACount {
	int total=0;
	int EmptyLine=0;
	int DescribeLine=0;
	int CodeLine=0;
	int tag=0;  //设置一个标志，要tag=0，证明这一行还没扫描到“/*”，tag=1说明已经扫到了
	ACount() throws IOException{
		Pattern p1=Pattern.compile("//");
		Pattern p2=Pattern.compile("//*");
		Pattern p3=Pattern.compile("/*/");
		System.out.println("请输入文件的绝对路径:");
		System.out.print("wc.exe -a ");
		Scanner ina=new Scanner(System.in);
		String path=ina.nextLine();
		BufferedReader fis=new BufferedReader(new FileReader(path));
		String s;
		while((s=fis.readLine())!=null) {
			total++;
			if(tag==0) {     //根据tag的值进行不同的操作
			Matcher m1=p1.matcher(s);
			Matcher m2=p2.matcher(s);
			if(s.isEmpty()||(s.startsWith("{")&&s.endsWith("{")))  //只有tag=0时才计算空行，要是在多行注释里面出现的空行算入注释行而不算空行
				EmptyLine++;
			else if(m1.find())
				DescribeLine++;
			else if(m2.find()) {
				DescribeLine++;
				tag=1;
			}
			}
			else {
				DescribeLine++;
				Matcher m3=p3.matcher(s);
				if(m3.find())  //当匹配到“*/”的时候，说明多行注释结束，把tag置为0
					tag=0;
			}
		}
		CodeLine=total-DescribeLine-EmptyLine;
		System.out.println("该文件有"+EmptyLine+"行空行");
		System.out.println("该文件有"+DescribeLine+"行注释行");
		System.out.println("该文件有"+CodeLine+"行代码行\n\n");
		fis.close();
	}
}
