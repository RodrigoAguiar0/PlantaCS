<?php
include_once("connection.php");
if (isset($_POST['txtUsername']) && 
  isset ($_POST['txtNomeCientifico'])){
	
	$username = $_POST['txtUsername'];
	$nomeCientifico = $_POST['txtNomeCientifico'];
	
	$query = "DELETE FROM jardim WHERE planta_nomeCientifico='$nomeCientifico' AND usuario_pessoa_id=(SELECT pessoa_id FROM usuario WHERE username='$username');";
	
	if($conn->query($query) === TRUE) {
		echo "success - remocao";
	} else {
		echo "fail - remocao - "  . $query . "\n" . $conn->error;
		//adicionar ' . $query . "\n" . $conn->error' para um relatório mais detalhado da falha de cadastro
	}
	$conn->close();
}
?>