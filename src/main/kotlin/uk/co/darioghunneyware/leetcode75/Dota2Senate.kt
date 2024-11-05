package uk.co.darioghunneyware.leetcode75

import java.util.LinkedList
import java.util.Queue

class Dota2Senate {
    fun predictPartyVictory(senate: String): String {
        val radiant = "Radiant"
        val dire = "Dire"

        if (senate.length == 2) {
            return when (senate.first()) {
                'R' -> radiant
                else -> dire
            }
        }

        val partyQueue = LinkedList<Char>()
        senate.map { partyQueue.offer(it) }

        while (partyQueue.size > 1) {
            var index = 0

            while (index < partyQueue.size) {
                if (partyQueue[index] == 'R') {
                    partyQueue.remove('D')
                } else {
                    partyQueue.remove('R')
                }

                index++
            }

            if (onePartySenate(partyQueue, 'R')) return radiant
            if (onePartySenate(partyQueue, 'D')) return dire

            if (index == partyQueue.size) {
                if (partyQueue.last() == 'R') {
                    partyQueue.remove('D')
                } else {
                    partyQueue.remove('R')
                }
            }
        }

        return if (partyQueue.first == 'R') radiant else dire
    }

    private fun onePartySenate(
        partyQueue: Queue<Char>,
        party: Char,
    ): Boolean = partyQueue.all { it == party }
}
