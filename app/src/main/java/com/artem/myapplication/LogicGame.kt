package com.artem.myapplication

class LogicGame(var gameBoard: Array<Array<Int>>, val numToWin: Int) {



    fun checkWin(): Boolean {
        return checkColumns() || checkRows() || checkDiagonal()
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

    fun checkDiagonal(): Boolean {
        var count = 0
        for (i in 0 until gameBoard[0].size - 1) {
            if (gameBoard[i][i] == gameBoard[i + 1][i + 1] && (gameBoard[i][i] == 0 || gameBoard[i][i] == 1)) {
                count++
            } else {
                count = 0
            }
            if (count == (numToWin - 1)) return true
        }
        count = 0
        for (i in 0 until gameBoard[0].size - 1) {

            if (gameBoard[i][gameBoard[0].size - 1 - i] == gameBoard[i + 1][gameBoard[0].size - 2 - i] && ((gameBoard[i][gameBoard[0].size - 1 - i] == 0) || gameBoard[i][gameBoard[0].size - 1 - i] == 1)) {
                count++
            } else {
                count = 0
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
                    count++
                } else {
                    count = 0
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
                    count++
                } else {
                    count = 0
                }
                if (count == (numToWin - 1)) {
                    return true
                }
            }
            count = 0
        }
        return false
    }
}
