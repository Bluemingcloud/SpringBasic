package com.simple.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.basic.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class) // junit을 스프링 테스트 코드로 실행시킴
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") // 내가 동작시킬 스프링 설정파일(ex root-context.xml)의 경로를 입력
public class JdbcTest { // 서버를 켜지 않은 상태로 Main 메서드 처럼 동작
	
	// 커넥션 풀 DB 연결(DataSource : DB 관련된 정보 저장 객체)
	//@Autowired
	//@Qualifier("ds")
	//private DataSource ds; // root-context.xml에 선언되어 있는 DataSource 객체(bean)
	
	@Autowired
	@Qualifier("sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	TestMapper testMapper;
	
//	@Test // test코드로 동작할 메서드에 붙여준다.
//	public void testCode01() {
//		try {
//			Connection conn = ds.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement("SELECT SYSDATE AS time FROM DUAL");
//			ResultSet rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				System.out.println(rs.getString("time"));
//			}
//			
//			conn.close();
//			pstmt.close();
//			rs.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			
//		}
//	}
	
	@Test
	public void testCode02() {
		
		//System.out.println(sqlsessionFactory);
		//SqlSession sql = sqlSessionFactory.openSession(true);
		
		String time = testMapper.getTime();
		System.out.println(time);
		
	}

}
