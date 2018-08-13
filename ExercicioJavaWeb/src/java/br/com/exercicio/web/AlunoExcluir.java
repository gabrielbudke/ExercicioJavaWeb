/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exercicio.web;

import br.com.exercicio.dao.AlunoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gabriel Budke
 */

@WebServlet(urlPatterns = "/alunos/excluir")
public class AlunoExcluir extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        boolean apagou = new AlunoDAO().excluir(id);

        if (apagou) {
            resp.sendRedirect("/ExercicioJavaWeb/alunos");

        } else {
            resp.getWriter().print("Não foi possível apagar");
        }

    }

}
