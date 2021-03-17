package at.berger.breadwatcher.model.error

enum class ErrorCode(val message: String, val severity: Severity) {
    NOT_FOUND("Entity was not found", Severity.BAD_INPUT),
    MISSING_PROPERTY("Missing property value", Severity.BAD_INPUT),
    INTERNAL_ERROR("Internal server error", Severity.INTERNAL_ERROR);

    fun excDet(entity: ServiceEntity, detail: String?, vararg params: Any) : ServiceException {
        val err = ServiceError(this, entity, detail, params)
        return ServiceException(err);
    }

    fun exc(entity: ServiceEntity, vararg params: Any) : ServiceException {
        return excDet(entity, null, params)
    }
}