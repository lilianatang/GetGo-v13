-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Mar 18, 2018 at 06:09 PM
-- Server version: 5.6.38
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `getGo`
--

-- --------------------------------------------------------

--
-- Table structure for table `condition`
--

CREATE TABLE `condition` (
  `id` int(21) NOT NULL,
  `institution_id` int(21) NOT NULL,
  `department_id` int(21) NOT NULL,
  `min_mark` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `condition`
--

INSERT INTO `condition` (`id`, `institution_id`, `department_id`, `min_mark`) VALUES
(1, 1, 1, 50),
(2, 1, 1, 50),
(3, 1, 1, 50),
(4, 1, 1, 50),
(5, 1, 1, 50),
(6, 1, 2, 50),
(7, 1, 2, 50),
(8, 1, 2, 50),
(9, 1, 2, 50),
(10, 1, 2, 50),
(11, 1, 3, 50),
(12, 1, 3, 50),
(13, 1, 3, 50),
(14, 1, 3, 50),
(15, 1, 3, 50),
(16, 1, 4, 50),
(17, 1, 4, 50),
(18, 1, 4, 50),
(19, 1, 4, 50),
(20, 1, 4, 50),
(21, 1, 5, 50),
(22, 1, 5, 50),
(23, 1, 5, 50),
(24, 1, 5, 50),
(25, 1, 5, 50),
(26, 1, 6, 50),
(27, 1, 6, 50),
(28, 1, 6, 50),
(29, 1, 6, 50),
(30, 1, 6, 50),
(31, 2, 7, 50),
(32, 2, 7, 50),
(33, 2, 7, 50),
(34, 2, 7, 50),
(35, 2, 7, 50),
(36, 2, 8, 50),
(37, 2, 8, 50),
(38, 2, 8, 50),
(39, 2, 8, 50),
(40, 2, 8, 50),
(41, 2, 9, 50),
(42, 2, 9, 50),
(43, 2, 9, 50),
(44, 2, 9, 50),
(45, 2, 9, 50),
(46, 2, 10, 50),
(47, 2, 10, 50),
(48, 2, 10, 50),
(49, 2, 10, 50),
(50, 2, 10, 50),
(51, 2, 11, 50),
(52, 2, 11, 50),
(53, 2, 11, 50),
(54, 2, 11, 50),
(55, 2, 11, 50),
(56, 2, 12, 50),
(57, 2, 12, 50),
(58, 2, 12, 50),
(59, 2, 12, 50),
(60, 2, 13, 50),
(61, 2, 13, 50),
(62, 2, 13, 50),
(63, 2, 13, 50),
(64, 2, 13, 50),
(66, 4, 8, 50),
(67, 4, 8, 50),
(68, 4, 8, 50),
(69, 4, 8, 50),
(70, 4, 8, 50),
(71, 4, 9, 50),
(72, 4, 9, 50),
(73, 4, 9, 50),
(74, 4, 9, 50),
(75, 4, 9, 50),
(76, 4, 10, 50),
(77, 4, 10, 50),
(78, 4, 10, 50),
(79, 4, 10, 50),
(80, 4, 10, 50),
(81, 4, 11, 50),
(82, 4, 11, 50),
(83, 4, 11, 50),
(84, 4, 11, 50),
(85, 4, 11, 50),
(86, 3, 20, 50),
(87, 3, 21, 50),
(88, 3, 22, 50),
(89, 3, 23, 50),
(90, 3, 24, 50),
(91, 3, 25, 50),
(92, 3, 26, 50),
(93, 3, 27, 50),
(94, 3, 28, 50),
(95, 3, 29, 50),
(96, 3, 30, 50),
(97, 3, 31, 50),
(98, 3, 32, 50);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(21) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `credits` varchar(10) DEFAULT NULL,
  `description` varchar(200) DEFAULT '"None"'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `name`, `credits`, `description`) VALUES
(1, 'English Language Arts 30-1', '5', ''),
(2, 'Mathematics 30-1', '5', ''),
(3, 'Biology 30', '5', ''),
(4, 'Computing Science 35 AP', '5', ''),
(5, 'Computing Science ADV(CTS-5Cr)', '5', ''),
(6, 'Mathematics 31', '5', ''),
(7, 'Physics (AP) 35', '5', ''),
(8, 'Physics 30', '5', ''),
(9, 'Chemistry 30', '5', ''),
(10, 'Dance 35', '5', ''),
(11, 'Portfolio Art 35', '5', ''),
(12, 'Dance Composition 35', '5', ''),
(13, 'Directing 35', '5', ''),
(14, 'Drawing(Adv Techn) 35(CTS-5Cr)', '5', ''),
(15, 'Film & Media Arts 35(CTS-5Cr)', '5', ''),
(16, 'Film Studies 35', '5', ''),
(17, 'Applied Graphic Arts 35', '5', ''),
(18, 'Music 35', '5', ''),
(19, 'Instrumental Jazz 35', '5', ''),
(20, 'Painting (Adv Techn) 35', '5', ''),
(21, 'Jazz Dance 35', '5', ''),
(22, 'Pottery/Ceramics(Adv Techn) 35', '5', ''),
(23, 'Sculpting (Adv Techn) 35', '5', ''),
(24, 'Shooting the Screenplay 35', '5', ''),
(25, 'Tap Dance 35', '5', ''),
(26, 'Technical Theatre 35 (5Cr)', '5', ''),
(27, 'Technical Theatre EPS 35', '5', ''),
(28, 'Theatre Arts 35', '5', ''),
(29, 'Vocal Jazz 35', '5', ''),
(30, 'Ballet 35', '5', ''),
(31, 'Band 35', '5', ''),
(32, 'Adv Acting/Touring Theatre 35', '5', ''),
(33, 'Adv Tech-Print/Draw/Sculp(5Cr)', '5', ''),
(34, 'Choir 35', '5', ''),
(35, 'CommunicationTech Adv(CTS-5Cr)', '5', ''),
(36, 'Contemporary Dance 35', '5', ''),
(37, 'Performing Arts 35A', '5', ''),
(38, 'Drama 30', '5', ''),
(39, 'General Music 30', '5', ''),
(40, 'Band Music 35', '5', ''),
(41, 'Musical Theatre 35', '5', ''),
(42, 'Art 30', '5', ''),
(43, 'Art 31', '5', ''),
(44, 'Instrumental Music 30', '5', ''),
(45, 'Choral Music 30', '5', ''),
(46, 'Aboriginal Studies 30', '5', ''),
(47, 'Social Studies 30-1', '5', ''),
(48, 'Hungarian 35', '5', ''),
(49, 'Cree Lang & Culture 30-3Y', '5', ''),
(50, 'Cree Lang & Culture 30-6Y', '5', ''),
(51, 'Cree Language & Culture 30-9Y', '5', ''),
(52, 'Cree L & C 30-12Y', '5', ''),
(53, 'Cree Lang & Culture 30', '5', ''),
(54, 'Portuguese 35', '5', ''),
(55, 'Portuguese Lang &Culture 35-3Y', '5', ''),
(56, 'Swedish 35', '5', ''),
(57, 'Spanish Lang & Culture 30-3Y', '5', ''),
(58, 'Spanish Lang & Culture 30-6Y', '5', ''),
(59, 'Spanish Lang & Culture 30-9Y', '5', ''),
(60, 'Spanish Language Arts 30', '5', ''),
(61, 'Am Sgn Lng & Deaf Culture 35', '5', ''),
(62, 'Am Sign L & C 35-9Y', '5', ''),
(63, 'American Sign Lang Arts 35', '5', ''),
(64, 'Latin 30', '5', ''),
(65, 'Italian Lang & Culture 30-3Y', '5', ''),
(66, 'Italian Lang & Culture 30-6Y', '5', ''),
(67, 'Chinese Lang & Culture 30-3Y', '5', ''),
(68, 'Chinese Lang & Culture 30-6Y', '5', ''),
(69, 'Chinese Lang & Culture 30-9Y', '5', ''),
(70, 'Chinese Language Arts 30', '5', ''),
(71, 'Russian 35', '5', ''),
(72, 'Korean Lang & Culture 35', '5', ''),
(73, 'Polish Language & Arts 35', '5', ''),
(74, 'Korean Lang & Culture 35-3Y', '5', ''),
(75, 'Polish Lang & Culture 35 - 12Y', '5', ''),
(76, 'Polish Lang & Culture 35 - 3Y', '5', ''),
(77, 'Francais 30-1', '5', ''),
(78, 'Francais 30-2', '5', ''),
(79, 'French 30 (New)', '5', ''),
(80, 'French 30-9Y', '5', ''),
(81, 'French 31', '5', ''),
(82, 'French Language Arts 30-1', '5', ''),
(83, 'French Language Arts 30-2', '5', ''),
(84, 'French 30-3Y', '5', ''),
(85, 'Punjabi Lang & Culture 30-3Y', '5', ''),
(86, 'Punjabi Lang & Culture 30-9Y', '5', ''),
(87, 'Punjabi Lang & Culture 35', '5', ''),
(88, 'Sikh and Punjabi 35', '5', ''),
(89, 'Hebrew 35', '5', ''),
(90, 'Hebrew Language Arts 35', '5', ''),
(91, 'Greek 35', '5', ''),
(92, 'Arabic L & C 35-12Y', '5', ''),
(93, 'Arabic L & C 35-6Y', '5', ''),
(94, 'German Lang & Culture 30-3Y', '5', ''),
(95, 'German Lang & Culture 30-6Y', '5', ''),
(96, 'German Lang & Culture 30-9Y', '5', ''),
(97, 'German Language Arts 30', '5', ''),
(98, 'German Language Arts 35', '5', ''),
(99, 'Polish 35', '5', ''),
(100, 'Blackfoot Lang & Cult 30', '5', ''),
(101, 'Japanese 30', '5', ''),
(102, 'Japanese Lang & Culture 30-3Y', '5', ''),
(103, 'Japanese Lang & Culture 30-6Y', '5', ''),
(104, 'Japanese Lang & Culture 30-9Y', '5', ''),
(105, 'Ukrainian Lang Arts 30', '5', ''),
(106, 'Ukranian Lang & Culture 30-3Y', '5', ''),
(107, 'Ukranian Lang & Culture 30-6Y', '5', ''),
(108, 'Ukranian Lang & Culture 30-9Y', '5', ''),
(109, 'Science 30', '5', ''),
(110, 'Mathematics 30-2', '5', ''),
(111, 'Macro-Economics 30', '5', ''),
(112, 'Community Health Adv (CTS-5Cr)', '5', ''),
(113, 'Foods Adv (CTS-5Cr)', '5', ''),
(114, 'Agriculture Adv (CTS-5Cr)', '5', ''),
(115, 'Wildlife Adv (CTS-5Cr)', '5', ''),
(116, 'Forestry Adv (CTS-5Cr)', '5', ''),
(117, 'Micro-Economics 30', '5', ''),
(118, 'Physical Education 30', '5', ''),
(119, 'Applied Sociology 30', '5', ''),
(120, 'Cultural and Physical Anthropology 30', '5', ''),
(121, 'Experimental Psychology 30', '5', ''),
(122, 'International Politics 30', '5', ''),
(123, 'Philosophies of Man 30', '5', ''),
(124, 'Religious Studies 35', '5', ''),
(125, 'Western World History 30', '5', ''),
(126, 'World Geography 30', '5', ''),
(127, 'World Religion 30', '5', ''),
(128, 'Community Care Services', '3 or 5', ''),
(129, 'Construction Technologies', '3 or 5', ''),
(130, 'Cosmetology', '3 or 5', ''),
(131, 'Criminal Justice Studies', '3 or 5', ''),
(132, 'Design Studies', '3 or 5', ''),
(133, 'Electro-Technologies', '3 or 5', ''),
(134, 'Enterprise and innovation', '3 or 5', ''),
(135, 'Enviromental Stewardship', '3 or 5', ''),
(136, 'Esthetics', '3 or 5', ''),
(137, 'Fabrication Studies', '3 or 5', ''),
(138, 'Fashion Studies', '3 or 5', ''),
(139, 'Financial Management', '3 or 5', ''),
(140, 'Health Care Aide', '3 or 5', ''),
(141, 'Health Care Services', '3 or 5', ''),
(142, 'Human & Social Services', '3 or 5', ''),
(143, 'Information Processing', '3 or 5', ''),
(144, 'Legal Studies', '3 or 5', ''),
(145, 'Logistics', '3 or 5', ''),
(146, 'Management & Marketing', '3 or 5', ''),
(147, 'Mechanics', '3 or 5', ''),
(148, 'Networking', '3 or 5', ''),
(149, 'Power Engineering', '3 or 5', ''),
(150, 'Primary Resources', '3 or 5', ''),
(151, 'Recreation Leadership', '3 or 5', ''),
(152, 'Tourism Studies', '3 or 5', '');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `id` int(21) NOT NULL,
  `institution_id` int(21) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `average_mark` int(3) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `institution_id`, `name`, `average_mark`, `description`) VALUES
(1, 1, 'Faculty of Science', 70, ''),
(2, 1, 'Faculty of Arts', 70, ''),
(3, 1, 'Faculty of Engineering', 70, ''),
(4, 1, 'Faculty of Nursing', 70, ''),
(5, 1, '\"Faculty of Agricultural Life and Environmental Science\"', 70, ''),
(6, 1, 'Faculty of Physical Education and Recreation', 70, ''),
(7, 2, 'School of Business', 65, ''),
(8, 2, 'Faculty of Nursing', 65, ''),
(9, 2, 'Faculty of Science', 65, ''),
(10, 2, 'Faculty of Arts', 65, ''),
(11, 2, 'Faculty of Engineering Transfer', 70, ''),
(12, 2, 'Faculty of Fine Arts', 60, ''),
(13, 2, 'Faculty of Communication Studies', 65, ''),
(15, 4, 'Faculty of Science', 60, ''),
(16, 4, 'Bachelor of Managment program ', 65, ''),
(17, 4, 'Bachelor of Arts program ', 60, ''),
(18, 4, 'Bachelor of Management & Bachelor of Science in Chemistry Dual Degrees', 65, ''),
(20, 3, '3-year B.A Biology', 60, ''),
(21, 3, '3-year B.A Chemistry', 60, ''),
(22, 3, '4-year B.A Psychology', 60, ''),
(23, 3, '4-year B.A Environmental Studies', 60, ''),
(24, 3, '4-year B.A Environmental Studies Chemistry', 60, ''),
(25, 3, '4-year B.A Politics-History-Economics', 60, ''),
(26, 3, '3-year B.Sc Biology', 60, ''),
(27, 3, '3-year B.Sc Chemistry', 60, ''),
(28, 3, '4-year B.Sc Computing Science', 60, ''),
(29, 3, '4-year B.Sc Environmental Studies Biology', 60, ''),
(30, 3, '4-year Environmental Studies Chemistry', 60, ''),
(31, 3, '4-year B.Sc. Environmental Studies Computing Science', 60, ''),
(32, 3, '4-year B.Com', 60, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `group`
--

CREATE TABLE `group` (
  `course_id` int(21) DEFAULT NULL,
  `institution_id` int(21) DEFAULT NULL,
  `group` varchar(24) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `group`
--

INSERT INTO `group` (`course_id`, `institution_id`, `group`) VALUES
(1, 1, 'E'),
(2, 1, 'F'),
(3, 1, 'G'),
(4, 1, 'G'),
(5, 1, 'G'),
(6, 1, 'G'),
(7, 1, 'G'),
(8, 1, 'G'),
(9, 1, 'G'),
(10, 1, 'A'),
(11, 1, 'A'),
(12, 1, 'A'),
(13, 1, 'A'),
(14, 1, 'A'),
(15, 1, 'A'),
(16, 1, 'A'),
(17, 1, 'A'),
(18, 1, 'A'),
(19, 1, 'A'),
(20, 1, 'A'),
(21, 1, 'A'),
(22, 1, 'A'),
(23, 1, 'A'),
(24, 1, 'A'),
(25, 1, 'A'),
(26, 1, 'A'),
(27, 1, 'A'),
(28, 1, 'A'),
(29, 1, 'A'),
(30, 1, 'A'),
(31, 1, 'A'),
(32, 1, 'A'),
(33, 1, 'A'),
(34, 1, 'A'),
(35, 1, 'A'),
(36, 1, 'A'),
(37, 1, 'A'),
(38, 1, 'A'),
(39, 1, 'A'),
(40, 1, 'A'),
(41, 1, 'A'),
(42, 1, 'A'),
(43, 1, 'A'),
(44, 1, 'A'),
(45, 1, 'A'),
(46, 1, 'B'),
(47, 1, 'B'),
(48, 1, 'C'),
(49, 1, 'C'),
(50, 1, 'C'),
(51, 1, 'C'),
(52, 1, 'C'),
(53, 1, 'C'),
(54, 1, 'C'),
(55, 1, 'C'),
(56, 1, 'C'),
(57, 1, 'C'),
(58, 1, 'C'),
(59, 1, 'C'),
(60, 1, 'C'),
(61, 1, 'C'),
(62, 1, 'C'),
(63, 1, 'C'),
(64, 1, 'C'),
(65, 1, 'C'),
(66, 1, 'C'),
(67, 1, 'C'),
(68, 1, 'C'),
(69, 1, 'C'),
(70, 1, 'C'),
(71, 1, 'C'),
(72, 1, 'C'),
(73, 1, 'C'),
(74, 1, 'C'),
(75, 1, 'C'),
(76, 1, 'C'),
(77, 1, 'C'),
(78, 1, 'C'),
(79, 1, 'C'),
(80, 1, 'C'),
(81, 1, 'C'),
(82, 1, 'C'),
(83, 1, 'C'),
(84, 1, 'C'),
(85, 1, 'C'),
(86, 1, 'C'),
(87, 1, 'C'),
(88, 1, 'C'),
(89, 1, 'C'),
(90, 1, 'C'),
(91, 1, 'C'),
(92, 1, 'C'),
(93, 1, 'C'),
(94, 1, 'C'),
(95, 1, 'C'),
(96, 1, 'C'),
(97, 1, 'C'),
(98, 1, 'C'),
(99, 1, 'C'),
(100, 1, 'C'),
(101, 1, 'C'),
(102, 1, 'C'),
(103, 1, 'C'),
(104, 1, 'C'),
(105, 1, 'C'),
(106, 1, 'C'),
(107, 1, 'C'),
(108, 1, 'C'),
(109, 1, 'D'),
(2, 1, 'D'),
(3, 1, 'D'),
(4, 1, 'D'),
(5, 1, 'D'),
(6, 1, 'D'),
(7, 1, 'D'),
(8, 1, 'D'),
(9, 1, 'D'),
(7, 1, 'H'),
(8, 1, 'H'),
(9, 1, 'I'),
(6, 1, 'J'),
(3, 1, 'K'),
(9, 1, 'L'),
(109, 1, 'L'),
(110, 1, 'M'),
(111, 1, 'N'),
(117, 1, 'O'),
(112, 1, 'P'),
(113, 1, 'P'),
(114, 1, 'P'),
(115, 1, 'P'),
(116, 1, 'P'),
(118, 1, 'Q'),
(151, 1, 'Q'),
(48, 2, 'A'),
(49, 2, 'A'),
(50, 2, 'A'),
(51, 2, 'A'),
(52, 2, 'A'),
(53, 2, 'A'),
(54, 2, 'A'),
(55, 2, 'A'),
(56, 2, 'A'),
(57, 2, 'A'),
(58, 2, 'A'),
(59, 2, 'A'),
(60, 2, 'A'),
(61, 2, 'A'),
(62, 2, 'A'),
(63, 2, 'A'),
(64, 2, 'A'),
(65, 2, 'A'),
(66, 2, 'A'),
(67, 2, 'A'),
(68, 2, 'A'),
(69, 2, 'A'),
(70, 2, 'A'),
(71, 2, 'A'),
(72, 2, 'A'),
(73, 2, 'A'),
(74, 2, 'A'),
(75, 2, 'A'),
(76, 2, 'A'),
(77, 2, 'A'),
(78, 2, 'A'),
(79, 2, 'A'),
(80, 2, 'A'),
(81, 2, 'A'),
(82, 2, 'A'),
(83, 2, 'A'),
(84, 2, 'A'),
(85, 2, 'A'),
(86, 2, 'A'),
(87, 2, 'A'),
(88, 2, 'A'),
(89, 2, 'A'),
(90, 2, 'A'),
(91, 2, 'A'),
(92, 2, 'A'),
(93, 2, 'A'),
(94, 2, 'A'),
(95, 2, 'A'),
(96, 2, 'A'),
(97, 2, 'A'),
(98, 2, 'A'),
(99, 2, 'A'),
(100, 2, 'A'),
(101, 2, 'A'),
(102, 2, 'A'),
(103, 2, 'A'),
(104, 2, 'A'),
(105, 2, 'A'),
(106, 2, 'A'),
(107, 2, 'A'),
(108, 2, 'A'),
(42, 2, 'B'),
(43, 2, 'B'),
(35, 2, 'B'),
(10, 2, 'B'),
(38, 2, 'B'),
(39, 2, 'B'),
(44, 2, 'B'),
(45, 2, 'B'),
(41, 2, 'B'),
(18, 2, 'B'),
(37, 2, 'B'),
(2, 2, 'C'),
(3, 2, 'C'),
(5, 2, 'C'),
(6, 2, 'C'),
(8, 2, 'C'),
(9, 2, 'C'),
(109, 2, 'C'),
(110, 2, 'C'),
(111, 2, 'D'),
(112, 2, 'D'),
(113, 2, 'D'),
(114, 2, 'D'),
(115, 2, 'D'),
(116, 2, 'D'),
(117, 2, 'D'),
(118, 2, 'D'),
(119, 2, 'D'),
(120, 2, 'D'),
(121, 2, 'D'),
(122, 2, 'D'),
(123, 2, 'D'),
(124, 2, 'D'),
(125, 2, 'D'),
(126, 2, 'D'),
(127, 2, 'D'),
(128, 2, 'D'),
(129, 2, 'D'),
(130, 2, 'D'),
(131, 2, 'D'),
(132, 2, 'D'),
(133, 2, 'D'),
(134, 2, 'D'),
(135, 2, 'D'),
(136, 2, 'D'),
(137, 2, 'D'),
(138, 2, 'D'),
(139, 2, 'D'),
(140, 2, 'D'),
(141, 2, 'D'),
(142, 2, 'D'),
(143, 2, 'D'),
(144, 2, 'D'),
(145, 2, 'D'),
(146, 2, 'D'),
(147, 2, 'D'),
(148, 2, 'D'),
(149, 2, 'D'),
(150, 2, 'D'),
(151, 2, 'D'),
(152, 2, 'D'),
(1, 2, 'E'),
(2, 2, 'F'),
(110, 2, 'F'),
(3, 2, 'G'),
(9, 2, 'H'),
(109, 2, 'H'),
(2, 2, 'I'),
(6, 2, 'I'),
(110, 2, 'I'),
(2, 2, 'J'),
(3, 2, 'K'),
(5, 2, 'K'),
(6, 2, 'K'),
(8, 2, 'K'),
(9, 2, 'K'),
(6, 2, 'L'),
(9, 2, 'M'),
(8, 2, 'N'),
(3, 3, 'A'),
(9, 3, 'A'),
(9, 3, 'B'),
(2, 3, 'B'),
(2, 3, 'C'),
(2, 3, 'D'),
(3, 3, 'D'),
(3, 3, 'E'),
(9, 3, 'E'),
(2, 3, 'E'),
(3, 3, 'F'),
(9, 3, 'F'),
(2, 3, 'F'),
(NULL, 3, 'G'),
(9, 3, 'I'),
(2, 3, 'I'),
(8, 3, 'I'),
(2, 3, 'K'),
(2, 3, 'L'),
(9, 3, 'L'),
(2, 3, 'L'),
(47, 4, 'A'),
(46, 4, 'A'),
(3, 4, 'G'),
(8, 4, 'G'),
(9, 4, 'G'),
(49, 4, 'A'),
(50, 4, 'A'),
(51, 4, 'A'),
(52, 4, 'A'),
(53, 4, 'A'),
(54, 4, 'A'),
(55, 4, 'A'),
(56, 4, 'A'),
(57, 4, 'A'),
(58, 4, 'A'),
(59, 4, 'A'),
(60, 4, 'A'),
(61, 4, 'A'),
(62, 4, 'A'),
(63, 4, 'A'),
(64, 4, 'A'),
(65, 4, 'A'),
(66, 4, 'A'),
(67, 4, 'A'),
(68, 4, 'A'),
(69, 4, 'A'),
(70, 4, 'A'),
(71, 4, 'A'),
(72, 4, 'A'),
(73, 4, 'A'),
(74, 4, 'A'),
(75, 4, 'A'),
(76, 4, 'A'),
(77, 4, 'A'),
(78, 4, 'A'),
(79, 4, 'A'),
(80, 4, 'A'),
(81, 4, 'A'),
(82, 4, 'A'),
(83, 4, 'A'),
(84, 4, 'A'),
(18, 4, 'B'),
(39, 4, 'B'),
(42, 4, 'B'),
(43, 4, 'B'),
(38, 4, 'B'),
(45, 4, 'B'),
(37, 4, 'B'),
(10, 4, 'B'),
(35, 4, 'B'),
(44, 4, 'B'),
(110, 4, 'C'),
(2, 4, 'C'),
(6, 4, 'C'),
(3, 4, 'C'),
(9, 4, 'C'),
(4, 4, 'C'),
(5, 4, 'C'),
(8, 4, 'C'),
(109, 4, 'C'),
(119, 4, 'D'),
(121, 4, 'D'),
(122, 4, 'D'),
(123, 4, 'D'),
(111, 4, 'D'),
(117, 4, 'D'),
(127, 4, 'D'),
(114, 4, 'D'),
(112, 4, 'D'),
(146, 4, 'D');

-- --------------------------------------------------------

--
-- Table structure for table `institution`
--

CREATE TABLE `institution` (
  `id` int(21) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `city` varchar(40) DEFAULT NULL,
  `province` varchar(10) DEFAULT NULL,
  `country` varchar(80) DEFAULT NULL,
  `pc_zip` varchar(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `institution`
--

INSERT INTO `institution` (`id`, `name`, `city`, `province`, `country`, `pc_zip`, `type`, `description`) VALUES
(1, 'University of Alberta', 'Edmonton', 'AB', 'Canada', 'T6G 2R3', 'University', ''),
(2, 'Macewan University ', 'Edmonton', 'AB', 'Canada', 'T5J 4S2', 'University', ''),
(3, 'Kings University', 'Edmonton', 'AB', 'Canada', 'T6B 2H3', 'University', ''),
(4, 'Concordia', 'Edmonton', 'AB', 'Canada', 'T5B 4E4', 'University', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `linked_condition`
--

CREATE TABLE `linked_condition` (
  `id` int(21) NOT NULL,
  `condition_id` int(21) NOT NULL,
  `condition_group` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `linked_condition`
--

INSERT INTO `linked_condition` (`id`, `condition_id`, `condition_group`) VALUES
(1, 7, 'A'),
(2, 7, 'B'),
(3, 7, 'C'),
(4, 7, 'D'),
(5, 7, 'M'),
(6, 5, 'A'),
(7, 5, 'B'),
(8, 5, 'C'),
(9, 5, 'D'),
(10, 8, 'A'),
(11, 8, 'B'),
(12, 8, 'C'),
(13, 8, 'D'),
(14, 8, 'M'),
(15, 9, 'B'),
(16, 9, 'C'),
(17, 9, 'D'),
(18, 9, 'M'),
(19, 10, 'B'),
(20, 10, 'C'),
(21, 10, 'D'),
(22, 10, 'M'),
(23, 17, 'A'),
(24, 17, 'B'),
(25, 17, 'C'),
(26, 17, 'D'),
(27, 20, 'F'),
(28, 20, 'J'),
(29, 20, 'M'),
(30, 25, 'A'),
(31, 25, 'B'),
(32, 25, 'C'),
(33, 25, 'D'),
(34, 25, 'M'),
(35, 29, 'Q'),
(36, 29, 'K'),
(37, 33, 'A'),
(38, 33, 'B'),
(39, 33, 'C'),
(40, 33, 'D'),
(41, 34, 'A'),
(42, 34, 'B'),
(43, 34, 'C'),
(44, 34, 'D'),
(45, 35, 'A'),
(46, 35, 'B'),
(47, 35, 'C'),
(48, 35, 'D'),
(49, 40, 'A'),
(50, 40, 'B'),
(51, 40, 'C'),
(52, 40, 'D'),
(53, 45, 'A'),
(54, 45, 'B'),
(55, 45, 'C'),
(56, 45, 'D'),
(57, 47, 'A'),
(58, 47, 'B'),
(59, 47, 'C'),
(60, 47, 'D'),
(61, 48, 'A'),
(62, 48, 'B'),
(63, 48, 'C'),
(64, 48, 'D'),
(65, 49, 'A'),
(66, 49, 'B'),
(67, 49, 'C'),
(68, 49, 'D'),
(69, 50, 'A'),
(70, 50, 'B'),
(71, 50, 'C'),
(72, 50, 'D'),
(73, 58, 'B'),
(74, 58, 'C'),
(75, 59, 'C'),
(76, 59, 'D'),
(77, 61, 'A'),
(78, 61, 'B'),
(79, 61, 'C'),
(80, 61, 'D'),
(81, 62, 'A'),
(82, 62, 'B'),
(83, 62, 'C'),
(84, 62, 'D'),
(85, 63, 'A'),
(86, 63, 'B'),
(87, 63, 'C'),
(88, 63, 'D'),
(89, 64, 'A'),
(90, 64, 'B'),
(91, 64, 'C'),
(92, 64, 'D'),
(93, 67, 'B'),
(94, 67, 'A'),
(95, 67, 'C'),
(96, 68, 'B'),
(97, 68, 'A'),
(98, 68, 'C'),
(99, 69, 'A'),
(100, 69, 'C'),
(101, 70, 'B'),
(102, 70, 'A'),
(103, 70, 'C'),
(104, 73, 'A'),
(105, 73, 'B'),
(106, 73, 'C'),
(107, 74, 'A'),
(108, 74, 'B'),
(109, 74, 'C'),
(110, 75, 'A'),
(111, 75, 'C'),
(112, 75, 'D'),
(113, 77, 'A'),
(114, 77, 'B'),
(115, 77, 'C'),
(116, 78, 'A'),
(117, 78, 'B'),
(118, 78, 'C'),
(119, 79, 'A'),
(120, 79, 'C'),
(121, 80, 'A'),
(122, 80, 'B'),
(123, 80, 'C'),
(124, 80, 'D'),
(125, 85, 'A'),
(126, 85, 'B'),
(127, 85, 'C'),
(128, 85, 'D'),
(129, 1, 'E'),
(130, 2, 'F'),
(131, 6, 'E'),
(132, 11, 'E'),
(133, 12, 'F'),
(134, 13, 'H'),
(135, 14, 'I'),
(136, 15, 'J'),
(137, 16, 'E'),
(138, 18, 'K'),
(139, 19, 'L'),
(140, 21, 'E'),
(141, 22, 'F'),
(142, 23, 'K'),
(143, 24, 'L'),
(144, 26, 'E'),
(145, 27, 'F'),
(146, 28, 'H'),
(147, 30, 'I'),
(148, 31, 'E'),
(149, 32, 'F'),
(150, 36, 'E'),
(151, 37, 'G'),
(152, 38, 'H'),
(153, 39, 'I'),
(154, 41, 'E'),
(155, 42, 'J'),
(156, 43, 'K'),
(157, 44, 'K'),
(158, 46, 'E'),
(159, 51, 'E'),
(160, 52, 'F'),
(161, 53, 'L'),
(162, 54, 'M'),
(163, 55, 'N'),
(164, 56, 'E'),
(165, 57, 'A'),
(166, 60, 'E'),
(167, 66, 'E'),
(168, 71, 'E'),
(169, 72, 'F'),
(170, 76, 'E'),
(171, 81, 'E'),
(172, 82, 'F'),
(173, 83, 'G'),
(174, 84, 'G'),
(175, 86, 'A'),
(176, 87, 'B'),
(177, 88, 'C'),
(178, 89, 'D'),
(179, 90, 'E'),
(180, 91, 'F'),
(181, 92, 'G'),
(182, 93, 'H'),
(183, 94, 'I'),
(184, 95, 'C'),
(185, 96, 'E'),
(186, 97, 'K'),
(187, 98, 'C');

-- --------------------------------------------------------

--
-- Table structure for table `major`
--

CREATE TABLE `major` (
  `id` int(21) NOT NULL,
  `department_id` int(21) DEFAULT NULL,
  `institution_id` int(21) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `major`
--

INSERT INTO `major` (`id`, `department_id`, `institution_id`, `name`, `description`) VALUES
(1, 1, 1, 'Applied Mathematics', ''),
(2, 1, 1, 'Astrophysics', ''),
(3, 1, 1, 'Atmospheric Science', ''),
(4, 1, 1, 'Biochemistry', ''),
(5, 1, 1, 'Biological Science', ''),
(6, 1, 1, 'Biology', ''),
(7, 1, 1, 'Cell Biology', ''),
(8, 1, 1, 'Chemistry', ''),
(9, 1, 1, 'Computing Science', ''),
(10, 1, 1, 'Earth and Atmospheric Science', ''),
(11, 1, 1, '\"Ecology', 'Evolution and Environmental Biology\"'),
(12, 1, 1, 'Environmental Earth Science', ''),
(13, 1, 1, 'Geology', ''),
(14, 1, 1, 'Geophysics', ''),
(15, 1, 1, 'Immunology and Infection', ''),
(16, 1, 1, 'Integrative Physiology', ''),
(17, 1, 1, 'Mathematical Physics', ''),
(18, 1, 1, 'Mathematics', ''),
(19, 1, 1, '\"Molecular', 'Cellular and Developmental Biology\"'),
(20, 1, 1, 'Neuroscience', ''),
(21, 1, 1, 'Paleontology', ''),
(22, 1, 1, 'Pharmacology', ''),
(23, 1, 1, 'Physical Science', ''),
(24, 1, 1, 'Physics', ''),
(25, 1, 1, 'Physiology', ''),
(26, 1, 1, 'Planning', ''),
(27, 1, 1, 'Psychology', ''),
(28, 1, 1, 'Science and Education', ''),
(29, 1, 1, 'Statistics', ''),
(30, 1, 1, 'Undeclared', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE `profile` (
  `id` int(21) NOT NULL,
  `first_name` varchar(40) DEFAULT NULL,
  `last_name` varchar(40) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `city` varchar(40) DEFAULT NULL,
  `province` varchar(10) DEFAULT NULL,
  `country` varchar(10) DEFAULT NULL,
  `pc_zip` varchar(10) DEFAULT NULL,
  `international` int(1) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `highest_education` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profile`
--
-- --------------------------------------------------------

--
-- Table structure for table `profile_marks`
--

CREATE TABLE `profile_marks` (
  `student_id` int(21) DEFAULT NULL,
  `course_id` int(21) DEFAULT NULL,
  `mark` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profile_marks`
--

--
-- Indexes for dumped tables
--

--
-- Indexes for table `condition`
--
ALTER TABLE `condition`
  ADD PRIMARY KEY (`id`),
  ADD KEY `institution_id` (`institution_id`),
  ADD KEY `department_id` (`department_id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`),
  ADD KEY `institution_id` (`institution_id`);

--
-- Indexes for table `group`
--
ALTER TABLE `group`
  ADD KEY `course_id` (`course_id`),
  ADD KEY `institution_id` (`institution_id`);

--
-- Indexes for table `institution`
--
ALTER TABLE `institution`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `linked_condition`
--
ALTER TABLE `linked_condition`
  ADD PRIMARY KEY (`id`),
  ADD KEY `condition_id` (`condition_id`);

--
-- Indexes for table `major`
--
ALTER TABLE `major`
  ADD PRIMARY KEY (`id`),
  ADD KEY `department_id` (`department_id`),
  ADD KEY `institution_id` (`institution_id`);

--
-- Indexes for table `profile`
--
ALTER TABLE `profile`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `profile_marks`
--
ALTER TABLE `profile_marks`
  ADD KEY `student_id` (`student_id`),
  ADD KEY `course_id` (`course_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `condition`
--
ALTER TABLE `condition`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=99;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=153;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `institution`
--
ALTER TABLE `institution`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `linked_condition`
--
ALTER TABLE `linked_condition`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=188;

--
-- AUTO_INCREMENT for table `major`
--
ALTER TABLE `major`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `profile`
--
ALTER TABLE `profile`
  MODIFY `id` int(21) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `condition`
--
ALTER TABLE `condition`
  ADD CONSTRAINT `condition_ibfk_1` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`),
  ADD CONSTRAINT `condition_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`);

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`);

--
-- Constraints for table `group`
--
ALTER TABLE `group`
  ADD CONSTRAINT `group_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  ADD CONSTRAINT `group_ibfk_2` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`);

--
-- Constraints for table `linked_condition`
--
ALTER TABLE `linked_condition`
  ADD CONSTRAINT `linked_condition_ibfk_1` FOREIGN KEY (`condition_id`) REFERENCES `condition` (`id`);

--
-- Constraints for table `major`
--
ALTER TABLE `major`
  ADD CONSTRAINT `major_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  ADD CONSTRAINT `major_ibfk_2` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`);

--
-- Constraints for table `profile_marks`
--
ALTER TABLE `profile_marks`
  ADD CONSTRAINT `profile_marks_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `profile` (`id`),
  ADD CONSTRAINT `profile_marks_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `group` (`course_id`);
