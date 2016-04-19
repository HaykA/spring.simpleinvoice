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
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
  </head>
  <body>
    <div class="well">
      <pre>
        <c:if test="${not empty form1}">
          Email: ${form1.email}
          Repeat Email: ${form1.repeatEmail}
          Username: ${form1.username}
          Firstname: ${form1.firstname}
          Secondname: ${form1.secondname}
          Password: ${form1.password}
          Repeat Password: ${form1.repeatPassword}
        </c:if>
      </pre>
    </div>
  </body>

</html>