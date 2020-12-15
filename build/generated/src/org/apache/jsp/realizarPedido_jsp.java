package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class realizarPedido_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-br\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("        <title>IFood</title>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("\n");
      out.write("                adicionar = function () {\n");
      out.write("\n");
      out.write("                    if ($(\"#quantidade\").val() != 0) {\n");
      out.write("                        var valorTotal = parseFloat($(\"#valorTotal\").text());\n");
      out.write("                        var linha = $(\"<tr>\");\n");
      out.write("                        var colunas = \"\";\n");
      out.write("                        var opcao = $(\"#produto\").find(\"option:selected\");\n");
      out.write("                        valorTotal = valorTotal + (opcao.data('preco') * $(\"#quantidade\").val());\n");
      out.write("                        colunas += '<td style=\"visibility:hidden;\" data-cod-produto=' + $(\"#produto\").val() + '>' + $(\"#produto\").val() + '</td>';\n");
      out.write("                        colunas += '<td>' + opcao.data('nome') + '</td>';\n");
      out.write("                        colunas += '<td data-quantidade=' + $(\"#quantidade\").val() + '>' + $(\"#quantidade\").val() + '</td>';\n");
      out.write("                        colunas += '<td data-preco=' + opcao.data('preco') + '>' + opcao.data('preco') + '</td>';\n");
      out.write("                        colunas += '<td><button type=\"button\" class=\"btn btn-danger btn-xs\" onclick=\"remover(this)\">Excluir <span class=\"glyphicon glyphicon-trash\"></span></button></td>';\n");
      out.write("                        colunas += '</tr>';\n");
      out.write("                        linha.append(colunas);\n");
      out.write("                        $(\"#tabela\").append(linha);\n");
      out.write("                        $(\"#quantidade\").val(null);\n");
      out.write("\n");
      out.write("                        $(\"#valorTotal\").text(valorTotal);\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                remover = function (item) {\n");
      out.write("                    var valorTotal = parseFloat($(\"#valorTotal\").text());\n");
      out.write("                    var tr = $(item).closest('tr');\n");
      out.write("\n");
      out.write("                    var quantidade = tr.find('td[data-quantidade]').data('quantidade');\n");
      out.write("                    var preco = tr.find('td[data-preco]').data('preco');\n");
      out.write("                    valorTotal = valorTotal - (quantidade * preco);\n");
      out.write("\n");
      out.write("                    $(\"#valorTotal\").text(valorTotal);\n");
      out.write("                    tr.remove();\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                $(\"#cliente\").change(function () {\n");
      out.write("                    $(\"#tabela tr\").remove();\n");
      out.write("                    var linha = $(\"<tr>\");\n");
      out.write("                    var colunas = \"\";\n");
      out.write("                    colunas += '<td style=\"visibility:hidden;\">Código</td>';\n");
      out.write("                    colunas += '<td>Produto</td>';\n");
      out.write("                    colunas += '<td>Quantidade</td>';\n");
      out.write("                    colunas += '<td>Preço Unit.</td>';\n");
      out.write("                    colunas += '<td>Ação</td>';\n");
      out.write("                    colunas += '</tr>';\n");
      out.write("                    linha.append(colunas);\n");
      out.write("                    $(\"#tabela\").append(linha);\n");
      out.write("                    $(\"#valorTotal\").text(0);\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                finalizar = function () {\n");
      out.write("                    var itensProdutos = \"\";\n");
      out.write("                    var itensQuantidades = \"\";\n");
      out.write("                    var itensPrecos = \"\";\n");
      out.write("                    $(\"#tabela\").find('tr').next('tr').each(function () {\n");
      out.write("                        itensProdutos = itensProdutos + $(this).find('td[data-cod-produto]').data('cod-produto') + \";\";\n");
      out.write("                        itensQuantidades = itensQuantidades + $(this).find('td[data-quantidade]').data('quantidade') + \";\";\n");
      out.write("                        itensPrecos = itensPrecos + $(this).find('td[data-preco]').data('preco') + \";\";\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                    $.ajax({\n");
      out.write("                        url: 'EfetuarPedidoController?acao=confirmar',\n");
      out.write("                        method: 'POST',\n");
      out.write("                        data: {cliente: $(\"#cliente\").val(),\n");
      out.write("                            obs: $(\"#obs\").val(),\n");
      out.write("                            troco: $(\"#troco\").val(),\n");
      out.write("                            cupom: $(\"#cupom\").val(),\n");
      out.write("                            metodo: $(\"#metodo\").val(),\n");
      out.write("                            itensProdutos: itensProdutos,\n");
      out.write("                            itensQuantidades: itensQuantidades,\n");
      out.write("                            itensPrecos: itensPrecos,\n");
      out.write("                            valorTotal: parseFloat($(\"#valorTotal\").text())},\n");
      out.write("                        success: function (resposta) {\n");
      out.write("                            alert(\"Numero do Pedido = \" + resposta);\n");
      out.write("                            location.reload();\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                };\n");
      out.write("                 var testCupom = false;\n");
      out.write("             aplicarCupom = function () {\n");
      out.write("                var valorTotal = parseFloat($(\"#valorTotal\").text());\n");
      out.write("                var cupom = parseFloat($(\"#cupom\").val());\n");
      out.write("                var opcao = $(\"#cupom\").find(\"option:selected\");\n");
      out.write("                var cupom = opcao.data('valor');\n");
      out.write("                if (testCupom === false) {\n");
      out.write("\n");
      out.write("                    valorTotal = valorTotal - cupom;\n");
      out.write("                   $(\"#valorTotal\").text(valorTotal);\n");
      out.write("                    testCupom = true;\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("            document.getElementById(\"hellobutton\").addEventListener(\"click\", hello);\n");
      out.write("            });\n");
      out.write("        </script>   \n");
      out.write("        <script>\n");
      out.write("           \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-12 page-header\">\n");
      out.write("                    <h1 class=\"header\">Efetuar Pedido</h1>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-6\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"cliente\">Cliente</label>\n");
      out.write("                        <select class=\"form-control\" id=\"cliente\" name=\"cliente\">\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"produto\">Produto</label>\n");
      out.write("                        <select class=\"form-control\" id=\"produto\" name=\"produto\">\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"quantidade\">Quantidade</label>\n");
      out.write("                        <input type=\"number\" id=\"quantidade\" name=\"quantidade\" class=\"form-control\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"quantidade\">Observação:</label>\n");
      out.write("                        <input type=\"text\" id=\"obs\" name=\"obs\" class=\"form-control\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"quantidade\">Troco</label>\n");
      out.write("                        <input type=\"number\" id=\"troco\" name=\"troco\" class=\"form-control\">\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"produto\">Cupom</label>\n");
      out.write("                        <select class=\"form-control\" id=\"cupom\" name=\"cupom\">\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </select><br>\n");
      out.write("                        <button onclick=\"aplicarCupom()\" type=\"button\" class=\"btn btn-primary\">Aplicar Cupom</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"produto\">Método de Pagamento</label>\n");
      out.write("                        <select class=\"form-control\" id=\"metodo\" name=\"metodo\">\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <button onclick=\"adicionar()\" type=\"button\" class=\"btn btn-primary\">Adicionar Item</button>\n");
      out.write("                    <br><br>\n");
      out.write("                    <center>\n");
      out.write("                        \n");
      out.write("                        <button type=\"button\"  class=\"btn btn-success\">Finalizar Pedido</button>\n");
      out.write("                    </center>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-6\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <h2 align=\"right\">\n");
      out.write("                            Valor Total - R$\n");
      out.write("                            <label id=\"valorTotal\" name=\"valorTotal\">0</label>\n");
      out.write("                        </h2>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <table class=\"table table-striped table-bordered table-hover table-condensed\" id=\"tabela\" name=\"tabela\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td style=\"visibility:hidden;\">Código</td>\n");
      out.write("                                <td>Produto</td>\n");
      out.write("                                <td>Quantidade</td>\n");
      out.write("                                <td>Preço Unit.</td>\n");
      out.write("                                <td>Ação</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientes}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("umCliente");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${umCliente.codigo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${umCliente.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>  \n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produtos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("umProduto");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${umProduto.codigo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" \n");
          out.write("                                        data-nome=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${umProduto.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"\n");
          out.write("                                        data-preco=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${umProduto.preco}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${umProduto.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>  \n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cupoms}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVar("cupom");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cupom.idCupom}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"\n");
          out.write("                                        data-valor=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cupom.valor}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cupom.descricao}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>  \n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_3.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_3.setParent(null);
    _jspx_th_c_forEach_3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${metodopagamentos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_3.setVar("metodoPagamento");
    int[] _jspx_push_body_count_c_forEach_3 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_3 = _jspx_th_c_forEach_3.doStartTag();
      if (_jspx_eval_c_forEach_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${metodoPagamento.idMetodoPagamento}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${metodoPagamento.nomeMetodoPagamento}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>  \n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_3.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_3);
    }
    return false;
  }
}
