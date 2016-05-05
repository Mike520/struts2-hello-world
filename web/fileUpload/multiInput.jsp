<%--
  Created by IntelliJ IDEA.
  User: liwenxiang
  Date: 2016/5/5
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>多文件上传</title>
</head>
<body>
<form action="multiUpload.action" method="post" enctype="multipart/form-data">
    文件1：<input type="file" name="file"><br/>
    文件2：<input type="file" name="file"><br/>
    文件3：<input type="file" name="file"><br/>
    <input type="submit" value="上传">
</form>
</body>
</html>