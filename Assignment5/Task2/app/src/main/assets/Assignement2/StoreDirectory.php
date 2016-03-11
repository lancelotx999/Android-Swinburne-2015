<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>tHe Spring - Store Directory</title>
		<meta http-equiv="content-type" content="type/html; charset=utf-8" />
		<meta http-equiv="Content-Style-Type" content="text/css" />
		<link rel="stylesheet" type="text/css" href="style/4310640_dK_style1.css" title="Darryl's style" media="screen"/>
		<link rel="alternate stylesheet" type="text/css" href="style/4308131_SeanLee.css" title="Sean's style" media="screen"/>			
	</head>


	<body id = "StoreDirectory">
		<div class="StoreDirectory">
			<?php require ("SSI/Header.php"); ?>

			<?php require ("SSI/NavBar.php"); ?>

				<div>
					<p><br /></p>
					<hr />
					<div id = "Top">
						<ul id = "StoreDirectoryMenu">
							<li><a href ="#BasementFloor">Basement Floor</a></li>
							<li><a href ="#GroundFloor">Ground Floor</a></li>
							<li><a href ="#FirstFloor">First Floor</a></li>
							<li><a href ="#SecondFloor">Second Floor</a></li>
							<li><a href ="#ThirdFloor">Third Floor</a></li>
						</ul><br />
					</div>
					<p><br /></p>
					<hr />
					
					<p><br /></p>
					<div id = "BasementFloor">
						<h1>Basement</h1>
						<p><br /></p>
						<img src="images/BasementFloor.jpg" alt="Basement Floor" width= "100%" />
						<ul id = "BasementFloorMenu">
							<li><a href="#Top" >Back To Top</a></li>
						</ul><br />
					</div>
					<p><br /></p>

					<p><br /></p>
					<hr />

					<p><br /></p>
					<div id = "GroundFloor">
						<h1>Ground Floor</h1>
						<p><br /></p>
						<img src="images/GroundFloor.jpg" alt="Ground Floor" width= "100%" />
						<ul id = "GroundFloorMenu">
							<li><a href="#Top" >Back To Top</a></li>
						</ul><br />
					</div>
					
					<p><br /></p>
					<hr />
					
					<p><br /></p>
					<div id = "FirstFloor">
						<h1>First Floor</h1>
						<p><br /></p>
						<img src="images/FirstFloor.jpg" alt="First Floor" width= "100%" />
						<ul id = "FirstFloorMenu">
							<li><a href="#Top" >Back To Top</a></li>
						</ul><br />
					</div>
					
					<p><br /></p>
					<hr />
					
					<p><br /></p>
					<div id = "SecondFloor">
						<h1>Second Floor</h1>
						<p><br /></p>
						<img src="images/SecondFloor.jpg" alt="Second Floor" width= "100%" />
						<ul id = "SecondFloorMenu">
							<li><a href="#Top" >Back To Top</a></li>
						</ul><br />
					</div>
					
					<p><br /></p>
					<hr />
					
					<p><br /></p>
					<div id = "ThirdFloor">
						<h1>Third Floor</h1>
						<p><br /></p>
						<img src="images/ThirdFloor.jpg" alt="Third Floor" width= "100%" />
						<ul id = "ThirdFloorMenu">
							<li><a href="#Top" >Back To Top</a></li>
						</ul><br />
					</div>
					
					<p><br /></p>
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