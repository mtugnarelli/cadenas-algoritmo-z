package ar.uba.fi.cadenas;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestCalcularZ {

    private String cadena;
    private int[] zEsperado;
    
    public TestCalcularZ(String cadena, int[] zEsperado) {

        this.cadena = cadena;
        this.zEsperado = zEsperado;
    }
    
    @Test
    public void calcularZ() {
        
        AlgoritmoZ algoritmo = new AlgoritmoZ(this.cadena);

        for (int i = 1; i <= zEsperado.length; i++) {
            
            assertThat("Z[" + i + "]", algoritmo.z(i), is( equalTo( zEsperado[i - 1] )));
        }
    }

    @Parameters(name = "{0}")
    public static Collection<Object[]> obtenerParametros() {

        return Arrays.asList(
                    new Object[] { "aa" , new int[] { 1 } }, 
                    new Object[] { "aaa" , new int[] { 2, 1 } }, 
                    new Object[] { "aaaa" , new int[] { 3, 2, 1 } }, 
                    new Object[] { "aaaaa" , new int[] { 4, 3, 2, 1 } }, 
                    new Object[] { "aaaaaa" , new int[] { 5, 4, 3, 2, 1 } }, 
                    new Object[] { "aabcaabxaaz" , new int[] { 1, 0, 0, 3, 1, 0, 0, 2, 1, 0 } }, 
                    new Object[] { "bbaababcabbaaba" , new int[] { 1, 0, 0, 1, 0, 1, 0, 0, 6, 1, 0, 0, 1, 0 } },
                    new Object[] { "abcabcabcabcabcabc" , new int[] { 0, 0, 15, 0, 0, 12, 0, 0, 9, 0, 0, 6, 0, 0, 3, 0, 0} },
                    new Object[] { "bbbaabbaasbx" , new int[] { 2, 1, 0, 0, 2, 1, 0, 0, 0, 1, 0 } }, 
                    new Object[] { "ab" , new int[] { 0 } } 
                );
    }


}
