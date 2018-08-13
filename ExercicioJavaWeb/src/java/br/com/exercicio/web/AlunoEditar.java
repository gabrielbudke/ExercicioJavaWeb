package br.com.exercicio.web;

import br.com.exercicio.bean.AlunoBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alunos
 */
@WebServlet(urlPatterns = "/alunos/editar")
public class AlunoEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        AlunoBean aluno = new AlunoBean();
        
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("	<title>Editar Aluno</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("	<form action='/ExercicioJavaWeb/alunos/update' method='post'>");
        out.println("		<div>");
        out.println("			<label for='campo-nome'>Nome</label>");
        out.println("			<input type='text' id='campo-nome' name='nome' value='" + aluno.getNome() + "'>");
        out.println("		</div>");
        out.println("		<div>");
        out.println("			<label for='campo-matricula'>Código da Matricula</label>");
        out.println("			<input type='text' id='campo-matricula' name='matricula' value='" + aluno.getCodigoMatricula() + "'>");
        out.println("		</div>");
        out.println("		<div>");
        out.println("			<label for='campo-nota-1'>Nota 1</label>");
        out.println("			<input type='text' id='campo-nota-1' name='nota1' value='" + aluno.getNota1() + "'>");
        out.println("		</div>");
        out.println("		<div>");
        out.println("			<label for='campo-nota-2'>Nota 2</label>");
        out.println("			<input type='text' id='campo-nota-2' name='nota2' value='" + aluno.getNota2() + "'>");
        out.println("		</div>");
        out.println("		<div>");
        out.println("			<label for='campo-nota-3'>Nota 3</label>");
        out.println("			<input type='text' id='campo-nota-3' name='nota3' value='" + aluno.getNota3() + "'>");
        out.println("		</div>");
        out.println("		<div>");
        out.println("			<label for='campo-nota-4'>Nota 4</label>");
        out.println("			<input type='text' id='campo-nota-4' name='nota4' value='" + aluno.getNota4() + "'>");
        out.println("		</div>");
        out.println("		<div>");
        out.println("			<label for='campo-frequencia'>Frequencia</label>");
        out.println("			<input type='text' id='campo-frequencia' name='frequencia' value='" + aluno.getFrequencia() + "'>");
        out.println("		</div>");
        out.println("		<input class='' type='submit' value='Cadastrar'>");

        out.println("	</form>");
        out.println("</body>");
        out.println("</html>");

    }

}
