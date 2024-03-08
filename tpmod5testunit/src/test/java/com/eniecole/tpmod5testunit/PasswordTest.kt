package com.eniecole.tpmod5testunit

import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordTest {
    @Test
    fun testPwd() {
        assertEquals(checkPassword("azer.2"),false)
        assertEquals(checkPassword("AzeQSaz.:"), true)
        assertEquals(checkPassword(""),false)
        assertEquals(checkPassword("90238URJOFDJOISNI134dqsd"), false)
        assertEquals(checkPassword("qazecs1SDQSD1SD./2"), true)
    }
}