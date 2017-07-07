package gov.ca.cwds.geo.health;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.db.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author CWDS TPT2 Team
 */

public class DataSourceHealthCheck extends HealthCheck {

    private static final Logger LOG = LoggerFactory.getLogger(DataSourceHealthCheck.class);

    private final DataSourceFactory dataSourceFactory;

    public DataSourceHealthCheck(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

    @Override
    protected Result check() throws Exception {
        String url = dataSourceFactory.getUrl();
        String user = dataSourceFactory.getUser();
        String password = dataSourceFactory.getPassword();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            return Result.healthy();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            return HealthCheck.Result.unhealthy(e.getMessage());
        }

    }
}