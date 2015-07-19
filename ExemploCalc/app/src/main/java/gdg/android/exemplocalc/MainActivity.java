package gdg.android.exemplocalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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


    //Função Click Sona

    public void funcSoma(View v){
        //Carregando os componentes que estao na tela e armazenando em variaveis
        EditText num1 = (EditText)findViewById(R.id.valor);
        EditText num2 = (EditText)findViewById(R.id.valor2);
        TextView resultado = (TextView)findViewById(R.id.textView);

        //aatribuindo a variaveis o valor convertido dos campos de texto na tela
       double valor1 = Double.parseDouble(num1.getText().toString());
       double valor2 = Double.parseDouble(num2.getText().toString());
       //devolvendo para tela o valor da soma(nesse caso)
       String result = String.valueOf(valor1 + valor2);
       resultado.setText(result);
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
}
