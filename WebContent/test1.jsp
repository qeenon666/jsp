<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.wp.voca.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>voca test</title>
	<style>
		body{
			width: 600px;
			margin-top:50px;
			margin-left:50px;
		}
		header{
			height:100px;
		}
		.question {
			padding-top: 25px;
		}
	</style>
</head>
<body>

	<%
		String cnt = (String)session.getAttribute("cut");
		String name = (String)session.getAttribute("id");
	%>
	
	<header>
		<h1>voca 테스트</h1>
		<div style='text-align: right;'>
			<p>반갑습니다, <%= name %> !...</p>
		</div>
	</header>
	<article>
		<%
			List<VocaDO> memberList = (List<VocaDO>)request.getAttribute("member_list");
			if (memberList != null) {
				for (VocaDO member : memberList) {
		%>
          	<form action='${pageContext.request.contextPath}/voca?action=test1' method='POST'>	
          	<%if(cnt == "1"){ %>			
            <div class = "question">
				1. <%= member.getT1() %><br>
				<div>
					<input type='radio' name='q1' value='1' required />A.<%= member.getT2() %> <br>
				 	<input type='radio' name='q1' value='2' />B.<%= member.getT3() %> <br>
				 	<input type='radio' name='q1' value='3' />C.<%= member.getT4() %><br>
				 	<input type='radio' name='q1' value='4' />D.<%= member.getT5() %><br>
				 </div>
			</div>
			<div class='question'>
				<p>2. <%= member.getT6() %><br></p>
				<div>
					 <input type='radio' name='q2' value='1' required />A.<%= member.getT7() %><br>
					 <input type='radio' name='q2' value='2' />B.<%= member.getT8() %> <br>
					 <input type='radio' name='q2' value='3' />C.<%= member.getT9() %><br> 
					 <input type='radio' name='q2' value='4' />D.<%= member.getT10() %><br>
				</div>
			</div>
			<div class='question'>
				<p>3. <%= member.getT11() %><br></p>
				<div>
					 <input type='radio' name='q3' value='1' required />A.<%= member.getT12() %><br>
					 <input type='radio' name='q3' value='2' />B.<%= member.getT13() %> <br>
					 <input type='radio' name='q3' value='3' />C.<%= member.getT14() %><br> 
					 <input type='radio' name='q3' value='4' />D.<%= member.getT15() %><br>
				</div>
			</div>
			<div style='padding-top: 50px; text-align: right'>
				<input type="hidden" value="2" name="cut" />
				<input type='submit' value='다음' />
			</div>
			 <%} else if(cnt == "2"){  %>
			<div class='question'>
				<p>4. <%= member.getT16() %><br></p>
				<div>
					<input type='radio' name='q4' value='1' required />A.<%= member.getT17() %><br>
					 <input type='radio' name='q4' value='2' />B.<%= member.getT18() %> <br>
					 <input type='radio' name='q4' value='3' />C.<%= member.getT19() %><br> 
					 <input type='radio' name='q4' value='4' />D.<%= member.getT20() %><br>
				</div> 
			</div>
			<div class='question'>
				<p>5. <%= member.getT21() %><br></p>
				<div>
					 <input type='radio' name='q5' value='1' required />A.<%= member.getT22() %><br>
					 <input type='radio' name='q5' value='2' />B.<%= member.getT23() %> <br>
					 <input type='radio' name='q5' value='3' />C.<%= member.getT24() %><br> 
					 <input type='radio' name='q5' value='4' />D.<%= member.getT25() %><br>
				</div>
			</div>
			<div class='question'>
				<p>6. <%= member.getT26() %><br></p>
				<div>
					 <input type='radio' name='q6' value='1' required />A.<%= member.getT27() %><br>
					 <input type='radio' name='q6' value='2' />B.<%= member.getT28() %> <br>
					 <input type='radio' name='q6' value='3' />C.<%= member.getT29() %><br> 
					 <input type='radio' name='q6' value='4' />D.<%= member.getT30() %><br>
				</div>
			</div>
			<div style='padding-top: 50px; text-align: right'>
				<input type="hidden" value="3" name="cut" />
				<input type='button' value='이전' onclick='window.history.go(-1);' />
				<input type='submit' value='다음' />
			</div>
			 <% }  else if(cnt == "3"){ %>
			<div class='question'>
				<p>7. <%= member.getT31() %><br></p>
				<div>
					 <input type='radio' name='q7' value='1' required />A.<%= member.getT32() %><br>
					 <input type='radio' name='q7' value='2' />B.<%= member.getT33() %> <br>
					 <input type='radio' name='q7' value='3' />C.<%= member.getT34() %><br> 
					 <input type='radio' name='q7' value='4' />D.<%= member.getT35() %><br>
				</div>
			</div>
			<div class='question'>
				<p>8. <%= member.getT36() %><br></p>
				<div>
					 <input type='radio' name='q8' value='1' required />A.<%= member.getT37() %><br>
					 <input type='radio' name='q8' value='2' />B.<%= member.getT38() %> <br>
					 <input type='radio' name='q8' value='3' />C.<%= member.getT39() %><br> 
					 <input type='radio' name='q8' value='4' />D.<%= member.getT40() %><br>
				</div>
			</div>
			<div class='question'>
				<p>9. <%= member.getT41() %><br></p>
				<div>
					 <input type='radio' name='q9' value='1' required />A.<%= member.getT42() %><br>
					 <input type='radio' name='q9' value='2' />B.<%= member.getT43() %> <br>
					 <input type='radio' name='q9' value='3' />C.<%= member.getT44() %><br> 
					 <input type='radio' name='q9' value='4' />D.<%= member.getT45() %><br>
				</div>
			</div>
			<div style='padding-top: 50px; text-align: right'>
				<input type="hidden" value="4" name="cut" />
				<input type='button' value='이전' onclick='window.history.go(-1);' />
				<input type='submit' value='다음' />
			</div>
			 <%} else if(cnt == "4"){ %>
			<div class='question'>
				<p>10. <%= member.getT46() %><br></p>
				<div>
					 <input type='radio' name='q10' value='1' required />A.<%= member.getT47() %><br>
					 <input type='radio' name='q10' value='2' />B.<%= member.getT48() %> <br>
					 <input type='radio' name='q10' value='3' />C.<%= member.getT49() %><br> 
					 <input type='radio' name='q10' value='4' />D.<%= member.getT50() %><br>
				</div>
			</div>
			<div class='question'>
				<p>11. <%= member.getT51() %><br></p>
				<div>
					 <input type='radio' name='q11' value='1' required />A.<%= member.getT52() %><br>
					 <input type='radio' name='q11' value='2' />B.<%= member.getT53() %> <br>
					 <input type='radio' name='q11' value='3' />C.<%= member.getT54() %><br> 
					 <input type='radio' name='q11' value='4' />D.<%= member.getT55() %><br>
				</div>
			</div>
			<div class='question'>
				<p>12. <%= member.getT56() %><br></p>
				<div>
					 <input type='radio' name='q12' value='1' required />A.<%= member.getT57() %><br>
					 <input type='radio' name='q12' value='2' />B.<%= member.getT58() %> <br>
					 <input type='radio' name='q12' value='3' />C.<%= member.getT59() %><br> 
					 <input type='radio' name='q12' value='4' />D.<%= member.getT60() %><br>
				</div>
			</div>
			<div style = "padding-top : 50px; text-align : right;">
               <input type = button value = "이전" onclick = "window.history.go(-1);"/>   
               <input type = "submit" value = "다음 "/>
               <input type="hidden" value="5" name="cut" />
            </div>
            <% }%> 
		    
		    <% if(cnt == "5") {%>
            <div class='question'>
				<p>13. <%= member.getT61() %><br></p>
				<div>
					 <input type='radio' name='q13' value='1' required />A.<%= member.getT62() %><br>
					 <input type='radio' name='q13' value='2' />B.<%= member.getT63() %> <br>
					 <input type='radio' name='q13' value='3' />C.<%= member.getT64() %><br> 
					 <input type='radio' name='q13' value='4' />D.<%= member.getT65() %><br>
				</div>
			</div>
			<div class='question'>
				<p>14. <%= member.getT66() %><br></p>
				<div>
					 <input type='radio' name='q14' value='1' required />A.<%= member.getT67() %><br>
					 <input type='radio' name='q14' value='2' />B.<%= member.getT68() %> <br>
					 <input type='radio' name='q14' value='3' />C.<%= member.getT69() %><br> 
					 <input type='radio' name='q14' value='4' />D.<%= member.getT70() %><br>
				</div>
			</div>
			<div class='question'>
				<p>15. <%= member.getT71() %><br></p>
				<div>
					 <input type='radio' name='q15' value='1' required />A.<%= member.getT72() %><br>
					 <input type='radio' name='q15' value='2' />B.<%= member.getT73() %> <br>
					 <input type='radio' name='q15' value='3' />C.<%= member.getT74() %><br> 
					 <input type='radio' name='q15' value='4' />D.<%= member.getT75() %><br>
				</div>
			</div>
			<input type = button value = "이전" onclick = "window.history.go(-1);"/>   
            <input type = "submit" value = "다음 "/>
            <input type="hidden" value="6" name="cut" />
            </form>  
		<%}
		    }
          		}%>
	</article>
</body>
</html>