package com.example.prepnova;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.prepnova.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            String userName = getArguments().getString("USER_NAME", "User");
            binding.tvGreeting.setText("Welcome back, " + userName + "! 👋");
        }

        binding.btnToPlanner.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
        binding.btnToFlashcards.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_ThirdFragment)
        );
        binding.btnToResume.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_ResumeBuilderFragment)
        );
        binding.btnToScanner.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_DocumentScannerFragment)
        );
        binding.btnToInterview.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_InterviewPrepFragment)
        );
        binding.btnToSummarizer.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_NoteSummarizerFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
