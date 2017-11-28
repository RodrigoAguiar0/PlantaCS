package plantaplus.plantaplus.controller;

/**
 * UserController.java
 * Versão: 0.8
 * Data de criação: 20/10/2017
 *
 * Este sistema tem o propósito de oferecer assistência para seus usuários, oferecendo recomendações
 * de cuidaddos, como rega, poda, adubação, tratamento de pragas e doenças e exposição ao sol, para
 * diversos tipos de plantas.
 * */

import plantaplus.plantaplus.model.Usuario;

public class UserController {

    /**
     * Esta classe é responsável pela comunicação com o banco de dados do sistema, além da validação
     * e captura de excessões do sistema
     *
     * @author Rafael Beffart Paludo
     * @since 20/10/2017
     * */

    UserDAO userDao = new UserDAO();

    /**
     * Essa função é chamada no clique do botão e adiciona o usuário ao banco após a inserção dos
     * dados no formulário;
     *
     * @param usuario: Objeto usuário contento as informações a serem adicionadas ao banco
     * @return True ou False sendo a confirmação do cadastro
     */
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

    /**
     * Essa função valida campos do formulário durante a criação do usuário
     *
     * @param usuario: Objeto usuário contento as informações a serem cadastradas
     * @return True ou False sendo a confirmação da validade das informações
     */
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