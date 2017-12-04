<?php
include_once("connection.php");
if (isset($_POST['txtUsername']) && 
  isset ($_POST['txtNomeCientifico'])){
	
	$username = $_POST['txtUsername'];
	$nomeCientifico = $_POST['txtNomeCientifico'];
	
	$query = "INSERT INTO jardim (planta_nomeCientifico, usuario_pessoa_id) VALUES ('$nomeCientifico', (
		SELECT pessoa_id FROM usuario WHERE username='$username')
		);";
	
	if($conn->query($query) === TRUE) {
		echo "success - jardim";
	} else {
		echo "fail - jardim - "  . $query . "\n" . $conn->error;
		//adicionar ' . $query . "\n" . $conn->error' para um relatório mais detalhado da falha de cadastro
	}
	$conn->close();
}
?>