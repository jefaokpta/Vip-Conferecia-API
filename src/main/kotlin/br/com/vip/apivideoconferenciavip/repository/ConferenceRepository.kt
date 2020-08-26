package br.com.vip.apivideoconferenciavip.repository

import br.com.vip.apivideoconferenciavip.model.Conference
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ConferenceRepository: CrudRepository<Conference, UUID> {
}