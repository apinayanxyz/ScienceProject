package com.example.scienceproject.ui.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.scienceproject.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    private var _binding: FragmentScoreBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val scoreViewModel =
            ViewModelProvider(this).get(ScoreViewModel::class.java)

        _binding = FragmentScoreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val totalScoreTextView: TextView = binding.yourTotalScore
        totalScoreTextView.text= GlobalVar.score.toString()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}