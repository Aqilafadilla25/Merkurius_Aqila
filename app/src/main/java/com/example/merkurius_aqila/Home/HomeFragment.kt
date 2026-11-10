package com.example.merkurius_aqila.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.merkurius_aqila.Home.pertemuan_10.TenthActivity
import com.example.merkurius_aqila.Home.pertemuan_4.FourthActivity
import com.example.merkurius_aqila.Home.pertemuan_5.FifthActivity
import com.example.merkurius_aqila.Home.pertemuan_6.SixthActivity
import com.example.merkurius_aqila.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnToFourth.setOnClickListener{
            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 19)


            startActivity(intent)
            requireActivity().finish()
        }
        binding.btnToFifth.setOnClickListener{
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToSixth.setOnClickListener{
            val intent = Intent(requireContext(), SixthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToTenth.setOnClickListener{
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToElevent.setOnClickListener{
            val intent = Intent(requireContext(), EleventActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    // clear SP
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()
                    requireActivity().finish()
                }

                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Tidak!")
                }
                .show()
        }
    }
}
