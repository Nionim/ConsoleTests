plugins {
    id("java")
    kotlin("jvm") version "2.1.10"
    id("com.gradleup.shadow") version("8.3.0")
}

group = "delta.cion"
version = "1.0-SNAPSHOT"

// TODO
// javac -h . delta/cion/Main.java

val sourceDir = ".\\src\\main\\java\\delta\\cion\\c\\"
val outputFile = ".\\src\\main\\java\\delta\\cion\\dll\\"
val java_home = "E:\\JaBase\\graalvm-jdk-22.0.2+9.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}

tasks {

    jar {
        manifest {
            attributes["Main-Class"] = "delta.cion.Main"
        }
    }

    build {
        dependsOn(shadowJar)
        dependsOn("generateDlls")
    }

    shadowJar {
        mergeServiceFiles()
        archiveClassifier.set("")
    }

    // python .\DllGenerator.py .\src\main\java\delta\cion\c\ .\src\main\java\delta\cion\dll\ E:\JaBase\graalvm-jdk-22.0.2+9.1
    register<Exec>("generateDlls") {
        commandLine("python", ".\\DllGenerator.py", sourceDir, outputFile, java_home)
    }
}