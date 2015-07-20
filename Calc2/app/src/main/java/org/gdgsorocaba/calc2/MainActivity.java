package org.gdgsorocaba.calc2;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Double dValor1;
    private Double dValor2;
    private Context context;
    private TextView txtResultado;

    public void loadData() {
        EditText edtValor1 = (EditText) findViewById(R.id.edtValor1);
        EditText edtValor2 = (EditText) findViewById(R.id.edtValor2);

        try {
            context = getApplicationContext();

            txtResultado = (TextView) findViewById(R.id.txtResultado);

            if (edtValor1.getText().length() == 0)
                dValor1 = 0.0;
            else
                dValor1 = Double.parseDouble(edtValor1.getText().toString());

            if (edtValor2.getText().length() == 0)
                dValor2 = 0.0;
            else
                dValor2 = Double.parseDouble(edtValor2.getText().toString());
        } catch (Exception ex) {
            Toast toast = Toast.makeText(context, "Falha ao carregar dados. (" + ex.getMessage() + ")", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void doNotification(String sTextNotify) {
        try {
            // Based on Template
            NewMessageNotification.notify(context, "Resultado: " + sTextNotify, 1);

            // Build itself
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.gdg_logo_white)
                            .setContentTitle("Resultado")
                            .setContentText(sTextNotify);
            int mNotificationId = 1;
            NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            mNotifyMgr.notify(mNotificationId, mBuilder.build());

            Toast toast = Toast.makeText(context, sTextNotify, Toast.LENGTH_SHORT);
            toast.show();
        } catch (Exception ex) {
            Toast toast = Toast.makeText(context, getString(R.string.fail_showing_notification) + "(" + ex.getMessage() + ")", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * Executa soma
     *
     * @param view Operations
     */
    public void doAddition(View view) {
        try {
            loadData();
            String sResultado = String.valueOf(dValor1 + dValor2);
            txtResultado.setText(sResultado);
            doNotification(sResultado);
        } catch (Exception ex) {
            Toast toast = Toast.makeText(context, getString(R.string.fail_executing_addition) + "(" + ex.getMessage() + ")", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * Executa Subtracao
     *
     * @param view Operations
     */
    public void doSubtraction(View view) {
        try {
            loadData();
            String sResultado = String.valueOf(dValor1 - dValor2);
            txtResultado.setText(sResultado);
        } catch (Exception ex) {
            Toast toast = Toast.makeText(context, getString(R.string.fail_executing_subtraction) + "(" + ex.getMessage() + ")", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * Exec Division
     *
     * @param view Operations
     */
    public void doDivision(View view) {
        try {
            loadData();
            String sResultado;

            if (dValor2 != 0)
                sResultado = String.valueOf(dValor1 / dValor2);
            else
                sResultado = "#DIV/0!";

            txtResultado.setText(sResultado);
        } catch (Exception ex) {
            Toast toast = Toast.makeText(context, getString(R.string.fail_executing_division) + "(" + ex.getMessage() + ")", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * Exec Multiplication
     *
     * @param view Operations
     */
    public void doMultiplication(View view) {
        try {
            loadData();
            String sResultado = String.valueOf(dValor1 * dValor2);
            txtResultado.setText(sResultado);
        } catch (Exception ex) {
            Toast toast = Toast.makeText(context, getString(R.string.fail_executing_multiplication) + "(" + ex.getMessage() + ")", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
