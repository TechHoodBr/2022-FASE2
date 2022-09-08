-- Planos
INSERT INTO TB_CML_PLANO (ID_PLANO, NM_NOME, NM_CODIGO, NU_VALOR) VALUES (SEQ_CML_PLANO.NEXTVAL, 'Básico', 'BASIC', 15);
INSERT INTO TB_CML_PLANO (ID_PLANO, NM_NOME, NM_CODIGO, NU_VALOR) VALUES (SEQ_CML_PLANO.NEXTVAL, 'Avançado', 'ADVANCED', 25);
INSERT INTO TB_CML_PLANO (ID_PLANO, NM_NOME, NM_CODIGO, NU_VALOR) VALUES (SEQ_CML_PLANO.NEXTVAL, 'Premium', 'PREMIUM', 40);

-- Tipo de Usuário
INSERT INTO TB_CML_TIPO_USUARIO (ID_TIPO_USUARIO, NM_NOME) VALUES (SEQ_CML_TIPO_USUARIO.NEXTVAL, 'Professor(a)');
INSERT INTO TB_CML_TIPO_USUARIO (ID_TIPO_USUARIO, NM_NOME) VALUES (SEQ_CML_TIPO_USUARIO.NEXTVAL, 'Aluno');

-- Usuario - Professores
INSERT INTO TB_CML_USUARIO (ID_USUARIO, NM_NOME, DS_LOGIN, DS_SENHA, ID_TIPO_USUARIO, ID_PLANO) VALUES (SEQ_CML_USUARIO.NEXTVAL, 'Professor 1', 'professor1', '123', 1, 1);
INSERT INTO TB_CML_USUARIO (ID_USUARIO, NM_NOME, DS_LOGIN, DS_SENHA, ID_TIPO_USUARIO, ID_PLANO) VALUES (SEQ_CML_USUARIO.NEXTVAL, 'Professor 2', 'professor2', '123', 1, 1);
INSERT INTO TB_CML_USUARIO (ID_USUARIO, NM_NOME, DS_LOGIN, DS_SENHA, ID_TIPO_USUARIO, ID_PLANO) VALUES (SEQ_CML_USUARIO.NEXTVAL, 'Professor 3', 'professor3', '123', 1, 1);

-- Usuario - Alunos
INSERT INTO TB_CML_USUARIO (ID_USUARIO, NM_NOME, DS_LOGIN, DS_SENHA, ID_TIPO_USUARIO, ID_PLANO) VALUES (SEQ_CML_USUARIO.NEXTVAL, 'Aluno 1', 'aluno1', '123', 2, 1);
INSERT INTO TB_CML_USUARIO (ID_USUARIO, NM_NOME, DS_LOGIN, DS_SENHA, ID_TIPO_USUARIO, ID_PLANO) VALUES (SEQ_CML_USUARIO.NEXTVAL, 'Aluno 2', 'aluno2', '123', 2, 2);
INSERT INTO TB_CML_USUARIO (ID_USUARIO, NM_NOME, DS_LOGIN, DS_SENHA, ID_TIPO_USUARIO, ID_PLANO) VALUES (SEQ_CML_USUARIO.NEXTVAL, 'Aluno 3', 'aluno3', '123', 2, 3);

-- Aulas - Gravadas
INSERT INTO TB_CML_AULA (ID_AULA, ID_USUARIO, DS_TITULO, DT_INICIO_LIVE, DT_FIM_LIVE, DS_DESCRICAO, DS_URL_VIDEO) VALUES (SEQ_CML_AULA.NEXTVAL, 1, 'Aula 1 - Saudações e Apresentações', '27-08-2022 09:00:00', '27-08-2022 10:00:00', 'Em nossa primeira aula, tratamos do tema: Saudações e apresentações\r\nVídeo feito para o projeto Educopédia, parte de um curso criado para auxiliar os professores que trabalham na SME do Rio de Janeiro.\r\nAcessem o conteúdo teórico de nosso curso no site www.educopedia.com.br, nos menus "Educação Especial" - "Surdez".\r\nEste vídeo foi feito em parceria com o departamento de mídia da Educolibras (www.educolibras.com.br), que forneceu apoio tecnológico.\r\nMusic: Drops of H2O ( The Filtered Water Treatment) -B - J.Lang feat Airtone', 'http://www.HOSTNAME.com.br/video/1 - Aula 1 - Saudações e Apresentações.mp4');
INSERT INTO TB_CML_AULA (ID_AULA, ID_USUARIO, DS_TITULO, DT_INICIO_LIVE, DT_FIM_LIVE, DS_DESCRICAO, DS_URL_VIDEO) VALUES (SEQ_CML_AULA.NEXTVAL, 1, 'Aula 2 - Família', '28-08-2022 18:00:00', '28-08-2022 19:00:00', 'Na segunda aula, introduzimos o tema "família".\r\n\r\nVídeo feito para o projeto Educopédia, parte de um curso criado para auxiliar os professores que trabalham na SME do Rio de Janeiro.\r\nAcessem o conteúdo teórico de nosso curso no site www.educopedia.com.br, nos menus "Educação Especial" -  "Surdez".\r\n\r\nEste vídeo foi feito em parceria com o departamento de mídia da Educolibras (www.educolibras.com.br), que forneceu apoio tecnológico.', 'http://www.HOSTNAME.com.br/video/2 - Aula 2 - Família.mp4');
INSERT INTO TB_CML_AULA (ID_AULA, ID_USUARIO, DS_TITULO, DT_INICIO_LIVE, DT_FIM_LIVE, DS_DESCRICAO, DS_URL_VIDEO) VALUES (SEQ_CML_AULA.NEXTVAL, 1, 'Aula 2.1 - Glossário', '29-08-2022 19:00:00', '29-08-2022 19:30:00', 'Na segunda (parte 1) aula, introduzimos o tema "família". Veja agora o glossário com os principais sinais utilizados na aula.\r\n\r\nVídeo feito para o projeto Educopédia, parte de um curso criado para auxiliar os professores que trabalham na SME do Rio de Janeiro.\r\nAcessem o conteúdo teórico de nosso curso no site www.educopedia.com.br, nos menus "Educação Especial" - "Surdez".\r\nEste vídeo foi feito em parceria com o departamento de mídia da Educolibras (www.educolibras.com.br), que forneceu apoio tecnológico.', 'http://www.HOSTNAME.com.br/video/3 - Aula 2.1 - Glossário.mp4');
INSERT INTO TB_CML_AULA (ID_AULA, ID_USUARIO, DS_TITULO, DT_INICIO_LIVE, DT_FIM_LIVE, DS_DESCRICAO, DS_URL_VIDEO) VALUES (SEQ_CML_AULA.NEXTVAL, 2, 'Alfabeto manual', '05-09-2022 07:00:00', '05-09-2022 08:00:00', 'Vídeo produzido para o projeto Educopédia, parte de um curso criado para auxiliar os professores que trabalham na SME do Rio de Janeiro.\r\nAcessem o conteúdo teórico de nosso curso no site www.educopedia.com.br, nos menus "Educação Especial" -  "Surdez".\r\n\r\nEste vídeo foi feito em parceria com o departamento de mídia da Educolibras (www.educolibras.com.br), que forneceu apoio tecnológico.', 'http://www.HOSTNAME.com.br/video/4 - O alfabeto manual.mp4');
INSERT INTO TB_CML_AULA (ID_AULA, ID_USUARIO, DS_TITULO, DT_INICIO_LIVE, DT_FIM_LIVE, DS_DESCRICAO, DS_URL_VIDEO) VALUES (SEQ_CML_AULA.NEXTVAL, 3, 'Sinais de Sentimentos', '06-09-2022 07:15:00', '06-09-2022 08:30:00', 'Desde 2020, mudamos a forma como chamamos o Hugo e a Maya. Antes nomeados intérpretes virtuais, agora usamos o termo tradutores virtuais, que mais se adequa ao papel deles na comunidade surda.\r\n\r\nAprenda sinais de SENTIMENTOS em Libras (Língua Brasileira de Sinais) com o Hugo.', 'http://www.HOSTNAME.com.br/video/5 - Sinais de Sentimentos.mp4');

-- Aula - Ao vivo
INSERT INTO TB_CML_AULA (ID_AULA, ID_USUARIO, DS_TITULO, DT_INICIO_LIVE, DT_FIM_LIVE, DS_DESCRICAO, DS_URL_VIDEO) VALUES (SEQ_CML_AULA.NEXTVAL, 1, 'Aula 3 - Verbos', '07-09-2022 09:00:00', '07-09-2022 10:00:00', 'Aprenda sinais de VERBOS em Libras (Língua Brasileira de Sinais) com o Professor 1.', null);
INSERT INTO TB_CML_AULA (ID_AULA, ID_USUARIO, DS_TITULO, DT_INICIO_LIVE, DT_FIM_LIVE, DS_DESCRICAO, DS_URL_VIDEO) VALUES (SEQ_CML_AULA.NEXTVAL, 2, 'Aula 4 - Dias, Meses, Estações do Ano', '08-09-2022 09:00:00', '08-09-2022 10:00:00', 'Aprenda sinais de Dias da Semana, Meses e Estações do Ano em Libras (Língua Brasileira de Sinais) com o Professor 2.', null);
INSERT INTO TB_CML_AULA (ID_AULA, ID_USUARIO, DS_TITULO, DT_INICIO_LIVE, DT_FIM_LIVE, DS_DESCRICAO, DS_URL_VIDEO) VALUES (SEQ_CML_AULA.NEXTVAL, 3, 'Aula 5 - Supermercado', '09-09-2022 09:00:00', '09-09-2022 10:00:00', 'Aprenda sinais de Supermercado em Libras (Língua Brasileira de Sinais) com o Professor 3.', null);

-- Aula - Materiais
INSERT INTO TB_CML_AULA_MATERIAIS (ID_AULA_MATERIAIS, ID_AULA, NM_NOME_ARQUIVO, DS_URL_ARQUIVO, DT_UPLOAD, NU_BAIXADO) VALUES (SEQ_CML_AULA_MATERIAIS.NEXTVAL, 1, 'Saudações e Apresentações.pdf', 'http://www.HOSTNAME.com.br/material/1 - Saudações e Apresentações.pdf', '27-08-2022 11:00:00', 0);
INSERT INTO TB_CML_AULA_MATERIAIS (ID_AULA_MATERIAIS, ID_AULA, NM_NOME_ARQUIVO, DS_URL_ARQUIVO, DT_UPLOAD, NU_BAIXADO) VALUES (SEQ_CML_AULA_MATERIAIS.NEXTVAL, 2, 'Família.pdf', 'http://www.HOSTNAME.com.br/material/2 - Família.pdf', '28-08-2022 19:00:00', 0);
INSERT INTO TB_CML_AULA_MATERIAIS (ID_AULA_MATERIAIS, ID_AULA, NM_NOME_ARQUIVO, DS_URL_ARQUIVO, DT_UPLOAD, NU_BAIXADO) VALUES (SEQ_CML_AULA_MATERIAIS.NEXTVAL, 3, 'Glossário.pdf', 'http://www.HOSTNAME.com.br/material/3 - Glossário.pdf', '29-08-2022 20:30:00', 0);
