This project shows how Gradle's current automatic selection for
`org.gradle.jvm.version` is flawed, as it does not account for the compiler's
version. For example, Java 16 classes can be used in the classpath of a
`--release 8` compilation, if the `javac` used is from JDK 16+.

The `java16-lib` project is compiled with 16. Super simple.
The `java8-lib` project is compiled using JDK 16, with `--release 8`.
Gradle defaults to using 8 as the `org.gradle.jvm.version` for resolution, but
this is incorrect -- we are using a 16 compiler here, and forcing the version
will allow it to compile just fine. Gradle should instead be using 16 as the
`org.gradle.jvm.version`.
