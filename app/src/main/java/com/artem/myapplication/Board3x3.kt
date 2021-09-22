package com.artem.myapplication

import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageButton
import androidx.core.content.res.ResourcesCompat
import com.artem.myapplication.databinding.FragmentBoard3x3Binding
import java.util.*


class Board3x3 : Fragment() {
    private var _binding: FragmentBoard3x3Binding? = null
    private val binding get() = _binding!!
    var gameBoard: Array<Array<Int>> = Array(3) { Array(3) { 5 } }
    var currentPlayer = 1
    var countWinPutin=0
    var countWinNavalny=0
    private var logicGame = LogicGame(gameBoard, 3)
    var currentPic = R.drawable.navalny


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBoard3x3Binding.inflate(inflater, container, false)
        val view = binding.root
        //   (activity as MainActivity).supportActionBar?.hide()
        return view
    }

    override fun onResume() {
        super.onResume()
        initListeners()
        if (logicGame.checkDraw()) {
            binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
        }
    }

    fun initListeners() {
        val btnArray = arrayOf(
            arrayOf(binding.imgBut1, binding.imgBut2, binding.imgBut3),
            arrayOf(binding.imgBut4, binding.imgBut5, binding.imgBut6),
            arrayOf(binding.imgBut7, binding.imgBut8, binding.imgBut9)
        )

        for (i in 0 until btnArray[0].size) {
            for (j in 0 until btnArray[0].size) {
                btnArray[i][j].setOnClickListener {
                    btnArray[i][j].setImageResource(currentPic)
                    textTurn()
                    if (currentPlayer == 1) {
                        gameBoard[i][j] = 1
                        println(logicGame.checkWin())
                        if (logicGame.checkWin()) {
                            winPlayer()
                        } else if (logicGame.checkDraw()) {
                            binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                        }


                    } else {
                        gameBoard[i][j] = 0
                        println(logicGame.checkWin())
                        if (logicGame.checkWin()) {
                            winPlayer()
                        } else if (logicGame.checkDraw()) {
                            binding.txtInfoTable.text = "Ничья,ёпта!!!!!"
                        }

                    }
                    swapPic()
                    //showGameBoard(gameBoard)
                    btnArray[i][j].isClickable = false
                }

            }
        }

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
        val btnArray = arrayOf(
            arrayOf(binding.imgBut1, binding.imgBut2, binding.imgBut3),
            arrayOf(binding.imgBut4, binding.imgBut5, binding.imgBut6),
            arrayOf(binding.imgBut7, binding.imgBut8, binding.imgBut9)
        )

        for (i in 0 until btnArray[0].size) {
            for (j in 0 until btnArray[0].size) {
                btnArray[i][j].setImageResource(0)
                btnArray[i][j].background = resources.getDrawable(R.drawable.tricolor)
                btnArray[i][j].isClickable = true
            }
        }

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
            arrayOf(binding.imgBut1, binding.imgBut2, binding.imgBut3),
            arrayOf(binding.imgBut4, binding.imgBut5, binding.imgBut6),
            arrayOf(binding.imgBut7, binding.imgBut8, binding.imgBut9)
        )
        showGameBoard(logicGame.winArray)
        if (currentPlayer == 1) {
            binding.txtInfoTable.text = "Победил Навальный"

            for (i in 0 until logicGame.winArray.size) {
                for (j in 0 until logicGame.winArray.size) {
                    if (logicGame.winArray[i][j] == 1) {
                        btnArray[i][j].setBackgroundColor(resources.getColor(R.color.green))
                    }
                    if (logicGame.gameBoard[i][j] == 1) {
                        btnArray[i][j].setImageResource(R.drawable.navalnysmile)
                    }
                    if (logicGame.gameBoard[i][j] == 0) {
                        btnArray[i][j].setImageResource(R.drawable.putinjail)
                    }

                }

            }
            countWinNavalny++
            binding.txtScore1.text=countWinNavalny.toString()
            playSound()
            gameOver()
        } else {
            binding.txtInfoTable.text = "Победил Путин"
            for (i in 0 until logicGame.winArray.size) {
                for (j in 0 until logicGame.winArray.size) {
                    if (logicGame.winArray[i][j] == 1) {
                        btnArray[i][j].setBackgroundColor(resources.getColor(R.color.green))
                    }
                    if (logicGame.gameBoard[i][j] == 0) {
                        btnArray[i][j].setImageResource(R.drawable.putinsmile)
                    }
                    if (logicGame.gameBoard[i][j] == 1) {
                        btnArray[i][j].setImageResource(R.drawable.navalnyjail)
                    }

                }

            }
            countWinPutin++
            binding.txtScore2.text=countWinPutin.toString()
            playSound()
            gameOver()
        }
    }

    fun playSound() {
        val navalnySound =
            arrayOf(R.raw.navalny_corupcia, R.raw.navalny_dalshe, R.raw.navalny_sidet)
        val putinSound = arrayOf(R.raw.putin_derzki, R.raw.putin_parasha)

        if (currentPlayer == 1) {

            val mp: MediaPlayer = MediaPlayer.create(context, navalnySound[(0..2).random()])
            mp.setOnPreparedListener {
                mp.start()
            }
            mp.setOnCompletionListener {
                mp.release()
            }
        } else {
            val mp: MediaPlayer = MediaPlayer.create(context, putinSound[(0..1).random()])
            mp.setOnPreparedListener {
                mp.start()
            }
            mp.setOnCompletionListener {
                mp.release()
            }

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}