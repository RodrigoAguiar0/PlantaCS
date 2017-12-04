package plantaplus.plantaplus.controller;

/**
 * UserDAOTest.java
 * Versão: 0.8
 * Data de criação: 08/10/2017
 *
 * Este sistema tem o propósito de oferecer assistência para seus usuários, oferecendo recomendações
 * de cuidaddos, como rega, poda, adubação, tratamento de pragas e doenças e exposição ao sol, para
 * diversos tipos de plantas.
 * */

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import plantaplus.plantaplus.model.Usuario;

import static org.junit.Assert.*;

/**
 * Created by Rodrigo Aguiar on 12/3/2017.
 */
public class UserDAOTest {

    UserDAO userDAO = new UserDAO();
    Usuario usuario = new Usuario();
    Date date = new Date();

    @Before
    public void setUp() throws Exception {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        date = formato.parse("05/07/1998");
        usuario.setNome("Lucas Mario");
        usuario.setId(987654321);
        usuario.setData(date);
        usuario.setSenha("senha@123456");
        usuario.setEmail("lucasmario@teste.com");
        usuario.setUsername("lucasmario123");
    }

    @Test
    public void adicionarUsuario() throws Exception {
        Usuario expected = usuario;
        userDAO.adicionarUsuario(usuario);
        assertEquals(userDAO.getUsuarioById(987654321), expected);
    }

    @Test
    public void usuarioExiste() throws Exception {
        boolean expected = true;
        userDAO.adicionarUsuario(usuario);
        assertEquals(userDAO.usuarioExiste(usuario), expected);
    }

    @Test
    public void excluir() throws Exception {
        boolean expected = false;
        userDAO.adicionarUsuario(usuario);
        userDAO.excluir(usuario);
        assertEquals(userDAO.usuarioExiste(usuario), expected);
    }

    @Test
    public void listarTodos() throws Exception {
    }

    @Test
    public void getUsuarioById() throws Exception {
        Usuario expected = usuario;
        userDAO.adicionarUsuario(usuario);
        assertEquals(userDAO.getUsuarioById(987654321), expected);
    }

}