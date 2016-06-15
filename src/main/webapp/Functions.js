function cancelButton(){
	document.getElementById("Name").value="";
	document.getElementById("Adddress").value="";
	document.getElementById("PAN").value="";
	document.getElementById("Year").value="";
	document.getElementById("Income").value="";
	document.getElementById("TDS").value="";
	document.getElementById("Tax").value="";
	document.getElementById("DOB").value="";
}

function calculateTds(){
	var Income = document.getElementById("Income").value;
	
			TDS = Income * 0.08;
			document.getElementById("TDS").value = TDS;
	        doucment.getElementById("TDS").focus ();
			return TDS;
			
	}
	
 function calculateTax(){
	var Income = document.getElementById("Income").value;

	if(Income >=0 && Income <=250000){
				per = 0.0;
			}
			else if (Income > 250000 && Income<=500000) {
				Income = Income - 250000;
						per = 0.1;
			}
			else if (Income > 500000 && Income<=1000000) {
				Income = Income - 250000;
						per = 0.2;
			}
			else if (Income > 1000000 ) {
				Income = Income - 250000;
						per = 0.3;
			}
			
	        Tax = Income * per;
			document.getElementById("Tax").value = Tax;
	        doucment.getElementById("Tax").focus ();
			return Tax;
	}