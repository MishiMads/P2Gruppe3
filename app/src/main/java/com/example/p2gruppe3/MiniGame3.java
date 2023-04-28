package com.example.p2gruppe3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MiniGame3 extends View {

        private Bitmap avocadoBitmap;
        private Bitmap toastBitmap;
        private Bitmap trashBitmap;
        private Rect labyrinthRect;
        private Rect avocadoRect;
        private Rect toastRect;
        private Rect trashRect;
        private int avocadoX;
        private int avocadoY;
        private boolean isExpired;

        public MiniGame3(Context context) {
            super(context);
            init();
        }

        public MiniGame3(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        private void init() {
            // Load bitmaps for the avocado, toast, and trash can
            avocadoBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avocado);
            toastBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.toast);
            trashBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pot);

            // Set up rectangles for the labyrinth, avocado, toast, and trash can
            labyrinthRect = new Rect(100, 100, 700, 700);
            avocadoRect = new Rect(150, 150, 250, 250);
            toastRect = new Rect(600, 150, 700, 250);
            trashRect = new Rect(600, 600, 700, 700);

            // Set the initial position of the avocado
            avocadoX = avocadoRect.centerX();
            avocadoY = avocadoRect.centerY();

            // Set the initial expiration state of the avocado
            isExpired = false;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            // Draw the labyrinth
            Paint labyrinthPaint = new Paint();
            labyrinthPaint.setColor(Color.BLACK);
            labyrinthPaint.setStyle(Paint.Style.STROKE);
            labyrinthPaint.setStrokeWidth(10);
            canvas.drawRect(labyrinthRect, labyrinthPaint);

            // Draw the avocado
            canvas.drawBitmap(avocadoBitmap, avocadoX - avocadoBitmap.getWidth() / 2, avocadoY - avocadoBitmap.getHeight() / 2, null);

            // Draw the toast and trash can
            canvas.drawBitmap(toastBitmap, toastRect.left, toastRect.top, null);
            canvas.drawBitmap(trashBitmap, trashRect.left, trashRect.top, null);
        }

        /*@Override
        public boolean onTouchEvent(MotionEvent event) {
            boolean handled = false;
            int action = event.getActionMasked();
            if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE) {
                // Move the avocado to the touch position
                avocadoX = (int) event.getX();
                avocadoY = (int) event.getY();
                invalidate();
                handled = true;
            } else if (action == MotionEvent.ACTION_UP) {
                // Determine whether the avocado is on the toast or trash can
                if (toastRect.contains(avocadoX, avocadoY)) {
                    // Avocado is on the toast
                    if (isExpired) {
                        // Display a message that the player lost
                        Toast.makeText(getContext(), "Sorry, the avocado is expired!", Toast.LENGTH_SHORT).show();
                    } else {
                        // Display a message that the player won
                        Toast.makeText(getContext(), "Congratulations, you made some delicious avocado toast!", Toast.LENGTH_SHORT).show();
                    }
                } else if (trashRect.contains(avocadoX, avocadoY)) {
                    // Avocado is in the trash
                    if (isExpired) {
                        // Display a message that the player won
                        Toast.makeText(getContext(), "Congratulations, you correctly identified the expired avocado!", Toast.LENGTH_SHORT).show();
                    } else {
                        // Display a message that the player lost
                        Toast.makeText(getContext(), "Sorry, that avocado was not expired!", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        }
    }
*/
}



