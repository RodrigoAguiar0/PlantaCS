<?php
include_once("connection.php");
if (isset($_POST['txtEmail'])){
	$email = $_POST['txtEmail'];
	
	$query = "SELECT email FROM usuario WHERE email = '$email'";
	
	$result = mysqli_query($conn, $query);
	
	if ($result->num_rows > 0){
		echo "success - login";
	} else {
		echo "fail - Google login - '$email'";
	}
}
?>