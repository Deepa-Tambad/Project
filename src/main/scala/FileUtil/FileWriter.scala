package FileUtil

import java.io.PrintWriter
import model.{Trainer, Trainers}

import java.util

object FileWriter {

  def convertJsonToCsv(trainers: Trainers, outputPath: String, errorPath: String): Any = {
    val fieldTrainersNames = trainers.trainer.head.productElementNames
    val field_Value: List[Trainer] = trainers.trainer
    Try(new PrintWriter(outputPath)) match {
      case Success(value) => {
        val header: String = fieldTrainersNames.foldRight("")((prev, current) => prev + "," + current)
        value.println(header)
        Try(field_Value.map(f => {
          val mobileNumber: String = f.mobileNumber match {
            case None => ","
            case Some(value) => value.toString + ","
          }
          val row_Value = f.id + "," + f.fName + "," + f.lName + "," + mobileNumber
          value.println(row_Value)}))
      }
    }
  }

  def logErrorFile(path: String, errorMessage: String): Unit = {
    Try(new PrintWriter(path)) match {
      case Success(value) => value.println(errorMessage)
        value.close()
      case Failure(exception) => println("Couldn't write the Error to the File")
    }
  }
}
