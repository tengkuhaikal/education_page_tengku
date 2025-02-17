package com.example.educationpeacemy;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.educationpeacemy.databinding.ActivityDetailedBinding;

public class DetailedActivity extends AppCompatActivity {

    ActivityDetailedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detailed);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = this.getIntent();

        if (intent != null) {
            int name = intent.getIntExtra("name", 0);
            int image = intent.getIntExtra("image", R.drawable.diabetes_mellitus);
            int desc = intent.getIntExtra("desc", R.string.diabetes_desc);
            int symptoms = intent.getIntExtra("symptoms", R.string.diabetes_symptoms);
            int treatment = intent.getIntExtra("treatment", R.string.diabetes_treatment);

            binding.detailedName.setText(name);
            binding.detailedImage.setImageResource(image);
            binding.detailedDescription.setText(desc);
            binding.detailedSymptoms.setText(symptoms);
            binding.detailedTreatment.setText(treatment);

        }
    }
}