name := """monitoring-poc"""

version := "1.0"

scalaVersion := "2.11.6"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")
mainClass in Compile := Some("com.example.Application")

libraryDependencies ++= Seq(
  // Uncomment to use Akka
  //"com.typesafe.akka" % "akka-actor_2.11" % "2.3.9",
  "junit"             % "junit"           % "4.12"  % "test",
  "com.novocode"      % "junit-interface" % "0.11"  % "test",
  "org.springframework.boot" % "spring-boot-starter-parent" % "1.3.3.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-web" % "1.3.3.RELEASE",
  "org.springframework" % "spring-context" % "4.2.4.RELEASE",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.2",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.6.2",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.6.2",
  "com.jcraft" % "jsch" % "0.1.53"
)

dependencyOverrides ++= Set(
  "org.springframework" % "spring-context" % "4.2.4.RELEASE",
  "org.springframework" % "spring-tx" % "4.2.4.RELEASE",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.2",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.6.2",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.6.2"
)
