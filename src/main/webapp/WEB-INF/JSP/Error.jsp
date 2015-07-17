<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>An Exception Has Been Caught!</h1>
        <p>Application has encountered an error.</p>
    
        <!--
            Failed URL: ${url}
            Exception:  ${exception.message}
            Stack Trace:
            <c:forEach items="${exception.stackTrace}" var="ste">
            ${ste} 
            </c:forEach>
        -->
    </body>
</html>
