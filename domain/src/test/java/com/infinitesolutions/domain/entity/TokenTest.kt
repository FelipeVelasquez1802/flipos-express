package com.infinitesolutions.domain.entity

import com.infinitesolutions.domain.exception.empty.EmptyTokenException
import org.junit.Assert.*
import org.junit.Test

class TokenTest {

    @Test
    fun createTokenWithKeyEmpty() {
        // Given
        val key = ""
        val user = User(1, "admin", token = key)
        val messageException = "Tenemos un problema con las credenciales del usuario."
        // When
        try {
            Token(key, user)
            fail()
        } catch (e: EmptyTokenException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun createTokenSuccess() {
        // Given
        val key = "123qweasdzxc"
        // When
        val token = Token(key, User(1, "admin", token = key))
        // Then
        assertNotNull(token)
    }

    @Test
    fun createTokenWithOnlyUser() {
        // Given
        val key = "123qweasdzxc"
        // When
        val token = Token(User(1, "admin", token = key))
        // Then
        assertNotNull(token)
    }

    @Test
    fun createTokenWithPasswordNotEmpty() {
        // Given
        val key = "123qweasdzxc"
        val password = "admin"
        // When
        val token = Token(key, User(1, "admin", password))
        // Then
        assertNotNull(token)
    }
}