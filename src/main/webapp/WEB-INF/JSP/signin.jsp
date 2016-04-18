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
    <si:head title="${text_Register}" showBrandname="true" ignoreDefaultCss="true"/>
    <link rel="stylesheet" href="<c:url value='/browser/core/css/signin.css' />" type="text/css"/>
  </head>
  <body>
    <%-- Header --%>
    <header>
      <nav class="navbar navbar-default navbar-signup">
        <div class="container-fluid">
          <!-- Navbar Header -->
          <div class="navbar-header">
            <div id="brandname">
              <a href="<c:url value='/'/>" class="brand">SIMPLEINVOICE</a>
              <a href="<c:url value='/signup'/>" class="btn btn-sm btn-success"><bs:fa icon="asterisk"/>&nbsp;${text_Register}</a>
            </div>
          </div>
        </div>
      </nav>
    </header>
    <%-- Sign In --%>
    <section>
      <article>
        <%-- Sign In Alert --%>
        <c:if test='${param.error != null}'>
        <div class="alert alert-danger alert-dismissible signin-alert" role="alert">
          <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <bs:fa icon="warning"/><strong> Warning!</strong> Better check yourself, you're not looking too good.
        </div>
        </c:if>
        <%-- Sign In Form --%>
        <div class="signin-body clearfix">
          <!-- SignIn-form -->
          <div id="signin-form">
            <form method="post">
              <security:csrfInput/>
              <div class="form-group">
                <div class="input-group">
                  <label class="input-group-addon" id="addon-username" for="ipt-username"><bs:gi icon="user" size="2"/></label>
                  <input type="text" name="username" id="ipt-username" class="form-control signin-input input-lg"
                    placeholder="${text_Username}" aria-describedby="addon-username" maxlength="45">
                </div>
              </div>
              <div class="form-group">
                <div class="input-group">
                  <label class="input-group-addon" id="addon-password" for="ipt-password"><bs:gi icon="lock" size="2"/></label>
                  <input type="password" name="password" id="ipt-password" class="form-control signin-input input-lg"
                    placeholder="${text_Password}" aria-describedby="addon-password" maxlength="45">
                </div>
              </div>
              <button type="submit" class="btn btn-lg btn-primary"><bs:fa icon="sign-in"/>&nbsp;${text_SignIn}</button>
            </form>
          </div>
        </div>
      </article>
    </section>
  </body>

</html>