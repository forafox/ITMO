plugins {
    java
    application
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

//configurations{
//    create("Poki")
//}
application {
    mainClass.set("pokemons.Main")
}
dependencies {
//    implementation ("Pokemon.jar")
    implementation(files("Pokemon.jar"))
}
repositories {
    flatDir {
        dirs ("libs")
    }
    mavenCentral()
    maven(url = "https://jitpack.io")
}

val fatJar = tasks.create<Jar>("fatJar") {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
}

tasks["build"].dependsOn(fatJar)

