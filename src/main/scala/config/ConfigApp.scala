package config

import zio._
import zio.config._
import zio.config.magnolia.deriveConfig

case class Interface(
    host: String,
    port: Int
)

case class ConfigApp(
    interface: Interface
)

object ConfigApp {

  implicit val configDescriptor: Config[ConfigApp] =
    deriveConfig[Interface]
      .nested("interface")
      .to[ConfigApp]
}
