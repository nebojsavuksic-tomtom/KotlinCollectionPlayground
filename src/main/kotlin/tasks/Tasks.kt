package tasks


import BasketballTeam
import Player

val players = listOf(
    Player("Nikola Jokic", age = 26, 95, Player.Position.C, 29.542),
    Player("Jamal Murray", age = 24, 88, Player.Position.PG, 27.285),
    Player("Facundo Campazzo", age = 30, 79, Player.Position.PG, 3.20),
    Player("Aron Gordon", age = 25, 85, Player.Position.SF, 18.136),
    Player("Michael Porter Jr.", age = 22, 87, Player.Position.SF, 3.550),
    Player("Paul Millsap", age = 36, 78, Player.Position.PF, 10.00),
    Player("Monté Morris", age = 25, 82, Player.Position.PG, 1.723),
    Player("Javale McGee", age = 25, 82, Player.Position.PG, 4.20),
    Player("Will Burton", age = 30, 81, Player.Position.SG, 18.136),
)

val denverNuggets = BasketballTeam(name = "Denver Nuggets", city = "Denver", players = players)


fun BasketballTeam.bestPlayer(): Player = this.players.maxByOrNull { it.overall } ?: error("No players found")

fun BasketballTeam.oldestPlayer(): Player = this.players.maxByOrNull { it.age } ?: error("No players found")
fun BasketballTeam.youngestPlayer(): Player = this.players.minByOrNull { it.age } ?: error("No players found")
fun BasketballTeam.averagePlayerAge(): Double = this.players.map { it.age }.average()

fun BasketballTeam.numberOfPlayersAt(position: Player.Position): Int = this.players.count { it.position == position }

fun BasketballTeam.playersByPositions(): Map<Player.Position, List<Player>> = this.players.groupBy { it.position }

/**
 * Position with biggest number of players at that position
 */
fun BasketballTeam.positionWithBestCoverage(): Player.Position = this.players
    // Returns Map<Position, Player>
    .groupBy { it.position }
    // Returns Map<Position, CountOfPlayers>
    .map { it.key to it.value.count() }
    // Returns Pair<Position, CountOfPlayersAsInt> which has the biggest count
    .maxByOrNull { it.second }!!
    // Takes the position
    .first

fun BasketballTeam.biggestPlayerWage(): Double = this.players.maxOf { it.yearlyWageInMillions }
fun BasketballTeam.lowestPlayerWage(): Double = this.players.minOf { it.yearlyWageInMillions }
fun BasketballTeam.totalYearWageExpense(): Double = this.players.sumByDouble { it.yearlyWageInMillions }


fun main() {
    println("The best player of ${denverNuggets.name} is: ${denverNuggets.bestPlayer()}") //Jokic

    println("The oldest player of ${denverNuggets.name} is: ${denverNuggets.oldestPlayer()}")
    println("The youngest player of ${denverNuggets.name} is: ${denverNuggets.youngestPlayer()}")
    println("${denverNuggets.name} average player age is: ${denverNuggets.averagePlayerAge()}")

    printPlayersPerPositions()

    printNumberOfPlayersAtPosition(Player.Position.PG)
    printNumberOfPlayersAtPosition(Player.Position.SG)
    printNumberOfPlayersAtPosition(Player.Position.SF)
    printNumberOfPlayersAtPosition(Player.Position.PF)
    printNumberOfPlayersAtPosition(Player.Position.C)

    println("\nPosition with best coverage is: ${denverNuggets.positionWithBestCoverage()}")

    println("\nThe biggest player wage: ${denverNuggets.biggestPlayerWage()}")
    println("\nThe lowest player wage: ${denverNuggets.lowestPlayerWage()}")
    println("\nTotal year wage expenses: ${denverNuggets.totalYearWageExpense()}")
}

private fun printPlayersPerPositions() {
    denverNuggets.playersByPositions().forEach {
        println("\nPosition ${it.key.value}:")

        it.value.forEachIndexed { index, player ->
            println("${index + 1}. ${player.fullName}")
        }
    }
    println()
}

private fun printNumberOfPlayersAtPosition(position: Player.Position) {
    println("Number of players at ${position.value} position: ${denverNuggets.numberOfPlayersAt(position)}")
}