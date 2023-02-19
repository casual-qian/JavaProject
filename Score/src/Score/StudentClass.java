package Score;

import java.util.Arrays;

public class StudentClass {

	private int num;
	private Student[] student;
	
	public StudentClass() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public StudentClass(int num, Student[] student) {
		super();
		this.num = num;
		this.student = student;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Student[] getStudent() {
		return student;
	}

	public void setStudent(Student[] student) {
		this.student = student;
	}

	/**
	 * 查询学生是否在班级中
	 * @param name
	 * @return
	 */
	public boolean find(String name) {
		for(int i=0;i<num;i++) {
			if(name.equals(student[i].getName()))
				return true;
		}
		return false;
	}
	
	/**
	 * 添加学生
	 * @param student
	 */
	public void add(Student student) {
		Student[] newClass = new Student[this.num+1];
		newClass = Arrays.copyOfRange(this.student, 0, this.num+1);
		newClass[num] = student;
		this.setNum(this.num+1);
		this.setStudent(newClass);
	}
	
	/**
	 * 删除学生
	 * @param name
	 */
	public void del(String name) {
		if(!this.find(name)) {
			System.out.println("该学生不存在！");
			return;
		}
		Student[] newClass = new Student[this.num-1];
		for(int i=0,j=0;i<this.num-1;i++) {
			if(this.student[i].getName()!=name) {
				newClass[j]=student[i];
				j++;
			}
		}
		this.setNum(this.num-1);
		this.setStudent(newClass);
	}
	
	/**
	 * 打印学生名单
	 */
	public void PrintStudent() {
		System.out.println("学号\t姓名\t计算机\t数学\t英语\t总分");
		for(int i=0;i<this.num;i++) {
			System.out.println(student[i].getId()+"\t"+student[i].getName()+"\t"+student[i].getComputer()+"\t"+student[i].getMath()+"\t"+student[i].getEnglish()+"\t"+student[i].getTotal());
		}
		System.out.println("");
	} 
	
	/**
	 * 按总成绩排序
	 */
	public void OrderByTotal() {
		for(int i=0;i<this.num-1;i++) {
			for(int j=i+1;j<this.num;j++) {
				if(this.student[j].getTotal()>this.student[i].getTotal()) {
					Student temp = student[i];
					student[i]=student[j];
					student[j]=temp;
				}
			}
		}
		System.out.println("按总成绩排序");
		this.PrintStudent();
	}
	
	/**
	 * 按计算机成绩排序
	 */
	public void OrderByComputer() {
		for(int i=0;i<this.num-1;i++) {
			for(int j=i+1;j<this.num;j++) {
				if(this.student[j].getComputer()>this.student[i].getComputer()) {
					Student temp = student[i];
					student[i]=student[j];
					student[j]=temp;
				}
			}
		}
		System.out.println("按计算机成绩排序");
		this.PrintStudent();
	}
	
	/**
	 * 按数学成绩排序
	 */
	public void OrderByMath() {
		for(int i=0;i<this.num-1;i++) {
			for(int j=i+1;j<this.num;j++) {
				if(this.student[j].getMath()>this.student[i].getMath()) {
					Student temp = student[i];
					student[i]=student[j];
					student[j]=temp;
				}
			}
		}
		System.out.println("按数学成绩排序");
		this.PrintStudent();
	}
	
	/**
	 * 按英语成绩排序
	 */
	public void OrderByEnglish() {
		for(int i=0;i<this.num-1;i++) {
			for(int j=i+1;j<this.num;j++) {
				if(this.student[j].getEnglish()>this.student[i].getEnglish()) {
					Student temp = student[i];
					student[i]=student[j];
					student[j]=temp;
				}
			}
		}
		System.out.println("按英语成绩排序");
		this.PrintStudent();
	}
}
