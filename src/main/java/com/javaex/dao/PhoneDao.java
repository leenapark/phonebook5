package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList"); // xml 에서 작성한 쿼리문 이름을 ""에 넣는다 ->
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

	public Map<String, Object> getPerson2(int personId) {
		System.out.println("dao getPerson2: " + personId);

		Map<String, Object> personMap = sqlSession.selectOne("phonebook.selectOne2", personId);
		System.out.println(personMap.toString());
		/*
		int id = Integer.parseInt(String.valueOf(personMap.get("PERSONID")));
		System.out.println(id);
		String name = (String)personMap.get("NAME");
		System.out.println(name);
		*/
		return personMap;
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
	/*
	 * public void personUpdate(PersonVo personVo) {
	 * 
	 * System.out.println("dao personVo: " + personVo);
	 * 
	 * 
	 * sqlSession.update("phonebook.update", personVo); }
	 */
	
	// 전화 번호 수정 - vo 대신 map 사용 할 때 = 
		public int personUpdate(int personId, String name, String hp, String company) {
			
			System.out.println("dao personUpdate: " + personId + ", " + name + ", " + hp + ", " + company);
			
			// vo 대신 map 사용
			Map<String, Object> personMap = new HashMap<String, Object>();
			personMap.put("id", personId);
			personMap.put("name", name);
			personMap.put("hp", hp);
			personMap.put("company", company);
			
			
			int count = sqlSession.update("phonebook.update2", personMap);
			
			return count;
			
		}
	
	// 전화 번호 수정 2
	public int personUpdate2(PersonVo personVo) {
		
		System.out.println("dao personVo: " + personVo);
		
		int count = sqlSession.update("phonebook.update", personVo);
		
		return count;
	}
	
	

}
