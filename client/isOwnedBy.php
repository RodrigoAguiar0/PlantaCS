<?php
include_once("connection.php");
if (isset ($_POST['txtUsername']) &&
	isset ($_POST['txtScientificName'])){
	
	$username = $_POST['txtUsername'];
	$scientificName = $_POST['txtScientificName'];
	
	$query = "SELECT * FROM jardim WHERE planta_nomeCientifico='$scientificName' AND usuario_pessoa_id=(
				SELECT pessoa_id FROM usuario WHERE username='$username');";
		
	$result = mysqli_query($conn, $query);
	
	if ($result->num_rows > 0) {
		echo "own - true";
	} else {
		echo "own - false";
	}
	
	$conn->close();
}
?>