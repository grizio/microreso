package microreso.system.db

import scalikejdbc.{ConnectionPool, ConnectionPoolSettings, DB, DBSession, SettingsProvider}

import scala.concurrent.{ExecutionContext, Future}

class DatabaseTransaction(config: DatabaseConfiguration)(implicit ec: ExecutionContext) {
  ConnectionPool.singleton(
    config.connectionURL,
    config.username,
    config.password,
    ConnectionPoolSettings(
      initialSize = 0,
      maxSize = 3
    )
  )

  def withConnection[A](op: DBSession => Future[A]): Future[A] = DB.readOnly(op)

  def withTransaction[A](op: DBSession => Future[A]): Future[A] = DB.futureLocalTx(op)
}
