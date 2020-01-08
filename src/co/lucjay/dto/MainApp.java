package co.lucjay.dto;

import co.lucjay.dao.EmployeeDao;

public class MainApp {
	public static void main(String[] args) {
//		EmployeeDao dao = new EmployeeDao();
//		dao.select();
		JobDisplay js = new JobDisplay();
		js.allSelectDisplay();
	}
}
