/*
Last updated : 4:52 PM. 14/5/2014
This file is to perform data validation on feedback_form.php to ensure all inputted fields are valid
*/


function validate(myform)
{
	var UserName = myform.UserName.value;
	var Gender = myform.Gender.value;
	var Country = myform.Country.value;
	var Ratings = myform.Ratings.value;
	var Comments = myform.Comments.value;

	//var Check = 0;


	if ((UserName == "") || (UserName == "Enter your name"))
	{
		alert("Please fill in your name!");
		//Check++;
		return false;
	}


	else if ((Country == "Enter the name of your country") || (Country == ""))
	{
		alert("Please state the country that you are currently residing in!");
		//Check++;
		return false;
	}

	else if (Comments == "")
	{
		alert("Please do give us some comments!");
		//Check++;
		return false;
	}

}