package plantaplus.plantaplus.controller;

/**
 * UserDAO.java
 * Versão: 0.8
 * Data de criação: 08/10/2017
 *
 * Este sistema tem o propósito de oferecer assistência para seus usuários, oferecendo recomendações
 * de cuidaddos, como rega, poda, adubação, tratamento de pragas e doenças e exposição ao sol, para
 * diversos tipos de plantas.
 * */

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import plantaplus.plantaplus.model.Usuario;


    public class UserDAO implements AsyncResponse{

    /**
     * Esta classe possui funções para lidar com cadastros de usuários no banco de dados, com as
     * funções CRUD.
     *
     * @author Davi Müller
     * @since 18/10/2017
     * */

    private final String INSERT = "INSERT INTO proposta (prop_nome, prop_depart, prop_descricao, " +
            "prop_finalizada, contrat_cod) VALUES (?, ?, ?, ?, ?)";
    private final String FINALIZA = "UPDATE proposta SET prop_finalizada=true WHERE prop_cod=?";
    private final String LIST = "SELECT *FROM proposta WHERE contra_cod=?";
    private final String LISTBYID = "SELECT *FROM proposta WHERE prop_cod=?";
    private final String FIND = "SELECT *FROM usuario WHERE username=? AND password=?";

    /**
     * Adiciona um usuário no banco de dados
     *
     * @param usuario - Usuário a ser adicionado no banco de dados
     * */
    public void adicionarUsuario(Usuario usuario) {
        if (usuario != null) {
            Connection conn = null;
            try {
                conn = GeraConexao.getConexao();
                PreparedStatement pstm = conn.prepareStatement(INSERT);

        //    pstm.setString(1, planta.getNome());
        //    pstm.setInt(5, codContratante);

                pstm.execute();
                System.out.println("Usuario cadastrado com sucesso");
                GeraConexao.fechaConexao(conn, pstm);
                } catch (SQLException e) {
                    System.out.println("Erro ao cadastrar o usuario" + e.getMessage());
                    }
        } else {
            System.out.println("Planta enviada como parâmetro está vazia");
            }

        }

    /**
     * Verifica a existência de um determinado usuário no banco de dados, baseado em username e
     * senha
     *
     * @param username - Nome de usuário usado pelo usuário para acessar a aplicação
     * @param senha - Senha usada pelo usuário para acessar a aplicação
     * @return boolean - Resultado da busca (verdadeiro se confirmada a existência do usuário e
     * falso caso contrário)
     * */
    public boolean existeUsuario(String username, String senha){
        HashMap postData = new HashMap();

        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://192.168.25.4/client/login.php");


        Connection conn = null;
        try {
            conn = GeraConexao.getConexao();
            PreparedStatement pstm = conn.prepareStatement(FIND);
            pstm.setString(1, username);
            pstm.setString(2, senha);
            pstm.execute();
            GeraConexao.fechaConexao(conn, pstm);
            return true;
        }catch (SQLException e){
            return false;
        }
    }

    /**
     * Exclui um determinado usuário do banco de dados.
     *
     * @param usuario - Instância usuário que se deseja excluir do banco de dados.
     *
     * */
     public void excluir(Usuario usuario) {
        if (usuario != null) {
            Connection conn = null;
            try {
                conn = GeraConexao.getConexao();
                PreparedStatement pstm = conn.prepareStatement(FINALIZA);

        //pstm.setInt(1, planta.getCodigo());

                pstm.execute();
                System.out.println("Usuario excluído com sucesso");
                GeraConexao.fechaConexao(conn, pstm);
                } catch (SQLException e) {
                    System.out.println("Erro ao excluir o usuario" + e.getMessage());
                }
        } else {
            System.out.println("Usuario enviado como parâmetro está vazio");
        }
    }

    /**
     * Retorna a lista de usuários do banco de dados.
     *
     * @return Arraylist<Usuario> - Lista com todos os usuários contidos no banco de dados.
     */
    public ArrayList<Usuario> listarTodos(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            conn = GeraConexao.getConexao();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();

        //proposta.setNome(rs.getString("prop_nome"));
        //proposta.setDepartamentos(rs.getString("prop_depart"));
        //proposta.setDescricao(rs.getString("prop_descricao"));
        //proposta.setFinalizada(rs.getBoolean("prop_finalizada"));

                usuarios.add(usuario);
            }
            GeraConexao.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            System.out.println("Erro ao listar os usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    /**
     * Procura usuário no banco de dados e retorna o objeto Usuario
     *
     * @param id - Id único do usuário que se deseja encntrar
     * @return Usuario - Usuário procurado e encontrado
     * */
    public Usuario getUsuarioById(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try {
            conn = GeraConexao.getConexao();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {

        //planta.setNome(rs.getString("prop_nome"));
        //planta.setDepartamentos(rs.getString("prop_depart"));
        //planta.setDescricao(rs.getString("prop_descricao"));
        //planta.setFinalizada(rs.getBoolean("prop_finalizada"));

        }
        GeraConexao.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            System.out.println("Erro ao capturar o usuario" + e.getMessage());
        }

        return usuario;
        }

        @Override
        public void processFinish(String s) {

        }
    }
