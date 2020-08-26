package br.com.vip.apivideoconferenciavip.endpoint

import br.com.vip.apivideoconferenciavip.model.Conference
import br.com.vip.apivideoconferenciavip.model.ConferenceDTO
import br.com.vip.apivideoconferenciavip.repository.ConferenceRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/conferences")
class ConferenceEndpoint(val conferenceRepository: ConferenceRepository) {

    @GetMapping
    fun getConferences() = conferenceRepository.findAll()

    @PostMapping
    fun setConference(@RequestBody data:ConferenceDTO){
        println(data)
        println(conferenceRepository.save(Conference(data.url, data.record, data.folder)))
    }
}