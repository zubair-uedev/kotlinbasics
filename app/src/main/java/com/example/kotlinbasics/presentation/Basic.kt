package com.example.kotlinbasics.presentation

//fun main() {
////    var a: Int = 19
////    var b: Int = 22
////    //arithmatic
////    println(a + b)
////    //compare operator
////    println(a == b)
////    a++ //= //a = a+1
//    //if else statement
//    println("WelCome to Sleep,Coffee,Assignment")
//    println("Choose your startegy")
//    println("1 :Coffee")
//    println("2 :Sleep")
//    println("3 :Assignment")
//    println("please enter your choice")
//    val enterNum = readLine()?.toIntOrNull()
//    if (enterNum !in 1..3) {
//        println("please enter valid number and try again")
//    }
//    val choice = mapOf(
//        1 to "coffee",
//        2 to "sleep",
//        3 to "assignment"
//    )
//    val computerChoice = (1..3).random()
//    println("you choose ${choice[enterNum]}")
//    println("opponent choose ${choice[computerChoice]}")
//
//    if (enterNum == computerChoice) {
//        println("draw a match ")
//    } else {
//        if (enterNum == 1 && computerChoice == 2) {
//            println("you win coffee beats sleep")
//        } else if (enterNum == 2 && computerChoice == 3) {
//            println("you win sleep beasts assignment")
//        } else if (enterNum == 3 && computerChoice == 1) {
//            println("you win assignment beats coffee")
//        } else {
//            println("you lose the match and trt again")
//        }
//    }
//
//}
//suspend fun main() {
//    val password: Int = 4321
//    var guess: Int = 0
//    println("password crack start know")
//    while (guess <= 9999) {
//        print("Trying... $guess\r")
//        delay(2)
//        if (guess == password) {
//            println("password : $guess")
//            break
//        }
//        guess++
//    }
//}
data class UserInfo(
    val id: Int,
    val name: String,
    val address: String
)

fun main() {
    val mList = mutableListOf<UserInfo>(
        UserInfo(id = 1, name = "zubaoir", address = "burewala"),
        UserInfo(id = 1, name = "zubaoir", address = "burewala"),
        UserInfo(id = 1, name = "zubaoir", address = "burewala"),
        UserInfo(id = 1, name = "zubaoir", address = "burewala"),
        UserInfo(id = 1, name = "zubaoir", address = "burewala"),
        UserInfo(id = 1, name = "zubaoir", address = "burewala"),
    )
    for (i in mList) {
        println(i)
    }
}
