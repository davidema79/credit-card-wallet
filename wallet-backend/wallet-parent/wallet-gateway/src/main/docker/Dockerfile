FROM java:8u111-jre 
# Create a directory where our app will be placed
RUN mkdir -p /home/e-wallet

# Add the final image into the
ADD ./wallet-gateway.jar /home/e-wallet

# Change directory so that our commands run inside this new directory
WORKDIR /home/e-wallet
    
VOLUME ["/home/e-wallet/logs"]

EXPOSE 7070

ENTRYPOINT ["java", "-jar", "/home/e-wallet/wallet-gateway.jar"]