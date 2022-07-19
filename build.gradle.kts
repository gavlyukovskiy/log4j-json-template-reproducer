plugins {
    java
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "reproducer"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    implementation("org.apache.logging.log4j:log4j-layout-template-json")
    modules {
        module("org.springframework.boot:spring-boot-starter-logging") {
            replacedBy(
                "org.springframework.boot:spring-boot-starter-log4j2",
                "Use Log4j2 instead of the default Logback"
            )
        }
    }
}
