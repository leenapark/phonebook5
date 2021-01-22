package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	@Autowired
	private SqlSession sqlSession;

	// 전제 리스트 가져오기
	public List<PersonVo> getList() {
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList2"); // xml 에서 작성한 쿼리문 이름을 ""에 넣는다 ->
																					// "이름"
		System.out.println(personList.toString());
		return personList;
	}

	// 데이터 한 개 가져오기
	public PersonVo getPerson(int personId) {
		System.out.println("dao getPerson: " + personId);
		
		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", personId);
		System.out.println("dao personVo: " + personId);

		return personVo;
	}

	// 전화번호 저장
	public void personInsert(PersonVo personVo) {
		System.out.println("dao insert: " + personVo.toString());

		sqlSession.insert("phonebook.insert", personVo);
	}

	// 전화번호 삭제
	public void personDelete(int personId) {
		System.out.println("dao int: " + personId);

		sqlSession.delete("phonebook.delete", personId);

	}
	
	// 전화 번호 수정
	public void personUpdate(PersonVo personVo) {
		
		System.out.println("dao personVo: " + personVo);
		
		sqlSession.update("phonebook.update", personVo);
	}
	

}
