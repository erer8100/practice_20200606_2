package egovframework.pra.cmm.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.pra.cmm.service.HeadMenuVO;
import egovframework.pra.cmm.service.MenuManageVO;

@Repository("menuManageDAO")
public class MenuManageDAO extends EgovComAbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<HeadMenuVO> selectMenuHead(MenuManageVO menuManageVO) throws Exception{
		return (List<HeadMenuVO>) this.list("menuManageDAO.selectMenuHeadByVO", menuManageVO);
	}
	
	
	public HeadMenuVO selectMenuHead(String menuNo) throws Exception{
		return (HeadMenuVO) this.select("menuManageDAO.selectMenuHeadByNo", menuNo);
	}
}
