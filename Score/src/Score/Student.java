package Score;

public class Student {

	private String Id;
	private String Name;
	private double Total;
	private double Computer;
	private double Math;
	private double English;
	
	public Student() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Student(String id, String name) {
		super();
		Id = id;
		Name = name;
	}
	public Student(String id, String name, double computer, double math, double english) {
		super();
		Id = id;
		Name = name;
		Computer = computer;
		Math = math;
		English = english;
		Total = computer+math+english;
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getTotal() {
		return Total;
	}
	public void setTotal(double total) {
		Total = total;
	}
	public double getComputer() {
		return Computer;
	}
	public void setComputer(double computer) {
		Computer = computer;
	}
	public double getMath() {
		return Math;
	}
	public void setMath(double math) {
		Math = math;
	}
	public double getEnglish() {
		return English;
	}
	public void setEnglish(double english) {
		English = english;
	}
	
}
