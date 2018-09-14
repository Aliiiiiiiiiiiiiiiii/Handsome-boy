package wc;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class HighLevel extends JFrame implements ActionListener{
       JLabel welcome=new JLabel("Weclome Back!",JLabel.CENTER);
       JLabel none1=new JLabel("                             ");
       JLabel none2=new JLabel("                             ");
       JTextArea write=new JTextArea(60,60);
       JScrollPane sp=new JScrollPane(write);
       Color color=new Color(0,0,0);
   HighLevel(){
	   setTitle("WC.exe");
	   setBounds(0,0,900,600);
	   Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
	   setLocation((screen.width-900)/2,(screen.height-600)/2);
	   JPanel p=new JPanel();
	   this.add(p);
	   p.setBackground(Color.DARK_GRAY);
	   p.setLayout(new BorderLayout());
	   JPanel p1=new JPanel();
	   p1.setLayout(new GridLayout(1,3,200,0));
	   JMenuBar mb=new JMenuBar();
	   setJMenuBar(mb);
	   JMenu m=new JMenu("��ʼ");
	   mb.add(m);
	   JMenuItem m1=new JMenuItem("��");
	   JMenuItem m2=new JMenuItem("�˳�");
	   m.setFont(new Font("��Բ",Font.BOLD,35));
	   m1.setFont(new Font("��Բ",Font.BOLD,25));
	   m2.setFont(new Font("��Բ",Font.BOLD,25));
	   m.add(m1);
	   m.add(m2);
	   JMenu help=new JMenu("����");
	   help.setFont(new Font("��Բ",Font.BOLD,35));
	   mb.add(help);
	   JMenu about=new JMenu("����");
	   about.setFont(new Font("��Բ",Font.BOLD,35));
	   JMenu setting=new JMenu("����");
	   setting.setFont(new Font("��Բ",Font.BOLD,35));
	   JMenuItem m3=new JMenuItem("������ɫ");
	   JMenuItem m4=new JMenuItem("�ı���ɫ");
	   m3.setFont(new Font("��Բ",Font.BOLD,25));
	   m4.setFont(new Font("��Բ",Font.BOLD,25));
	   setting.add(m3);
	   setting.add(m4);
	   mb.add(about);
	   mb.add(setting);
	   write.setFont(new Font("��Բ",Font.BOLD,35));
	   write.setEditable(false);
	   welcome.setFont(new Font("Script MT Bold",Font.BOLD,50));
	   welcome.setForeground(Color.WHITE);
	   p.add(welcome,BorderLayout.NORTH);
	   p.add(sp,BorderLayout.CENTER);
	   p.add(none1,BorderLayout.WEST);
	   p.add(none2,BorderLayout.EAST);
	   p.add(p1,BorderLayout.SOUTH);
	   m1.addActionListener(this);
	   m2.addActionListener(this);
	   m3.addActionListener(this);
	   m4.addActionListener(this);
	   this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   this.setVisible(true);
   }
   public void actionPerformed(ActionEvent e){
	   if(e.getActionCommand()=="��") {
		   Pattern pp1=Pattern.compile("\\S");
		   Pattern pp2=Pattern.compile("[^a-zA-Z]");
		   FileDialog open=new FileDialog(this,"open",FileDialog.LOAD);
		   open.setVisible(true);
		   try {
			   String openfile=open.getDirectory()+open.getFile();
			   BufferedReader fis=new BufferedReader(new FileReader(openfile));
			   String s;
			   int charcount=0;
			   int wordcount=0;
			   int linecount=0;
			   while((s=fis.readLine())!=null) {
				   Matcher m=pp1.matcher(s);
				   while(m.find())
					   charcount++;
				   if(s.isEmpty()==false) {
						String[] letter=pp2.split(s);
						for(String word : letter)
							wordcount++;
						   }
				   linecount++;
				   write.append(s);
				   write.append("\n");
			   }
			   write.append("\n\n���ļ���"+charcount+"���ַ�\n");
			   write.append("���ļ���"+wordcount+"������\n");
			   write.append("���ļ���"+linecount+"��\n");
			   fis.close();
		   }catch(IOException ioe) {
			   System.out.println("ERROR");
		   }
	   }
	   else if(e.getActionCommand()=="�˳�") {
	   System.exit(0);}
	   else if(e.getActionCommand()=="������ɫ") {
			color= JColorChooser.showDialog(this,"ѡ����ɫ",color);
			if (color==null ) color=Color.BLACK; 
			write.setForeground(color);
	   }
	   else if(e.getActionCommand()=="�ı���ɫ") {
			color= JColorChooser.showDialog(this,"ѡ����ɫ",color);
			if (color==null ) color=Color.WHITE; 
			write.setBackground(color);
	   }
   }
}