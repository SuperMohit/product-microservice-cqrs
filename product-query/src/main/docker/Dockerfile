FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD product-query-0.0.1-SNAPSHOT.jar product-query.jar
RUN sh -c 'touch /product-query.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /product-query.jar" ]
