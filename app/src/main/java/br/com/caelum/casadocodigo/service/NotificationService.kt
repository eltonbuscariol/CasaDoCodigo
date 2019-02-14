package br.com.caelum.casadocodigo.service

import br.com.caelum.casadocodigo.event.NotificationEvent
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.greenrobot.eventbus.EventBus

class NotificationService : FirebaseMessagingService(){


    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        EventBus.getDefault().post(NotificationEvent(remoteMessage))
    }
}