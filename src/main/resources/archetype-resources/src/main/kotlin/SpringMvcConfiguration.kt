package ${package}

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.nicolasyanncouturier.svelte3.spring.web.HtmlDocument
import com.github.nicolasyanncouturier.svelte3.spring.web.SvelteViewResolver
import com.github.nicolasyanncouturier.svelte3.ssr.SimpleRenderer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ViewResolver


@Configuration
class SpringMvcConfiguration {

    @Bean
    fun svelteViewResolver(): ViewResolver {
        return SvelteViewResolver(SimpleRenderer(), ExampleHtmlDocument(), jsonMapper=ObjectMapper())
    }

    class ExampleHtmlDocument: HtmlDocument {

        override fun render(lang: String?, head: String?, css: String?, html: String?, bundle: String?, props: String?): String {
            val langCode = lang?.let { """ lang="$it"""" }
            val headCode = head ?: ""
            val cssCode = css?.let {
                """
                <style>
                $it
                </style>
                """.trimIndent()
            } ?: ""
            val bundleCode = bundle?.let {
                """<script defer="" src="/static/$it" crossorigin="anonymous"></script>"""
            } ?: ""
            val propsCode = props?.let {
                """
                <script>window.onload = function() {
                  document.body.innerHTML = '';
                  const test = new app({
                    target: document.body,
                    props: $it
                  });
                }</script>
                """.trimIndent()
            } ?: ""
            val htmlCode = html ?: ""

            return """
                <!DOCTYPE html>
                <html$langCode">
                  <head>
                  <meta name=viewport content="width=device-width, initial-scale=1">
                  <link rel="stylesheet" href="/static/main.css">
                  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
                  $headCode
                  $cssCode
                  $bundleCode
                  $propsCode
                  </head>
                  <body class="bg-light">
                    $htmlCode
                  </body>
                </html>
                """.trimIndent()
        }

    }
}