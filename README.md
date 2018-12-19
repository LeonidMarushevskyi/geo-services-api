# CWDS GEO Services API

The CWDS GEO Services API provides RESTful services for the CWDS Digital Services.

## Wiki

The development team is actively using the [Github Wiki](https://github.com/ca-cwds/geo-services-api/wiki).

## Documentation

The development team uses [Swagger](http://swagger.io/) for documenting the API.
NOTE : At this time there is not a publicy available link to the documentation, a link will be provided as soon as one is available.


## Docker Container Configuration

### Application Configuration Parameters
- APP_VERSION -- Version of application

### Smarty Streets
- **SS_ID** -- Smarty Streets Client Id (required)
- **SS_TOKEN** -- Smarty Streets token (required)

### SSL Configuration Parameters
- KEY_STORE_FILE -- Path to keystore file
- KEY_STORE_PASSWORD -- Keystore password

#### Swagger Configuration Parameters
- LOGIN_URL -- Login URL 
- SHOW_SWAGGER -- Show swagger (true | false) default - true
- SWAGGER_JSON_URL -- default - http://localhost:8080/swagger.json
- SWAGGER_CALLBACK_URL -- default - http://localhost:8080/swagger

#### Shiro Configuration Parameters
- SHIRO_CONFIG_PATH -- path to Shiro configuration file

The Docker env-file option provides a convenient method to supply these variables. These instructions assume an env file called .env located in the current directory. The repository contains a sample env file called env.sample.

Further configuration options are available in the file config/geo-services-api.yml.

# Questions

If you have any questions regarding the contents of this repository, please email the Office of Systems Integration at FOSS@osi.ca.gov.

