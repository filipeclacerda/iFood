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
                <h1>Manter Cupom - ${operacao}</h1>
            </div>

            <div class="row">
                <div class="col-sm-8">

                    <form action="ManterCupomController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterCupom">

                        <div class="form-group">
                            <label for="txtCodCupom">Código do cupom</label>
                            <input type="number" class="form-control" id="txtCodCupom" name="txtIdCupom" value="${cupom.idCupom}" <c:if test="${operacao != 'Incluir'}">readonly</c:if> required>
                        </div>

                        <div class="form-group">
                            <label for="txtNomeCupom">Descrição do cupom</label>
                            <input type="text" class="form-control" id="txtNomeCupom" name="txtNomeCupom" value="${cupom.descricao}" <c:if test="${operacao == 'Excluir'}">readonly</c:if> required> 
                        </div>

                        <div class="form-group">
                            <label for="txtPrecoCupom">Preço do cupom</label>
                            <input type="number" step="0.01" class="form-control" id="txtPrecoCupom" name="txtValor" value="${cupom.valor}" <c:if test="${operacao == 'Excluir'}">readonly</c:if> required> 
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
