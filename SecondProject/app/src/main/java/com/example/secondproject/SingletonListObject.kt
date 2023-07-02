package com.example.secondproject

class SingletonListObject(
    val tl: TL
) {
    companion object {
        var list: ArrayList<TL> = arrayListOf()
        var currentid: Int = 0

        fun addToTlList(tl: TL) {
            list.add(tl)
            currentid++
        }
    }
}