package za.co.locotec.notifyr
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class NotificationData(val app:  String, val title: String, val detail: String) {
}
