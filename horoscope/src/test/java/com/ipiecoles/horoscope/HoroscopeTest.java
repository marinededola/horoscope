package com.ipiecoles.horoscope;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

public class HoroscopeTest {

    @Test
    public void testHoroscope(){

        //Given
        Horoscope horoscope = new Horoscope();
        String signe = "Bélier";
        String donneesSigne = "{ \"Bélier\": [[\"Description\"]] }";


        //When
        HoroscopeData horoscopeData = horoscope.getHoroscope(signe, donneesSigne);

        //Then
        //Créer une classe avec..
        //Objet crée avec la bonne valeurs dans les attributs

        Assertions.assertThat(horoscopeData.getSigne()).isEqualTo("Bélier");
    }
}
