<html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
    <%@include  file="navbar.html" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Prato</title>

    </head>
    <body>
        <div class="container">

            <div class="d-flex flex-row">
                <div class="col p-2">
                    <h1>Prato</h1>
                    <form>
                        <label for="fidprato">IDPrato:</label><br>
                        <input type="number" id="fidprato" name="fidprato" min="1" max="1000"><br>
                        <label for="lpreco">Preço:</label><br>
                        <input type="text" id="lpreco" name="lpreco"><br>
                        <label for="lnomePrato">Nome Prato:</label><br>
                        <input type="text" id="lnomePrato" name="lnomePrato"><br>
                        <label for="lrestaurante">Restaurante:</label><br>
                        <select name="lrestaurante" id="lrestaurante">
                                <option value=""></option>
                        </select><br>
                        <label for="ldescricao">Descriçao:</label><br>
                        <textarea id="ldescricao" name="ldescricao" rows="4" cols="50"></textarea><br>
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