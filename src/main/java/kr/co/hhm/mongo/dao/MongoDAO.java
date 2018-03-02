package kr.co.hhm.mongo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import kr.co.hhm.mongo.vo.MongoTestVO;

@Component
public class MongoDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void saveMongoData(MongoTestVO mongoTestVO) {
		mongoTemplate.save(mongoTestVO); 	//save를 이용해 저장하기
	}
	
	public MongoTestVO findMongoData(String key, String value) {
		//MongoTemplate 에서 조건을 검색하기 위해 Criteria 클래스를 사용
		Criteria criteria = new Criteria(key);
		criteria.is(value);	//일치하는 값을 찾기 위해 is 메소드 사용
		
		//쿼리 객체 작성
		Query query = new Query(criteria);
		
		//쿼리를 사용한 조회
		MongoTestVO vo = mongoTemplate.findOne(query, MongoTestVO.class);
		
		return vo;
		
	}
}
