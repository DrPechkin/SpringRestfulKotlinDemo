package com.example.viktor.springrestfulkotlin

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringRestfulKotlinDemoApplicationTests {
    private val baseUrl = "http://localhost:8080"
    private val jsonContentType = MediaType(MediaType.APPLICATION_JSON.type, MediaType.APPLICATION_JSON.subtype)
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var webAppContext: WebApplicationContext // Объявляем изменяемую переменную с отложенной инициализацией в которую будет внедрен конекст приложения

    @Before // Этот метод будет запущен перед каждым тестом
    fun before() {
        mockMvc = webAppContextSetup(webAppContext).build() // Создаем объект с контекстом придожения
    }


    @Test
    fun `1 - Get empty list of notes`() {
        val request = get(baseUrl).contentType(jsonContentType)

        mockMvc.perform(request) // Выполняем запрос
                .andExpect(status().isOk) // Ожидаем http статус 200 OK
                .andExpect(content().json("[]", true)) // ожидаем пустой JSON массив в теле ответа
    }

    @Test
    fun `2 - Add first note`() {
        val passedJsonString = """
            {
                "title": "first note",
                "text": "test first note"
            }
        """.trimIndent()

        val request = post(baseUrl).contentType(jsonContentType).content(passedJsonString)

        val resultJsonString = """
            {
                "id": 1,
                "title": "first note",
                "text": "test first note"
            }
        """.trimIndent()

        mockMvc.perform(request)
                .andExpect(status().isCreated)
                .andExpect(content().json(resultJsonString, true))
    }
}
