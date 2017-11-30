<%@page import="com.javaquarium.action.ListerEspeceAction"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="message.bienvenue" /></title>
</head>
<body>
	<table>
		<tr>
			<th><bean:message key="tableau.nom"/></th>
			<th><bean:message key="tableau.description"/></th>
			<th><bean:message key="tableau.couleur"/></th>
			<th><bean:message key="tableau.dimension"/></th>
			<th><bean:message key="tableau.prix"/></th>
			<th><bean:message key="tableau.detail"/></th>
			<th><bean:message key="tableau.aquarium"/></th>
		</tr>
		<logic:iterate name="<%=ListerEspeceAction.SESSION_LIST_POISSON%>"
			id="MonPoisson">
			<tr>
				<td><bean:write name="MonPoisson" property="nom" /></td>
				<td><bean:write name="MonPoisson" property="description" /></td>
				<td><bean:write name="MonPoisson" property="couleur" /></td>
				<td><bean:write name="MonPoisson" property="dimension" /></td>	
				<td><bean:write name="MonPoisson" property="prix" /></td>
				<td>Test</td>
			</tr>
		</logic:iterate>
		
	</table>
	<a href="/Javaquarium/jsp/UC02_ajout.jsp"><bean:message key="ajouter.lien.poisson"/></a>
</body>
</html>