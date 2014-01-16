package io.kazuki.v0.store.jdbi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JdbiDataSourceConfiguration {
  private final String jdbcDriver;
  private final String jdbcUrl;
  private final String jdbcUser;
  private final String jdbcPassword;
  private final int poolMinConnections;
  private final int poolMaxConnections;

  public JdbiDataSourceConfiguration(@JsonProperty("jdbcDriver") String jdbcDriver,
      @JsonProperty("jdbcUrl") String jdbcUrl, @JsonProperty("jdbcUser") String jdbcUser,
      @JsonProperty("jdbcPassword") String jdbcPassword,
      @JsonProperty("poolMinConnections") int poolMinConnections,
      @JsonProperty("poolMaxConnections") int poolMaxConnections) {
    this.jdbcDriver = jdbcDriver;
    this.jdbcUrl = jdbcUrl;
    this.jdbcUser = jdbcUser;
    this.jdbcPassword = jdbcPassword;
    this.poolMinConnections = poolMinConnections;
    this.poolMaxConnections = poolMaxConnections;
  }

  public String getJdbcDriver() {
    return jdbcDriver;
  }

  public String getJdbcUrl() {
    return jdbcUrl;
  }

  public String getJdbcUser() {
    return jdbcUser;
  }

  public String getJdbcPassword() {
    return jdbcPassword;
  }

  public int getPoolMinConnections() {
    return poolMinConnections;
  }

  public int getPoolMaxConnections() {
    return poolMaxConnections;
  }
}