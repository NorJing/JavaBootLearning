package com.dboot;

import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.cache.config.EnableGemfireCaching;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

/*
.\mvnw spring-boot:run
.\mvnw clean package
java -jar target/dBootRestDemo.jar
*/

@SpringBootApplication

/*
REST
stateless
get/post/put/delete/patch
1XX - informational
2XX - success
3XX - redirection
4XX - client error
5XX - server error
HTTP header
Accept:application/json
Content-type:application/xml
*/

// for Gemfire
@ClientCacheApplication(name = "AccessingGemFireDataRestApplication", logLevel = "error")
@EnableEntityDefinedRegions(basePackageClasses = Person.class, clientRegionShortcut = ClientRegionShortcut.LOCAL)
@EnableGemfireRepositories
@SuppressWarnings("unused")

// curl -i -X POST -H "Content-Type:application/json" -d "{  \"firstName\" : \"Tommy\", \"lastName\" : \"Frank\" }" http://localhost:8080/people

public class DBootRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBootRestDemoApplication.class, args);
	}

}

