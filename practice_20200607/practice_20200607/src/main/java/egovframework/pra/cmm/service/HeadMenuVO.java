package egovframework.pra.cmm.service;

import java.io.Serializable;

public class HeadMenuVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2984848547037099934L;
	private String menuNo;
	private String menuNm;
	private String chkURL;
	private String menuParam;
	private String userSe;
	private String gourpId;
	public String getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	
	public String getChkURL() {
		return chkURL;
	}
	public void setChkURL(String chkURL) {
		this.chkURL = chkURL;
	}
	public String getMenuParam() {
		return menuParam;
	}
	public void setMenuParam(String menuParam) {
		this.menuParam = menuParam;
	}
	public String getUserSe() {
		return userSe;
	}
	public void setUserSe(String userSe) {
		this.userSe = userSe;
	}
	public String getGourpId() {
		return gourpId;
	}
	public void setGourpId(String gourpId) {
		this.gourpId = gourpId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "HeadMenuVO [menuNo=" + menuNo + ", menuNm=" + menuNm + ", chkUrl=" + chkURL + ", menuParam=" + menuParam
				+ ", userSe=" + userSe + ", gourpId=" + gourpId + "]";
	}
	
}
