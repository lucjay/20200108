package co.lucjay.dto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.lucjay.dao.DAO;
import co.lucjay.dao.jobService;

public class jobServiceImpl extends DAO implements jobService {
	private PreparedStatement psmt;
	private ResultSet rs;
	private List<JobDto> list;
	private JobDto dto;

	private final String ALL_JOBS = "select * from jobs";

	@Override
	public List<co.lucjay.dto.JobDto> selectAll() throws Exception {
		list = new ArrayList<JobDto>();
		psmt = conn.prepareStatement(ALL_JOBS);
		rs = psmt.executeQuery();
		while (rs.next()) {
			dto = new JobDto();
			dto.setJob_id(rs.getString("job_id"));
			dto.setJob_title(rs.getString("job_title"));
			dto.setMax_salary(rs.getInt("max_salary"));
			dto.setMin_salary(rs.getInt("min_salary"));
			list.add(dto);
		}
		return list;
	}

	@Override
	public int update(co.lucjay.dto.JobDto dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(co.lucjay.dto.JobDto dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(co.lucjay.dto.JobDto dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public JobDto select(JobDto dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
