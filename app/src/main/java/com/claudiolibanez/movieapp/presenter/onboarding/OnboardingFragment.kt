package com.claudiolibanez.movieapp.presenter.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.claudiolibanez.movieapp.R
import com.claudiolibanez.movieapp.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.buttonStart.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_authentication)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}