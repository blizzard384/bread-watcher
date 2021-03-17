package at.berger.breadwatcher.model.error

data class ServiceError(val code: ErrorCode, val entity: ServiceEntity, val detail: String?, val params: Array<out Any>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ServiceError

        if (code != other.code) return false
        if (entity != other.entity) return false
        if (detail != other.detail) return false
        if (!params.contentEquals(other.params)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = code.hashCode()
        result = 31 * result + entity.hashCode()
        result = 31 * result + detail.hashCode()
        result = 31 * result + params.contentHashCode()
        return result
    }


}