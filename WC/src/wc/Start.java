package wc;

import java.io.IOException;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		System.out.println("Welcome to wc.exe!\n");
		System.out.println("----------ָ��ο�-----------");
		System.out.println("wc.exe -c   �����ļ����ַ���");
		System.out.println("wc.exe -w   �����ļ��ĵ�����");
		System.out.println("wc.exe -l   �����ļ�������");
		System.out.println("wc.exe -s   �ݹ鴦��Ŀ¼�·����������ļ�");
		System.out.println("wc.exe -a   ���ش����� / ���� / ע����");
		System.out.println("wc.exe -x   ��ʾͼ�ν���");
		System.out.println("wc.exe -exit   �˳�");
		System.out.println("-------------------------------------\n");
		while(true) {
			System.out.print("������ָ��: wc.exe -");
			Scanner s=new Scanner(System.in);
			String in= s.nextLine();
			switch(in) { //���벻ͬ��ָ��򿪲�ͬ���࣬ʵ�ֲ�ͬ�Ĺ���
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
				System.out.println("��������ȷ������");
				
			}
		}
	}

}
