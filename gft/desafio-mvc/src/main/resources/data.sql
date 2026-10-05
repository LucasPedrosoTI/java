INSERT INTO usuario (admin, email, senha)
VALUES (
    1,
    "admin@gft.com",
    "$2a$10$ZJJEee5s0D9GoVLxHElZgub3/y7FiXjdmgOrW2YnV8l9I4nJksybm"
  ),
  (
    0,
    "user@gft.com",
    "$2a$10$I1q1psMlBET2/bJUxIjmGOitfazqkyyAWDRfemvhIRETYj/jHHk72"
  );
INSERT INTO tecnologia (nome)
VALUES ("JavaScript"),
  ("Python"),
  ("Java"),
  ("PHP"),
  ("C#"),
  ("C++"),
  ("Ruby"),
  ("CSS"),
  ("TypeScript"),
  ("C"),
  ("Swift"),
  ("Objective-C"),
  ("Scala"),
  ("R"),
  ("Go"),
  ("Shell"),
  ("PowerShell"),
  ("Perl"),
  ("Kotlin"),
  ("Haskell");
INSERT INTO level (nome)
VALUES ("L0"),
  ("L1"),
  ("L2"),
  ("L3"),
  ("L4"),
  ("L5"),
  ("L6"),
  ("L7");
INSERT INTO unidades_gft (
    cep,
    cidade,
    endereco,
    estado,
    nome,
    telefone
  )
VALUES (
    "06454000",
    "Barueri",
    "Alameda Rio Negro, n° 585 Ed. Padauiri, 10° andar",
    "SP",
    "GFT Alphaville",
    "1121763253"
  ),
  (
    "80230010",
    "Rebouças",
    "Av. Sete de Setembro, 2451 Torre Trinity Corporate 6º andar",
    "PR",
    "GFT Sorocaba",
    "4140095700"
  ),
  (
    "18095450",
    "Jardim Sta. Rosália",
    "Av. São Francisco, 98",
    "SP",
    "GFT Curitiba",
    "1121763553"
  );
INSERT INTO vaga (
    codigo_vaga,
    data_de_abertura,
    descricao_vaga,
    projeto,
    qtd_vagas,
    level_id
  )
VALUES (
    "#ORIG2020",
    "2020-11-04",
    "DESENVOLVEDOR BACK END JAVA",
    "Banco Original",
    10,
    1
  ),
  (
    "#SANT2020",
    "2020-11-06",
    "ANALISTA DE TESTES",
    "Santander",
    10,
    2
  ),
  (
    "#ITAU2020",
    "2020-11-06",
    "SCRUM MASTER",
    "Itaú",
    10,
    3
  ),
  (
    "#BBTG2020",
    "2020-11-07",
    "PROJECT OWNER",
    "BTG",
    10,
    4
  );
INSERT INTO vaga_tecnologia (vaga_id, tecnologia_id)
VALUES (1, 1),
  (1, 3),
  (2, 2),
  (2, 4),
  (3, 4),
  (3, 5);
INSERT INTO funcionario (
    nome,
    cargo,
    matricula,
    inicio_wa,
    termino_wa,
    local_de_trabalho_id,
    level_id,
    data_de_alocacao,
    alocacao_id
  )
VALUES (
    "João",
    "DESENVOLVEDOR_BACK",
    "0123456",
    "2020-11-04",
    "2020-11-19",
    1,
    1,
    null,
    null
  ),
  (
    "José",
    "ESTAGIARIO",
    "0123457",
    "2020-11-05",
    "2020-11-20",
    2,
    2,
    null,
    null
  ),
  (
    "José",
    "ESTAGIARIO",
    "0123458",
    "2020-11-05",
    "2020-11-20",
    3,
    3,
    null,
    null
  ),
  (
    "José",
    "ESTAGIARIO",
    "0123459",
    "2020-11-06",
    "2020-11-21",
    1,
    4,
    null,
    null
  ),
  (
    "José",
    "ESTAGIARIO",
    "0123460",
    "2020-11-07",
    "2020-11-22",
    1,
    5,
    null,
    null
  ),
  (
    "José",
    "ESTAGIARIO",
    "0123461",
    "2020-11-07",
    "2020-11-22",
    1,
    6,
    null,
    null
  ),
  (
    "José",
    "ESTAGIARIO",
    "0123462",
    "2020-11-07",
    "2020-11-22",
    1,
    7,
    "2020-11-08",
    1
  ),
  (
    "João",
    "ESTAGIARIO",
    "0123463",
    "2020-11-07",
    "2020-11-22",
    1,
    7,
    "2020-11-10",
    2
  );
INSERT INTO funcionario_tecnologia (funcionario_id, tecnologia_id)
VALUES (1, 1),
  (1, 3),
  (1, 4),
  (2, 1),
  (2, 4),
  (2, 5);