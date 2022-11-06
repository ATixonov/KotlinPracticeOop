package ru.synergy.kotlinpracticeoop.player

open class Video {
    open fun play() {
        println("play video")
    }
}

interface Audio {
    fun play() {
        println("play audio")
    }
}

class Media(): Video(), Audio {

    override fun play() {
        super<Audio>.play()
        super<Video>.play()
    }
}