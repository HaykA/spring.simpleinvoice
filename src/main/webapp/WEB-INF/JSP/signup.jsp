<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces="true"%>

<%-- JSTL-taglibs --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- Spring-taglibs --%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='security' uri='http://www.springframework.org/security/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>

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
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
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
              <a href="<c:url value='/signin'/>" class="btn btn-sm btn-primary"><bs:fa icon="sign-in"/>&nbsp;${text_SignIn}</a>
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
        <%-- Sign Up Form --%>
        <c:url value='/signup' var='url'/>
        <div class="signup-body clearfix">
          <!-- SignIn-form -->
          <div id="signup-form">
            <form:form action='${url}' commandName='userForm'>
              <security:csrfInput/>
              <h1>Sign Up</h1>
              <div class="form-group">
                  <form:label path="email.value" class="input-group-addon" id="addon-email">Email</form:label>
                  <form:input path="email.value" class="form-control signin-input"
                    placeholder="E-Mail" aria-describedby="addon-email" maxlength="45"/>
                  <form:errors path="email.value"/>
              </div>
              <div class="form-group">
                  <form:label path="email.controlValue" class="input-group-addon" id="addon-r_email">Repeat Email</form:label>
                  <form:input path="email.controlValue" class="form-control signin-input"
                    placeholder="E-Mail" aria-describedby="addon-r_email" maxlength="45"/>
                  <form:errors path="email.controlValue"/>
              </div>
              <div class="form-group">
                  <form:label path="username" class="input-group-addon" id="addon-username">Username</form:label>
                  <form:input path="username" class="form-control signin-input"
                    placeholder="${text_Username}" aria-describedby="addon-username" maxlength="45"/>
                  <form:errors path="username"/>
              </div>
              <div class="form-group">
                  <form:label path="firstname" class="input-group-addon" id="addon-firstname">Firstname</form:label>
                  <form:input path="firstname" class="form-control signin-input"
                    placeholder="Firstname" aria-describedby="addon-firstname" maxlength="45"/>
                  <form:errors path="firstname"/>
              </div>
              <div class="form-group">
                  <form:label path="secondname" class="input-group-addon" id="addon-secondname">Secondname</form:label>
                  <form:input path="secondname" class="form-control signin-input"
                    placeholder="Secondname" aria-describedby="addon-secondname" maxlength="45"/>
                  <form:errors path="secondname"/>
              </div>
              <div class="form-group">
                  <form:label path="password.value" class="input-group-addon" id="addon-password">Password</form:label>
                  <form:input path="password.value" type="password" class="form-control signin-input"
                    placeholder="${text_Password}" aria-describedby="addon-password" maxlength="45"/>
                  <form:errors path="password.value"/>
              </div>
              <div class="form-group">
                  <form:label path="password.controlValue" class="input-group-addon" id="addon-r_password">Repeat Password</form:label>
                  <form:input path="password.controlValue" type="password" class="form-control signin-input"
                    placeholder="${text_Password}" aria-describedby="addon-r_password" maxlength="45"/>
                  <form:errors path="password.controlValue"/>
              </div>
              ${captcha}
    
              <div class="g-recaptcha" data-sitekey="6LfQth0TAAAAAOWIw1a4oZ3T6DUO8fxP_UfRk_Fs"></div>
      <br/>

              <button type="submit" class="btn btn-success"><bs:fa icon="asterisk"/>&nbsp;${text_Register}</button>
            </form:form>
          </div>
        </div>
      </article>
    </section>
  </body>

</html>