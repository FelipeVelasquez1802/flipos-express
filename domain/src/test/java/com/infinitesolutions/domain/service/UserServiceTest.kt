package com.infinitesolutions.domain.service

import com.infinitesolutions.domain.entity.Token
import com.infinitesolutions.domain.entity.User
import com.infinitesolutions.domain.exception.EmptyUserException
import com.infinitesolutions.domain.exception.empty.EmptyPasswordException
import com.infinitesolutions.domain.exception.empty.EmptyTokenException
import com.infinitesolutions.domain.exception.empty.EmptyUsernameException
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import com.infinitesolutions.domain.repository.local.UserRepository as UserRepositoryLocal
import com.infinitesolutions.domain.repository.remote.UserRepository as UserRepositoryRemote

@RunWith(MockitoJUnitRunner::class)
class UserServiceTest {

    @Mock
    lateinit var userRepositoryRemote: UserRepositoryRemote

    @Mock
    lateinit var userRepositoryLocal: UserRepositoryLocal

    private lateinit var userService: UserService

    @Before
    fun init() {
        userService = UserService(userRepositoryLocal, userRepositoryRemote)
    }

    @Test
    fun loginSuccess() {
        // Given
        val username = "admin"
        val password = "admin123"
        val key = "123qweasdzxc"
        val user = User(1, "admin", token = key)
        `when`(userRepositoryRemote.login(username, password)).thenReturn(Token(key, user))
        `when`(userRepositoryLocal.update(user)).thenReturn(user)
        // When
        val token = userService.login(username, password)
        // Then
        Assert.assertNotNull(token)
    }

    @Test
    fun loginWithUsernameAndPasswordEmpty() {
        // Given
        val username = ""
        val password = ""
        val messageException = "El campo de nombre de usuario no puede estar vacio."
        // When
        try {
            userService.login(username, password)
            fail()
        } catch (e: EmptyUsernameException) {
            // Then
            Assert.assertEquals(messageException, e.message)
        }
    }

    @Test
    fun loginWithUsernameEmpty() {
        // Given
        val username = ""
        val password = "admin1234"
        val messageException = "El campo de nombre de usuario no puede estar vacio."
        // When
        try {
            userService.login(username, password)
            fail()
        } catch (e: EmptyUsernameException) {
            // Then
            Assert.assertEquals(messageException, e.message)
        }
    }

    @Test
    fun loginWithPasswordEmpty() {
        // Given
        val username = "admin"
        val password = ""
        val messageException = "El campo de contraseña no puede ser vació."
        // When
        try {
            userService.login(username, password)
            fail()
        } catch (e: EmptyPasswordException) {
            // Then
            Assert.assertEquals(messageException, e.message)
        }
    }

    @Test
    fun isLoginSuccess() {
        // Given
        val key = "123qweasdzxc"
        val user = User(1, "admin", token = key)
        `when`(userRepositoryLocal.selectToken()).thenReturn(key)
        `when`(userRepositoryRemote.isLogin(key)).thenReturn(Token(key, user))
        `when`(userRepositoryLocal.update(user)).thenReturn(user)
        // When
        val token = userService.isLogin()
        // Then
        assertNotNull(token)
    }

    @Test
    fun isLoginFailed() {
        // Given
        val messageException = "Tenemos un problema con las credenciales del usuario."
        `when`(userRepositoryLocal.selectToken()).thenReturn(null)
        // When
        try {
            userService.isLogin()
            fail()
        } catch (e: EmptyTokenException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun isLoginFinishSession() {
        // Given
        val key = "123qweasdzxc"
        val user = User(1, "admin", token = key)
        val messageException = "Tenemos problemas con el usuario, llegó nulo"
        `when`(userRepositoryLocal.selectToken()).thenReturn(key)
        `when`(userRepositoryRemote.isLogin(key)).thenReturn(null)
        // When
        try {
            userService.isLogin()
            fail()
        } catch (e: EmptyUserException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }
}