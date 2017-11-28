<?php
include_once("connection.php");
if (isset($_POST['txtUsername']) && 
  isset ($_POST['txtPassword']) && 
  isset ($_POST['txtEmail']) && 
  isset ($_POST['txtName'])){
	$username = $_POST['txtUsername'];
	$password = $_POST['txtPassword'];
	$email = $_POST['txtEmail'];
	$name = $_POST['txtName'];
	
	$query = "INSERT INTO usuario SET username='$username', email='$email', password='$password', nome='$name'";
	
	if($conn->query($query) === TRUE) {
		echo "success - cadastro";
	} else {
		echo "fail - cadastro - "  . $query . "\n" . $conn->error;
		//adicionar ' . $query . "\n" . $conn->error' para um relatório mais detalhado da falha de cadastro
	}
	$conn->close();
}
?>