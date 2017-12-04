<?php
include_once("connection.php");
if (isset ($_POST['txtUsername'])){
	
	$username = $_POST['txtUsername'];
	
	$query = "SELECT nomeCientifico, nomePopular
		FROM planta
		INNER JOIN (
			SELECT planta_nomeCientifico FROM jardim WHERE usuario_pessoa_id=(
				SELECT pessoa_id FROM usuario WHERE username LIKE '$username'
			)) AS jardimPessoal 
		ON planta.nomeCientifico=jardimPessoal.planta_nomeCientifico;";
		
	$result = mysqli_query($conn, $query);
	
	$response = array();
	
	while($row = mysqli_fetch_array($result)) {
		array_push($response, array("nomeCientifico"=>$row[0], "nomePopular"=>$row[1]));
		// pares nome-valor, formados por "tag"=>valor
	}
	
	echo json_encode(array("server_response"=>$response));
	
	$conn->close();
}
?>