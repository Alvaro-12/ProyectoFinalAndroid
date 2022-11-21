<?php
$mysqlConexion = new mysqli("localhost","root","","pfinal");
if($mysqlConexion->connect_error){
    die ("Error de conexion");
}