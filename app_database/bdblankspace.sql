-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2018 at 03:15 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.0.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdblankspace`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbcolecao`
--

CREATE TABLE `tbcolecao` (
  `idColecao` int(11) NOT NULL,
  `tituloColecao` varchar(50) NOT NULL,
  `descricaoColecao` varchar(150) NOT NULL,
  `dataCriacao` date NOT NULL,
  `idPublicacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbhistoria`
--

CREATE TABLE `tbhistoria` (
  `idHistoria` int(11) NOT NULL,
  `tituloHistoria` varchar(50) NOT NULL,
  `conteudoHistoria` varchar(5000) NOT NULL,
  `imagemHistoria` varchar(3000) DEFAULT NULL,
  `dataCriacao` date NOT NULL,
  `idColecao` int(11) DEFAULT NULL,
  `idPublicacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbhistoria`
--

INSERT INTO `tbhistoria` (`idHistoria`, `tituloHistoria`, `conteudoHistoria`, `imagemHistoria`, `dataCriacao`, `idColecao`, `idPublicacao`) VALUES
(16, 'Crepusculo', 'Crepúsculo poderia ser como qualquer outra história não fosse um elemento irresistível: o \nobjeto da paixão da protagonista é um vampiro. Assim, soma-se à paixão um perigo sobrenatural \ntemperado com muito suspense, e o resultado é uma leitura de tirar o fôlego – um \nromance repleto das angústias e incertezas da juventude – o arrebatamento, a atração, \na ansiedade que antecede cada palavra, cada gesto, e todos os medos. Isabella Swan chega à \nnublada e chuvosa cidadezinha de Forks – último lugar onde gostaria de viver. \nTenta se adaptar à vida provinciana na qual aparentemente todos se conhecem, \nlidar com sua constrangedora falta de coordenação motora e se habituar a morar com um pai \ncom quem nunca conviveu. Em seu destino está Edward Cullen.\n\nEle é lindo, perfeito, misterioso e, à primeira vista, hostil à presença de Bella o \nque provoca nela uma inquietação desconcertante. Ela se apaixona. Ele, no melhor estilo \n“amor proibido”, alerta: Sou um risco para você. Ela é uma garota incomum. \nEle é um vampiro. Ela precisa aprender a controlar seu corpo quando ele a toca. \nEle, a controlar sua sede pelo sangue dela. Em meio a descobertas e sobressaltos, Edward é, \nsim, perigoso: um perigo que qualquer mulher escolheria correr.\n\nNesse universo fantasioso, os personagens construídos por Stephenie Meyer – humanos ou \nnão – se mostram de tal forma familiares em seus dilemas e seu comportamento que o \nsobrenatural parece real. Meyer torna perfeitamente plausível – e irresistível – a paixão de \numa garota de 17 anos por um vampiro encantador.', 'card_cover2.jpg', '2018-11-30', NULL, 22),
(17, 'Ladrão de Raios', 'Capítulo 1 - Sem querer, transformo em pó minha\nprofessora de iniciação à Álgebra\nOlhe, eu não queria ser um meio-sangue.\nSe você está lendo isto porque acha que pode ser um, meu conselho é o seguinte: feche este\nlivro agora mesmo. Acredite em qualquer mentira que sua mãe ou seu pai lhe contou sobre seu\nnascimento, e tente levar uma vida normal.\nSer meio-sangue é perigoso. É assustador. Na maioria das vezes, acaba com a gente de um jeito\npenoso e detestável.\nSe você é uma criança normal, que está lendo isto porque acha que é ficção, ótimo. Continue\nlendo. Eu o invejo por ser capaz de acreditar que nada disso aconteceu. Mas, se você se\nreconhecer nestas páginas – se sentir alguma coisa emocionante lá dentro –, pare de ler\nimediatamente. Você pode ser um de nós. E, uma vez que fica sabendo disso, é apenas uma\nquestão de tempo antes que eles também sintam isso, e venham atrás de você.\nNão diga que eu não avisei.\nMeu nome é Percy Jackson.\nTenho doze anos de idade. Até alguns meses atrás, era aluno de um internato, na Academia\nYancy, uma escola particular para crianças problemáticas no norte do estado de Nova York.\nSe eu sou uma criança problemática? Sim. Pode-se dizer isso.\nEu poderia partir de qualquer ponto da minha vida curta e infeliz para prová-lo, mas as coisas\ncomeçaram a ir realmente mal no último mês de maio, quando nossa turma do sexto ano fez\numa excursão a Manhattan – vinte e oito crianças alucinadas e dois professores em um ônibus\nescolar amarelo indo para o Metropolitan Museum of Art, a fim de observar velharias gregas e\nromanas.\nEu sei, parece tortura. A maior parte das excursões da Yancy era mesmo. Mas o Sr. Brunner,\nnosso professor de latim, estava guiando essa excursão, assim eu tinha esperanças.\nO Sr. Brunner era um sujeito de meia-idade em uma cadeira de rodas motorizada. Tinha o\ncabelo ralo, uma barba desalinhada e usava um casaco surrado de tweed que sempre cheirava\na café. Talvez você não o achasse legal, mas ele contava histórias e piadas e nos deixava fazer\nbrincadeiras em sala. Também tinha uma impressionante coleção de armaduras e armas\nromanas, portanto era o único professor cuja aula não me fazia dormir.\nEu esperava que desse tudo certo na excursão. Pelo menos tinha esperança de não me meter\nem encrenca dessa vez.\nCara, como eu estava errado.\nEntenda: coisas ruins me acontecem em excursões escolares. Como na minha escola da quinta\nsérie, quando fomos para o campo de batalha de Saratoga, e eu tive aquele acidente com um\ncanhão da Revolução Americana. Eu não estava apontando para o ônibus da escola, mas é claro\nque fui expulso do mesmo jeito.\nE antes disso, na escola da quarta série, quando fizemos um passeio pelos bastidores do tanque\ndos tubarões do Mundo Marinho, e eu de, alguma forma, acionei a alavanca errada no\npassadiço e nossa turma tomou um banho inesperado. E antes disso... Bem, já dá para você ter\numa ideia.\nNessa viagem, eu estava determinado a ser bonzinho.\nAo longo de todo o caminho para a cidade aguentei Nancy Bobofit, aquela cleptomaníaca ruiva\ne sardenta, acertando a nuca do meu melhor amigo, Grover, com pedaços de sanduíche de\nmanteiga de amendoim com ketchup.\nGrover era um alvo fácil. Ele era magrelo. Chorava quando ficava frustrado. Devia ter repetido\nde ano muitas vezes, porque era o único na sexta série que tinha espinhas e uma barba rala\ncomeçando a nascer no queixo. E, ainda por cima, era aleijado. Tinha um atestado que o\ndispensava da Educação Física pelo resto da vida, porque tinha algum tipo de doença muscular\nnas pernas. Andava de um jeito engraçado, como se cada passo doesse, mas não se deixe\nenganar por isso. Você precisa vê-lo correr quando era dia de enchilada na cantina.\nDe qualquer modo, Nancy Bobofit estava jogando bolinhas de sanduíche que grudavam no\ncabelo castanho cacheado dele, e ela sabia que eu não podia revidar, porque já estava sendo\nobservado, sob o risco de ser expulso. O diretor me ameaçara de morte com uma suspensão\n“na escola” (ou seja, sem poder assistir às aulas, mas tendo de comparecer à escola e ficar\ntrancado numa sala fazendo tarefas de casa) caso alguma coisa ruim, embaraçosa ou até\nmoderadamente divertida acontecesse durante a excursão.\n– Eu vou matá-la – murmurei.\nGrover tentou me acalmar.\n– Está tudo bem. Gosto de manteiga de amendoim.\nEle se esquivou de outro pedaço do lanche de Nancy', 'card_cover3.jpg', '2018-11-30', NULL, 25),
(18, 'God of War', 'Kratos virou Ícaro ao contrário, estendeu os braços e puxou com toda sua força. As asas \nforam arrancadas, deixando para trás cotos sangrentos e incandescentes nas costas de Ícaro. \nEle berrou quando passou a cair ainda mais rápido pela névoa vermelha[...].', 'card_cover4.png', '2018-11-30', NULL, 26),
(19, 'A history', 'Vee jogou o caderno dentro da mochila e fechou o zíper com raiva. Mordi\no lábio e dei um tchauzinho. Virei-me discretamente, observando o restante da\nsala. Sabia o nome de todos os alunos... menos o de um. O aluno novo. O técnico\nnunca se dirigia a ele, e ele parecia preferir que fosse assim. Estava jogado em\numa carteira atrás de mim, os olhos negros e frios fixados num ponto adiante.\nComo sempre. Nunca acreditei por um momento sequer que ele simplesmente\npassasse o tempo todo sentado ali, dia após dia, fitando o vazio. Tinha de estar\nHush Hush_miolo_final.indd 12 ush Hush_miolo_final.indd 12 05/05/10 17:42 5/05/10 17:42\n13\npensando em algo, mas o instinto me dizia que eu provavelmente não ia querer\nsaber o que era.\nEle colocou o livro de biologia na mesa e deslizou para a antiga cadeira de Vee.\nSorri.\n— Oi. Sou Nora.\nSeus olhos negros me atravessaram e os cantos de sua boca se ergueram. Meu\ncoração parou por um segundo e, naquela pausa, um sentimento sinistro e desesperador\npareceu me envolver como uma sombra. Passou depois de um segundo,\nmas eu continuava a encará-lo. O sorriso dele não era amistoso. Era um sorriso que\nqueria dizer confusão. Confusão garantida', 'card_cover5.png', '2018-11-30', NULL, 27);

-- --------------------------------------------------------

--
-- Table structure for table `tbpublicacao`
--

CREATE TABLE `tbpublicacao` (
  `idPublicacao` int(11) NOT NULL,
  `dataModificacao` date NOT NULL,
  `statusPublicacao` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpublicacao`
--

INSERT INTO `tbpublicacao` (`idPublicacao`, `dataModificacao`, `statusPublicacao`) VALUES
(22, '2018-11-30', 1),
(23, '2018-11-30', 1),
(24, '2018-11-30', 1),
(25, '2018-11-30', 1),
(26, '2018-11-30', 1),
(27, '2018-11-30', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbseguidor`
--

CREATE TABLE `tbseguidor` (
  `idSeguidor` int(11) NOT NULL,
  `idUsuarioSeguidor` int(11) NOT NULL,
  `idUsuarioSeguinte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbusuario`
--

CREATE TABLE `tbusuario` (
  `idUsuario` int(11) NOT NULL,
  `emailUsuario` varchar(100) NOT NULL,
  `nomeUsuario` varchar(20) NOT NULL,
  `sobrenomeUsuario` varchar(30) NOT NULL,
  `carreiraUsuario` varchar(30) NOT NULL,
  `nascimentoUsuario` date NOT NULL,
  `senhaUsuario` varchar(200) NOT NULL,
  `imagemUsuario` varchar(3000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbusuario`
--

INSERT INTO `tbusuario` (`idUsuario`, `emailUsuario`, `nomeUsuario`, `sobrenomeUsuario`, `carreiraUsuario`, `nascimentoUsuario`, `senhaUsuario`, `imagemUsuario`) VALUES
(10, 'lucasjesus.lj@hotmail.com', 'Lucas', 'Jesus', 'Back End', '1999-02-28', '8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92', NULL),
(11, 'igorsantana766@gmail.com', 'Igor', 'Santana', 'Analista Da TOTVS', '1998-11-20', '8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92', NULL),
(12, 'eitorbrandao10@hotmail.com', 'Eitor', 'Brandão', 'Suporte técnico', '1999-02-18', '8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92', NULL),
(13, 'pastoreli.igor@gmail.com', 'Igor', 'Pastoreli', 'Front End', '1999-08-08', '8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbusuariopublicacao`
--

CREATE TABLE `tbusuariopublicacao` (
  `idUsuario` int(11) NOT NULL,
  `idPublicacao` int(11) NOT NULL,
  `donoPublicacao` bit(2) DEFAULT NULL,
  `favoritoPublicacao` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbusuariopublicacao`
--

INSERT INTO `tbusuariopublicacao` (`idUsuario`, `idPublicacao`, `donoPublicacao`, `favoritoPublicacao`) VALUES
(11, 22, b'01', NULL),
(13, 25, b'01', NULL),
(12, 26, b'01', NULL),
(10, 27, b'01', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbcolecao`
--
ALTER TABLE `tbcolecao`
  ADD PRIMARY KEY (`idColecao`),
  ADD KEY `idPublicacao` (`idPublicacao`);

--
-- Indexes for table `tbhistoria`
--
ALTER TABLE `tbhistoria`
  ADD PRIMARY KEY (`idHistoria`),
  ADD KEY `idPublicacao` (`idPublicacao`),
  ADD KEY `idPublicacao_2` (`idPublicacao`),
  ADD KEY `idColecao` (`idColecao`);

--
-- Indexes for table `tbpublicacao`
--
ALTER TABLE `tbpublicacao`
  ADD PRIMARY KEY (`idPublicacao`);

--
-- Indexes for table `tbseguidor`
--
ALTER TABLE `tbseguidor`
  ADD PRIMARY KEY (`idSeguidor`),
  ADD KEY `idUsuarioSeguidor` (`idUsuarioSeguidor`),
  ADD KEY `idUsuarioSeguinte` (`idUsuarioSeguinte`);

--
-- Indexes for table `tbusuario`
--
ALTER TABLE `tbusuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indexes for table `tbusuariopublicacao`
--
ALTER TABLE `tbusuariopublicacao`
  ADD KEY `idPublicacao` (`idPublicacao`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbcolecao`
--
ALTER TABLE `tbcolecao`
  MODIFY `idColecao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbhistoria`
--
ALTER TABLE `tbhistoria`
  MODIFY `idHistoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `tbpublicacao`
--
ALTER TABLE `tbpublicacao`
  MODIFY `idPublicacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `tbseguidor`
--
ALTER TABLE `tbseguidor`
  MODIFY `idSeguidor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbusuario`
--
ALTER TABLE `tbusuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
