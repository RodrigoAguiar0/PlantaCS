package plantaplus.plantaplus.controller;

/**
 * Created by ASUS on 20/10/2017.
 */

import plantaplus.plantaplus.model.Usuario;

public class UserController {

    UserDAO userDao = new UserDAO();

    //função chamada no clique do botão
    public boolean adicionarUsuario(Usuario usuario) {

        boolean cadastro = false;

        if (usuario != null && usuario.getEmail().length() > 0
                && usuario.getNome().length() > 0
                && usuario.getSenha().length() > 0
                && usuario.getUsername().length() > 0) {
            cadastro = true;
        }
        return cadastro;
    }

    public boolean acessoValidoUsuario (Usuario usuario) {

        boolean cadastro = false;

        if (usuario != null &&
                usuario.getUsername().length() != 0 &&
                usuario.getSenha().length() != 0) {
            cadastro = true;
        }

        return cadastro;
    }
}