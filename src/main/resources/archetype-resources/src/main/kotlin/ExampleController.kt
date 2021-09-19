package ${package}

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView


@Controller
class ExampleController {

    @GetMapping("/")
    fun example(): String = "svelte:ExampleView"

    @GetMapping("/props")
    fun exampleWithProps(@RequestParam("counter")counter:Int): ModelAndView {
        return ModelAndView("svelte:ExampleView", mapOf("counter" to counter))
    }

}