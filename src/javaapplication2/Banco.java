package javaapplication2;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lucas
 */
public class Banco {

    Manipulacao m = new Manipulacao();
    private Connection connection;
    private final String pesquisaNota1 = "SELECT count(nota) FROM pesquisa.questionario where nota=1";
    private final String pesquisaNota2 = "SELECT count(nota) FROM pesquisa.questionario where nota=2";
    private final String pesquisaNota3 = "SELECT count(nota) FROM pesquisa.questionario where nota=3";
    private final String pesquisaNota4 = "SELECT count(nota) FROM pesquisa.questionario where nota=4";
    private final String pesquisaNota5 = "SELECT count(nota) FROM pesquisa.questionario where nota=5";
    private final String pesquisaTotalVotos = "SELECT count(nota) FROM pesquisa.questionario";
    private final String pesquisaSatisfeito = "SELECT count(satisfeito) FROM pesquisa.questionario where satisfeito = 1";
    private final String pesquisaInsatisfeito = "SELECT count(satisfeito) FROM pesquisa.questionario where satisfeito = 0";
    private final String pesquisaSugestao = "SELECT id, avaliacao, nome FROM pesquisa.questionario where publicar=1 and publicado = false ORDER BY RAND() limit 1";
    private final String updateTrue = "update questionario set publicado = 1 where id = ?";
    private final String updateFalse = "update questionario set publicado = 0";

    public Banco() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.254/pesquisa", "user", "1234");
        //System.out.println("Conectado com sucesso.");
        con.close();
    }

    public void consultarNota1() throws ClassNotFoundException, SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.254/pesquisa", "user", "1234");
        Statement stm = con.createStatement();
        // Definido o Statement, executamos a query no banco de dados  
        ResultSet rs = stm.executeQuery(pesquisaNota1);
   // O método next() informa se houve resultados e posiciona o cursor do banco  
        // na próxima linha disponível para recuperação  
        // Como esperamos várias linhas utilizamos um laço para recuperar os dados 
        while (rs.next()) {
            m.setnota1(rs.getDouble("count(nota)"));
        }
        con.close();
    }

    public void consultarNota2() throws ClassNotFoundException, SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.254/pesquisa", "user", "1234");
        Statement stm = con.createStatement();
        // Definido o Statement, executamos a query no banco de dados  
        ResultSet s = stm.executeQuery(pesquisaNota2);
   // O método next() informa se houve resultados e posiciona o cursor do banco  
        // na próxima linha disponível para recuperação  
        // Como esperamos várias linhas utilizamos um laço para recuperar os dados 
        while (s.next()) {
            m.setnota2(s.getDouble("count(nota)"));
        }
        con.close();
    }

    public void consultarNota3() throws ClassNotFoundException, SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.254/pesquisa", "user", "1234");
        Statement stm = con.createStatement();
        // Definido o Statement, executamos a query no banco de dados  
        ResultSet r = stm.executeQuery(pesquisaNota3);
   // O método next() informa se houve resultados e posiciona o cursor do banco  
        // na próxima linha disponível para recuperação  
        // Como esperamos várias linhas utilizamos um laço para recuperar os dados 
        while (r.next()) {
            m.setnota3(r.getDouble("count(nota)"));
        }
        con.close();
    }

    public void consultarNota4() throws ClassNotFoundException, SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.254/pesquisa", "user", "1234");
        Statement stm = con.createStatement();
        // Definido o Statement, executamos a query no banco de dados  
        ResultSet trs = stm.executeQuery(pesquisaNota4);
   // O método next() informa se houve resultados e posiciona o cursor do banco  
        // na próxima linha disponível para recuperação  
        // Como esperamos várias linhas utilizamos um laço para recuperar os dados 
        while (trs.next()) {
            m.setnota4(trs.getDouble("count(nota)"));
        }
        con.close();
    }

    public void consultarNota5() throws ClassNotFoundException, SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.254/pesquisa", "user", "1234");
        Statement stm = con.createStatement();
        // Definido o Statement, executamos a query no banco de dados  
        ResultSet vrs = stm.executeQuery(pesquisaNota5);
   // O método next() informa se houve resultados e posiciona o cursor do banco  
        // na próxima linha disponível para recuperação  
        // Como esperamos várias linhas utilizamos um laço para recuperar os dados 
        while (vrs.next()) {
            m.setnota5(vrs.getDouble("count(nota)"));
        }
        con.close();
    }

    public void consultarQuantidadeVotos() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.254/pesquisa", "user", "1234");
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(pesquisaTotalVotos);
        while (rs.next()) {
            m.setTotalVotos(rs.getInt("count(nota)"));
        }
        con.close();
    }

    public void consultarSatisfeto() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.254/pesquisa", "user", "1234");
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(pesquisaSatisfeito);
        while (rs.next()) {
            m.setsatisfeito(rs.getDouble("count(satisfeito)"));
        }
        con.close();
    }

    public void consultarSugetao() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.254/pesquisa", "user", "1234");
        PreparedStatement s = con.prepareStatement(updateTrue);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(pesquisaSugestao);
        int idd;
        if (rs.next()) {
            m.setSugestao(rs.getString("avaliacao"));
            m.setNome(rs.getString("nome"));
            idd = (rs.getInt("id"));
            s.setInt(1, idd);
            s.executeUpdate();
        } else {
            PreparedStatement d = con.prepareStatement(updateFalse);
            d.executeUpdate();
            rs.close();
            rs = stm.executeQuery(pesquisaSugestao);
            if (rs.next()) {
                m.setSugestao(rs.getString("avaliacao"));
                m.setNome(rs.getString("nome"));
                idd = (rs.getInt("id"));
                s.setInt(1, idd);
                s.executeUpdate();
            }
        }
        con.close();
    }

    public void consultarInsatisfeto() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.254/pesquisa", "user", "1234");
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(pesquisaInsatisfeito);
        while (rs.next()) {
            m.setinsatisfeito(rs.getDouble("count(satisfeito)"));
        }
        con.close();
    }
}

/*class ManipulacaoBanco {
 public static void main(String[] args) {
 try {
 Banco bd = new Banco();            
 } catch (Exception e) {
 System.out.println("Não conectado.");
 }
 }    
 }*/
