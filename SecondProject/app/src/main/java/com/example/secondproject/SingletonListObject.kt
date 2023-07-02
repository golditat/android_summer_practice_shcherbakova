package com.example.secondproject

class SingletonListObject(
) {
    companion object {
        var list: ArrayList<TL> = arrayListOf()
        var currentid: Int = list.size - 1

    }
}