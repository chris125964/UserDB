INSERT INTO USER (VORNAME, NACHNAME, EMAIL, PASSWORT) values ('Angelika', 'Rott', 'Angelika',
			hash('SHA256', stringtoutf8('secret'), 1));
INSERT INTO USER (VORNAME, NACHNAME, EMAIL, PASSWORT) values ('Christian', 'Todd', 'Christian',
			hash('SHA256', stringtoutf8('secret'), 1));
INSERT INTO USER (VORNAME, NACHNAME, EMAIL, PASSWORT) values ('Matthias', 'Todd', 'Mats',
			hash('SHA256', stringtoutf8('secret'), 1));
INSERT INTO USER (VORNAME, NACHNAME, EMAIL, PASSWORT) values ('Clemens', 'Todd', 'Clemens',
			hash('SHA256', stringtoutf8('secret'), 1));
INSERT INTO USER (VORNAME, NACHNAME, EMAIL, PASSWORT) values ('Philipp', 'Tuttlies', 'tude',
			hash('SHA256', stringtoutf8('secret'), 1));
INSERT INTO USER (VORNAME, NACHNAME, EMAIL, PASSWORT) values ('Benjamin', 'Todd', 'Benni',
			hash('SHA256', stringtoutf8('secret'), 1));


INSERT INTO Gruppe (LETTER, ID) values ('A', 1);
INSERT INTO Gruppe (LETTER, ID) values ('B', 2);
INSERT INTO Gruppe (LETTER, ID) values ('C', 3);
INSERT INTO Gruppe (LETTER, ID) values ('D', 4);
INSERT INTO Gruppe (LETTER, ID) values ('E', 5);
INSERT INTO Gruppe (LETTER, ID) values ('F', 6);

INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (1, 'Kanada', 1, 1);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (2, 'China', 1, 2);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (3, 'Neuseeland', 1, 3);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (4, 'Niederlande', 1, 4);
--
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (5, 'Deutschland', 2, 1);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (6, 'Elfenbeinküste', 2, 2);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (7, 'Norwegen', 2, 3);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (8, 'Thailand', 2, 4);
--
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (9, 'Japan', 3, 1);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (10, 'Schweiz', 3, 2);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (11, 'Kamerun', 3, 3);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (12, 'Ecuador', 3, 4);
--
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (13, 'USA', 4, 1);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (14, 'Australien', 4, 2);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (15, 'Schweden', 4, 3);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (16, 'Nigeria', 4, 4);
--
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (17, 'Brasilien', 5, 1);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (18, 'Südkorea', 5, 2);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (19, 'Spanien', 5, 3);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (20, 'Costa Rica', 5, 4);
--
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (21, 'Frankreich', 6, 1);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (22, 'England', 6, 2);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (23, 'Kolumbien', 6, 3);
INSERT INTO TEAM (ID, NAME, GRUPPE_ID, NR) values (24, 'Mexico', 6, 4);
--

-- Matches in Gruppe A
INSERT INTO MATCH (ID, TEAM1_ID, TEAM2_ID) values (1, 1, 2);
INSERT INTO MATCH (ID, TEAM1_ID, TEAM2_ID) values (2, 3, 4);
INSERT INTO MATCH (ID, TEAM1_ID, TEAM2_ID) values (3, 2, 4);
INSERT INTO MATCH (ID, TEAM1_ID, TEAM2_ID) values (4, 1, 3);
INSERT INTO MATCH (ID, TEAM1_ID, TEAM2_ID) values (5, 4, 1);
INSERT INTO MATCH (ID, TEAM1_ID, TEAM2_ID) values (6, 2, 3);


-- Tipps in Gruppe A für User Christian
INSERT INTO RESULT (ID, GOALS1, GOALS2, MATCH_ID, USER_EMAIL) values (1, 0, 0, 1, 'Christian');
INSERT INTO RESULT (ID, GOALS1, GOALS2, MATCH_ID, USER_EMAIL) values (2, 0, 0, 2, 'Christian');
INSERT INTO RESULT (ID, GOALS1, GOALS2, MATCH_ID, USER_EMAIL) values (3, 0, 0, 3, 'Christian');
INSERT INTO RESULT (ID, GOALS1, GOALS2, MATCH_ID, USER_EMAIL) values (4, 0, 0, 4, 'Christian');
INSERT INTO RESULT (ID, GOALS1, GOALS2, MATCH_ID, USER_EMAIL) values (5, 0, 0, 5, 'Christian');
INSERT INTO RESULT (ID, GOALS1, GOALS2, MATCH_ID, USER_EMAIL) values (6, 0, 0, 6, 'Christian');

