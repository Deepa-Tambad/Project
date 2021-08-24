
import FileUtil.{FileWriter, JsonFileReader}
import config.ApplicationConfig
import model.Trainers

import scala.util._

object GenerateFile extends App {

  val file: Option[String] = Try(JsonFileReader.readFile(ApplicationConfig.config.getString("sourcepath"))) match {
    case Success(value) => Some(value)
    case Failure(exception) => Option.empty
  }

  if (file.isEmpty) {
    FileWriter
      .logErrorFile(ApplicationConfig.config.getString("errorpath"), "Couldn't read the Json File")
  } else {
    val members: Try[Trainers] = Try(JsonFileReader.convertToTrainers(file.get))
    members match {
      case Success(value) => {
        FileWriter.convertJsonToCsv(value, ApplicationConfig.config.getString("outputpath"),
          ApplicationConfig.config.getString("errorpath"))
      }
      case Failure(exception) => {
        FileWriter
          .logErrorFile(ApplicationConfig.config.getString("errorpath"), exception.getMessage)
      }
    }
  }
}
