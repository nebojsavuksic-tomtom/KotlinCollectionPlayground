package tasks

import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

internal class BasketballTeamTest {
    @Test
    fun `should verify DenverNuggets best player`() {
        denverNuggets.bestPlayer().fullName `assert equals to` "Nikola Jokic"
    }

    @Test
    fun `should verify DenverNuggets oldest player`() {
        denverNuggets.oldestPlayer().fullName `assert equals to` "Paul Millsap"
    }

    @Test
    fun `should verify DenverNuggets youngest player`() {
        denverNuggets.youngestPlayer().fullName `assert equals to` "Michael Porter Jr."
    }

    @Test
    fun `should verify DenverNuggets average player age`() {
        denverNuggets.averagePlayerAge() `assert equals to` 27.0
    }

    @Test
    fun `should verify DenverNuggets number of players per position`() {
        Player.Position.values().zip(listOf(4, 1, 2, 1, 1)).forEach { (position, expectedNumOfPlayers) ->
            denverNuggets.numberOfPlayersAt(position) `assert equals to` expectedNumOfPlayers
        }
    }
    @Test
    fun `should verify DenverNuggets players per position`() {
        val expectedPlayersPerPosition = players.groupBy { it.position }

        denverNuggets.playersByPositions() `assert equals to` expectedPlayersPerPosition
    }

    @Test
    fun `should verify DenverNuggets position with most players`() {
        denverNuggets.positionWithBestCoverage() `assert equals to` Player.Position.PG
    }

    @Test
    fun `should verify DenverNuggets biggest player wage`() {
        denverNuggets.biggestPlayerWage() `assert equals to` 29.542
    }

    @Test
    fun `should verify DenverNuggets lowest player wage`() {
        denverNuggets.lowestPlayerWage() `assert equals to` 1.723
    }

    @Test
    fun `should verify DenverNuggets total yearly wage expense`() {
        assertEquals(denverNuggets.totalYearWageExpense(), 115.77199, 0.00001)
    }


    private infix fun Any?.`assert equals to`(other: Any?) {
        assertThat(this, `is`(equalTo(other)))
    }
}