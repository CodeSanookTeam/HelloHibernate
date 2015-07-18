import groovy.sql.Sql

class SqlServerQuery {

    def void query() {

        def configuration = [
                'dbInstance': "localhost\\SQLEXPRESS",
                'dbPort'    : 1433,
                'dbName'    : "TestDb",
                'dbUser'    : "sa",
                'dbPass'    : "44jkw\$"
        ]

        def sql = Sql.newInstance("jdbc:sqlserver://${configuration.dbInstance}:${configuration.dbPort};" +
                "databaseName=${configuration.dbName}", configuration.dbUser, configuration.dbPass,
                'com.microsoft.sqlserver.jdbc.SQLServerDriver')

        println "current database name ${configuration.dbName}"

       def result = sql.firstRow("SELECT COUNT(Id) AS userCount FROM dbo.[User]")
       assert result.userCount == 1
    }

}
