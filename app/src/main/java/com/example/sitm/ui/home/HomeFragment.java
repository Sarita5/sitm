package com.example.sitm.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.sitm.R;
import com.example.sitm.databinding.FragmentHomeBinding;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        textView.setText("_Welcome \n Sagar Insitute of \n Technology and Management");
        ImageSlider imageSlider=root.findViewById(R.id.slider);
        List<SlideModel>slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.getmyuni.com%2Fcollege%2Fsagar-institute-of-technology-and-management-sitm-barabanki-images-videos&psig=AOvVaw3IW9x7Zw04r7msQdLUVjXI&ust=1646734431651000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKC217Dis_YCFQAAAAAdAAAAABAD", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.getmyuni.com%2Fcollege%2Fsagar-institute-of-technology-and-management-sitm-barabanki-images-videos&psig=AOvVaw3IW9x7Zw04r7msQdLUVjXI&ust=1646734431651000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKC217Dis_YCFQAAAAAdAAAAABAD", ScaleTypes.CENTER_CROP));slideModels.add(new SlideModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.getmyuni.com%2Fcollege%2Fsagar-institute-of-technology-and-management-sitm-barabanki-images-videos&psig=AOvVaw3IW9x7Zw04r7msQdLUVjXI&ust=1646734431651000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKC217Dis_YCFQAAAAAdAAAAABAD", ScaleTypes.CENTER_CROP));slideModels.add(new SlideModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.getmyuni.com%2Fcollege%2Fsagar-institute-of-technology-and-management-sitm-barabanki-images-videos&psig=AOvVaw3IW9x7Zw04r7msQdLUVjXI&ust=1646734431651000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKC217Dis_YCFQAAAAAdAAAAABAD", ScaleTypes.CENTER_CROP));slideModels.add(new SlideModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.getmyuni.com%2Fcollege%2Fsagar-institute-of-technology-and-management-sitm-barabanki-images-videos&psig=AOvVaw3IW9x7Zw04r7msQdLUVjXI&ust=1646734431651000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKC217Dis_YCFQAAAAAdAAAAABAD", ScaleTypes.CENTER_CROP));slideModels.add(new SlideModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.getmyuni.com%2Fcollege%2Fsagar-institute-of-technology-and-management-sitm-barabanki-images-videos&psig=AOvVaw3IW9x7Zw04r7msQdLUVjXI&ust=1646734431651000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKC217Dis_YCFQAAAAAdAAAAABAD", ScaleTypes.CENTER_CROP));slideModels.add(new SlideModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.getmyuni.com%2Fcollege%2Fsagar-institute-of-technology-and-management-sitm-barabanki-images-videos&psig=AOvVaw3IW9x7Zw04r7msQdLUVjXI&ust=1646734431651000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKC217Dis_YCFQAAAAAdAAAAABAD", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.getmyuni.com%2Fcollege%2Fsagar-institute-of-technology-and-management-sitm-barabanki-images-videos&psig=AOvVaw3IW9x7Zw04r7msQdLUVjXI&ust=1646734431651000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKC217Dis_YCFQAAAAAdAAAAABAD", ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(slideModels,ScaleTypes.CENTER_CROP);
       /* homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}