package com.hellosg.studio.hitechagri.models

data class Node(var name: String, var nodeId: String, var temp: Float, var airHumi: Float, var soilHumi: Float, var light: Float) {
    constructor(name: String, nodeId: String) : this(name, nodeId, 0f, 0f, 0f, 0f) {}
}