package plantaplus.plantaplus.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pichau on 12/3/2017.
 */
public class PlantaTest {
    Planta teste1 = new Planta("Teste1", "TesteNome1", true,
            true, true, true, true,
            true, true, 7, 12, "");
    Planta teste2 = new Planta("Teste2", "TesteNome2", false,
            false, false, false, false,
            false, false, 1, 1, "");

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getNomePopular1() throws Exception {
        String expected;
        expected = "Teste1";
        assertEquals(teste1.getNomePopular(), expected);
    }

    @Test
    public void getNomePopular2() throws Exception {
        String expected;
        expected = "Teste2";
        assertEquals(teste2.getNomePopular(), expected);
    }

    @Test
    public void setNomePopular1() throws Exception {
        String input, expected;
        expected = input = "TesteNovamente1";
        teste1.setNomePopular(input);
        assertEquals(teste1.getNomePopular(), expected);
    }

    @Test
    public void setNomePopular2() throws Exception {
        String input, expected;
        expected = input = "TesteNovamente2";
        teste2.setNomePopular(input);
        assertEquals(teste2.getNomePopular(), expected);
    }

    @Test
    public void getNomeCientifico1() throws Exception {
        String expected;
        expected = "TesteNome1";
        assertEquals(teste1.getNomeCientifico(), expected);
    }

    @Test
    public void getNomeCientifico2() throws Exception {
        String expected;
        expected = "TesteNome2";
        assertEquals(teste2.getNomeCientifico(), expected);
    }

    @Test
    public void setNomeCientifico1() throws Exception {
        String input, expected;
        expected = input = "TesteNovamenteMesmo1";
        teste1.setNomeCientifico(input);
        assertEquals(teste1.getNomeCientifico(), expected);
    }

    @Test
    public void setNomeCientifico2() throws Exception {
        String input, expected;
        expected = input = "TesteNovamenteMesmo2";
        teste2.setNomeCientifico(input);
        assertEquals(teste2.getNomeCientifico(), expected);
    }

    @Test
    public void isEspinhosa1() throws Exception {
        assertEquals(teste1.isEspinhosa(), true);
    }

    @Test
    public void isEspinhosa2() throws Exception {
        assertEquals(teste2.isEspinhosa(), false);
    }

    @Test
    public void setEspinhosa11() throws Exception {
        teste1.setEspinhosa(false);
        assertEquals(teste1.isEspinhosa(), false);
    }

    @Test
    public void setEspinhosa12() throws Exception {
        teste2.setEspinhosa(true);
        assertEquals(teste2.isEspinhosa(), true);
    }

    @Test
    public void isSuculenta1() throws Exception {
        assertEquals(teste1.isSuculenta(), true);
    }

    @Test
    public void isSuculenta2() throws Exception {
        assertEquals(teste2.isSuculenta(), false);
    }

    @Test
    public void setSuculenta1() throws Exception {
        teste1.setSuculenta(false);
        assertEquals(teste1.isSuculenta(), false);
    }

    @Test
    public void setSuculenta2() throws Exception {
        teste2.setSuculenta(true);
        assertEquals(teste2.isSuculenta(), true);
    }

    @Test
    public void isTrepadeira1() throws Exception {
        assertEquals(teste1.isTrepadeira(), true);
    }

    @Test
    public void isTrepadeira2() throws Exception {
        assertEquals(teste2.isTrepadeira(), false);
    }

    @Test
    public void setTrepadeira1() throws Exception {
        teste1.setTrepadeira(false);
        assertEquals(teste1.isTrepadeira(), false);
    }

    @Test
    public void setTrepadeira2() throws Exception {
        teste2.setTrepadeira(true);
        assertEquals(teste2.isTrepadeira(), true);
    }

    @Test
    public void isComestivel1() throws Exception {
        assertEquals(teste1.isComestivel(), true);
    }

    @Test
    public void isComestivel2() throws Exception {
        assertEquals(teste2.isComestivel(), false);
    }

    @Test
    public void setComestivel1() throws Exception {
        teste1.setComestivel(false);
        assertEquals(teste1.isComestivel(), false);
    }

    @Test
    public void setComestivel2() throws Exception {
        teste2.setComestivel(true);
        assertEquals(teste2.isComestivel(), true);
    }

    @Test
    public void isOrnamental1() throws Exception {
        assertEquals(teste1.isOrnamental(), true);
    }

    @Test
    public void isOrnamental2() throws Exception {
        assertEquals(teste2.isOrnamental(), false);
    }

    @Test
    public void setOrnamental1() throws Exception {
        teste1.setOrnamental(false);
        assertEquals(teste1.isOrnamental(), false);
    }

    @Test
    public void setOrnamental2() throws Exception {
        teste2.setOrnamental(true);
        assertEquals(teste2.isOrnamental(), true);
    }

    @Test
    public void isProcessada1() throws Exception {
        assertEquals(teste1.isProcessada(), true);
    }

    @Test
    public void isProcessada2() throws Exception {
        assertEquals(teste2.isProcessada(), false);
    }

    @Test
    public void setProcessada1() throws Exception {
        teste1.setProcessada(false);
        assertEquals(teste1.isProcessada(), false);
    }

    @Test
    public void setProcessada2() throws Exception {
        teste2.setProcessada(true);
        assertEquals(teste2.isProcessada(), true);
    }

    @Test
    public void isFloral1() throws Exception {
        assertEquals(teste1.isFloral(), true);
    }

    @Test
    public void isFloral2() throws Exception {
        assertEquals(teste2.isFloral(), false);
    }

    @Test
    public void setFloral1() throws Exception {
        teste1.setFloral(false);
        assertEquals(teste1.isFloral(), false);
    }

    @Test
    public void setFloral2() throws Exception {
        teste2.setFloral(true);
        assertEquals(teste2.isFloral(), true);
    }

    @Test
    public void getRega1() throws Exception {
        assertEquals(teste1.getRega(), 7);
    }

    @Test
    public void getRega2() throws Exception {
        assertEquals(teste2.getRega(), 1);
    }


    @Test
    public void setRega1() throws Exception {
        teste1.setRega(7);
        assertEquals(teste1.getRega(), 7);
    }

    @Test
    public void setRega2() throws Exception {
        teste2.setRega(4);
        assertEquals(teste2.getRega(), 4);
    }

    @Test
    public void getExposicaoSolar1() throws Exception {
        assertEquals(teste1.getExposicaoSolar(), 12, 0.1);
    }

    @Test
    public void getExposicaoSolar2() throws Exception {
        assertEquals(teste2.getExposicaoSolar(), 1, 0.1);
    }

    @Test
    public void setExposicaoSolar1() throws Exception {
        teste1.setExposicaoSolar(5);
        assertEquals(teste1.getExposicaoSolar(), 5, 0.1);
    }

    @Test
    public void setExposicaoSolar2() throws Exception {
        teste2.setExposicaoSolar(7);
        assertEquals(teste2.getExposicaoSolar(), 7, 0.1);
    }
}