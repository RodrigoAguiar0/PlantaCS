package plantaplus.plantaplus.model;

import plantaplus.plantaplus.controller.GeraConexao;

import java.sql.Connection;

public class ConnTest {

    public static void main(String[] args) {
        Connection conn = GeraConexao.getConexao();
        GeraConexao.fechaConexao(conn);
    }
}
