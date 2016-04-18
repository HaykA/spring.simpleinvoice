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
<spring:message code='SignOut' var="text_SignOut"/>
<spring:message code='Register' var="text_Register"/>
<spring:message code='SignInOrRegister' var="text_SignInOrRegister"/>
<spring:message code='Manage' var="text_Manage"/>
<spring:message code='Settings' var="text_Settings"/>

<%-- HTML --%>
<!DOCTYPE html>
<html>
  <head>
    <si:head title="${text_SignInOrRegister}" showBrandname="true" ignoreDefaultCss="true"/>
    <link rel="stylesheet" href="<c:url value='/browser/core/css/signin.css' />" type="text/css"/>
  </head>
  <body>
    <%-- Header --%>
    <header>
      <nav class="navbar navbar-default navbar-signin">
        <div class="container-fluid">
          <!-- Navbar Header -->
          <div class="navbar-header">
            <div id="brand">
              <img alt="${text_Logo}" src="<c:url value='/images/core/logo.jpg'/>"/>
            </div>
          </div>
          <!-- SignIn-form -->
          <div id="signin-form">
          
            <%-- BEGIN ANONYMOUS --%>
            <security:authorize access='isAnonymous()'>
            <form class="navbar-form navbar-right" method="post" action="<c:url value='/signin'/>" id="loginform">
              <security:csrfInput/>
              <div class="form-group">
                <div class="input-group">
                  <label class="input-group-addon" id="addon-username" for="ipt-username"><bs:gi icon="user"/></label>
                  <input type="text" name="username" id="ipt-username" class="form-control signin-input"
                    placeholder="${text_Username}" aria-describedby="addon-username" maxlength="45">
                </div>
              </div>
              <div class="form-group">
                <div class="input-group">
                  <label class="input-group-addon" id="addon-password" for="ipt-password"><bs:gi icon="lock"/></label>
                  <input type="password" name="password" id="ipt-password" class="form-control signin-input"
                    placeholder="${text_Password}" aria-describedby="addon-password" maxlength="45">
                </div>
              </div>
              <button type="submit" class="btn btn-primary"><bs:fa icon="sign-in"/>&nbsp;${text_SignIn}</button>
            </form>
            </security:authorize>
            <%-- END ANONYMOUS --%>
            
            <%-- BEGIN AUTHENTICATED --%>
            <security:authorize access='isAuthenticated()'>
            <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                  aria-haspopup="true" aria-expanded="false"><bs:fa icon="user" fixedWidth="true"/>&nbsp;${user.name}<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#"><bs:fa icon="suitcase" fixedWidth="true"/>&nbsp;${text_Manage}</a></li>
            <li><a href="#"><bs:fa icon="gear" fixedWidth="true"/>&nbsp;${text_Settings}</a></li>
            <li role="separator" class="divider"></li>
            <li>
              <form method="post" action="<c:url value='/logout'/>" id="logoutform">
                <security:csrfInput/>
                <input type="hidden" id="logoutbutton" value="logout"/>
              </form>
              <a href="#" onclick="$('#logoutform').submit()"><bs:fa icon="sign-out" fixedWidth="true"/>&nbsp;${text_SignOut}</a>
            </li>
          </ul>
        </li>
            </ul>
            
            
            </security:authorize>
            <%-- END AUTHENTICATED --%>
            
          </div>
        </div>
      </nav>
    </header>
    <%-- Sign Up --%>
    <section>
      <article>
        <div class="index-body clearfix">
        
          <%-- BEGIN AUTHENTICATED --%>
          <security:authorize access='isAuthenticated()'>
          <h1>Hello <security:authentication property="name"/></h1>
          </security:authorize>
          <%-- END AUTHENTICATED --%>
          
          <%-- BEGIN ANONYMOUS --%>
          <security:authorize access='isAnonymous()'>
          <h1>Simple Invoice 1.0</h1>
          <a href="<c:url value='/signup'/>" class="btn btn-lg btn-success"><bs:fa icon="asterisk"/>&nbsp;${text_Register}</a>
          </security:authorize>
          <%-- END ANONYMOUS --%>
          
        </div>
      </article>
    </section>
  </body>

</html>