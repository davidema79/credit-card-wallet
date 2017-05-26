# BidlottoWeb

This project was generated with [angular-cli](https://github.com/angular/angular-cli) version 1.0.0-beta.22-1.

## Development server
Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

### Enviroments
Supported environments:
1. `dev`
  * Basic 1 to 1 transpilation.
  * No minification or obfuscation.
  * Contains debugging information
  * Can enable a mock backend.
  * Git branch: development
    * Pipeline: Compile DEV, static-analysis, unit tests.
    
1. `test`
  * Transpilation and bundling
  * Contains debugging info (SourceMaps, etc..)
  * Git branch: development
    * Pipeline: Compile TEST, ETE test, deployment on staging
    
1. `prod`
  * Minified and obfuscated.
  * SourceMap should be created but never bundled along. Dev should have the option to load up the sourceMaps when live debugging is required.
  * Git branch: master
    * Pipeline: Compile PRD, commit sourceMaps and remove from bundle, deployment on production

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive/pipe/service/class`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).
Before running the tests make sure you are serving the app via `ng serve`.

## Create, Run and Push the Container

Move into the directory where bidlotto-web lives and:
1. Remove the directory `dist` it it exists.
1. Create the container with the command:  `docker build -t nexus.vexios.mla.local:18079/lotto/lotto-web:<tag label> -t nexus.vexios.mla.local:18079/lotto/lotto-web:latest .`
1. Run the image just created with the command: `docker run -p 4200:4200  nexus.vexios.mla.local:18079/lotto/lotto-web:<tag label>`
1. Push the image to the private docker registry: `docker push nexus.vexios.mla.local:18079/lotto/lotto-web`. This command will push both images into the registry.


## Deploying to Github Pages

Run `ng github-pages:deploy` to deploy to Github Pages.

## Further help

To get more help on the `angular-cli` use `ng --help` or go check out the [Angular-CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
