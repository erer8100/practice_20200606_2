<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="egovframework.com.cmm.util.EgovUserDetailsHelper" %>


<c:set var="menuIndexUrl" value="/cmm/EgovMainMenuIndex.do"/>
<c:set var="menuHomeUrl" value="/cmm/EgovMainMenuHome.do"/>
<c:set var="logoutUrl" value="/cmm/actionLogout.do"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<script type="text/javascript">
var getContextPath = "${pageContext.request.contextPath}";
</script>
<script language="text/javascript" src="<c:url value='/js/egovframework/com/main.js' />"></script>
<script type="text/javascript">
	function fn_main_headPageMove(menuNo, url){
		document.selectOne.menuNo.value=menuNo;
		document.selectOne.chkURL.value=url;
	    document.selectOne.action = "<c:url value='${menuIndexUrl}'/>";
	    document.selectOne.submit();
	}

	function actionLogout()
	{
		document.selectOne.action = "${logoutUrl}'/>";
		document.selectOne.submit();
		//top.document.location.href = "<c:url value='/j_spring_security_logout'/>";
	}
</script>
<link rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/mpm.css' />" type="text/css">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/egovframework/com/common.css' />" />
</head>
<body>
<form name="selectOne">
<input name="menuNo" type="hidden" />
<input name="chkURL" type="hidden" />

    <div id="gnb">
    <div id="top_logo"><a href="<c:url value='${menuHomeUrl}' />" target=_self><img src="<c:url value='/images/egovframework/com/logo_01.gif' />" alt="egovframe" /></a></div>
    <div id="use_descri">
            <ul>
                <li>공통서비스 테스트 사이트(업무사용자용)</li>
                <li><a href="javascript:actionLogout()"><img src="<c:url value='/images/egovframework/com/logout_btn.gif' />" alt="로그아웃" /></a></li>
            </ul>
    </div>
    </div>
    <div id="new_topnavi">
        <ul>
			<li><a href="<c:url value='${menuHomeUrl}' />" target="_self">HOME</a></li>
			<c:forEach var="result" items="${list_headmenu}" varStatus="status">
			   
			   <li class="gap"> l </li>
			   <li><a href="${pageContext.request.contextPath}${menuIndexUrl}?menuNo=${result.menuNo}&chkURL=${result.chkURL}" target="_content" ><c:out value="${result.menuNm}"/></a></li>
			</c:forEach>
        </ul>
    </div>

</form>
</body>
</html>