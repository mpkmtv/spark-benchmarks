import de.heikoseeberger.sbtheader.HeaderPlugin.autoImport._
import de.heikoseeberger.sbtheader._
import de.heikoseeberger.sbtheader.License.ALv2
import sbt._
import sbt.Keys._
import sbt.plugins.JvmPlugin

object Common extends AutoPlugin {

  override def trigger = allRequirements

  override def requires = JvmPlugin && AutomateHeaderPlugin

  override lazy val projectSettings =
    Dependencies.Common ++ Seq(
      organization := "com.bbva.spark",
      organizationName := "BBVA",
      version := "0.1.0",
      organizationHomepage := Some(url("https://github.com/BBVA")),
      scmInfo := Some(ScmInfo(url("https://github.com/BBVA/spark-benchmarks"), "git@github.com:BBVA/spark-benchmarks.git")),
      developers += Developer("contributors", "Contributors", "", url("https://github.com/BBVA/spark-benchmarks/contributors")),

      licenses := Seq(("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))),

      scalaVersion := Dependencies.ScalaVersion,

      scalacOptions ++= Seq(
        "-encoding", "UTF-8",
        "-feature",
        "-unchecked",
        "-deprecation",
        //"-Xfatal-warnings",
        "-Xlint",
        "-Yno-adapted-args",
        "-Ywarn-dead-code",
        "-Xfuture"
      ),

      javacOptions ++= Seq(
        "-Xlint:unchecked"
      ),

      //autoAPIMappings := true,
      //apiURL := Some(url(s"http://developer.bbva.com/docs/api/spark-benchmarks/${version.value}")),
/*
      headerLicense := headerLicense.value ++ Map(
        "scala" -> ALv2("2017", "Banco Bilbao Vizcaya Argentaria S.A."),
        "java" -> ALv2("2017", "Banco Bilbao Vizcaya Argentaria S.A."),
        "conf" -> ALv2("2017", "Banco Bilbao Vizcaya Argentaria S.A.", "#")
      )
*/
    )

}