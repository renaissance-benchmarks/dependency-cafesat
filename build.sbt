enablePlugins(GitVersioning)

git.useGitDescribe := true

lazy val writeVersion = taskKey[File]("Writes project version into version.sbt")

writeVersion := {
  val out = file("version.sbt")
  IO.write(out, "version := "+'"'+ version.value +'"')
  out
}

lazy val scalaCafeSAT = (project in file("."))
  .settings(
    name := "CafeSat",
    organization := "com.regblanc",
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.4" % "test",
    Test / parallelExecution := true,
    writeVersion / aggregate := false,
  )
