import play.sbt.PlayLayoutPlugin
import play.twirl.sbt.SbtTwirl

lazy val commonSettings = Seq(
  version := "1.0.0-SNAPSHOT",
  organization := "$organization$",

  scalaVersion := "2.12.3",

  resolvers ++= Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.typesafeRepo("releases")
  ),

  scalacOptions ++= Seq(
    "-unchecked",
    "-deprecation",
    "-feature",
    "-language:implicitConversions"
  ),

  libraryDependencies ++= Seq(
    "org.combinators" %% "cls-scala" % $cls_scala_version$,
    "org.combinators" %% "cls-scala-presentation-play-git" % $cls_scala_presentation_play_git_version$,
$if(templating_support.truthy)$
    "org.combinators" %% "templating" % $templating_version$,
$endif$
    "org.scalactic" %% "scalactic" % $scalactic_version$ % "test",
    "org.scalatest" %% "scalatest" % $scalatest_version$ % "test",
    guice
  )

)

lazy val root = (Project(id = "$name$", base = file(".")))
  .settings(commonSettings: _*)
$if(templating_version.truthy)$
  .enablePlugins(SbtTwirl)
$endif$
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .settings(
$if(templating_support.truthy)$
//  Python support
    sourceDirectories in (Compile, TwirlKeys.compileTemplates) += sourceDirectory.value / "main" / "python-templates",
    TwirlKeys.templateFormats += ("py" -> "org.combinators.templating.twirl.PythonFormat"),
    TwirlKeys.templateImports += "org.combinators.templating.twirl.Python",

//  Java support
    sourceDirectories in (Compile, TwirlKeys.compileTemplates) += sourceDirectory.value / "main" / "java-templates",
    TwirlKeys.templateImports := Seq(),
    TwirlKeys.templateFormats += ("java" -> "org.combinators.templating.twirl.JavaFormat"),
    TwirlKeys.templateImports += "org.combinators.templating.twirl.Java",

    TwirlKeys.templateImports += "com.github.javaparser.ast._",
    TwirlKeys.templateImports += "com.github.javaparser.ast.body._",
    TwirlKeys.templateImports += "com.github.javaparser.ast.comments._",
    TwirlKeys.templateImports += "com.github.javaparser.ast.expr._",
    TwirlKeys.templateImports += "com.github.javaparser.ast.stmt._",
    TwirlKeys.templateImports += "com.github.javaparser.ast.`type`._",

//  Monitor template files for changes
    PlayKeys.playMonitoredFiles ++= (sourceDirectories in (Compile, TwirlKeys.compileTemplates)).value,
$endif$
  moduleName := "$name$"
)
