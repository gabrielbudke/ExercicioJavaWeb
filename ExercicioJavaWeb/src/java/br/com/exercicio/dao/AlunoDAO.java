/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exercicio.dao;

import br.com.exercicio.bean.AlunoBean;
import br.com.exercicio.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class AlunoDAO {

    public List<AlunoBean> obterTodos() {
        List<AlunoBean> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try {
            Statement st = Conexao.obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultSet = st.getResultSet();
            while (resultSet.next()) {
                AlunoBean aluno = new AlunoBean();
                aluno.setId(resultSet.getInt("id"));
                aluno.setCodigoMatricula(resultSet.getString("codigo_matricula"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setNota1(resultSet.getFloat("nota_1"));
                aluno.setNota2(resultSet.getFloat("nota_2"));
                aluno.setNota3(resultSet.getFloat("nota_3"));
                aluno.setNota4(resultSet.getFloat("nota_4"));
                aluno.setMedia(resultSet.getFloat("media"));
                aluno.setFrequencia(resultSet.getByte("frequencia"));
                aluno.setSituacao(resultSet.getString("situacao"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }

        return alunos;

    }

    public int adicionar(AlunoBean aluno) {
        String sql = "INSERT INTO alunos (nome, codigo_matricula, nota_1, nota_2, nota_3, nota_4, media, frequencia, situacao) VALUES (?, ?, ? ,? , ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCodigoMatricula());
            ps.setFloat(3, aluno.getNota1());
            ps.setFloat(4, aluno.getNota2());
            ps.setFloat(5, aluno.getNota3());
            ps.setFloat(6, aluno.getNota4());
            ps.setFloat(7, aluno.getMedia());
            ps.setByte(8, aluno.getFrequencia());
            ps.setString(9, aluno.getSituacao());
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return -1;
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM alunos WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            Conexao.fecharConexao();
        }

        return false;
    }

    public AlunoBean obterPeloId(int id) {
        String sql = "SELECT nome, codigo_matricula, nota_1, nota_2, nota_3, nota_4, frequencia WHERE id = ?";

        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            if (resultSet.next()) {
                AlunoBean aluno = new AlunoBean();
                aluno.setId(id);
                aluno.setCodigoMatricula(resultSet.getString("codigo_matricula"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setNota1(resultSet.getFloat("nota_1"));
                aluno.setNota2(resultSet.getFloat("nota_2"));
                aluno.setNota3(resultSet.getFloat("nota_3"));
                aluno.setNota4(resultSet.getFloat("nota_4"));
                aluno.setFrequencia(resultSet.getByte("frequencia"));
                return aluno;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            Conexao.fecharConexao();
        }

        return null;
    }

    public boolean alterar(AlunoBean aluno) {
        String sql = "UPDATE alunos SET codigo_matricula = ?, nome = ?, nota_1 = ?, nota_2 = ?, nota_3 = ?, nota_4 = ? media = ? situacao = ? WHERE id = ?";

        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, aluno.getCodigoMatricula());
            ps.setString(2, aluno.getNome());
            ps.setFloat(3, aluno.getNota1());
            ps.setFloat(4, aluno.getNota2());
            ps.setFloat(5, aluno.getNota3());
            ps.setFloat(6, aluno.getNota4());
            ps.setFloat(7, aluno.calcularMedia());
            ps.setString(8, aluno.getSituacao());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            Conexao.fecharConexao();
        }

        return false;
    }

}
