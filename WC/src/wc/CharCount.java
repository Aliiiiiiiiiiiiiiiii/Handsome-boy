package wc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharCount {
	String REGEX="\\S"; //�ǿհ��ַ�
	
	CharCount() throws IOException{
		Pattern p=Pattern.compile(REGEX);  //����������ʽPattern���Լ�Matcher��
		System.out.println("�������ļ��ľ���·��:");
		System.out.print("wc.exe -c ");
		Scanner inc=new Scanner(System.in);
		String path=inc.nextLine();
		BufferedReader fis=new BufferedReader(new FileReader(path));
		String s;
		int charcount=0;
		while((s=fis.readLine())!=null) {
			Matcher m=p.matcher(s);  //��������ʽ����ģʽƥ��
			while(m.find())
				charcount++;
		}
		System.out.println("���ļ���"+charcount+"���ַ�\n\n");
		fis.close();
	}
}
