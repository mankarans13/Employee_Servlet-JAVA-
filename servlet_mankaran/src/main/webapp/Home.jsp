<!DOCTYPE html>
<html>
<head>
	<title>Image Example</title>
	<style>
	.centre{
	margin-top: 5.5rem;
	padding-left: 31.5rem;
	}
	button {
			background-color: white; /* Green */
			border: none;
			color: black;
			padding: 10px 25px;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 16px;
			margin: 4px 2px;
			cursor: pointer;
		text-shadow: 3px 3px 19px #000;
		}
		button:hover {
			background-color: #2857A9; /* Darker green */
		}
	img {
			display: block;
			margin-top: 70px;
			text-shadow: 5px 5px 10px #000;
		}
		body {
			
		
			background: linear-gradient(to right,grey, #2857A9);
			background-size: 200% 200%;
			animation: gradient 10s ease infinite;
		}
		

		@keyframes gradient {
			0% {
				background-position: 0% 50%;
			}
			50% {
				background-position: 100% 50%;
			}
			100% {
				background-position: 0% 50%;
			}
		
		}
		h1 {
			color: white;
			text-align: center;
			text-shadow: 5px 5px 10px #000;
		
		}
		h2{
		}
		p {
			font-family: Arial black;
			font-size: 25px;
		}
	</style>
</head>
<body>
<navbar>

</navbar>

	<h1>Ayasya Digital Solution</h1>
	<%
		String message = "Hello, world!";
	%>
<div class  ="centre"><img src="ayasya2.jpg" alt="Ayasya Digital Solution"></img> </div>
	<center>
	
 <a href="http://localhost:8080/servlet_mankaran/login_ch.html"><button style="position: relative; top: -370px;right: 70px "><b>Login</button></a>
<a href="http://localhost:8080/servlet_mankaran/registration_ch.html"><button style="position: relative; top: -370px; right: -70px;"><b>registration</button></a>
	
	</center>
	
<h2> 
	<p><b> About Ayasya Digital</p>
	<center>
<p1><i>IT-sphere is a vibrant arena with continuous changes and challenges. And Ayasya Digital Solutions has been one company which always has absorbed all the shifting requirements in the market and has come up with corresponding solutions right from the year 2010.
</center>
<p><b>A WORD ABOUT US</p>
<center>
<p1><i>With the vision to have a truthful engagement with its clients and the mission to provide them with easy, responsive, flexible, affordable and fool-proof IT-solutions, the company over the years has grown from strength to strength.

It is this supreme quality of our services brought in by value-additions rooted in innovation, deep expertise, sharp analysis, process-optimization and customer-rapport that has earned us the recognition of a top-tier service-provider of various IT-solutions.

Regular upgrading and application of newer software-tools form a pivotal part in us being a one-point-contact for different IT-requirements of our clients.</i>
</center>
</p1>

<jsp:include page="Fetch_data_footer.jsp" />

</body>
</html>

