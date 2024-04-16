<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1> 회원가입 </h1>
   <form action="Member.do">
   <table>
      <tr>
         <td>이름</td>
         <td><input type="text" name="name"/></td>
      </tr>
      <tr>
         <td>직업</td>
         <td><input type="text" name="job"/></td>
      </tr>
      <tr>
         <td>phone</td>
         <td><input type="tel" name="tel"/></td>
      </tr>
      <tr>
         <td><input type="submit" value="저장"/></td>
      </tr>
   </table>
   </form>
</body>
</html>