# inleksys_server
1)Скачать проект с github
2)Открыть папку backend через IDE-например Eclipse,idea
3)В модуле database в папке resourse в файлах database.properties и flyway.properties поменять  url,login,password, по умолчанию: jdbc:postgresql://localhost:5433/postgres,postgres,postgres.((Работает с postgrest версии ниже 11,обусловлено flyway))
4)Открыть терминал зайти в папку database написать mvn flyway:migrate
5)Перейти в папку controllers,в папке java/all/controller запустить класс AppInit
ДЛЯ СБОРКИ В JAR И ОТКРЫТИЯ БЕЗ IDE:
Выполнить пункты 1 и 3 из списка выше.Через maven выполнить пункт 4,после чего перейти в папку controllers и выполнить mvn clean install.
В папке target данного модуля появится controllers-2.0.5.RELEASE.jar.Выполнить java -jar controllers-2.0.5.RELEASE.jar.
