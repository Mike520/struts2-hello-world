<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: liwenxiang
  Date: 2016/4/7
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<br>
<s:property value="product.name"/>
</br>
<s:property value="product.price"/>
</br>
<fmt:formatNumber value='${product.price}' pattern="0.00" />
</br>
<s:iterator value="productList" var="list">
    <s:property value="#list.name"/>
    <s:property value="#list.price"/>
    <fmt:formatNumber value='${list.price}' pattern="0.00" />
    <fmt:formatNumber value='${price}' pattern="0.00" />
    </br>
</s:iterator>
</body>
</html>
