package microreso.domain.user.model

case class User(
  id: UserId,
  username: Username,
  password: String,
  email: String,
  role: UserRole.Value
)