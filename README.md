https://www.svenmalvik.com/azure-appconfiguration-feature-flags/

- Create Azure App Configuration
- `export APP_CONFIGURATION_CONNECTION_STRING=...`
- Add feature flag to your Azure App Configuration service called `beta`.
- `mvn clean install && mvn spring-boot:run`
