FROM cwds/alpinejre
RUN mkdir /opt/geo-services-api
RUN mkdir /opt/geo-services-api/logs
ADD config/geo-services-api.yml /opt/geo-services-api/geo-services-api.yml
ADD config/shiro.ini /opt/geo-services-api/config/shiro.ini
ADD build/libs/geo-services-api-dist.jar /opt/geo-services-api/geo-services-api.jar
ADD entrypoint.sh /opt/geo-services-api/entrypoint.sh
RUN chmod +x /opt/geo-services-api/entrypoint.sh
EXPOSE 8080 8443
WORKDIR /opt/geo-services-api
CMD ["/opt/geo-services-api/entrypoint.sh"]
