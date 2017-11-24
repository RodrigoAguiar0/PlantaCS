package plantaplus.plantaplus.model;

/**
 * Usuario.java
 * Versão: 0.8
 * Data de criação: 08/10/2017
 *
 * Este sistema tem o propósito de oferecer assistência para seus usuários, oferecendo recomendações
 * de cuidaddos, como rega, poda, adubação, tratamento de pragas e doenças e exposição ao sol, para
 * diversos tipos de plantas.
 * */

import java.util.Date;

public class Usuario {

    /**
     * Essa classe é responsável por definir o objeto usuário, assim como instanciá-lo e realizar
     * modificações em cada instância do mesmo;
     *
     * @author Rafael Beffart Paludo
     * @since 20/10/2017
     * */

    private String username;
    private String email;
    private String senha;
    private Date data;
    private int id;
    private String nome;

    /**
     * Retorna o username do usuário;
     *
     * @return username do usuário
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Altera a variável username do usuário;
     *
     * @param username
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * Retorna o email do usuário;
     *
     * @return email do usuário
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Altera a variável email do usuário;
     *
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Retorna a senha do usuário;
     *
     * @return senha do usuário
     */
    public String getSenha(){
        return this.senha;
    }

    /**
     * Altera a variável senha do usuário;
     *
     * @param senha
     */
    public void setSenha(String senha) {
        this.username = senha;
    }

    /**
     * Retorna a data de criação da conta do usuário;
     *
     * @return data do usuário
     */
    public Date getData(){
        return this.data;
    }

    /**
     * Altera a variável data do usuário;
     *
     * @param data
     */
    public void setData(Date data){
        this.data = data;
    }

    /**
     * Retorna o ID do usuário;
     *
     * @return ID do usuário
     */
    public Integer getId(){
        return this.id;
    }

    /**
     * Altera a variável id do usuário;
     *
     * @param id
     */
    public void setId(Integer id){
        this.id = id;
    }
    /**
     * Retorna o nome do usuário;
     *
     * @return nome do usuário
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Altera a variável nome do usuário;
     *
     * @param nome
     */
    public void setNome(String nome){
        this.nome = nome;
    }

}
