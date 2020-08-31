package br.com.vip.apivideoconferenciavip.service

import br.com.vip.apivideoconferenciavip.model.Conference
import br.com.vip.apivideoconferenciavip.model.ConferenceDTO
import br.com.vip.apivideoconferenciavip.repository.ConferenceRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ConferenceService(val conferenceRepository: ConferenceRepository) {

    fun getAllConferences() = conferenceRepository.findAll()

    fun getConference(id: String) = conferenceRepository.findById(UUID.fromString(id))

    fun saveConference(conferenceDTO: ConferenceDTO) = conferenceRepository.save(Conference(
            conferenceDTO.url,
            conferenceDTO.record,
            conferenceDTO.folder
    ))

//    fun saveConference(conferenceDTO: ConferenceDTO): ConferenceDTO{
//        return conferenceRepository.save(Conference(
//                conferenceDTO.url,
//                conferenceDTO.record,
//                conferenceDTO.folder
//        )).let{
//            ConferenceDTO(it.url, it.record, it.folder)
//        }
//    }
}