<?php
if($_SERVER["REQUEST_METHOD"]=="GET"){
    require_once 'Conexion.php';
    $nombre=$_GET["Nick"];
  //  $pass=$_POST["Pass"];

    $select="SELECT*FROM usuario WHERE Nick == '".$nombre."'";
    $resultado=$mysqlConexion->query($select);
    while($row=$resultado->fetch_assoc()){
        $array=$row;
    }
    echo json_encode($array);
}else{
    echo "No hay registros";
}
