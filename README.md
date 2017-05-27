# eWallet For Virtual Documents
Electronic Wallet for Credit Cards and other Virtual Documents

### Abstract
This projects shows how to integrate a simple backend project developed with SpringBoot and Angular 4 as Web UI.

Backend part includes Spring Security, Actuators and JPA persistence. It uses MySQL Database to persist the data.

## Back End: Wallet Gateway
The backend is under `wallet-backend/`. It is a maven modular project.

### How to Build
Move into `wallet-backend/wallet-parent/` and build with the command:
```shell
	mvn clean verify
```
It will execute the tests and generate an executable **fat** jar.

### How to Execute

#### Setup the DataBase

Before to launch the executable file, you need to setup the database. This project uses MySQL to persist the data. 

In order to create the database and the tables, please execute the .sql script `wallet-backend/ewallet-script.sql` 

#### Execute the Jar

Move into the folder `wallet-backend/wallet-parent/wallet-gateway/target`, there you will find an executable .jar file: `wallet-gateway.jar`.

Launch it with the usual java command:
```shell
	java -jar wallet-gateway.jar
```

## Front End: Wallet Web
The front-end part of the project is under `wallet-web/`. The project was generated with [angular-cli](https://github.com/angular/angular-cli) version 1.0.3.

### Angular-CLI Installation

Install globally angular-cli:
```shell
    npm install -g @angular/cli
```

### Download Dependencies
You need to install all the dependencies before to run it. 

Move into the folder `wallet-web/`, and execute the command:
```shell
    npm install
```

Then you can build or deploy the development server. 

### Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

### Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.

### Docker Image
If you want to create a docker image, after you built the project, you need to execute:
```shell
    docker build -t <name of the image> .
```

The Dockerfile contained in the project will create a new docker image based on Nginx

### Run Docker container
After the image was created, you can deploy it with the command:

```shell
    docker run --name wallet-web-first -d -p80:80 <name of the image>
```

Now open your web browser at [http://localhost/](http://localhost/). 

**Please note** that till you don't deploy the backend you will be able to see the web application, but you cannot login. 

### Further help

To get more help on the `angular-cli` use `ng --help` or go check out the [Angular-CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

