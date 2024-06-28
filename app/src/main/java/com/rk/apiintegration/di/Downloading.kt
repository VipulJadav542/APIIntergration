package com.rk.apiintegration.di

import android.util.Log

class HttpClient {
}

class Executor {

}

class Request constructor(private val httpClient: HttpClient, private val executor: Executor) {
    fun getRequest() {
        Log.d("main", "file downloading")
    }
}

class Downloader constructor(private val request: Request) {
    fun getDownload() {
        request.getRequest()
    }
}
object DownloaderFactory    {
    fun create():Downloader{
        val client = HttpClient()
        val executor = Executor()
        val request=Request(client, executor)
        return Downloader(request)
    }
}