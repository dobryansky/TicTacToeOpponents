package com.artem.myapplication

class LogicGame(var gameBoard: Array<Array<Int>>, val numToWin: Int) {


    var winArray: Array<Array<Int>> = Array(gameBoard[0].size) { Array(gameBoard[0].size) { 5 } }

    fun checkWin(): Boolean {
        return checkColumns() || checkRows() || checkDiagonal()

    }
    fun printWinArray(){
        if(checkWin()) {
            for (i in 0 until winArray.size) {
                for (j in 0 until winArray.size) {
                    print("${winArray[i][j]} ")
                }
                println()
            }
        }
    }

    fun checkDiagonal(): Boolean {
        var count = 0
        for (i in 0 until gameBoard[0].size - 1) {
            if (gameBoard[i][i] == gameBoard[i + 1][i + 1] && (gameBoard[i][i] == 0 || gameBoard[i][i] == 1)) {
                winArray[i][i]=1
                winArray[i + 1][i + 1]=1
                count++
            } else {
                count = 0
                winArray = Array(gameBoard[0].size) { Array(gameBoard[0].size) { 5 } }
            }
            if (count == (numToWin - 1)) return true
        }
        count = 0
        winArray = Array(gameBoard[0].size) { Array(gameBoard[0].size) { 5 } }
        for (i in 0 until gameBoard[0].size - 1) {

            if (gameBoard[i][gameBoard[0].size - 1 - i] == gameBoard[i + 1][gameBoard[0].size - 2 - i] && ((gameBoard[i][gameBoard[0].size - 1 - i] == 0) || gameBoard[i][gameBoard[0].size - 1 - i] == 1)) {
                winArray[i][gameBoard[0].size - 1 - i]=1
                winArray[i + 1][gameBoard[0].size - 2 - i]=1
                count++
            } else {
                count = 0
                winArray = Array(gameBoard[0].size) { Array(gameBoard[0].size) { 5 } }
            }
            if (count == (numToWin - 1)) return true
        }
        return false

    }

    fun checkRows(): Boolean {
        var count = 0
        for (i in 0 until gameBoard[0].size) {
            for (j in 0 until gameBoard[0].size - 1) {

                if (gameBoard[i][j] == gameBoard[i][j + 1] && ((gameBoard[i][j] == 0) || gameBoard[i][j] == 1)) {
                    winArray[i][j]=1
                    winArray[i][j + 1]=1
                    count++
                } else {
                    count = 0
                    winArray = Array(gameBoard[0].size) { Array(gameBoard[0].size) { 5 } }
                }
                if (count == (numToWin - 1)) {
                    return true
                }
            }
            count = 0
        }
        return false


    }

    fun checkColumns(): Boolean {
        var count = 0
        for (j in 0 until gameBoard[0].size) {
            for (i in 0 until gameBoard[0].size - 1) {

                if (gameBoard[i][j] == gameBoard[i + 1][j] && (gameBoard[i][j] == 0 || gameBoard[i][j] == 1)) {
                    winArray[i][j]=1
                    winArray[i + 1][j]=1
                    count++
                } else {
                    count = 0
                    winArray = Array(gameBoard[0].size) { Array(gameBoard[0].size) { 5 } }
                }
                if (count == (numToWin - 1)) {
                    return true
                }
            }
            count = 0
        }
        return false
    }


    fun checkDraw(): Boolean {
        for (i in 0 until gameBoard[0].size ){
            for (j in 0 until gameBoard[0].size ){
                if(gameBoard[i][j]==5){
                    return false
                }
            }
        }
        return true
    }
}
