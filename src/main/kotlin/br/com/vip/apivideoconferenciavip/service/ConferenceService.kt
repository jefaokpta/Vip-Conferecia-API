package br.com.vip.apivideoconferenciavip.service

import br.com.vip.apivideoconferenciavip.model.Conference
import br.com.vip.apivideoconferenciavip.model.ConferenceDTO
import br.com.vip.apivideoconferenciavip.repository.ConferenceRepository
import br.com.vip.apivideoconferenciavip.util.convertToUUID
import br.com.vip.apivideoconferenciavip.util.deleteRecordFolder
import br.com.vip.apivideoconferenciavip.util.recordSize
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ConferenceService(val conferenceRepository: ConferenceRepository) {

    fun getAllConferences() = conferenceRepository.findAll()

    fun getConference(id: String): ResponseEntity<Any>{
        val uuid = convertToUUID(id).run { this?: return ResponseEntity.notFound().build() }
        return conferenceRepository.findById(uuid).run {
            if (isPresent)  ResponseEntity.ok(get())
            else ResponseEntity.notFound().build()
        }
    }

    fun getConferenceObj(id: String): Conference?{
        val uuid = convertToUUID(id).run { this?: return null }
        return conferenceRepository.findById(uuid).run {
            if (isPresent) get()
            else null
        }
    }

    fun saveConference(conferenceDTO: ConferenceDTO) = conferenceRepository.save(Conference(
            conferenceDTO.url,
            conferenceDTO.record,
            conferenceDTO.folder,
            recordSize(conferenceDTO)
    ))

    fun deleteConference(id: String): ResponseEntity<Any> {
        val uuid = convertToUUID(id).run { this?: return ResponseEntity.notFound().build() }
       return conferenceRepository.findById(uuid).run {
            if (isPresent) {
                conferenceRepository.deleteById(uuid)
                deleteRecordFolder(get())
                ResponseEntity.ok().build()
            } else ResponseEntity.notFound().build()
        }
    }

}