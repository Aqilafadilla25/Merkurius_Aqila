package com.example.merkurius_aqila.Message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.merkurius_aqila.R
import com.example.merkurius_aqila.databinding.FragmentHomeBinding
import com.example.merkurius_aqila.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!
    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://i.pravatar.cc/150?img=1","20"),
        MessageModel("Budi", "Sudah makan?", "https://i.pravatar.cc/150?img=2","20"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://i.pravatar.cc/150?img=3","25"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://i.pravatar.cc/150?img=4","12"),
        MessageModel("Eka", "Nice job kemarin!", "https://i.pravatar.cc/150?img=5","30"),
        MessageModel("Fajar", "Lagi ngapain?", "https://i.pravatar.cc/150?img=6","25"),
        MessageModel("Gita", "Boleh minta tolong?", "https://i.pravatar.cc/150?img=7","19"),
        MessageModel("Hana", "Lihat email ya", "https://i.pravatar.cc/150?img=8","30"),
        MessageModel("Irfan", "Oke noted", "https://i.pravatar.cc/150?img=9","15"),
        MessageModel("Joko", "Sampai jumpa besok", "https://i.pravatar.cc/150?img=10","18")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }
}