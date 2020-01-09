package co.lucjay.hr.employees;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDisplay {

	public void allSelectList() {
		EmployeeServiceImpl emp = new EmployeeServiceImpl();
		List<EmployeeDto> list = new ArrayList<EmployeeDto>();
		try {
			list = emp.allSelect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (EmployeeDto dto : list)
			dto.toString();
	}

	public void employeeInsert() {
		EmployeeServiceImpl emp = new EmployeeServiceImpl();
		EmployeeDto dto = new EmployeeDto();
		dto.setEmployee_id(222);
		dto.setFirst_name("승리");
		dto.setLast_name("박");
		dto.setEmail("Park");
		dto.setPhone_number("010.0000.0000");
		dto.setHire_date(Date.valueOf("2020-01-10"));
		dto.setJob_id("AD_PRES");
		dto.setSalary(150000);
		dto.setCommission_pct(0);
		dto.setManager_id(100);
		dto.setDepartment_id(60);
		try {
			int n = emp.insert(dto);
			if (n != 0)
				System.out.println("정상적으로 입력됐졍~~~~~~~~~~~~~~~");
			else
				System.out.println("입력 실패 됐어ㅓㅓㅓㅓㅓㅓ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchSelect() {
		EmployeeServiceImpl emp = new EmployeeServiceImpl();
		EmployeeDto dto = new EmployeeDto();
		Scanner sc = new Scanner(System.in);
		System.out.println("검색 할 사용자 ID(숫자)를 입력행");
		int key = sc.nextInt(); // 키보드에서 입력한 id를 저장
		try {
			dto = emp.select(key);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.toString();
		sc.close();
	}

	public void empDelete() {
		EmployeeServiceImpl emp = new EmployeeServiceImpl();
		EmployeeDto dto = new EmployeeDto();
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제 할 사용자 입력행");
		dto.setEmployee_id(sc.nextInt());
		try {
			int n = emp.delete(dto);
			if (n != 0)
				System.out.println("정상적으로 삭제 됨");
			else
				System.out.println("삭제 안됐졍");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
		allSelectList(); // 삭제 후 전체 리스트를 보여준다.
	}

	public void update() {
		EmployeeServiceImpl emp = new EmployeeServiceImpl();
		EmployeeDto dto = new EmployeeDto();
		Scanner sc = new Scanner(System.in);
		System.out.println("업뎃할사용자 아이디 숫자로 입력해바");
		int key = sc.nextInt();
		try {
			dto = emp.select(key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dto.toString();
		sc.nextLine();
		System.out.println("변경 할 Frist name을 입력해");
		dto.setFirst_name(sc.nextLine());
		try {
			int n = emp.update(dto);
			if (n != 0)
				System.out.println("정삭적으로 변경됐져~~~");
			else
				System.out.println("변경 안됐눈뎅~~~~~");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
		allSelectList(); // 변경 후 전체 리스트를 보여줌
	}
}
