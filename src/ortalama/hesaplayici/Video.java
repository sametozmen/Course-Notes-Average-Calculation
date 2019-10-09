package ortalama.hesaplayici;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class Video extends Activity {
	private static String TAG = Video.class.getName();
	public VideoView video;
	private static long SLEEP_TIME = 10; 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN); 
        setContentView(R.layout.video);
        		video=(VideoView) findViewById(R.id.videoView1);
        		Uri adres=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.acilis2);
        		video.setVideoURI(adres);
        		video.start();
        		//run();
        		IntentLauncher launcher = new IntentLauncher();
        		launcher.start();
}
    private class IntentLauncher extends Thread {
	@Override
	public void run() {
	try {
	Thread.sleep(SLEEP_TIME*1000);
	} catch (Exception e) {
	Log.e(TAG, e.getMessage());
	}
	 
	Intent intent = new Intent(Video.this, anasayfa.class);
	Video.this.startActivity(intent);
	Video.this.finish();
	}
}
}