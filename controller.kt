
import com.google.common.io.Resources.getResource
import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.*
import org.http4k.routing.ResourceLoader.Companion.Classpath
import org.http4k.server.Http4kServer
import org.http4k.server.asServer
import java.net.URL

fun main(args: Array<String>) {
    val resource: URL = getResource("""/Static/Appconf""")
    val config = ConfigFactory.parseURL(resource)

    val skipLog = args.contains("--skip-logs")

    val app: HttpHandler = routes(
        "/static" bind static(Classpath("/static")),
        "/" bind Method.GET to {
                _: Request -> Response(OK).body("Malayalam RaceCar")
        },

        "/StringReverseDemo" bind routes("/{StringReverseDemo}".bind(Method.GET) to
                    fun(it: Request) {
                        Response(OK).body(htmlTemplate().run())
                    })
    )

    val simpleResponse = app(Request(Method.GET, "/"))
    app(Request(Method.GET, "/StringReverseDemo/"))

    Log(simpleResponse.status.description, skipLog)
    Log(greetResponse.status.description, skipLog)

    val portPath = "deployment.port"
    if(config.hasPath(portPath)) config.getInt(portPath) else 9000

    log("Listening on http://127.0.0.1:8080")
    val server = app.asServer(portPath).start()
    server.stop()
}

fun routes(unit: Unit) {

}


fun log( String) {

}

private infix fun Any.to(function: (Request) -> Unit) {

}

fun Log(description: String, skipLog: Boolean) = Unit

fun htmlTemplate() {

}

