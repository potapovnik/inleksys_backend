# inleksys_server
+ Реализована серверная часть,проблем не обнаружено.
Можно доделать,если критично:
-Не получилось реализовать упаковку в jar файл.

Запуск:(Работает с postgrest версии ниже 11,обусловлено flyway)
Скачать,поменять в модуле database-database.properties url,login,password, по умолчанию jdbc:postgresql://localhost:5433/postgres,postgres,postgres.
В модуле database применить flyway:migrate.
