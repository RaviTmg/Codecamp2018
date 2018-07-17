package com.crumet.codecamp2018

class SponsorModel {
    internal var name: String? = null
    internal var type: String? = null
    internal var short_description: String? = null
    internal var ic_name: Int? = null

    constructor(name: String?, type: String?, short_description: String?, ic_name: Int?) {
        this.name = name
        this.type = type
        this.short_description = short_description
        this.ic_name = ic_name
    }

    fun getName(): String? {
        return name
    }

    fun getType(): String? {
        return type
    }

    fun getDesc(): String? {
        return short_description
    }

    fun getIcon(): Int? {
        return ic_name
    }
}