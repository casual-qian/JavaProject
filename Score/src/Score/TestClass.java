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
		//初始化班级学生信息
		testClass.Init();
		//为初始化的学生信息建立Excel表格
		testClass.CreateExcel(testClass.studentClass.getStudent());	
		//学生信息按序输出
		testClass.studentClass.OrderByTotal();
		testClass.studentClass.OrderByComputer();
		testClass.studentClass.OrderByMath();
		testClass.studentClass.OrderByEnglish();
	}
	
	public void Init() {
		Scanner input = new Scanner(System.in);
		Student[] students = new Student[5];
		for(int i=1;i<=5;i++) {
			System.out.print("请输入第" + i + "位学生学号：");
			String id = input.next();
			System.out.print("姓名：");
			String name = input.next();
			System.out.print("计算机成绩：");
			double computer = input.nextDouble();
			System.out.print("数学成绩：");
			double math = input.nextDouble();
			System.out.print("英语成绩：");
			double english =  input.nextDouble();
			Student Current = new Student(id,name,computer,math,english);
			students[i-1]=Current;
		}
		this.studentClass = new StudentClass(5,students);
		System.out.println("初始化学生信息如下：");
		this.studentClass.PrintStudent();
	}
	
	/**
	 * 将学生信息写入Excel文件
	 * @param student
	 */
	public void CreateExcel(Student[] student) {
		try {
			WritableWorkbook book = Workbook.createWorkbook(new File("D:\\class.xls"));
            WritableSheet sheet = book.createSheet("sheet1", 0);  
            Label label = new Label(0, 0, "学号");
            sheet.addCell(label);
            label = new Label(1, 0, "姓名");  
            sheet.addCell(label);
            label = new Label(2, 0, "计算机");  
            sheet.addCell(label);
            label = new Label(3, 0, "数学");  
            sheet.addCell(label);
            label = new Label(4, 0, "英语");  
            sheet.addCell(label);
            label = new Label(5, 0, "总分");  
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
			System.out.println("初始学生信息已经写入D盘下的“class.xls”文件");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println(e);
		}
	}
}
