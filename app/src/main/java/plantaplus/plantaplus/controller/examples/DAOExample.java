package plantaplus.plantaplus.controller.examples;


    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import plantaplus.plantaplus.controller.GeraConexao;
import plantaplus.plantaplus.model.Planta;   //   ****** importação da classe de implementação do objeto a ser cadastrado

public class DAOExample {

    private final String INSERT = "INSERT INTO proposta (prop_nome, prop_depart, prop_descricao, prop_finalizada, contrat_cod) VALUES (?, ?, ?, ?, ?)";
    private final String FINALIZA = "UPDATE proposta SET prop_finalizada=true WHERE prop_cod=?";
    private final String LIST = "SELECT *FROM proposta WHERE contra_cod=?";
    private final String LISTBYID = "SELECT *FROM proposta WHERE prop_cod=?";

    public void adicionar(Planta planta, int codContratante) {
        if (planta != null) {
            Connection conn = null;
            try {
                conn = GeraConexao.getConexao();
                PreparedStatement pstm = conn.prepareStatement(INSERT);

            //    pstm.setString(1, planta.getNome());
            //    pstm.setInt(5, codContratante);

                pstm.execute();
                System.out.println("Planta cadastrada com sucesso");
                GeraConexao.fechaConexao(conn, pstm);
            } catch (SQLException e) {
                System.out.println("Erro ao cadastrar a planta" + e.getMessage());
            }
        } else {
            System.out.println("Planta enviada como parâmetro está vazia");
        }

    }

    public void excluir(Planta planta) {
        if (planta != null) {
            Connection conn = null;
            try {
                conn = GeraConexao.getConexao();
                PreparedStatement pstm = conn.prepareStatement(FINALIZA);

                //pstm.setInt(1, planta.getCodigo());

                pstm.execute();
                System.out.println("Planta excluída com sucesso");
                GeraConexao.fechaConexao(conn, pstm);
            } catch (SQLException e) {
                System.out.println("Erro ao excluir a planta" + e.getMessage());
            }
        } else {
            System.out.println("Planta enviada como parâmetro está vazia");
        }
    }

    public ArrayList<Planta> listarTodos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Planta> plantas = new ArrayList<>();
        try {
            conn = GeraConexao.getConexao();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Planta planta = new Planta();

                //proposta.setNome(rs.getString("prop_nome"));
                //proposta.setDepartamentos(rs.getString("prop_depart"));
                //proposta.setDescricao(rs.getString("prop_descricao"));
                //proposta.setFinalizada(rs.getBoolean("prop_finalizada"));

                plantas.add(planta);
            }
            GeraConexao.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            System.out.println("Erro ao listar as plantas: " + e.getMessage());
        }
        return plantas;
    }

    public Planta getUsuarioById(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Planta planta = new Planta();
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
            System.out.println("Erro ao capturar a planta" + e.getMessage());
        }
        return planta;
    }
}

