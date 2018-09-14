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
		System.out.print("请输入要执行的操作:wc.exe -s -");
		Scanner control=new Scanner(System.in);
		String ct= control.nextLine();
		System.out.print("请输入要递归处理的目录路径:");
		Scanner in=new Scanner(System.in);
		String path= in.nextLine();
		System.out.print("请输入要递归处理的文件类型:wc.exe -s -"+ct+" *.");
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
					if(n.matches("\\S+."+st)) {  //找出目录下符合文件后缀的文件
		        			BufferedReader fis=new BufferedReader(new FileReader(path+"\\"+n));
		        			while((s=fis.readLine())!=null) {   //这里的操作跟前面的模块一样
		        				Matcher m=cp.matcher(s);
		        				while(m.find())
		        					count++;
		        			}
		        			System.out.println(n+"  中有"+count+"个字符");
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
		        			System.out.println(n+"  中有"+count+"个单词");
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
		        			System.out.println(n+"  中有"+count+"行");
		        			count=0;
		        			fis.close();
					}
				}
			break;
			
			case "a":
				
		}
	}
}
