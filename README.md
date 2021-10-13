# dapper sample for maven users

Add this dependency:

````xml
<dependency>
  <groupId>io.github.jbock-java</groupId>
  <artifactId>dapper</artifactId>
  <version>1.0</version>
</dependency>
````

Then configure the annotation processor:

````xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <configuration>
        <annotationProcessorPaths>
          <dependency>
            <groupId>io.github.jbock-java</groupId>
            <artifactId>dapper-compiler</artifactId>
            <version>1.0</version>
          </dependency>
        </annotationProcessorPaths>
      </configuration>
    </plugin>
  </plugins>
</build>
````

Add this to `module-info.java`:

````java
requires jakarta.inject;
requires dagger;
````

### Run it

````sh
./mvnw clean package
jpackage --name coffee --type app-image --module-path `./get_module_path` --module coffee/example.dagger.CoffeeApp --dest target/out
./create_launcher_script >coffee && chmod +x coffee
./coffee
````

The `jpackage` part will only work with jdk16 or higher.
The `jpackage` binary can be found in `$JAVA_HOME/bin`.

### See also

* [dapper](https://github.com/jbock-java/dapper)
