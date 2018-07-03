-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:2016
-- Время создания: Июл 01 2018 г., 17:59
-- Версия сервера: 10.1.10-MariaDB
-- Версия PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `obmetko`
--

-- --------------------------------------------------------

--
-- Структура таблицы `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `author` varchar(200) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `Category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `books`
--

INSERT INTO `books` (`id`, `name`, `author`, `price`, `Category_id`) VALUES
(1, 'Ведьмак', 'Анджей Сапковский', 100, 1),
(2, 'Java для начинающих. Объектно-ориентированный подход', 'Барт Бэзинс', 55, 2),
(3, 'Тор. Бог грома', 'Джейсон Аарон', 49, 3),
(4, 'Волчица и пряности. Том 1', 'Исуна Хасэкура', 200, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `login` varchar(4000) DEFAULT NULL,
  `password` varchar(4000) DEFAULT NULL,
  `email` varchar(4000) DEFAULT NULL,
  `Roles_id` int(11) NOT NULL DEFAULT '2'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `login`, `password`, `email`, `Roles_id`) VALUES
(1, 'admin', 'admin', 'admin@tut.by', 1),
(2, 'user', 'user', 'user@tut.by', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `catalog`
--

CREATE TABLE `catalog` (
  `id` int(11) NOT NULL,
  `catalogName` varchar(4000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `catalog`
--

INSERT INTO `catalog` (`id`, `catalogName`) VALUES
(1, 'каталог книг'),
(2, 'каталог манги и комиксов');

-- --------------------------------------------------------

--
-- Структура таблицы `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `CategoryName` varchar(100) DEFAULT NULL,
  `Catalog_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `category`
--

INSERT INTO `category` (`id`, `CategoryName`, `Catalog_id`) VALUES
(1, 'программирование', 1),
(2, 'художественная', 1),
(3, 'комиксы', 2),
(4, 'манга', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `list of purchases`
--

CREATE TABLE `list of purchases` (
  `id` int(11) NOT NULL,
  `Users_id` int(11) NOT NULL,
  `Books_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `list of purchases`
--

INSERT INTO `list of purchases` (`id`, `Users_id`, `Books_id`) VALUES
(1, 1, 3),
(2, 2, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `role` varchar(405) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`id`, `role`) VALUES
(1, 'admin'),
(2, 'Buyer');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Books_Category1_idx` (`Category_id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Users_Roles1_idx` (`Roles_id`);

--
-- Индексы таблицы `catalog`
--
ALTER TABLE `catalog`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Category_Catalog2_idx` (`Catalog_id`);

--
-- Индексы таблицы `list of purchases`
--
ALTER TABLE `list of purchases`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_List of purchases_Users2_idx` (`Users_id`),
  ADD KEY `fk_List of purchases_Books1_idx` (`Books_id`);

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `catalog`
--
ALTER TABLE `catalog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `list of purchases`
--
ALTER TABLE `list of purchases`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `books`
--
ALTER TABLE `books`
  ADD CONSTRAINT `fk_Books_Category1` FOREIGN KEY (`Category_id`) REFERENCES `category` (`id`);

--
-- Ограничения внешнего ключа таблицы `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_Users_Roles` FOREIGN KEY (`Roles_id`) REFERENCES `roles` (`id`);

--
-- Ограничения внешнего ключа таблицы `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `fk_Category_Catalog2` FOREIGN KEY (`Catalog_id`) REFERENCES `catalog` (`id`);

--
-- Ограничения внешнего ключа таблицы `list of purchases`
--
ALTER TABLE `list of purchases`
  ADD CONSTRAINT `fk_List of purchases_Books1` FOREIGN KEY (`Books_id`) REFERENCES `books` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_List of purchases_Users2` FOREIGN KEY (`Users_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
