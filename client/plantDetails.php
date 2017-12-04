<?php
include_once("connection.php");
if (isset ($_POST['txtScientificName'])){
	
	$scientificName = $_POST['txtScientificName'];
	
	$query = "SELECT * FROM planta WHERE nomeCientifico='$scientificName';";
		
	$result = mysqli_query($conn, $query);
	
	$response = array();
	
	while($row = mysqli_fetch_array($result)) {
		array_push($response, array("nomeCientifico"=>$row[0], 
									"nomePopular"=>$row[1],
									"rega"=>$row[2],
									"exposicaoSolar"=>$row[3],
									"adubagem"=>$row[4],
									"poda"=>$row[5],
									"pragas"=>$row[6],
									"doencas"=>$row[7],
									"descricao"=>$row[8]));
		// pares nome-valor, formados por "tag"=>valor
	}
	
	echo json_encode(array("server_response"=>$response));
	
	$conn->close();
}
?>