lazy val parentProject = ProjectRef(uri("../../.."), "scalaSatBenchmarks")

lazy val scalaCafeSAT = (project in file("."))
  .settings(
    name := "CafeSat",
    organization := "com.regblanc",
    scalaVersion := (parentProject / scalaVersion).value,
    scalacOptions := (parentProject / scalacOptions).value ++ Seq("-unchecked", "-deprecation", "-feature"),
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.20" % Test,
    Test / parallelExecution := true
  )
