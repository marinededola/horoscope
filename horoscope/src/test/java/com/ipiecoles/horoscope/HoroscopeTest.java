package com.ipiecoles.horoscope;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.time.LocalDate;

public class HoroscopeTest {

   /* private static Document convertStringToXMLDocument2(String xmlString)
    // ATTETION 2 import possible (pas sur d'avoir pris le bon)
    {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try
        {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }*/

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
                "  <description>Horoscope Taureau du jour</description>\n" +
                "  <language>fr-fr</language>\n" +
                "  <copyright>Copyright 1998-2021 AsiaFlash.com. Tous droits réservés.</copyright>\n" +
                "  <image>\n" +
                "    <url>https://www.asiaflash.com/anh/asiaflash_logo.jpg</url>\n" +
                "    <title>Horoscope du jour</title>\n" +
                "    <link>https://www.asiaflash.com/horoscope/horoscope-quotidien.html</link>\n" +
                "  </image>\n" +
                "  <pubDate>Thu, 11 Feb 2021 00:05:01 +0100</pubDate>\n" +
                "  <atom:link href=\"https://www.asiaflash.com/horoscope/rss_horojour_taureau.xml\" rel=\"self\" type=\"application/rss+xml\" />\n" +
                "  <item>\n" +
                "    <title>Horoscope Taureau du Jeudi 11 Février 2021</title>\n" +
                "    <link>https://www.asiaflash.com/horoscope/horoscope-taureau.html</link>\n" +
                "    <category>Horoscope traditionnel du jour</category>\n" +
                "    <description>\n" +
                "&lt;br/&gt;&lt;center&gt;&lt;br/&gt;&lt;img src=\"https://www.asiaflash.com/anh/af_occ02_02_taureau.jpg\" alt=\"Taureau\" title=\"Taureau\"/&gt;&lt;/center&gt;\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Amour&lt;/b&gt;&lt;br&gt;\n" +
                "Un déséquilibre pourra commencer aujourd'hui à s'installer entre votre conjoint ou partenaire et vous. L'un de vous deux sera tellement possessif que l'autre ne pourra le supporter. Vous aurez besoin de tout votre calme pour détendre la situation. Pour les solitaires, la vie amoureuse ne sera pas cette fois sur le devant de la scène, mais cela ne les empêchera pas d'avoir droit à des moments de bonheur. Une nette envie de tomber amoureux qui, dans quelques cas, se traduira par un joli coup de coeur.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Argent&lt;/b&gt;&lt;br&gt;\n" +
                "Le secteur argent sera mis en vedette. La chance va vous sourire. Vos finances se porteront le mieux du monde. Cela dit, avec cet aspect de Saturne, vous devrez rester très prudent et éviter toutes les dépenses inutiles. Si vous souhaitez vous lancer dans un achat important ou modifier vos placements, sachez que le moment est assez mal choisi.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Santé&lt;/b&gt;&lt;br&gt;\n" +
                "Cet aspect de Mars vous donnera un coup de fouet aujourd'hui. Elle rendra leur tonus à ceux d'entre vous qui sont anémiés. Mais n'allez pas au-delà de vos forces. Conservez toujours une marge de sécurité.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Travail&lt;/b&gt;&lt;br&gt;\n" +
                "Si vous devez faire un choix important concernant votre avenir professionnel, attendez de préférence encore quelques jours. Vous serez dans de meilleures dispositions d'esprit.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Famille&lt;/b&gt;&lt;br&gt;\n" +
                "Aucune planète ne viendra aujourd'hui affecter les secteurs de votre thème liés à vos proches. Il y aura donc toutes les chances pour que votre vie de famille suive son cours sans événement notable à signaler. Ceux qui ont des enfants devraient en profiter pour s'impliquer plus étroitement dans leurs activités, de manière à les aider si une difficulté se présente.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Vie sociale&lt;/b&gt;&lt;br&gt;\n" +
                "Si vous êtes confronté à des problèmes personnels ou familiaux, le soutien de vos amis vous procurera un grand réconfort. Toutefois, évitez de vous laisser trop influencer par les conseils des uns et des autres.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Citation du jour&lt;/b&gt;&lt;br&gt;\n" +
                "Qui ne sait se borner ne sut jamais écrire (Boileau).\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Nombre de chance&lt;/b&gt;&lt;br&gt;\n" +
                "906\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Clin d'oeil&lt;/b&gt;&lt;br&gt;\n" +
                "Tout sera question de rythme : trouver le vôtre, respecter celui des autres, et ne pas vous énerver si les choses n'avancent pas aussi vite que vous le souhaiteriez.\n" +
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
                "    <guid isPermaLink=\"false\">rss_horojour_taureau_20210211</guid>\n" +
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
        Assertions.assertThat(horoscopeOutPut.getDescription()).isEqualTo("\"<br/><center><br/><img src=\\\"https://www.asiaflash.com/anh/af_occ02_01_belier.jpg\\\" alt=\\\"Bélier\\\" title=\\\"Bélier\\\"/></center> <br><br><b>Horoscope Bélier - Amour</b><br> Vénus en aspect harmonique protégera votre vie conjugale. Cette journée sera agréable à vivre, marquée par un regain de sensualité et de passion. Mais attention : si votre couple traverse une crise importante, Vénus à elle toute seule ne parviendra pas à redresser la situation, et vous ne devrez donc pas vous faire trop d'illusions. Célibataire, vous ferez de véritables ravages. Attention à ceux qui vous entourent ! Pourtant, même si vous jonglez avec les coeurs, vous vous arrangerez pour éviter les complications. <br><br><b>Horoscope Bélier - Argent</b><br> Vénus est une planète bénéfique et devrait vous porter chance en matière pécuniaire. Il faudra pourtant éviter de prendre trop de risques et vous méfier des envies d'achat déraisonnables. <br><br><b>Horoscope Bélier - Santé</b><br> Les astres vous inclineront à prendre des initiatives positives pour clarifier votre état de santé, et ainsi dominer tous vos doutes et toutes vos inquiétudes dans ce domaine. Un bon check-up général serait recommandé ; la Sécurité Sociale vous en offre d'ailleurs un tous les cinq ans. N'hésitez plus, pour une raison ou une autre. <br><br><b>Horoscope Bélier - Travail</b><br> Vous serez bien décidé à aller au bout de vos projets. La planète Mars vous y aidera, en décuplant votre énergie. Cependant, les travaux de routine ne seront toujours pas votre tasse de thé ; évitez-les au maximum durant cette journée, ou confiez-les à une personne dont vous connaissez bien le sérieux et la ponctualité. <br><br><b>Horoscope Bélier - Famille</b><br> Nette amélioration de vos relations avec les personnes âgées de votre entourage familial. Tous ceux d'entre vous qui ont eu dernièrement du mal avec leurs parents vont enfin trouver un terrain d'entente et de dialogue. N'hésitez pas à leur rendre visite : vous pourrez profiter de cette complicité retrouvée. Avec vos enfants, la journée sera facile à vivre et agréable. <br><br><b>Horoscope Bélier - Vie sociale</b><br> Votre esprit de compétition sera très aiguisé. Que ce soit dans votre travail ou dans vos loisirs, vous chercherez à prouver que vous restez le meilleur. <br><br><b>Horoscope Bélier - Citation du jour</b><br> Chacun sa besace (proverbe français). <br><br><b>Horoscope Bélier - Nombre de chance</b><br> 558 <br><br><b>Horoscope Bélier - Clin d'oeil</b><br> Montrez-vous moins suggestible et moins influençable. <br><br> <center> <a href=\\\"https://www.asiaflash.com/horoscope-2021/\\\" target=\\\"_blank\\\"><font size=\\\"-1\\\">Horoscope 2021</font></a> | <a href=\\\"https://www.asiaflash.com/tarot/\\\" target=\\\"_blank\\\"><font size=\\\"-1\\\">Tarot gratuit</font></a> | <a href=\\\"https://www.asiaflash.com/horoscope/\\\" target=\\\"_blank\\\"><font size=\\\"-1\\\">Horoscopes</font></a> <br> <a href=\\\"https://www.asiaflash.com/\\\" target=\\\"_blank\\\"><font size=\\\"-1\\\">(c) AsiaFlash.com</font></a> </center>\\n\" +\n");
    }

    /*@Test
    public void affichageXML(){
        String xmlString = "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                "<rss version=\"2.0\" xmlns:atom=\"http://www.w3.org/2005/Atom\">\n" +
                "<channel>\n" +
                "  <title>Horoscope du jour</title>\n" +
                "  <link>https://www.asiaflash.com/horoscope/horoscope-quotidien.html</link>\n" +
                "  <description>Horoscope Taureau du jour</description>\n" +
                "  <language>fr-fr</language>\n" +
                "  <copyright>Copyright 1998-2021 AsiaFlash.com. Tous droits réservés.</copyright>\n" +
                "  <image>\n" +
                "    <url>https://www.asiaflash.com/anh/asiaflash_logo.jpg</url>\n" +
                "    <title>Horoscope du jour</title>\n" +
                "    <link>https://www.asiaflash.com/horoscope/horoscope-quotidien.html</link>\n" +
                "  </image>\n" +
                "  <pubDate>Thu, 11 Feb 2021 00:05:01 +0100</pubDate>\n" +
                "  <atom:link href=\"https://www.asiaflash.com/horoscope/rss_horojour_taureau.xml\" rel=\"self\" type=\"application/rss+xml\" />\n" +
                "  <item>\n" +
                "    <title>Horoscope Taureau du Jeudi 11 Février 2021</title>\n" +
                "    <link>https://www.asiaflash.com/horoscope/horoscope-taureau.html</link>\n" +
                "    <category>Horoscope traditionnel du jour</category>\n" +
                "    <description>\n" +
                "&lt;br/&gt;&lt;center&gt;&lt;br/&gt;&lt;img src=\"https://www.asiaflash.com/anh/af_occ02_02_taureau.jpg\" alt=\"Taureau\" title=\"Taureau\"/&gt;&lt;/center&gt;\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Amour&lt;/b&gt;&lt;br&gt;\n" +
                "Un déséquilibre pourra commencer aujourd'hui à s'installer entre votre conjoint ou partenaire et vous. L'un de vous deux sera tellement possessif que l'autre ne pourra le supporter. Vous aurez besoin de tout votre calme pour détendre la situation. Pour les solitaires, la vie amoureuse ne sera pas cette fois sur le devant de la scène, mais cela ne les empêchera pas d'avoir droit à des moments de bonheur. Une nette envie de tomber amoureux qui, dans quelques cas, se traduira par un joli coup de coeur.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Argent&lt;/b&gt;&lt;br&gt;\n" +
                "Le secteur argent sera mis en vedette. La chance va vous sourire. Vos finances se porteront le mieux du monde. Cela dit, avec cet aspect de Saturne, vous devrez rester très prudent et éviter toutes les dépenses inutiles. Si vous souhaitez vous lancer dans un achat important ou modifier vos placements, sachez que le moment est assez mal choisi.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Santé&lt;/b&gt;&lt;br&gt;\n" +
                "Cet aspect de Mars vous donnera un coup de fouet aujourd'hui. Elle rendra leur tonus à ceux d'entre vous qui sont anémiés. Mais n'allez pas au-delà de vos forces. Conservez toujours une marge de sécurité.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Travail&lt;/b&gt;&lt;br&gt;\n" +
                "Si vous devez faire un choix important concernant votre avenir professionnel, attendez de préférence encore quelques jours. Vous serez dans de meilleures dispositions d'esprit.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Famille&lt;/b&gt;&lt;br&gt;\n" +
                "Aucune planète ne viendra aujourd'hui affecter les secteurs de votre thème liés à vos proches. Il y aura donc toutes les chances pour que votre vie de famille suive son cours sans événement notable à signaler. Ceux qui ont des enfants devraient en profiter pour s'impliquer plus étroitement dans leurs activités, de manière à les aider si une difficulté se présente.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Vie sociale&lt;/b&gt;&lt;br&gt;\n" +
                "Si vous êtes confronté à des problèmes personnels ou familiaux, le soutien de vos amis vous procurera un grand réconfort. Toutefois, évitez de vous laisser trop influencer par les conseils des uns et des autres.\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Citation du jour&lt;/b&gt;&lt;br&gt;\n" +
                "Qui ne sait se borner ne sut jamais écrire (Boileau).\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Nombre de chance&lt;/b&gt;&lt;br&gt;\n" +
                "906\n" +
                "\n" +
                "&lt;br&gt;&lt;br&gt;&lt;b&gt;Horoscope Taureau - Clin d'oeil&lt;/b&gt;&lt;br&gt;\n" +
                "Tout sera question de rythme : trouver le vôtre, respecter celui des autres, et ne pas vous énerver si les choses n'avancent pas aussi vite que vous le souhaiteriez.\n" +
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
                "    <guid isPermaLink=\"false\">rss_horojour_taureau_20210211</guid>\n" +
                "  </item>\n" +
                "</channel>\n" +
                "</rss>";
        Document docXML = convertStringToXMLDocument2(xmlString);
        System.out.println("dgfdghdh");
        System.out.println(docXML);

    }*/

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
