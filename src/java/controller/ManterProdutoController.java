/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.ProdutoModel;
import model.Restaurante;

/**
 *
 * @author Marco
 */
public class ManterProdutoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("restaurantes", Restaurante.obterRestaurantes());
            if (!operacao.equals("Incluir")) {
                int codProduto = Integer.parseInt(request.getParameter("codProduto"));
                ProdutoModel produto = ProdutoModel.obterProduto(codProduto);
                request.setAttribute("produto", produto);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterProduto.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");
        int codigo = Integer.parseInt(request.getParameter("txtCodProduto"));
        String nome = request.getParameter("txtNomeProduto");
        Float preco = Float.parseFloat(request.getParameter("txtPrecoProduto"));
        String descricao = request.getParameter("txtDescricao");
        int idRestaurante = Integer.parseInt(request.getParameter("txtIdRestaurante"));

            try {
            Restaurante restaurante = null;
             if (idRestaurante != 0 ) {
             restaurante = Restaurante.obterRestaurante(idRestaurante);
             }
             
            ProdutoModel produto = new ProdutoModel (codigo, nome, preco,descricao, restaurante);
            if (operacao.equals("Incluir")) {
                produto.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    produto.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        produto.excluir();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaProdutoController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
