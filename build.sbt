lazy val scalaSMTLib = {
  val commit = "3a51d3a2a8def2fe7221530fa4368f9b3c3a606d"
  val githubLink = s"git://github.com/renaissance-benchmarks/dependency-scala-smtlib.git#$commit"
  RootProject(uri(githubLink))
}

lazy val scalaCafeSAT = (project in file(".")).
  settings(
    name := "CafeSat",
    organization := "com.regblanc",
    version := "0.01",
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),

    javaOptions in IntegrationTest ++= Seq("-Xss10M"),
    fork in IntegrationTest := true,
    logBuffered in IntegrationTest := false,
    parallelExecution in Test := true,

    libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test,it"
  ).
  configs( IntegrationTest ).
  settings( Defaults.itSettings : _*).
  dependsOn(scalaSMTLib)
