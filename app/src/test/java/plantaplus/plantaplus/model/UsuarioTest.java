package plantaplus.plantaplus.model;

/**
 * UsuarioTest.java
 * Versão: 0.8
 * Data de criação: 12/3/2017
 *
 * Este sistema tem o propósito de oferecer assistência para seus usuários, oferecendo recomendações
 * de cuidaddos, como rega, poda, adubação, tratamento de pragas e doenças e exposição ao sol, para
 * diversos tipos de plantas.
 * */

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Essa classe é responsável pelos testes unitários da classe Usuario
 *
 * @author Rodrigo Aguiar
 * @since 12/03/2017
 */
public class UsuarioTest {

    Usuario usuario = new Usuario();
    Date date = new Date();

    @Before
    public void setUsuario() throws ParseException {
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
    public void getUsername() throws Exception {
        String output, expected;
        expected = "lucasmario123";
        output = usuario.getUsername();
        assertEquals(output, expected);
    }

    @Test
    public void setUsername() throws Exception {
        String input, output, expected;
        input = expected = "teste";
        usuario.setUsername(input);
        output = usuario.getUsername();
        assertEquals(output, expected);
    }

    @Test
    public void getEmail() throws Exception {
        String output, expected;
        expected = "lucasmario@teste.com";
        output = usuario.getEmail();
        assertEquals(output, expected);
    }

    @Test
    public void setEmail() throws Exception {
        String input, output, expected;
        input = expected = "teste@teste.com.br";
        usuario.setEmail(input);
        output = usuario.getEmail();
        assertEquals(output, expected);
    }

    @Test
    public void getSenha() throws Exception {
        String output, expected;
        expected = "senha@123456";
        output = usuario.getSenha();
        assertEquals(output, expected);
    }

    @Test
    public void setSenha() throws Exception {
        String input, output, expected;
        input = expected = "123456Senh@";
        usuario.setSenha(input);
        output = usuario.getSenha();
        assertEquals(output, expected);
    }

    @Test
    public void getData() throws Exception {
        Date output, expected;
        expected = date;
        output = usuario.getData();
        assertEquals(output, expected);
    }

    @Test
    public void setData() throws Exception {
        Date input, output, expected;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        input = formato.parse("03/12/2018");
        expected = input;
        usuario.setData(input);
        output = usuario.getData();
        assertEquals(output, expected);
    }

    @Test
    public void getId() throws Exception {
        int output, expected;
        expected = 987654321;
        output = usuario.getId();
        assertEquals(output, expected);
    }

    @Test
    public void setId() throws Exception {
        int input, output, expected;
        input = expected = 123456789;
        usuario.setId(input);
        output = usuario.getId();
        assertEquals(output, expected);
    }

    @Test
    public void getNome() throws Exception {
        String output, expected;
        expected = "Lucas Mario";
        output = usuario.getNome();
        assertEquals(output, expected);
    }

    @Test
    public void setNome() throws Exception {
        String input, output, expected;
        input = expected = "José Pedro";
        usuario.setNome(input);
        output = usuario.getNome();
        assertEquals(output, expected);
    }

}