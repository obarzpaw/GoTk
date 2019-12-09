package com.gotk

import GoTkCharacter
import com.gotk.api.GoTk
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlinx.coroutines.runBlocking

class GoTkTest {
    private val testedObject = GoTk()

    @Before
    fun setUp() {
        testedObject.init()
    }

    @Test
    fun initGoTk() {
        Assert.assertNotNull(testedObject.api)
    }

    @Test
    fun getCharacterById() {
        runBlocking {
            val returnedCharacter = testedObject.api.getCharacterById(583)
            Assert.assertEquals("Jon Snow", returnedCharacter?.name)
        }
    }

    @Test
    fun getCharacterByName() {
        runBlocking {
            var returnedCharacter = testedObject.api.getCharacterByName("jon snow")
            Assert.assertEquals("Jon Snow", returnedCharacter[0].name)

            returnedCharacter = testedObject.api.getCharacterByName("eddard stark")
            Assert.assertEquals("Eddard Stark", returnedCharacter[0].name)

            returnedCharacter = testedObject.api.getCharacterByName("Arya Stark")
            Assert.assertEquals("Arya Stark", returnedCharacter[0].name)
        }
    }

    @Test
    fun getCharactersByPage() {
        runBlocking {
            var returnedCharacters : List<GoTkCharacter> = testedObject.api.getCharactersByPage(1)
            Assert.assertEquals(10, returnedCharacters.size)
        }
    }

    @Test
    fun getCharacterByUrl() {
        runBlocking {
            val url = "https://anapioficeandfire.com/api/characters/36"
            val returnedCharacter = testedObject.api.getCharacterByUrl(url)
            Assert.assertEquals("Aegon Frey", returnedCharacter?.name)
        }
    }

    @Test
    fun getBookById() {
        runBlocking {
            val returnedBook = testedObject.api.getBookById(2)
            Assert.assertEquals("A Clash of Kings", returnedBook?.name)
        }
    }

    @Test
    fun getBookByUrl() {
        runBlocking {
            val url = "https://www.anapioficeandfire.com/api/books/2"
            val returnedBook = testedObject.api.getBookByUrl(url)
            Assert.assertEquals("A Clash of Kings", returnedBook?.name)
        }
    }

    @Test
    fun getHouseById() {
        runBlocking {
            val returnedHouse = testedObject.api.getHouseById(378)
            Assert.assertEquals("House Targaryen of King's Landing", returnedHouse?.name)
        }
    }

    @Test
    fun getHouseByUrl() {
        runBlocking {
            val url = "https://anapioficeandfire.com/api/houses/229"
            val returnedHouse = testedObject.api.getHouseByUrl(url)
            Assert.assertEquals("House Lannister of Casterly Rock", returnedHouse?.name)
        }
    }
}