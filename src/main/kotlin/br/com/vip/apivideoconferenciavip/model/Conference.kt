package br.com.vip.apivideoconferenciavip.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Conference(
        val url:String,
        val record:String,
        val folder:String
) {
        @Id
        val id:UUID = UUID.randomUUID()
        val dateTime: LocalDateTime = LocalDateTime.now()
}