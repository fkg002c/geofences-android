package com.fkg002c.geofences.ui.geozones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fkg002c.geofences.databinding.FragmentGeozonesBinding

class GeozonesFragment : Fragment() {

    private var _binding: FragmentGeozonesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val geozonesViewModel =
            ViewModelProvider(this).get(GeozonesViewModel::class.java)

        _binding = FragmentGeozonesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGeozones
        geozonesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}