function validateForm(){
	
	if(document.getElementById("Name").value==""){
		document.getElementById("msgId").innerHTML="Name cannot be null";
		return false;
	}
	else if(document.getElementById("Adddress").value==""){
		document.getElementById("msgId").innerHTML="Adddress cannot be null";
		return false;
	}
	
	else if(document.getElementById("PAN").value=="")
	{document.getElementById("msgId").innerHTML="PAN cannot be null";
	return false;
		
	}	
	else if (document.getElementById("DOB").value=="")
	{
		document.getElementById("msgId").innerHTML="DOB cannot be null";
		return false;
	}
	else if(document.getElementById("Year").value==""){
		document.getElementById("msgId").innerHTML="Assessment Year cannot be null";
		return false;
	}
	else if(document.getElementById("Income").value=="")
	{
		document.getElementById("msgId").innerHTML="Income cannot be null";
		return false;
	}
	else if(document.getElementById("TDS").value=="")
	{
		document.getElementById("msgId").innerHTML="TDS cannot be null";
		return false;
	}	
	else if(document.getElementById("Tax").value=="")
	{document.getElementById("msgId").innerHTML="Tax cannot be null";
	return false;
		
	}
	if((!dateFormatValidate() ||!dateFormatValidate()|| !assessYearValidate()||! nameValidate()||!incomeValidate()||! tdsValidate() ||!taxValidate()  ) )
	{
		alert('wrong condition');
	return false;	
	}
	else
		document.forms["formServlet"].reset();
		return true;
}

function nameValidate(){
	
	var name=document.getElementById("Name").value;
	 var iChars = "~`!@#$%^&*+=-[]\\\';,/{}|\":<>?";

	    for (var i = 0; i < name.length; i++) {
	       if (iChars.indexOf(name.charAt(i)) != -1) {
	    	   
	    	   document.getElementById("msgId").innerHTML="Special Characters in Name not allowed";
	           return false;
	       }
	    }
	    
	    return true;
}

function panValidate(){
	panValue=document.getElementById("PAN").value;
	if(panValue!=""){
		if(panValue.length!=10  ){
			document.getElementById("msgId").innerHTML="PAN value entered is incorrect";
			return false;
		}
		else{
			document.getElementById("msgId").innerHTML="";
			var panPat = /^([a-zA-Z]{5})(\d{4})([a-zA-Z]{1})$/;
			 if (panValue.search(panPat) == -1) {
				 document.getElementById("msgId").innerHTML="Invalid Pan No";
	            
	             return false;
	         }
			 else{
				 document.getElementById("msgId").innerHTML="";
				 return true;
			 }
		}
	}
}




function assessmentYearValidate(){
	var assessYear=document.getElementById("Year").value;
	if((isNaN(assessYear)||assessYear.length!=4||assessYear<1900 ||assessYear>2016) && assessYear!=""){
		document.getElementById("msgId").innerHTML="Year value entered is incorrect";
		return false;
	}
	else
	{
		document.getElementById("msgId").innerHTML="";
		return true;
	}	
}



function incomeValidate(){
	var income=document.getElementById("Income").value;
	if(isNaN(income)){
		 document.getElementById("msgId").innerHTML="Invalid Income entered";
		 return false;
	}
	else{
		 document.getElementById("msgId").innerHTML="";
		return true;
	}
}
