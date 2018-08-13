package br.com.exercicio.web;

import br.com.exercicio.bean.AlunoBean;
import br.com.exercicio.dao.AlunoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gabriel Budke
 */
@WebServlet(urlPatterns = "/alunos")
public class AlunoIndex extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<AlunoBean> alunos = new AlunoDAO().obterTodos();

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("	<title>Alunos</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div>");
        out.println("<a href='/ExercicioJavaWeb/alunos/cadastro'>Novo</a>");
        out.println("</div>");
        out.println("<div>");
        out.println("	<table>");
        out.println("		<thead>");
        out.println("			<th>Código Matrícula</th>");
        out.println("			<th>Nome</th>");
        out.println("			<th>Nota1</th>");
        out.println("			<th>Nota2</th>");
        out.println("			<th>Nota3</th>");
        out.println("			<th>Nota4</th>");
        out.println("			<th>Média</th>");
        out.println("			<th>Frequencia</th>");
        out.println("			<th>Situação</th>");
        out.println("		</thead>");
        out.println("		<tbody>");

        for (AlunoBean aluno : alunos) {
        out.println("               <tr>");
        out.println("			<td>" + aluno.getCodigoMatricula()+ "</td>");
        out.println("			<td>" + aluno.getNome() + "</td>");
        out.println("			<td>" + aluno.getNota1() + "</td>");
        out.println("			<td>" + aluno.getNota2() + "</td>");
        out.println("			<td>" + aluno.getNota3() + "</td>");
        out.println("			<td>" + aluno.getNota4() + "</td>");
        out.println("			<td>" + aluno.getMedia() + "</td>");
        out.println("			<td>" + aluno.getFrequencia() + "</td>");
        out.println("			<td>" + aluno.getSituacao() + "</td>");
        out.println("               </tr>");

        }
        out.println("		</tbody>");
        out.println("	</table>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }

}
