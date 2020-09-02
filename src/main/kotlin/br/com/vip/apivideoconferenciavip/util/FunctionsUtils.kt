package br.com.vip.apivideoconferenciavip.util

import br.com.vip.apivideoconferenciavip.model.Conference
import br.com.vip.apivideoconferenciavip.model.ConferenceDTO
import java.io.File
import java.util.*

val pathToRecords = "/root/.jitsi-meet-cfg/jibri/recordings/"

fun recordSize(conferenceDTO: ConferenceDTO): Long{
    val file = fileFactory(conferenceDTO)
    return file.length()
}

fun fileFactory(conference: Conference): File {
    val folder = conference.folder.split("/")[3]
    return File(pathToRecords + folder + "/" + conference.record)
}

fun fileFactory(conference: ConferenceDTO): File {
    val folder = conference.folder.split("/")[3]
    return File(pathToRecords + folder + "/" + conference.record)
}

fun deleteRecordFolder(conference: Conference) {
    val folderName = conference.folder.split("/")[3]
    val folder = File(pathToRecords + folderName)
    if (folder.exists()) folder.deleteRecursively()
}

fun convertToUUID(id: String): UUID? {
    return try {
        UUID.fromString(id)
    } catch (ex: IllegalArgumentException) {
        println("UUID recebido invalido $id")
        null
    }
}