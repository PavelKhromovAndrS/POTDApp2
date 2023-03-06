package com.example.potdapp2

import com.example.potdapp2.ui.API_KEY
import com.example.potdapp2.ui.BASE_URL
import org.junit.Assert.assertTrue
import org.junit.Test

class NasaRepositoryTest{
    @Test
    fun NasaRepository_ApiKeyNotNull_ReturnsTrue() {
        assertTrue(API_KEY!=null)
    }
    @Test
    fun NasaRepository_ApiKeyNotEmptyString_ReturnsTrue() {
        assertTrue(API_KEY!="")
    }
    @Test
    fun NasaRepository_BaseUrlNotNull_ReturnsTrue() {
        assertTrue(BASE_URL!=null)
    }
    @Test
    fun NasaRepository_BaseUrlNotEmptyString_ReturnsTrue() {
        assertTrue(BASE_URL!="")
    }
}