package ortalama.hesaplayici;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Mail extends Activity {

	private EditText recipient;
	private EditText subject;
	private EditText body;
	
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.mail);

      recipient = (EditText) findViewById(R.id.recipient);
      subject = (EditText) findViewById(R.id.subject);
      body = (EditText) findViewById(R.id.body);
      recipient.setVisibility(View.VISIBLE);
      Button sendBtn = (Button) findViewById(R.id.sendEmail);
      sendBtn.setOnClickListener(new View.OnClickListener() {
         public void onClick(View view) {
        	 sendEmail();
        	 recipient.setText("");
        	 subject.setText("");
        	 body.setText("");
         }
   });

   }
   protected void sendEmail() {

      String[] recipients = {recipient.getText().toString()};
      Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
      email.setType("message/rfc822");

      email.putExtra(Intent.EXTRA_EMAIL, recipients);
      email.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
      email.putExtra(Intent.EXTRA_TEXT, body.getText().toString());

      try {
         startActivity(Intent.createChooser(email, "Bir E-posta programý seçiniz.."));
      } catch (android.content.ActivityNotFoundException ex) {
         Toast.makeText(Mail.this, "E-posta programý yüklü deðil.",
        		 Toast.LENGTH_LONG).show();
         Uri link = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.gm");
         Intent tara = new Intent(Intent.ACTION_DEFAULT, link);
         startActivity(tara);
      }
   }}