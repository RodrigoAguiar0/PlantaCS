package plantaplus.plantaplus.model;

/**
 * Planta.java
 * Versão: 0.8
 * Data de criação: 08/10/2017
 *
 * Este sistema tem o propósito de oferecer assistência para seus usuários, oferecendo recomendações
 * de cuidaddos, como rega, poda, adubação, tratamento de pragas e doenças e exposição ao sol, para
 * diversos tipos de plantas.
 * */

public class Planta {

    /**
     * Essa classe tem como função ser o objeto planta utilizado para recebimento de informações do
     * banco de dados e como referência de uso dos possíveis dados de plantas a serem referenciados
     * durante o desenvolvimento;
     *
     * @author Rafael Beffart Paludo
     * @since 20/10/2017
     * */

    private String nomePopular;
    private String nomeCientifico;
    private boolean espinhosa;
    private boolean suculenta;
    private boolean trepadeira;
    private boolean comestivel;
    private boolean ornamental;
    private boolean processada;
    private boolean floral;
    private int rega;
    private float exposicaoSolar;
    private String adubagem;

    /**
     * Construtor de uma planta com nome popular, ou seja, com um nome que não está em nosso banco
     * de dados, e sem outros parâmetros para a definição correta da planta, sendo então o
     * contrutor default;
     *
     * @param nomePopular: Nome popular de uma planta específica
     */
    public Planta(String nomePopular) {
    }

    /**
     * Construtor de uma planta com o intuito de selecionar qual é o tipo da planta e qual será o
     * tratamento dado a ela durante os cuidados;
     *
     * @param nomePopular: Nome popular de uma planta específica
     * @param nomeCientifico: Nome científico da planta
     * @param espinhosa: True ou false se a planta pertence a este grupo
     * @param suculenta: True ou false se a planta pertence a este grupo
     * @param trepadeira: True ou false se a planta pertence a este grupo
     * @param comestivel: True ou false se a planta pertence a este grupo
     * @param ornamental: True ou false se a planta pertence a este grupo
     * @param processada: True ou false se a planta pertence a este grupo
     * @param floral: True ou false se a planta pertence a este grupo
     * @param rega: Contém informações a respeito da quantidade de rega que a planta necessita
     * @param exposicaoSolar: Contém informações a respeito da quantidade de tempo de sol que a
     *                      planta necessita
     * @param adubagem: Contém informações a respeito de como a planta deve ser adubada
     */
    public Planta(String nomePopular, String nomeCientifico, boolean espinhosa, boolean suculenta,
                  boolean trepadeira, boolean comestivel, boolean ornamental, boolean processada,
                  boolean floral, int rega, float exposicaoSolar, String adubagem) {
        this.nomePopular = nomePopular;
        this.nomeCientifico = nomeCientifico;
        this.espinhosa = espinhosa;
        this.suculenta = suculenta;
        this.trepadeira = trepadeira;
        this.comestivel = comestivel;
        this.ornamental = ornamental;
        this.processada = processada;
        this.floral = floral;
        this.rega = rega;
        this.exposicaoSolar = exposicaoSolar;
        this.adubagem = adubagem;
    }

    /**
     * Retorna nome popular da planta;
     *
     * @return Nome popular da planta
     */
    public String getNomePopular() {
        return nomePopular;
    }

    /**
     * Altera a variável nomePopular da planta;
     *
     * @param nomePopular
     */
    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }

    /**
     * Retorna nome científico da planta;
     *
     * @return Nome científico da planta
     */
    public String getNomeCientifico() {
        return nomeCientifico;
    }

    /**
     * Altera a variável nomeCientifico da planta;
     *
     * @param nomeCientifico
     */
    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    /**
     * Retorna se a planta é espinhosa ou não;
     *
     * @return True ou False
     */
    public boolean isEspinhosa() {
        return espinhosa;
    }

    /**
     * Altera a variável espinhosa da planta;
     *
     * @param espinhosa
     */
    public void setEspinhosa(boolean espinhosa) {
        this.espinhosa = espinhosa;
    }

    /**
     * Retorna se a planta é suculenta ou não;
     *
     * @return True ou False
     */
    public boolean isSuculenta() {
        return suculenta;
    }

    /**
     * Altera a variável suculenta da planta;
     *
     * @param suculenta
     */
    public void setSuculenta(boolean suculenta) {
        this.suculenta = suculenta;
    }

    /**
     * Retorna se a planta é trepadeira ou não;
     *
     * @return True ou False
     */
    public boolean isTrepadeira() {
        return trepadeira;
    }

    /**
     * Altera a variável trepadeira da planta;
     *
     * @param trepadeira
     */
    public void setTrepadeira(boolean trepadeira) {
        this.trepadeira = trepadeira;
    }

    /**
     * Retorna se a planta é comestível ou não;
     *
     * @return True ou False
     */
    public boolean isComestivel() {
        return comestivel;
    }

    /**
     * Altera a variável comestivel da planta;
     *
     * @param comestivel
     */
    public void setComestivel(boolean comestivel) {
        this.comestivel = comestivel;
    }

    /**
     * Retorna se a planta é ornamental ou não;
     *
     * @return True ou False
     */
    public boolean isOrnamental() {
        return ornamental;
    }

    /**
     * Altera a variável ornamental da planta;
     *
     * @param ornamental
     */
    public void setOrnamental(boolean ornamental) {
        this.ornamental = ornamental;
    }

    /**
     * Retorna se a planta é processada ou não;
     *
     * @return True ou False
     */
    public boolean isProcessada() {
        return processada;
    }

    /**
     * Altera a variável processada da planta;
     *
     * @param processada
     */
    public void setProcessada(boolean processada) {
        this.processada = processada;
    }

    /**
     * Retorna se a planta é floral ou não;
     *
     * @return True ou False
     */
    public boolean isFloral() {
        return floral;
    }

    /**
     * Altera a variável floral da planta;
     *
     * @param floral
     */
    public void setFloral(boolean floral) {
        this.floral = floral;
    }

    /**
     * Retorna a quantidade de rega necessária para a planta;
     *
     * @return Quantidade de rega da planta
     */
    public int getRega() {
        return rega;
    }

    /**
     * Altera a variável rega da planta;
     *
     * @param rega
     */
    public void setRega(int rega) {
        this.rega = rega;
    }

    /**
     * Retorna a quantidade necessária de exposição solar da planta;
     *
     * @return Quantidade de exposição solar da planta
     */
    public float getExposicaoSolar() {
        return exposicaoSolar;
    }

    /**
     * Altera a variável exposicaoSolar da planta;
     *
     * @param exposicaoSolar
     */
    public void setExposicaoSolar(float exposicaoSolar) {
        this.exposicaoSolar = exposicaoSolar;
    }

    /**
     * Retorna a forma de adubagem da planta;
     *
     * @return Forma de adubagem da planta
     */
    public String getAdubagem() {
        return adubagem;
    }

    /**
     * Altera a variável adubagem da planta;
     *
     * @param adubagem
     */
    public void setAdubagem(String adubagem) {
        this.adubagem = adubagem;
    }
}
