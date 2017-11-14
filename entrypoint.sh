#!/usr/bin/env bash

JAVA_OPTS="-Xms128m -Xmx256m ${JAVA_OPTS}"

if [ -z "$API_CONFIG" ]
then
  API_CONFIG="geo-services-api.yml"
fi

if [ -f /opt/newrelic/newrelic.yml ]; then
    java -javaagent:/opt/newrelic/newrelic.jar  ${JAVA_OPTS} -jar geo-services-api.jar server $API_CONFIG
else
    java  ${JAVA_OPTS} -jar geo-services-api.jar server $API_CONFIG
fi

