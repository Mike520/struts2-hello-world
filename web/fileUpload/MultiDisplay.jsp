<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: liwenxiang
  Date: 2016/5/5
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>多文件展示</title>
</head>
<body>
<s:iterator value="destFileName" var="dest" status="st">
    文件<s:property value="#st.index"/>：${fileFileName[st.index]} <br/>
    <img src="${dest}" alt="no img found"> <br/>
</s:iterator>
</body>
</html>
