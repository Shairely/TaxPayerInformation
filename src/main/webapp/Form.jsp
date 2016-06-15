
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>
<script type="text/javascript" src="datepicker.js"></script>
<script type="text/javascript" src="validations.js"></script>
<script type="text/javascript" src="Functions.js"></script>

</head>
<body>  
<form action="formServlet" name="formServlet" method="post">  
 <h1>
<center> Personal Information</center></h1>
<br>
<br>
<table border="0">
<tr>
<td id="msgId" style="color: red; font-family: arial;font-size: 12px;">
</td>
</tr>
</table>
<table border="0" align="center" width="500px">
<tr>
<td width="40%">Name:</td><td width="60%"><input type="text" size="50%" name="Name" align="left" border="0" width="100%" id="Name" onblur="nameValidate()"/></td> 
</tr>
 <tr>
<td>Address:</td><td  width="100%"><textarea  name="Adddress" id="Adddress" ></textarea></td> 
</tr>

<tr>
<td>PAN :</td><td><input type="text" name="PAN" size="50%" align="left" id="PAN" onblur="panValidate()"/></td> 
</tr>
<tr>
<td>DOB: (dd/mm/yyyy)  </td><td>
<!-- <input type="text" name="DOB" size="50%"  align="left" id="datepicker" onblur="dateFormatValidate()"/> -->
<input name="ExpiryDate" type="text" name="exp_date" id="exp_date" size="10" maxlength="10" />
<img src="../images/date.png" onClick="displayDatePicker('exp_date');">
</td> 
</tr>
<tr>
<td>Assessment Year:</td><td><input type="text" size="50%" name="Year" align="left" id="Year" onblur="assessmentYearValidate()" /></td> 
</tr>
<tr>
<td>Income:</td><td><input type="text" name="Income" size="50%" align="left" id="Income" onblur="calculateTds()"  /></td> 
</tr>
<tr>
<td>TDS:</td><td><input type="text" name="TDS" size="50%"  align="left" id="TDS"  onblur="calculateTax()" readonly="readonly"/></td> 
</tr>
<tr>
<td >Tax Deducted:</td><td><input type="text" name="Tax" size="50%"  align="left" id="Tax" readonly="readonly" /></td> 
</tr> 
</table>  
<br/><br/>  
<table align="center">
<tr>
<td><input type="submit" value="save" align="middle" onclick="return validateForm()"/> 
</td>
<td><input type="button" value="cancel" align="middle" onclick="cancelButton()"/> 
</td>
</tr>
</table>
 
  
</form>  
</body>  
</html>  