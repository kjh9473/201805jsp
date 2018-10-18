package kr.or.ddit.prod.service;
 import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.dao.ProdDaoInf;
import kr.or.ddit.prod.model.ProdVO;
import kr.or.ddit.util.model.PageVO;
 public class ProdService implements ProdServiceInf{
 	private ProdDaoInf prodDao = new ProdDao();
	
 	@Override
 	public Map<String, Object> selectProdPageList(PageVO pageVo) {
 		List<ProdVO> prodList = prodDao.selectProdPageList(pageVo); 
 		
 		int totalProdCnt = prodDao.getProdCnt();
 		int pageCnt = (int)Math.ceil(((double)totalProdCnt/pageVo.getPageSize()));
 		
 		Map<String, Object> resultMap = new HashMap<String, Object>();
 		resultMap.put("prodList", prodList);
 		resultMap.put("pageCnt", pageCnt);
 		
 		return resultMap;
 	}
	
 	@Override
	public int getProdCnt() {
		return prodDao.getProdCnt();
	}
 	
 	@Override
	public ProdVO selectProdDetail(String prod_id) {
		return prodDao.selectProdDetail(prod_id);
	}
 	
 }