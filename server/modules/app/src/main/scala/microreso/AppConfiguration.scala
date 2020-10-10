package microreso

import com.typesafe.config.ConfigFactory
import microreso.system.db.DatabaseConfiguration
import microreso.system.http.HttpConfiguration

class AppConfiguration {
  private val config = ConfigFactory.load()

  val database: DatabaseConfiguration = DatabaseConfiguration(
    host = config.getString("microreso.database.host"),
    port = config.getInt("microreso.database.port"),
    username = config.getString("microreso.database.username"),
    password = config.getString("microreso.database.password"),
    database = config.getString("microreso.database.database")
  )

  val http: HttpConfiguration = HttpConfiguration(
    host = config.getString("microreso.http.host"),
    port = config.getInt("microreso.http.port"),
  )
}
