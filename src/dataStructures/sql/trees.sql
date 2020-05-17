-- рекурсивный запрос это нерекурсивная база + рекурсивная часть
WITH RECURSIVE Fibonacci AS (
    SELECT 1 AS ord,
           1 AS value,
           1 AS next_value

           -- объединение с рекурсивной частью
    UNION ALL

    -- при этом есть некая рабочая таблица, в которую
    -- записывается результат итерации (1, 1, 1)
    SELECT ord + 1 AS value,
           next_value,
           value + next_value
           -- использование результата предыдущей итерации
    FROM Fibonacci
    WHERE ord < 10
)

-- итерация заканчивается, когда рекурсивная часть пустая
SELECT *
FROM Fibonacci;


-- деревья списками смежности
CREATE TABLE Vertex
(
    id        INT PRIMARY KEY,
    value     TEXT,
    parent_id INT REFERENCES Vertex
);

WITH RECURSIVE Bfs AS (
    SELECT V.id        AS vertex_id,
           V.parent_id AS parent_id,
           V.value,
           0           AS level
    FROM Vertex V
    WHERE id = 42

    UNION ALL

    SELECT V.id          AS vertex_id,
           V.parent_id   AS parent_id,
           V.value,
           Bfs.level + 1 AS level
    FROM Vertex V
             JOIN Bfs ON V.parent_id = Bfs.vertex_id
)

SELECT *
FROM Bfs;

-- структурные метки (materialized path) => каждая вершина имеет метку,
-- в вершину записывается путь по меткам до этой вершины [1, 2, 5] или "1.2.5"
-- или "1.1.2" (когда детей вершины нумеруем от 1 слева направо)

-- деревья структурными метками:
-- расширение ltree позволяет круто работать со структурными метками
CREATE TABLE Vertex
(
    id    INT PRIMARY KEY,
    value TEXT,
    path  INT[]
);

CEREATE OR REPLACE FUNCTION IsPrefix(prefix INT[], arr INT[]) RETURNS BOOLEAN AS $$
	DECLARE len_prefix INT;
	BEGIN
		IF prefix > arr THEN
			RETURN FALSE
		END IF;

		len_prefix = array_length(prefix, 1)
		RETURN prefix = arr[1:len_prefix]
	END
$$ LANGUAGE plpgsql;

SELECT *
FROM Vertex
WHERE IsPrefix((SELECT path FROM Vertex WHERE id = 42), path);


-- вложенные множества: вершине приписываем два числа
-- первое при заходе в неё, второе при окончании обхода всех её потомков
-- проверка на потомка - сравнение отрезков
CREATE TABLE Vertex
(
    id    INT PRIMARY KEY,
    value TEXT,
    left  INT,
    right INT,
    CHECK (left < right)
);

SELECT Child.*
FROM Vertex Child
         JOIN Vertex Parent ON Child.left BETWEEN Parent.left AND Parent.right
WHERE Parent.id = 42;

-- получение таблицы вершина - список всех дочерних вершин
SELECT k.id, array_agg(kw.id)
FROM keyword k
         LEFT JOIN keyword kw ON k.id = kw.parent_id
GROUP BY k.id;

-- получение вершины, длины пути до вершины и самого пути
WITH RECURSIVE keyword_level AS (
    SELECT id,
           1         AS path_size,
           ARRAY [0] AS root_path
    FROM keyword k
    WHERE id = 0

    UNION ALL

    SELECT k.id,
           kl.path_size + 1,
           array_append(kl.root_path, k.id)
    FROM keyword k
             JOIN keyword_level kl ON k.parent_id = kl.id
)

SELECT *
FROM keyword_level
ORDER BY id;

-- получение вершины и количества детей
WITH RECURSIVE keyword_level AS (
    SELECT id AS parent_id,
           id
    FROM keyword k

    UNION ALL

    SELECT kl.parent_id,
           k.id
    FROM keyword k
             JOIN keyword_level kl ON k.parent_id = kl.id
)

SELECT '#'       AS foo,
       parent_id AS id,
       count(*)
FROM keyword_level
GROUP BY parent_id
ORDER BY parent_id;
