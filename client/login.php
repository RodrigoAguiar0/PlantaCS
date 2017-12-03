<?php
include_once("connection.php");
if (isset($_POST['txtUsername']) && isset ($_POST['txtPassword'])){
	$username = $_POST['txtUsername'];
	$password = $_POST['txtPassword'];
	
	$query = "SELECT username, password, email FROM usuario WHERE username = '$username' AND password = '$password'";
	
	$result = mysqli_query($conn, $query);
	
	if ($result->num_rows > 0){
		echo "success - login";
	} else {
		echo "fail - login";
	}
}
?>