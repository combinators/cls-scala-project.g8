logLevel := Level.Warn
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
$if(templatingSupport.truthy)$
addSbtPlugin("com.typesafe.sbt" % "sbt-twirl" % "$twirl_version$")
$endif$
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "$play_version$")
