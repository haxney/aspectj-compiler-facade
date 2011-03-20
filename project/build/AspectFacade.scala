import sbt._

class AspectjCompilerFacade(info: ProjectInfo) extends DefaultProject(info) {
  lazy val aspectjTools = "org.aspectj" % "aspectjtools" % "1.6.11"
  lazy val springRelease = "Spring Framework Release Repository" at "http://maven.springframework.org/release"
}
