package kr.or.ddit.prod.dao;
 import java.util.List;
 import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
 import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.prod.model.ProdVO;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;
 public class ProdDao implements ProdDaoInf{
 	@Override
	public List<ProdVO> selectProdPageList(PageVO pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<ProdVO> pageList = session.selectList("prod.selectProdPageList", pageVo);
		session.close();
		
		return pageList;
	}
 	@Override
	public int getProdCnt() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int totalProdCnt = session.selectOne("prod.getProdCnt");
		session.close();
		
		return totalProdCnt;
	}
 	@Override
	public ProdVO selectProdDetail(String prod_id) {
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		ProdVO prodVo = session.selectOne("prod.selectProdDetail", prod_id);
		
		session.close();
		
		return prodVo;
	}
 }