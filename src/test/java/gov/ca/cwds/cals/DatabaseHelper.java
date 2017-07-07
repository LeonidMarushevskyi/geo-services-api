package gov.ca.cwds.cals;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author CWDS CALS API Team
 */
public class DatabaseHelper {
    public Database database;
    private String url;
    private String user;
    private String password;

    public DatabaseHelper(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void runScript(String script) throws Exception {
        new Liquibase(script, new ClassLoaderResourceAccessor(), getDatabase()).update((String) null);
    }

    public void runScript(String script, String schema) throws Exception {
        String defaultSchema = getDatabase().getDefaultSchemaName();
        getDatabase().setDefaultSchemaName(schema);

        runScript(script);

        getDatabase().setDefaultSchemaName(defaultSchema);
    }

    private Database getDatabase() throws Exception {
        if (database == null) {
            Connection connection = DriverManager.getConnection(url, user, password);
            database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
        }

        return database;
    }
}
