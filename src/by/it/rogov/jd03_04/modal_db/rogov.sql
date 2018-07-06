-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:2016
-- Время создания: Июл 06 2018 г., 01:01
-- Версия сервера: 10.1.10-MariaDB
-- Версия PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `rogov`
--

-- --------------------------------------------------------

--
-- Структура таблицы `labrary`
--

CREATE TABLE `labrary` (
  `ID` int(11) NOT NULL,
  `textFree` varchar(10000) DEFAULT NULL,
  `textPay` varchar(10000) DEFAULT NULL,
  `users_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `labrary`
--

INSERT INTO `labrary` (`ID`, `textFree`, `textPay`, `users_ID`) VALUES
(16, 'СПОРТИВНОЕ ПИТАНИЕ: ПРОТЕИН', 'Протеиновые продукты – это продукты с высоким содержанием белка и почти нулевым содержанием углеводов. Белок – основной строитель и защитник мышечной ткани. Так, если Вы наращиваете мышцы, без белка они просто не будут расти. При похудении организм также может терять мышечную ткань вместо жира, и именно белок сможет гарантировать Вам, что жир уйдет, а мышцы останутся.', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `permission`
--

CREATE TABLE `permission` (
  `ID` int(11) NOT NULL,
  `pemissionAccess` int(11) DEFAULT NULL,
  `users_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `permission`
--

INSERT INTO `permission` (`ID`, `pemissionAccess`, `users_ID`) VALUES
(7, 1, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `ID` int(11) NOT NULL,
  `role` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`ID`, `role`) VALUES
(1, 'Administator'),
(2, 'User'),
(3, 'Guest');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `roles_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`ID`, `login`, `password`, `email`, `roles_ID`) VALUES
(1, 'admin', 'pasadmin', 'admin@mail@ru', 1),
(2, 'testLogin', 'testPassword', 'testEmail@email.com', 2),
(3, 'testLogin2', 'testPassword', 'testEmail2@email.com', 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `labrary`
--
ALTER TABLE `labrary`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_labrary_users1_idx` (`users_ID`);

--
-- Индексы таблицы `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_permission_users1_idx` (`users_ID`);

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_users_roles1_idx` (`roles_ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `labrary`
--
ALTER TABLE `labrary`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT для таблицы `permission`
--
ALTER TABLE `permission`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT для таблицы `roles`
--
ALTER TABLE `roles`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `labrary`
--
ALTER TABLE `labrary`
  ADD CONSTRAINT `fk_labrary_users1` FOREIGN KEY (`users_ID`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `permission`
--
ALTER TABLE `permission`
  ADD CONSTRAINT `fk_permission_users1` FOREIGN KEY (`users_ID`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_users_roles1` FOREIGN KEY (`roles_ID`) REFERENCES `roles` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
