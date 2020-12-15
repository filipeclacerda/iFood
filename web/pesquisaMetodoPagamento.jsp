<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <title>SCP</title>
    </head>
    <body>

        <div class="container">

            <div class="page-header">
                <h1>Pesquisa de Método Pagamentos</h1>
            </div>

            <table class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th>ID Método Pagamento</th>
                        <th>Nome Método Pagamento</th>

                        <th colspan=2>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${metodoPagamentos}" var="metodoPagamento">
                        <tr>
                            <td><c:out value="${metodoPagamento.idMetodoPagamento}" /></td>
                            <td><c:out value="${metodoPagamento.nomeMetodoPagamento}" /></td>                            
                            <td><a class="btn btn-primary btn-sm" href=
                                   "ManterMetodoPagamentoController?acao=prepararOperacao&operacao=Editar&idMetodoPagamento=<c:out value="${metodoPagamento.idMetodoPagamento}"/>">Editar</a></td>
                            <td><a class="btn btn-danger btn-sm" href=
                                   "ManterMetodoPagamentoController?acao=prepararOperacao&operacao=Excluir&idMetodoPagamento=<c:out value="${metodoPagamento.idMetodoPagamento}"/>">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterMetodoPagamentoController?acao=prepararOperacao&operacao=Incluir" 
                  method="post">
                <input class="btn btn-success" type="submit" name="btnIncluir" value="Incluir">
            </form>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
