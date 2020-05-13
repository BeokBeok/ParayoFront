package com.example.parayo.controller

import com.example.parayo.common.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController // view 를 랜더링하지 않고 http 본문에 직접 텍스트로 이루어진 데이터를 씀
class HelloController {

    @GetMapping("api/v1/hello")
    fun hello() = ApiResponse.ok("world")
}