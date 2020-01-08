package co.lucjay.dto;

import java.util.ArrayList;
import java.util.List;

public class JobDisplay {
//	jobServiceImpl job; 추후 spring framework사용시 interface 객체를 호출 사용함
	private List<JobDto> list;

	public void allSelectDisplay() { // 전체리스트를 보여주는 메소드
		jobServiceImpl jobs = new jobServiceImpl();
		list = new ArrayList<JobDto>();
		try {
			list = jobs.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (JobDto dto : list) {
			System.out.print(dto.getJob_id() + " | ");
			System.out.print(dto.getJob_title() + " | ");
			System.out.print(dto.getMax_salary() + " | ");
			System.out.println(dto.getMin_salary() + " | ");
		}
	}
}
