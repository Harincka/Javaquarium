<%@page import="com.javaquarium.action.AjoutPoissonAquariumAction"%>
<%@page import="com.javaquarium.action.LoginAction"%>
<%@page import="com.javaquarium.util.SessionUtils"%>
<%@page import="com.javaquarium.action.ListerEspeceAction"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css">
<title><bean:message key="message.bienvenue" /></title>
<style scoped>
	.button-remove{
		background : rgb(202, 60, 60);
		color : white;
	}
	.div-entete a, .div-entete p{
		display : inline-block;
	}
</style>
</head>
<body>
	<h1>
		<bean:message key="message.bienvenue"/>
		<%= request.getSession().getAttribute(LoginAction.SESSION_USERNAME) %>
	</h1>
	<div class="div-entete">
		<p><bean:message key="message.listerespece.title.aquarium"/> ( <%=SessionUtils.countNumberOfPoisson(request.getSession().getAttribute(AjoutPoissonAquariumAction.AQUARIUM)) %> )</p>
		
		<a class="pure-button" href="/Javaquarium/save.do"><bean:message key="message.listerespece.button.save.espece.title"/></a>
		<a class="pure-button" href="/Javaquarium/clear.do"><bean:message key="message.listerespece.button.empty.espece.title"/></a>
	</div>
	
	<table class="pure-table">
		<thead>
			<tr>
				<th><bean:message key="tableau.nom"/></th>
				<th><bean:message key="tableau.description"/></th>
				<th><bean:message key="tableau.couleur"/></th>
				<th><bean:message key="tableau.dimension"/></th>
				<th><bean:message key="tableau.prix"/></th>
				<th><bean:message key="tableau.aquarium"/></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="<%=ListerEspeceAction.SESSION_LIST_POISSON%>"
				id="MonPoisson">
				<tr>
					<td><bean:write name="MonPoisson" property="name" /></td>
					<td><bean:write name="MonPoisson" property="description" /></td>
					<td><bean:write name="MonPoisson" property="couleur" /></td>
					<td><bean:write name="MonPoisson" property="dimension" /></td>	
					<td><bean:write name="MonPoisson" property="prix" /></td>
					<td>
						<a class="pure-button pure-button-primary" href="/Javaquarium/ajouter.do?name=<bean:write name="MonPoisson" property="name"/>"><bean:message key="message.listerespece.button.add"/></a>
						<a class="pure-button button-remove" href="/Javaquarium/enlever.do?name=<bean:write name="MonPoisson" property="name"/>"><bean:message key="message.listerespece.button.remove"/></a>
					</td>
				</tr>
			</logic:iterate>
		</tbody>
	</table>
	<br/>
	<a class="pure-button" href="/Javaquarium/jsp/UC02_ajout.jsp"><bean:message key="ajouter.lien.poisson"/></a>
</body>
</html>