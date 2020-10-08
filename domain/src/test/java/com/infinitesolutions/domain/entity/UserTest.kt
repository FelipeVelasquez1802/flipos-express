package com.infinitesolutions.domain.entity

import com.infinitesolutions.domain.exception.empty.EmptyPasswordException
import com.infinitesolutions.domain.exception.empty.EmptyUsernameException
import org.junit.Assert
import org.junit.Test

class UserTest {

    @Test
    fun createUserWithUsernameAndPassword() {
        // Given
        val username = "admin"
        val password = "admin123"
        // When
        val user = User(username = username, password = password)
        // Then
        Assert.assertNotNull(user)
    }

    @Test
    fun createUserWithUsernameAndPasswordEmpty() {
        // Given
        val username = ""
        val password = ""
        val messageException = "El campo de nombre de usuario no puede estar vacio."
        // When
        try {
            User(username = username, password = password)
            Assert.fail()
        } catch (e: EmptyUsernameException) {
            // Then
            Assert.assertEquals(messageException, e.message)
        }
    }

    @Test
    fun createUserWithPasswordEmpty() {
        // Given
        val username = "admin"
        val password = ""
        val messageException = "El campo de contraseña no puede ser vació."
        // When
        try {
            User(username = username, password = password)
            Assert.fail()
        } catch (e: EmptyPasswordException) {
            // Then
            Assert.assertEquals(messageException, e.message)
        }
    }

    @Test
    fun createUserWithTokenNotEmptyAndPasswordEmpty() {
        // Given
        val username = "admin"
        val password = ""
        val token = "sdnakjdkasjdkljaskldjksaljdklasjdklsajkl3"
        // When
        val user = User(username = username, password = password, token = token)
        // Then
        Assert.assertNotNull(user)
    }

    @Test
    fun createUserWithPasswordNull() {
        // Given
        val username = "admin"
        val password = null
        val messageException = "El campo de contraseña no puede ser vació."
        // When
        try {
            User(username = username, password = password)
            Assert.fail()
        } catch (e: EmptyPasswordException) {
            // Then
            Assert.assertEquals(messageException, e.message)
        }
    }
}