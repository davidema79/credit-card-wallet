FROM java:8u111-jre 
# Create a directory where our app will be placed
RUN mkdir -p /home/vexiosci

# Add the final image into the
ADD ./bo-vexios-gateway.jar /home/vexiosci

# Change directory so that our commands run inside this new directory
WORKDIR /home/vexiosci
    
VOLUME ["/home/vexiosci/logs"]

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "-Dloader.path=/home/vexiosci/conf,/home/vexiosci", "/home/vexiosci/bo-vexios-gateway.jar"]