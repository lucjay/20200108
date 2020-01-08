package co.lucjay.dto;

//Dto=table 1:1 관계, 테이블컬럼 그대로 
public class JobDto { // jobs table
	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;

	public JobDto() {
	}

	public String getJob_id() {
		return job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public int getMin_salary() {
		return min_salary;
	}

	public int getMax_salary() {
		return max_salary;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public void setMin_salary(int min_salary) {
		this.min_salary = min_salary;
	}

	public void setMax_salary(int max_salary) {
		this.max_salary = max_salary;
	}

	public String toString() { // 일반적인 DTO Class는 이 메소드를 생성하지 않음(투스트링메소드를 오버라이딩안함)
		System.out.print(job_id + " ");
		System.out.print(job_title + " ");
		System.out.print(min_salary + " ");
		System.out.println(max_salary);
		return null;
	}
}
