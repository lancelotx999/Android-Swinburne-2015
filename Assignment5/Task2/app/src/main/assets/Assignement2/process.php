<?php
/*Author: Sean Lee
  Student ID: 4308131
  Last Updated: 13/5/2014
 */
 
	$UserName = $_GET['UserName'];
	$Gender = $_GET['Gender'];
	$Country = $_GET['Country'];
	$Ratings = $_GET['Ratings'];

	echo "You have successfully submitted your feedback form. <br/><br/>";
	
	echo "Name: " .$UserName. "<br/>";
	echo "Gender: " .$Gender. "<br/>";
	echo "Country: " .$Country. "<br/>";
	echo "Ratings: " .$Ratings. "<br/>";
	
	echo "<br/> Thank you!";
?>