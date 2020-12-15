<html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
    <%@include  file="navbar.html" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Restaurante</title>

    </head>
    <body>
        <div class="container">

            <div class="d-flex flex-row">
                <div class="col p-2">
                    <h1>Restaurante</h1>
                    <form>
                        <label for="fcodigo">Codigo:</label><br>
                        <input type="number" id="fcodigo" name="fcodigo" min="1" max="1000"><br>
                        <label for="lname">Nome do Restaurante:</label><br>
                        <input type="text" id="lname" name="lname"><br>
                        <label for="ltel">Telefone:</label><br>
                        <input type="text" id="ltel" name="ltel"><br>
                        <label for="lmail">Logradouro:</label><br>
                        <input type="text" id="llogradouro" name="llogradouro"><br>
                        <label for="lmail">Cidade:</label><br>
                        <input type="text" id="lcidade" name="lcidade"><br>
                        <label for="lmail">Estado:</label><br>
                        <input type="text" id="lestado" name="lestado"><br>
                        <label for="lmail">Numero:</label><br>
                        <input type="number" id="lnumero" name="lnumero"><br>
                        <label for="lcategoria">Categoria:</label><br>
                        <select name="lcategoria" id="lcategoria">
                            <option value=""></option>
                        </select>
                        <div align="right">
                            <button type="submit" class="btn btn-primary">Enviar</button> </div>
                        <br>
                    </form>
                </div>  
                <div class="col p-2"></div>
            </div>
        </div>
    </body>
</html>
