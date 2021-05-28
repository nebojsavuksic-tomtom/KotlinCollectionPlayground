data class BasketballTeam(
    val name: String,
    val city: String,
    val players: List<Player>,
)

data class Player(
    val fullName: String,
    val age: Int,
    val overall: Int,
    val position: Position,
    val yearlyWageInMillions: Double
) {
    enum class Position(val value: String) {
        PG("Point Guard"),
        SG("Shooting Guard"),
        SF("Small Forward"),
        PF("Power Forward"),
        C("Center")
    }
}