package br.com.exercicio.web;

import br.com.exercicio.bean.AlunoBean;
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
@WebServlet (urlPatterns = "/alunos/update")
public class AlunoUpdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        AlunoBean aluno = new AlunoBean();
        aluno.setId(Integer.parseInt(req.getParameter("id")));
        aluno.setNome(req.getParameter("nome"));
        aluno.setCodigoMatricula("matricula");
        aluno.setNota1(Float.parseFloat(req.getParameter("nota1")));
        aluno.setNota2(Float.parseFloat(req.getParameter("nota2")));
        aluno.setNota3(Float.parseFloat(req.getParameter("nota3")));
        aluno.setNota4(Float.parseFloat(req.getParameter("nota4")));
        aluno.calcularMedia();

        if (aluno.calcularMedia() < 5) {
            aluno.setSituacao("REPROVADO");
        } else if (aluno.calcularMedia() >= 6 && aluno.calcularMedia() < 7) {
            aluno.setSituacao("EXAME");
        } else {
            aluno.setSituacao("APROVADO");
        }
        
        boolean alterou = new AlunoDAO().alterar(aluno);

    }

}
