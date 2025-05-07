package com.example.scienceproject.ui.home

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.scienceproject.MainActivity
import com.example.scienceproject.QuizActivity
import com.example.scienceproject.R
import com.example.scienceproject.TestActivity
import com.example.scienceproject.databinding.FragmentHomeBinding
import kotlin.random.Random

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var physicsQuizButton = view.findViewById<Button>(R.id.physicsQuizButton)
        physicsQuizButton.setText("Physics")
        var biologyQuizButton = view.findViewById<Button>(R.id.biologyQuizButton)
        var chemistyQuizButton = view.findViewById<Button>(R.id.chemistryQuizButton)
        var allQuizButton = view.findViewById<Button>(R.id.allQuizButton)
        var randomQuizButton = view.findViewById<Button>(R.id.randomQuizButton)

        var physicsTestButton = view.findViewById<Button>(R.id.physicsTestButton)
        var biologyTestButton = view.findViewById<Button>(R.id.biologyTestButton)
        var chemistyTestButton = view.findViewById<Button>(R.id.chemistryTestButton)
        var allTestButton = view.findViewById<Button>(R.id.allTestButton)
        var randomTestButton = view.findViewById<Button>(R.id.randomTestButton)

        val quizIntent = Intent(requireContext(),QuizActivity::class.java)
        val testIntent = Intent(requireContext(),TestActivity::class.java)


        physicsQuizButton.setOnClickListener {
            quizIntent.putExtra("testType",1)
            startActivity(quizIntent)
        }
        biologyQuizButton.setOnClickListener {
            quizIntent.putExtra("testType",2)
            startActivity(quizIntent)
        }
        chemistyQuizButton.setOnClickListener {
            quizIntent.putExtra("testType",3)
            startActivity(quizIntent)
        }
        allQuizButton.setOnClickListener {
            quizIntent.putExtra("testType",0)
            startActivity(quizIntent)
        }
        randomQuizButton.setOnClickListener {
            val randomChoice = List(1){Random.nextInt(0,3)}
            quizIntent.putExtra("testType", randomChoice[0])
            startActivity(quizIntent)
        }

        physicsTestButton.setOnClickListener {
            testIntent.putExtra("testType",1)
            startActivity(testIntent)
        }
        biologyTestButton.setOnClickListener {
            testIntent.putExtra("testType",2)
            startActivity(testIntent)
        }
        chemistyTestButton.setOnClickListener {
            testIntent.putExtra("testType",3)
            startActivity(testIntent)
        }
        allTestButton.setOnClickListener {
            testIntent.putExtra("testType",0)
            startActivity(testIntent)
        }
        randomTestButton.setOnClickListener {
            val randomChoice = List(1){Random.nextInt(0,3)}
            testIntent.putExtra("testType", randomChoice[0])
            startActivity(testIntent)
        }

    }
    //fun buttonClick(view:View?)
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}