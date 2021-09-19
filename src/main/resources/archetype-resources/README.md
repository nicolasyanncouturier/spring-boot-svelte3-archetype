#set($h3 = '###')

${artifactId}
===============================

Requirements
-------------------------------

You must install `npm`.

You must install GraalVM version 21+ for Java 15+.

You need to set your `JAVA_HOME` to the GraalVM install.

Tips: Have a look at `sdkman` https://sdkman.io and install f.ex.:`21.1.0.r16-grl`

Compile
-------------------------------
```shell
npm i
mvn clean spring-boot:run
```
Go to http://localhost:8080

Develop
-------------------------------
Ensure your IDE is using the GraalVM install.

Start your Spring Boot app from your IDE.

In a shell run:
```shell
npm run dev
```
This will "hot reload" any changes made to your Svelte views.

Note: this directly modifies the generated JS sources in `target/classes` and therefore only works with
an app running directly from these files.