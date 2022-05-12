package com.example.socialmediagamer.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.socialmediagamer.R;
import com.example.socialmediagamer.providers.AuthProvider;
import com.example.socialmediagamer.providers.PostProvider;
import com.example.socialmediagamer.providers.UserProvider;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    LinearLayout mLinearLayoutEditProfile;
    View mView;
    TextView mTextViewUsername;
    TextView mTextViewPhone;
    TextView mTextViewEmail;
    TextView mTextViewPostNumber;
    ImageView mImageViewCover;
    CircleImageView mImageViewProfile;

    UserProvider mUserProvider;
    AuthProvider mAuthProvider;
    PostProvider mPostProvider;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_profile, container, false);
        mUserProvider = new UserProvider();
        mAuthProvider = new AuthProvider();
        mTextViewEmail = mView.findViewById(R.id.textViewEmail);
        mTextViewPostNumber = mView.findViewById(R.id.textViewPostNumber);
        mImageViewCover = mView.findViewById(R.id.imageViewCover);
        mImageViewProfile = mView.findViewById(R.id.circleImageProfile);
        mTextViewPhone = mView.findViewById(R.id.textViewphone);
        mTextViewUsername = mView.findViewById(R.id.textViewUsername);

        getUser();
        getPostNumber();
        return mView;
    }

    private void getPostNumber(){
    mPostProvider.getPostByUser(mAuthProvider.getUid()).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
        @Override
        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
            int numberPost = queryDocumentSnapshots.size();
            mTextViewPostNumber.setText(String.valueOf(numberPost));
        }
    });
    }

    private void getUser(){
        mUserProvider.getUser(mAuthProvider.getUid()).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                 if(documentSnapshot.contains("email")){
                    String email = documentSnapshot.getString("email");
                    mTextViewEmail.setText(email);

                 }
                if(documentSnapshot.contains("phone")){
                    String phone = documentSnapshot.getString("phone");
                    mTextViewPhone.setText(phone);

                }
                if(documentSnapshot.contains("username")){
                    String username = documentSnapshot.getString("username");
                    mTextViewUsername.setText(username);

                }
                if(documentSnapshot.contains("email")){
                    String email = documentSnapshot.getString("email");
                    mTextViewEmail.setText(email);

                }
                if(documentSnapshot.contains("image_profile")){
                    String imageProfile = documentSnapshot.getString("image_profile");
                    if(imageProfile !=null){
                        if(!imageProfile.isEmpty()){
                            Picasso.with(getContext()).load(imageProfile).into(mImageViewProfile);
                        }
                    }
                }

                if(documentSnapshot.contains("image_cover")){
                    String imageCover = documentSnapshot.getString("image_cover");
                    if(imageCover !=null){
                        if(!imageCover.isEmpty()){
                            Picasso.with(getContext()).load(imageCover).into(mImageViewCover);
                        }
                    }
                }

            }
        });
    }
}