package plantaplus.plantaplus.model;

public class Planta {

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

    public Planta(String nomePopular) {
        // default
    }

    public Planta(String nomePopular, String nomeCientifico) {
        this.nomePopular = nomePopular;
        this.nomeCientifico = nomeCientifico;
    }

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

    public String getNomePopular() {
        return nomePopular;
    }

    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public boolean isEspinhosa() {
        return espinhosa;
    }

    public void setEspinhosa(boolean espinhosa) {
        this.espinhosa = espinhosa;
    }

    public boolean isSuculenta() {
        return suculenta;
    }

    public void setSuculenta(boolean suculenta) {
        this.suculenta = suculenta;
    }

    public boolean isTrepadeira() {
        return trepadeira;
    }

    public void setTrepadeira(boolean trepadeira) {
        this.trepadeira = trepadeira;
    }

    public boolean isComestivel() {
        return comestivel;
    }

    public void setComestivel(boolean comestivel) {
        this.comestivel = comestivel;
    }

    public boolean isOrnamental() {
        return ornamental;
    }

    public void setOrnamental(boolean ornamental) {
        this.ornamental = ornamental;
    }

    public boolean isProcessada() {
        return processada;
    }

    public void setProcessada(boolean processada) {
        this.processada = processada;
    }

    public boolean isFloral() {
        return floral;
    }

    public void setFloral(boolean floral) {
        this.floral = floral;
    }

    public int getRega() {
        return rega;
    }

    public void setRega(int rega) {
        this.rega = rega;
    }

    public float getExposicaoSolar() {
        return exposicaoSolar;
    }

    public void setExposicaoSolar(float exposicaoSolar) {
        this.exposicaoSolar = exposicaoSolar;
    }

    public String getAdubagem() {
        return adubagem;
    }

    public void setAdubagem(String adubagem) {
        this.adubagem = adubagem;
    }
}
