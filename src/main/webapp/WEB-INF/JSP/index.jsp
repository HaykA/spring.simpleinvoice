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
<spring:message code='SignInOrRegister' var="text_SignInOrRegister"/>

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
            <form class="navbar-form navbar-right" method="post">
              <security:csrfInput/>
              <div class="form-group">
                <div class="input-group">
                  <span class="input-group-addon" id="addon-username"><bs:gi icon="user"/></span>
                  <input type="text" name="username" id="ipt-username" class="form-control signin-input"
                    placeholder="${text_Username}" aria-describedby="addon-username" maxlength="45">
                </div>
              </div>
              <div class="form-group">
                <div class="input-group">
                  <span class="input-group-addon" id="addon-password"><bs:gi icon="lock"/></span>
                  <input type="password" name="password" id="ipt-password" class="form-control signin-input"
                    placeholder="${text_Password}" aria-describedby="addon-password" maxlength="45">
                </div>
              </div>
              <button type="submit" class="btn btn-primary"><bs:fa icon="sign-in"/>&nbsp;${text_SignIn}</button>
            </form>
          </div>
        </div>
      </nav>
    </header>
    <%-- Sign Up --%>
    <section>
      <article>
        <div class="signup-body clearfix">
          <h1>Simple Invoice 1.0</h1>
          <a href="#" class="btn btn-lg btn-success"><bs:fa icon="asterisk"/>&nbsp;${text_Register}</a>
        </div>
      </article>
    </section>
  </body>

</html>