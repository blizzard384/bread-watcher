package at.berger.breadwatcher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BreadWatcherApplication

fun main(args: Array<String>) {
	runApplication<BreadWatcherApplication>(*args)
}
