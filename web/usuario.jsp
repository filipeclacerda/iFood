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
                <h1>Manter Cliente - ${operacao}</h1>
            </div>

            <div class="row">
                <div class="col-sm-8">

                    <form action="ManterClienteController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterCliente">

                        <div class="form-group">
                            <label for="txtCodCliente">Código do cliente</label>
                            <input type="number" class="form-control" id="txtCodCliente" name="txtCodCliente" value="${cliente.codigo}" <c:if test="${operacao != 'Incluir'}">readonly</c:if> required>
                        </div>

                        <div class="form-group">
                            <label for="txtNomeCliente">Nome do cliente</label>
                            <input type="text" class="form-control" id="txtNomeCliente" name="txtNomeCliente" value="${cliente.nome}" <c:if test="${operacao == 'Excluir'}">readonly</c:if> required> 
                        </div>
                        <div class="form-group">
                            <label for="txtEmailCliente">Email do cliente</label>
                            <input type="email" class="form-control" id="txtEmailCliente" name="txtEmailCliente" value="${cliente.email}" <c:if test="${operacao == 'Excluir'}">readonly</c:if> required> 
                        </div>
                        <div class="form-group">
                            <label for="txtTelefone">Telefone</label>
                            <input type="text" class="form-control" id="txtEmailCliente" name="txtTelefone" value="${cliente.telefone}" <c:if test="${operacao == 'Excluir'}">readonly</c:if> required> 
                        </div>
                        <div class="form-group">
                            <label for="txtLogradouro">Logradouro</label>
                            <input type="text" class="form-control" id="txtNomeCliente" name="txtLogradouro" value="${cliente.logradouro}" <c:if test="${operacao == 'Excluir'}">readonly</c:if> required> 
                        </div>
                        <div class="form-group">
                            <label for="txtNumero">Número</label>
                            <input type="text" class="form-control" id="txtNomeCliente" name="txtNumero" value="${cliente.numero}" <c:if test="${operacao == 'Excluir'}">readonly</c:if> required> 
                        </div>
                        <div class="form-group">
                            <label for="txtBairro">Bairro</label>
                            <input type="text" class="form-control" id="txtNomeCliente" name="txtBairro" value="${cliente.bairro}" <c:if test="${operacao == 'Excluir'}">readonly</c:if> required> 
                        </div>
                        <div class="form-group">
                            <label for="txtCidade">Cidade</label>
                            <input type="text" class="form-control" id="txtNomeCliente" name="txtCidade" value="${cliente.cidade}" <c:if test="${operacao == 'Excluir'}">readonly</c:if> required> 
                        </div>
                        <div class="form-group">
                            <label for="txtEstado">Estado</label>
                            <input type="text" class="form-control" id="txtNomeCliente" name="txtEstado" value="${cliente.estado}" <c:if test="${operacao == 'Excluir'}">readonly</c:if> required> 
                        </div>
                        
                        
                        
                        <button type="submit" class="btn btn-success">Confirmar</button>
                    </form>
                </div>
            </div>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
