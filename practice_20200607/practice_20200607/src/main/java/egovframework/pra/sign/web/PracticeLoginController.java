package egovframework.pra.sign.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.EgovComponentChecker;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.uat.uia.service.EgovLoginService;
import egovframework.com.uat.uia.web.EgovLoginController;

@Controller
public class PracticeLoginController {
	
	
	/** EgovLoginService */
	@Resource(name = "loginService")
	private EgovLoginService loginService;

	/** EgovCmmUseService */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/** log */
	private static final Logger LOGGER = LoggerFactory.getLogger(PracticeLoginController.class);
	
	@RequestMapping(value = "/sign/login.do")
	public String loginUsrView(@ModelAttribute("loginVO") LoginVO loginVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		if (EgovComponentChecker.hasComponent("mberManageService")) {
			model.addAttribute("useMemberManage", "true");
		}

		/*
		GPKIHttpServletResponse gpkiresponse = null;
		GPKIHttpServletRequest gpkirequest = null;

		try{

			gpkiresponse=new GPKIHttpServletResponse(response);
		    gpkirequest= new GPKIHttpServletRequest(request);
		    gpkiresponse.setRequest(gpkirequest);
		    model.addAttribute("challenge", gpkiresponse.getChallenge());
		    return "egovframework/com/uat/uia/EgovLoginUsr";

		}catch(Exception e){
		    return "egovframework/com/cmm/egovError";
		}
		*/
		return "egovframework/pra/sign/EgovLoginUsr";
	}
	
	/**
	 * 일반(세션) 로그인을 처리한다
	 * @param vo - 아이디, 비밀번호가 담긴 LoginVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 로그인결과(세션정보)
	 * @exception Exception
	 */
	@RequestMapping(value = "/sign/actionLogin.do")
	public String actionLogin(@ModelAttribute("loginVO") LoginVO loginVO, HttpServletRequest request, ModelMap model) throws Exception {

		// 1. 일반 로그인 처리
		LoginVO resultVO = loginService.actionLogin(loginVO);

		if (resultVO != null && resultVO.getId() != null && !resultVO.getId().equals("")) {

			// 2-1. 로그인 정보를 세션에 저장
			request.getSession().setAttribute("loginVO", resultVO);

			return "redirect:/content.do";

		} else {
			model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
			return "egovframework/pra/sign/EgovLoginUsr";
		}
	}
}
