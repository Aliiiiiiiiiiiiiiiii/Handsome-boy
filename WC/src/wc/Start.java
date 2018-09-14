package wc;

import java.io.IOException;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		System.out.println("Welcome to wc.exe!\n");
		System.out.println("----------指令参考-----------");
		System.out.println("wc.exe -c   返回文件的字符数");
		System.out.println("wc.exe -w   返回文件的单词数");
		System.out.println("wc.exe -l   返回文件的行数");
		System.out.println("wc.exe -s   递归处理目录下符合条件的文件");
		System.out.println("wc.exe -a   返回代码行 / 空行 / 注释行");
		System.out.println("wc.exe -x   显示图形界面");
		System.out.println("wc.exe -exit   退出");
		System.out.println("-------------------------------------\n");
		while(true) {
			System.out.print("请输入指令: wc.exe -");
			Scanner s=new Scanner(System.in);
			String in= s.nextLine();
			switch(in) { //输入不同的指令打开不同的类，实现不同的功能
			case "c":
				CharCount cc=new CharCount();
				break;
			case "w":
				WordCount wc=new WordCount();
				break;
			case "l":
				LineCount lc=new LineCount();
				break;
			case "s":
				SCount sc=new SCount();
				break;
			case "a":
				ACount ac=new ACount();
				break;
			case "x":
				HighLevel hl=new HighLevel();
				break;
			case "exit":
				System.out.println("Good Bye!");
				System.exit(0);
			default:
				System.out.println("请输入正确的命令");
				
			}
		}
	}

}
