package br.com.vip.apivideoconferenciavip.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DownloadControllerTest{

    @Test
    fun reccordPath(){
        val path = "/config/recordings/xcocvojrcvfkbnmm"
        val size = path.split("/").size
        println(path.split("/")[size-1])
    }
}