package kr.or.ddit.prod.dao;
 import java.util.List;

import kr.or.ddit.prod.model.ProdVO;
import kr.or.ddit.util.model.PageVO;

public interface ProdDaoInf {
 	public List<ProdVO> selectProdPageList(PageVO pageVo);
	
	public int getProdCnt();
	
	public ProdVO selectProdDetail(String prod_id);
	
}