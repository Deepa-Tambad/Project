package config

import com.typesafe.config.{Config, ConfigFactory}

object ApplicationConfig {

  val config: Config = ConfigFactory.load().getConfig("json-to-csv")
}
