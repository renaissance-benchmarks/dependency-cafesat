enablePlugins(GitVersioning)

git.useGitDescribe := true

lazy val writeVersion = taskKey[File]("Writes project version into version.sbt")

writeVersion := {
  val out = file("version.sbt")
  IO.write(out, "version := "+'"'+ version.value +'"')
  out
}

lazy val scalaSMTLib = {
  val commit = "3a51d3a2a8def2fe7221530fa4368f9b3c3a606d"
  val githubLink = s"git://github.com/renaissance-benchmarks/dependency-scala-smtlib.git#$commit"
  RootProject(uri(githubLink))
}

lazy val scalaCafeSAT = (project in file("."))
  .settings(
    name := "CafeSat",
    organization := "com.regblanc",
    version := "0.01",
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.4" % "test",
    Test / parallelExecution := true,
    writeVersion / aggregate := false,
  )
  .dependsOn(scalaSMTLib % "compile->compile; compile->test")
  .aggregate(scalaSMTLib)
