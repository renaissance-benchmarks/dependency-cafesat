lazy val scalaSMTLib = {
  val commit = "004fab30fc294677a14429fad2cd95ab4d366416"
  val githubLink = s"git://github.com/regb/scala-smtlib.git#$commit"
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
