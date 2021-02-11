# Horoscope

Récupérer l'horoscope du jour en fonction du signe envoyé.

## Requête HTTP

`POST /horoscope`

```json
{
    "signe": "Bélier"
}
```

Pour récupérer l'horoscope pour un signe particulier au format RSS : https://www.asiaflash.com/horoscope/rss_horojour_belier.xml ou https://www.asiaflash.com/horoscope/rss_horojour_taureau.xml... Attention aux retours chariot et aux guillemets !

## Réponse HTTP

```json
{
    "horoscope": "<h1>Horoscope du jour</h1> : ..."
}
```
