
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title> AAMC ♡ </title>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card border-info">
                <div class="card-header bg-info">
                    <h4>Actualizar Datos del Libro</h4>
                </div>
                <div class="card-body">
                    <form method="POST">
                        <label>Nombre del Libro</label>
                        <input type="text" name="nombreLibro" class="form-control" value="${lista[0].NombreDelLibro}">
                        <label>Autor</label>
                        <input type="text" name="autor" class="form-control" value="${lista[0].Autor}">
                        <label>Fecha de Publicacion</label>
                        <input type="text" name="publicacion" class="form-control" value="${lista[0].FechaPublicacion}"><br>
                        <input type="submit" value="Actualizar" class="btn btn-success">
                        <a href="index.htm">Regresar</a>
                    </form>
                </div>
            </div>
    </body>
</html>
