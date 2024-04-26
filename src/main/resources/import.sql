-- Inserir telefone
INSERT INTO telefone (codigoArea, numero) VALUES 
('62', '123'), ('63', '321'), ('91', '352'), ('63', '958'), 
('62', '654'), ('91', '533'), ('15', '245'), ('67', '235'), 
('55', '175'), ('56', '745'), ('31', '7777'), ('41', '6666'), 
('51', '5555'), ('32', '7757'), ('32', '7456'), ('87', '2203');

-- Inserir usuários
INSERT INTO usuario (nome, dataNascimento, email, senha, id_telefone, sexo, cpf) VALUES 
('João Silva', '1990-01-01', 'joao.silva@gmail.com', 'senha123', 11, 1, '12345678901'),
('Maria Souza', '1995-03-15', 'maria.souza@gmail.com', 'senha456', 12, 2, '98765432109'),
('Carlos Oliveira', '1988-05-20', 'carlos.oliveira@gmail.com', 'senha789', 13, 1, '45678912365'),
('Ana Santos', '1992-11-10', 'ana.santos@gmail.com', 'senhaabc', 14, 2, '98765412387'),
('Fernanda Oliveira', '1980-07-25', 'fernanda@gmail.com', 'senhaxyz', 15, 2, '56456434533'),
('Carlos Silva', '1975-09-18', 'carlos@gmail.com', 'senha123abc', 16, 1, '78567345323');

-- Inserir clientes
INSERT INTO cliente (endereco, cep, cidade, estado, id_usuario) VALUES 
('Rua A, 123', '12345-678', 'São Paulo', 'SP', 1),
('Av. B, 456', '54321-098', 'Rio de Janeiro', 'RJ', 2),
('Rua C, 789', '98765-432', 'Belo Horizonte', 'MG', 3);

-- Inserir funcionários
INSERT INTO funcionario (cargo, salario, id_usuario) VALUES 
('Gerente', 5000.00, 4),
('Especialista em E-commerce', 3000.00, 5),
('Analista de Dados de Vendas', 2500.00, 6);

-- Inserir autores
INSERT INTO autor (nome, biografia) VALUES ('Colleen Hoover', 'Colleen Hoover é uma escritora norte-americana que escreve principalmente romances nos gêneros romântico e ficção para jovens adultos. Muitos de seus trabalhos foram autopublicados antes de serem adquiridos por uma editora.');
INSERT INTO autor (nome, biografia) VALUES ('Ali Hazelwood', 'Ali Hazelwood é uma autora italiana, que viveu em diversos países antes de se mudar para os Estados Unidos para se doutorar em Neurociência. Que conquistou o mundo da literatura com seus romances de ficção científica que combinam humor, inteligência e romance');
INSERT INTO autor (nome, biografia) VALUES ('Augusto Cury', 'Augusto Jorge Cury é um psiquiatra, professor e escritor brasileiro. Augusto é autor da Teoria da Inteligência Multifocal e seus livros foram publicados em mais de 70 países, com mais de 25 milhões de livros vendidos somente no Brasil.');
INSERT INTO autor (nome, biografia) VALUES ('Nicholas Sparks', 'Nicholas Charles Sparks é um escritor norte-americano. Ele é conhecido por suas novelas românticas, muitas das quais se passam em Carolina do Norte, onde Sparks cresceu. Suas obras incluem O Diário da Nossa Paixão, Um Amor Para Recordar e Querido John.');
INSERT INTO autor (nome, biografia) VALUES ('J.K. Rowling', 'Joanne Rowling, mais conhecida pelo pseudônimo J.K. Rowling, é uma escritora, roteirista e produtora cinematográfica britânica, mundialmente famosa pela série de livros Harry Potter.');
INSERT INTO autor (nome, biografia) VALUES ('George Orwell', 'George Orwell foi um escritor e jornalista inglês. Sua obra é marcada por uma inteligência perspicaz e uma consciência profunda da injustiça social. Suas obras mais famosas incluem 1984 e A Revolução dos Bichos.');

-- Inserir gênero
INSERT INTO genero (nome, descricao) VALUES ('Romance', 'Livros que enfocam em relacionamentos amorosos e desenvolvimento emocional dos personagens.');
INSERT INTO genero (nome, descricao) VALUES ('Ficção Científica', 'Gênero literário que lida principalmente com cenários futuristas, tecnologia avançada e outras ciências e tecnologias imaginárias.');
INSERT INTO genero (nome, descricao) VALUES ('Suspense', 'Gênero literário que cria um sentimento de excitação ou tensão emocional no leitor, frequentemente gerado por uma sequência de eventos inesperados.');
INSERT INTO genero (nome, descricao) VALUES ('Fantasia', 'Gênero literário que envolve elementos sobrenaturais, como magia, criaturas místicas e mundos imaginários.');
INSERT INTO genero (nome, descricao) VALUES ('Mistério', 'Gênero literário que envolve enigmas, investigações e situações inexplicáveis que desafiam a compreensão do leitor.');
INSERT INTO genero (nome, descricao) VALUES ('Aventura', 'Gênero literário que narra histórias emocionantes e cheias de ação, muitas vezes envolvendo viagens, descobertas e desafios perigosos.');

-- Inserir fornecedores
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Loja Moderna Ltda', '11.222.333/0001-99', '123456789', 'moderna@gmail.com', 'Av. Paulista, 1000 - Bela Vista', '01311-000', 'São Paulo', 'São Paulo', 300, 1);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Companhia das Letras Ltda', '55.444.666/0001-88', '987654321', 'letras@gmail.com', 'Rua Major Maragliano, 466 - Vila Mariana', '04015-001', 'São Paulo', 'São Paulo', 400, 2);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Sextante Ltda', '99.777.333/0001-55', '123654987', 'sextante@gmail.com', 'Rua Voluntários da Pátria, 41 - Botafogo', '22270-000', 'Rio de Janeiro', 'Rio de Janeiro', 350, 3);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Livraria Cultura Ltda', '88.999.777/0001-66', '456123789', 'cultura@gmail.com', 'Av. Paulista, 2300 - Bela Vista', '01310-300', 'São Paulo', 'São Paulo', 500, 4);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Saraiva S.A.', '77.666.555/0001-44', '789456123', 'saraiva@gmail.com', 'Rua Henrique Schaumann, 270 - Pinheiros', '05413-000', 'São Paulo', 'São Paulo', 450, 5);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Editora Abril Ltda', '66.555.444/0001-33', '654987321', 'abril@gmail.com', 'Av. das Nações Unidas, 7221 - Pinheiros', '05425-070', 'São Paulo', 'São Paulo', 550, 6);

-- Inserir editora
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Atria Books', 'atriabooks@gmail.com', 'rua 10', 'nova york', 10);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Globo Livros', 'globolivros@gmail.com', 'Av. Sete de Setembro, 550 - Centro', 'Rio de Janeiro', 7);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Intrínseca', 'intrinseca@gmail.com', 'Rua Marquês de São Vicente, 99 - Gávea', 'Rio de Janeiro', 8);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Editora Rocco', 'rocco@gmail.com', 'Rua Argentina, 171 - São Cristóvão', 'Rio de Janeiro', 9);

-- Inserir livro
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora) 
VALUES ('Confess', 39.90, 50, '9781501176838', '2015-03-10', 'Confess é um romance contemporâneo escrito por Colleen Hoover. O livro foi publicado em 2015 e é centrado em Auburn Reed e Owen Gentry. Auburn tem um passado difícil e encontra Owen, um artista misterioso, enquanto trabalha em uma galeria de arte. Juntos, eles embarcam em uma jornada emocional, desvendando segredos e enfrentando desafios que testam seu amor.', 6, 1, 1);
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora) 
VALUES ('A Hipotese do Amor', 29.99, 100, '9780593336823', '2021-09-14', 'The Love Hypothesis é um romance contemporâneo escrito por Ali Hazelwood. O livro narra a história de Olive Smith, uma estudante de pós-graduação determinada a provar uma teoria científica sobre o amor. Com a ajuda de seu charmoso professor, eles embarcam em uma jornada de descoberta científica e pessoal.', 5, 2, 2);
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora) 
VALUES ('O Vendedor de Sonhos', 34.90, 80, '9788575429039', '2008-09-01', 'O Vendedor de Sonhos é um romance psicológico escrito por Augusto Cury. O livro conta a história de um homem misterioso que salva a vida de um suicida e o convence a acompanhar em uma jornada para mudar a sociedade através de sonhos e reflexões profundas sobre a vida.', 1, 1, 2);
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora) 
VALUES ('Harry Potter e a Pedra Filosofal', 49.90, 100, '9788532530802', '1997-06-26', 'Harry Potter é uma série de sete romances de fantasia escrita pela autora britânica J.K. Rowling. Os livros narram as aventuras de um jovem bruxo, Harry Potter, e seus amigos Hermione Granger e Ron Weasley, todos estudantes na Escola de Magia e Bruxaria de Hogwarts.', 4, 4, 4);
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora) 
VALUES ('1984', 35.00, 80, '9788532530803', '1949-06-08', '1984 é um romance distópico escrito por George Orwell em 1948 e publicado em 1949. A obra é um dos maiores clássicos da literatura mundial e uma das mais influentes e importantes do século XX.', 4, 6, 3);
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora) 
VALUES ('O Diário da Nossa Paixão', 29.90, 70, '9788532511666', '1996-10-01', 'O Diário da Nossa Paixão é um romance do escritor norte-americano Nicholas Sparks, que relata a história de amor entre Noah Calhoun e Allie Nelson, que se conhecem e se apaixonam durante um verão.', 3, 5, 2);

-- Inserir relacionamento entre livro e autor
INSERT INTO livro_autor (idlivro, idautor) VALUES (1, 1);
INSERT INTO livro_autor (idlivro, idautor) VALUES (2, 2);
INSERT INTO livro_autor (idlivro, idautor) VALUES (3, 3);
INSERT INTO livro_autor (idlivro, idautor) VALUES (4, 4);
INSERT INTO livro_autor (idlivro, idautor) VALUES (5, 5);
INSERT INTO livro_autor (idlivro, idautor) VALUES (6, 6);

-- Inserir relacionamento entre livro e gênero
INSERT INTO livro_genero (idlivro, idgenero) VALUES (1, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (2, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (3, 2);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (4, 4);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (5, 2);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (6, 1);
