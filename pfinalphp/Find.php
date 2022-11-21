<?php
if($_SERVER["REQUEST_METHOD"]=="GET"){
    require_once 'Conexion.php';
    $nick=$_GET["Nick"];
    $pass=$_GET["Pass"];

    $select="SELECT*FROM usuario WHERE Nick = '$nick' and Pass= '$pass' ";
    $resultado=$mysqlConexion->query($select);
    if($mysqlConexion->affected_rows>0){
    while($row=$resultado->fetch_assoc()){
        $array=$row;
        echo json_encode($array);
    }
}else{
    echo "No hay registros";
}
}

