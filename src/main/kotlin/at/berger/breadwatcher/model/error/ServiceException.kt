package at.berger.breadwatcher.model.error

import java.lang.RuntimeException

data class ServiceException(val error: ServiceError) : RuntimeException(error.code.name) {
}