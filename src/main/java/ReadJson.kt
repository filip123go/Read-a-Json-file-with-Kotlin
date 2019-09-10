import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File
import java.nio.charset.Charset

fun main() {

    val jsonObjectMapper = jacksonObjectMapper()
    jsonObjectMapper.registerKotlinModule()
    jsonObjectMapper.registerModule(JavaTimeModule())

    val jsonString: String = File(""".\src\main\resources\employees.json""").readText(Charsets.UTF_8)

    val jsonEmployeeTextList : List<Employee> = jsonObjectMapper.readValue(jsonString)

    for (employee in jsonEmployeeTextList ){
        println(employee)
    }


}