package com.sonukgupta72.pictionarygame

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.pictionary_fragment.*
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide


class PictionaryFragment : Fragment() {

    companion object {
        fun newInstance() = PictionaryFragment()
    }

    private lateinit var viewModel: PictionaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pictionary_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PictionaryViewModel::class.java)

        viewModel.getNextQuestion()

        viewModel.getImageData().observe(this, Observer<ImageModel> { this.setData(it) })
        viewModel.getGameOver().observe(this, Observer<Int> { this.gameOver(it) })
        viewModel.getCountDown().observe(this, Observer<String> { this.countDown(it) })
        viewModel.getDeficultyLevel().observe(this, Observer<Int> { this.setDifficultyLevel(it) })

        btn_submit.setOnClickListener(View.OnClickListener {
            viewModel.submitAnswer(et_answer.text.toString())
        })
    }

    private fun setDifficultyLevel(it: Int?) {
        if (it != null && it > 0) {
            tv_round.text = "" + it + "/5"
        }
    }

    private fun countDown(it: String?) {
        if (!TextUtils.isEmpty(it)) {
            tv_counter.text = it
        }
    }

    private fun gameOver(it: Int?) {
        if (it != null && it >= 0) {
            Toast.makeText(activity, "Your Score: " + it, Toast.LENGTH_LONG).show()
            activity?.finish()
        }
    }

    private fun setData(imageModel: ImageModel) {
        Glide.with(this).load(imageModel.imageUrl).into(iv_img_animal)
        et_answer.setText(imageModel.answer)
        log("answer " + imageModel.answer)
        log("difficultyLevelML " + imageModel.difficulty)
    }


    private fun log(message: String) {
        Log.d("Log", message);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
