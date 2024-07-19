plugins {
    id("org.openrewrite.build.root") version("latest.release")
    id("org.openrewrite.build.java-base") version("latest.release")
}

allprojects {
    group = "org.openrewrite.tools"
    description = "Fork of h2database to maintain Java 8 compatibility"
}
