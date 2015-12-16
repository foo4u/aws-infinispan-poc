FROM jboss/base-jdk:7
MAINTAINER Scott Rossillo "srossillo@smartling.com"

USER root

# Prepare shared directory for logs
RUN mkdir /var/log/jboss.keycloak
RUN chown jboss.jboss /var/log/jboss.keycloak

USER jboss

COPY build/libs/ /opt/jboss

ENV JBOSS_HOME /opt/jboss

COPY entrypoint.sh ${JBOSS_HOME}/

EXPOSE 8080 7800

ENTRYPOINT ["/opt/jboss/entrypoint.sh"]
