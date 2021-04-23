enablePlugins(GitVersioning)

git.useGitDescribe := true

lazy val writeVersion = taskKey[File]("Writes project version into version.sbt")

writeVersion := {
  val out = file("version.sbt")
  IO.write(out, "version := "+'"'+ version.value +'"')
  out
}

lazy val commonSettings = Seq(
  version := "0.01",
  organization := "com.regblanc",
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
  crossScalaVersions := Seq("2.13.18", "3.3.8")
)

lazy val scalaCafeSAT = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "CafeSat",

    Test / parallelExecution := true,
    writeVersion / aggregate := false,

    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.20" % Test
  )
