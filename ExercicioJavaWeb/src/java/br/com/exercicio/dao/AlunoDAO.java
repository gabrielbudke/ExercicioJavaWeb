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
                aluno.setCodigo_matricula(resultSet.getString("codigo_matricula"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setNota_1(resultSet.getFloat("nota_1"));
                aluno.setNota_2(resultSet.getFloat("nota_2"));
                aluno.setNota_3(resultSet.getFloat("nota_3"));
                aluno.setNota_4(resultSet.getFloat("nota_4"));
                aluno.setNota_4(resultSet.getFloat("media"));
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
            ps.setString(2, aluno.getCodigo_matricula());
            ps.setFloat(3, aluno.getNota_1());
            ps.setFloat(4, aluno.getNota_2());
            ps.setFloat(5, aluno.getNota_3());
            ps.setFloat(6, aluno.getNota_4());
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

}
