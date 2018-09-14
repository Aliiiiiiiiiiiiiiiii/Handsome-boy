package wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SCount {
	SCount() throws IOException{
		System.out.print("������Ҫִ�еĲ���:wc.exe -s -");
		Scanner control=new Scanner(System.in);
		String ct= control.nextLine();
		System.out.print("������Ҫ�ݹ鴦���Ŀ¼·��:");
		Scanner in=new Scanner(System.in);
		String path= in.nextLine();
		System.out.print("������Ҫ�ݹ鴦����ļ�����:wc.exe -s -"+ct+" *.");
		Scanner style=new Scanner(System.in);
		String st= style.nextLine();
        File file=new File(path);
        String[] name=file.list();
        String s;
        int count=0;
		switch(ct) {
			case "c":
				Pattern cp=Pattern.compile("\\S");
				for(String n:name) {
					if(n.matches("\\S+."+st)) {  //�ҳ�Ŀ¼�·����ļ���׺���ļ�
		        			BufferedReader fis=new BufferedReader(new FileReader(path+"\\"+n));
		        			while((s=fis.readLine())!=null) {   //����Ĳ�����ǰ���ģ��һ��
		        				Matcher m=cp.matcher(s);
		        				while(m.find())
		        					count++;
		        			}
		        			System.out.println(n+"  ����"+count+"���ַ�");
		        			count=0;
		        			fis.close();
					}
				}
			break;
			
			case "w":
				Pattern wp=Pattern.compile("[^a-zA-Z]");
				for(String n:name) {
					if(n.matches("\\S+."+st)) {
		        			BufferedReader fis=new BufferedReader(new FileReader(path+"\\"+n));
		        			while((s=fis.readLine())!=null) {
		        				if(s.isEmpty()==false) {
		        				String[] letter=wp.split(s);
		        				for(String word : letter)
		        					count++;
		        				}
		        			}
		        			System.out.println(n+"  ����"+count+"������");
		        			count=0;
		        			fis.close();
					}
				}
			break;
				
			case "l":
				for(String n:name) {
					if(n.matches("\\S+."+st)) {
		        			BufferedReader fis=new BufferedReader(new FileReader(path+"\\"+n));
		        			while((s=fis.readLine())!=null) {
		        					count++;
		        			}
		        			System.out.println(n+"  ����"+count+"��");
		        			count=0;
		        			fis.close();
					}
				}
			break;
			
			case "a":
				
		}
	}
}
