package br.com.vip.apivideoconferenciavip.controller

import br.com.vip.apivideoconferenciavip.model.Conference
import br.com.vip.apivideoconferenciavip.service.ConferenceService
import br.com.vip.apivideoconferenciavip.util.fileFactory
import br.com.vip.apivideoconferenciavip.util.pathToRecords
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.io.FileInputStream

@RestController
@RequestMapping("/v1/conferences/download")
class DownloadController(val conferenceService: ConferenceService) {

    @GetMapping("/{id}")
    fun download(@PathVariable id: String): ResponseEntity<Any> {
        val conference = conferenceService.getConferenceObj(id)?: return ResponseEntity.notFound().build()
        val file = fileFactory(conference)
        if (!file.exists()){
            println("Arquivo nao encontrado! ${file.absolutePath}")
            return ResponseEntity.notFound().build()
        }
        val resource = InputStreamResource(FileInputStream(file))
        val headers = HttpHeaders().apply {
            add("Content-Disposition", "filename=${conference.record.split("_")[0]}.mp4")
        }
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM) // QUAL O TYPE MP4?
                .body(resource);
    }

}