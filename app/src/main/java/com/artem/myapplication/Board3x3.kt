package com.artem.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artem.myapplication.databinding.FragmentBoard3x3Binding


class Board3x3 : Fragment() {
    private var _binding: FragmentBoard3x3Binding? = null
    private val binding get() = _binding!!

    val idsBtn = arrayOf(
        R.id.imgBut1, R.id.imgBut2, R.id.imgBut3,
        R.id.imgBut4, R.id.imgBut5, R.id.imgBut6,
        R.id.imgBut7, R.id.imgBut8, R.id.imgBut9
    )

    val gameBoard: Array<Array<Int>> = Array(3) { Array(3) { 5 } }


    val Player_O = 1
    val Player_X = 2
    var currentPlayer = 1
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
    }

    fun initListeners() {
        binding.txtInfoTable.text = "Ходит Навальный"

        binding.imgBut1.setOnClickListener {
            if (currentPlayer==1){
                gameBoard[0][0]=1
            } else{
                gameBoard[0][0]=0
            }
            showGameBoard(gameBoard)
            swapPic()
            binding.imgBut1.setImageResource(currentPic)
            binding.imgBut1.isClickable = false


        }
        binding.imgBut2.setOnClickListener {

            if (currentPlayer==1){
                gameBoard[0][1]=1
            } else{
                gameBoard[0][1]=0
            }
            showGameBoard(gameBoard)
            swapPic()
            binding.imgBut2.setImageResource(currentPic)
            binding.imgBut2.isClickable = false

        }
        binding.imgBut3.setOnClickListener {
            if (currentPlayer==1){
                gameBoard[0][2]=1
            } else{
                gameBoard[0][2]=0
            }
            showGameBoard(gameBoard)
            swapPic()
            binding.imgBut3.setImageResource(currentPic)
            binding.imgBut3.isClickable = false

        }
        binding.imgBut4.setOnClickListener {
            swapPic()
            binding.imgBut4.setImageResource(currentPic)
            binding.imgBut4.isClickable = false

        }
        binding.imgBut5.setOnClickListener {
            swapPic()
            binding.imgBut5.setImageResource(currentPic)
            binding.imgBut5.isClickable = false


        }
        binding.imgBut6.setOnClickListener {
            swapPic()
            binding.imgBut6.setImageResource(currentPic)
            binding.imgBut6.isClickable = false

        }
        binding.imgBut7.setOnClickListener {
            swapPic()
            binding.imgBut7.setImageResource(currentPic)
            binding.imgBut7.isClickable = false

        }
        binding.imgBut8.setOnClickListener {
            swapPic()
            binding.imgBut8.setImageResource(currentPic)
            binding.imgBut8.isClickable = false

        }
        binding.imgBut9.setOnClickListener {
            swapPic()
            binding.imgBut9.setImageResource(currentPic)
            binding.imgBut9.isClickable = false

        }

        binding.btnReset.setOnClickListener {
            resetBoard()

        }


    }

    fun swapPic() {
        if (currentPlayer == 1) {
            currentPic = R.drawable.navalny
            binding.txtInfoTable.text = "Ходит Путин"
            currentPlayer = 2
        } else {
            currentPic = R.drawable.putin
            binding.txtInfoTable.text = "Ходит Навальный"
            currentPlayer = 1
        }
    }

    fun resetBoard()  {
        binding.imgBut1.setImageResource(0)
        binding.imgBut2.setImageResource(0)
        binding.imgBut3.setImageResource(0)
        binding.imgBut4.setImageResource(0)
        binding.imgBut5.setImageResource(0)
        binding.imgBut6.setImageResource(0)
        binding.imgBut7.setImageResource(0)
        binding.imgBut8.setImageResource(0)
        binding.imgBut9.setImageResource(0)
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

    }

    fun showGameBoard(table: Array<Array<Int>>) {
        for (row in table) {
            for (cell in row) {
                print("$cell")
            }
            println()
        }
    }

    fun playerTurn(){

        if (currentPlayer==1){

        } else{

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}