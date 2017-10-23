package plantaplus.plantaplus.controller;

/**
 * Created by ASUS on 20/10/2017.
 */

import plantaplus.plantaplus.model.Usuario;

public class UserController {

    UserDAO userDao = new UserDAO();

    //função chamada no clique do botão
    public boolean adicionar(Usuario usuario) {

        boolean cadastro = false;

        /*if (planta != null && planta.getNome().length() > 0
                && planta.getContratante() != null
                && !planta.getCursos().isEmpty()
                && planta.getDescricao().length() > 0) {
            cadastro = true;
            dao.adicionar(planta, codContratante);
        }*/
        return cadastro;
    }
}