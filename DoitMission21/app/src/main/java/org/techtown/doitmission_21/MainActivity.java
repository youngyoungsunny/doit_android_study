package org.techtown.doitmission_21;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.techtown.doitmission_22.R;


    public class MainActivity extends AppCompatActivity {
        EditText editName;
        EditText editWriter;
        EditText editContent;
        TextView textView;
        SQLiteDatabase database;

        String tableName = "bookrecords";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            editName = findViewById(R.id.editName);
            editWriter = findViewById(R.id.editContent);
            editContent = findViewById(R.id.editContent);
            //textView = findViewById(R.id);

            createDatabase("library.db");
            createTable(tableName);

            Button button = findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    insertRecode(editName.getText().toString(), editWriter.getText().toString(),
                            editContent.getText().toString());

                    Toast.makeText(MainActivity.this, "데이터베이스에 추가", Toast.LENGTH_LONG).show();
                }
            });
        }

        private void createDatabase(String databaseName) {
            println("createDatabase 호출");
            database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);

            println("데이터베이스 생성함 : "+databaseName);
        }

        private void createTable(String table) {
            println("createTable 호출");
            if (database == null) {
                println("데이터베이스를 먼저 생성하세요.");
                return;
            }

            database.execSQL("create table if not exists " + table + "("
                    + " _id integer PRIMARY KEY autoincrement, "
                    + " name text, "
                    + " writer text, "
                    + " content text)");
            println("테이블 생성함 : " + table);
        }

        private void insertRecode(String name1, String writer1, String content1) {
            println("insertRecord 호출");

            if(database == null) {
                println("데이터베이스를 먼저 생성하세요");
                return;
            }
            if(tableName == null) {
                println("테이블 먼저 생성하세요");
                return;
            }

            database.execSQL("insert into " + tableName
                    + "(name, writer, content) "
                    + " values "
                    + "('" +name1+ "','" + writer1 + "','" + content1 + "')");

            println("레코드 추가함");
            Toast.makeText(getApplicationContext(),"데이터베이스에 추가함 최종!!",Toast.LENGTH_LONG).show();

            editName.setText("");
            editWriter.setText("");
            editContent.setText("");
        }

        public void println(String data) {
            textView.append(data + "\n");
        }

    }