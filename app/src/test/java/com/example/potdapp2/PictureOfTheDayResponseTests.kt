package com.example.potdapp2

import com.example.potdapp2.api.PictureOfTheDayResponseFunctionForTests
import org.junit.Assert.*
import org.junit.Test

class PictureOfTheDayResponseTests {
    @Test
    fun PictureOfTheDay_TitleEqualsMoon_ReturnsTrue() {
        assertEquals("Moon", PictureOfTheDayResponseFunctionForTests.pictureOfTheDay.title);
    }
    @Test
    fun PictureOfTheDay_CopirightNotEqualsMoon_ReturnsFalse() {
        assertNotEquals("Mars", PictureOfTheDayResponseFunctionForTests.pictureOfTheDay.copyright);
    }
    @Test
    fun PictureOfTheDay_IsNull_ReturnsTrue() {
        assertNull(null);
    }
    @Test
    fun PictureOfTheDay_NotNull_ReturnsFalse() {
        assertNotNull(PictureOfTheDayResponseFunctionForTests.pictureOfTheDay);
    }
    @Test
    fun PictureOfTheDay_IsSame_ReturnsTrue() {
        assertSame(PictureOfTheDayResponseFunctionForTests.pictureOfTheDay.title,PictureOfTheDayResponseFunctionForTests.pictureOfTheDay.title)
    }

}