# inleksys_server
1)Скачать проект с гитхаюба
2)Открыть папку backend через IDE-например Eclipse,idea
3)В модуле database в папке resourse в файлах database.properties и flyway.properties поменять  url,login,password, по умолчанию: jdbc:postgresql://localhost:5433/postgres,postgres,postgres.((Работает с postgrest версии ниже 11,обусловлено flyway))
4)Открыть терминал зайти в папку database написать mvn flyway:migrate
5)Перейти в папку controllers,в папке java/all/controller запустить класс AppInit
