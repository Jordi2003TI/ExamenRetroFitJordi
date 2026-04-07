package com.example.examenretrofitjordi.DataClasses

import java.util.Objects

class ValidationError (
    private val loc: List<String>,
    private val msg: String,
    private val type: String,
    private val ctx: Objects
)