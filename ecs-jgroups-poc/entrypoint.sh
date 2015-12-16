#!/bin/bash

set -u # Fail on unset variables
set -e # Fail if any command fails

# Get EC2 host IP from AWS
EXTERNAL_HOST_IP=$(curl http://169.254.169.254/latest/meta-data/local-ipv4)

echo "Using host IP: ${EXTERNAL_HOST_IP}"

exec /usr/bin/java -Djava.net.preferIPv4Stack=true -Djgroups.bind_addr=global -Djgroups.external.addr=${EXTERNAL_HOST_IP} -Djgroups.bind.port=${JGROUPS_BIND_PORT} -Djgroups.tcpping.initial_hosts=${JGROUPS_INITIAL_HOSTS} -jar ${JBOSS_HOME}/aws-ecs-jgroups.jar
