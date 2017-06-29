//package com.dai;
//
//import android.graphics.Bitmap;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.media.AudioFormat;
//import android.media.AudioRecord;
//import android.media.MediaRecorder;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//
///**
// * Created by dai on 2017/6/28.
// */
//
//public class TestActivity extends AppCompatActivity {
//    private Button button;
//    private ImageView imageView;
//    private int frequency = 8000;
//    private int channelConfiguration = AudioFormat.CHANNEL_CONFIGURATION_MONO;
//    private int audioEncoding = AudioFormat.ENCODING_PCM_16BIT;
//    private RealDoubleFFT transformer;
//    private int blockSize = 256;
//    private boolean started = false;
//    private Canvas canvas;
//    private Paint paint;
//    private Bitmap bitmap;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fft);
//        button = (Button) findViewById(R.id.fft_button);
//        button.setOnClickListener(this);
//        imageView = (ImageView) findViewById(R.id.fft_imageView);
//        transformer = new RealDoubleFFT(blockSize);
//        bitmap = Bitmap.createBitmap(256, 100, Bitmap.Config.ARGB_8888);
//        canvas = new Canvas(bitmap);
//        paint = new Paint();
//        paint.setColor(Color.GREEN);
//        imageView.setImageBitmap(bitmap);
//    }
//
//    private class RecordAudio extends AsyncTask<Void, double[], Void> {
//        @Override
//        protected Void doInBackground(Void... params) {
//            int bufferSize = AudioRecord.getMinBufferSize(frequency,
//                    channelConfiguration, audioEncoding);
//            AudioRecord audioRecord = new AudioRecord(
//                    MediaRecorder.AudioSource.MIC, frequency,
//                    channelConfiguration, audioEncoding, bufferSize);
//            short[] buffer = new short[blockSize];
//            double[] toTransform = new double[blockSize];
//            audioRecord.startRecording();
//            while (started) {
////将record的数据 读到buffer中，但是我认为叫做write可能会比较合适些。
//                int bufferResult = audioRecord.read(buffer, 0, blockSize);
//                for (int i = 0; i < bufferResult; i++) {
//                    toTransform[i] = (double) buffer[i] / Short.MAX_VALUE;
//                }
//                transformer.ft(toTransform);
//                publishProgress(toTransform);
//            }
//            audioRecord.stop();
//            return null;
//        }
//
//        @Override
//        protected void onProgressUpdate(double[]... values) {
//            super.onProgressUpdate(values);
//            canvas.drawColor(Color.BLACK);
//            for (int i = 0; i < values[0].length; i++) {
//                int x = i;
//                int downy = (int) (100 - (values[0][i]) * 10);
//                int upy = 100;
//                canvas.drawLine(x, downy, x, upy, paint);
//            }
//            imageView.invalidate();
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//        started = true;
//        new RecordAudio().execute();
//    }
//}
