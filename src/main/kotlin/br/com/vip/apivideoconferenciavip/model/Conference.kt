package br.com.vip.apivideoconferenciavip.model

import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "conference",indexes = [
        Index(name = "IDX_DATETIME", columnList = "date_time")
])
data class Conference(
                val url: String,
                val record: String,
                val folder: String,
                val recordSize: Long
) {
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(columnDefinition = "BINARY(16)")
        val id:UUID = UUID.randomUUID()
        @Column(name = "date_time", nullable = false)
        val dateTime: LocalDateTime = LocalDateTime.now()
}