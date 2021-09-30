# Counting words
## Prerequisite:
- Docker must be installed

## Run the application
- make dc-build-up

## Endpoints

## Get the highest frequency
- curl --location --request GET 'http://localhost:8080/word-frequency/api/words/highest-frequency?text=The sun shines over the lake'

## Get the frequency for the word
- curl --location --request GET 'http://localhost:8080/word-frequency/api/words/frequency-for-word?text=The sun shines over THe lake&word=THE'

## Get the frequencies of most frequent n words
curl --location --request GET 'http://localhost:8080/word-frequency/api/words/most-n-frequent?text=The sun shines over the lake&nFrequentWords=3'