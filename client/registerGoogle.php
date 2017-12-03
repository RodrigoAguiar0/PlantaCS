<?php
include_once("connection.php");
if (isset ($_POST['txtEmail']) && 
  isset ($_POST['txtName'])){
	$email = $_POST['txtEmail'];
	$name = $_POST['txtName'];
	
	$query = "INSERT INTO usuario SET email='$email', nome='$name'";
	//INSERT INTO usuario (email, nome) VALUES ("rbpaludo@gmail.com", "rbpaludo@gmail.com")
	if($conn->query($query) === TRUE) {
		echo "success - register";
	} else {
		echo "fail - register: "  . $query . "\n" . $conn->error;
		// adicionar '  . $query . "\n" . $conn->error' para um relatório mais detalhado da falha de cadastro
	}
	$conn->close();
}
?>