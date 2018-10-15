package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest {
	
	// junit 실행주기
	// @BeforeClass 이 적용된 메소드 실행(최초 1회), 단 static 메소드로 선언
	// @Before 어노테이션이 적용된 메소드 실행(테스트 메소드 실행전 실행) 
	// @Test
	// @After 어노테이션이 적용된 메소드 실행(테스트 메소드 실행후 실행)
	// @AfterClass 어노테이션이 적용된 메소드  실행(최초 1회), 단 static 메소드로 선언
	
	
	//beforeClass 
	//before --> selectUserAll --> after 
	//before --> selectUserTest --> after
	//before --> selectUserByVoTest --> after
	//afterClass
	
	
	private UserServiceInf userService;
	private final String TEST_USER_ID = "testUserId1";
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass");
	}
	
	@Before
	public void before(){
		userService = new UserService();
		userService.deleteUser(TEST_USER_ID);
		System.out.println("before");
	}
	
	@After
	public void after(){
		System.out.println("after");
	}
	
	@Test
	public void selectUserAllTest() {
		/***Given***/
		
		/***When***/
		List<UserVO> list = userService.selectUserAll();
		/***Then***/
		
		assertEquals(105,list.size());
	}
	
	@Test
	public void selectUserTest(){
		/***Given***/
		
		/***When***/
//		List<UserVO> userList = userDao.selectUserAll();
		
		UserVO userVo = userService.selectUser("brown");
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
		
		
		UserVO userVo2 = userService.selectUser(userVo);
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
		
		Map<String,Object> resultMap = userService.selectUserPageList(pageVo);
		List<UserVO> pageUser = (List<UserVO>) resultMap.get("userList");
		
		int pageCnt = (Integer) resultMap.get("pageCnt");
		
		/***Then***/
		assertEquals(10,pageUser.size());
		assertEquals(11, pageCnt);
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
		int result = userService.insertUser(userVo);
		/***Then***/
		assertEquals(1, result);
		
	}
}
