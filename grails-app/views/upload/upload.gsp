<%--
  Created by IntelliJ IDEA.
  User: varinder singh
  Date: 19-11-2020
  Time: 22:31
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous">

</script>
<body>


    <g:uploadForm controller="upload" action="upload">
        <div class="btn btn-primary btn-sm float-left">
            <input type="file" class="btn" name="usercsv" />
        </div>
        <g:submitButton class="btn btn-success" name="upload" value="Upload" />
    </g:uploadForm>

    <g:if test="${result?.contains("Error")}">
        <div class="alert alert-danger"> ${result} </div>
    </g:if>

<g:if test="${result?.contains("success")}">
    <div class="alert alert-success"> ${result} </div>
</g:if>

<g:if test="${result?.contains("Info")}">
    <div class="alert alert-info"> ${result} </div>
</g:if>

</body>
</html>




