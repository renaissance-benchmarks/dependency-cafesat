lazy val commonSettings = Seq(
  organization := "com.regblanc",
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
  crossScalaVersions := Seq("2.13.18", "3.3.8")
)

lazy val scalaCafeSAT = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "CafeSat",

    Test / parallelExecution := true,

    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.20" % Test
  )
