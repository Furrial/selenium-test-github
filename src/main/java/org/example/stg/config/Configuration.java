package org.example.stg.config;

import org.aeonbits.owner.Config;

@Config.Sources({"file:src\\main\\resources\\config.properties"})
public interface Configuration extends Config {
    String testAppUrl();

    String driverUrl();

    String username();

    String password();

    int timeout();
}
