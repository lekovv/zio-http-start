package config

import zio._
import zio.config._
import zio.config.magnolia.deriveConfig

case class Interface(
    host: String,
    port: Int
)

case class CatFacts(url: String)

case class ConfigApp(
    interface: Interface,
    catFacts: CatFacts
)

object ConfigApp {

  implicit val configDescriptor: Config[ConfigApp] = (
    deriveConfig[Interface].nested("interface") zip
      deriveConfig[CatFacts].nested("catFacts")
  )
    .to[ConfigApp]
    .mapKey(toKebabCase)
}
