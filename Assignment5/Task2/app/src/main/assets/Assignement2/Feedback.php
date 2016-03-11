<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>tHe Spring - Feedback</title>
		<meta http-equiv="content-type" content="type/html; charset=utf-8" />
		<meta http-equiv="Content-Style-Type" content="text/css" />
		
		<link rel="stylesheet" type="text/css" href="style/4310640_dK_style1.css" title="Darryl's style" media="screen"/>
		<link rel="alternate stylesheet" type="text/css" href="style/4308131_SeanLee.css" title="Sean's style" media="screen"/>			
		
		<script type="text/javascript" src="scripts/script1.js"></script>
	</head>

	<body id = "Feedback">
		<div class="Feedback">

			<?php require ("SSI/Header.php"); ?>

			<?php require ("SSI/NavBar.php"); ?>
		
			<div>
				<p><br /></p>
				<hr />
					
					<h1>Feedback</h1>
					<p>Please complete the feedback form if you wish to give reviews to tHe Spring. Your comments are appreciated. Thank you.</p>
					
					<form id ="survey" method="get" action="process.php" onsubmit="return validate(this)">

						<p><label for="UserName">Name: </label><input id="UserNname" name="UserName" type ="text" value="Enter your name"size="50" /></p>
						<p>Gender: <input type="radio" value="Male" id="Gender" name="Gender" checked="checked"/>Male
								<input type="radio" value="Female" id="Gender" name="Gender"/>Female
						</p>
						<p>><label for="Country">Country: <input type = "text" value="Enter the name of your country" id="Country" name="Country" size="40"/></p>
						
						<p>Ratings: <input type="radio" value="1" name="Ratings" checked="checked" />1 star
									<input type="radio" value="2" name="Ratings"/>2 stars
									<input type="radio" value="3" name="Ratings"/>3 stars
									<input type="radio" value="4" name="Ratings"/>4 stars
									<input type="radio" value="5" name="Ratings"/>5 stars
						</p>
						
						<p>><label for="Comments">Comments: <textarea id = "Comments" name="Comments" rows="4" cols="40"></textarea>
						</p>
						
						<p><input type="submit" name="submit" value="Submit" /> <input type="reset" name="clear" value="Clear" /></p>


					</form>
				
				<hr />
				<p><br /></p>
			</div>

			<div class="bottom">
			
				<h1>Contact us</h1>

					<table class="TableSettings">
							<tbody>
								<tr>
									<td rowspan="2"><img src="images/Spring.jpg" alt="Spring" height="200" width="400" /></td>
									<th><h3>Address</h3></th>
								</tr>
								<tr>
									<td>			
										PE Land Sdn. Bhd.<br />
										The Spring Centre Management Office<br />
										3rd Floor, The Spring Shopping Mall,<br />
										Persiaran Spring, 93300 Kuching,<br />
										Sarawak, Malaysia
									</td>
								</tr>
							</tbody>	
						</table>
						
				<p><br /></p>
				<hr />
				<p><br /></p>
		
				<a href="https://www.facebook.com/tHe.Spring.Kuching"><img src="images/facebook.png" alt="facebook" height="60" width="60" /></a><br />

				<h3 id="mail">Mail</h3>
				<p><a href ="contact.php" class="mail">enquiry@thespring.com.my</a></p>

				<h3>Phone Number</h3>

				<div id="PhoneNumber"><em>+6082 238 111</em><br /><br/></div>

				<div id="copyright">
					<p>©Copyright by Sean Lee &amp; Darryl Kong 2014</p>
				</div>
			</div>
		</div>
		<div class = "footer">
		<?php require ("SSI/Footer.php"); ?>
		</div>
	</body>
</html>