package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    private static final String TAG = Emojifier.class.getSimpleName();

    public static void detectFaces(Context ctx, Bitmap bitmap){

        // Create the face detector
        FaceDetector detector = new FaceDetector.Builder(ctx)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        // Build the frame
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        // Detect the faces
        SparseArray<Face> faces = detector.detect(frame);

        // Log the number of faces
        Log.d(TAG, "detectFaces - number of faces: " + faces.size());

        // If no faces detected, show a toast
        if(faces.size() == 0){
            Toast.makeText(ctx, "No faces detected", Toast.LENGTH_SHORT).show();
        }

        // Release detector
        detector.release();
    }
}
