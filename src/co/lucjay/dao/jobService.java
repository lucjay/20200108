package co.lucjay.dao;

import java.util.List;

import co.lucjay.dto.JobDto;

public interface jobService {
	public List<JobDto> selectAll() throws Exception; // 전체테이블 목록

	public JobDto select(JobDto dto) throws Exception; // 특정한 한레코드

	public int update(JobDto dto) throws Exception;// 레코드 갱신

	public int delete(JobDto dto) throws Exception;// 레코드 삭제

	public int insert(JobDto dto) throws Exception;// 레코드 추가
}
