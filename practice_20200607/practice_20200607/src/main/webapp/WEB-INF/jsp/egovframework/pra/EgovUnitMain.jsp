<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>eGovFrame 공통 컴포넌트</title>
</head>

<frameset frameborder="0" framespacing="0" rows="100, *, 43">
	<frame name="_top" src="<c:url value='/head.do' />" scrolling="no" title="헤더">
		
	<frame name="_content" src="<c:url value='/content.do' />" title="메인페이지">
		
	<frame name="_bottom" src="<c:url value='/bottom.do' />" scrolling="no" title="푸터">
</frameset>
