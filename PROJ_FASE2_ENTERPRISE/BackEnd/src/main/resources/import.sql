-- TBL_BRQ_CATEGORIA_SKILL
INSERT INTO TBL_BRQ_CATEGORIA_SKILL (ID_CATEGORIA_SKILL,DH_CRIADO,ST_INATIVO,NM_NOME) VALUES (SEQ_TBL_BRQ_CATEGORIA_SKILL.NEXTVAL, SYSDATE, 0, 'Linguagem');
INSERT INTO TBL_BRQ_CATEGORIA_SKILL (ID_CATEGORIA_SKILL,DH_CRIADO,ST_INATIVO,NM_NOME) VALUES (SEQ_TBL_BRQ_CATEGORIA_SKILL.NEXTVAL, SYSDATE, 0, 'Tecnologia');
INSERT INTO TBL_BRQ_CATEGORIA_SKILL (ID_CATEGORIA_SKILL,DH_CRIADO,ST_INATIVO,NM_NOME) VALUES (SEQ_TBL_BRQ_CATEGORIA_SKILL.NEXTVAL, SYSDATE, 0, 'Projeto');

-- TBL_BRQ_SKILL
INSERT INTO TBL_BRQ_SKILL (ID_SKILL,DH_CRIADO,ST_INATIVO,NM_NOME,ID_CATEGORIA_SKILL) VALUES (SEQ_TBL_BRQ_SKILL.NEXTVAL, SYSDATE, 0, 'Java',1);
INSERT INTO TBL_BRQ_SKILL (ID_SKILL,DH_CRIADO,ST_INATIVO,NM_NOME,ID_CATEGORIA_SKILL) VALUES (SEQ_TBL_BRQ_SKILL.NEXTVAL, SYSDATE, 0, 'C#',1);
INSERT INTO TBL_BRQ_SKILL (ID_SKILL,DH_CRIADO,ST_INATIVO,NM_NOME,ID_CATEGORIA_SKILL) VALUES (SEQ_TBL_BRQ_SKILL.NEXTVAL, SYSDATE, 0, 'Scrum',3);
INSERT INTO TBL_BRQ_SKILL (ID_SKILL,DH_CRIADO,ST_INATIVO,NM_NOME,ID_CATEGORIA_SKILL) VALUES (SEQ_TBL_BRQ_SKILL.NEXTVAL, SYSDATE, 0, 'Node.js',2);
INSERT INTO TBL_BRQ_SKILL (ID_SKILL,DH_CRIADO,ST_INATIVO,NM_NOME,ID_CATEGORIA_SKILL) VALUES (SEQ_TBL_BRQ_SKILL.NEXTVAL, SYSDATE, 0, 'JavaScript',1);
INSERT INTO TBL_BRQ_SKILL (ID_SKILL,DH_CRIADO,ST_INATIVO,NM_NOME,ID_CATEGORIA_SKILL) VALUES (SEQ_TBL_BRQ_SKILL.NEXTVAL, SYSDATE, 0, 'Spring Boot',2);

-- TBL_BRQ_CERTIFICADO
INSERT INTO TBL_BRQ_CERTIFICADO (ID_CERTIFICADO,DH_CRIADO,ST_INATIVO,NM_NOME, ID_SKILL) VALUES (SEQ_TBL_BRQ_CERTIFICADO.NEXTVAL, SYSDATE, 0, 'Scrum Master Professional', 3);
INSERT INTO TBL_BRQ_CERTIFICADO (ID_CERTIFICADO,DH_CRIADO,ST_INATIVO,NM_NOME, ID_SKILL) VALUES (SEQ_TBL_BRQ_CERTIFICADO.NEXTVAL, SYSDATE, 0, 'Spring Professional', 6);
INSERT INTO TBL_BRQ_CERTIFICADO (ID_CERTIFICADO,DH_CRIADO,ST_INATIVO,NM_NOME, ID_SKILL) VALUES (SEQ_TBL_BRQ_CERTIFICADO.NEXTVAL, SYSDATE, 0, 'JavaScript Professional', 5);
INSERT INTO TBL_BRQ_CERTIFICADO (ID_CERTIFICADO,DH_CRIADO,ST_INATIVO,NM_NOME, ID_SKILL) VALUES (SEQ_TBL_BRQ_CERTIFICADO.NEXTVAL, SYSDATE, 0, 'Microsoft C# Professional', 2);


-- TBL_BRQ_CANDIDATO
INSERT INTO TBL_BRQ_CANDIDATO (ID_CANDIDATO,DH_CRIADO,ST_INATIVO,NR_CPF,DS_EMAIL,ST_GENERO,DT_NASCIMENTO,NM_NOME,NR_TELEFONE) VALUES (SEQ_TBL_BRQ_CANDIDATO.NEXTVAL, SYSDATE, 0, '12345678901', 'filipe@fiap.com.br', 'M', TIMESTAMP '1985-02-03 00:00:00.000000','Filipe Holanda','11998761234');
INSERT INTO TBL_BRQ_CANDIDATO (ID_CANDIDATO,DH_CRIADO,ST_INATIVO,NR_CPF,DS_EMAIL,ST_GENERO,DT_NASCIMENTO,NM_NOME,NR_TELEFONE) VALUES (SEQ_TBL_BRQ_CANDIDATO.NEXTVAL, SYSDATE, 0, '32145678901', 'paulo@fiap.com.br', 'M', TIMESTAMP '1986-04-05 00:00:00.000000','Paulo Grillo','2112344321');
INSERT INTO TBL_BRQ_CANDIDATO (ID_CANDIDATO,DH_CRIADO,ST_INATIVO,NR_CPF,DS_EMAIL,ST_GENERO,DT_NASCIMENTO,NM_NOME,NR_TELEFONE) VALUES (SEQ_TBL_BRQ_CANDIDATO.NEXTVAL, SYSDATE, 0, '45645678901', 'thais@fiap.com.br', 'F', TIMESTAMP '1987-05-06 00:00:00.000000','Thais Lenhard','1112341234');
INSERT INTO TBL_BRQ_CANDIDATO (ID_CANDIDATO,DH_CRIADO,ST_INATIVO,NR_CPF,DS_EMAIL,ST_GENERO,DT_NASCIMENTO,NM_NOME,NR_TELEFONE) VALUES (SEQ_TBL_BRQ_CANDIDATO.NEXTVAL, SYSDATE, 0, '78945678901', 'bruna@fiap.com.br', 'F', TIMESTAMP '1988-06-07 00:00:00.000000','Bruna Moura','1298761235');
INSERT INTO TBL_BRQ_CANDIDATO (ID_CANDIDATO,DH_CRIADO,ST_INATIVO,NR_CPF,DS_EMAIL,ST_GENERO,DT_NASCIMENTO,NM_NOME,NR_TELEFONE) VALUES (SEQ_TBL_BRQ_CANDIDATO.NEXTVAL, SYSDATE, 0, '98745678901', 'wellington@fiap.com.br', 'M', TIMESTAMP '1989-07-08 00:00:00.000000','Wellington Ramos','1554321239');

-- TBL_BRQ_CANDIDATO_SKILLS
 -- Filipe - Java
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (1,1);
 -- Filipe - C#
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (1,2);
 -- Filipe - Spring Boot
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (1,6);
 -- Filipe - Scrum
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (1,3);
 -- Filipe - JavaScript
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (1,5);
 -- Paulo - Java
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (2,1);
 -- Paulo - Node.js
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (2,4);
 -- Paulo - JavaScript
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (2,5);
 -- Paulo - Spring Boot
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (2,6);
 -- Thais - Spring Boot
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (3,6);
 -- Thais - Scrum
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (3,3);
 -- Thais - JavaScript
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (3,5);
 -- Bruna - Node.js
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (4,4);
 -- Bruna - Scrum
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (4,3);
 -- Bruna - JavaScript
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (4,5);
 -- Wellington - C#
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (5,2);
 -- Wellington - Java
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (5,1);
 -- Wellington - JavaScript
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (5,4);
 -- Wellington - Scrum
INSERT INTO TBL_BRQ_CANDIDATO_SKILLS (ID_CANDIDATO,ID_SKILL) VALUES (5,3);

-- TBL_BRQ_CANDIDATO_CERTIFICADOS
 -- Filipe - Spring Professional
INSERT INTO TBL_BRQ_CANDIDATO_CERTIFICADOS (ID_CANDIDATO,ID_CERTIFICADO) VALUES (1,2);
 -- Filipe - Scrum Master Professional
INSERT INTO TBL_BRQ_CANDIDATO_CERTIFICADOS (ID_CANDIDATO,ID_CERTIFICADO) VALUES (1,1);
 -- Thais - Scrum Master Professional
INSERT INTO TBL_BRQ_CANDIDATO_CERTIFICADOS (ID_CANDIDATO,ID_CERTIFICADO) VALUES (3,1);
 -- Paulo - JavaScript Professional
INSERT INTO TBL_BRQ_CANDIDATO_CERTIFICADOS (ID_CANDIDATO,ID_CERTIFICADO) VALUES (2,3);
 -- Wellington - Microsoft C# Professional
INSERT INTO TBL_BRQ_CANDIDATO_CERTIFICADOS (ID_CANDIDATO,ID_CERTIFICADO) VALUES (5,4);
 -- Bruna - JavaScript Professional
INSERT INTO TBL_BRQ_CANDIDATO_CERTIFICADOS (ID_CANDIDATO,ID_CERTIFICADO) VALUES (4,3);
