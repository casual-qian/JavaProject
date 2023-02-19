package Score;

import java.util.Arrays;

public class StudentClass {

	private int num;
	private Student[] student;
	
	public StudentClass() {
		super();
		// TODO �Զ����ɵĹ��캯�����
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
	 * ��ѯѧ���Ƿ��ڰ༶��
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
	 * ���ѧ��
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
	 * ɾ��ѧ��
	 * @param name
	 */
	public void del(String name) {
		if(!this.find(name)) {
			System.out.println("��ѧ�������ڣ�");
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
	 * ��ӡѧ������
	 */
	public void PrintStudent() {
		System.out.println("ѧ��\t����\t�����\t��ѧ\tӢ��\t�ܷ�");
		for(int i=0;i<this.num;i++) {
			System.out.println(student[i].getId()+"\t"+student[i].getName()+"\t"+student[i].getComputer()+"\t"+student[i].getMath()+"\t"+student[i].getEnglish()+"\t"+student[i].getTotal());
		}
		System.out.println("");
	} 
	
	/**
	 * ���ܳɼ�����
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
		System.out.println("���ܳɼ�����");
		this.PrintStudent();
	}
	
	/**
	 * ��������ɼ�����
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
		System.out.println("��������ɼ�����");
		this.PrintStudent();
	}
	
	/**
	 * ����ѧ�ɼ�����
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
		System.out.println("����ѧ�ɼ�����");
		this.PrintStudent();
	}
	
	/**
	 * ��Ӣ��ɼ�����
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
		System.out.println("��Ӣ��ɼ�����");
		this.PrintStudent();
	}
}
