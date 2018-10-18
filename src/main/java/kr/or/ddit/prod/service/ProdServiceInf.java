package kr.or.ddit.prod.service;
 import java.util.Map;
 import kr.or.ddit.prod.model.ProdVO;
import kr.or.ddit.util.model.PageVO;
 public interface ProdServiceInf {
	
	public Map<String, Object> selectProdPageList(PageVO pageVo);
	
	public int getProdCnt();
	
	public ProdVO selectProdDetail(String prod_id);
}