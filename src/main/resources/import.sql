-- Inserir telefone
INSERT INTO telefone (codigoArea, numero) VALUES ('62', '123'), ('63', '321'), ('91', '352'), ('63', '958'), ('62', '654');

-- Inserir autores
INSERT INTO autor (nome, biografia) VALUES ('Colleen Hoover', 'Colleen Hoover é uma escritora norte-americana que escreve principalmente romances nos gêneros romântico e ficção para jovens adultos. Muitos de seus trabalhos foram autopublicados antes de serem adquiridos por uma editora.');
INSERT INTO autor (nome, biografia) VALUES ('Ali Hazelwood', 'Ali Hazelwood é uma autora italiana, que viveu em diversos países antes de se mudar para os Estados Unidos para se doutorar em Neurociência. Que conquistou o mundo da literatura com seus romances de ficção científica que combinam humor, inteligência e romance');
INSERT INTO autor (nome, biografia) VALUES ('Augusto Cury', 'Augusto Jorge Cury é um psiquiatra, professor e escritor brasileiro. Augusto é autor da Teoria da Inteligência Multifocal e seus livros foram publicados em mais de 70 países, com mais de 25 milhões de livros vendidos somente no Brasil.');

-- Inserir gênero
INSERT INTO genero (nome, descricao) VALUES ('Romance', 'Livros que enfocam em relacionamentos amorosos e desenvolvimento emocional dos personagens.');

-- Inserir fornecedores
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Loja Moderna Ltda', '11.222.333/0001-99', '123456789', 'moderna@gmail.com', 'Av. Paulista, 1000 - Bela Vista', '01311-000', 'São Paulo', 'São Paulo', 300, 2);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Companhia das Letras Ltda', '55.444.666/0001-88', '987654321', 'letras@gmail.com', 'Rua Major Maragliano, 466 - Vila Mariana', '04015-001', 'São Paulo', 'São Paulo', 400, 3);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Sextante Ltda', '99.777.333/0001-55', '123654987', 'sextante@gmail.com', 'Rua Voluntários da Pátria, 41 - Botafogo', '22270-000', 'Rio de Janeiro', 'Rio de Janeiro', 350, 4);

-- Inserir editora
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Atria Books', 'atriabooks@gmail.com', 'rua 10', 'nova york', 1);

-- Inserir livro
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora) 
VALUES ('Confess', 39.90, 50, '9781501176838', '2015-03-10', 'Confess é um romance contemporâneo escrito por Colleen Hoover. O livro foi publicado em 2015 e é centrado em Auburn Reed e Owen Gentry. Auburn tem um passado difícil e encontra Owen, um artista misterioso, enquanto trabalha em uma galeria de arte. Juntos, eles embarcam em uma jornada emocional, desvendando segredos e enfrentando desafios que testam seu amor.', 1, 1, 1);

-- Inserir relacionamento entre livro e autor
INSERT INTO livro_autor (idlivro, idautor) VALUES (1, 1);

-- Inserir relacionamento entre livro e gênero
INSERT INTO livro_genero (idlivro, idgenero) VALUES (1, 1);
