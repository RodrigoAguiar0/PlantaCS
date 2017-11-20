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

    /**
     * Adiciona um usuário no banco de dados
     *
     * @param usuario - Usuário a ser adicionado no banco de dados
     * */
    public void adicionarUsuario(Usuario usuario) {
        if (usuario != null) {

        } else {
            System.out.println("Planta enviada como parâmetro está vazia");
        }

    }

    /**
     * Verifica a existência de um determinado usuário no banco de dados, baseado em username e
     * senha
     *
     * @param usuario - Usuário usado que deseja acessar a aplicação
     * @return boolean - Resultado da busca (verdadeiro se confirmada a existência do usuário e
     * falso caso contrário)
     * */
    public boolean usuarioExiste(Usuario usuario){
        try {
            HashMap postData = new HashMap();
            postData.put("txtUsername", usuario.getEmail());
            postData.put("txtPassword", usuario.getSenha());

            PostResponseAsyncTask task = new PostResponseAsyncTask(UserDAO.this, postData);
            task.execute("http://192.168.25.4/client/login.php");
            return true;
        } catch (Exception e) {
            System.out.println("ALOOOOOOOOOU");
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
            try {

            } catch (Exception e) {
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

        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {

            while (true) {
                Usuario usuario = new Usuario();
                usuarios.add(usuario);
            }
        } catch (Exception e) {
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
        Usuario usuario = new Usuario();
        try {
            while (true) {

            }
        } catch (Exception e) {
            System.out.println("Erro ao capturar o usuario" + e.getMessage());
        }

        return usuario;
    }

    /**
     * Saída das funções de comunicação ao banco de dados
     *
     * @param result - Resultado retornado pela função PHP de comunicação com a aplicação
     */
    @Override
    public void processFinish(String result) {

    }
}
