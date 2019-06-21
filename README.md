# CWDS GEO Services API

The CWDS GEO Services API provides RESTful API to lookup, suggest, validate and get the distance for physical addresses.
It is an decorator for the SmartyStreets: https://smartystreets.com/ which is under the hud.

## Wiki

The development team is actively using the [Github Wiki](https://github.com/ca-cwds/geo-services-api/wiki).

## Documentation

The development team uses [Swagger](http://swagger.io/) for documenting the API.
NOTE : At this time there is not a publicy available link to the documentation, a link will be provided as soon as one is available.


## Configuration

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

## Testing

### Unit Tests
To run all unit tests, run `./gradlew test`. If the build is successful, all tests passed. If a test fails, you will see more output. If no files have changed, the test run may be very fast.

## Development

### Running the Application
_Make sure you have configured the valid client id and token for SmartyStreets as well as Perry (https://github.com/ca-cwds/perry).  
Checkuot configuration in 'config/geo-services-api.yml'_

To start the application by gradle use: `./gradlew run`

Note: This will attempt to download artifacts, which may require you to be connected to OpenVPN.
First of all check 

Also there is an option to start `gov.ca.cwds.geo.GeoServicesApiApplication`                                                    
with the program arguments `server config/geo-services-api.yml`

# Questions

If you have any questions regarding the contents of this repository, please email the Office of Systems Integration at FOSS@osi.ca.gov.

