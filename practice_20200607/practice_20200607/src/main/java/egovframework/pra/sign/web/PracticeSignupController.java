package egovframework.pra.sign.web;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.uss.umt.service.EgovMberManageService;
import egovframework.com.uss.umt.service.MberManageVO;
import egovframework.com.uss.umt.service.UserDefaultVO;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class PracticeSignupController {
	
	
	/** mberManageService */
	@Resource(name = "mberManageService")
	private EgovMberManageService mberManageService;

	/** cmmUseService */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** DefaultBeanValidator beanValidator */
	@Autowired
	private DefaultBeanValidator beanValidator;
	/**
	 * 일반회원등록화면으로 이동한다.
	 * @param userSearchVO 검색조건정보
	 * @param mberManageVO 일반회원초기화정보
	 * @param model 화면모델
	 * @return uss/umt/EgovMberInsert
	 * @throws Exception
	 */
	@RequestMapping("/sign/signup.do")
	public String insertMberView(@ModelAttribute("userSearchVO") UserDefaultVO userSearchVO, @ModelAttribute("mberManageVO") MberManageVO mberManageVO, Model model)
			throws Exception {

		// 미인증 사용자에 대한 보안처리
		/*Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
		if (!isAuthenticated) {
			return "index";
		}*/

		ComDefaultCodeVO vo = new ComDefaultCodeVO();

		//패스워드힌트목록을 코드정보로부터 조회
		vo.setCodeId("COM022");
		List<?> passwordHint_result = cmmUseService.selectCmmCodeDetail(vo);
		//성별구분코드를 코드정보로부터 조회
		vo.setCodeId("COM014");
		List<?> sexdstnCode_result = cmmUseService.selectCmmCodeDetail(vo);
		//사용자상태코드를 코드정보로부터 조회
		vo.setCodeId("COM013");
		List<?> mberSttus_result = cmmUseService.selectCmmCodeDetail(vo);
		//그룹정보를 조회 - GROUP_ID정보
		vo.setTableNm("COMTNORGNZTINFO");
		List<?> groupId_result = cmmUseService.selectGroupIdDetail(vo);

		model.addAttribute("passwordHint_result", passwordHint_result); //패스워트힌트목록
		model.addAttribute("sexdstnCode_result", sexdstnCode_result); //성별구분코드목록
		model.addAttribute("mberSttus_result", mberSttus_result); //사용자상태코드목록
		model.addAttribute("groupId_result", groupId_result); //그룹정보 목록

		return "egovframework/pra/sign/EgovMberInsert";
	}
	
	/**
	 * 일반회원등록처리후 목록화면으로 이동한다.
	 * @param mberManageVO 일반회원등록정보
	 * @param bindingResult 입력값검증용 bindingResult
	 * @param model 화면모델
	 * @return forward:/uss/umt/EgovMberManage.do
	 * @throws Exception
	 */
	@RequestMapping("/sign/actionSignup.do")
	public String insertMber(@ModelAttribute("entrprsManageVO") MberManageVO mberManageVO, BindingResult bindingResult, Model model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
		if (!isAuthenticated) {
			return "index";
		}

		beanValidator.validate(mberManageVO, bindingResult);
		if (bindingResult.hasErrors()) {
			return "egovframework/pra/sign/EgovMberInsert";
		} else {
			if ("".equals(mberManageVO.getGroupId())) {//KISA 보안약점 조치 (2018-10-29, 윤창원)
				mberManageVO.setGroupId(null);
			}
			mberManageService.insertMber(mberManageVO);
			//Exception 없이 진행시 등록 성공메시지
			model.addAttribute("resultMsg", "success.common.insert");
		}
		return "forward:/index.do1";
	}
}
