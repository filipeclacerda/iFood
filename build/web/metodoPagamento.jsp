<html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
    <%@include  file="navbar.html" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Metodo Pagamento</title>

    </head>
    <body>
        <div class="container">

            <div class="d-flex flex-row">
                <div class="col p-2">
                    <h1>Metodo Pagamento</h1>
                    <form>
                        <label for="fid">ID:</label><br>
                        <input type="number" id="fid" name="fid" min="1" max="1000"><br>
                        <label for="lmetodo">Metodo Pagamento:</label><br>
                        <input type="text" id="lmetodo" name="lmetodo"><br>
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