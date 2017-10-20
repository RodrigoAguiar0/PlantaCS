private final String LIST = "SELECT *FROM proposta WHERE contra_cod=?";
private final String LISTBYID = "SELECT *FROM proposta WHERE prop_cod=?";

public void adicionar(Usuario usuario, int codContratante) {
        if (usuario != null) {
            Connection conn = null;
            try {
                conn = GeraConexao.getConexao();
                PreparedStatement pstm = conn.prepareStatement(INSERT);

        //    pstm.setString(1, planta.getNome());
        //    pstm.setInt(5, codContratante);

                pstm.execute();
                System.out.println("Usuario cadastrado com sucesso");
                GeraConexao.fechaConexao(conn, pstm);
                } catch (SQLException e) {
                    System.out.println("Erro ao cadastrar o usuario" + e.getMessage());
                    }
        } else {
            System.out.println("Planta enviada como parâmetro está vazia");
            }

        }

public void excluir(Usuario usuario) {
        if (usuario != null) {
            Connection conn = null;
            try {
                conn = GeraConexao.getConexao();
                PreparedStatement pstm = conn.prepareStatement(FINALIZA);

        //pstm.setInt(1, planta.getCodigo());

                pstm.execute();
                System.out.println("Usuario excluído com sucesso");
                GeraConexao.fechaConexao(conn, pstm);
                } catch (SQLException e) {
                    System.out.println("Erro ao excluir o usuario" + e.getMessage());
                }
        } else {
            System.out.println("Usuario enviado como parâmetro está vazio");
            }
        }

public ArrayList<Usuario> listarTodos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Usuario> usuario = new ArrayList<>();
        try {
            conn = GeraConexao.getConexao();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();

        //proposta.setNome(rs.getString("prop_nome"));
        //proposta.setDepartamentos(rs.getString("prop_depart"));
        //proposta.setDescricao(rs.getString("prop_descricao"));
        //proposta.setFinalizada(rs.getBoolean("prop_finalizada"));

                usuario.add(usuario);
                }
            GeraConexao.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            System.out.println("Erro ao listar os usuarios: " + e.getMessage());
            }
        return usuario;
        }

public Usuario getUsuarioById(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();
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
            System.out.println("Erro ao capturar o usuario" + e.getMessage());
        }
        return usuario;
        }
