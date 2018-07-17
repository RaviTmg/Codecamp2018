package com.crumet.codecamp

class EventModel {

    internal var time: String? = null
    internal var title: String? = null

    constructor(time: String, title: String){
        this.time = time
        this.title = title
    }
    fun getTime(): String? {
        return time
    }

    fun setTime(time: String) {
        this.time = time
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }
}