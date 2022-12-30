package com.example.ktebi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ktebi.databinding.ActivityMainBinding;
import com.example.ktebi.ui.Adapters.MainAdapter;
import com.example.ktebi.ui.DBHelpers;
import com.example.ktebi.ui.Models.MainModel;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    TextView edid,edBookname,edBookDescription,edBookRating;
    ImageView Iv;
    DBHelpers DB;

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<MainModel>list=new ArrayList<>();
        list.add(new MainModel("1",R.drawable.fantastic_books,"Lost BOY","There is one version of my story that everyone knows. And then there is the truth. Once I loved a boy called Peter Pan. Peter brought me to his island because there were no rules and no grownups to make us mind.Peter will say I'm a villain, that I wronged him, that I never was his friend. Peter Lies.","2/5"));
        list.add(new MainModel("2",R.drawable.violeta,"Violeta ","This epic story of a woman who perseveres two pandemics, war, the Great Depression and the battle for equal rights is not only a passionate love story but a testament to the strength of the human spirit.","4.5/5"));
        list.add(new MainModel("3",R.drawable.emma_janeaustin," Emma","Emma is spoiled, headstrong, and self-satisfied; she greatly overestimates her own matchmaking abilities; she is blind to the dangers of meddling in other people's lives; and her imagination and perceptions often lead her astray.","4/5"));
        list.add(new MainModel("4",R.drawable.when_we_were_birds," When We Were Birds","this mystical love story follows Darwin, a rastafarian man who becomes a gravedigger to support himself and gets mixed up in some nefarious dealings, and Yejide, a woman with a power that's both a blessing and a curse.","4/5"));
        list.add(new MainModel("5",R.drawable.the_headmistress_of_rosemere," The Headmistress of Rosemere","Patience Creighton will finally find the peace she lost years ago--if she can open her heart and forgive the man who loves her.","4/5"));
        list.add(new MainModel("6",R.drawable.the_bird_and_the_sword,"The Bird and the Sword","The day my mother left me, she told me to swallow my words, to push them down deep, and I haven’t spoken a word since. I’m no longer just a prisoner to my mother’s curse but I’m still invisible to those around me.","4/5"));

        list.add(new MainModel("7",R.drawable.the_heiress_of_winterwood,"The Heiress of Winterwood","Amelia Barrett, heiress to an ancestral estate nestled in the English moors, defies family expectations and promises to raise her dying friend’s infant baby. She'll risk everything to keep her word—even to the point of proposing to the child’s father, Graham, a sea captain she’s never met.","4/5"));
        list.add(new MainModel("8",R.drawable.the_proposal,"The Proposal","Freelance writer Nik's boyfriend proposes at a Dodger's game, and the dude can't even spell her name right. She says no (obviously), and the video goes viral. ","2/5"));
        list.add(new MainModel("9",R.drawable.pride_and_prejudice,"Pride & Prejudice","Pride and Prejudice follows the turbulent relationship between Elizabeth Bennet, the daughter of a country gentleman, and Fitzwilliam Darcy, a rich aristocratic landowner. They must overcome the titular sins of pride and prejudice in order to fall in love and marry.","4.5/5"));

        list.add(new MainModel("10",R.drawable.from_blood_and_ash,"  From Blood and Ash "," Poppy’s life has never been her own. As the Maiden, the future of the kingdom rests on her shoulders, and she is to remain untouched, in solitary, until the day of her Ascension.","4/5"));
        list.add(new MainModel("11",R.drawable.a_lady_at_willowgrove_hall," A Lady at Willowgrove Hall","Her secret cloaks her in isolation. His secret traps him in a life that is not his own. They will have to learn to trust one another in order to find freedom in this Regency romance.","4/5"));
        list.add(new MainModel("12",R.drawable.eleanor_and_park,"Eleanor & Park ","They say you never forget your first love. Test that theory by taking a trip down memory lane with Eleanor and Park, two lovestruck misfit teens in 1986. They're smart enough to know young love never lasts, but brave enough to try.","4/5"));
        list.add(new MainModel("13",R.drawable.beneath_his_silence,"Beneath His Silence "," Second daughter of a baron—and a little on the mischievous side—Ella Pemberton is no governess. But the pretense is a necessity if she ever wishes to get inside of Wyckhorn Manor and attain the truth. Exposing the man who killed her sister is all that matters.","4/5"));
        list.add(new MainModel("14",R.drawable.the_revelation_of_light_and_dark,"The Revelation of Light and Dark ","From a young age, she always knew she was different. Hallucinations and visions plagued her young mind but were then locked away until she learned her whole existence has been a lie.","4/5"));
        list.add(new MainModel("15",R.drawable.i_kissed_shara_wheeler,"I Kissed Shara Wheeler","Chloe Green has spent her whole tenure at Willowgrove Christian Academy competing for valedictorian with the principal’s perfect daughter, Shara Wheeler. But when Shara kisses Chloe and then disappears on prom night, she leaves only a string of cryptic clues.","4/5"));

        MainAdapter adapter=new MainAdapter(list,this);
        binding.recycerview.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.recycerview.setLayoutManager(layoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.books:
                startActivity(new Intent(DisplayActivity.this,updateActivity.class));
                break;
            case R.id.work:
                startActivity(new Intent(DisplayActivity.this,workActivity.class));



        }
        return super.onOptionsItemSelected(item);
    }
}

/*edid=findViewById(R.id.BookId);
        edBookname=findViewById(R.id.BookName);
        edBookDescription=findViewById(R.id.BookDescription);
        edBookRating=findViewById(R.id.BookRating);
        Iv=findViewById(R.id.imageview);
        DB = new DBHelpers(this);


        Iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=edid.toString();
                String Bookname=edBookname.toString();
                String BookDescription=edBookDescription.toString();
                String BookRating=edBookRating.toString();
                boolean insertBooks=DB.insertBooks(id,Bookname,BookDescription,BookRating);
                if (insertBooks==true){
                    Toast.makeText(getApplicationContext(), " added successfully", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(), " no no", Toast.LENGTH_SHORT).show();

                }
            }
        });*/