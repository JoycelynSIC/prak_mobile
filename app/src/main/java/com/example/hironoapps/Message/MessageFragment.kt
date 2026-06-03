package com.example.hironoapps.Message

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.hironoapps.Message.tutorial.TutorialMessageActivity
import com.example.hironoapps.R
import com.example.hironoapps.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://i.pravatar.cc/150?u=alya"),
        MessageModel("Budi", "Sudah makan?", "https://i.pravatar.cc/150?u=budi"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://i.pravatar.cc/150?u=citra"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://i.pravatar.cc/150?u=dika"),
        MessageModel("Eka", "Nice job kemarin!", "https://i.pravatar.cc/150?u=eka"),
        MessageModel("Fajar", "Lagi ngapain?", "https://i.pravatar.cc/150?u=fajar"),
        MessageModel("Gita", "Boleh minta tolong?", "https://i.pravatar.cc/150?u=gita"),
        MessageModel("Hana", "Lihat email ya", "https://i.pravatar.cc/150?u=hana"),
        MessageModel("Irfan", "Oke noted", "https://i.pravatar.cc/150?u=irfan"),
        MessageModel("Joko", "Sampai jumpa besok", "https://i.pravatar.cc/150?u=joko")
    )
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!
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
        setHasOptionsMenu(true)

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}