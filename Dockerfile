FROM cwds/javajdk
RUN mkdir /opt/geo-services-api
RUN mkdir /opt/geo-services-api/logs
ADD config/geo-services-api.yml /opt/geo-services-api/geo-services-api.yml
ADD config/shiro.ini /opt/geo-services-api/config/shiro.ini
ADD config/testKeyStore.jks /opt/geo-services-api/config/testKeyStore.jks
ADD build/libs/geo-services-api-dist.jar /opt/geo-services-api/geo-services-api.jar
EXPOSE 8080 8443
WORKDIR /opt/geo-services-api
CMD ["java", "-jar", "geo-services-api.jar","server","geo-services-api.yml"]