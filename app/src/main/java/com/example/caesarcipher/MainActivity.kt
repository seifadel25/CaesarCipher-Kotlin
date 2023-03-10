package com.example.caesarcipher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caesarcipher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEncrypt.setOnClickListener {
            val inputText = binding.etInput.text.toString()
            val key = binding.etKey.text.toString().toInt()
            val encryptedText = encrypt(inputText, key)
            binding.tvOutput.text = encryptedText
        }

        binding.btnDecrypt.setOnClickListener {
            val inputText = binding.etInput.text.toString()
            val key = binding.etKey.text.toString().toInt()
            val decryptedText = decrypt(inputText, key)
            binding.tvOutput.text = decryptedText
        }
    }

    private fun encrypt(text: String, key: Int): String {
        var result = ""
        for (i in 0 until text.length) {
            val c = text[i]
            result += if (c.isUpperCase()) {
                ((c.toInt() + key - 65) % 26 + 65).toChar()
            } else {
                ((c.toInt() + key - 97) % 26 + 97).toChar()
            }
        }
        return result
    }

    private fun decrypt(text: String, key: Int): String {
        var result = ""
        for (i in 0 until text.length) {
            val c = text[i]
            result += if (c.isUpperCase()) {
                ((c.toInt() - key - 65 + 26) % 26 + 65).toChar()
            } else {
                ((c.toInt() - key - 97 + 26) % 26 + 97).toChar()
            }
        }
        return result
    }
}
