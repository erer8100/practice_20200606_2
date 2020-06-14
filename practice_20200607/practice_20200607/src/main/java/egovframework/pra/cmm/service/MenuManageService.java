package egovframework.pra.cmm.service;

import java.util.List;

public interface MenuManageService {
	public List<HeadMenuVO> selectMainMenuHead(MenuManageVO menuManageVO) throws Exception;
	public HeadMenuVO selectMainMenuHead(String menuNo) throws Exception;
	public String[] passUrlParam(String menuNo) throws Exception;
}
