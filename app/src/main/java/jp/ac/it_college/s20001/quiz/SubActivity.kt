package jp.ac.it_college.s20001.quiz

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import jp.ac.it_college.s20001.quiz.databinding.ActivitySubBinding
import com.opencsv.CSVIterator
import com.opencsv.CSVReader
import com.opencsv.bean.CsvToBeanBuilder
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.time.TimeSource.Monotonic.toString


class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding

    // 問題
    private var a: Int = 1
    // 正解
    private var y: Int = 0
    // 不正解
    private var n: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resultButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }

        binding.timerText.text = "11"

        val quizList: MutableList<Array<String>> = mutableListOf()
        val fileReader = BufferedReader(InputStreamReader(assets.open("s20001.csv")))
        val csvIter = CSVIterator(CSVReader(fileReader))
        for(row in csvIter){
            if(row == null) break

            row.toString().split(",").toTypedArray()
            quizList.add(row)
        }

        val quiz: TextView = binding.Quiz
        val a1: Button = binding.A1
        val a2: Button = binding.A2
        val a3: Button = binding.A3
        val a4: Button = binding.A4
        var yes: TextView = binding.Yes
        var no: TextView = binding.No

        val list: List<Int> = listOf(2, 3, 4, 5)
        val num: List<Int> = list.shuffled()
        val ans = quizList[a][2]
        binding.Quiz.text = quizList[a][0]
        binding.A1.text = quizList[a][num[2]]
        binding.A2.text = quizList[a][num[3]]
        binding.A3.text = quizList[a][num[4]]
        binding.A4.text = quizList[a][num[5]]


        a1.setOnClickListener {
            if(a1.text == ans) {
                y += 1
                a += 1
                yes.text = "正解です！"
                quiz.text = quizList[a][0]
                a1.text = quizList[a][2]
                a2.text = quizList[a][3]
                a3.text = quizList[a][4]
                a4.text = quizList[a][5]
            } else {
                a += 1
                n += 1
                no.text = "不正解です！"
                quiz.text = quizList[a][0]
                a1.text = quizList[a][2]
                a2.text = quizList[a][3]
                a3.text = quizList[a][4]
                a4.text = quizList[a][5]
            }
        }

        a2.setOnClickListener {
            if(a2.text == ans) {
                a += 1
                y += 1
                yes.text = "正解です！"
                quiz.text = quizList[a][0]
                a1.text = quizList[a][2]
                a2.text = quizList[a][3]
                a3.text = quizList[a][4]
                a4.text = quizList[a][5]
            } else {
                a += 1
                n += 1
                no.text = "不正解です！"
                quiz.text = quizList[a][0]
                a1.text = quizList[a][2]
                a2.text = quizList[a][3]
                a3.text = quizList[a][4]
                a4.text = quizList[a][5]
            }
        }

        a3.setOnClickListener {
            if(a3.text == ans) {
                a += 1
                y += 1
                yes.text = "正解です！"
                quiz.text = quizList[a][0]
                a1.text = quizList[a][2]
                a2.text = quizList[a][3]
                a3.text = quizList[a][4]
                a4.text = quizList[a][5]
            } else {
                a += 1
                n += 1
                no.text = "不正解です！"
                quiz.text = quizList[a][0]
                a1.text = quizList[a][2]
                a2.text = quizList[a][3]
                a3.text = quizList[a][4]
                a4.text = quizList[a][5]
            }
        }

        a4.setOnClickListener {
            if(a4.text == ans) {
                a += 1
                y += 1
                yes.text = "正解です！"
                quiz.text = quizList[a][0]
                a1.text = quizList[a][2]
                a2.text = quizList[a][3]
                a3.text = quizList[a][4]
                a4.text = quizList[a][5]
            } else {
                a += 1
                n += 1
                no.text = "不正解です！"
                quiz.text = quizList[a][0]
                a1.text = quizList[a][2]
                a2.text = quizList[a][3]
                a3.text = quizList[a][4]
                a4.text = quizList[a][5]
            }
        }

        val timer = object : CountDownTimer(11 * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val second = millisUntilFinished / 1000L
                binding.timerText.text = "%1d".format(second)
            }

            override fun onFinish() {
                binding.timerText.text = "0"
                if (binding.timerText.text == "0") {
                    a += 1
                    n += 1
                    quiz.text = quizList[a][0]
                    a1.text = quizList[a][2]
                    a2.text = quizList[a][3]
                    a3.text = quizList[a][4]
                    a4.text = quizList[a][5]
                } else {
                    ;
                }

            }
        }

        timer.start()
    }
}