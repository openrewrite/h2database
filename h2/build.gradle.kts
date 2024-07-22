plugins {
    id("org.openrewrite.build.language-library")
}

// Override openrewrite default source set locations to stay aligned with
// the original project
java.sourceSets["main"].java {
    srcDir("src/main")
}

java.sourceSets["main"].resources {
    srcDir("src/main")
}

java.sourceSets["test"].java {
    srcDir("src/test")
    srcDir("src/tools")
}

java.sourceSets["test"].resources {
    srcDir("src/test")
}

tasks.jar {
    archiveBaseName.set("h2-mvstore")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

dependencies {
    compileOnly("org.slf4j:slf4j-api:1.7.36")

    implementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation("jakarta.servlet:jakarta.servlet-api:5.0.0")
    implementation("org.apache.lucene:lucene-core:8.5.2")
    implementation("org.apache.lucene:lucene-analyzers-common:8.5.2")
    implementation("org.apache.lucene:lucene-queryparser:8.5.2")
    implementation("org.locationtech.jts:jts-core:1.17.0")
    implementation("org.osgi:org.osgi.core:5.0.0")
    implementation("org.osgi:org.osgi.service.jdbc:1.1.0")

    testImplementation("org.postgresql:postgresql:42.4.0")
    testImplementation("org.ow2.asm:asm:9.4")
}

publishing {
    publications.withType<MavenPublication> {
        artifactId = "h2-mvstore"
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.isFork = true
    options.release.set(null as? Int?) // remove `--release 8` set in `org.openrewrite.java-base`
}

tasks.named("javadoc") {
    enabled = false
}

tasks.named("licenseMain") {
    enabled = false
}

tasks.named("licenseTest") {
    enabled = false
}
