package at.berger.breadwatcher.model

import java.time.Instant

data class Bread(val id: String, val name: String, val amount : Double, val timestamp: Instant) {
}