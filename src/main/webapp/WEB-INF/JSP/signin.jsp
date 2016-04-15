<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces="true"%>

<%-- JSTL-taglibs --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- Spring-taglibs --%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='security' uri='http://www.springframework.org/security/tags'%>

<%-- Custom-taglibs --%>
<%@taglib prefix="si" uri="http://simpleinvoice.com/core/tags"%>
<%@taglib prefix="bs" uri="http://bootstrap.com/tags"%>

<%-- Message Source Codes --%>
<spring:message code='Logo' var="text_Logo"/>
<spring:message code='Username' var="text_Username"/>
<spring:message code='Password' var="text_Password"/>
<spring:message code='SignIn' var="text_SignIn"/>
<spring:message code='Register' var="text_Register"/>

<%-- HTML --%>
<!DOCTYPE html>
<html>
  <head>
    <si:head title="${text_SignIn}" showBrandname="true"/>
    <link rel="stylesheet" href="<c:url value='/browser/core/css/signin.css' />" type="text/css"/>
  </head>
  <body>
    <header id="main-header">
      <div class="main-header-container clearfix">
          <div id="logo-small">
            <img alt="${text_Logo}" src="<c:url value='/images/core/logo72.jpg'/>"/>
          </div>
          <h1>Simple Invoice 1.0</h1>
          <a href="#" class="btn btn-sm btn-success"><bs:fa icon="asterisk"/>&nbsp;${text_Register}</a>      
      </div>
      
    </header>
    <!-- <div class="alert alert-warning">Hello world</div>  -->
    <section id="main-section">
    <form method="post">
        
          <div id="signin-inputgroup">
            <div class="input-group input-group-floatleft">
              <span class="input-group-addon" id="addon-username"><bs:gi icon="user"/></span>
              <input type="text" name="username" id="ipt-username" class="form-control"
                placeholder="${text_Username}" aria-describedby="addon-username" maxlength="45">
            </div>
            <div class="input-group input-group-floatleft">
              <span class="input-group-addon" id="addon-password"><bs:gi icon="lock"/></span>
              <input type="password" name="password" id="ipt-password" class="form-control"
                placeholder="${text_Password}" aria-describedby="addon-password" maxlength="45">
            </div>
            <div class="input-group input-group-floatleft">
              <button type="submit" class="btn btn-primary"><bs:fa icon="sign-in"/>&nbsp;${text_SignIn}</button>
            </div>
          </div>

        <security:csrfInput/>
      </form>
    
    
      <article id="main-article">
        <div id="signin-body">
          
          
        </div>
      </article>
    </section>
  </body>

</html>