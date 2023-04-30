FROM adoptopenjdk/maven-openjdk11

RUN mkdir -p /opt
COPY bh/*.jar /opt/app
COPY entry-point.sh /opt/

RUN chmod +x /opt/entry-point.sh
RUN chmod g+rwX /opt/

ENTRYPOINT ["/opt/entry-point.sh"]

EXPOSE 8080
