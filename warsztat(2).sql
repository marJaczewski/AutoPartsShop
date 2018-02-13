-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 27 Cze 2017, 13:25
-- Wersja serwera: 10.1.19-MariaDB
-- Wersja PHP: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `warsztat`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `auto`
--

CREATE TABLE `auto` (
  `id_auto` int(11) NOT NULL,
  `przebieg` int(11) DEFAULT NULL,
  `rocznik` int(11) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `numerrejestracyjny` varchar(45) DEFAULT NULL,
  `WLASCICIEL_id_wlasciciel` int(11) NOT NULL,
  `MODEL_id_model` int(11) NOT NULL,
  `marka` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `auto`
--

INSERT INTO `auto` (`id_auto`, `przebieg`, `rocznik`, `model`, `numerrejestracyjny`, `WLASCICIEL_id_wlasciciel`, `MODEL_id_model`, `marka`) VALUES
(1, 150000, 1998, 'cordoba', 'wwe16sd', 1, 1, 'seat'),
(2, 290000, 2005, 'transit', 'wwe12cc', 2, 5, 'ford'),
(3, 10000, 2015, 'corolla', 'wec2658', 3, 6, 'toyota'),
(4, 310000, 2005, 'transit', 'wwl19vc', 2, 5, 'ford'),
(5, 124530, 2004, 'swift', 'wsk59eu', 4, 8, 'suzuki'),
(6, 2343, 23452, ' cordoba ', ' ew32424 ', 2, 1, '  seat '),
(7, 3453, 345345, 'transit', 'rt45354', 3, 2, 'ford '),
(8, 234, 2343, 'crio', '23422dfd', 21, 7, 'renault '),
(9, 234, 4345, 'cordoba', 'dfgfd43', 9, 1, 'seat '),
(10, 45645, 5464, 'transit', '456456', 11, 2, 'ford '),
(11, 4324, 34, 'transit', 'dfvd434', 13, 2, 'ford '),
(12, 23423, 3234, 'transit', 'sdfvw343', 13, 2, 'ford '),
(13, 23, 1997, 'transit', 'scsd23', 13, 2, 'ford '),
(14, 234, 2015, 'transit', '3242', 14, 3, 'ford '),
(15, 3243, 2006, 'transit', 'sdf', 14, 2, 'ford '),
(16, 90000, 2014, 'crio', 'wwe17kl', 1, 7, 'renault '),
(17, 2344, 2017, 'cordoba', 'kj41231', 6, 1, 'seat '),
(18, 250000, 2003, 'swift', 'opl90hj', 26, 8, 'suzuki ');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `czynnoscserwisowa`
--

CREATE TABLE `czynnoscserwisowa` (
  `id_czynnoscserwisowa` int(11) NOT NULL,
  `data_rozpoczecia` datetime NOT NULL,
  `data_zakonczenia` datetime DEFAULT NULL,
  `ZLECENIE_id_zlecenie` int(11) NOT NULL,
  `DEFINICJACS_ID_DEFINICJACS` int(11) NOT NULL,
  `MECHANIK_id_mechanik` int(11) NOT NULL,
  `STANOWISKO_id_stanowisko` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `czynnoscserwisowa`
--

INSERT INTO `czynnoscserwisowa` (`id_czynnoscserwisowa`, `data_rozpoczecia`, `data_zakonczenia`, `ZLECENIE_id_zlecenie`, `DEFINICJACS_ID_DEFINICJACS`, `MECHANIK_id_mechanik`, `STANOWISKO_id_stanowisko`) VALUES
(2, '2017-06-19 18:53:00', '2017-06-27 01:50:01', 2, 2, 5, 4),
(3, '2017-06-15 18:59:09', NULL, 1, 8, 5, 4),
(146, '2017-06-27 01:52:01', NULL, 9, 5, 2, 2),
(147, '2017-06-27 01:52:01', '0000-00-00 00:00:00', 9, 8, 5, 5),
(148, '2017-06-27 01:56:23', NULL, 10, 3, 5, 5),
(150, '2017-06-27 01:56:23', NULL, 10, 1, 5, 5),
(151, '2017-06-27 01:59:55', '2017-06-27 02:02:17', 11, 5, 2, 2),
(152, '2017-06-27 01:59:55', '2017-06-27 02:02:20', 11, 5, 2, 2),
(153, '2017-06-27 02:00:41', '2017-06-27 02:00:51', 12, 5, 2, 2),
(155, '2017-06-27 02:00:41', '2017-06-27 02:01:11', 12, 9, 1, 1),
(157, '2017-06-27 02:00:41', '2017-06-27 02:01:28', 12, 10, 4, 4),
(158, '2017-06-27 02:07:54', '2017-06-27 02:08:15', 13, 1, 5, 5),
(159, '2017-06-27 02:07:54', '2017-06-27 02:08:35', 13, 3, 5, 5),
(160, '2017-06-27 02:10:41', '2017-06-27 02:10:52', 14, 6, 2, 2),
(161, '2017-06-27 02:10:41', '2017-06-27 02:10:58', 14, 7, 4, 4),
(162, '2017-06-27 09:48:07', '2017-06-27 10:33:35', 15, 11, 2, 2),
(163, '2017-06-27 13:13:57', NULL, 16, 5, 2, 2),
(164, '2017-06-27 13:15:13', NULL, 17, 5, 2, 2),
(165, '2017-06-27 13:15:13', NULL, 17, 8, 5, 5),
(166, '2017-06-27 13:23:57', NULL, 18, 5, 2, 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `definicjacs`
--

CREATE TABLE `definicjacs` (
  `ID_DEFINICJACS` int(11) NOT NULL,
  `nazwa` varchar(45) DEFAULT NULL,
  `kosztrobocizny` int(11) DEFAULT NULL,
  `orientacyjnyczastrwania` int(11) DEFAULT NULL,
  `SPECJALIZACJAMECHANIKA_id_specjalizacjamechanika` int(11) NOT NULL,
  `TYPSTANOWISKA_id_typstanowiska` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `definicjacs`
--

INSERT INTO `definicjacs` (`ID_DEFINICJACS`, `nazwa`, `kosztrobocizny`, `orientacyjnyczastrwania`, `SPECJALIZACJAMECHANIKA_id_specjalizacjamechanika`, `TYPSTANOWISKA_id_typstanowiska`) VALUES
(1, 'Wymiana klocków hamulcowych swift', 60, 120, 5, 4),
(2, 'Wymiana rozrusznika crio', 100, 150, 1, 3),
(3, 'Wimiana klocków i tarcz hamulcowych swift', 70, 190, 5, 4),
(4, 'Wymiana oleju cordoba', 20, 15, 5, 3),
(5, 'Wstawienie progu Lewy transit', 100, 110, 2, 1),
(6, ' Wstawienie progu Prawy transit', 100, 100, 2, 1),
(7, 'Regeneracja zawieszenia transit', 300, 180, 4, 4),
(8, 'Wymiana filtra paliwa cordoba', 20, 15, 5, 5),
(9, 'diagnoza elektryczna', 20, 20, 1, 2),
(10, 'diagnoza zawieszenia', 20, 20, 4, 4),
(11, 'diagnoza lakiernicza', 20, 10, 2, 5),
(12, 'diagnoza silnika', 20, 10, 3, 3),
(13, 'diagnoza ogólna', 20, 10, 5, 5),
(14, 'diagnoza specjalna', 50, 10, 6, 5);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `definicjacs_has_definicjaczesci`
--

CREATE TABLE `definicjacs_has_definicjaczesci` (
  `DEFINICJACS_ID_DEFINICJACS` int(11) NOT NULL,
  `DEFINICJACZESCI_id_definicjaczesci` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `definicjacs_has_definicjaczesci`
--

INSERT INTO `definicjacs_has_definicjaczesci` (`DEFINICJACS_ID_DEFINICJACS`, `DEFINICJACZESCI_id_definicjaczesci`) VALUES
(1, 3),
(2, 7),
(3, 3),
(3, 4),
(4, 7),
(5, 9),
(6, 10),
(7, 1),
(8, 6);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `definicjacs_has_model`
--

CREATE TABLE `definicjacs_has_model` (
  `DEFINICJACS_ID_DEFINICJACS` int(11) NOT NULL,
  `MODEL_id_model` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `definicjacs_has_model`
--

INSERT INTO `definicjacs_has_model` (`DEFINICJACS_ID_DEFINICJACS`, `MODEL_id_model`) VALUES
(1, 8),
(2, 7),
(3, 8),
(4, 5),
(5, 1),
(5, 2),
(6, 2),
(6, 3),
(7, 2),
(7, 3),
(7, 4),
(7, 5),
(8, 1),
(9, 1),
(9, 2),
(9, 3),
(9, 4),
(9, 5),
(9, 6),
(9, 7),
(9, 8),
(10, 1),
(10, 2),
(10, 3),
(10, 4),
(10, 5),
(10, 6),
(10, 7),
(10, 8),
(11, 1),
(11, 2),
(11, 3),
(11, 4),
(11, 5),
(11, 6),
(11, 7),
(11, 8),
(12, 1),
(12, 2),
(12, 3),
(12, 4),
(12, 5),
(12, 6),
(12, 7),
(12, 8),
(13, 1),
(13, 2),
(13, 3),
(13, 4),
(13, 5),
(13, 6),
(13, 7),
(13, 8),
(14, 1),
(14, 2),
(14, 3),
(14, 4),
(14, 5),
(14, 6),
(14, 7),
(14, 8);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `definicjaczesci`
--

CREATE TABLE `definicjaczesci` (
  `id_definicjaczesci` int(11) NOT NULL,
  `nazwa` varchar(100) DEFAULT NULL,
  `numerkatalogowy` varchar(45) DEFAULT NULL,
  `cena` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `definicjaczesci`
--

INSERT INTO `definicjaczesci` (`id_definicjaczesci`, `nazwa`, `numerkatalogowy`, `cena`) VALUES
(1, 'Tuleje wahacza komplet', 'tr25139853', 120),
(2, 'Rozrusznik', 'qlb287183', 120),
(3, 'Klocki hamulcowe', '203821', 40),
(4, 'Tarcza hamulcowa', '324234223', 210),
(5, 'Filtr paliwa', 'PP757', 20),
(6, 'Filtr  paliwa', 'pp433', 25),
(7, 'Filtr oleju', 'OP632', 40),
(8, 'Filtr oleju', 'WK42/2', 90),
(9, 'prog lewy', '1995-2000transitL', 20),
(10, 'prog prawy', '1995-2000transitP', 20),
(11, 'olej silnikowy Mobil1 2000, 4litry', '', 70);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `diagnoza`
--

CREATE TABLE `diagnoza` (
  `id_diagnoza` int(11) NOT NULL,
  `koszt` varchar(45) DEFAULT NULL,
  `PRACOWNIK_id_pracownik` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dostawa`
--

CREATE TABLE `dostawa` (
  `id_dostawa` int(11) NOT NULL,
  `datadostawy` datetime DEFAULT NULL,
  `numerfaktury` varchar(45) DEFAULT NULL,
  `PRACOWNIK_id_pracownik` int(11) NOT NULL,
  `DOSTAWCA_id_dostawca` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `dostawa`
--

INSERT INTO `dostawa` (`id_dostawa`, `datadostawy`, `numerfaktury`, `PRACOWNIK_id_pracownik`, `DOSTAWCA_id_dostawca`) VALUES
(1, '2017-05-30 16:23:22', 'F0001', 7, 1),
(2, '2017-06-01 12:45:22', 'F0002', 7, 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dostawca`
--

CREATE TABLE `dostawca` (
  `id_dostawca` int(11) NOT NULL,
  `numertelefonu` int(11) DEFAULT NULL,
  `adres` varchar(100) DEFAULT NULL,
  `e-mail` varchar(30) DEFAULT NULL,
  `nazwa` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `dostawca`
--

INSERT INTO `dostawca` (`id_dostawca`, `numertelefonu`, `adres`, `e-mail`, `nazwa`) VALUES
(1, 514236598, 'Ul. Nowakowska 42, 20-265 Piaseczno', 'techimport_info@o2.pl', 'TechImport'),
(2, 522369258, 'Ul. 3. Maja, 03-326 Zamość', 'europarts@gmail.com', 'EuroParts');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dostepnoscmechanika`
--

CREATE TABLE `dostepnoscmechanika` (
  `id_dostepnoscmechanika` int(11) NOT NULL,
  `poczatek` datetime DEFAULT NULL,
  `koniec` datetime DEFAULT NULL,
  `id_mechanik` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `dostepnoscmechanika`
--

INSERT INTO `dostepnoscmechanika` (`id_dostepnoscmechanika`, `poczatek`, `koniec`, `id_mechanik`) VALUES
(126, '2017-07-03 08:00:00', '2017-07-03 18:00:00', 1),
(127, '2017-07-04 08:00:00', '2017-07-04 18:00:00', 1),
(128, '2017-07-05 08:00:00', '2017-07-05 18:00:00', 1),
(129, '2017-07-06 08:00:00', '2017-07-06 18:00:00', 1),
(130, '2017-07-07 08:00:00', '2017-07-07 18:00:00', 1),
(131, '2017-06-26 08:00:00', '2017-06-26 18:00:00', 1),
(132, '2017-06-27 08:00:00', '2017-06-27 18:00:00', 1),
(133, '2017-06-28 08:00:00', '2017-06-28 18:00:00', 1),
(134, '2017-06-29 08:00:00', '2017-06-29 18:00:00', 1),
(135, '2017-06-30 08:00:00', '2017-06-30 18:00:00', 1),
(136, '2017-06-19 08:00:00', '2017-06-19 18:00:00', 2),
(137, '2017-06-20 08:00:00', '2017-06-20 18:00:00', 2),
(138, '2017-06-21 08:00:00', '2017-06-21 18:00:00', 2),
(139, '2017-06-22 08:00:00', '2017-06-22 18:00:00', 2),
(140, '2017-06-23 08:00:00', '2017-06-23 18:00:00', 2),
(141, '2017-06-26 08:00:00', '2017-06-26 18:00:00', 2),
(143, '2017-06-28 08:00:00', '2017-06-28 18:00:00', 2),
(144, '2017-06-29 08:00:00', '2017-06-29 18:00:00', 2),
(145, '2017-06-30 08:00:00', '2017-06-30 18:00:00', 2),
(146, '2017-06-19 08:00:00', '2017-06-19 18:00:00', 3),
(147, '2017-06-20 08:00:00', '2017-06-20 18:00:00', 3),
(148, '2017-06-21 08:00:00', '2017-06-21 18:00:00', 3),
(149, '2017-06-22 08:00:00', '2017-06-22 18:00:00', 3),
(150, '2017-06-23 08:00:00', '2017-06-23 18:00:00', 3),
(151, '2017-06-26 08:00:00', '2017-06-26 18:00:00', 3),
(152, '2017-06-27 08:00:00', '2017-06-27 18:00:00', 3),
(153, '2017-06-28 08:00:00', '2017-06-28 18:00:00', 3),
(154, '2017-06-29 08:00:00', '2017-06-29 18:00:00', 3),
(155, '2017-06-30 08:00:00', '2017-06-30 18:00:00', 3),
(156, '2017-06-19 08:00:00', '2017-06-19 18:00:00', 4),
(157, '2017-06-20 08:00:00', '2017-06-20 18:00:00', 4),
(158, '2017-06-21 08:00:00', '2017-06-21 18:00:00', 4),
(159, '2017-06-22 08:00:00', '2017-06-22 18:00:00', 4),
(160, '2017-06-23 08:00:00', '2017-06-23 18:00:00', 4),
(161, '2017-06-26 08:00:00', '2017-06-26 18:00:00', 4),
(162, '2017-06-27 08:00:00', '2017-06-27 18:00:00', 4),
(163, '2017-06-28 08:00:00', '2017-06-28 18:00:00', 4),
(164, '2017-06-29 08:00:00', '2017-06-29 18:00:00', 4),
(165, '2017-06-30 08:00:00', '2017-06-30 18:00:00', 4),
(166, '2017-06-19 08:00:00', '2017-06-19 18:00:00', 5),
(167, '2017-06-20 08:00:00', '2017-06-20 18:00:00', 5),
(168, '2017-06-21 08:00:00', '2017-06-21 18:00:00', 5),
(169, '2017-06-22 08:00:00', '2017-06-22 18:00:00', 5),
(170, '2017-06-23 08:00:00', '2017-06-23 18:00:00', 5),
(171, '2017-06-26 08:00:00', '2017-06-26 18:00:00', 5),
(172, '2017-06-27 08:00:00', '2017-06-27 18:00:00', 5),
(173, '2017-06-28 08:00:00', '2017-06-28 18:00:00', 5),
(174, '2017-06-29 08:00:00', '2017-06-29 18:00:00', 5),
(175, '2017-06-30 08:00:00', '2017-06-30 18:00:00', 5),
(176, '2017-06-19 08:00:00', '2017-06-19 18:00:00', 6),
(177, '2017-06-20 08:00:00', '2017-06-20 18:00:00', 6),
(178, '2017-06-21 08:00:00', '2017-06-21 18:00:00', 6),
(179, '2017-06-22 08:00:00', '2017-06-22 18:00:00', 6),
(180, '2017-06-23 08:00:00', '2017-06-23 18:00:00', 6),
(181, '2017-06-26 08:00:00', '2017-06-26 18:00:00', 6),
(182, '2017-06-27 08:00:00', '2017-06-27 18:00:00', 6),
(183, '2017-06-28 08:00:00', '2017-06-28 18:00:00', 6),
(184, '2017-06-29 08:00:00', '2017-06-29 18:00:00', 6),
(185, '2017-06-30 08:00:00', '2017-06-30 18:00:00', 6),
(728, '2017-06-27 08:00:00', '2017-06-27 13:23:44', 2),
(729, '2017-06-27 15:13:44', '2017-06-27 18:00:00', 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `egzeplarzczesci`
--

CREATE TABLE `egzeplarzczesci` (
  `id_egzeplarzczesc` int(11) NOT NULL,
  `regal` int(11) DEFAULT NULL,
  `polka` int(11) DEFAULT NULL,
  `DEFINICJACZESCI_id_definicjaczesci` int(11) NOT NULL,
  `CZYNNOSCSERWISOWA_id_czynnoscserwisowa` int(11) DEFAULT NULL,
  `DOSTAWA_id_dostawa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `egzeplarzczesci`
--

INSERT INTO `egzeplarzczesci` (`id_egzeplarzczesc`, `regal`, `polka`, `DEFINICJACZESCI_id_definicjaczesci`, `CZYNNOSCSERWISOWA_id_czynnoscserwisowa`, `DOSTAWA_id_dostawa`) VALUES
(1, 1, 1, 1, NULL, 1),
(2, 1, 1, 2, NULL, 1),
(3, 2, 1, 3, NULL, 1),
(4, 1, 5, 4, NULL, 1),
(5, 4, 1, 5, NULL, 1),
(6, 1, 5, 6, NULL, 1),
(7, 5, 4, 7, NULL, 2),
(8, 1, 2, 8, NULL, 2),
(9, 2, 1, 9, NULL, 2),
(10, 4, 3, 10, NULL, 2),
(11, 2, 4, 11, NULL, 2),
(12, 2, 3, 11, NULL, 1),
(13, 5, 5, 1, NULL, 1),
(14, 4, 4, 2, NULL, 2),
(15, 3, 5, 3, NULL, 1),
(16, 1, 7, 4, NULL, 2),
(17, 2, 5, 5, NULL, 2),
(18, 1, 5, 6, NULL, 1),
(19, 4, 4, 7, NULL, 2),
(20, 1, 5, 8, NULL, 2),
(21, 2, 3, 9, NULL, 2),
(22, 3, 6, 10, NULL, 1),
(23, 1, 5, 11, NULL, 1),
(24, 5, 5, 1, NULL, 1),
(25, 4, 4, 2, NULL, 2),
(26, 3, 5, 3, NULL, 1),
(27, 1, 7, 4, NULL, 2),
(28, 2, 5, 5, NULL, 2),
(29, 1, 5, 6, NULL, 1),
(30, 4, 4, 7, NULL, 2),
(31, 1, 5, 8, NULL, 2),
(32, 2, 3, 9, NULL, 2),
(33, 3, 6, 10, NULL, 1),
(34, 1, 5, 11, NULL, 1),
(35, 5, 5, 1, NULL, 1),
(36, 4, 4, 2, NULL, 2),
(37, 3, 5, 3, NULL, 1),
(38, 1, 7, 4, NULL, 2),
(39, 2, 5, 5, NULL, 2),
(40, 1, 5, 6, NULL, 1),
(41, 4, 4, 7, NULL, 2),
(42, 1, 5, 8, NULL, 2),
(43, 2, 3, 9, NULL, 2),
(44, 3, 6, 10, NULL, 1),
(45, 1, 5, 11, NULL, 1),
(46, 1, 2, 1, NULL, 1),
(47, 1, 2, 2, NULL, 1),
(48, 1, 2, 3, NULL, 1),
(49, 1, 2, 4, NULL, 1),
(50, 1, 2, 5, NULL, 1),
(51, 1, 2, 6, NULL, 1),
(52, 1, 2, 7, NULL, 1),
(53, 1, 2, 8, NULL, 1),
(54, 1, 2, 9, NULL, 1),
(55, 1, 2, 10, NULL, 1),
(56, 1, 2, 11, NULL, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `mechanik`
--

CREATE TABLE `mechanik` (
  `id_mechanik` int(11) NOT NULL,
  `SPECJALIZACJAMECHANIKA_id_specjalizacjamechanika` int(11) NOT NULL,
  `PRACOWNIK_id_pracownik` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `mechanik`
--

INSERT INTO `mechanik` (`id_mechanik`, `SPECJALIZACJAMECHANIKA_id_specjalizacjamechanika`, `PRACOWNIK_id_pracownik`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 8);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `model`
--

CREATE TABLE `model` (
  `id_model` int(11) NOT NULL,
  `poczatkowyrokprodukcji` int(11) DEFAULT NULL,
  `koncowyrokprodukcji` int(11) DEFAULT NULL,
  `pojemnoscsilnika` float DEFAULT NULL,
  `mocsilnika` int(11) DEFAULT NULL,
  `wersja` varchar(45) DEFAULT NULL,
  `nazwa` varchar(20) DEFAULT NULL,
  `marka` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `model`
--

INSERT INTO `model` (`id_model`, `poczatkowyrokprodukcji`, `koncowyrokprodukcji`, `pojemnoscsilnika`, `mocsilnika`, `wersja`, `nazwa`, `marka`) VALUES
(1, 1995, 1999, 1.6, 75, '1', 'cordoba', 'seat'),
(2, 1986, 1994, 3, 140, '3', 'transit', 'ford'),
(3, 1994, 2000, 2.9, 150, '4', 'transit', 'ford'),
(4, 1998, 2000, 2, 110, '5', 'transit', 'ford'),
(5, 2000, 2005, 2, 100, '6', 'transit', 'ford'),
(6, 2010, 2015, 1.8, 180, '5', 'corolla', 'toyota'),
(7, 2003, 2008, 1.4, 80, 'xc', 'crio', 'renault'),
(8, 1995, 2000, 1.8, 80, '1', 'swift', 'suzuki');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `model_has_definicjaczesci`
--

CREATE TABLE `model_has_definicjaczesci` (
  `MODEL_id_model` int(11) NOT NULL,
  `DEFINICJACZESCI_id_definicjaczesci` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `model_has_definicjaczesci`
--

INSERT INTO `model_has_definicjaczesci` (`MODEL_id_model`, `DEFINICJACZESCI_id_definicjaczesci`) VALUES
(1, 2),
(1, 3),
(1, 5),
(1, 11),
(2, 9),
(2, 10),
(3, 8),
(3, 9),
(3, 10),
(4, 1),
(4, 7),
(4, 8),
(5, 1),
(5, 7),
(6, 5),
(7, 2),
(7, 6),
(8, 3),
(8, 4);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownik`
--

CREATE TABLE `pracownik` (
  `id_pracownik` int(11) NOT NULL,
  `imie` varchar(45) DEFAULT NULL,
  `nazwisko` varchar(45) DEFAULT NULL,
  `pesel` varchar(11) DEFAULT NULL,
  `stawkagodzinowa` float DEFAULT NULL,
  `adres` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `pracownik`
--

INSERT INTO `pracownik` (`id_pracownik`, `imie`, `nazwisko`, `pesel`, `stawkagodzinowa`, `adres`) VALUES
(1, 'Mirosław', 'Wąsik', '69020365892', 15, 'Ul. Madalińskiego 12/234, 02-547 Warszawa'),
(2, 'Andrzej', 'Wielgos', '75111202365', 15, 'Ul. Śniardwy 3/30, 02-547 Warszawa'),
(3, 'Łukasz', 'Pasternak', '55060801236', 15, 'Borzychy 45, 07-120 Korytnica'),
(4, 'Hubert', 'Kruszewski', '88060623652', 15, 'Pniewnik 12c, 07-100 Węgrów'),
(5, 'Piotr', 'Nojszewski', '68010825411', 23, 'Ul. Mickiewicza 12/2, 07-100 Węgrów'),
(6, 'Mariusz', 'Jaczewski', '95082365325', 20, 'Rabiany 20 07-120 Korytnica'),
(7, 'Jan', 'Kodym', '77020325369', 20, 'Ul. Bacha23/1001, 02-547 Warszawa'),
(8, 'Karol', 'Szczepański', '85060256365', 20, 'Ul.Pruszkowska 12c, 02-547 Warszawa');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `reklamacja`
--

CREATE TABLE `reklamacja` (
  `id_reklamacja` int(11) NOT NULL,
  `data_zgloszenia` datetime DEFAULT NULL,
  `opis` varchar(500) DEFAULT NULL,
  `data_zakonczenia` datetime DEFAULT NULL,
  `ZLECENIE_id_zlecenie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `reklamacja`
--

INSERT INTO `reklamacja` (`id_reklamacja`, `data_zgloszenia`, `opis`, `data_zakonczenia`, `ZLECENIE_id_zlecenie`) VALUES
(1, '2017-06-26 21:16:00', '  ', NULL, 3),
(2, '2017-06-26 21:16:06', '  ', NULL, 3),
(3, '2017-06-26 22:49:12', ' fgdhfghdffhgdgh ', NULL, 1),
(4, '2017-06-27 09:47:47', '  ', NULL, 8),
(5, '2017-06-27 10:21:08', ' nie dziala ', NULL, 6);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `specjalizacjamechanika`
--

CREATE TABLE `specjalizacjamechanika` (
  `id_specjalizacjamechanika` int(11) NOT NULL,
  `nazwa` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `specjalizacjamechanika`
--

INSERT INTO `specjalizacjamechanika` (`id_specjalizacjamechanika`, `nazwa`) VALUES
(1, 'elektryk'),
(2, 'blacharz_lakiernik'),
(3, 'ekspert od silników'),
(4, 'ekspert od zawieszenia'),
(5, 'ogólny'),
(6, 'specjalista');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `stanowisko`
--

CREATE TABLE `stanowisko` (
  `id_stanowisko` int(11) NOT NULL,
  `TYPSTANOWISKA_id_typstanowiska` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `stanowisko`
--

INSERT INTO `stanowisko` (`id_stanowisko`, `TYPSTANOWISKA_id_typstanowiska`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 5);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `typstanowiska`
--

CREATE TABLE `typstanowiska` (
  `id_typstanowiska` int(11) NOT NULL,
  `nazwa` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `typstanowiska`
--

INSERT INTO `typstanowiska` (`id_typstanowiska`, `nazwa`) VALUES
(1, 'lakiernicze'),
(2, 'elektryczne'),
(3, 'kanał'),
(4, 'podnośnik'),
(5, 'ogólne');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `login` varchar(20) DEFAULT NULL,
  `pasword` varchar(20) DEFAULT NULL,
  `job` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`login`, `pasword`, `job`) VALUES
('mar', 'jacz', 'recepcjonista'),
('dawid', 'kurzawa', 'manager'),
('olo', 'kow', 'magazynier');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wlasciciel`
--

CREATE TABLE `wlasciciel` (
  `id_wlasciciel` int(11) NOT NULL,
  `nazwisko` varchar(20) DEFAULT NULL,
  `imie` varchar(20) DEFAULT NULL,
  `adres` varchar(100) DEFAULT NULL,
  `e-mail` varchar(40) DEFAULT NULL,
  `nr_telefonu` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `wlasciciel`
--

INSERT INTO `wlasciciel` (`id_wlasciciel`, `nazwisko`, `imie`, `adres`, `e-mail`, `nr_telefonu`) VALUES
(1, 'Borkusewicz', 'Bartek', 'Dąbrowice 13, 05-220 Piszczec', 'borkusewicz@gmail.com', '515523569'),
(2, 'Podpirka', 'Mateusz', 'Mickiewicza 3a, 66-352 Węgrów', 'podpir@gmail.com', '602563874'),
(3, 'Aftyka', 'Jakub', 'Wołoska 141a, 02-507 Warszawa', 'afryka@gmail.com', '732569789'),
(4, 'Powierża', 'Kamil', 'Maksymilianów 23, 07-100 Węgrów', 'powierzak@gmail.com', '609345123'),
(5, 'Karaban', 'Hubert', 'Zofinin 43c, 07-100 Węgrów', 'hubertkaraban@gmail.com', '709893129'),
(6, 'Sylwia', 'Książek', 'ul. Sienkiewicza 34, 07-100 Tończa', 'książek@o2.pl', '514578384'),
(26, ' Koprowski ', ' Roman ', ' Modrzew 23c, 09-239Modrzew ', ' koper@o2.pl ', ' 500234123 ');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zlecenie`
--

CREATE TABLE `zlecenie` (
  `data_przyjecia` datetime DEFAULT NULL,
  `data_zakonczenia` datetime DEFAULT NULL,
  `wartosc` int(11) DEFAULT NULL,
  `marza` float DEFAULT NULL,
  `id_zlecenie` int(11) NOT NULL,
  `REKLAMACJA_id_reklamacja` int(11) DEFAULT NULL,
  `AUTO_id_auto` int(11) NOT NULL,
  `DIAGNOZA_id_diagnoza` int(11) DEFAULT NULL,
  `WLASCICIEL_id_wlasciciel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `zlecenie`
--

INSERT INTO `zlecenie` (`data_przyjecia`, `data_zakonczenia`, `wartosc`, `marza`, `id_zlecenie`, `REKLAMACJA_id_reklamacja`, `AUTO_id_auto`, `DIAGNOZA_id_diagnoza`, `WLASCICIEL_id_wlasciciel`) VALUES
('2017-06-16 13:53:20', NULL, 20000, 2, 1, 3, 1, NULL, 1),
('2017-06-19 18:47:34', NULL, 200, 2, 2, NULL, 2, NULL, 2),
('2017-06-25 11:59:02', NULL, 180, 0, 3, 2, 1, NULL, 1),
('2017-06-25 12:11:43', NULL, 70, 0, 4, NULL, 1, NULL, 1),
('2017-06-25 13:40:12', NULL, 200, 0, 5, NULL, 1, NULL, 1),
('2017-06-25 13:51:47', NULL, 120, 0, 6, 5, 1, NULL, 1),
('2017-06-25 21:06:55', NULL, 0, 0, 7, NULL, 1, NULL, 1),
('2017-06-26 15:51:23', NULL, 305, 0, 8, 4, 1, NULL, 1),
('2017-06-27 01:52:01', NULL, 305, 0, 9, NULL, 1, NULL, 1),
('2017-06-27 01:56:23', NULL, 710, 0, 10, NULL, 18, NULL, 26),
('2017-06-27 01:59:55', NULL, 480, 0, 11, NULL, 1, NULL, 1),
('2017-06-27 02:00:41', NULL, 425, 0, 12, NULL, 17, NULL, 6),
('2017-06-27 02:07:54', NULL, 550, 0, 13, NULL, 5, NULL, 4),
('2017-06-27 02:10:41', NULL, 1320, 0, 14, NULL, 7, NULL, 3),
('2017-06-27 09:48:07', NULL, 40, 0, 15, NULL, 1, NULL, 1),
('2017-06-27 13:13:56', NULL, 240, 0, 16, NULL, 1, NULL, 1),
('2017-06-27 13:15:13', NULL, 305, 0, 17, NULL, 1, NULL, 1),
('2017-06-27 13:23:57', NULL, 240, 0, 18, NULL, 1, NULL, 1);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `auto`
--
ALTER TABLE `auto`
  ADD PRIMARY KEY (`id_auto`),
  ADD KEY `fk_AUTO_WLASCICIEL1_idx` (`WLASCICIEL_id_wlasciciel`),
  ADD KEY `fk_AUTO_MODEL1_idx` (`MODEL_id_model`);

--
-- Indexes for table `czynnoscserwisowa`
--
ALTER TABLE `czynnoscserwisowa`
  ADD PRIMARY KEY (`id_czynnoscserwisowa`),
  ADD KEY `fk_CZYNNOSCSERWISOWA_ZLECENIE1_idx` (`ZLECENIE_id_zlecenie`),
  ADD KEY `fk_CZYNNOSCSERWISOWA_DEFINICJACS1_idx` (`DEFINICJACS_ID_DEFINICJACS`),
  ADD KEY `fk_CZYNNOSCSERWISOWA_MECHANIK1_idx` (`MECHANIK_id_mechanik`),
  ADD KEY `fk_CZYNNOSCSERWISOWA_STANOWISKO1_idx` (`STANOWISKO_id_stanowisko`);

--
-- Indexes for table `definicjacs`
--
ALTER TABLE `definicjacs`
  ADD PRIMARY KEY (`ID_DEFINICJACS`),
  ADD KEY `fk_DEFINICJACS_SPECJALIZACJAMECHANIKA1_idx` (`SPECJALIZACJAMECHANIKA_id_specjalizacjamechanika`),
  ADD KEY `fk_DEFINICJACS_TYPSTANOWISKA1_idx` (`TYPSTANOWISKA_id_typstanowiska`);

--
-- Indexes for table `definicjacs_has_definicjaczesci`
--
ALTER TABLE `definicjacs_has_definicjaczesci`
  ADD PRIMARY KEY (`DEFINICJACS_ID_DEFINICJACS`,`DEFINICJACZESCI_id_definicjaczesci`),
  ADD KEY `fk_DEFINICJACS_has_DEFINICJACZESCI_DEFINICJACZESCI1_idx` (`DEFINICJACZESCI_id_definicjaczesci`),
  ADD KEY `fk_DEFINICJACS_has_DEFINICJACZESCI_DEFINICJACS1_idx` (`DEFINICJACS_ID_DEFINICJACS`);

--
-- Indexes for table `definicjacs_has_model`
--
ALTER TABLE `definicjacs_has_model`
  ADD PRIMARY KEY (`DEFINICJACS_ID_DEFINICJACS`,`MODEL_id_model`),
  ADD KEY `fk_DEFINICJACS_has_MODEL_MODEL1_idx` (`MODEL_id_model`),
  ADD KEY `fk_DEFINICJACS_has_MODEL_DEFINICJACS1_idx` (`DEFINICJACS_ID_DEFINICJACS`);

--
-- Indexes for table `definicjaczesci`
--
ALTER TABLE `definicjaczesci`
  ADD PRIMARY KEY (`id_definicjaczesci`);

--
-- Indexes for table `diagnoza`
--
ALTER TABLE `diagnoza`
  ADD PRIMARY KEY (`id_diagnoza`),
  ADD KEY `fk_DIAGNOZA_PRACOWNIK1_idx` (`PRACOWNIK_id_pracownik`);

--
-- Indexes for table `dostawa`
--
ALTER TABLE `dostawa`
  ADD PRIMARY KEY (`id_dostawa`),
  ADD KEY `fk_DOSTAWA_PRACOWNIK1_idx` (`PRACOWNIK_id_pracownik`),
  ADD KEY `fk_DOSTAWA_DOSTAWCA1_idx` (`DOSTAWCA_id_dostawca`);

--
-- Indexes for table `dostawca`
--
ALTER TABLE `dostawca`
  ADD PRIMARY KEY (`id_dostawca`);

--
-- Indexes for table `dostepnoscmechanika`
--
ALTER TABLE `dostepnoscmechanika`
  ADD PRIMARY KEY (`id_dostepnoscmechanika`),
  ADD KEY `id_mechanik` (`id_mechanik`);

--
-- Indexes for table `egzeplarzczesci`
--
ALTER TABLE `egzeplarzczesci`
  ADD PRIMARY KEY (`id_egzeplarzczesc`),
  ADD KEY `fk_EGZEPLARZCZESCI_DEFINICJACZESCI1_idx` (`DEFINICJACZESCI_id_definicjaczesci`),
  ADD KEY `fk_EGZEPLARZCZESCI_CZYNNOSCSERWISOWA1_idx` (`CZYNNOSCSERWISOWA_id_czynnoscserwisowa`),
  ADD KEY `fk_EGZEPLARZCZESCI_DOSTAWA1_idx` (`DOSTAWA_id_dostawa`);

--
-- Indexes for table `mechanik`
--
ALTER TABLE `mechanik`
  ADD PRIMARY KEY (`id_mechanik`),
  ADD KEY `fk_MECHANIK_SPECJALIZACJAMECHANIKA1_idx` (`SPECJALIZACJAMECHANIKA_id_specjalizacjamechanika`),
  ADD KEY `PRACOWNIK_id_pracownik` (`PRACOWNIK_id_pracownik`);

--
-- Indexes for table `model`
--
ALTER TABLE `model`
  ADD PRIMARY KEY (`id_model`);

--
-- Indexes for table `model_has_definicjaczesci`
--
ALTER TABLE `model_has_definicjaczesci`
  ADD PRIMARY KEY (`MODEL_id_model`,`DEFINICJACZESCI_id_definicjaczesci`),
  ADD KEY `fk_MODEL_has_DEFINICJACZESCI_DEFINICJACZESCI1_idx` (`DEFINICJACZESCI_id_definicjaczesci`),
  ADD KEY `fk_MODEL_has_DEFINICJACZESCI_MODEL1_idx` (`MODEL_id_model`);

--
-- Indexes for table `pracownik`
--
ALTER TABLE `pracownik`
  ADD PRIMARY KEY (`id_pracownik`);

--
-- Indexes for table `reklamacja`
--
ALTER TABLE `reklamacja`
  ADD PRIMARY KEY (`id_reklamacja`),
  ADD KEY `fk_REKLAMACJA_ZLECENIE1_idx` (`ZLECENIE_id_zlecenie`);

--
-- Indexes for table `specjalizacjamechanika`
--
ALTER TABLE `specjalizacjamechanika`
  ADD PRIMARY KEY (`id_specjalizacjamechanika`);

--
-- Indexes for table `stanowisko`
--
ALTER TABLE `stanowisko`
  ADD PRIMARY KEY (`id_stanowisko`),
  ADD KEY `fk_STANOWISKO_TYPSTANOWISKA1_idx` (`TYPSTANOWISKA_id_typstanowiska`);

--
-- Indexes for table `typstanowiska`
--
ALTER TABLE `typstanowiska`
  ADD PRIMARY KEY (`id_typstanowiska`);

--
-- Indexes for table `wlasciciel`
--
ALTER TABLE `wlasciciel`
  ADD PRIMARY KEY (`id_wlasciciel`),
  ADD UNIQUE KEY `id_wlasciciel_2` (`id_wlasciciel`),
  ADD KEY `id_wlasciciel` (`id_wlasciciel`);

--
-- Indexes for table `zlecenie`
--
ALTER TABLE `zlecenie`
  ADD PRIMARY KEY (`id_zlecenie`),
  ADD KEY `fk_ZLECENIE_REKLAMACJA1_idx` (`REKLAMACJA_id_reklamacja`),
  ADD KEY `fk_ZLECENIE_AUTO1_idx` (`AUTO_id_auto`),
  ADD KEY `fk_ZLECENIE_DIAGNOZA1_idx` (`DIAGNOZA_id_diagnoza`),
  ADD KEY `fk_ZLECENIE_WLASCICIEL1_idx` (`WLASCICIEL_id_wlasciciel`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `auto`
--
ALTER TABLE `auto`
  MODIFY `id_auto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT dla tabeli `czynnoscserwisowa`
--
ALTER TABLE `czynnoscserwisowa`
  MODIFY `id_czynnoscserwisowa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=167;
--
-- AUTO_INCREMENT dla tabeli `definicjacs`
--
ALTER TABLE `definicjacs`
  MODIFY `ID_DEFINICJACS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT dla tabeli `definicjaczesci`
--
ALTER TABLE `definicjaczesci`
  MODIFY `id_definicjaczesci` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT dla tabeli `diagnoza`
--
ALTER TABLE `diagnoza`
  MODIFY `id_diagnoza` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `dostawa`
--
ALTER TABLE `dostawa`
  MODIFY `id_dostawa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT dla tabeli `dostawca`
--
ALTER TABLE `dostawca`
  MODIFY `id_dostawca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT dla tabeli `dostepnoscmechanika`
--
ALTER TABLE `dostepnoscmechanika`
  MODIFY `id_dostepnoscmechanika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=730;
--
-- AUTO_INCREMENT dla tabeli `egzeplarzczesci`
--
ALTER TABLE `egzeplarzczesci`
  MODIFY `id_egzeplarzczesc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
--
-- AUTO_INCREMENT dla tabeli `mechanik`
--
ALTER TABLE `mechanik`
  MODIFY `id_mechanik` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT dla tabeli `model`
--
ALTER TABLE `model`
  MODIFY `id_model` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  MODIFY `id_pracownik` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT dla tabeli `reklamacja`
--
ALTER TABLE `reklamacja`
  MODIFY `id_reklamacja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT dla tabeli `specjalizacjamechanika`
--
ALTER TABLE `specjalizacjamechanika`
  MODIFY `id_specjalizacjamechanika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT dla tabeli `stanowisko`
--
ALTER TABLE `stanowisko`
  MODIFY `id_stanowisko` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT dla tabeli `typstanowiska`
--
ALTER TABLE `typstanowiska`
  MODIFY `id_typstanowiska` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT dla tabeli `wlasciciel`
--
ALTER TABLE `wlasciciel`
  MODIFY `id_wlasciciel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT dla tabeli `zlecenie`
--
ALTER TABLE `zlecenie`
  MODIFY `id_zlecenie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `czynnoscserwisowa`
--
ALTER TABLE `czynnoscserwisowa`
  ADD CONSTRAINT `fk_CZYNNOSCSERWISOWA_DEFINICJACS1` FOREIGN KEY (`DEFINICJACS_ID_DEFINICJACS`) REFERENCES `definicjacs` (`ID_DEFINICJACS`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CZYNNOSCSERWISOWA_MECHANIK1` FOREIGN KEY (`MECHANIK_id_mechanik`) REFERENCES `mechanik` (`id_mechanik`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CZYNNOSCSERWISOWA_STANOWISKO1` FOREIGN KEY (`STANOWISKO_id_stanowisko`) REFERENCES `stanowisko` (`id_stanowisko`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CZYNNOSCSERWISOWA_ZLECENIE1` FOREIGN KEY (`ZLECENIE_id_zlecenie`) REFERENCES `zlecenie` (`id_zlecenie`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `dostepnoscmechanika`
--
ALTER TABLE `dostepnoscmechanika`
  ADD CONSTRAINT `id_mechanik` FOREIGN KEY (`id_mechanik`) REFERENCES `mechanik` (`id_mechanik`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
