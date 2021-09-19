package ${package}

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Svelte3DemoApplication

fun main(args: Array<String>) {
    runApplication<Svelte3DemoApplication>(*args)
}