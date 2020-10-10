package microreso.system.db

case class DatabaseConfiguration(
  host: String,
  port: Int,
  username: String,
  password: String,
  database: String,
) {
  def connectionURL: String = s"jdbc:postgresql://${host}:${port}/${database}"
}