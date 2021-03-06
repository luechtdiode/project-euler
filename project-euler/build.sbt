name := "project-euler"

version := "1.0.0"

scalaVersion := "2.10.3"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.+" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.10.+"

libraryDependencies += "org.json4s" % "json4s-native_2.10" % "3.2.+"

libraryDependencies += "org.scala-lang" % "scala-swing" % "2.10.+"

libraryDependencies += "net.databinder.dispatch" % "dispatch-core_2.10" % "0.11.+"

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.10.+"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.+"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.+"

libraryDependencies += "com.squareup.retrofit" % "retrofit" % "1.0.+"

libraryDependencies += "org.scala-lang.modules" %% "scala-async" % "0.9.+"

libraryDependencies += "com.netflix.rxjava" % "rxjava-scala" % "0.15.+"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.2.+"

libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.2.+"

publishMavenStyle := true

publishTo := Some(Resolver.file("maven-local",  new File( "C:/Users/Public/maven/repository" )) )

