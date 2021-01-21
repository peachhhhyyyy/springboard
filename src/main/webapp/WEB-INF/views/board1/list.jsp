<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
   <title> Spring Board </title>
   <meta charset="utf-8">
   <style>
      a{text-decoration:none}
   </style>
</head>
<body>
<center>
<font color='gray' size='4' face='휴먼편지체'>
<hr width='600' size='2' color='gray' noshade>
<h3> Spring Board</h3>
<font color='gray' size='4' face='휴먼편지체'>
<a href='../'>인덱스</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='write.do'>글쓰기</a><br/>
</font>
<hr width='600' size='2' color='gray' noshade>

<TABLE border='2' width='600' align='center' noshade>
<TR size='2' align='center' noshade bgcolor='AliceBlue'>
   <th bgcolor='AliceBlue'>no</th>
   <th color='gray'>writer</th>
   <th color='gray'>e-mail</th>
   <th color='gray'>subject</th>
   <th color='gray'>date</th>
   <th color='gray'>삭제</th>
</TR>


  <c:if test="${empty listResult.list}">
      <tr>
         <td align='center' colspan="5">데이터가 하나도 없음</td>
      </tr>
   </c:if>
   <c:forEach items="${listResult.list}" var="board">
      <tr>
         <td align='center'>${board.seq}</td>
         <td>${board.writer}</td>
         <td>${board.email}</td>
         <td><a href='content.do?seq=${board.seq}'>${board.subject}</a></td>
         <td>${board.rdate}</td>
         <td align='center'><a href='del.do?seq=${board.seq}'>삭제</a></td>
      </tr>
   </c:forEach>
   
</TABLE>
<hr width='600' size='2' color='gray' noshade>
<font color='gray' size='3' face='휴먼편지체'>

     (총페이지수 : ${listResult.totalPageCount})
    &nbsp;&nbsp;&nbsp;
<c:forEach begin="1" end="${listResult.totalPageCount}" var="i">
        <a href="list.do?cp=${i}">
           <c:choose>
               <c:when test="${i==listResult.cp}">
                  <strong>${i}</strong>
               </c:when>
              <c:otherwise>
                 ${i}
              </c:otherwise>
           </c:choose>
        </a>&nbsp;
    </c:forEach>           
    
    ( TOTAL : ${listResult.totalCount} )
    
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       페이지 싸이즈 :
    <select id="psId" name="ps" onchange="f(this)">
       <c:choose>
          <c:when test="${listResult.ps == 3}">
              <option value="3" selected>3</option>
              <option value="5">5</option>
            <option value="10">10</option>
          </c:when>
          <c:when test="${listResult.ps == 5}">
              <option value="3">3</option>
              <option value="5" selected>5</option>
            <option value="10">10</option>
          </c:when>
         <c:otherwise>
             <option value="3">3</option>
             <option value="5">5</option>
             <option value="10" selected>10</option>
         </c:otherwise>   
       </c:choose>   
    </select>
    
    <script language="javascript">
    <%-- window.onload = function(){ 위에 if else if문 대신 쓸 수 있음
       var sel = document.getElementById("psId");
        for(var i=0; i<sel.length; i++){
             if(sel[i].value==<%=ps%>){
                console.log("sel[i].value is "+sel[i].value);
                 sel[i].selected = true;
             }
         }
    } --%>
    
       function f(select){
           //var el = document.getElementById("psId");
           var ps = select.value;
           //alert("ps : " + ps);
           location.href="list.do?ps="+ps;
       }
    </script>
    
</font>
<hr width='600' size='2' color='gray' noshade>
    
</center>
</body>
</html>