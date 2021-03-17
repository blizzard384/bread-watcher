package at.berger.breadwatcher.model

data class BreadSession(val id: String?, val pass: String, val breads: MutableList<Bread>)
