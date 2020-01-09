package co.lucjay.hr.employees;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl extends DAO implements EmployeeService {
	private PreparedStatement psmt;
	private ResultSet rs;
	private List<EmployeeDto> list;

	// DBsql
	private final String ALL_SELECT = "select * from employees";
	private final String EMP_INSERT = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
	private final String SEARCH_SELECT = "select * from employees where employee_id = ?";
	private final String EMP_DELETE = "delete from employees where employee_id = ?"; // app에서 삭제하면 자동커밋(오토커밋)
	private final String EMP_UPDATE = "update employees set first_name=?,last_name=?,email=?,phone_number=?,hire_date=?,job_id=?,salary=?,commission_pct=?,manager_id=?,department_id=? where employee_id = ?";

	@Override
	public List<EmployeeDto> allSelect() throws SQLException {
		EmployeeDto dto;
		list = new ArrayList<EmployeeDto>();
		psmt = conn.prepareStatement(ALL_SELECT);
		rs = psmt.executeQuery();
		while (rs.next()) {
			dto = new EmployeeDto();
			dto.setEmployee_id(rs.getInt("employee_id"));
			dto.setFirst_name(rs.getString("first_name"));
			dto.setLast_name(rs.getString("last_name"));
			dto.setEmail(rs.getString("email"));
			dto.setPhone_number(rs.getString("phone_number"));
			dto.setHire_date(rs.getDate("hire_date"));
			dto.setJob_id(rs.getString("job_id"));
			dto.setSalary(rs.getFloat("salary"));
			dto.setCommission_pct(rs.getFloat("commission_pct"));
			dto.setManager_id(rs.getInt("manager_id"));
			dto.setDepartment_id(rs.getInt("department_id"));
			list.add(dto);
		}
		return list;
	}

	@Override
	public EmployeeDto select(int key) throws SQLException { // 특정하나를가져오는레코드
		EmployeeDto dto = new EmployeeDto();
		psmt = conn.prepareStatement(SEARCH_SELECT);
		psmt.setInt(1, key);
		rs = psmt.executeQuery();
		if (rs.next()) { // 검색 하나일때 if
			dto.setEmployee_id(rs.getInt("employee_id"));
			dto.setFirst_name(rs.getString("First_name"));
			dto.setLast_name(rs.getString("last_name"));
			dto.setEmail(rs.getString("email"));
			dto.setPhone_number(rs.getString("phone_number"));
			dto.setHire_date(rs.getDate("hire_date"));
			dto.setJob_id(rs.getString("job_id"));
			dto.setSalary(rs.getFloat("salary"));
			dto.setCommission_pct(rs.getFloat("commission_pct"));
			dto.setManager_id(rs.getInt("manager_id"));
			dto.setDepartment_id(rs.getInt("department_id"));
		} else {
			System.out.println("존재하지 않는 레코드 입니다.");

		}
		return dto;

	}

	@Override
	public int insert(EmployeeDto dto) throws SQLException {
		psmt = conn.prepareStatement(EMP_INSERT);
		psmt.setInt(1, dto.getEmployee_id());
		psmt.setString(2, dto.getFirst_name());
		psmt.setString(3, dto.getLast_name());
		psmt.setString(4, dto.getEmail());
		psmt.setString(5, dto.getPhone_number());
		psmt.setDate(6, dto.getHire_date());
		psmt.setString(7, dto.getJob_id());
		psmt.setFloat(8, dto.getSalary());
		psmt.setFloat(9, dto.getCommission_pct());
		psmt.setInt(10, dto.getManager_id());
		psmt.setInt(11, dto.getDepartment_id());
		int n = psmt.executeUpdate();
		return n;
	}

	@Override
	public int update(EmployeeDto dto) throws SQLException {
		psmt = conn.prepareStatement(EMP_UPDATE);
		psmt.setString(1, dto.getFirst_name());
		psmt.setString(2, dto.getLast_name());
		psmt.setString(3, dto.getEmail());
		psmt.setString(4, dto.getPhone_number());
		psmt.setDate(5, dto.getHire_date());
		psmt.setString(6, dto.getJob_id());
		psmt.setFloat(7, dto.getSalary());
		psmt.setFloat(8, dto.getCommission_pct());
		psmt.setInt(9, dto.getManager_id());
		psmt.setInt(10, dto.getDepartment_id());
		psmt.setInt(11, dto.getEmployee_id());
		int n = psmt.executeUpdate();
		return n;
	}

	@Override
	public int delete(EmployeeDto dto) throws SQLException {
		psmt = conn.prepareStatement(EMP_DELETE);
		psmt.setInt(1, dto.getEmployee_id());
		int n = psmt.executeUpdate();
		return n;
	}

}
