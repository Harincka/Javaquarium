<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="message.insertionPoisson"/></title>
</head>
<body>

<div class="pure-control-group">
		<bean:message key="ajouter.message.poisson" />
</div>

<html:form action="ajouterNouveauPoisson" styleClass="pure-form pure-form-aligned">
	<html:errors/>
	<br/>
	
	<div class="pure-control-group">
		<bean:message key="tableau.nom" />
		<html:text property="nom" />
	</div>
	
	<div class="pure-control-group">
		<bean:message key="tableau.description" />
		<html:text property="description" />
	</div>
	
	<div class="pure-control-group">
		<bean:message key="tableau.couleur" />
		<html:text property="couleur" />
	</div>
	
	<div class="pure-control-group">
		<bean:message key="tableau.prix" />
		<html:text property="prix" />
	</div>
	
	<div class="pure-control-group">
		<bean:message key="tableau.dimension" />
		<html:text property="dimension" />
	</div>
	
	<div class="pure-control-group">
			<html:submit property="submit" value="Envoyer"
				styleClass="pure-button pure-button-primary" />
			<html:reset property="reset" value="Effacer"
				styleClass="pure-button pure-button-primary" />
		</div>
	
	
</html:form>


</body>
</html>