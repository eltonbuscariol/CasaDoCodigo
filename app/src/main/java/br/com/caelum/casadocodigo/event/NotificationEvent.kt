package br.com.caelum.casadocodigo.event

import com.google.firebase.messaging.RemoteMessage

class NotificationEvent(private val remoteMessage: RemoteMessage?) {

    fun getRemoteMessage() = remoteMessage
}