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
	int tag=0;  //����һ����־��Ҫtag=0��֤����һ�л�ûɨ�赽��/*����tag=1˵���Ѿ�ɨ����
	ACount() throws IOException{
		Pattern p1=Pattern.compile("//");
		Pattern p2=Pattern.compile("//*");
		Pattern p3=Pattern.compile("/*/");
		System.out.println("�������ļ��ľ���·��:");
		System.out.print("wc.exe -a ");
		Scanner ina=new Scanner(System.in);
		String path=ina.nextLine();
		BufferedReader fis=new BufferedReader(new FileReader(path));
		String s;
		while((s=fis.readLine())!=null) {
			total++;
			if(tag==0) {     //����tag��ֵ���в�ͬ�Ĳ���
			Matcher m1=p1.matcher(s);
			Matcher m2=p2.matcher(s);
			if(s.isEmpty()||(s.startsWith("{")&&s.endsWith("{")))  //ֻ��tag=0ʱ�ż�����У�Ҫ���ڶ���ע��������ֵĿ�������ע���ж��������
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
				if(m3.find())  //��ƥ�䵽��*/����ʱ��˵������ע�ͽ�������tag��Ϊ0
					tag=0;
			}
		}
		CodeLine=total-DescribeLine-EmptyLine;
		System.out.println("���ļ���"+EmptyLine+"�п���");
		System.out.println("���ļ���"+DescribeLine+"��ע����");
		System.out.println("���ļ���"+CodeLine+"�д�����\n\n");
		fis.close();
	}
}
