package egovframework.pra.cmm.service;

import java.io.Serializable;

public class MenuManageVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3382743381467690351L;
	
	private String tmp_Id;
	private String tmp_UserSe;
	private String tmp_Name;
	private String tmp_Email;
	private String tmp_OrgnztId;
	private String tmp_UniqId;
	public String getTmp_Id() {
		return tmp_Id;
	}
	public void setTmp_Id(String tmp_Id) {
		this.tmp_Id = tmp_Id;
	}
	public String getTmp_UserSe() {
		return tmp_UserSe;
	}
	public void setTmp_UserSe(String tmp_UserSe) {
		this.tmp_UserSe = tmp_UserSe;
	}
	public String getTmp_Name() {
		return tmp_Name;
	}
	public void setTmp_Name(String tmp_Name) {
		this.tmp_Name = tmp_Name;
	}
	public String getTmp_Email() {
		return tmp_Email;
	}
	public void setTmp_Email(String tmp_Email) {
		this.tmp_Email = tmp_Email;
	}
	public String getTmp_OrgnztId() {
		return tmp_OrgnztId;
	}
	public void setTmp_OrgnztId(String tmp_OrgnztId) {
		this.tmp_OrgnztId = tmp_OrgnztId;
	}
	public String getTmp_UniqId() {
		return tmp_UniqId;
	}
	public void setTmp_UniqId(String tmp_UniqId) {
		this.tmp_UniqId = tmp_UniqId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
