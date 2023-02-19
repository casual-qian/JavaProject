package Score;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class TestClass {
	private StudentClass studentClass;
	public static void main(String[] args) {
		TestClass testClass = new TestClass();
		//��ʼ���༶ѧ����Ϣ
		testClass.Init();
		//Ϊ��ʼ����ѧ����Ϣ����Excel���
		testClass.CreateExcel(testClass.studentClass.getStudent());	
		//ѧ����Ϣ�������
		testClass.studentClass.OrderByTotal();
		testClass.studentClass.OrderByComputer();
		testClass.studentClass.OrderByMath();
		testClass.studentClass.OrderByEnglish();
	}
	
	public void Init() {
		Scanner input = new Scanner(System.in);
		Student[] students = new Student[5];
		for(int i=1;i<=5;i++) {
			System.out.print("�������" + i + "λѧ��ѧ�ţ�");
			String id = input.next();
			System.out.print("������");
			String name = input.next();
			System.out.print("������ɼ���");
			double computer = input.nextDouble();
			System.out.print("��ѧ�ɼ���");
			double math = input.nextDouble();
			System.out.print("Ӣ��ɼ���");
			double english =  input.nextDouble();
			Student Current = new Student(id,name,computer,math,english);
			students[i-1]=Current;
		}
		this.studentClass = new StudentClass(5,students);
		System.out.println("��ʼ��ѧ����Ϣ���£�");
		this.studentClass.PrintStudent();
	}
	
	/**
	 * ��ѧ����Ϣд��Excel�ļ�
	 * @param student
	 */
	public void CreateExcel(Student[] student) {
		try {
			WritableWorkbook book = Workbook.createWorkbook(new File("D:\\class.xls"));
            WritableSheet sheet = book.createSheet("sheet1", 0);  
            Label label = new Label(0, 0, "ѧ��");
            sheet.addCell(label);
            label = new Label(1, 0, "����");  
            sheet.addCell(label);
            label = new Label(2, 0, "�����");  
            sheet.addCell(label);
            label = new Label(3, 0, "��ѧ");  
            sheet.addCell(label);
            label = new Label(4, 0, "Ӣ��");  
            sheet.addCell(label);
            label = new Label(5, 0, "�ܷ�");  
            sheet.addCell(label);
            Number number;
            for(int i=1;i<=5;i++) {
            	label = new Label(0, i, student[i-1].getId());  
                sheet.addCell(label);
                label = new Label(1, i, student[i-1].getName());
                sheet.addCell(label);
                number = new Number(2, i, student[i-1].getComputer());  
                sheet.addCell(number);
                number = new Number(3, i, student[i-1].getMath());  
                sheet.addCell(number);
                number = new Number(4, i, student[i-1].getEnglish());  
                sheet.addCell(number);
                number = new Number(5, i, student[i-1].getTotal());  
                sheet.addCell(number);
            }
			book.write();;
			book.close();
			System.out.println("��ʼѧ����Ϣ�Ѿ�д��D���µġ�class.xls���ļ�");
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println(e);
		}
	}
}
