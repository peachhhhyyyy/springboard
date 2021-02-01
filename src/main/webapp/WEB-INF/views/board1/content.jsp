<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<style>
   a{text-decoration:none}
</style>


<meta charset="utf-8">
<center>
   <font color='gray' size='4' face='휴먼편지체'>
   <hr width='600' size='2' color='gray' noshade>
   <h3>Spring Board</h3>
   <font color='gray' size='4' face='휴먼편지체'>
   <a href='write.do'>글쓰기</a>
   </font>
   <hr width='600' size='2' color='gray' noshade>
   </font>
   <table border='2' width='600' align='center' noshade>
   <tr>
   <td width='20%' align='center'>No</td>
   <td>${content.seq}</td>
   </tr>
   <tr>
   <td width='20%' align='center'>Writer</td>
   <td>${content.writer}</td>
   </tr>
   <tr>
   <td align='center'>E-mail</td>
   <td>${content.email}</td>
   </tr>
   <tr>
   <td align='center'>Subject</td>
   <td>${content.subject}</td>
   </tr>
   <tr>
   <td align='center'>Contents</td>
   <td>${content.content}</td>
   </tr>
   <tr>
   <td align='center'>File Name</td>
   <td><a href="download.do?fname=${content.fname}">${content.fname}</a></td>
   </tr>
   <tr>
   <td align='center'>Original File Name</td>
   <td>${content.ofname}</td>
   </tr>
   <tr>
   <td align='center'>File Size</td>
   <td>${content.fsize}</td>
   </tr>
   </table>
   
   <hr width='600' size='2' color='gray' noshade>
   <font color='gray' size='4' face='휴먼편지체'>
   <a href='update.do?seq=${content.seq}'>수정</a>
    &nbsp;&nbsp;| 
   <a href='del.do?seq=${content.seq}'>삭제</a>
    &nbsp;&nbsp;| 
   <a href='list.do'>목록</a>
   </font>
   <hr width='600' size='2' color='gray' noshade>
</center>