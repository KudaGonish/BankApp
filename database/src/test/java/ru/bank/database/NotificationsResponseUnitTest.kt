package ru.bank.database

/*
import com.amicum.notification.remote.model.response.NotificationDto
import com.amicum.notification.remote.model.response.NotificationListDto
import com.amicum.share_data.test_data.NotificationTest
import org.junit.Test
import org.junit.Assert.*

*/
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *//*

class NotificationsResponseUnitTest {

    var testData = NotificationTest().invoke()

    var testDTO = com.amicum.notification.remote.model.response.NotificationListDto(
        id = "siz",
        title = "Необходима замена СИЗ",
        notifications = listOf(
            com.amicum.notification.remote.model.response.NotificationDto(
                worker_id = 100000123,
                worker_full_name = "Якимов М. Н.",
                worker_position_title = "Директор",
                siz_id = 30800199,
                siz_title = "ЩИТОК СВАРЩИКА НН-12 CRYSTALINE UNIVERSAL",

                checkup_date_start = "2021-09-01",
                checkup_date_end = "2021-09-30",
                status_id = "1",
                audit_place_title = null,
                audit_date_time = null,
                audit_place_id = null,
                audit_id = null,
                briefing_date_time = null,
                check_knowledge_date_time = null,
                worker_date_end = null,
                worker_staff_number = "П1",
                checking_id = null,
                flag = null,
                ppk_date_time = null,
                ppk_id = null,
                ppk_status_id = null,
                restriction = null
            )
        )
    )

    @Test
    fun testConvertJsonToPOJO1(){
        assertEquals(testDTO.id, testData.id)
    }
    @Test
    fun testConvertJsonToPOJO2(){
        assertEquals(testDTO.title, testData.title)
    }
    @Test
    fun testConvertJsonToPOJO13(){
        assertEquals(testDTO.notifications, testData.notifications)
    }

}*/
