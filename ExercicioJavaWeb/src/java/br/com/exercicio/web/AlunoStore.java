package br.com.exercicio.web;

import br.com.exercicio.bean.AlunoBean;
import br.com.exercicio.dao.AlunoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gabriel Budke
 */
public class AlunoStore extends HttpServlet {

    private float nota1, nota2, nota3, nota4, media;
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        nota1 = Float.parseFloat(req.getParameter("nota1"));
        
        
        
        
        
        AlunoBean aluno = new AlunoBean();
        aluno.setNome(req.getParameter("nome"));
        aluno.setCodigo_matricula(req.getParameter("matricula"));
        aluno.setNota1(Float.parseFloat(req.getParameter("nota1")));
        aluno.setNota_2(Float.parseFloat(req.getParameter("nota2")));
        aluno.setNota_3(Float.parseFloat(req.getParameter("nota3")));
        aluno.setNota_4(Float.parseFloat(req.getParameter("nota4")));
        int codigo = new AlunoDAO().adicionar(aluno);
    
    
    
    }
    
    
            
    
}
