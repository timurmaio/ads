--------------------------------------------------
-- most slowest queries
--------------------------------------------------
SELECT round(mean_time) as mean_time_ms,
       calls,
       left(query, 130)
FROM pg_stat_statements
ORDER BY 1 DESC, 2 DESC;


--------------------------------------------------
-- total table size (index + table)
--------------------------------------------------
SELECT concat(n.nspname, '.', c.relname)             AS relation,
       pg_size_pretty(pg_total_relation_size(c.oid)) AS total_size
FROM pg_class c
         LEFT JOIN pg_namespace n ON n.oid = c.relnamespace
WHERE c.relkind = 'r'
  AND n.nspname NOT IN ('pg_catalog', 'information_schema')
ORDER BY pg_total_relation_size(c.oid) DESC;


--------------------------------------------------
-- index scans by table
--------------------------------------------------
SELECT concat(t.schemaname, '.', t.tablename) AS relation,
       ic.relname                             AS indexname,
       i.indisunique                          AS unique,
       psai.idx_scan                          AS scans,
       round(c.reltuples)                     AS tuples
FROM pg_tables t
         LEFT OUTER JOIN pg_class c ON t.tablename = c.relname
         LEFT OUTER JOIN pg_index i ON c.oid = i.indrelid
         LEFT OUTER JOIN pg_stat_all_indexes psai ON i.indexrelid = psai.indexrelid
         LEFT OUTER JOIN pg_class ic ON ic.oid = i.indexrelid
WHERE t.schemaname NOT IN ('pg_catalog', 'information_schema')
ORDER BY 1, 2;
