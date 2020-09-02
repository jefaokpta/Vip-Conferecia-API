package br.com.vip.apivideoconferenciavip.controller

import br.com.vip.apivideoconferenciavip.util.pathToRecords
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity
import java.io.File

internal class DownloadControllerTest{

    //@Test
    fun deleteFolderTest(){
        val file = File("/Users/jefaokpta/Downloads/teste")
        if (!file.exists()){
            println("Arquivo nao encontrado! ${file.absolutePath}")
            assert(false)
        }
        assertTrue(file.deleteRecursively())
    }

    //@Test
    fun reccordPathTest(){
        val path = "/config/recordings/xcocvojrcvfkbnmm"
        val size = path.split("/").size
        println(path.split("/")[size-1])
    }
}