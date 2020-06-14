package egovframework.pra.cmm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.pra.cmm.service.HeadMenuVO;
import egovframework.pra.cmm.service.MenuManageService;
import egovframework.pra.cmm.service.MenuManageVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("MenuManageService")
public class MenuManageServiceImpl extends EgovAbstractServiceImpl implements MenuManageService {

	@Resource(name="menuManageDAO")
	MenuManageDAO menuManageDAO;
	
	@Override
	public List<HeadMenuVO> selectMainMenuHead(MenuManageVO menuManageVO) throws Exception {
		// TODO Auto-generated method stub
		
		
		return menuManageDAO.selectMenuHead(menuManageVO);
	}
	
	@Override
	public HeadMenuVO selectMainMenuHead(String menuNo) throws Exception{
		return menuManageDAO.selectMenuHead(menuNo);
	}
	
	@Override
	public String[] passUrlParam(String menuNo) throws Exception {
		HeadMenuVO menuVO=this.selectMainMenuHead(menuNo);
		String[] paramList={};
		if(menuVO.getMenuParam()!=null)
		{
			paramList=menuVO.getMenuParam().split(";");
		}
		
		return paramList;
		
	}
}
