/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Robi
 * Created: 10-mag-2017
 */

/* nome db:ammdb  nome utente: nerd  password: nerd */

/*tabella relativa agli utenti*/
CREATE TABLE utente(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(256),
    cognome VARCHAR(256),
    email VARCHAR(256),
    password VARCHAR(256),
    urlProfilo VARCHAR(256),
    dataNascita DATE,
    presentazione VARCHAR(256)
    --idUtente
);

/*Creo la tabella relativa al tipo di url: IMAGE, LINK, NULL*/
CREATE TABLE tipoUrl(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    tipo VARCHAR(100)
);

/*Creazione della tabella dei post*/
CREATE TABLE post(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    utente INTEGER,
    FOREIGN KEY (utente) REFERENCES utente(id),
    contentText VARCHAR(200), --modifica contenuto testo
    url VARCHAR(32),
    tipoPost INTEGER,
    FOREIGN KEY (tipoPost) REFERENCES tipoUrl(id)
);

/*Creazione della tabella dei gruppi*/
CREATE TABLE gruppo(
    idGruppo INTEGER,
    nome VARCHAR(256),
    amministratore INTEGER,
    FOREIGN KEY (amministratore) REFERENCES utente(id),
    descrizione VARCHAR(400)
);

/*Creazione una tabella relativa agli utenti per ogni gruppo*/
CREATE TABLE utentePerOgniGruppo(
    utente INTEGER,
    FOREIGN KEY (utente) REFERENCES utente(id),
    gruppo INTEGER,
    PRIMARY KEY (utente, gruppo)
);

/*Popolo la tabella relativa agli utenti*/
INSERT INTO utente (id, nome, cognome, email, password, urlProfilo, dataNascita, presentazione)
VALUES (0,
        'Mario',
        'Bros',
        'mariobros@gmail.com',
        '0000',
        'img/SuperMario.jpg',
        '1900-03-10',
        'Ciao, sono Mario!'),
        (1,
        'Neo',
        'Cortex',
        'cortex@gmail.com',
        '9001',
        'img/neocortex.jpg',
        '1930-12-04',
        'Ciao, sono Cortex e sono un super cattivo! Mhuahahahah'),
        (2,
        'Crash',
        'Bandicoot',
        'crashbandicoot@gmail.com',
        '5678',
        'img/crash.jpg',
        '1910-07-22',
        'Ciao, sono Crash!'),
        (3,
        'Luigi',
        'Bros',
        'luigino@gmail.com',
        '1234',
        'img/luigi.png',
        '1930-07-16',
        'Ciao, sono Luigi!');

/*Popolamento tabella tipoUrl*/
INSERT INTO tipoUrl (id, tipo)
VALUES (0, 'NULL');

INSERT INTO tipoUrl (id, tipo)
VALUES (1, 'IMAGE');

INSERT INTO tipoUrl (id, tipo)
VALUES (2, 'LINK');

/*Popolo la tabella di tipo post*/
INSERT INTO post(id, utente, contentText, url, tipoPost)
        VALUES (0,
                0,
                'Luigi, ti aspetto in pista!',
                'img/SuperMario.jpg',
                0);

INSERT INTO post(id, utente, contentText, url, tipoPost)
        VALUES (1,
                1,
                'Preparati ad affrontare la mia ira, Crash Bandicoot!',
                'img/neocortex.jpg',
                1);

INSERT INTO post(id, utente, contentText, url, tipoPost)
        VALUES (2,
                2,
                'Ehi Cortex, dai una occhiata qua: https://www.youtube.com/watch?v=DYjcZ5e5-iM',
                'img/crash.jpg',
                2);

INSERT INTO post(id, utente, contentText, url, tipoPost)
        VALUES (3,
                3,
                'Mario, guarda come eravamo giovani!',
                'img/luigi.png',
                1);

/*Popolo la tabella relativa ai gruppi*/
INSERT INTO gruppo(idGruppo, nome, amministratore, descrizione)
        VALUES (0,
                'Nintendo',
                0,
                'Ciao a tutti, se siete dei grandi fan della Nintendo, unitevi a noi!');
                
INSERT INTO gruppo(idGruppo, nome, amministratore, descrizione)
        VALUES (1,
                'Playstation',
                0,
                'Ciao a tutti, se siete dei grandi fan della Sony, quindi della playstation unitevi a noi!');
 /*aggiungi idpost e idgruppo*/