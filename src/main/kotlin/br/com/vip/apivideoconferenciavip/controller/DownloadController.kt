package br.com.vip.apivideoconferenciavip.controller

import br.com.vip.apivideoconferenciavip.model.Conference
import br.com.vip.apivideoconferenciavip.repository.ConferenceRepository
import org.springframework.core.io.InputStreamResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.io.FileInputStream
import java.util.*

@RestController
@RequestMapping("/v1/conferences/download")
class DownloadController(val conferenceRepository: ConferenceRepository) {

    @GetMapping
    fun download(): ResponseEntity<Resource> {
        val conference = conferenceRepository.findById(UUID.fromString("a88a717e-8a10-4f60-b055-c4e20b8584e6")).run{
            if(isEmpty)
                println("FUDEU:::::")
            get()
        }
        val file = File("${conference.folder}/${conference.record}")
        println(conference.folder)
        val resource = InputStreamResource(FileInputStream(file))
        val headers = HttpHeaders().apply {
            add("Content-Disposition", "filename=Conferencia.mp4")
        }
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM) // QUAL O TYPE MP4?
                .body(resource);
    }
}