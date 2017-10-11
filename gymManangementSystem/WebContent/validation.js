
function validate(){

	var name = document.getElementById("name").value;

	var kinId = document.getElementById("kinId").value;
	var email = document.getElementById("email").value;
	var phone = document.getElementById("phone").value;
	var dob = document.getElementById("dob").value;
	var doj = document.getElementById("doj").value;
	var add = document.getElementById("add").value;

	if (name==""|| kinId==""|| email==""|| dob==""|| doj==""|| add=="") {

		document.getElementById("texting").innerHTML = " empty data not accpted";
		return false;

	}
	else
	{

		if(isNaN(phone)){
			document.getElementById("texting").innerHTML = "phone must be number";

			return false;
		}

		else{
			window.location.href ='/main';
		//	return true;

		}    

	}
}