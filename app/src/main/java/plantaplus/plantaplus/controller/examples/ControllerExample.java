package plantaplus.plantaplus.controller.examples;

import plantaplus.plantaplus.model.Planta;

public class ControllerExample {

    DAOExample dao = new DAOExample();

    //função chamada no clique do botão
    public boolean adicionar(Planta planta, int codContratante) {

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
