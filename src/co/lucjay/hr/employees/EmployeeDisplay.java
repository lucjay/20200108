package co.lucjay.hr.employees;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

}
