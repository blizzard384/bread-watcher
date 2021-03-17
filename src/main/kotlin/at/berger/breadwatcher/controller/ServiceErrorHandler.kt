package at.berger.breadwatcher.controller

import at.berger.breadwatcher.model.error.ServiceException
import at.berger.breadwatcher.model.error.Severity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest


@ControllerAdvice
class ServiceErrorHandler {

    @ExceptionHandler(ServiceException::class)
    protected fun handleConflict(ex: ServiceException, request: WebRequest?): ResponseEntity<Any> {
        val err = ex.error
        val msg = ErrorMessage(err.code, err.code.message, err.entity, err.detail, err.params)

        return if (err.code.severity == Severity.BAD_INPUT)
            ResponseEntity.badRequest().body(msg)
        else ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg)
    }
}