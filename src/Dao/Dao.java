/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Autor;
import Model.Livro;
import conexao.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author oli
 */
public class Dao {

    private final Connection minha_conexao;

    public Dao() throws Exception {
        this.minha_conexao = new ConexaoFactory().conexao();
    }

    public String create(Autor aut) throws SQLException {
         PreparedStatement stmt = minha_conexao.prepareStatement(
                    "insert into autor (`nome`,`endereco`,`email`,`telefone`) values (?, ?, ?, ?) ");
        try {
           
                stmt.setString(1, aut.getNome());
                stmt.setString(2, aut.getEndereco());
                stmt.setString(3, aut.getEmail());
                stmt.setString(4, aut.getTelefone());
                stmt.execute();

            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Aquivo" + e, "Aviso", JOptionPane.WARNING_MESSAGE);

        }
        stmt.close();
        return "susseso";
    }

    public String Remove(Autor aut) throws SQLException {
        PreparedStatement stmt = minha_conexao.prepareStatement("DELETE FROM `lp`.`autor` WHERE (`idAutor` = ?);");
        try {

            stmt.setInt(1, aut.getId());
            stmt.execute();

        } catch (SQLException e) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
        stmt.close();
        return "Sussesso";
    }

    public String Update(Autor aut) throws SQLException {
        PreparedStatement stmt = minha_conexao.prepareStatement(
                "UPDATE `lp`.`autor` SET `nome` = ?, `endereco` = ?, `email` = ?, `telefone` = ? WHERE (`idAutor` = ?)");
        try {

            // UPDATE `lp1`.`autor` SET `nome` = 'Juiano', `endereco` = 'gmail.com', `email` = 'co', `telefone` = '(111) 99614 - 5114' WHERE (`id` = '30');
            stmt.setString(1, aut.getNome());
            stmt.setString(2, aut.getEndereco());
            stmt.setString(3, aut.getEmail());
            stmt.setString(4, aut.getTelefone());
            stmt.setInt(5, aut.getId());
            stmt.execute();

        } catch (SQLException e) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
        stmt.close();
        return "susseso";
    }

    public String create_livro(Livro liv) throws SQLException {
        PreparedStatement stmt = minha_conexao.prepareStatement(
                "INSERT INTO `lp`.`livro` (`isnb`, `titulo`, `n_edicao`, `nome_autor`) VALUES (?, ?, ?,?);");
        try {

            stmt.setString(1, liv.getIsbn());
            stmt.setString(2, liv.getTitulo());
            stmt.setString(3, liv.getEdicao().toString());
            stmt.setString(4,liv.getAutor().getNome());
           
            stmt.execute();

        } catch (SQLException e) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
        stmt.close();
        return "Adicnando livro.....";
    }

    public String Update_livro(Livro liv) throws SQLException {
        PreparedStatement stmt = minha_conexao.prepareStatement(
                "UPDATE `lp`.`livro` SET `isnb` = ?, `titulo` = ?, `n_edicao` = ? WHERE (`isnb` = ?);");
        try {

            stmt.setString(1, liv.getIsbn());
            stmt.setString(2, liv.getTitulo());
            stmt.setString(3, liv.getEdicao().toString());
            stmt.setString(4, liv.getIsbn());

            stmt.execute();

        } catch (SQLException e) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
        stmt.close();
        return "susseso";
    }

    public String Remove_Livro(Livro liv) throws SQLException {
        PreparedStatement stmt = minha_conexao.prepareStatement("DELETE FROM `lp`.`livro` WHERE (`isnb` = ?);");
        try {

            stmt.setString(1, liv.getIsbn());
            stmt.execute();

        } catch (SQLException e) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
        stmt.close();
        return "Sussesso";

    }

    public List<Autor> read() throws SQLException {
        List<Autor> autores = new ArrayList<>();
        PreparedStatement stm = minha_conexao.prepareStatement("Select * from autor");
        ResultSet rs = stm.executeQuery();
        try {

            while (rs.next()) {
                Autor aut = new Autor();
                aut.setId(rs.getInt("idAutor"));
                aut.setNome(rs.getString("nome"));
                aut.setEndereco(rs.getString("endereco"));
                aut.setEmail(rs.getString("email"));
                aut.setTelefone(rs.getString("telefone"));
               
                autores.add(aut);

            }

        } catch (SQLException e) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
        rs.close();
        stm.close();
        return autores;
    }
    
    public List<Livro> read_livro() throws SQLException {
        List<Livro> livros = new ArrayList<>();
        PreparedStatement stm = minha_conexao.prepareStatement("Select * from livro");
        ResultSet rs = stm.executeQuery();
        try {

            while (rs.next()) {
                Livro liv = new Livro();
                Autor aut = new Autor();
                liv.setIsbn(rs.getString("isnb"));
                liv.setTitulo(rs.getString("titulo"));
                liv.setEdicao(rs.getInt("n_edicao"));
                
               
                livros.add(liv);
               

            }

        } catch (SQLException e) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
        rs.close();
        stm.close();
        return livros;
    }
}
