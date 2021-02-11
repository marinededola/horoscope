package com.ipiecoles.horoscope;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.time.LocalDate;

public class HoroscopeTest {

    @Test
    public void testHoroscope(){

        //Given
        Horoscope horoscope = new Horoscope();
        //String signe = "Bélier";
        String donneesSigne = "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                "<rss version=\"2.0\" xmlns:atom=\"http://www.w3.org/2005/Atom\">\n" +
                "<channel>\n" +
                "  <title>Horoscope du jour</title>\n" +
                "  <link>https://www.asiaflash.com/horoscope/horoscope-quotidien.html</link>\n" +
                "  <description>Horoscope Bélier du jour</description>\n" +
                "  <language>fr-fr</language>\n" +
                "  <copyright>Copyright 1998-2021 AsiaFlash.com. Tous droits réservés.</copyright>\n" +
                "  <image>\n" +
                "    <url>https://www.asiaflash.com/anh/asiaflash_logo.jpg</url>\n" +
                "    <title>Horoscope du jour</title>\n" +
                "    <link>https://www.asiaflash.com/horoscope/horoscope-quotidien.html</link>\n" +
                "  </image>\n" +
                "  <pubDate>Thu, 11 Feb 2021 00:05:01 +0100</pubDate>\n" +
                "  <atom:link href=\"https://www.asiaflash.com/horoscope/rss_horojour_belier.xml\" rel=\"self\" type=\"application/rss+xml\" />\n" +
                "  <item>\n" +
                "    <title>Horoscope Bélier du Jeudi 11 Février 2021</title>\n" +
                "    <link>https://www.asiaflash.com/horoscope/horoscope-belier.html</link>\n" +
                "    <category>Horoscope traditionnel du jour</category>\n" +
                "    <description>\n" +
                "&lt;br/&gt;&lt;center&gt;&lt;br/&gt;&lt;img src=\"https://www.asiaflash.com/anh/af_occ02_01_belier.jpg\" alt=\"Bélier\" title=\"Bélier\"/&gt;&lt;/center&gt;\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Bélier - Amour&lt;/b&gt;&lt;br&gt;\n" +
                "Vénus en aspect harmonique protégera votre vie conjugale. Cette journée sera agréable à vivre, marquée par un regain de sensualité et de passion. Mais attention : si votre couple traverse une crise importante, Vénus à elle toute seule ne parviendra pas à redresser la situation, et vous ne devrez donc pas vous faire trop d'illusions. Célibataire, vous ferez de véritables ravages. Attention à ceux qui vous entourent ! Pourtant, même si vous jonglez avec les coeurs, vous vous arrangerez pour éviter les complications.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Bélier - Argent&lt;/b&gt;&lt;br&gt;\n" +
                "Vénus est une planète bénéfique et devrait vous porter chance en matière pécuniaire. Il faudra pourtant éviter de prendre trop de risques et vous méfier des envies d'achat déraisonnables.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Bélier - Santé&lt;/b&gt;&lt;br&gt;\n" +
                "Les astres vous inclineront à prendre des initiatives positives pour clarifier votre état de santé, et ainsi dominer tous vos doutes et toutes vos inquiétudes dans ce domaine. Un bon check-up général serait recommandé ; la Sécurité Sociale vous en offre d'ailleurs un tous les cinq ans. N'hésitez plus, pour une raison ou une autre.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Bélier - Travail&lt;/b&gt;&lt;br&gt;\n" +
                "Vous serez bien décidé à aller au bout de vos projets. La planète Mars vous y aidera, en décuplant votre énergie. Cependant, les travaux de routine ne seront toujours pas votre tasse de thé ; évitez-les au maximum durant cette journée, ou confiez-les à une personne dont vous connaissez bien le sérieux et la ponctualité.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Bélier - Famille&lt;/b&gt;&lt;br&gt;\n" +
                "Nette amélioration de vos relations avec les personnes âgées de votre entourage familial. Tous ceux d'entre vous qui ont eu dernièrement du mal avec leurs parents vont enfin trouver un terrain d'entente et de dialogue. N'hésitez pas à leur rendre visite : vous pourrez profiter de cette complicité retrouvée. Avec vos enfants, la journée sera facile à vivre et agréable.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Bélier - Vie sociale&lt;/b&gt;&lt;br&gt;\n" +
                "Votre esprit de compétition sera très aiguisé. Que ce soit dans votre travail ou dans vos loisirs, vous chercherez à prouver que vous restez le meilleur.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Bélier - Citation du jour&lt;/b&gt;&lt;br&gt;\n" +
                "Chacun sa besace (proverbe français).\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Bélier - Nombre de chance&lt;/b&gt;&lt;br&gt;\n" +
                "558\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Bélier - Clin d'oeil&lt;/b&gt;&lt;br&gt;\n" +
                "Montrez-vous moins suggestible et moins influençable.\n" +
                "\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;\n" +
                "&lt;center&gt;\n" +
                "&lt;a href=&quot;https://www.asiaflash.com/horoscope-2021/&quot; target=&quot;_blank&quot;&gt;&lt;font size=&quot;-1&quot;&gt;Horoscope 2021&lt;/font&gt;&lt;/a&gt;\n" +
                "| &lt;a href=&quot;https://www.asiaflash.com/tarot/&quot; target=&quot;_blank&quot;&gt;&lt;font size=&quot;-1&quot;&gt;Tarot gratuit&lt;/font&gt;&lt;/a&gt;\n" +
                "| &lt;a href=&quot;https://www.asiaflash.com/horoscope/&quot; target=&quot;_blank&quot;&gt;&lt;font size=&quot;-1&quot;&gt;Horoscopes&lt;/font&gt;&lt;/a&gt;\n" +
                "&lt;br&gt;\n" +
                "&lt;a href=&quot;https://www.asiaflash.com/&quot; target=&quot;_blank&quot;&gt;&lt;font size=&quot;-1&quot;&gt;(c) AsiaFlash.com&lt;/font&gt;&lt;/a&gt;\n" +
                "&lt;/center&gt;\n" +
                "\n" +
                "    </description>\n" +
                "    <pubDate>Thu, 11 Feb 2021 00:05:01 +0100</pubDate>\n" +
                "    <guid isPermaLink=\"false\">rss_horojour_belier_20210211</guid>\n" +
                "  </item>\n" +
                "</channel>\n" +
                "</rss>";


        //When
        //crée methode getDataFromSigne(signe)
        HoroscopeOutPut horoscopeOutPut = horoscope.getHoroscope(donneesSigne);

        //Then
        //Créer une classe avec..
        //Objet crée avec la bonne valeurs dans les attributs

        // recuperer la description horoscope
        Assertions.assertThat(horoscopeOutPut.getDescription()).isEqualTo(" <br/><center><br/><img src=\"https://www.asiaflash.com/anh/af_occ02_01_belier.jpg\" alt=\"Bélier\" title=\"Bélier\"/></center> <br><br><b>Horoscope Bélier - Amour</b><br> Vénus en aspect harmonique protégera votre vie conjugale. Cette journée sera agréable à vivre, marquée par un regain de sensualité et de passion. Mais attention : si votre couple traverse une crise importante, Vénus à elle toute seule ne parviendra pas à redresser la situation, et vous ne devrez donc pas vous faire trop d'illusions. Célibataire, vous ferez de véritables ravages. Attention à ceux qui vous entourent ! Pourtant, même si vous jonglez avec les coeurs, vous vous arrangerez pour éviter les complications.  <br><br><b>Horoscope Bélier - Argent</b><br> Vénus est une planète bénéfique et devrait vous porter chance en matière pécuniaire. Il faudra pourtant éviter de prendre trop de risques et vous méfier des envies d'achat déraisonnables.  <br><br><b>Horoscope Bélier - Santé</b><br> Les astres vous inclineront à prendre des initiatives positives pour clarifier votre état de santé, et ainsi dominer tous vos doutes et toutes vos inquiétudes dans ce domaine. Un bon check-up général serait recommandé ; la Sécurité Sociale vous en offre d'ailleurs un tous les cinq ans. N'hésitez plus, pour une raison ou une autre.  <br><br><b>Horoscope Bélier - Travail</b><br> Vous serez bien décidé à aller au bout de vos projets. La planète Mars vous y aidera, en décuplant votre énergie. Cependant, les travaux de routine ne seront toujours pas votre tasse de thé ; évitez-les au maximum durant cette journée, ou confiez-les à une personne dont vous connaissez bien le sérieux et la ponctualité.  <br><br><b>Horoscope Bélier - Famille</b><br> Nette amélioration de vos relations avec les personnes âgées de votre entourage familial. Tous ceux d'entre vous qui ont eu dernièrement du mal avec leurs parents vont enfin trouver un terrain d'entente et de dialogue. N'hésitez pas à leur rendre visite : vous pourrez profiter de cette complicité retrouvée. Avec vos enfants, la journée sera facile à vivre et agréable.  <br><br><b>Horoscope Bélier - Vie sociale</b><br> Votre esprit de compétition sera très aiguisé. Que ce soit dans votre travail ou dans vos loisirs, vous chercherez à prouver que vous restez le meilleur.  <br><br><b>Horoscope Bélier - Citation du jour</b><br> Chacun sa besace (proverbe français).  <br><br><b>Horoscope Bélier - Nombre de chance</b><br> 558  <br><br><b>Horoscope Bélier - Clin d'oeil</b><br> Montrez-vous moins suggestible et moins influençable.   <br><br> <center> <a href=\"https://www.asiaflash.com/horoscope-2021/\" target=\"_blank\"><font size=\"-1\">Horoscope 2021</font></a> | <a href=\"https://www.asiaflash.com/tarot/\" target=\"_blank\"><font size=\"-1\">Tarot gratuit</font></a> | <a href=\"https://www.asiaflash.com/horoscope/\" target=\"_blank\"><font size=\"-1\">Horoscopes</font></a> <br> <a href=\"https://www.asiaflash.com/\" target=\"_blank\"><font size=\"-1\">(c) AsiaFlash.com</font></a> </center>      ");
    }


    @Test
    public void testHoroscopeSigneNull(){

        //Given
        Horoscope horoscope = new Horoscope();
        String signe = null;
        String donneesSigne = "BLABLA";


        //When
        HoroscopeData horoscopeData = horoscope.getHoroscope(signe, donneesSigne);

        //Then
        //Créer une classe avec..
        //Objet crée avec la bonne valeurs dans les attributs

        Assertions.assertThat(horoscopeData.getSigne()).isNull();
    }
}
