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


fun BasketballTeam.bestPlayer(): Player = TODO()

fun BasketballTeam.oldestPlayer(): Player = TODO()
fun BasketballTeam.youngestPlayer(): Player = TODO()
fun BasketballTeam.averagePlayerAge(): Double = TODO()

fun BasketballTeam.numberOfPlayersAt(position: Player.Position): Int = TODO()

fun BasketballTeam.playersByPositions(): Map<Player.Position, List<Player>> = TODO()

/**
 * Position with biggest number of players at that position
 */
fun BasketballTeam.positionWithBestCoverage(): Player.Position = TODO()

fun BasketballTeam.biggestPlayerWage(): Double = TODO()
fun BasketballTeam.lowestPlayerWage(): Double = TODO()
fun BasketballTeam.totalYearWageExpense(): Double = TODO()


fun main() {
    // Use for prints if needed
}
