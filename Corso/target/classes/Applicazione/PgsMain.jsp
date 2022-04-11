<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<TITLE>pgsMain.jsp</TITLE>
</HEAD>
<BODY style=background-image:url(https://www.wallpapersales.co.uk/acatalog/31831.jpg)>

<h3 style= font-size:40px;color:black;text-align:center>Menù</h3><BR>

<FORM method="post" action="/Corso/CtrlMain">
<DIV align="center" class="container" style= width:40%;>

<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Ricerca</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row"><INPUT type="radio" name="rdoScelta" value="0" checked="checked"></th>
      <td>Archivio&nbsp;Docente</td>
    </tr>
    <tr>
      <th scope="row"><INPUT type="radio" name="rdoScelta" value="1" ></th>
      <td>Archivio&nbsp;Discente</td>
    </tr>
    <tr>
      <th scope="row"><INPUT type="radio" name="rdoScelta" value="5" ></th>
      <td>Archivio&nbsp;Aula</td>
    </tr>
    <tr>
      <th scope="row"><INPUT type="radio" name="rdoScelta" value="2" ></th>
      <td>Gestione&nbsp;Corso</td>
      
    </tr>
    <tr>
      <th scope="row"><INPUT type="radio" name="rdoScelta" value="3" ></th>
      <td>Ricerca&nbsp;Corso&nbsp;Per&nbsp;Docente</td>
      
    </tr>
     <tr>
      <th scope="row"><INPUT type="radio" name="rdoScelta" value="4" ></th>
      <td>Ricerca&nbsp;Corso&nbsp;Per&nbsp;Discente</td>
    </tr>
  </tbody>
</table>
<BR>
<INPUT class="btn btn-secondary" type ="submit" name="cmdInvio" value="Invio">
</DIV>
</form>
<div ALIGN="center"><br>
</div>

</BODY>
</HTML>