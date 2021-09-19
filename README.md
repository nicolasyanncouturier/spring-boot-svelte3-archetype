# spring-boot-svelte3-archetype

## Usage

Edit your `~/.m2/settings.xml` and add this github repo as a repository to use the archetype from as in the example below:

```xml
    <settings>
      
      <profiles>
        <profile>
          <id>default</id>
          <activation>
            <activeByDefault>true</activeByDefault>
          </activation>
          <repositories>
            <repository>
              <id>com.github.nicolasyanncouturier.spring-boot-svelte3-archetype</id><!-- id expected by maven-archetype-plugin to avoid fetching from everywhere -->
              <url>https://raw.githubusercontent.com/nicolasyanncouturier/spring-boot-svelte3-archetype/master</url>
              <releases>
                <enabled>true</enabled>
                <checksumPolicy>warn</checksumPolicy>
              </releases>
            </repository>
          </repositories>
        </profile>
      </profiles>
    
    </settings>
```


```shell
mvn archetype:generate -B \
-DarchetypeGroupId=com.github.nicolasyanncouturier \
-DarchetypeArtifactId=spring-boot-svelte3-archetype \
-DarchetypeVersion=0.1.0 \
-Dpackage=<your-package> \
-DgroupId=<your-group-id> \
-DartifactId=<your-artifact-id>
```