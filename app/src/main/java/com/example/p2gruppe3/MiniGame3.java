package com.example.p2gruppe3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MiniGame3 extends View {

    Bitmap avocado;
    Bitmap toast;
    Bitmap pot;

    Bitmap scaledAvocado;
    float avocadoX;
    float avocadoY;
    float scaledAvocadoX;
    float scaledAvocadoY;
    float toastX;
    float toastY;
    float potX;
    float potY;
    float cellSize;

    int viewWidth;
    int viewHeight;

    int numRows;
    int numCols;
    int currentRow;
    int currentCol;
    int touchCol;
    int touchRow;
    float scaledWidth;
    float scaledHeight;



    private int[][] walls =
            {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1},
                    {1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                    {1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                    {1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                    {1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1},
                    {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1},
                    {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                    {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},


            };


    public MiniGame3(Context context, AttributeSet attrs) {
        super(context, attrs);
        avocado = BitmapFactory.decodeResource(context.getResources(), R.drawable.avocado);
        toast = BitmapFactory.decodeResource(context.getResources(), R.drawable.toast);
        pot = BitmapFactory.decodeResource(context.getResources(), R.drawable.pot);

    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Get the dimensions of the view
        viewWidth = getWidth();
        viewHeight = getHeight();

        // Calculate the number of rows and columns based on the view dimensions
        numRows = walls.length;
        numCols = walls[0].length;
        cellSize = Math.min(viewWidth / (float) numCols, viewHeight / (float) numRows);
        //avocadoX = cellSize * 2;
        //avocadoY = cellSize * 4;
        toastX = cellSize;
        toastY = cellSize * 15;
        potX = cellSize * 9;
        potY = cellSize * 15;


        // Draw the labyrinth
        Paint wallPaint = new Paint();
        wallPaint.setColor(Color.LTGRAY);
        wallPaint.setStyle(Paint.Style.FILL);
        wallPaint.setStrokeWidth(cellSize / 5);

        Paint pathPaint = new Paint();
        pathPaint.setColor(Color.WHITE);
        pathPaint.setStyle(Paint.Style.FILL);

        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        redPaint.setStyle(Paint.Style.FILL);


        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                float left = col * cellSize;
                float top = 2 * cellSize + row * cellSize;
                float right = left + cellSize;
                float bottom = top + cellSize;

                if (walls[row][col] == 1) {
                    canvas.drawRect(left, top, right, bottom, wallPaint);
                } else {
                    canvas.drawRect(left, top, right, bottom, pathPaint);
                }
                if (row==touchRow && col==touchCol)
                {
                    canvas.drawRect(left, top, right, bottom, redPaint);
                }
            }
        }

        scaledWidth = cellSize * 3 / 4; // 3/4 of cellSize
        scaledHeight = cellSize * 3 / 4; // 3/4 of cellSize
        scaledAvocado = Bitmap.createScaledBitmap(avocado, (int) scaledWidth, (int) scaledHeight, false);
        scaledAvocadoX = avocadoX + (cellSize*2) - scaledAvocado.getWidth()/2;
        scaledAvocadoY = avocadoY + (cellSize*4) - scaledAvocado.getHeight()/2;


        //Rect avocadoPosition = new Rect((int) avocadoX-avocado.getWidth() / 2, (int) avocadoY-avocado.getWidth() / 2, (int) (avocadoX + cellSize/1.5), (int) (avocadoY + cellSize/1.5));
        //canvas.drawBitmap(avocado, null, avocadoPosition, null);
        //canvas.drawBitmap(avocado, avocadoX - avocado.getWidth() / 2, avocadoY - avocado.getHeight() / 2, null);
        canvas.drawBitmap(scaledAvocado, scaledAvocadoX, scaledAvocadoY, null);

        Rect toastPosition = new Rect((int) toastX, (int) toastY, (int) (toastX + cellSize), (int) (toastY + cellSize));
        canvas.drawBitmap(toast, null, toastPosition, null);

        Rect potPosition = new Rect((int) potX, (int) potY, (int) (potX + cellSize), (int) (potY + cellSize));
        canvas.drawBitmap(pot, null, potPosition, null);

        // Calculate the bounding boxes of the avocado, pot, and toast bitmaps
        Rect avocadoRect = new Rect(
                (int)scaledAvocadoX,
                (int)scaledAvocadoY,
                (int)(scaledAvocadoX + scaledWidth),
                (int)(scaledAvocadoY + scaledHeight)
        );


        // Check if the avocado bitmap overlaps with the pot or toast bitmaps
        if (avocadoRect.intersect(toastPosition)) {
            // Show an alert dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("The avocado was still edible! You can still plant the seed nonetheless.").setTitle("Congratulations");
            builder.setPositiveButton("Go to catalog", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Restart the game
                    //resetGame();
                }
            });
            builder.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Quit the game
                    ((Activity) getContext()).finish();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        if (avocadoRect.intersect(potPosition)) {
            // Show an alert dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("The avocado was still edible. You could have eaten it before planting the seed.").setTitle("Too bad");
            builder.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Restart the game
                    //resetGame();
                }
            });
            builder.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Quit the game
                    ((Activity) getContext()).finish();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }



    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            float touchX = event.getX();
            float touchY = event.getY();
            int viewPosition[] = new int[2];
            getLocationOnScreen(viewPosition);
            touchCol = (int) ((touchX-viewPosition[0])/cellSize);
            touchRow = (int) ((touchY-viewPosition[1])/cellSize);


            // Check if the touch event is within a certain distance from the avocado
            if (Math.abs(touchX - scaledAvocadoX) < cellSize/0.9 && Math.abs(touchY - scaledAvocadoY) < cellSize/0.9 && walls[touchRow][touchCol] == 0) {
                // Update the avocado position
                avocadoX = touchX - (cellSize*2);
                avocadoY = touchY - (cellSize*4);


                //walls[touchRow][touchCol] == 0


                //Sammenlign og se om position svarer til [0] i array ellers ikke flytte

                // Invalidate the view to redraw the avocado
                invalidate();
            }
        }
        return true;
    }
}

