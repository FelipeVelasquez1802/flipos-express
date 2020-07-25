package com.infinitesolutions.fliposexpress.data.api.firebase.repositories

import com.google.firebase.auth.FirebaseAuth
import com.infinitesolutions.fliposexpress.data.api.firebase.ApiFirebase
import com.infinitesolutions.fliposexpress.domain.entities.UserDomain
import com.infinitesolutions.fliposexpress.domain.interfaces.repositories.UserRepository
import durdinapps.rxfirebase2.RxFirebaseAuth
import io.reactivex.Observable

class UserRepositoryApiImpl : UserRepository {

    private val apiFirebase: FirebaseAuth = ApiFirebase.auth()

    override fun login(email: String?, password: String?): Observable<Any?> {
        return RxFirebaseAuth.signInWithEmailAndPassword(apiFirebase, email ?: "", password ?: "")
            .flatMapObservable {
                val user = it.user
                var userDomain: UserDomain? = null
                if (user != null) {
                    userDomain = UserDomain(user.email)
                    userDomain.id = user.uid
                }

                Observable.just(userDomain)
            }
    }

    override fun insert(user: UserDomain): Observable<UserDomain?> {
        TODO("Not yet implemented")
    }

    override fun select(): Observable<ArrayList<UserDomain>> {
        TODO("Not yet implemented")
    }

    override fun select(id: String): Observable<UserDomain?> {
        TODO("Not yet implemented")
    }

    override fun selectByUsername(username: String): Observable<UserDomain?> {
        TODO("Not yet implemented")
    }

    override fun selectFirst(): Observable<UserDomain?> {
        TODO("Not yet implemented")
    }

    override fun update(user: UserDomain): Observable<UserDomain?> {
        TODO("Not yet implemented")
    }

}