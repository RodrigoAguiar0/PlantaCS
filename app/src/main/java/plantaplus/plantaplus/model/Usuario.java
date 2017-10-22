package plantaplus.plantaplus.model;

import java.util.Date;

/**
 * Created by ASUS on 18/10/2017.
 */

public class Usuario {
    private String username;
    private String email;
    private String senha;
    private Date data;
    private int id;
    private String nome;

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String senha) {
        this.username = senha;
    }

    public Date getData(){
        return this.data;
    }
    public void setData(Date data){
        this.data = data;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

}
