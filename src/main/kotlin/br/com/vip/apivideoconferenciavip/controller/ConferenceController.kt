package br.com.vip.apivideoconferenciavip.controller

import br.com.vip.apivideoconferenciavip.model.Conference
import br.com.vip.apivideoconferenciavip.model.ConferenceDTO
import br.com.vip.apivideoconferenciavip.service.ConferenceService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/conferences")
class ConferenceController(val conferenceService: ConferenceService) {

    @GetMapping
    fun getConferences() = conferenceService.getAllConferences()

    @GetMapping("/{id}")
    fun getConference(@PathVariable id: String) = conferenceService.getConference(id)

    @PostMapping
    fun setConference(@RequestBody data:ConferenceDTO): Conference {
        println(data)
        return conferenceService.saveConference(data)
    }
}