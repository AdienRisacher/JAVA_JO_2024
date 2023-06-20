<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<script>
  var apiUrl = 'http://localhost:8080/java_jo_2024/pays';
  var xhr = new XMLHttpRequest();

  xhr.open('GET', apiUrl, true);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      var response = xhr.responseText;
      console.log(response);
    } else {
      console.log('Erreur lors de l\'appel à l\'API');
    }
  };

  xhr.send();
</script>
</body>
</html>
