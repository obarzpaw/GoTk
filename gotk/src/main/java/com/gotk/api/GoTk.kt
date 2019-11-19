package com.gotk.api

class GoTk {
    lateinit var api: GoTkAPIService

    fun init() {
        api = GoTkAPIService.create()
    }
}