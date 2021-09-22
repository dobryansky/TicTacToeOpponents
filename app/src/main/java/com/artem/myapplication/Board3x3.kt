package com.artem.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.artem.myapplication.databinding.FragmentBoard3x3Binding


class Board3x3 : Fragment() {
    private var _binding: FragmentBoard3x3Binding? = null
    private val binding get() = _binding!!
    var gameBoard: Array<Array<Int>> = Array(3) { Array(3) { 5 } }




     //  arrayOf(binding.imgBut1,binding.imgBut2,binding.imgBut3)
    var currentPlayer = 1
    private var logicGame = LogicGame(gameBoard, 3)

    var currentPic = R.drawable.navalny
    var gameOver = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBoard3x3Binding.inflate(inflater, container, false)

        val view = binding.root
        return view


    }

    override fun onResume() {
        super.onResume()
        initListeners()
        if (logicGame.checkDraw()){
            binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
        }
    }

    fun initListeners() {
        val btnArray = arrayOf(
            arrayOf(binding.imgBut1,binding.imgBut2,binding.imgBut3),
            arrayOf(binding.imgBut4,binding.imgBut5,binding.imgBut6),
            arrayOf(binding.imgBut7,binding.imgBut8,binding.imgBut9)
        )



        for (i in 0 until btnArray[0].size) {
            for (j in 0 until btnArray[0].size ){
                    btnArray[i][j].setOnClickListener {
                        btnArray[i][j].setImageResource(currentPic)
                        textTurn()
                        if (currentPlayer == 1) {
                            gameBoard[i][j] = 1
                            println(logicGame.checkWin())
                            if (logicGame.checkWin()) {
                                winPlayer()
                            }
                            if (logicGame.checkDraw()){
                                binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                            }

                        } else {
                            gameBoard[i][j] = 0
                            println(logicGame.checkWin())
                            if (logicGame.checkWin()) {
                                winPlayer()
                            }
                            if (logicGame.checkDraw()){
                                binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                            }

                        }
                        swapPic()
                        showGameBoard(gameBoard)
                        btnArray[i][j].isClickable = false
                    }

        }
    }











        /*binding.txtInfoTable.text = "Ходит Навальный"

        binding.imgBut1.setOnClickListener {
            binding.imgBut1.setImageResource(currentPic)
            textTurn()
            if (currentPlayer == 1) {
                gameBoard[0][0] = 1
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            } else {
                gameBoard[0][0] = 0
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            }
            swapPic()
            showGameBoard(gameBoard)
            binding.imgBut1.isClickable = false


        }
        binding.imgBut2.setOnClickListener {
            binding.imgBut2.setImageResource(currentPic)
            textTurn()
            if (currentPlayer == 1) {
                gameBoard[0][1] = 1
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            } else {
                gameBoard[0][1] = 0
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            }
            swapPic()

            showGameBoard(gameBoard)
            binding.imgBut2.isClickable = false


        }
        binding.imgBut3.setOnClickListener {
            binding.imgBut3.setImageResource(currentPic)
            textTurn()
            if (currentPlayer == 1) {
                gameBoard[0][2] = 1
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            } else {
                gameBoard[0][2] = 0
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            }
            swapPic()
            showGameBoard(gameBoard)
            binding.imgBut3.isClickable = false


        }
        binding.imgBut4.setOnClickListener {
            binding.imgBut4.setImageResource(currentPic)
            textTurn()
            if (currentPlayer == 1) {
                gameBoard[1][0] = 1
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            } else {
                gameBoard[1][0] = 0
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            }
            swapPic()
            showGameBoard(gameBoard)
            binding.imgBut4.isClickable = false

        }
        binding.imgBut5.setOnClickListener {
            binding.imgBut5.setImageResource(currentPic)
            textTurn()
            if (currentPlayer == 1) {
                gameBoard[1][1] = 1
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            } else {
                gameBoard[1][1] = 0
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            }
            swapPic()
            showGameBoard(gameBoard)
            binding.imgBut5.isClickable = false


        }
        binding.imgBut6.setOnClickListener {
            binding.imgBut6.setImageResource(currentPic)
            textTurn()
            if (currentPlayer == 1) {
                gameBoard[1][2] = 1
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            } else {
                gameBoard[1][2] = 0
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            }
            swapPic()
            showGameBoard(gameBoard)
            binding.imgBut6.isClickable = false

        }
        binding.imgBut7.setOnClickListener {
            binding.imgBut7.setImageResource(currentPic)
            textTurn()
            if (currentPlayer == 1) {
                gameBoard[2][0] = 1
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            } else {
                gameBoard[2][0] = 0
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            }
            swapPic()
            showGameBoard(gameBoard)
            binding.imgBut7.isClickable = false

        }
        binding.imgBut8.setOnClickListener {
            binding.imgBut8.setImageResource(currentPic)
            textTurn()
            if (currentPlayer == 1) {
                gameBoard[2][1] = 1
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            } else {
                gameBoard[2][1] = 0
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            }
            swapPic()
            showGameBoard(gameBoard)
            binding.imgBut8.isClickable = false

        }
        binding.imgBut9.setOnClickListener {
            binding.imgBut9.setImageResource(currentPic)
            textTurn()
            if (currentPlayer == 1) {
                gameBoard[2][2] = 1
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            } else {
                gameBoard[2][2] = 0
                println(logicGame.checkWin())
                if (logicGame.checkWin()) {
                    winPlayer()
                }
                if (logicGame.checkDraw()){
                    binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                }

            }
            swapPic()
            showGameBoard(gameBoard)
            binding.imgBut9.isClickable = false

        }*/

        binding.btnReset.setOnClickListener {
            gameBoard = Array(3) { Array(3) { 5 } }
            showGameBoard(gameBoard)
            resetBoard()

        }


    }

    fun swapPic() {
        if (currentPlayer == 1) {
            currentPic = R.drawable.putin
            currentPlayer = 0
        } else {
            currentPic = R.drawable.navalny
            currentPlayer = 1
        }
    }

    fun textTurn() {
        if (currentPlayer == 1) {
            binding.txtInfoTable.text = "Ходит Путин"

        } else {
            binding.txtInfoTable.text = "Ходит Навальный"
        }
    }

    fun resetBoard() {
        binding.imgBut1.setImageResource(0)
        binding.imgBut2.setImageResource(0)
        binding.imgBut3.setImageResource(0)
        binding.imgBut4.setImageResource(0)
        binding.imgBut5.setImageResource(0)
        binding.imgBut6.setImageResource(0)
        binding.imgBut7.setImageResource(0)
        binding.imgBut8.setImageResource(0)
        binding.imgBut9.setImageResource(0)
        binding.imgBut1.setBackgroundColor(resources.getColor(R.color.greybackgroung))
        binding.imgBut2.setBackgroundColor(resources.getColor(R.color.greybackgroung))
        binding.imgBut3.setBackgroundColor(resources.getColor(R.color.greybackgroung))
        binding.imgBut4.setBackgroundColor(resources.getColor(R.color.greybackgroung))
        binding.imgBut5.setBackgroundColor(resources.getColor(R.color.greybackgroung))
        binding.imgBut6.setBackgroundColor(resources.getColor(R.color.greybackgroung))
        binding.imgBut7.setBackgroundColor(resources.getColor(R.color.greybackgroung))
        binding.imgBut8.setBackgroundColor(resources.getColor(R.color.greybackgroung))
        binding.imgBut9.setBackgroundColor(resources.getColor(R.color.greybackgroung))
        binding.imgBut1.isClickable = true
        binding.imgBut2.isClickable = true
        binding.imgBut3.isClickable = true
        binding.imgBut4.isClickable = true
        binding.imgBut5.isClickable = true
        binding.imgBut6.isClickable = true
        binding.imgBut7.isClickable = true
        binding.imgBut8.isClickable = true
        binding.imgBut9.isClickable = true
        currentPlayer = 1
        currentPic = R.drawable.navalny
        gameBoard = Array(3) { Array(3) { 5 } }
        showGameBoard(gameBoard)
        logicGame = LogicGame(gameBoard, 3)
        binding.txtInfoTable.text = "Ходит Навальный"

    }

    fun showGameBoard(table: Array<Array<Int>>) {
        for (row in table) {
            for (cell in row) {
                print("$cell")
            }
            println()
        }
    }

    fun gameOver() {
        binding.imgBut1.isClickable = false
        binding.imgBut2.isClickable = false
        binding.imgBut3.isClickable = false
        binding.imgBut4.isClickable = false
        binding.imgBut5.isClickable = false
        binding.imgBut6.isClickable = false
        binding.imgBut7.isClickable = false
        binding.imgBut8.isClickable = false
        binding.imgBut9.isClickable = false
    }

    fun winPlayer() {
        val btnArray = arrayOf(
            arrayOf(binding.imgBut1,binding.imgBut2,binding.imgBut3),
            arrayOf(binding.imgBut4,binding.imgBut5,binding.imgBut6),
            arrayOf(binding.imgBut7,binding.imgBut8,binding.imgBut9)
        )
        if (currentPlayer == 1) {
            binding.txtInfoTable.text = "Победил Навальный"

            for (i in 0 until logicGame.winArray.size) {
                for (j in 0 until logicGame.winArray.size) {
                    if(logicGame.winArray[i][j]==1){
                        btnArray[i][j].setBackgroundColor(resources.getColor(R.color.green))
                    }

                }

            }

            gameOver()
        } else {
            binding.txtInfoTable.text = "Победил Путин"
            for (i in 0 until logicGame.winArray.size) {
                for (j in 0 until logicGame.winArray.size) {
                    if(logicGame.winArray[i][j]==1){
                        btnArray[i][j].setBackgroundColor(resources.getColor(R.color.green))
                    }

                }

            }
            gameOver()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}