<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="model.session.Docente"
import="model.dao.DocenteService"
import="model.dao.DocenteDAO" %>
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
import="java.util.*"
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<TITLE>pgsArchivioDocente.jsp</TITLE>
</HEAD>
<BODY style=background-image:url(https://asabaspecialisthospital.org/wp-content/uploads/2019/07/Background-website-01.jpg)>

<FORM method="post" action="/Corso/CtrlArchivioDocente" name="ArchivioDocente">
<div class="container">
<div class="text">
&nbsp;&nbsp;<input class="btn btn-success" type="submit" name="cmdAzione" value="Torna alla Home">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<h3 style="text-align: center; color:green; font-size:35px" >Archivio Docenti </h3>
</div>

<% List<Docente> pgsElenco= (List<Docente>) request.getAttribute("elencoDocenti");
   if(pgsElenco.size() > 0){
   		int i = 0;
   
%>

<TABLE border="1" class="table" >
<thead class="thead-dark">
<TR>
<th scope="col"> </th>
<th scope="col">Cognome</th>   		
<th scope="col">Nome</th>  
</TR>
</thead>
<TBODY>


<%while(i< pgsElenco.size()){
	%>
	<TR>
	<th>
	<input type="radio" name="rdoIDDocente" value="<%= ((Docente)pgsElenco.get(i)).getId() %>" > 
	</th>
	<th> <%= ((Docente)pgsElenco.get(i)).getCognome() %></th>
	<th> <%= ((Docente)pgsElenco.get(i)).getNome() %></th>	
	</TR>
	<% i++;
	} %>	
</TBODY>
</TABLE>
</div>
<% } else{%> Non ci sono Docenti<% } %> <BR>

<div class="container" style="text-align:center">
	<input type="submit" name="cmdAzione" value="Nuovo">
	&nbsp;&nbsp;&nbsp;<input type="submit" name="cmdAzione" value="Modifica">
	&nbsp;&nbsp;&nbsp;<input type="submit" name="cmdAzione" value="Elimina">
</div>

<br>
</Form>

</BODY>
</HTML>
