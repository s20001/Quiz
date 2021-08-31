package jp.ac.it_college.s20001.quiz

import android.icu.lang.UCharacter.toString
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import jp.ac.it_college.s20001.quiz.databinding.ActivitySubBinding
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.opencsv.CSVIterator
import com.opencsv.CSVReader
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringReader
import java.lang.Integer.toString
import kotlin.collections.ArrayList

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quizList: MutableList<Array<String>> = mutableListOf()
        val fileReader = BufferedReader(InputStreamReader(assets.open("s20001.csv")))
        val csvIter = CSVIterator(CSVReader(fileReader))
        for(row in csvIter){
            if(row == null) break


        }

    }
}