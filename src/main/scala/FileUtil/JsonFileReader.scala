package FileUtil

import model._
import spray.json.{RootJsonFormat, enrichString}

import scala.io.Source
import scala.util._
import spray.json.DefaultJsonProtocol._

object JsonFileReader {

  def readFile(path: String): String = {
    Try(Source.fromFile(path)) match {
      case Success(source: Source) => {
        return source.getLines().mkString
      }
      case Failure(exception) => {
        throw exception
      }
    }
  }

  implicit val trainerJsonFormat: RootJsonFormat[Trainer] = jsonFormat4(Trainer)

  implicit val trainersJsonFormat: RootJsonFormat[Trainers] = jsonFormat1(Trainers)


  def convertToTrainer(trainer : String) = {
    trainer.parseJson.convertTo[Trainer]
  }

  def convertToTrainers(trainers : String ) = {
    trainers.parseJson.convertTo[Trainers]
  }

}
