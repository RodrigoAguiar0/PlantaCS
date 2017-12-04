<?php
include_once("connection.php");
	
	$query = "SELECT nomeCientifico, nomePopular FROM planta;";
		
	$result = mysqli_query($conn, $query);
	
	$response = array();
	
	while($row = mysqli_fetch_array($result)) {
		array_push($response, array("nomeCientifico"=>$row[0], "nomePopular"=>$row[1]));
		// pares nome-valor, formados por "tag"=>valor
	}
	
	echo json_encode(array("server_response"=>$response));
	
	$conn->close();
?>