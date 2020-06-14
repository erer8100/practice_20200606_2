package egovframework.pra.cmm.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.pra.cmm.service.HeadMenuVO;
import egovframework.pra.cmm.service.MenuManageService;
import egovframework.pra.cmm.service.MenuManageVO;

@Controller
public class PracticeComIndexController {

	/** log */
	private static final Logger LOGGER = LoggerFactory.getLogger(PracticeComIndexController.class);
	
	@Resource(name = "MenuManageService")
	private MenuManageService menuManageService;
	
	@RequestMapping({"/index.do", "/cmm/EgovMainMenuHome.do"})
	public String index(ModelMap model) throws Exception {
		
		
		
		return "egovframework/pra/EgovUnitMain";
	}
	
	
	@RequestMapping("/head.do")
	public String top(Model model) throws Exception{
		
		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
		MenuManageVO menuManageVO = new MenuManageVO();
		if (!isAuthenticated) {
			
			menuManageVO.setTmp_UserSe("anonym");
		} else {

			LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
			
			LOGGER.debug("User Id : {}", user.getId());
			LOGGER.debug("User Se : {}", user.getUserSe());

			menuManageVO.setTmp_Id(user.getId());
			menuManageVO.setTmp_UserSe(user.getUserSe());
			menuManageVO.setTmp_Name(user.getName());
			menuManageVO.setTmp_Email(user.getEmail());
			menuManageVO.setTmp_OrgnztId(user.getOrgnztId());
			menuManageVO.setTmp_UniqId(user.getUniqId());
		}
		
		List<HeadMenuVO> list_headmenu = menuManageService.selectMainMenuHead(menuManageVO);
		for(HeadMenuVO vo: list_headmenu)
		{
			LOGGER.debug("Head Menu : {}", vo.toString());
		}
		model.addAttribute("list_headmenu", list_headmenu);
		
		return "egovframework/pra/head";
	}
	
	@RequestMapping("/content.do")
	public String content() throws Exception{
		return "egovframework/pra/EgovMainView";
	}
	
	@RequestMapping("/bottom.do")
	public String bottom() throws Exception{
		return "egovframework/pra/main_bottom";
	}
	
	/**
	 * 로그아웃한다.
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping(value = "/cmm/actionLogout.do")
	public String actionLogout(HttpServletRequest request, ModelMap model) throws Exception {

		/*String userIp = EgovClntInfo.getClntIP(request);

		// 1. Security 연동
		return "redirect:/j_spring_security_logout";*/

		request.getSession().setAttribute("loginVO", null);

		//return "redirect:/egovDevIndex.jsp";
		return "redirect:/index.do";
	}
	
	@RequestMapping(value = "/cmm/EgovMainMenuIndex.do")
	public String EgovMainMenuIndex(HttpServletRequest request) throws Exception {

		/*String userIp = EgovClntInfo.getClntIP(request);

		// 1. Security 연동
		return "redirect:/j_spring_security_logout";*/

		String menuNo=request.getParameter("menuNo");
		String[] paramList = menuManageService.passUrlParam(menuNo);
		String paramPath="";
		
		for(int i=0; i<paramList.length; i++)
		{
			if(i!=paramList.length-1)
				paramPath+=paramList[i]+"&";
			else
				paramPath+=paramList[i];
		}
		String fullUrl=request.getParameter("chkURL")+"?"+paramPath;
		//return "redirect:/egovDevIndex.jsp";
		LOGGER.debug("fullUrl : {}", fullUrl);
		return "redirect:"+fullUrl;
	}
}
