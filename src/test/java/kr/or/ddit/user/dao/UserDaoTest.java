package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
	
	private UserDaoInf userDao;
	private final String TEST_USER_ID = "testUserId1";
	
	@Before
	public void setup(){
		userDao = new UserDao();
		userDao.deleteUser(TEST_USER_ID);
	}

	@Test
	public void selectUserAllTest() {
		/***Given***/
		
		/***When***/
		List<UserVO> userList = userDao.selectUserAll();
		
		System.out.println("List : " + userList);
		
		/***Then***/
		assertEquals(105,userList.size());
		
	}
	@Test
	public void selectUserTest(){
		/***Given***/
		
		/***When***/
//		List<UserVO> userList = userDao.selectUserAll();
		
		UserVO userVo = userDao.selectUser("brown");
		System.out.println("String : " + userVo);
		
		/***Then***/
		assertEquals("브라운",userVo.getName());
		assertEquals("brown", userVo.getUserId());
	}
	
	@Test
	public void selectUserByVoTest(){
		
		/***Given***/
		
		/***When***/
		UserVO userVo = new UserVO();
		userVo.setUserId("brown");
		
		
		UserVO userVo2 = userDao.selectUser(userVo);
		System.out.println("UserVO : "+ userVo2);
		
		/***Then***/
		assertNotNull(userVo2);
		assertEquals("브라운",userVo2.getName());
		assertEquals("brown", userVo2.getUserId());
	}
	
	@Test
	public void selectUserPageListTest(){
		
		/***Given***/
		
		/***When***/
		PageVO pageVo = new PageVO();
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		
		
		List<UserVO> pageUser = userDao.selectUserPageList(pageVo);
		System.out.println("pageUser : "+ pageUser);
		
		/***Then***/
		assertEquals(10,pageUser.size());
	}
	
	/**
	* Method : totalUserCntTest
	* 작성자 : pc25
	* 변경이력 :
	* Method 설명 : 사용자 전체 건수 조회 테스트
	*/
	@Test
	public void totalUserCntTest(){
		/***Given***/
		
		/***When***/
		int totalUserCnt = userDao.getUserCnt();
		
		/***Then***/
		
		assertEquals(105,totalUserCnt);
	}
	
	@Test
	public void insertUserTest(){
		/***Given***/
		//userVo 객체 생성
		UserVO userVo = new UserVO();
		userVo.setUserId(TEST_USER_ID);
		userVo.setPass("pass1234");
		userVo.setName("user");
		userVo.setAddr1("대전식 중구 대흥동 76");
		userVo.setAddr2("2층 대덕인재개발원");
		userVo.setZipcd("34940");
		String date = "18/08/08";
		DateFormat format = new SimpleDateFormat("yy/MM/dd");
		Date date1;
		try {
			date1 = format.parse(date);
			userVo.setBirth(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userVo.setEmail("user@gmail.com");
		userVo.setTel("0422228202");
		
		/***When***/
		//userDao.insertUser()
		int result = userDao.insertUser(userVo);
		/***Then***/
		assertEquals(1, result);
		
	}
	
	@Test
	public void deleteUserTest(){
		/***Given***/
		String userId = TEST_USER_ID;
		
		/***When***/
		int result = userDao.deleteUser(userId);
		
		/***Then***/
		assertEquals(1,result);
		
	};
	
	@Test
	public void updateUserTest(){
		/***Given***/
		//userVo 객체 생성
				UserVO userVo = new UserVO();
				userVo.setUserId("newUser02");
				userVo.setPass("길동");
				userVo.setName("홍길");
				userVo.setAddr1("대전식 중구 대흥동 76");
				userVo.setAddr2("2층 대덕인재개발원");
				userVo.setZipcd("34940");
				String date = "18/08/08";
				DateFormat format = new SimpleDateFormat("yy/MM/dd");
				Date date1;
				try {
					date1 = format.parse(date);
					userVo.setBirth(date1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				userVo.setEmail("user@gmail.com");
				userVo.setTel("0422228202");
				userVo.setProfile("??");
		/***When***/
		int result = userDao.updateUser(userVo);
		/***Then***/
		assertEquals(1, result);
	}
	
}
