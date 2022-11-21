<?php
if($_SERVER["REQUEST_METHOD"]=="POST"){
    require_once 'Conexion.php';
    $nick=$_POST["Nick"];
    $email=$_POST["Email"];
    $pass=$_POST["Pass"];
    $calificacion=$_POST["Calificacion"];
    $errores=$_POST["Errores"];
    $aciertos=$_POST["Aciertos"];
    $InsertU="INSERT INTO usuario(Nick,Email,Pass,Calificacion,Errores,Aciertos) VALUES('$nick','$email','$pass','$calificacion','$errores','$aciertos')";
    $resultado=$mysqlConexion->query($InsertU);
    if($mysqlConexion->affected_rows>0){
    echo "exito";
}else{
    echo "error";
}
}
