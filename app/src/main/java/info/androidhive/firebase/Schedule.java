package info.androidhive.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Schedule extends AppCompatActivity {

    String birthday = "";
    String rDate = "";
    private TextView eventTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);

        final Calendar c = Calendar.getInstance();
        int year = c.get(c.YEAR);
        final int month = c.get(c.MONTH) + 1;
        int dayOfMonth = c.get(c.DAY_OF_MONTH);

        //Get the widgets reference from XML layout
        final TextView tv = (TextView) findViewById(R.id.tv);
        final Button dateButton = (Button) findViewById(R.id.dateButton);
        final DatePicker dp = (DatePicker) findViewById(R.id.dp);
        eventTitle = (TextView) findViewById(R.id.eventTitle);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        rDate = df.format(c.getTime());
        //Display the DatePicker initial date
        tv.setText("Initial Date [mm/dd/yyyy]:\n" + month + "/" + dayOfMonth + "/" + year);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the DatePicker Selected Date
                tv.setText("Selected Date of Birth: [mm/dd/yyyy]\n");
                tv.setText(tv.getText() + "" + (dp.getMonth() + 1) + "/" + dp.getDayOfMonth() + "/" + dp.getYear());
                birthday = dp.getYear() + "-" + (dp.getMonth() + 1) + "-" + dp.getDayOfMonth();
                dp.updateDate(c.get(c.YEAR) + 1, c.get(c.MONTH) + 2, c.get(c.DAY_OF_MONTH) + 10);
            }
        });




    }


}


