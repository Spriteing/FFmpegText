package example.jiege.ncrf.ffmpegtext;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.vise.log.ViseLog;
import com.vise.log.inner.LogcatTree;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("avutil-54");
        System.loadLibrary("swresample-1");
        System.loadLibrary("avcodec-56");
        System.loadLibrary("avformat-56");
        System.loadLibrary("swscale-3");
        System.loadLibrary("postproc-53");
        System.loadLibrary("avfilter-5");
        System.loadLibrary("avdevice-56");
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViseLog.getLogConfig().configAllowLog(true);//配置日志信息
        ViseLog.plant(new LogcatTree());//添加Logcat打印信息

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        String input = new File(Environment.getExternalStorageDirectory(), "video1.mp4").getAbsolutePath();
        String output = new File(Environment.getExternalStorageDirectory(), "output_1280x720_yuv420p.yuv").getAbsolutePath();
        VideoUtils videoUtils = new VideoUtils();
        videoUtils.decode1(input, output);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
