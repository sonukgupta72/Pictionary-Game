package com.sonukgupta72.pictionarygame

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import java.io.StringReader
import kotlin.random.Random

class PictionaryViewModel : ViewModel() {

    private val jsonString: String = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/australian-cattle-dog.jpg\",\n" +
            "    \"difficulty\": 1,\n" +
            "    \"answer\": \"DOG\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 2,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/Tortoise-shell-cat.jpg\",\n" +
            "    \"difficulty\": 1,\n" +
            "    \"answer\": \"CAT\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 3,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/horse.jpg\",\n" +
            "    \"difficulty\": 1,\n" +
            "    \"answer\": \"HORSE\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 4,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/poltava-chicken.jpg\",\n" +
            "    \"difficulty\": 1,\n" +
            "    \"answer\": \"HEN\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 5,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/largemouth-bass.jpg\",\n" +
            "    \"difficulty\": 1,\n" +
            "    \"answer\": \"FISH\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 6,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/eurasian-brown-bear.jpg\",\n" +
            "    \"difficulty\": 2,\n" +
            "    \"answer\": \"BEAR\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 7,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/bluebird-of-happiness.jpg\",\n" +
            "    \"difficulty\": 2,\n" +
            "    \"answer\": \"BIRD\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 8,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/hammerhead-shark.jpg\",\n" +
            "    \"difficulty\": 2,\n" +
            "    \"answer\": \"SHARK\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 9,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/mad-purple-snake.jpg\",\n" +
            "    \"difficulty\": 2,\n" +
            "    \"answer\": \"SNAKE\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 10,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/pig.jpg\",\n" +
            "    \"difficulty\": 2,\n" +
            "    \"answer\": \"PIG\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 11,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/male-lion.jpg\",\n" +
            "    \"difficulty\": 3,\n" +
            "    \"answer\": \"LION\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 12,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/wild-turkey.jpg\",\n" +
            "    \"difficulty\": 3,\n" +
            "    \"answer\": \"TURKEY\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 13,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/gray-wolf.jpg\",\n" +
            "    \"difficulty\": 3,\n" +
            "    \"answer\": \"WOLF\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 14,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/zebra-spider.jpg\",\n" +
            "    \"difficulty\": 3,\n" +
            "    \"answer\": \"SPIDER\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 15,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/rabbit.jpg\",\n" +
            "    \"difficulty\": 3,\n" +
            "    \"answer\": \"RABBIT\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 16,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/male-mandarin-duck.jpg\",\n" +
            "    \"difficulty\": 4,\n" +
            "    \"answer\": \"DUCK\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 17,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/red-deer-stag.jpg\",\n" +
            "    \"difficulty\": 4,\n" +
            "    \"answer\": \"DEER\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 18,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/cow-and-calf.jpg\",\n" +
            "    \"difficulty\": 4,\n" +
            "    \"answer\": \"COW\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 19,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/wolfs-mona-monkey.jpg\",\n" +
            "    \"difficulty\": 4,\n" +
            "    \"answer\": \"MONKEY\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 20,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/european-lobster.jpg\",\n" +
            "    \"difficulty\": 4,\n" +
            "    \"answer\": \"LOBSTER\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 21,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/ape.jpg\",\n" +
            "    \"difficulty\": 5,\n" +
            "    \"answer\": \"APE\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 22,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/shetland-pony.jpg\",\n" +
            "    \"difficulty\": 5,\n" +
            "    \"answer\": \"PONY\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 23,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/bald-eagle.jpg\",\n" +
            "    \"difficulty\": 5,\n" +
            "    \"answer\": \"EAGLE\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 24,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/spinner-dolphin-pod.jpg\",\n" +
            "    \"difficulty\": 5,\n" +
            "    \"answer\": \"DOLPHIN\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 25,\n" +
            "    \"imageUrl\": \"https://acdn.list25.com/wp-content/uploads/2015/03/american-bison.jpg\",\n" +
            "    \"difficulty\": 5,\n" +
            "    \"answer\": \"BISON\"\n" +
            "  }\n" +
            "]"

    var stringReader: StringReader = StringReader(jsonString)
    val gsonBuilder = GsonBuilder().serializeNulls()
    val gson = gsonBuilder.create()
    val gameList: List<ImageModel> = gson.fromJson(stringReader, Array<ImageModel>::class.java).toList()


    var difficultyLevel: Int = 3
    var counter: Int = 0
    var time: Int = 30
    lateinit var imageModel: ImageModel
    private var score: Int = 0

    private val imgData: MutableLiveData<ImageModel> = MutableLiveData()
    private val gameOver: MutableLiveData<Int> = MutableLiveData()
    private val countDown: MutableLiveData<String> = MutableLiveData()
    private val difficultyLevelML: MutableLiveData<Int> = MutableLiveData()


    val start = object : CountDownTimer(10 * 1000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            time = (millisUntilFinished / 1000).toInt()
            countDown.value = ("0:" + checkDigit(millisUntilFinished / 1000))
        }

        override fun onFinish() {
            if (time == 0) {
                submitAnswer("")
            }
        }
    }

    fun getNextQuestion() {
        if (difficultyLevel <= 1 || counter >= 5) {
            gameOver.value = score
        }else {
            imageModel = gameList.get((difficultyLevel - 1) * 5 + Random.nextInt(0, 4))
            imgData.value = imageModel
            difficultyLevelML.value = difficultyLevel
            startTimer()
        }
    }

    fun submitAnswer(answer: String) {
        time = 30
        if (imageModel.answer.equals(answer)) {
            score++;
            if (difficultyLevel < 5) {
                difficultyLevel++
            }
        } else {
            difficultyLevel--
        }

        finishTimer()
        counter++
        getNextQuestion()
    }

    fun getImageData(): LiveData<ImageModel> {
        return imgData
    }

    fun getGameOver(): LiveData<Int> {
        return gameOver
    }

    fun getCountDown(): LiveData<String> {
        return countDown
    }

    fun getDeficultyLevel(): LiveData<Int> {
        return difficultyLevelML
    }

    private fun startTimer() {
        start.start()
    }

    private fun finishTimer() {
        start.cancel()
        start.onFinish()
    }

    private fun checkDigit(number: Long): String {
        return if (number <= 9) "0$number" else number.toString()
    }
}
